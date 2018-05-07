package org.passenger.vo;

public class TicketVo extends PageVo {
    private String passStationId;
    private String ids;

    public String getPassStationId() {
        return passStationId;
    }

    public void setPassStationId(String passStationId) {
        this.passStationId = passStationId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
