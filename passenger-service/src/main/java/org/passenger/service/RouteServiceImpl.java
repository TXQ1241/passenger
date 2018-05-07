package org.passenger.service;

import org.passenger.dao.RouteMapper;
import org.passenger.pojo.Route;
import org.passenger.vo.RouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("routeService")
@Transactional
public class RouteServiceImpl implements IRouteService {

    @Autowired
    @Qualifier("routeMapper")
    RouteMapper routeMapper;

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
        return null;
    }
}
