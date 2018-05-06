package org.passenger.vo;

import java.util.Date;

public class ArriveVo extends PageVo{
    private String id;

    private String ids;

    private String stationId;

    private Date startTime;

    private Date arriveTime;

    private String carTripCode;//车次编码

    private Integer sort;

    private String fareCode;

    private String fare;

    private Integer ticketNum;

    private String stationName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
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

    public String getCarTripCode() {
        return carTripCode;
    }

    public void setCarTripCode(String carTripCode) {
        this.carTripCode = carTripCode;
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

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }
}
