package org.passenger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				//设置车站名
				if(StringUtils.isNotBlank(vo.getStartStation())) {
					Station station = stationService.getStationById(vo.getStartStation());
					vo.setStartStationName(station.getName());
				}
				if(StringUtils.isNotBlank(vo.getArriveStation())) {
					Station station = stationService.getStationById(vo.getArriveStation());
					vo.setArriveStationName(station.getName());
				}
				//设置时间
				if(carTrip.getStartTime() != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String startTimeStr = df.format(carTrip.getStartTime());
					String [] times = startTimeStr.split(" ");
					vo.setStartTimeStr(times[1]);
				}
				if(carTrip.getArriveTime() != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String startTimeStr = df.format(carTrip.getArriveTime());
					String [] times = startTimeStr.split(" ");
					vo.setArriveTimeStr(times[1]);
				}
				voList.add(vo);
			}
		}
		return voList;
	}

	public CarTrip getCarTripById(String carTripId) {
		return carTripMapper.getCarTripById(carTripId);
	}

	public void saveCarTrip(CarTripVo carTripVo) {
		try {
			//车次中设置车站名称
			if(StringUtils.isNotBlank(carTripVo.getStartStationName())) {
				List<Station> stationList = stationService.getStationByName(carTripVo.getStartStationName());
				if(stationList != null && stationList.size() > 0) {
					Station startStation = stationList.get(0);
					carTripVo.setStartStation(startStation.getId());
				}
			}
			if(StringUtils.isNotBlank(carTripVo.getArriveStationName())) {
				List<Station> stationList = stationService.getStationByName(carTripVo.getArriveStationName());
				if(stationList != null && stationList.size() > 0) {
					Station arriveStation = stationList.get(0);
					carTripVo.setArriveStation(arriveStation.getId());
				}
			}
			//转换时间格式
			if(StringUtils.isNotBlank(carTripVo.getStartTimeStr())) {
		        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
		        Date date=simpleDateFormat.parse(carTripVo.getStartTimeStr());
		        carTripVo.setStartTime(date);
			}
			if(StringUtils.isNotBlank(carTripVo.getArriveTimeStr())) {
		        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
		        Date date=simpleDateFormat.parse(carTripVo.getArriveTimeStr());
		        carTripVo.setArriveTime(date);
			}
			CarTrip carTrip = new CarTrip(carTripVo);
			if(StringUtils.isNotBlank(carTrip.getId())) {
				this.update(carTrip);
			} else {
				carTrip.setId(StringUtils.getUUID());
				this.save(carTrip);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
