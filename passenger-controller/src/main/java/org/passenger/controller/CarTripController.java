package org.passenger.controller;

import org.passenger.common.Constants;
import org.passenger.pojo.CarTrip;
import org.passenger.service.ICarTripService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.CarTripVo;
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
@RequestMapping("/cartrip/")
public class CarTripController {
	
	@Autowired
	@Qualifier("carTripService")
	ICarTripService carTripService;

	@RequestMapping("getCarTripList")
    @ResponseBody
    public DataVo getCarTrips(CarTripVo carTripVo){
        DataVo dataVo = new DataVo();
        Integer pageNum = carTripVo.getPageNum();
        //设置查询开始的条数(就是从哪条开始查询)
        if(pageNum != null) {
            carTripVo.setPageNum((pageNum-1)*carTripVo.getPageSize());
        }
        try {
            List<CarTripVo> carTripList = carTripService.getCarTripVos(carTripVo);
            dataVo.setDatalist(carTripList);
            dataVo.setCode(Constants.DataCode.SUCCESS);
            dataVo.setMsg("数据获取成功");
            if (carTripList != null) {
                dataVo.setCount(carTripService.getCarTripCount(carTripVo));
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
    public Map<String, String> saveCarTrip(@RequestBody CarTrip carTrip){
        Map<String, String> msgMap = new HashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(carTrip.getId())) {
                carTripService.update(carTrip);
            } else {
                carTrip.setId(StringUtils.getUUID());
                carTripService.save(carTrip);
            }
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存车次信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存车次信息失败");
        }
        return msgMap;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, String> deleteCarTripByIds(@RequestBody CarTripVo carTripVo) {
        Map<String, String> msgMap = new HashMap<String, String>();
        String [] carTripIds = null;
        if(StringUtils.isNotBlank(carTripVo.getIds())){
            carTripIds = carTripVo.getIds().split(",");
        }
        try {
            if(carTripIds != null && carTripIds.length > 0) {
                carTripService.deleteCarTripByIds(carTripIds);
            }
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除车次信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除车次信息失败");
        }
        return msgMap;
    }

}
