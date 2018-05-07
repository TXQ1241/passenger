package org.passenger.service;

import org.passenger.pojo.ArriveStation;
import org.passenger.vo.ArriveVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("arriveStationService")
@Transactional
public class ArriveStationServiceImpl implements IArriveStationService {

    public List<ArriveVo> getStations(ArriveVo arrvieVo) {
        return null;
    }

    public Integer getStationCount(ArriveVo arrvieVo) {
        return null;
    }

    public void saveArriveStation(ArriveVo arriveVo) {

    }

    public void save(ArriveStation arriveStation) {

    }

    public void deleteArriveByIds(String[] ids) {

    }
}
