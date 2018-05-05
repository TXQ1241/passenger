package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.ArriveStation;
import org.passenger.service.IArriveStationService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.ArriveVo;
import org.passenger.vo.DataVo;
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
@RequestMapping("/arrive/")
public class ArriveStationController {
	
	@Autowired
	@Qualifier("arriveStationService")
	IArriveStationService arriveStationService;

	@RequestMapping("getArriveStationList")
	@ResponseBody
	public DataVo getArriveStations(ArriveVo arrvieVo) {
		DataVo dataVo = new DataVo();
		try {
			List<ArriveVo> userList = arriveStationService.getStations(arrvieVo);
			dataVo.setDatalist(userList);
			dataVo.setCode(Constants.DataCode.SUCCESS);
			dataVo.setMsg("数据获取成功");
			if (userList != null) {
				dataVo.setCount(arriveStationService.getStationCount(arrvieVo));
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
	public Map<String, String>saveArriveStation(ArriveVo arriveVo) {
		Map<String, String> msgMap = new HashMap<String, String>();
		try {
			arriveStationService.saveArriveStation(arriveVo);
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存站点信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存站点信息失败");
		}
		return msgMap;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<String, String> deleteArriveStations(@RequestBody ArriveVo arriveVo) {
		Map<String, String> msgMap = new HashMap<String, String>();
		String [] arriveIds = null;
		if(StringUtils.isNotBlank(arriveVo.getIds())){
			arriveIds = arriveVo.getIds().split(",");
		}
		try {
			if(arriveIds != null && arriveIds.length > 0) {
				arriveStationService.deleteArriveByIds(arriveIds);
			}
			msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除站点信息成功");
		} catch (Exception e) {
			msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除站点信息失败");
		}
		return msgMap;
	}

}
