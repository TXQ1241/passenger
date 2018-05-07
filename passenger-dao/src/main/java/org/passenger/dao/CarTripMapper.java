package org.passenger.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.passenger.pojo.CarTrip;
import org.passenger.vo.CarTripVo;
import org.springframework.stereotype.Repository;

@Repository("carTripMapper")
public interface CarTripMapper {

    int insert(CarTrip carTrip);

    int update(CarTrip carTrip);
    
    List<CarTrip> getCarTrips(CarTripVo carTripVo);
    
    int getCarTripCount(CarTripVo carTripVo);
    
    void deleteCarTripByIds(String[] ids);
}