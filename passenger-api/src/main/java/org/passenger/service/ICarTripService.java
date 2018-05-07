package org.passenger.service;

import org.passenger.pojo.CarTrip;
import org.passenger.vo.CarTripVo;

import java.util.List;

/**
 * 车次管理接口
 * @author Administrator
 *
 */
public interface ICarTripService {

    /**
     * 获取车次信息
     * @param carTripVo
     * @return
     */
    List<CarTrip> getCarTrips(CarTripVo carTripVo);

    /**
     * 获取车次记录数
     * @param carTripVo
     * @return
     */
    Integer getCarTripCount(CarTripVo carTripVo);

    /**
     * 更新车次信息
     * @param carTrip
     */
    void update(CarTrip carTrip);

    /**
     * 保存车次信息
     * @param carTrip
     */
    void save(CarTrip carTrip);

    /**
     * 批量删除车次信息
     * @param carTripIds
     */
    void deleteCarTripByIds(String[] carTripIds);
    
    /**
     * 获取车次信息
     * @param carTripVo
     * @return
     */
	List<CarTripVo> getCarTripVos(CarTripVo carTripVo);
	
	/**
	 * 通过id获取车次信息
	 * @param carTripId
	 * @return
	 */
	CarTrip getCarTripById(String carTripId);
}
