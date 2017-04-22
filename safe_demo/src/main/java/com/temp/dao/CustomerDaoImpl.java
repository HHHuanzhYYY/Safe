package com.temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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
import com.temp.vo.CustomerFullInfoVo;
import com.temp.vo.CustomerVo;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateCustomer(String accountId, PwdType pwdType, String pwd) {
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
		
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(queryCustomerSQL, 
					new Object[] {accountId, pwd}, 
					new int[] {Types.VARCHAR, Types.VARCHAR}, 
					Integer.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			count = 0;
		}				
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean validateCustomerByNameAndPwd(String name, String pwd) {
		final String queryCustomerSQL = "SELECT COUNT(customerId) SUM "
				+ "FROM customer WHERE customerName = ? AND customerPwd = ? ";
		int count = 0;
		try {		
			count = jdbcTemplate.queryForObject(queryCustomerSQL, 
				new Object[] {name, pwd}, 
				new int[] {Types.VARCHAR, Types.VARCHAR}, 
				Integer.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			count = 0;
		}		
		return count >= 1 ? true : false;
	}

	@Override
	public List<CustomerVo> getAllCustomersByAccountId(String accountId, AccountType accountType) {
		List<CustomerVo> customerVos = null;
		switch (accountType) {
		case SINGLE:			
		case ONECARDMULTIBOX:
		case MULTICARDMULTIBOX:	
		{
			// Card binding to Box.
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
			break;
		} 
		case UION:	
		{
			// Card binding to Customer.
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
			break;
		}
		default:
			break;
		}
		return customerVos;
	}

	@Override
	public long setCustomer(CustomerPo newCustomer) {
		final String insertCustomerSQL = 
				"INSERT INTO customer" + 
						"(customerType, customerName, customerSex, " + 
						 "certificateType, certificateNo, homeAddress, unitName, " + 
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
				pst.setString(i++, newCustomer.getUnitName());
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
		if (certificateType == 1) {
			// Identification Card.
			queryCustomerDataSQL = 
					"SELECT customer.customerId, customer.customerName, "
					     + "customer.customerSex, customer.certificateType, "
					     + "customer.certificateNo, customer.unitName, customer.homeAddress, "
					     + "customer.phone, customer.mobile, customer.post, customer.remark, "
					     + "account.openAccountDate "
				  + "FROM customer, account, account_customer_relationship "
				  + "WHERE customer.customerId = account_customer_relationship.customerId "
				    + "AND account_customer_relationship.accountId = account.accountId "
				    + "AND customer.certificateType = 1 "
				    + "AND customer.certificateNo = ? "
				    + "AND account_customer_relationship.accountId = ? ";
		} else if (certificateType == 2) {
			// RFID
			queryCustomerDataSQL = 
					"SELECT customer.customerId, customerName, customerSex, certificateType, "
					     + "certificateNo, unitName, homeAddress, phone, mobile, "
					     + "post, remark, openAccountDate "
			      + "FROM card, customer, account "
			      + "WHERE card.customerId = customer.customerId "
			        + "AND card.cardRfid = ? "
			        + "AND card.accountId = account.accountId "
			        + "AND card.accountId = ? ";
		}
		retCustomerDataVos = jdbcTemplate.query(queryCustomerDataSQL, 
				new Object[] {certificateNo, accountId}, 
				new int[] {Types.VARCHAR, Types.VARCHAR}, 
				new RowMapper<CustomerDataVo>() {

					@Override
					public CustomerDataVo mapRow(ResultSet rs, int arg1) throws SQLException {
						CustomerDataVo customerDataVo = new CustomerDataVo();
						
						customerDataVo.setCustomerId(rs.getInt("customerId"));
						customerDataVo.setCustomerName(rs.getString("customerName"));
						customerDataVo.setCustomerSex(rs.getInt("customerSex"));
						customerDataVo.setCertificateType(rs.getInt("certificateType"));
						customerDataVo.setCertificateNo(rs.getString("certificateNo"));
						customerDataVo.setUnitName(rs.getString("unitName"));
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
						   Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT});		
		return count == 1 ? true : false;
	}

	@Override
	public List<CustomerFullInfoVo> getCustomersByCardRfid(String cardRfid) {
		final String queryCustomerSQL = "SELECT * "
									  + "FROM customer, card "
									  + "WHERE card.customerId = customer.customerId AND card.cardRfid = ? ";
		List<CustomerFullInfoVo> customerFullInfoVos = jdbcTemplate.query(queryCustomerSQL, 
				new Object[] {cardRfid}, new int[] {Types.VARCHAR}, 
				new RowMapper<CustomerFullInfoVo>() {

					@Override
					public CustomerFullInfoVo mapRow(ResultSet rs, int arg1) throws SQLException {
						CustomerFullInfoVo customerFullInfoVo = new CustomerFullInfoVo();
						
						customerFullInfoVo.setCustomerId(rs.getLong("customerId"));
						customerFullInfoVo.setCertificateType(rs.getInt("customerType"));
						customerFullInfoVo.setCustomerName(rs.getString("customerName"));
						customerFullInfoVo.setCustomerPwd(rs.getString("customerPwd"));
						customerFullInfoVo.setCustomerSex(rs.getInt("customerSex"));
						customerFullInfoVo.setCertificateType(rs.getInt("certificateType"));
						customerFullInfoVo.setCertificateNo(rs.getString("certificateNo"));
						customerFullInfoVo.setHomeAddress(rs.getString("homeAddress"));
						customerFullInfoVo.setUnitAddress(rs.getString("unitAddress"));
						customerFullInfoVo.setPhone(rs.getString("phone"));
						customerFullInfoVo.setMobile(rs.getString("mobile"));
						customerFullInfoVo.setPost(rs.getString("post"));
						customerFullInfoVo.setPhoto(
								rs.getBlob("photo") == null ? null : ImgUtil.encodeToBase64CodingImg(rs.getBlob("photo")));
						customerFullInfoVo.setRemark(rs.getString("remark"));
						
						return customerFullInfoVo;
					}
				});
		return customerFullInfoVos;
	}

}
