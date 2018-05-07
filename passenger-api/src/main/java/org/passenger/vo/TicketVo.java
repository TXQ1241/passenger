package org.passenger.vo;

public class TicketVo extends PageVo {
    private String routeId;
    private String ids;

    public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
