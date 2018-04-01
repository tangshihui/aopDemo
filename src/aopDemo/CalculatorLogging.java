package aopDemo;

public class CalculatorLogging implements Calculator {

	@Override
	public int add(int a, int b) {
		System.out.println("before add ...");
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("before sub ...");
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		System.out.println("before multi ...");
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("before div ...");
		return a/b;
	}

}
