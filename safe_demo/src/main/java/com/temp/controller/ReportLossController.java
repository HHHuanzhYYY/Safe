package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.ReportLossService;
//import com.temp.util.JsonUtil;
import com.temp.util.ReportLossAction;

@Controller
@RequestMapping("/reportLoss")
public class ReportLossController {

	@Autowired
	private ReportLossService reportLossService;
	
	@RequestMapping(value="/bankEmployeeLogin", method={RequestMethod.GET, RequestMethod.POST})
	public void bankEmployeeLogin(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.bankEmployeeLogin(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setReportLossApply", method={RequestMethod.GET, RequestMethod.POST})
	public void setReportLossApply(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossLog(rawData, ReportLossAction.APPLYREPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setReportLossDetails", method={RequestMethod.GET, RequestMethod.POST})
	public void setReportLossDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossDetails(rawData, ReportLossAction.HANDLEEPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/removeReportLossState", method={RequestMethod.GET, RequestMethod.POST})
	public void removeReportLossState(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		//String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossLog(rawData, ReportLossAction.REMOVEREPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
