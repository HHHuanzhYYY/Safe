package com.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.BoxManagerService;

@Controller
public class BoxController {
	
	@Autowired
	private BoxManagerService boxManagerService;

	@RequestMapping("/modifyBoxPwd")
	public void modifyBoxPwd(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = boxManagerService.modifyBoxPwd(rawData);
			
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
			String resJSON = boxManagerService.changeBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/freezeBox")
	public void freezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = boxManagerService.freezeBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/unfreezeBox")
	public void unfreezeBox(HttpServletRequest request, HttpServletResponse response) {
		String rawData = request.getParameter("Info");
		try {
			String resJSON = boxManagerService.unfreezeBox(rawData);
			
			PrintWriter writer = response.getWriter();
			writer.print(resJSON);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
