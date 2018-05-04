package org.passenger.controller;

import org.passenger.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/station/")
public class StationController {
	
	@Autowired
	@Qualifier("stationService")
	IStationService stationService;
	
}
