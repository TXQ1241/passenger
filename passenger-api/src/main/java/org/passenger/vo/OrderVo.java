package org.passenger.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.passenger.pojo.Orders;

public class OrderVo extends PageVo {

    private String userId;
    private String fare;//票价
    private String startStation;//始发站
    private String arriveStation;//到达站
    private String carTripCode;//车次
    private Integer ticketNum;//车票数
    private String startTime;//出发时间
    private String endTime;//到达时间
    
    public OrderVo () {}
    public OrderVo (Orders orders) {
    	try {
			BeanUtils.copyProperties(this, orders);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
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
    
	public String getCarTripCode() {
		return carTripCode;
	}
	public void setCarTripCode(String carTripCode) {
		this.carTripCode = carTripCode;
	}
	
	public Integer getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
