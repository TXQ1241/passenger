package org.passenger.service;

import org.passenger.dao.OrdersMapper;
import org.passenger.pojo.Orders;
import org.passenger.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    @Qualifier("orderMapper")
    OrdersMapper orderMapper;

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
}
