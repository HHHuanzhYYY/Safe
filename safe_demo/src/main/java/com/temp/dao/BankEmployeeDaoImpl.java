package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.BankEmployeePo;
import com.temp.vo.BankEmployeeVo;

@Repository
public class BankEmployeeDaoImpl implements BankEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateBankEmployeeByNameAndPwd(String employeeName, String employeePwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateBankEmployeeByIdAndPwd(int employeeId, String employeePwd) {
		String validateBankEmployeeSQL = "SELECT COUNT(employeeId) "
				+ "FROM bank_employee WHERE employeeId = ? AND password = ? ";
		int count = jdbcTemplate.queryForObject(validateBankEmployeeSQL, Integer.class, employeeId, employeePwd);
		return count == 1 ? true : false;
	}

	@Override
	public List<BankEmployeeVo> getAllBankEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBankEmployeeDetails(BankEmployeePo bankEmployeePo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBankEmployee(List<Integer> bankEmployeeIds) {
		// TODO Auto-generated method stub
		return false;
	}

}
