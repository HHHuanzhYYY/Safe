package com.temp.util.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.temp.util.JsonUtil;

@Component
@Aspect
public class LogUtil {
	
//	/**
//	 * Controller层只记录异常信息.
//	 * Controller层所有方法都记录异常信息.
//	 */
//	@AfterThrowing("execution(* com.temp.controller.*.*(..)")
//	public void controllerAfterThrowing() {
//		
//	}
	
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
	
	@Around("getService(rawData)    || setService(rawData)   || "
		  + "deleteService(rawData) || loginService(rawData) || "
		  + "validateService(rawData)")  
    public String serviceAround(ProceedingJoinPoint joinPoint, String rawData) {  
		System.out.println("Before:" + rawData);
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
            e.printStackTrace();
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        return resJson;  
    }  

	@Around("execution(* com.temp.service.ReportLossServiceImpl.setReportLoss*(String, com.temp.util.ReportLossAction)) "
		  + "&& args(rawData, reportLossAction)")
	public String reportLossAround(ProceedingJoinPoint joinPoint, 
			String rawData, com.temp.util.ReportLossAction reportLossAction) {
		System.out.println("before:" + rawData + "ReportLossAction:" + reportLossAction.toString());
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
            e.printStackTrace();
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        return resJson;  
	}
	
	@Around("execution(* com.temp.service.BoxManageServiceImpl.modifyBoxStatus(String, com.temp.util.BoxStatus)) "
		  + "&& args(rawData, boxStatus)")
	public String modifyBoxStatusAround(ProceedingJoinPoint joinPoint, 
			String rawData, com.temp.util.BoxStatus boxStatus) {
		System.out.println("before:" + rawData + "BoxStatus:" + boxStatus.toString());
		
        String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
            e.printStackTrace();
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        return resJson;  
	}
	
	@Around("execution(* com.temp.service.*.list*())")
	public String listAround(ProceedingJoinPoint joinPoint) {		
		String resJson = null;  
        try {  
        	resJson = (String) joinPoint.proceed();  
        } catch (Throwable e) {  
            e.printStackTrace();
            
            resJson = JsonUtil.constructJson(false, null, null);
        }
        return resJson;  
	}
	
}
