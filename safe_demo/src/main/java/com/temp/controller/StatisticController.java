package com.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.StatisticService;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

	@Autowired
	private StatisticService statisticService;
	
	
}
