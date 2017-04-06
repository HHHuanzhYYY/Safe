package com.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.temp.service.QueryService;

@Controller
public class QueryController {

	@Autowired
	private QueryService queryService;
	
}
