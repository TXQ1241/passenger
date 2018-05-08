package org.passenger.dao;

import java.util.List;
import org.passenger.pojo.Orders;
import org.passenger.vo.OrderVo;
import org.springframework.stereotype.Repository;

@Repository("orderMapper")
public interface OrdersMapper {
	
	List<Orders> getOrderList(OrderVo orderVo);
	int getOrderCount(OrderVo orderVo);
    int insert(Orders order);
    int update(Orders order);
	Orders getOrdersById(String id);
}