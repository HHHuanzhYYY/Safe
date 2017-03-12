package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.AccountManagerService;
import com.temp.service.CustomerManagerService;

@Controller
public class NewOpenAccountController {
	
	@Autowired
	private AccountManagerService accountManagerService;
	
	@Autowired
	private CustomerManagerService customerManagerService;

	@RequestMapping("/getAccoutsById")
	public void getAccountsById(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = accountManagerService.getAccoutListByIdOrRFID(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/validateCustomer")
	public void validateCustomer(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = customerManagerService.validateCustomer(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getCustomerInfo")
	public void getCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = customerManagerService.getCustomerInfoById(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setAccountInfo")
	public void setAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = accountManagerService.setAccountInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
