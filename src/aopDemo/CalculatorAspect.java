package aopDemo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAspect {

	//前置通知
	@Before("execution(* aopDemo.Calculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("开始调用" + methodName + ",args:" + Arrays.asList(joinPoint.getArgs()));
	}
	
	//后置通知 （无论是否发生异常，都会执行)
	@After("execution(* aopDemo.Calculator.*(..))")
	public void afterMethod(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("结束调用" + methodName + ",args:" + Arrays.asList(joinPoint.getArgs()));
	}

}
