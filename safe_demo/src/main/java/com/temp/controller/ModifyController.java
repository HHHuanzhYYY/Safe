package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.BoxManageService;
import com.temp.service.CardManageService;
import com.temp.service.CustomerManageService;
import com.temp.util.JsonUtil;

@Controller
@RequestMapping("/modify")
public class ModifyController {
	
	@Autowired
	private BoxManageService boxManageService;
	
	@Autowired
	private CardManageService cardManageService;
	
	@Autowired
	private CustomerManageService customerManageService;
	
	@RequestMapping(value="/modifyCardPwd", method={RequestMethod.GET, RequestMethod.POST})
	public void modifyCardPwd(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = cardManageService.setCardPwd(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getCustomerData", method={RequestMethod.GET, RequestMethod.POST})
	public void getCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = customerManageService.getCustomerData(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setCustomerData", method={RequestMethod.GET, RequestMethod.POST})
	public void setCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = customerManageService.setCustomerData(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getChangeBoxInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void getChangeBoxInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = boxManageService.getChangeBoxInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getChangeBoxDetails", method={RequestMethod.GET, RequestMethod.POST})
	public void getChangeBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = boxManageService.getChangeBoxDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/setChangeBoxDetails", method={RequestMethod.GET, RequestMethod.POST})
	public void setChangeBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = boxManageService.setChangeBoxDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
