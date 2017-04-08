package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.BoxManageService;
import com.temp.service.CardManageService;
import com.temp.service.CustomerManageService;

@Controller
@RequestMapping("/modify")
public class ModifyController {
	
	@Autowired
	private BoxManageService boxManageService;
	
	@Autowired
	private CardManageService cardManageService;
	
	@Autowired
	private CustomerManageService customerManageService;
	
	@RequestMapping("/modifyCardPwd")
	public void modifyCardPwd(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = cardManageService.setCardPwd(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getCustomerData")
	public void getCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = customerManageService.getCustomerData(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setCustomerData")
	public void setCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = customerManageService.setCustomerData(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getChangeBoxDetails")
	public void getChangeBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.getChangeBoxDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/setChangeBoxDetails")
	public void setChangeBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.setChangeBoxDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
