package aopDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy {

	private Calculator target;
	private Class targetClass;

	public CalculatorProxy(Calculator target, Class targetClass) {
		this.target = target;
		this.targetClass = targetClass;
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
				System.out.println("args:" + Arrays.asList(args));

				// 前置通知
				Object result = null;
				try {
					result = method.invoke(target, args);
					// 返回通知
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// 异常通知
				}
				// 后置通知
				return result;

			}
		};

		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
