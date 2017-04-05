package com.temp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.BoxManageService;
import com.temp.util.BoxStatus;

@Controller
public class SpecialServiceController {
	
	@Autowired
	private BoxManageService boxManageService;

	@RequestMapping("/freezeBox")
	public void freezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.modifyBoxStatus(rawData, BoxStatus.FREEZE);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/unfreezeBox")
	public void unfreezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.modifyBoxStatus(rawData, BoxStatus.INRENT);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
