package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.Ticket;
import org.passenger.service.ITicketService;
import org.passenger.vo.DataVo;
import org.passenger.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ticket/")
public class TicketController {
	
	@Autowired 
	@Qualifier("ticketService")
	ITicketService ticketService;

	@RequestMapping("getTicketList")
	@ResponseBody
	public DataVo getTickets(TicketVo ticketVo) {
		DataVo dataVo = new DataVo();
		Integer pageNum = ticketVo.getPageNum();
		//设置查询开始的条数(就是从哪条开始查询)
		if(pageNum != null) {
			ticketVo.setPageNum((pageNum-1)*ticketVo.getPageSize());
		}
		try {
			List<Ticket> userList = ticketService.getTicketList(ticketVo);
			dataVo.setDatalist(userList);
			dataVo.setCode(Constants.DataCode.SUCCESS);
			dataVo.setMsg("数据获取成功");
			if (userList != null) {
				dataVo.setCount(ticketService.getTicketCount(ticketVo));
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
	
}
