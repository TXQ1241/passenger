package org.passenger.service;

import org.passenger.dao.TicketMapper;
import org.passenger.pojo.Ticket;
import org.passenger.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
