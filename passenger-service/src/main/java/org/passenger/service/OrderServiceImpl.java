package org.passenger.service;

import org.passenger.pojo.Orders;
import org.passenger.vo.OrderVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {

    public List<Orders> getOrders(OrderVo orderVo) {
        return null;
    }

    public Integer getOrderCount(OrderVo orderVo) {
        return null;
    }
}
