package com.temp.dao;

import java.util.List;

import com.temp.po.BankBranchPo;
import com.temp.po.FeeTypePo;
import com.temp.po.MessagePo;
import com.temp.po.SubjectPo;
import com.temp.vo.BankBranchVo;
import com.temp.vo.BankEmployeeResumeVo;
import com.temp.vo.FeeTypeVo;
import com.temp.vo.MessageVo;
import com.temp.vo.SubjectVo;

public interface SystemConfigDao {

	/**
	 * getAllMessages.
	 * 
	 * @return List<MessageVo>
	 */
	List<MessageVo> getAllMessages();
	
	/**
	 * getBankBranchEmployees.
	 * 
	 * @param bankId
	 * @return List<BankEmployeeResumeVo>
	 */
	List<BankEmployeeResumeVo> getBankBranchEmployees(int bankId);
	
	/**
	 * setMessageDetails.
	 * 
	 * @param messagePo
	 * @return messageId
	 */
	long setMessageDetails(MessagePo messagePo);
	
	/**
	 * deleteMessage.
	 * 
	 * @param messageIds
	 * @return boolean
	 */
	boolean deleteMessage(List<Long> messageIds);
	
	/**
	 * getAllBankBranches.
	 * 
	 * @return List<BankBranchVo>
	 */
	List<BankBranchVo> getAllBankBranches();
	
	/**
	 * setBankDetails.
	 * 
	 * @param bankBranchPo
	 * @return bankId
	 */
	long setBankDetails(BankBranchPo bankBranchPo);
	
	/**
	 * deleteBank.
	 * 
	 * @param bankIds
	 * @return boolean
	 */
	boolean deleteBank(List<Long> bankIds);
	
	/**
	 * getAllSubjects.
	 * 
	 * @return List<SubjectVo>
	 */
	List<SubjectVo> getAllSubjects();
	
	/**
	 * setSubjectDetails.
	 * 
	 * @param subjectPo
	 * @return subjectId
	 */
	long setSubjectDetails(SubjectPo subjectPo);
	
	/**
	 * deleteSubject.
	 * 
	 * @param subjectIds
	 * @return boolean
	 */
	boolean deleteSubject(List<Long> subjectIds);
	
	/**
	 * getAllFeeTypes.
	 * 
	 * @return List<FeeTypeVo>
	 */
	List<FeeTypeVo> getAllFeeTypes();
	
	/**
	 * setFeeTypeDetails.
	 * 
	 * @param feeTypePo
	 * @return boolean
	 */
	boolean setFeeTypeDetails(FeeTypePo feeTypePo);
	
	/**
	 * setFeeTypeStatus.
	 * 
	 * @param feeTypeId
	 * @param status
	 * @return boolean
	 */
	boolean setFeeTypeStatus(final long feeTypeId, final int status);
	
	/**
	 * deleteFeeType.
	 * 
	 * @param feeTypeIds
	 * @return boolean
	 */
	boolean deleteFeeType(List<Long> feeTypeIds);
}
