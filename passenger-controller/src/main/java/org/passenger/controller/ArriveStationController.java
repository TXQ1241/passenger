package org.passenger.controller;

import org.passenger.service.IArriveStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arrive/")
public class ArriveStationController {
	
	@Autowired
	@Qualifier("arriveStationService")
	IArriveStationService arriveStationService;
	
}
