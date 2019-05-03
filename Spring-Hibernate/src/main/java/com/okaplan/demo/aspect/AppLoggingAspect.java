package com.okaplan.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

	//setup logger
	private Logger _logger=Logger.getLogger(getClass().getName());
	//setup pointcut declaration
	@Pointcut("execution(* com.okaplan.demo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.okaplan.demo.Dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.okaplan.demo.Service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forappFlow() {}
	
	//add @Before advice
	@Before("forappFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String _method=theJoinPoint.getSignature().toShortString();
		_logger.info("========>> in @Before: calling method: " + _method);
		//display the arguments to the method
		
		//get arguments
		Object[] args=theJoinPoint.getArgs();
		//loop and display
		for(Object _object : args) {
			_logger.info("======== >> argument: "+_object);
		}
	}
	
	//add @After advice
	
	@AfterReturning(
			pointcut="forappFlow()",
			returning="_object"
			)
	public void AfterReturning(JoinPoint theJoinpoint,Object _object) {
		//display method we are returning from
		String _method=theJoinpoint.getSignature().toShortString();
		_logger.info("========>> in @AfterReturning: from method: " + _method);
		//display data returned
		_logger.info("=======>> Displayed data "+ _object);
	}
}
