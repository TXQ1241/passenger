package org.passenger.vo;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.passenger.pojo.CarTrip;

public class CarTripVo extends PageVo {
    private String id;
    
    private String ids;

    private String code;

    private String startStation;
    
    private String startStationName;

    private String arriveStation;
    
    private String arriveStationName;

    private Date startTime;

    private Date arriveTime;
    
    public CarTripVo() {}
    public CarTripVo(CarTrip carTrip) {
    	try {
			BeanUtils.copyProperties(this, carTrip);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getArriveStation() {
		return arriveStation;
	}

	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getStartStationName() {
		return startStationName;
	}
	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}
	public String getArriveStationName() {
		return arriveStationName;
	}
	public void setArriveStationName(String arriveStationName) {
		this.arriveStationName = arriveStationName;
	}
	
    
}
