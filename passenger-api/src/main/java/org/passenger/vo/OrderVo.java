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
    private Double price;//车票数
    private String startTime;//出发时间
    private String arriveTime;//到达时间
    private String ticketDate;//票日期
    
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
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
    
}
