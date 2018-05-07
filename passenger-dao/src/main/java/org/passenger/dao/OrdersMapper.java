package org.passenger.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.passenger.pojo.Orders;
import org.passenger.vo.OrderVo;
import org.springframework.stereotype.Repository;

@Repository("orderMapper")
public interface OrdersMapper {
	
	List<Orders> getOrdersList(OrderVo orderVo);
	int getOrderCount(OrderVo orderVo);
    int insert(Orders order);
    int update(Orders order);
}