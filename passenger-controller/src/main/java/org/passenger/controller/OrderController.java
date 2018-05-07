package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.Orders;
import org.passenger.pojo.User;
import org.passenger.service.IOrderService;
import org.passenger.vo.DataVo;
import org.passenger.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	IOrderService orderService;

	@RequestMapping("getOrderList")
	@ResponseBody
	public DataVo getOrderList(HttpServletRequest request, OrderVo orderVo) {
		User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER);

		if(user != null) {
			orderVo.setUserId(user.getId());
		}

		DataVo dataVo = new DataVo();
		Integer pageNum = orderVo.getPageNum();
		//设置查询开始的条数(就是从哪条开始查询)
		if(pageNum != null) {
			orderVo.setPageNum((pageNum-1)*orderVo.getPageSize());
		}
		try {
			List<Orders> orderList = orderService.getOrders(orderVo);
			dataVo.setDatalist(orderList);
			dataVo.setCode(Constants.DataCode.SUCCESS);
			dataVo.setMsg("数据获取成功");
			if (orderList != null) {
				dataVo.setCount(orderService.getOrderCount(orderVo));
			} else {
				dataVo.setCount(Constants.ZERO_NUM);
			}
		} catch (Exception e) {
			dataVo.setCode(Constants.DataCode.FAIL);
			dataVo.setMsg("数据获取失败");
			e.printStackTrace();
		}
		return dataVo;
	}

	@RequestMapping("save")
	@ResponseBody
	public Map<String, String> saveOrder(Orders orders) {
		Map<String, String> msgMap = new HashMap<String, String>();
		try {
			orderService.save(orders);
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除订单信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除订单信息失败");
		}
		return msgMap;
	}

	/**
	 * 改签订单信息
	 * @param order
	 * @return
	 */
	@RequestMapping("change")
	@ResponseBody
	public Map<String, String> changeOrder(Orders order) {
		Map<String, String> msgMap = new HashMap<String, String>();
		try {

			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"改签成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"改签失败");
		}
		return msgMap;
	}
	
}
