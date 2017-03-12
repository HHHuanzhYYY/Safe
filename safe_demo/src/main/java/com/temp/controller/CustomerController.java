package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.CustomerManagerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerManagerService customerManagerService;
	
	@RequestMapping("/getCustomerInfo")
	public void getCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = customerManagerService.getCustomerInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setCustomerInfo")
	public void setCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = customerManagerService.setCustomerInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
