package com.temp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.po.AccountAddBoxPo;
import com.temp.po.AccountAddCustomerPo;
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
		String setAccountSQL = "INSERT INTO account(accountId, accountType, openAccountDate, "
												 + "cancelAccountDate, isAccountFree, openAccountFee, "
												 + "paymentType, amountSum, customerSum, bankId) "
							 + "VALUES(?, ?, NOW(), NULL, ?, ?, ?, ?, ?, ?) "
							 + "ON DUPLICATE KEY UPDATE accountType = ?, "
							 						 + "amountSum = amountSum + ?, "
							 						 + "customerSum = customerSum + ? ";
		
		int count = jdbcTemplate.update(setAccountSQL, new PreparedStatementSetter() {

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
				
				pst.setInt(i++, accountPo.getAccountType());
				pst.setFloat(i++, accountPo.getAmountSum());
				pst.setInt(i++, accountPo.getCustomerSum());
			}			
		});	
		return count >= 1 ? true : false;
	}

	@Override
	public List<AccountFullInfoVo> getAccountsByCardRfid(String cardRfid) {
		String queryAccountSQL = "SELECT account.accountId, accountType, openAccountDate, cancelAccountDate, "
									  + "isAccountFree, openAccountFee, paymentType, amountSum, customerSum, bankId "
							   + "FROM account, card "
							   + "WHERE account.accountId = card.accountId AND card.cardRfid = ? ";
		List<AccountFullInfoVo> accountFullInfoVos = jdbcTemplate.query(queryAccountSQL, 
				new Object[] {cardRfid}, new int[] {Types.VARCHAR}, 
				new RowMapper<AccountFullInfoVo>() {

					@Override
					public AccountFullInfoVo mapRow(ResultSet rs, int arg1) throws SQLException {
						AccountFullInfoVo accountFullInfoVo = new AccountFullInfoVo();
						
						accountFullInfoVo.setAccountId(rs.getString("accountId"));
						accountFullInfoVo.setAccountType(rs.getInt("accountType"));
						accountFullInfoVo.setOpenAccountDate(
								rs.getDate("openAccountDate") == null ? null : new Date(rs.getDate("openAccountDate").getTime()));
						accountFullInfoVo.setCancelAccountDate(
								rs.getDate("cancelAccountDate") == null ? null : new Date(rs.getDate("cancelAccountDate").getTime()));
						accountFullInfoVo.setIsAccountFree(rs.getInt("isAccountFree"));
						accountFullInfoVo.setOpenAccountFee(rs.getBigDecimal("openAccountFee").floatValue());
						accountFullInfoVo.setPaymentType(rs.getInt("paymentType"));
						accountFullInfoVo.setAmountSum(rs.getBigDecimal("amountSum").floatValue());
						accountFullInfoVo.setCustomerSum(rs.getInt("customerSum"));
						accountFullInfoVo.setBankId(rs.getLong("bankId"));
						
						return accountFullInfoVo;
					}
				});
		return accountFullInfoVos;
	}

	@Override
	public boolean setAccountNewBox(AccountAddBoxPo accountAddBoxPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAccountNewCustomer(AccountAddCustomerPo accountAddCustomerPo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
