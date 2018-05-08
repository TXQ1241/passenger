package org.passenger.service;

import org.passenger.pojo.Route;
import org.passenger.vo.RouteVo;

import java.util.List;

public interface IRouteService {
    /**
     * 批量删除线路信息
     * @param routeIds
     */
    void deleteRouteByIds(String[] routeIds);

    /**
     * 保存线路信息
     * @param route
     */
    void save(Route route);

    /**
     * 保存线路信息
     * @param route
     */
    void update(Route route);

    /**
     * 获取线路信息
     * @param routeVo
     * @return
     */
    List<Route> getRouteList(RouteVo routeVo);

    /**
     * 获取线路记录数
     * @param routeVo
     * @return
     */
    Integer getRouteCount(RouteVo routeVo);

    /**
     * 获取线路整合信息
     * @param routeVo
     * @return
     */
    List<RouteVo> getRouteVoList(RouteVo routeVo);
    
    /**
     * 保存路径信息
     * @param routeVo
     */
	void saveRoute(RouteVo routeVo);
	
	/**
	 * 获取线路信息
	 * @param routeVo
	 * @return
	 */
	List<RouteVo> getRouteInfoList(RouteVo routeVo);
	
	/**
	 * 通过id获取线路信息
	 * @param id
	 * @return
	 */
	Route getRouteById(String id);
}
