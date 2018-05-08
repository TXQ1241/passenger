package org.passenger.dao;

import java.util.List;
import org.passenger.pojo.Ticket;
import org.passenger.vo.TicketVo;
import org.springframework.stereotype.Repository;

@Repository("ticketMapper")
public interface TicketMapper {
	
	List<Ticket> getTicketList(TicketVo ticketVo);
	
	int getTicketCount(TicketVo ticketVo);
	
    int insert(Ticket ticket);
    
    int update(Ticket ticket);
    
    void deleteTicketByIds(String[] ids);

	Ticket getTicketById(String ticketId);

	List<Ticket> getTicketByRoAndDate(Ticket ticket);
}