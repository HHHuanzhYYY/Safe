package com.temp.log;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ControllerLogUtil {

	private static Logger log = LoggerFactory.getLogger(LogUtil.class);
	
	/**
	 * Controller层只记录异常信息.
	 * Controller层所有方法都记录异常信息.
	 */
	@AfterThrowing(throwing="t", pointcut="execution(* com.temp.controller.*.*(..))")
	public void controllerAfterThrowing(Throwable t) {
		log.error("Controller-", t);
	}
}
