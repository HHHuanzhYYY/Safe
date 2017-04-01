package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.AccountManageService;
import com.temp.service.CustomerManageService;

@Controller
public class NewOpenAccountController {
	
	@Autowired
	private AccountManageService accountManagerService;
	
	@Autowired
	private CustomerManageService customerManagerService;

	@RequestMapping("/getAccoutsById")
	public void getAccountsById(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
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
		String rawData = request.getParameter("info");
		try {
			String resJSON = customerManagerService.validateCustomer(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getAccountInfo")
	public void getAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = accountManagerService.getAccountInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setAccountInfo")
	public void setAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = accountManagerService.setAccountInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setAccountNewBox")
	public void setAccountNewBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = accountManagerService.setAccountNewBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setAccountNewCustomer")
	public void setAccountNewCustomer(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = accountManagerService.setAccountNewCustomer(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
