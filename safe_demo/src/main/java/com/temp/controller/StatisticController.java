package com.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.temp.service.StatisticService;

@Controller
public class StatisticController {

	@Autowired
	private StatisticService statisticService;
	
	
}
