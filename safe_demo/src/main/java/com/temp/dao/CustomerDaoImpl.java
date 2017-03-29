package com.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.temp.po.CustomerDataPo;
import com.temp.po.CustomerPo;
import com.temp.util.AccountType;
import com.temp.util.ImgUtil;
import com.temp.util.PwdType;
import com.temp.vo.CustomerDataVo;
import com.temp.vo.CustomerVo;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateCustomer(int accountId, PwdType pwdType, String pwd) {
		StringBuilder sb = new StringBuilder("SELECT COUNT(cardRfid) AS sum FROM card WHERE accountId = ? ");
		switch (pwdType) {
		case CHARPWD:
			sb.append("AND password = ? ");
			break;
		case FINGERPWD:
			sb.append("AND fingerPwd = ? ");
			break;
		case RESERVEFINGERPWD:
			sb.append("AND reserveFingerPwd = ? ");
			break;
		default:
			break;
		}
		String queryCustomerSQL = sb.toString();
		
		int count = jdbcTemplate.queryForObject(queryCustomerSQL, 
				new Object[] {accountId, pwd}, 
				new int[] {Types.BIGINT, Types.VARCHAR}, 
				Integer.class);
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean validateCustomerByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerVo getCustomerDetailsById(int custormerId) {
		final String sql = "";
		CustomerVo customerVo = jdbcTemplate.queryForObject(sql, new CustomerVoMapper(), custormerId);
		return customerVo;
	}
	
	class CustomerVoMapper implements RowMapper<CustomerVo> {

		@Override
		public CustomerVo mapRow(ResultSet arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}		
	}

	@Override
	public List<CustomerVo> getAllCustomersByAccountId(String accountId, AccountType accountType) {
		List<CustomerVo> customerVos = null;
		if (AccountType.SINGLE.equals(accountType)) {
			// Card ��Ϣ�󶨵� Box ����
			String queryCustomersSQL = "SELECT customer.customerName, "
									 		+ "customer.customerSex, "
									 		+ "customer.certificateType, "
									 		+ "customer.certificateNo, "
									 		+ "customer.mobile " 
									 + "FROM customer, account_customer_relationship "
									 + "WHERE customer.customerId = account_customer_relationship.customerId "
									   + "AND accountId = ?";
			customerVos = jdbcTemplate.query(queryCustomersSQL, 
					new Object[] {accountId}, 
					new int[] {Types.VARCHAR}, 
					new RowMapper<CustomerVo>() {

						@Override
						public CustomerVo mapRow(ResultSet rs, int arg1) throws SQLException {
							CustomerVo customerVo = new CustomerVo();
							
							customerVo.setCustomerName(rs.getString("customerName"));
							customerVo.setCustomerSex(rs.getInt("customerSex"));
							customerVo.setCertificateType(rs.getInt("certificateType"));
							customerVo.setCertificateNo(rs.getString("certificateNo"));
							customerVo.setMobile(rs.getString("mobile"));
							
							return customerVo;
						}
					}
			);
		} else if (AccountType.UION.equals(accountType)) {
			// Card ��Ϣ�󶨵� Customer ����
			String queryCustomersSQL = "SELECT customer.customerName, "
											+ "customer.customerSex, "
											+ "customer.certificateType, "
											+ "customer.certificateNo, "
											+ "customer.mobile, "
											+ "card.cardNo, "
											+ "card.cardRfid, "
											+ "card.cardType, "
											+ "card.cardStatus "
									 + "FROM customer, card "
									 + "WHERE customer.customerId = card.customerId AND card.accountId = ?";
			customerVos = jdbcTemplate.query(queryCustomersSQL, 
					new Object[] {accountId}, 
					new int[] {Types.VARCHAR}, 
					new RowMapper<CustomerVo>() {

						@Override
						public CustomerVo mapRow(ResultSet rs, int arg1) throws SQLException {
							CustomerVo customerVo = new CustomerVo();
							
							customerVo.setCustomerName(rs.getString("customerName"));
							customerVo.setCustomerSex(rs.getInt("customerSex"));
							customerVo.setCertificateType(rs.getInt("certificateType"));
							customerVo.setCertificateNo(rs.getString("certificateNo"));
							customerVo.setMobile(rs.getString("mobile"));
							customerVo.setCardNo(rs.getString("cardNo"));
							customerVo.setCardRfid(rs.getString("cardRfid"));
							customerVo.setCardType(rs.getInt("cardType"));
							customerVo.setCardStatus(rs.getInt("cardStatus"));
							
							return customerVo;
						}
					}
			);
		}
		return customerVos;
	}

	@Override
	public long setCustomer(CustomerPo newCustomer) {
		final String insertCustomerSQL = 
				"INSERT INTO customer" + 
						"(customerType, customerName, customerSex, " + 
						 "certificateType, certificateNo, homeAddress, unitAddress, " + 
						 "phone, mobile, post, photo, remark) " + 
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn.prepareStatement(insertCustomerSQL, Statement.RETURN_GENERATED_KEYS);
				int i = 1;
				pst.setInt(i++, newCustomer.getCustomerType());
				pst.setString(i++, newCustomer.getCustomerName());
				pst.setInt(i++, newCustomer.getCustomerSex());
				pst.setInt(i++, newCustomer.getCertificateType());
				pst.setString(i++, newCustomer.getCertificateNo());
				pst.setString(i++, newCustomer.getHomeAddress());
				pst.setString(i++, newCustomer.getUnitAddress());
				pst.setString(i++, newCustomer.getPhone());
				pst.setString(i++, newCustomer.getMobile());
				pst.setString(i++, newCustomer.getPost());
				//photo (BLOB)
				pst.setBlob(i++, ImgUtil.decodeFromBase64CodingImg(newCustomer.getPhoto()));
				pst.setString(i++, newCustomer.getRemark());
                return pst;
			}
		}, keyHolder);
		
		return (long) keyHolder.getKey();
	}
	
	@Override
	public boolean setAccountCustomerRelationship(String accountId, long customerId) {
		String insertAccountCustomerRelationshipSQL = 
				"INSERT INTO account_customer_relationship(accountId, customerId)"
			  + "VALUES(?, ?) ";
		int count = jdbcTemplate.update(insertAccountCustomerRelationshipSQL, 
				new Object[] {accountId, customerId}, 
				new int[] {Types.VARCHAR, Types.INTEGER});
		return count == 1 ? true : false;
	}

	@Override
	public boolean setCustomerCardRelationship(int customerId, String cardRfid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CustomerDataVo> getCustomerDataByCertificateNo(int certificateType, String certificateNo, long accountId) {
		List<CustomerDataVo> retCustomerDataVos = null;
		String queryCustomerDataSQL = null;
		if (certificateType == 0) {
			// Identification Card.
			queryCustomerDataSQL = 
					"SELECT customerId, customerName, customerSex, certificateType, "
					     + "certificateNo, unitAddress, homeAddress, phone, mobile, "
					     + "post, remark, openAccountDate "
				  + "FROM customer, account, account_customer_relationship "
				  + "WHERE customer.customerId = account_customer_relationship.customerId "
				    + "AND account_customer_relationship.accountId = account.accountId "
				    + "AND certificateType = 0 "
				    + "AND certificateNo = ? "
				    + "AND accountId = ? ";
		} else if (certificateType == 1) {
			// RFID
			queryCustomerDataSQL = 
					"SELECT customer.customerId, customerName, customerSex, certificateType, "
					     + "certificateNo, unitAddress, homeAddress, phone, mobile, "
					     + "post, remark, openAccountDate "
			      + "FROM card, customer, account, account_customer_relationship "
			      + "WHERE card.customerId = customer.customerId "
			        + "AND card.cardRfid = ? "
			        + "AND customer.customerId = account_customer_relationship.customerId "
			        + "AND account_customer_relationship.accountId = account.accountId "
			        + "AND account.accountId = ? ";
		}
		retCustomerDataVos = jdbcTemplate.query(queryCustomerDataSQL, 
				new Object[] {certificateNo, accountId}, 
				new int[] {Types.VARCHAR, Types.BIGINT}, 
				new RowMapper<CustomerDataVo>() {

					@Override
					public CustomerDataVo mapRow(ResultSet rs, int arg1) throws SQLException {
						CustomerDataVo customerDataVo = new CustomerDataVo();
						
						customerDataVo.setCustomerId(rs.getInt("customerId"));
						customerDataVo.setCustomerName(rs.getString("customerName"));
						customerDataVo.setCustomerSex(rs.getInt("customerSex"));
						customerDataVo.setCertificateType(rs.getInt("certificateType"));
						customerDataVo.setCertificateNo(rs.getString("certificateNo"));
						customerDataVo.setUnitAddress(rs.getString("unitAddress"));
						customerDataVo.setHomeAddress(rs.getString("homeAddress"));
						customerDataVo.setPhone(rs.getString("phone"));
						customerDataVo.setMobile(rs.getString("mobile"));
						customerDataVo.setPost(rs.getString("post"));
						customerDataVo.setRemark(rs.getString("remark"));
						customerDataVo.setOpenAccountDate(rs.getDate("openAccountDate"));
						
						return customerDataVo;
					}
			
				});
		return retCustomerDataVos;
	}
	
	@Override
	public boolean setCustomerData(CustomerDataPo customerDataPo) {
		String updateCustomerDataSQL = "UPDATE customer "
				                     + "SET unitAddress = ?, homeAddress = ?, phone = ?, mobile = ?, post = ?, remark = ? "
				                     + "WHERE customerId = ? ";
		int count = jdbcTemplate.update(updateCustomerDataSQL, 
				new Object[] {customerDataPo.getUnitAddress(), customerDataPo.getHomeAddress(), 
						      customerDataPo.getPhone(),       customerDataPo.getMobile(), 
						      customerDataPo.getPost(),        customerDataPo.getRemark(), 
						      customerDataPo.getCustomerId()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
						   Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER});
		
		return count == 1 ? true : false;
	}

	
}
