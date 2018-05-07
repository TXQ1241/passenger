package org.passenger.service;

import java.util.ArrayList;
import java.util.List;

import org.passenger.dao.OrdersMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.pojo.Orders;
import org.passenger.pojo.Ticket;
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
    
    public List<Orders> getOrders(OrderVo orderVo) {
        return orderMapper.getOrdersList(orderVo);
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
					vo.setTicketNum(ticket.getNumber());
				}
				
				voList.add(vo);
			}
		}
		return voList;
	}
}
