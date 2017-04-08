package com.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.RentDao;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private RentDao rentDao;
	
	
}
