package org.passenger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.passenger.dao.RouteMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.pojo.Route;
import org.passenger.pojo.Station;
import org.passenger.utils.StringUtils;
import org.passenger.vo.RouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("routeService")
@Transactional
public class RouteServiceImpl implements IRouteService {

    @Autowired
    @Qualifier("routeMapper")
    RouteMapper routeMapper;
    
    @Autowired
    @Qualifier("stationService")
    IStationService stationService;
    
    @Autowired
    @Qualifier("carTripService")
    ICarTripService carTripService;

    public void deleteRouteByIds(String[] routeIds) {
        routeMapper.deleteRouteByIds(routeIds);
    }

    public void save(Route route) {
        routeMapper.insert(route);
    }

    public void update(Route route) {
        routeMapper.update(route);
    }

    public List<Route> getRouteList(RouteVo routeVo) {
        return routeMapper.getRouteList(routeVo);
    }

    public Integer getRouteCount(RouteVo routeVo) {
        return routeMapper.getRouteCount(routeVo);
    }

    public List<RouteVo> getRouteVoList(RouteVo routeVo) {
    	List<RouteVo> voList = new ArrayList<RouteVo> ();
    	List<Route> routeList = this.getRouteList(routeVo);
    	if(routeList != null && routeList.size() > 0) {
    		for(Route route:routeList) {
    			RouteVo vo = new RouteVo(route);
    			if(StringUtils.isNotBlank(route.getCarTripId())) {
    				CarTrip carTrip = carTripService.getCarTripById(route.getCarTripId());
    				vo.setCarTripCode(carTrip.getCode());
    			}
    			voList.add(vo);
    			//设置时间
    			if(route.getStartTime() != null) {
    				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    				String startTimeStr = df.format(route.getStartTime());
    				String [] times = startTimeStr.split(" ");
    				vo.setStartTimeStr(times[1]);
    			}
    			if(route.getArriveTime() != null) {
    				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    				String startTimeStr = df.format(route.getArriveTime());
    				String [] times = startTimeStr.split(" ");
    				vo.setArriveTimeStr(times[1]);
    			}
    		}
    	}
        return voList;
    }

	public void saveRoute(RouteVo routeVo) {
		try {
			//车次中设置车站名称
			if(StringUtils.isNotBlank(routeVo.getStartStationName())) {
				List<Station> stationList = stationService.getStationByName(routeVo.getStartStationName());
				if(stationList != null && stationList.size() > 0) {
					Station startStation = stationList.get(0);
					routeVo.setStartStationId(startStation.getId());
				}
			}
			if(StringUtils.isNotBlank(routeVo.getArriveStationName())) {
				List<Station> stationList = stationService.getStationByName(routeVo.getArriveStationName());
				if(stationList != null && stationList.size() > 0) {
					Station arriveStation = stationList.get(0);
					routeVo.setArriveStationId(arriveStation.getId());
				}
			}
			//转换时间格式
			if(StringUtils.isNotBlank(routeVo.getStartTimeStr())) {
		        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
		        Date date=simpleDateFormat.parse(routeVo.getStartTimeStr());
		        routeVo.setStartTime(date);
			}
			if(StringUtils.isNotBlank(routeVo.getArriveTimeStr())) {
		        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
		        Date date=simpleDateFormat.parse(routeVo.getArriveTimeStr());
		        routeVo.setArriveTime(date);
			}
			Route route = new Route(routeVo);
			if(StringUtils.isNotBlank(route.getId())) {
				this.update(route);
			} else {
				route.setId(StringUtils.getUUID());
				this.save(route);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
