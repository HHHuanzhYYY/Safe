package com.temp.log;

import java.lang.reflect.Method;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.temp.util.JsonUtil;

@Aspect
@Order(1)
public class LogUtil {
	
	private static Logger log = LoggerFactory.getLogger(LogUtil.class);
	
	/**
	 * Service层日志信息。
	 */
	@Pointcut("execution(* com.temp.service.*.set*(String)) && args(rawData)")
	public void setService(String rawData) {}
	
	@Pointcut("execution(* com.temp.service.*.get*(String)) && args(rawData)")
	public void getService(String rawData) {}
	
	@Pointcut("execution(* com.temp.service.*.delete*(String)) && args(rawData)")
	public void deleteService(String rawData) {}
	
	@Pointcut("execution(* com.temp.service.*.*Login(String)) && args(rawData)")
	public void loginService(String rawData) {}
	
	@Pointcut("execution(* com.temp.service.*.validate*(String)) && args(rawData)")
	public void validateService(String rawData) {}
	
	@Around("execution(* com.temp.service.BankEmployeeServiceImpl.validateBankEmployee(java.util.Map<String, Object>))"
			+ " && args(requestInfo)")
	public String[] validateBankEmployeeService(ProceedingJoinPoint joinPoint, java.util.Map<String, Object> requestInfo) {
		long UUID = requestInfo.hashCode();
		
		// Log the Request Info.
		log.info(getCurrentMethodFullName(joinPoint, "(String rawData)") 
				+ "[UUID=" + UUID + "]" + " name= " + requestInfo.get("name") + ", password=" + requestInfo.get("password"));
		
        String[] resJsons = null;  
        try {  
        	resJsons = (String[]) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "(Map<String, Object> requestInfo)") + "[UUID=" + UUID + "]", e);
            
        	if (resJsons == null) {
        		resJsons = new String[2];
	            resJsons[0] = JsonUtil.constructJson(false, null, null);
	            resJsons[1] = Long.toString(0L);
        	}
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "(String rawData)") 
				+ "[UUID=" + UUID + "]" + " employeeId=" + resJsons[1] + ", retData= " + resJsons[0]);
        
        return resJsons;  
	}
	
	@Around("getService(rawData)    || setService(rawData)   || "
		  + "deleteService(rawData) || loginService(rawData) || "
		  + "validateService(rawData)"
		  )  
    public String serviceAround(ProceedingJoinPoint joinPoint, String rawData) { 
		long UUID = constructUUID(rawData);
		
		// Log the Request Info.
		log.info(getCurrentMethodFullName(joinPoint, "(String rawData)") 
				+ "[UUID=" + UUID + "]" + " rawData= " + rawData);
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "(String rawData)") + "[UUID=" + UUID + "]", e);
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "(String rawData)") 
				+ "[UUID=" + UUID + "]" + " retData= " + resJson);
        
        return resJson;  
    }  
	
	@Around("execution(* com.temp.service.BankEmployeeServiceImpl.setBankEmployeeStatus(String, com.temp.util.BankEmployeeStatus)) "
			  + "&& args(rawData, employeeStatus)")
	public String setBankEmployeeStatusAround(ProceedingJoinPoint joinPoint, 
			String rawData, com.temp.util.BankEmployeeStatus employeeStatus) {
		final long uuid = constructUUID(rawData);
		
		// Log the Request Info.
		log.info(getCurrentMethodFullName(joinPoint, "(String rawData, BankEmployeeStatus employeeStatus)") 
						+ "[UUID=" + uuid + "]" + " rawData= " + rawData + " futureEmployeeStatus=" + employeeStatus.toString());
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "(String rawData, BankEmployeeStatus employeeStatus)") 
        			+ "[UUID=" + uuid + "]", e);
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "(String rawData, ReportLossAction reportLossAction)") 
				+ "[UUID=" + uuid + "]" + " retData= " + resJson);
        
        return resJson;  
	}

	@Around("execution(* com.temp.service.ReportLossServiceImpl.setReportLoss*(String, com.temp.util.ReportLossAction)) "
		  + "&& args(rawData, reportLossAction)")
	public String reportLossAround(ProceedingJoinPoint joinPoint, 
			String rawData, com.temp.util.ReportLossAction reportLossAction) {
		final long uuid = constructUUID(rawData);
		
		// Log the Request Info.
		log.info(getCurrentMethodFullName(joinPoint, "(String rawData, ReportLossAction reportLossAction)") 
						+ "[UUID=" + uuid + "]" + " rawData= " + rawData + " reportLossAction=" + reportLossAction.toString());
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "(String rawData, ReportLossAction reportLossAction)") 
        			+ "[UUID=" + uuid + "]", e);
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "(String rawData, ReportLossAction reportLossAction)") 
				+ "[UUID=" + uuid + "]" + " retData= " + resJson);
        
        return resJson;  
	}
	
	@Around("execution(* com.temp.service.BoxManageServiceImpl.modifyBoxStatus(String, com.temp.util.BoxStatus)) "
		  + "&& args(rawData, boxStatus)")
	public String modifyBoxStatusAround(ProceedingJoinPoint joinPoint, 
			String rawData, com.temp.util.BoxStatus boxStatus) {
		final long uuid = constructUUID(rawData);
		
		// Log the Request Info.
		log.info(getCurrentMethodFullName(joinPoint, "(String rawData, BoxStatus boxStatus)") 
						+ "[UUID=" + uuid + "]" + " rawData= " + rawData + " boxStatus=" + boxStatus.toString());
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "(String rawData, BoxStatus boxStatus)") 
        			+ "[UUID=" + uuid + "]", e);
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "(String rawData, BoxStatus boxStatus)") 
				+ "[UUID=" + uuid + "]" + " retData= " + resJson);
        
        return resJson;  
	}
	
	@Around("execution(* com.temp.service.*.list*())")
	public String listAround(ProceedingJoinPoint joinPoint) {	
		final long uuid = constructUUID(null);
		
		String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
        	// Log Error Info.
        	log.error(getCurrentMethodFullName(joinPoint, "()") + "[UUID=" + uuid + "]", e);
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        
        // Log the Result.
        log.info(getCurrentMethodFullName(joinPoint, "()") 
				+ "[UUID=" + uuid + "]" + " retData= " + resJson);
        
        return resJson;  
	}
	
	private static String getCurrentMethodFullName(ProceedingJoinPoint joinPoint, String paramInfo) {
		Signature sig = joinPoint.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = joinPoint.getTarget();
        Method currentMethod = null;
        try {
			currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		} catch (NoSuchMethodException | SecurityException e1 ) {
			e1.printStackTrace();
		}
		
        // Concat the Return String.
        String retStr = "";
        if (currentMethod != null) {
        	Class<?> clazz = currentMethod.getDeclaringClass();
        	retStr = clazz.getCanonicalName() + "." + currentMethod.getName() + paramInfo;
        }
        
        return retStr;
	}
	
	private static long constructUUID(String param) {
		long uuid = 0;
		if (param == null) {
			uuid = Calendar.getInstance().getTimeInMillis();
		} else {
			uuid = Math.abs(param.hashCode());
		}
		return uuid; 
	}
}
