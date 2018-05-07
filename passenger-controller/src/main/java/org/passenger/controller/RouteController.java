package org.passenger.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.passenger.common.Constants;
import org.passenger.pojo.Route;
import org.passenger.service.IRouteService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.DataVo;
import org.passenger.vo.RouteVo;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/route/")
public class RouteController {

    @Autowired
    @Qualifier("routeService")
    IRouteService routeService;
    
    @RequestMapping("setCarTripId")
    public String setCarTripId(HttpServletRequest request,String carTripId) {
    	request.setAttribute(Constants.RouteConstants.CAR_TRIP_ID,carTripId);
    	return "arriveStation";
    }
    
    @RequestMapping("getCarTripId")
    @ResponseBody
    public String getCarTripId(HttpServletRequest request) {
    	return (String) request.getSession().getAttribute(Constants.RouteConstants.CAR_TRIP_ID);
    }
    
    /**
     * 获取线路信息（分页）
     * @param routeVo
     * @return
     */
    @RequestMapping("getRouteList")
    @ResponseBody
    public DataVo getRouteList(RouteVo routeVo) {
        DataVo dataVo = new DataVo();
        Integer pageNum = routeVo.getPageNum();
        //设置查询开始的条数(就是从哪条开始查询)
        if(pageNum != null) {
            routeVo.setPageNum((pageNum-1)*routeVo.getPageSize());
        }
        try {
            List<RouteVo> routeList = routeService.getRouteVoList(routeVo);
            dataVo.setDatalist(routeList);
            dataVo.setCode(Constants.DataCode.SUCCESS);
            dataVo.setMsg("数据获取成功");
            if (routeList != null) {
                dataVo.setCount(routeService.getRouteCount(routeVo));
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
     * @param route
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public Map<String, String> saveRoute(@RequestBody Route route){
        Map<String, String> msgMap = new HashMap<String, String>();
        try {
            routeService.saveRoute(route);
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存票数信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存票数信息失败");
        }
        return msgMap;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, String> deleteRouteByIds(@RequestBody RouteVo routeVo){
        Map<String, String> msgMap = new HashMap<String, String>();
        String [] routeIds = null;
        if(StringUtils.isNotBlank(routeVo.getIds())){
            routeIds = routeVo.getIds().split(",");
        }
        try {
            if(routeIds != null && routeIds.length > 0) {
                routeService.deleteRouteByIds(routeIds);
            }
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除车站信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除车站信息失败");
        }
        return msgMap;
    }

    @RequestMapping("getRoutes")
    @ResponseBody
    public DataVo getRoutes(RouteVo routeVo) {
        DataVo dataVo = new DataVo();
        try {
            List<RouteVo> userList = routeService.getRouteVoList(routeVo);
            dataVo.setDatalist(userList);
            dataVo.setCode(Constants.DataCode.SUCCESS);
            dataVo.setMsg("数据获取成功");
        } catch (Exception e) {
            dataVo.setCode(Constants.DataCode.FAIL);
            dataVo.setMsg("数据获取失败");
            e.printStackTrace();
        }
        return dataVo;
    }

}
