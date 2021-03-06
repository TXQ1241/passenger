package org.passenger.service;

import org.passenger.pojo.Orders;
import org.passenger.vo.OrderVo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 订单管理接口
 * @author Administrator
 *
 */
public interface IOrderService {
    /**
     * 获取订单信息
     * @param orderVo
     * @return
     */
    List<Orders> getOrders(OrderVo orderVo);

    /**
     * 获取订单记录数
     * @param orderVo
     * @return
     */
    Integer getOrderCount(OrderVo orderVo);

    void save(Orders orders);

    void update(Orders orders);
    
    /**
     * 获取订单封装信息
     * @param orderVo
     * @return
     */
	List<OrderVo> getOrderVos(OrderVo orderVo);

	void saveOrders(HttpServletRequest request, Orders orders);
	
	Orders getOrdersById(String id);
}
