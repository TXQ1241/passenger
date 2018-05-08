package org.passenger.service;

import java.util.ArrayList;
import java.util.List;

import org.passenger.dao.RouteMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.pojo.Route;
import org.passenger.pojo.Station;
import org.passenger.pojo.Ticket;
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
    
    @Autowired
    @Qualifier("ticketService")
    ITicketService ticketService;

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
    	
    	List<RouteVo> voList = new ArrayList<RouteVo> ();
    	List<Route> routeList = this.getRouteList(routeVo);
    	if(routeList != null && routeList.size() > 0) {
    		for(Route route:routeList) {
    			List<Ticket> ticketList = ticketService.getTicketByRoAndDate(route.getId(),routeVo.getDate());
    			if(ticketList != null && ticketList.size() > 0 ) {
    				for (Ticket t:ticketList) {
    	    			RouteVo vo = new RouteVo(route);
    	    			if(StringUtils.isNotBlank(route.getCarTripId())) {
    	    				CarTrip carTrip = carTripService.getCarTripById(route.getCarTripId());
    	    				vo.setCarTripCode(carTrip.getCode());
    	    			}
    	    			vo.setTicketNum(t.getNumber());
    	    			voList.add(vo);
    				}
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
