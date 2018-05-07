package org.passenger.service;

import org.passenger.pojo.Ticket;
import org.passenger.vo.TicketVo;

import java.util.List;

/**
 * 票数管理接口
 * @author Administrator
 *
 */
public interface ITicketService {

    /**
     * 获取票数信息
     * @param ticketVo
     * @return
     */
    List<Ticket> getTicketList(TicketVo ticketVo);

    /**
     * 获取票数记录数
     * @param ticketVo
     * @return
     */
    Integer getTicketCount(TicketVo ticketVo);

    /**
     * 保存票数信息
     * @param ticket
     */
    void save(Ticket ticket);

    /**
     * 更新票数信息
     * @param ticket
     */
    void update(Ticket ticket);

    /**
     * 批量删除票数信息
     * @param ticketIds
     */
    void deleteTicketByIds(String[] ticketIds);
    
    /**
     * 通过id获取票信息
     * @param ticketId
     * @return
     */
	Ticket getTicketById(String ticketId);
}
