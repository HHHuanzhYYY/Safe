package com.temp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.AccountManageService;
import com.temp.service.CustomerManageService;
import com.temp.util.JsonUtil;

@Controller
@RequestMapping("/openAccount")
public class NewOpenAccountController {
	
	@Autowired
	private AccountManageService accountManagerService;
	
	@Autowired
	private CustomerManageService customerManagerService;

	@RequestMapping(value="/getAccoutsById", method={RequestMethod.GET, RequestMethod.POST})
	public void getAccountsById(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = accountManagerService.getAccoutListByIdOrRFID(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/validateCustomer", method={RequestMethod.GET, RequestMethod.POST})
	public void validateCustomer(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = customerManagerService.validateCustomer(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getAccountInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void getAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = accountManagerService.getAccountInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setAccountInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void setAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = accountManagerService.setAccountInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setAccountNewBox", method={RequestMethod.GET, RequestMethod.POST})
	public void setAccountNewBox(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = accountManagerService.setAccountNewBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setAccountNewCustomer", method={RequestMethod.GET, RequestMethod.POST})
	public void setAccountNewCustomer(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = accountManagerService.setAccountNewCustomer(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
