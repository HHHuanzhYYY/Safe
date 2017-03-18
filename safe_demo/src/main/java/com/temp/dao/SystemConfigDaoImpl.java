package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.BankBranchPo;
import com.temp.po.FeeTypePo;
import com.temp.po.MessagePo;
import com.temp.po.SubjectPo;
import com.temp.vo.BankBranchVo;
import com.temp.vo.FeeTypeVo;
import com.temp.vo.MessageVo;
import com.temp.vo.SubjectVo;

@Repository
public class SystemConfigDaoImpl implements SystemConfigDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MessageVo> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setMessageDetails(MessagePo messagePo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(List<Integer> messageIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BankBranchVo> getAllBankBranches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBankDetails(BankBranchPo bankBranchPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBank(List<Integer> bankIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SubjectVo> getAllSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setSubjectDetails(SubjectPo subjectPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSubject(List<Integer> subjectIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FeeTypeVo> getAllFeeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setFeeTypeDetails(FeeTypePo feeTypePo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setFeeTypeStatus(int feeTypeId, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFeeType(List<Integer> feeTypeIds) {
		// TODO Auto-generated method stub
		return false;
	}

}
