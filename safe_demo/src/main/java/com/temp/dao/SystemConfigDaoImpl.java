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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.temp.po.BankBranchPo;
import com.temp.po.FeeTypePo;
import com.temp.po.MessagePo;
import com.temp.po.SubjectPo;
import com.temp.vo.BankBranchVo;
import com.temp.vo.BankEmployeeResumeVo;
import com.temp.vo.FeeTypeVo;
import com.temp.vo.MessageVo;
import com.temp.vo.SubjectVo;

@Repository
public class SystemConfigDaoImpl implements SystemConfigDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MessageVo> getAllMessages() {
		String queryMessagesSQL = "SELECT messageId, messageType, messageTitle FROM system_message ";
		List<MessageVo> messageVos = jdbcTemplate.query(queryMessagesSQL, new RowMapper<MessageVo>() {

			@Override
			public MessageVo mapRow(ResultSet rs, int arg1) throws SQLException {
				MessageVo messageVo = new MessageVo();
				
				messageVo.setMessageId(rs.getInt("messageId"));
				messageVo.setMessageType(rs.getInt("messageType"));
				messageVo.setMessageTitle(rs.getString("messageTitle"));
				
				return messageVo;
			}
			
		});
		return messageVos;
	}	

	@Override
	public List<BankEmployeeResumeVo> getBankBranchEmployees(int bankId) {
		final String queryEmployeeResumeSQL = "SELECT employeeId, employeeName FROM bank_employee WHERE bankId = ? ";
		List<BankEmployeeResumeVo> bankEmployeeResumeVos = jdbcTemplate.query(queryEmployeeResumeSQL, 
				new Object[]{bankId}, 
				new RowMapper<BankEmployeeResumeVo>() {

					@Override
					public BankEmployeeResumeVo mapRow(ResultSet rs, int arg1) throws SQLException {
						BankEmployeeResumeVo bankEmployeeResumeVo = new BankEmployeeResumeVo();
						
						bankEmployeeResumeVo.setEmployeeId(rs.getInt("employeeId"));
						bankEmployeeResumeVo.setEmployeeName(rs.getString("employeeName"));
						
						return bankEmployeeResumeVo;
					}
			
		});
		return bankEmployeeResumeVos;
	}

	@Override
	public long setMessageDetails(MessagePo messagePo) {
		long messageId = messagePo.getMessageId();
		if (messagePo.getMessageId() == 0) {
			final String updateMessageSQL = "INSERT INTO system_message("
					+ "createDateTime, messageType, messageTitle, messageContent, remark) "
				+ "VALUES(sysdate(), ?, ?, ?, ?) ";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn.prepareStatement(updateMessageSQL, Statement.RETURN_GENERATED_KEYS);
					
					int parameterIndex = 1;
					pst.setInt(parameterIndex++, messagePo.getMessageType());
					pst.setString(parameterIndex++, messagePo.getMessageTitle());
					pst.setString(parameterIndex++, messagePo.getMessageContent());
					pst.setString(parameterIndex++, messagePo.getRemark());
					
					return pst;
				}
			}, keyHolder);
			messageId = (long) keyHolder.getKey();
		} else {
			String updateMessageSQL = "UPDATE system_message "
					                + "SET updateDateTime = sysdate(), messageType = ?, messageTitle = ?, "
					                    + "messageContent = ?, remark = ? "
					                + "WHERE messageId = ? ";
			jdbcTemplate.update(updateMessageSQL, 
					new Object[] {messagePo.getMessageType(), 
								  messagePo.getMessageTitle(), 
								  messagePo.getMessageContent(),
								  messagePo.getRemark(), 
								  messagePo.getMessageId()}, 
					new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER});
			
			// 删除旧信息.
			String deleteMessageAndRecevierSQL = "DELETE FROM message_receiver WHERE messageId = ? ";
			jdbcTemplate.update(deleteMessageAndRecevierSQL, messagePo.getMessageId());
		}
		
		// 插入数据到表 message_receiver
		if (messagePo.getMessageReceiverType() == 1) {
			final String insertMessageReceiverSQL = "INSERT INTO message_receiver(messageId, messagereceiverType) "
					+ "VALUES(?, 1) ";
			jdbcTemplate.update(insertMessageReceiverSQL, 
					new Object[]{messageId}, new int[]{Types.BIGINT});
		} else {
			final String insertMessageReceiverSQL = 
					"INSERT INTO message_receiver(messagereceiverType, messageId, bankEmployeeId) "
					+ "VALUES(0, ?, ?) ";
			List<Object[]> batchArgs = new ArrayList<>();
			for (Integer receiverId : messagePo.getMessageReceivers()) {
				Object[] batchArg = new Object[] {messageId, receiverId};
				batchArgs.add(batchArg);
			}
			jdbcTemplate.batchUpdate(insertMessageReceiverSQL, batchArgs, new int[]{Types.BIGINT, Types.INTEGER});
		}
					
		return messageId;
	}

	@Override
	public boolean deleteMessage(List<Long> messageIds) {
		String deleteMessageSQL = "DELETE FROM system_message WHERE messageId = ? ";
		List<Object[]> batchArgs = new ArrayList<>();
		for (Long messageId : messageIds) {
			Object[] batchArg = new Object[] {messageId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteMessageSQL, batchArgs, new int[] {Types.BIGINT});
		
		return ret.length == 0 ? false : true;
	}

	@Override
	public List<BankBranchVo> getAllBankBranches() {
		String queryBankBranchSQL = "SELECT bankId, bankTitle FROM bank_branch ";
		List<BankBranchVo> bankBranchVos = jdbcTemplate.query(queryBankBranchSQL, 
				new RowMapper<BankBranchVo>() {

			@Override
			public BankBranchVo mapRow(ResultSet rs, int arg1) throws SQLException {
				BankBranchVo bankBranchVo = new BankBranchVo();
				
				bankBranchVo.setBankId(rs.getInt("bankId"));
				bankBranchVo.setBankTitle(rs.getString("bankTitle"));
				
				return bankBranchVo;
			}
		});
		return bankBranchVos;
	}

	@Override
	public long setBankDetails(BankBranchPo bankBranchPo) {
		long bankId = bankBranchPo.getBankId();
		if (bankBranchPo.getBankId() == 0) {
			// 新增网点
			String insertBankSQL = "INSERT INTO bank_branch(bankTitle, remark) VALUES(?, ?) ";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn.prepareStatement(insertBankSQL, Statement.RETURN_GENERATED_KEYS);
					
					int parameterIndex = 1;
					pst.setString(parameterIndex++, bankBranchPo.getBankTitle());
					pst.setString(parameterIndex++, bankBranchPo.getRemark());
					
					return pst;
				}
			}, keyHolder);
			
			bankId = (long) keyHolder.getKey();
		} else {
			// 修改网点信息
			String updateBankSQL = "UPDATE bank_branch SET bankTitle = ?, remark = ? WHERE bankId = ? ";
			
			jdbcTemplate.update(updateBankSQL, 
					new Object[] {bankBranchPo.getBankTitle(), bankBranchPo.getRemark(), bankBranchPo.getBankId()}, 
					new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER});
		}
		return bankId;
	}

	@Override
	public boolean deleteBank(List<Long> bankIds) {
		String deleteBankSQL = "DELETE FROM bank_branch WHERE bankId = ? ";
		List<Object[]> batchArgs = new ArrayList<>();
		for (Long bankId : bankIds) {
			Object[] batchArg = new Object[] {bankId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteBankSQL, batchArgs, new int[] {Types.BIGINT});
		
		return ret.length == 0 ? false : true;
	}

	@Override
	public List<SubjectVo> getAllSubjects() {
		String querySubjectSQL = "SELECT subjectId, subjectCode, subjectTitle, direction, remark FROM subject ";
		List<SubjectVo> retSubjectVos = jdbcTemplate.query(querySubjectSQL, 
				new RowMapper<SubjectVo>() {

			@Override
			public SubjectVo mapRow(ResultSet rs, int arg1) throws SQLException {
				SubjectVo subjectVo = new SubjectVo();
				
				subjectVo.setSubjectId(rs.getInt("subjectId"));
				subjectVo.setSubjectCode(rs.getString("subjectCode"));
				subjectVo.setSubjectTitle(rs.getString("subjectTitle"));
				subjectVo.setDirection(rs.getInt("direction"));
				subjectVo.setRemark(rs.getString("remark"));
				
				return subjectVo;
			}			
		});
		return retSubjectVos;
	}

	@Override
	public int setSubjectDetails(SubjectPo subjectPo) {
		int subjectId = 0;
		if (subjectPo.getSubjectId() == 0) {
			// 插入新的科目.
			final String insertSubjectSQL = "INSERT INTO subject(subjectCode, subjectTitle, direction, remark) "
										  + "VALUES(?, ?, ?, ?) ";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn.prepareStatement(insertSubjectSQL);
					
					int parameterIndex = 1;
					pst.setString(parameterIndex++, subjectPo.getSubjectCode());
					pst.setString(parameterIndex++, subjectPo.getSubjectTitle());
					pst.setInt(parameterIndex++, subjectPo.getDirection());
					pst.setString(parameterIndex++, subjectPo.getRemark());
					
					return pst;
				}
				
			}, keyHolder);
			subjectId = (int) keyHolder.getKey();
		} else {
			// 更新旧的科目.
			subjectId = subjectPo.getSubjectId();
			
			String updateSubjectSQL = "UPDATE subject "
									+ "SET subjectCode = ?, subjectTitle = ?, direction = ?, remark = ? "
									+ "WHERE subjectId = ? ";
			jdbcTemplate.update(updateSubjectSQL, 
					new Object[] {subjectPo.getSubjectCode(), 
								  subjectPo.getSubjectTitle(), 
								  subjectPo.getDirection(), 
								  subjectPo.getRemark(),
								  subjectId}, 
					new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER});
		}
		return subjectId;
	}

	@Override
	public boolean deleteSubject(List<Integer> subjectIds) {
		String deleteSubjectSQL = "DELETE FROM subject WHERE subjectId = ? ";
		List<Object[]> batchArgs = new ArrayList<>();
		for (Integer subjectId : subjectIds) {
			Object[] batchArg = new Object[] {subjectId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteSubjectSQL, batchArgs, new int[] {Types.INTEGER});
		
		return ret.length == 0 ? false : true;
	}

	@Override
	public List<FeeTypeVo> getAllFeeTypes() {
		String queryFeeTypeSQL = "SELECT feeTypeId, feeTypeTitle, remark, feeValue, status, "
									  + "subject.subjectId, subject.subjectTitle "
							   + "FROM fee_type, subject "
							   + "WHERE fee_type.subjectId = subject.subjectId";
		List<FeeTypeVo> feeTypeVos = jdbcTemplate.query(queryFeeTypeSQL, 
				new RowMapper<FeeTypeVo>() {

					@Override
					public FeeTypeVo mapRow(ResultSet rs, int arg1) throws SQLException {
						FeeTypeVo feeTypeVo = new FeeTypeVo();
						
						feeTypeVo.setFeeTypeId(rs.getInt("feeTypeId"));
						feeTypeVo.setFeeTypeTitle(rs.getString("feeTypeTitle"));
						feeTypeVo.setRemark(rs.getString("remark"));
						feeTypeVo.setFeeValue(rs.getFloat("feeValue"));
						feeTypeVo.setStatus(rs.getInt("status"));
						feeTypeVo.setSubjectId(rs.getInt("subjectId"));
						feeTypeVo.setSubjectTitle(rs.getString("subjectTitle"));
						
						return feeTypeVo;
					}			
		});
		return feeTypeVos;
	}

	@Override
	public boolean setFeeTypeDetails(FeeTypePo feeTypePo) {
		String insertFeeTypeSQL = 
				"INSERT INTO fee_type(feeTypeId, feeTypeTitle, subjectId, feeValue, status, remark) "
			  + "VALUES(?, ?, ?, ?, ?, ?) ";
		int count = jdbcTemplate.update(insertFeeTypeSQL, 
				new Object[] {feeTypePo.getFeeTypeId(), 
						      feeTypePo.getFeeTypeTitle(), 
						      feeTypePo.getSubjectId(), 
						      feeTypePo.getFeeValue(), 
						      feeTypePo.getStatus(), 
						      feeTypePo.getRemark()}, 
				new int[] {Types.INTEGER, Types.VARCHAR, Types.INTEGER, 
						   Types.FLOAT, Types.INTEGER, Types.VARCHAR});
		return count == 1 ? true : false;
	}

	@Override
	public boolean setFeeTypeStatus(int feeTypeId, int status) {
		String updateStatusSQL = "UPDATE fee_type SET status = ? WHERE feeTypeId = ? ";
		int count = jdbcTemplate.update(updateStatusSQL, 
				new Object[] {status, feeTypeId}, 
				new int[] {Types.INTEGER, Types.INTEGER});
		return count == 1 ? true : false;
	}

	@Override
	public boolean deleteFeeType(List<Integer> feeTypeIds) {
		String deleteFeeTypeSQL = "DELETE FROM fee_type WHERE feeTypeId = ? ";
		List<Object[]> batchArgs = new ArrayList<>();
		for (Integer feeTypeId : feeTypeIds) {
			Object[] batchArg = new Object[] {feeTypeId};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteFeeTypeSQL, batchArgs, new int[] {Types.INTEGER});
		
		return ret.length == 0 ? false : true;
	}

}
