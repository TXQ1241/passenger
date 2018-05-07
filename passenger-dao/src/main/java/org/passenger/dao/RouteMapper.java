package org.passenger.dao;

import java.util.List;
import org.passenger.pojo.Route;
import org.passenger.vo.RouteVo;

public interface RouteMapper {
	
	List<Route> getRouteList(RouteVo routeVo);
	
	int getRouteCount(RouteVo routeVo);

    int insert(Route route);

    int update(Route route);
    
    void deleteRouteByIds(String[] ids);
}