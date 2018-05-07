package org.passenger.service;

import java.util.List;

import org.passenger.dao.TicketMapper;
import org.passenger.pojo.Ticket;
import org.passenger.vo.RouteVo;
import org.passenger.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ticketService")
@Transactional
public class TriketServiceImpl implements ITicketService {

    @Autowired
    @Qualifier("ticketMapper")
    TicketMapper ticketMapper;

    public List<Ticket> getTicketList(TicketVo ticketVo) {
        return ticketMapper.getTicketList(ticketVo);
    }

    public Integer getTicketCount(TicketVo ticketVo) {
        return ticketMapper.getTicketCount(ticketVo);
    }

    public void save(Ticket ticket) {
        ticketMapper.insert(ticket);
    }

    public void update(Ticket ticket) {
        ticketMapper.update(ticket);
    }

    public void deleteTicketByIds(String[] ticketIds) {
        ticketMapper.deleteTicketByIds(ticketIds);
    }

	public Ticket getTicketById(String ticketId) {
		return ticketMapper.getTicketById(ticketId);
	}

	public List<Ticket> getTicketByRoAndDate(String routeId, String date) {
		Ticket ticket = new Ticket();
		ticket.setRouteId(routeId);
		ticket.setTicketDate(date);
		return ticketMapper.getTicketByRoAndDate(ticket);
	}
}
