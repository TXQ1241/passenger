package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.Ticket;
import org.passenger.service.ITicketService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.DataVo;
import org.passenger.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket/")
public class TicketController {
	
	@Autowired 
	@Qualifier("ticketService")
	ITicketService ticketService;

	/**
	 * 获取票数信息（分页）
	 * @param ticketVo
	 * @return
	 */
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
			List<Ticket> ticketList = ticketService.getTicketList(ticketVo);
			dataVo.setDatalist(ticketList);
			dataVo.setCode(Constants.DataCode.SUCCESS);
			dataVo.setMsg("数据获取成功");
			if (ticketList != null) {
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

	/**
	 * 保存/更新票数信息
	 * @param ticket
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, String> saveTicket(@RequestBody Ticket ticket){
		Map<String, String> msgMap = new HashMap<String, String>();
		try {
			if (StringUtils.isNotBlank(ticket.getId())) {
				ticketService.update(ticket);
			} else {
				ticket.setId(StringUtils.getUUID());
				ticketService.save(ticket);
			}
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存票数信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存票数信息失败");
		}
		return msgMap;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<String, String> deleteTicketByIds(@RequestBody TicketVo ticketVo){
		Map<String, String> msgMap = new HashMap<String, String>();
		String [] ticketIds = null;
		if(StringUtils.isNotBlank(ticketVo.getIds())){
			ticketIds = ticketVo.getIds().split(",");
		}
		try {
			if(ticketIds != null && ticketIds.length > 0) {
				ticketService.deleteTicketByIds(ticketIds);
			}
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除车站信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除车站信息失败");
		}
		return msgMap;
	}
	
}
