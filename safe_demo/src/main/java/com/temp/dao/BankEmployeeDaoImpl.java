package com.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.temp.po.BankEmployeePo;
import com.temp.util.BankEmployeeStatus;
import com.temp.vo.BankEmployeeVo;

@Repository
public class BankEmployeeDaoImpl implements BankEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long validateBankEmployeeByNameAndPwd(String employeeName, String employeePwd) {
		String validateBankEmployeeSQL = "SELECT employeeId "
									   + "FROM bank_employee "
									   + "WHERE employeeName = ? AND `password` = ? AND employeeStatus = 0 ";
		long employeeId = 0;
		try {
			employeeId = jdbcTemplate.queryForObject(validateBankEmployeeSQL, 
					new Object[] {employeeName, employeePwd}, 
					new int[] {Types.VARCHAR, Types.VARCHAR}, 
					Long.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			employeeId = 0;
		}	
		return employeeId;
	}

	@Override
	public boolean validateBankEmployeeByIdAndPwd(long employeeId, String employeePwd) {
		String validateBankEmployeeSQL = "SELECT COUNT(employeeId) "
				+ "FROM bank_employee WHERE employeeId = ? AND `password` = ?  AND employeeStatus = 0 ";
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(validateBankEmployeeSQL, 
					new Object[] {employeeId, employeePwd}, 
					new int[] {Types.BIGINT, Types.VARCHAR}, 
					Integer.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			count = 0;
		}
		return count == 1 ? true : false;
	}

	@Override
	public List<BankEmployeeVo> getAllBankEmployees(long bankId) {
		String queryBankEmployeeSQL = "SELECT employeeId,      loginId,       employeeName, "
										   + "employeeStatus,  priority,      icCardNo, "
				                           + "certificateType, certificateNo, isAdministrator, "
				                           + "bank_branch.bankId, bank_branch.bankTitle "
				                    + "FROM bank_employee, bank_branch "
				                    + "WHERE bank_employee.bankId = bank_branch.bankId "
				                      + "AND bank_employee.bankId = ? ";
		List<BankEmployeeVo> bankEmployeeVos = jdbcTemplate.query(queryBankEmployeeSQL, 
				new Object[] {bankId}, new int[] {Types.BIGINT},
				new RowMapper<BankEmployeeVo>() {

					@Override
					public BankEmployeeVo mapRow(ResultSet rs, int arg1) throws SQLException {
						BankEmployeeVo bankEmployeeVo = new BankEmployeeVo();
						
						bankEmployeeVo.setEmployeeId(rs.getInt("employeeId"));
						bankEmployeeVo.setLoginId(rs.getString("loginId"));
						bankEmployeeVo.setEmployeeName(rs.getString("employeeName"));
						bankEmployeeVo.setEmployeeStatus(rs.getInt("employeeStatus"));
						bankEmployeeVo.setPriority(rs.getInt("priority"));
						bankEmployeeVo.setIcCardNo(rs.getString("icCardNo"));
						bankEmployeeVo.setCertificateType(rs.getInt("certificateType"));
						bankEmployeeVo.setCertificateId(rs.getString("certificateNo"));
						bankEmployeeVo.setIsAdministrator(rs.getInt("isAdministrator"));
						bankEmployeeVo.setBankId(rs.getInt("bankId"));
						bankEmployeeVo.setBankTitle(rs.getString("bankTitle"));
						
						return bankEmployeeVo;
					}		
		});
		return bankEmployeeVos;
	}

	@Override
	public long setBankEmployeeDetails(BankEmployeePo bankEmployeePo) {
		long employeeId = bankEmployeePo.getEmployeeId();
		if (bankEmployeePo.getEmployeeId() == 0) {
			// 新建银行雇员.
			final String insertBankEmployeeSQL = 
					"INSERT INTO bank_employee(loginId, employeeName, employeeStatus, priority, "
											+ "certificateType, certificateNo, mobile, bankId, "
											+ "icCardNo, isAdministrator, remark ) "
				  + "VALUES(?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?) ";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn.prepareStatement(insertBankEmployeeSQL, Statement.RETURN_GENERATED_KEYS);
					
					int parameterIndex = 1;
					pst.setString(parameterIndex++, bankEmployeePo.getLoginId());
					pst.setString(parameterIndex++, bankEmployeePo.getEmployeeName());
					pst.setInt(parameterIndex++, bankEmployeePo.getPriority());
					pst.setInt(parameterIndex++, bankEmployeePo.getCertificateType());
					pst.setString(parameterIndex++, bankEmployeePo.getCertificateNo());
					pst.setString(parameterIndex++, bankEmployeePo.getMobile());
					pst.setLong(parameterIndex++, bankEmployeePo.getBankId());
					pst.setString(parameterIndex++, bankEmployeePo.getIcCardNo());
					pst.setInt(parameterIndex++, bankEmployeePo.getIsAdministrator());
					pst.setString(parameterIndex++, bankEmployeePo.getRemark());
					
					return pst;
				}
			}, keyHolder);
			
			employeeId = (long) keyHolder.getKey();
		} else {
			// 修改现有银行雇员.
			String updateBankEmployeeSQL = "UPDATE bank_employee "
										 + "SET loginId = ?, employeeName = ?, priority = ?, "
										     + "certificateType = ?, certificateNo = ?, mobile = ?, "
										     + "bankId = ?, icCardNo = ?, isAdministrator = ?, "
										     + "remark = ? "
										 + "WHERE employeeId = ? ";
			jdbcTemplate.update(updateBankEmployeeSQL, 
					new Object[] {bankEmployeePo.getLoginId(), 
							      bankEmployeePo.getEmployeeName(), 
							      bankEmployeePo.getPriority(), 
							      bankEmployeePo.getCertificateType(), 
							      bankEmployeePo.getCertificateNo(), 
							      bankEmployeePo.getMobile(), 
								  bankEmployeePo.getBankId(), 
								  bankEmployeePo.getIcCardNo(), 
								  bankEmployeePo.getIsAdministrator(), 
								  bankEmployeePo.getRemark(), 
								  bankEmployeePo.getEmployeeId()}, 
					new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, 
							   Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, 
							   Types.INTEGER, Types.VARCHAR, Types.BIGINT});
		}
		return employeeId;
	}
	
	@Override
	public boolean setBankEmployeeStatus(long employeeId, BankEmployeeStatus employeeStatus) {
		String updateEmployeeStatus = "UPDATE bank_employee SET employeeStatus = ? WHERE employeeId = ? ";
		int count = jdbcTemplate.update(updateEmployeeStatus, 
				new Object[] {employeeStatus.getValue(), employeeId}, 
				new int[] {Types.INTEGER, Types.BIGINT}
		);
		return count == 1 ? true : false;
	}

	@Override
	public boolean deleteBankEmployee(List<Long> bankEmployeeIds) {
		String deleteBankEmployeeSQL = "DELETE FROM bank_employee WHERE employeeId = ? ";
		
		 List<Object[]> batchArgs = new ArrayList<>();
		 for (long bankEmployeeId : bankEmployeeIds) {
			Object[] batchArg = new Object[] {bankEmployeeId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteBankEmployeeSQL, batchArgs, new int[] {Types.BIGINT});
		
		return ret.length == 0 ? false : true;
	}


}
