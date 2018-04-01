package aopDemo;

import org.springframework.stereotype.Component;

@Component("calculatorImpl")//以bean的id调用
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multi(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}

}
