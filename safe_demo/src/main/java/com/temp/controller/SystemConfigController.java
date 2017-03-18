package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.BankEmployeeService;
import com.temp.service.BoxManageService;
import com.temp.service.SystemConfigService;

@Controller
public class SystemConfigController {

	@Autowired
	private SystemConfigService systemConfigService;
	
	@Autowired
	private BoxManageService boxManageService;
	
	@Autowired
	private BankEmployeeService bankEmployeeService;
	
	@RequestMapping(value="/listAllMessages", method={RequestMethod.GET, RequestMethod.POST}) 
    public void listAllMessages(HttpServletRequest request, HttpServletResponse response) {    	
		try {
			String resJSON = systemConfigService.listAllMessages();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 
	
	@RequestMapping(value="/setMessageDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setMessageDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.setMessageDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteMessage", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteMessage(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.deleteMessage(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listBankBranches", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listBankBranches(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = systemConfigService.listBankBranches();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBankDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setBankDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.setBankDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteBank", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteBank(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.deleteBank(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listAllSubjects", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listAllSubjects(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = systemConfigService.listAllSubjects();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setSubjectDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setSubjectDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.setSubjectDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteSubject", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteSubject(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.deleteSubject(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listAllBoxs", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listAllBoxs(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = boxManageService.listAllBoxs();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBoxDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setBoxDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.setBoxDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteBox", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.deleteBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listAllBoxModels", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listAllBoxModels(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = boxManageService.listAllBoxModels();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBoxModelDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setBoxModelDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.setBoxModelDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteBoxModel", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteBoxModel(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = boxManageService.deleteBoxModel(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listAllBankEmployees", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listAllBankEmployees(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = bankEmployeeService.listAllBankEmployees();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setBankEmployeeDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setBankEmployeeDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = bankEmployeeService.setBankEmployeeDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteBankEmployee", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteBankEmployee(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = bankEmployeeService.deleteBankEmployee(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listAllFeeTypes", method={RequestMethod.GET, RequestMethod.POST}) 
	public void listAllFeeTypes(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resJSON = systemConfigService.listAllFeeTypes();
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/setFeeTypeDetails", method={RequestMethod.GET, RequestMethod.POST}) 
	public void setFeeTypeDetails(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.setFeeTypeDetails(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/operateFeeType", method={RequestMethod.GET, RequestMethod.POST}) 
	public void operateFeeType(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.operateFeeType(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteFeeType", method={RequestMethod.GET, RequestMethod.POST}) 
	public void deleteFeeType(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("info");
		try {
			String resJSON = systemConfigService.deleteFeeType(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
