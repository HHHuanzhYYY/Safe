package com.temp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.po.AccountPo;
import com.temp.util.CertificateType;
import com.temp.vo.AccountFullInfoVo;
import com.temp.vo.AccountVo;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AccountVo> getAccountListById(CertificateType type, String id) {
		final String queryAccountSQL = 
				"SELECT account.accountId, account.accountType, account.bankId, account.customerSum " + 
				"FROM customer, account_customer_relationship, account " + 
				"WHERE account.accountId = account_customer_relationship.accountId " + 
				  "AND account_customer_relationship.customerId = customer.customerId " + 
				  "AND customer.certificateType = ? " +
				  "AND customer.certificateNo = ? ";
		
		List<AccountVo> reAccountVos = jdbcTemplate.query(queryAccountSQL, 
				new Object[] {type.getValue(), id}, 
				new int[] {Types.INTEGER, Types.VARCHAR}, 
				new RowMapper<AccountVo>() {

					@Override
					public AccountVo mapRow(ResultSet rs, int arg1) throws SQLException {
						AccountVo accountVo = new AccountVo();
						
						accountVo.setAccountId(rs.getString("accountId"));
						accountVo.setAccountType(rs.getInt("accountType"));
						accountVo.setBankId(rs.getLong("bankId"));
						accountVo.setCustomerSum(rs.getInt("customerSum"));
						
						return accountVo;
					}
				});
		return reAccountVos;
	}

	@Override
	public List<AccountVo> getAccountListByRFID(String rfid) {
		final String queryAccountSQL = 
				"SELECT account.accountId, account.accountType, account.bankId, account.customerSum " +
				"FROM account, card " +
				"WHERE card.accountId = account.accountId AND card.cardRfid = ?";
		List<AccountVo> reAccountVos = jdbcTemplate.query(queryAccountSQL, 
				new Object[] {rfid}, 
				new int[] {Types.VARCHAR}, 
				new RowMapper<AccountVo>() {

					@Override
					public AccountVo mapRow(ResultSet rs, int arg1) throws SQLException {
						AccountVo accountVo = new AccountVo();
						
						accountVo.setAccountId(rs.getString("accountId"));
						accountVo.setAccountType(rs.getInt("accountType"));
						accountVo.setBankId(rs.getLong("bankId"));
						accountVo.setCustomerSum(rs.getInt("customerSum"));
						
						return accountVo;
					}
				});
		return reAccountVos;
	}

	@Override
	public boolean setAccount(AccountPo accountPo) {
		final String insertAccountSQL = "INSERT INTO account VALUES(?, ?, NOW(), NULL, ?, ?, ?, ?, ?, ?)";
		
		int count = jdbcTemplate.update(insertAccountSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				int i = 1;
				pst.setString(i++, accountPo.getAccountId());
				pst.setInt(i++, accountPo.getAccountType());
				pst.setInt(i++, accountPo.getIsAccountFree());
				pst.setFloat(i++, accountPo.getOpenAccountFee());
				pst.setInt(i++, accountPo.getPaymentType());
				pst.setFloat(i++, accountPo.getAmountSum());
				pst.setInt(i++, accountPo.getCustomerSum());
				pst.setLong(i++, accountPo.getBankId());
			}			
		});	
		return count == 1 ? true : false;
	}

	@Override
	public List<AccountFullInfoVo> getAccountsByCardRfid(String cardRfid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
