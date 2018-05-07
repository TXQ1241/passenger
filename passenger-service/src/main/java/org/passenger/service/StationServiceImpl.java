package org.passenger.service;

import org.passenger.dao.StationMapper;
import org.passenger.pojo.Station;
import org.passenger.vo.StationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("stationService")
@Transactional
public class StationServiceImpl implements IStationService {

    @Autowired
    @Qualifier("stationMapper")
    StationMapper stationMapper;

    public List<Station> getStations(StationVo stationVo) {
        return stationMapper.getStationList(stationVo);
    }

    public Integer getStationCount(StationVo stationVo) {
        return stationMapper.getStationCount(stationVo);
    }

    public void update(Station station) {
        stationMapper.update(station);
    }

    public void save(Station station) {
        stationMapper.insert(station);
    }

    public void deleteStationByIds(String[] stationIds) {
        stationMapper.deleteStationByIds(stationIds);
    }

	public Station getStationById(String id) {
		return stationMapper.getStationById(id);
	}

	public List<Station> getStationByName(String stationName) {
		return stationMapper.getStationByName(stationName);
	}
}
