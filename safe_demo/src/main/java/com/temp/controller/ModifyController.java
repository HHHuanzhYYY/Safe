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
public class ModifyController {
	
	@Autowired
	private BoxManageService boxManageService;
	
	@Autowired
	private CardManageService cardManageService;
	
	@Autowired
	private CustomerManageService customerManageService;
	
	@RequestMapping("/modifyCardPwd")
	public void modifyCardPwd(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = cardManageService.modifyCardPwd(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getCustomerData")
	public void getCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
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
		String rawData = request.getParameter("Info");
		try {
			String resJSON = customerManageService.setCustomerData(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/changeBox")
	public void changeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = boxManageService.changeBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
