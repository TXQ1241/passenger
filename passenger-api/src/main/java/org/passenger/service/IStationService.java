package org.passenger.service;

import org.passenger.pojo.Station;
import org.passenger.vo.StationVo;

import java.util.List;

/**
 * 车站管理接口
 * @author Administrator
 *
 */
public interface IStationService {

    /**
     * 获取车站信息
     * @param stationVo
     * @return
     */
    List<Station> getStations(StationVo stationVo);

    /**
     * 获取车站记录数
     * @param stationVo
     * @return
     */
    Integer getStationCount(StationVo stationVo);

    /**
     * 更新车站信息
     * @param station
     */
    void update(Station station);

    /**
     * 保存车站信息
     * @param station
     */
    void save(Station station);

    /**
     * 批量删除车站信息
     * @param stationIds
     */
    void deleteStationByIds(String[] stationIds);
    
    /**
     * 通过id获取车站信息
     * @param arriveStation
     * @return
     */
	Station getStationById(String id);
	
	/**
	 * 通过名称获取车站信息
	 * @param startStationName
	 * @return
	 */
	List<Station> getStationByName(String stationName);
   
}
