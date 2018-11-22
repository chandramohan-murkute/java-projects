package com.mo.billsys.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Aspect
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired
	private Environment				env;
	
	@Around("execution( * com.mo.billsys..*(..))")
	public Object aroundLoggingAdvice(ProceedingJoinPoint jp) throws Throwable {
		StringBuilder sb = new StringBuilder();
		sb.append("Entering Method [").append(jp.toString()).append("]");
		if (jp.getArgs() != null && jp.getArgs().length > 0) {
			sb.append(" with arguments ").append(Arrays.asList(jp.getArgs()));
		}
		logger.debug(sb.toString());
		Object result = jp.proceed(jp.getArgs());
		sb.delete(0, sb.length());
		sb.append("Exiting method [").append(jp.getSignature()).append("]");
		if (result != null) {
			sb.append(" by returning object [").append(result.toString())
					.append("]");
		}
		logger.debug(sb.toString());
		return result;
	}
}
