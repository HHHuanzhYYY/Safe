package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
						   "FROM account, account_customer_relation, card " +
						   "WHERE card.CustomerId = account_customer_relation.CustomerId " +
						     "AND account_customer_relation.AccountId = account.AccountId " +
						     "AND card.CardRfid=?";
		List<AccountVo> res = jdbcTemplate.queryForList(sql, AccountVo.class, rfid);
		return res;
	}

	@Override
	public boolean setAccount(AccountPo accountPo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
