package org.passenger.controller;

import org.passenger.service.ICarTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cartrip/")
public class CarTripController {
	
	@Autowired
	@Qualifier("carTripService")
	ICarTripService carTripService;
	
}
