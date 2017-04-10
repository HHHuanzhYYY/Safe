package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.RentService;
import com.temp.util.JsonUtil;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	private RentService rentService;

	@RequestMapping(value="/getBoxDetails", method={RequestMethod.GET, RequestMethod.POST})
	public void getBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = rentService.getBoxReletInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBoxReletInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void setBoxReletInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = rentService.setBoxReletInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getBoxUnrentInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void getBoxUnrentInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = rentService.getBoxUnrentInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBoxUnrentInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void setBoxUnrentInfo(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = rentService.setBoxOffleaseInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
