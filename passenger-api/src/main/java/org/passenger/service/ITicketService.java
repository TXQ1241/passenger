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
}
