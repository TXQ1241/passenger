package org.passenger.controller;

import org.passenger.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket/")
public class TicketController {
	
	@Autowired 
	@Qualifier("ticketService")
	ITicketService ticketService;
	
}
