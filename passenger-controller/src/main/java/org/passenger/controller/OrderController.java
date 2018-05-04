package org.passenger.controller;

import org.passenger.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	IOrderService orderService;
	
}
