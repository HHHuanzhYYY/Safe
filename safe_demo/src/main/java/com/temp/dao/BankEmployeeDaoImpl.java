package com.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	public List<BankEmployeeVo> getAllBankEmployees(int bankId) {
		String queryBankEmployeeSQL = "SELECT employeeId, loginId, employeeName, priority, icCardNo, "
				                           + "certificateType, certificateId, isAdministrator, "
				                           + "bank_branch.bankId, bank_branch.bankTitle "
				                    + "FROM bank_employee, bank_branch "
				                    + "WHERE bank_employee.bankId = bank_branch.bankId ";
		List<BankEmployeeVo> bankEmployeeVos = jdbcTemplate.query(queryBankEmployeeSQL, 
				new RowMapper<BankEmployeeVo>() {

					@Override
					public BankEmployeeVo mapRow(ResultSet rs, int arg1) throws SQLException {
						BankEmployeeVo bankEmployeeVo = new BankEmployeeVo();
						
						bankEmployeeVo.setEmployeeId(rs.getInt("employeeId"));
						bankEmployeeVo.setLoginId(rs.getString("loginId"));
						bankEmployeeVo.setEmployeeName(rs.getString("employeeName"));
						bankEmployeeVo.setPriority(rs.getInt("priority"));
						bankEmployeeVo.setIcCardNo(rs.getString("icCardNo"));
						bankEmployeeVo.setCertificateType(rs.getInt("certificateType"));
						bankEmployeeVo.setCertificateId(rs.getString("certificateId"));
						bankEmployeeVo.setIsAdministrator(rs.getInt("isAdministrator"));
						bankEmployeeVo.setBankId(rs.getInt("bankId"));
						bankEmployeeVo.setBankTitle(rs.getString("bankTitle"));
						
						return bankEmployeeVo;
					}		
		});
		return bankEmployeeVos;
	}

	@Override
	public int setBankEmployeeDetails(BankEmployeePo bankEmployeePo) {
		int employeeId = 0;
		if (bankEmployeePo.getEmployeeId() == 0) {
			// 新增职员
			final String insertBankEmployeeSQL = 
					"INSERT INTO bank_employee(loginId, employeeName, priority, "
											+ "certificateType, certificateId, mobile, bankId, "
											+ "icCardNo, isAdministrator, remark ) "
				  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn.prepareStatement(insertBankEmployeeSQL);
					
					int parameterIndex = 1;
					pst.setString(parameterIndex++, bankEmployeePo.getLoginId());
					pst.setString(parameterIndex++, bankEmployeePo.getEmployeeName());
					pst.setInt(parameterIndex++, bankEmployeePo.getPriority());
					pst.setInt(parameterIndex++, bankEmployeePo.getCertificateType());
					pst.setString(parameterIndex++, bankEmployeePo.getCertificateId());
					pst.setString(parameterIndex++, bankEmployeePo.getMobile());
					pst.setInt(parameterIndex++, bankEmployeePo.getBankId());
					pst.setString(parameterIndex++, bankEmployeePo.getIcCardNo());
					pst.setInt(parameterIndex++, bankEmployeePo.getIsAdministrator());
					pst.setString(parameterIndex++, bankEmployeePo.getRemark());
					
					return pst;
				}
			}, keyHolder);
			
			employeeId = (int) keyHolder.getKey();
		} else {
			// 更新职员信息
			employeeId = bankEmployeePo.getEmployeeId();
			
			String updateBankEmployeeSQL = "UPDATE bank_employee "
										 + "SET loginId = ?, employeeName = ?, priority = ?, "
										     + "certificateType = ?, certificateId = ?, mobile = ?, "
										     + "bankId = ?, icCardNo = ?, isAdministrator = ?, "
										     + "remark = ? "
										 + "WHERE employeeId = ? ";
			jdbcTemplate.update(updateBankEmployeeSQL, 
					new Object[] {bankEmployeePo.getLoginId(), 
							      bankEmployeePo.getEmployeeName(), 
							      bankEmployeePo.getPriority(), 
							      bankEmployeePo.getCertificateType(), 
							      bankEmployeePo.getCertificateId(), 
							      bankEmployeePo.getMobile(), 
								  bankEmployeePo.getBankId(), 
								  bankEmployeePo.getIcCardNo(), 
								  bankEmployeePo.getIsAdministrator(), 
								  bankEmployeePo.getRemark(), 
								  bankEmployeePo.getEmployeeId()}, 
					new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, 
							   Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, 
							   Types.INTEGER, Types.VARCHAR, Types.INTEGER});
		}
		return employeeId;
	}

	@Override
	public boolean deleteBankEmployee(List<Integer> bankEmployeeIds) {
		String deleteBankEmployeeSQL = "DELETE FROM bank_employee WHERE employeeId = ? ";
		
		 List<Object[]> batchArgs = new ArrayList<>();
		 for (int bankEmployeeId : bankEmployeeIds) {
			Object[] batchArg = new Object[] {bankEmployeeId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteBankEmployeeSQL, batchArgs, new int[] {Types.INTEGER});
		
		return ret.length == 0 ? false : true;
	}

}
