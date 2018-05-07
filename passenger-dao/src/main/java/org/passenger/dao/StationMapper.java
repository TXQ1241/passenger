package org.passenger.dao;

import java.util.List;

import org.passenger.pojo.Station;
import org.passenger.vo.StationVo;
import org.springframework.stereotype.Repository;

@Repository("stationMapper")
public interface StationMapper {

    int insert(Station station);

    int update(Station station);
    
    List<Station> getStationList(StationVo stationVo);
    
    int getStationCount(StationVo stationVo);
    
    void deleteStationByIds(String[] ids);

	Station getStationById(String id);

	List<Station> getStationByName(String stationName);
}