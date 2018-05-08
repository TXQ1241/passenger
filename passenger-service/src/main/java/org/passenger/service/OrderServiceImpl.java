package org.passenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.passenger.common.Constants;
import org.passenger.dao.OrdersMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.pojo.Orders;
import org.passenger.pojo.Route;
import org.passenger.pojo.Ticket;
import org.passenger.pojo.User;
import org.passenger.utils.StringUtils;
import org.passenger.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    @Qualifier("orderMapper")
    OrdersMapper orderMapper;
    
    @Autowired
    @Qualifier("carTripService")
    ICarTripService carTripService;
    
    @Autowired
    @Qualifier("ticketService")
    ITicketService ticketService;
    
    @Autowired
    @Qualifier("routeService")
    IRouteService routeService;
    
    @Autowired
    @Qualifier("userService")
    IUserService userService;
    
    public List<Orders> getOrders(OrderVo orderVo) {
        return orderMapper.getOrderList(orderVo);
    }

    public Integer getOrderCount(OrderVo orderVo) {
        return orderMapper.getOrderCount(orderVo);
    }

    public void save(Orders orders) {
        orderMapper.insert(orders);
    }

    public void update(Orders orders) {
        orderMapper.update(orders);
    }

	public List<OrderVo> getOrderVos(OrderVo orderVo) {
		List<OrderVo> voList = new ArrayList<OrderVo>();
		List<Orders> ordersList = this.getOrders(orderVo);
		if(ordersList != null && ordersList.size() > 0) {
			for (Orders order:ordersList) {
				OrderVo vo = new OrderVo(order);
				if(StringUtils.isNotBlank(order.getCarTripId())) {
					CarTrip carTrip = carTripService.getCarTripById(order.getCarTripId());
					vo.setCarTripCode(carTrip.getCode());
				}
				if(StringUtils.isNotBlank(order.getTicketId())) {
					Ticket ticket = ticketService.getTicketById(order.getTicketId());
					if(ticket != null) {
						vo.setTicketDate(ticket.getTicketDate());
					}
				}
				if(StringUtils.isNotBlank(order.getRouteId())) {

					Route route = routeService.getRouteById(order.getRouteId());
					if(route != null) {
						vo.setRouteId(route.getId());
						vo.setStartTime(route.getStartTime());
						vo.setArriveTime(route.getArriveTime());
						vo.setPrice(route.getPrice());
					}
				}
				
				voList.add(vo);
			}
		}
		return voList;
	}

	public void saveOrders(HttpServletRequest request, Orders orders) {
		
		User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER);
		if(user != null) {
			orders.setUserId(user.getId());
		}
		
		if(StringUtils.isNotBlank(orders.getTicketId())) {
			Ticket ticket = ticketService.getTicketById(orders.getTicketId());
			int ticketNum = ticket.getNumber();
			ticket.setNumber(--ticketNum);
			ticketService.update(ticket);
		}
		
		if(StringUtils.isNotBlank(orders.getId())) {
			//改签的处理
			Orders ordersInfo = this.getOrdersById(orders.getId());
			if(ordersInfo != null) {
				if(StringUtils.isNotBlank(ordersInfo.getTicketId())) {
					Ticket ticketInfo =  ticketService.getTicketById(ordersInfo.getTicketId());
					int ticketNumInfo = ticketInfo.getNumber();
					ticketInfo.setNumber(++ticketNumInfo);
					ticketService.update(ticketInfo);
				}
			}
			
		} else {
			double balance = getDouble(user.getUserBalance());
			if(StringUtils.isNotBlank(orders.getRouteId())) {
				Route route = routeService.getRouteById(orders.getRouteId());
				if(route != null) {
					balance = balance - getDouble(route.getPrice());
				}
			}
			user.setUserBalance(balance);
			userService.update(user);
			orders.setId(StringUtils.getUUID());
			orders.setCreateTime(new Date());
			this.save(orders);
		}
	}

	public Orders getOrdersById(String id) {
		return orderMapper.getOrdersById(id);
	}
	
	private double getDouble(Double num) {
		if(num == null) {
			num = 0d;
		}
		return num;
	}
}
