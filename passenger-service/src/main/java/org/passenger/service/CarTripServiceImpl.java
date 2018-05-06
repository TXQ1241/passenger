package org.passenger.service;

import org.passenger.pojo.CarTrip;
import org.passenger.vo.CarTripVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carTripService")
@Transactional
public class CarTripServiceImpl implements ICarTripService {

    public List<CarTrip> getCarTrips(CarTripVo carTripVo) {
        return null;
    }

    public Integer getCarTripCount(CarTripVo carTripVo) {
        return null;
    }

    public void update(CarTrip carTrip) {

    }

    public void save(CarTrip carTrip) {

    }

    public void deleteCarTripByIds(String[] carTripIds) {

    }
}
