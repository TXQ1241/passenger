package org.passenger.pojo;

import java.util.Date;

public class Ticket {
    private String id;

    private String passStationId;

    private Date ticketDate;

    private Integer number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassStationId() {
        return passStationId;
    }

    public void setPassStationId(String passStationId) {
        this.passStationId = passStationId;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}