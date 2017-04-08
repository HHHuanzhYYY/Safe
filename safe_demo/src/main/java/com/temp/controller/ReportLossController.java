package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.ReportLossService;
import com.temp.util.JsonUtil;
import com.temp.util.ReportLossAction;

@Controller
@RequestMapping("/reportLoss")
public class ReportLossController {

	@Autowired
	private ReportLossService reportLossService;
	
	@RequestMapping("/bankEmployeeLogin")
	public void bankEmployeeLogin(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.bankEmployeeLogin(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setReportLossApply")
	public void setReportLossApply(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossLog(rawData, ReportLossAction.APPLYREPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setReportLossDetails")
	public void setReportLossDetails(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossDetails(rawData, ReportLossAction.HANDLEEPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/removeReportLossState")
	public void removeReportLossState(HttpServletRequest request, HttpServletResponse response) {
		//String rawData = request.getParameter("info");
		String rawData = JsonUtil.getRawData(request);
		try {
			String resJSON = reportLossService.setReportLossLog(rawData, ReportLossAction.REMOVEREPORTLOSS);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
