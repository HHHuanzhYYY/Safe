package com.temp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.BoxManageService;
import com.temp.util.BoxStatus;
//import com.temp.util.JsonUtil;

@Controller
@RequestMapping("/specialService")
public class SpecialServiceController {
	
	@Autowired
	private BoxManageService boxManageService;

	@RequestMapping(value="/freezeBox", method={RequestMethod.GET, RequestMethod.POST})
	public void freezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = boxManageService.modifyBoxStatus(rawData, BoxStatus.FREEZE);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/unfreezeBox", method={RequestMethod.GET, RequestMethod.POST})
	public void unfreezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = boxManageService.modifyBoxStatus(rawData, BoxStatus.INRENT);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
