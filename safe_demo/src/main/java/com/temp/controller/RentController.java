package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.RentService;

@Controller
public class RentController {
	
	@Autowired
	private RentService rentService;

	@RequestMapping("/getBoxDetails")
	public void getBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = rentService.getBoxReletInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setBoxReletInfo")
	public void setBoxReletInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = rentService.setBoxReletInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getBoxUnrentInfo")
	public void getBoxUnrentInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = rentService.getBoxUnrentInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setBoxUnrentInfo")
	public void setBoxUnrentInfo(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = rentService.setBoxOffleaseInfo(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
