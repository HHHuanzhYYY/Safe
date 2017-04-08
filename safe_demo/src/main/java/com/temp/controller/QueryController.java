package com.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.QueryService;

@Controller
@RequestMapping("/query")
public class QueryController {

	@Autowired
	private QueryService queryService;
	
}
