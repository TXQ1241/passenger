package org.passenger.vo;

import org.apache.commons.beanutils.BeanUtils;
import org.passenger.pojo.Route;

import java.lang.reflect.InvocationTargetException;

public class RouteVo extends PageVo {
	private String id;
    private String ids;
    private String startStationId;//始发站id
    private String startStationName;//始发站名称
    private String arriveStationId;//到达站id
    private String arriveStationName;//到达站名称
    private String startTime;//始发时间
    private String arriveTime;//到达时间
    private Integer ticketNum;//票数
    private Double price;//票价
    private String carTripCode;//车次编码
    private String carTripId;//车次id
    private String date;//日期
    private String ticketId;//车票数id

    public RouteVo(){}

    public RouteVo(Route route){
        try {
            BeanUtils.copyProperties(this, route);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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

    public String getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(String startStationId) {
        this.startStationId = startStationId;
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

	public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCarTripCode() {
        return carTripCode;
    }

    public void setCarTripCode(String carTripCode) {
        this.carTripCode = carTripCode;
    }
    
    public String getCarTripId() {
		return carTripId;
	}

	public void setCarTripId(String carTripId) {
		this.carTripId = carTripId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
}
