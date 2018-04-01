package aopDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy {

	private Calculator target; 
	private Class targetClass;

	public CalculatorProxy(Calculator target,Class targetClass) {
		this.target = target;
		this.targetClass=targetClass;
	}

	public Calculator getCalculator() {
		Calculator proxy = null;
		
		ClassLoader loader = this.target.getClass().getClassLoader();
		Class[] interfaces = new Class[] { this.targetClass };
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				
				System.out.println("this is logging...");
				System.out.println("method:" + methodName);
				System.out.println("args:"+Arrays.asList(args));
				
				
				Object result = method.invoke(target, args);
				
				return result;

			}
		};

		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
