package com.temp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.temp.po.AccountPo;
import com.temp.vo.AccountVo;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AccountVo> getAccountListById(int type, String id) {
		final String sql = "SELECT account.AccountId, account.AccountType, account.BankId, account.CustomerSum " + 
						   "FROM customer, account_customer_relation, account " + 
						   "WHERE account.AccountId = account_customer_relation.AccountId " + 
						     "AND account_customer_relation.CustomerId = customer.CustomerId " + 
						     "AND customer.CertificateType=? " +
						     "AND customer.CertificateNum=?";
		
		List<AccountVo> res = jdbcTemplate.queryForList(sql, AccountVo.class, type, id);
		return res;
	}

	@Override
	public List<AccountVo> getAccountListByRFID(String rfid) {
		final String sql = "SELECT account.AccountId, account.AccountType, account.BankId, account.CustomerSum " +
						   "FROM account, card " +
						   "WHERE card.AccountId = account.AccountId AND card.CardRfid=?";
		List<AccountVo> res = jdbcTemplate.queryForList(sql, AccountVo.class, rfid);
		return res;
	}

	@Override
	public boolean setAccount(AccountPo accountPo) {
		final String insertAccountSQL = "INSERT INTO account VALUES(?, ?, ?, NOW(), NULL, ?, ?, ?, ?, ?)";
		
		long accountId = generateAccountId();
		accountPo.setAccountId(accountId);
		
		int count = jdbcTemplate.update(insertAccountSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				int i = 1;
				pst.setLong(i++, accountId);
				pst.setInt(i++, accountPo.getAccountType());
				pst.setString(i++, accountPo.getBankId());
				pst.setInt(i++, accountPo.getIsAccountFree());
				pst.setFloat(i++, accountPo.getOpenAccountFee());
				pst.setInt(i++, accountPo.getPaymentType());
				pst.setFloat(i++, accountPo.getAmountSum());
				pst.setInt(i++, accountPo.getCustomerSum());
			}			
		});
		
		return count == 1 ? true : false;
	}
	
}
