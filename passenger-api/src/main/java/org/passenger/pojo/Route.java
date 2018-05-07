package org.passenger.pojo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.passenger.vo.RouteVo;

public class Route {
    private String id;

    private String startStationId;

    private String startTime;

    private String arriveTime;

    private String carTripId;

    private Integer sort;

    private String fareCode;

    private String startStationName;

    private String arriveStationId;

    private String arriveStationName;

    private Double price;
    
    public Route() {}
    
	public Route(RouteVo routeVo) {
		try {
			BeanUtils.copyProperties(this, routeVo);
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

	public String getStartStationId() {
		return startStationId;
	}

	public void setStartStationId(String startStationId) {
		this.startStationId = startStationId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getCarTripId() {
		return carTripId;
	}

	public void setCarTripId(String carTripId) {
		this.carTripId = carTripId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getFareCode() {
		return fareCode;
	}

	public void setFareCode(String fareCode) {
		this.fareCode = fareCode;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public String getArriveStationId() {
		return arriveStationId;
	}

	public void setArriveStationId(String arriveStationId) {
		this.arriveStationId = arriveStationId;
	}

	public String getArriveStationName() {
		return arriveStationName;
	}

	public void setArriveStationName(String arriveStationName) {
		this.arriveStationName = arriveStationName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    
}