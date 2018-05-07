package org.passenger.service;

import org.passenger.dao.CarTripMapper;
import org.passenger.pojo.CarTrip;
import org.passenger.vo.CarTripVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carTripService")
@Transactional
public class CarTripServiceImpl implements ICarTripService {

    @Autowired
    @Qualifier("carTripMapper")
    CarTripMapper carTripMapper;

    public List<CarTrip> getCarTrips(CarTripVo carTripVo) {
        return carTripMapper.getCarTrips(carTripVo);
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
}
