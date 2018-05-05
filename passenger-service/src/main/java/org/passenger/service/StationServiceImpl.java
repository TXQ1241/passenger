package org.passenger.service;

import org.passenger.pojo.Station;
import org.passenger.pojo.User;
import org.passenger.vo.StationVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("stationService")
@Transactional
public class StationServiceImpl implements IStationService {

    public List<User> getStations(StationVo stationVo) {
        return null;
    }

    public Integer getStationCount(StationVo stationVo) {
        return null;
    }

    public void update(Station station) {

    }

    public void save(Station station) {

    }

    public void deleteStationByIds(String[] stationIds) {

    }
}
