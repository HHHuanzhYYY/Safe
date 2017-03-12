package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.temp.service.BankEmployeeService;

@Controller  
public class BankEmployeeController {  
	
    @Resource  
    private BankEmployeeService bankEmployeeService;  
      
    @RequestMapping(value="/login", method={RequestMethod.GET, RequestMethod.POST}) 
    public void login(HttpServletRequest request, HttpServletResponse response) {    	
		final String rawData = request.getParameter("Info");
		try {
			String resJSON = bankEmployeeService.validateBankEmployee(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 
}  
