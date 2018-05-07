package org.passenger.pojo;

import java.util.Date;

public class Route {
    private String id;

    private String startStationId;

    private Date startTime;

    private Date arriveTime;

    private String carTripCode;

    private Integer sort;

    private String fareCode;

    private String startStationName;

    private String arriveStationId;

    private String arriveStationName;

    private Double price;

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