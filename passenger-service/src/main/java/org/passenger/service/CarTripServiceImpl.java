package org.passenger.service;

import java.util.ArrayList;
import java.util.List;

import org.passenger.dao.CarTripMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.pojo.Station;
import org.passenger.utils.StringUtils;
import org.passenger.vo.CarTripVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carTripService")
@Transactional
public class CarTripServiceImpl implements ICarTripService {

    @Autowired
    @Qualifier("carTripMapper")
    CarTripMapper carTripMapper;
    
    @Autowired
    @Qualifier("stationService")
    IStationService stationService;

    public List<CarTrip> getCarTrips(CarTripVo carTripVo) {
        return carTripMapper.getCarTripList(carTripVo);
    }

    public Integer getCarTripCount(CarTripVo carTripVo) {
        return carTripMapper.getCarTripCount(carTripVo);
    }

    public void update(CarTrip carTrip) {
        carTripMapper.update(carTrip);
    }

    public void save(CarTrip carTrip) {
        carTripMapper.insert(carTrip);
    }

    public void deleteCarTripByIds(String[] carTripIds) {
        carTripMapper.deleteCarTripByIds(carTripIds);
    }

	public List<CarTripVo> getCarTripVos(CarTripVo carTripVo) {
		List<CarTripVo> voList = new ArrayList<CarTripVo>();
		List<CarTrip> carTripList = this.getCarTrips(carTripVo);
		if(carTripList != null && carTripList.size() > 0) {
			for (CarTrip carTrip:carTripList) {
				CarTripVo vo = new CarTripVo(carTrip);
				if(StringUtils.isNotBlank(vo.getArriveStation())) {
					Station station = stationService.getStationById(vo.getArriveStation());
					vo.setStartStationName(station.getName());
				}
				if(StringUtils.isNotBlank(vo.getStartStation())) {
					Station station = stationService.getStationById(vo.getArriveStation());
					vo.setArriveStationName(station.getName());
				}
				voList.add(vo);
			}
		}
		return null;
	}

	public CarTrip getCarTripById(String carTripId) {
		return carTripMapper.getCarTripById(carTripId);
	}
}
