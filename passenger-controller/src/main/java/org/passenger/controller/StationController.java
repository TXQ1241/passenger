package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.Station;
import org.passenger.pojo.User;
import org.passenger.service.IStationService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.DataVo;
import org.passenger.vo.StationVo;
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
@RequestMapping("/station/")
public class StationController {
	
	@Autowired
	@Qualifier("stationService")
	IStationService stationService;

	@RequestMapping("getStationList")
	@ResponseBody
	public DataVo getStations(StationVo stationVo) {
		DataVo dataVo = new DataVo();
		Integer pageNum = stationVo.getPageNum();
		//设置查询开始的条数(就是从哪条开始查询)
		if(pageNum != null) {
			stationVo.setPageNum((pageNum-1)*stationVo.getPageSize());
		}
		try {
			List<User> userList = stationService.getStations(stationVo);
			dataVo.setDatalist(userList);
			dataVo.setCode(Constants.DataCode.SUCCESS);
			dataVo.setMsg("数据获取成功");
			if (userList != null) {
				dataVo.setCount(stationService.getStationCount(stationVo));
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
	public Map<String, String> saveStation(Station station){
		Map<String, String> msgMap = new HashMap<String, String>();
		try {
			if (StringUtils.isNotBlank(station.getId())) {
				stationService.update(station);
			} else {
				station.setId(StringUtils.getUUID());
				stationService.save(station);
			}
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存车站信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存车站信息失败");
		}
		return msgMap;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<String, String> deleteStations(@RequestBody StationVo stationVo) {
		Map<String, String> msgMap = new HashMap<String, String>();
		String [] stationIds = null;
		if(StringUtils.isNotBlank(stationVo.getIds())){
			stationIds = stationVo.getIds().split(",");
		}
		try {
			if(stationIds != null && stationIds.length > 0) {
				stationService.deleteStationByIds(stationIds);
			}
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除车站信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除车站信息失败");
		}
		return msgMap;
	}

}
