package aopDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		 * Calculator cal= new CalculatorImpl(); int result;// = cal.add(2, 3);
		 * System.out.println(result);
		 * 
		 * cal = new CalculatorLogging();
		 * 
		 * result = cal.add(2, 3);
		 * 
		 * System.out.println(result);
		 * 
		 * Calculator cal1 = new CalculatorProxy(cal,Calculator.class).getCalculator();
		 * 
		 * result = cal1.add(2, 3);
		 * 
		 * System.out.println(result);
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Calculator cal = (Calculator)context.getBean("calculatorImpl");

		int result = cal.add(2, 66);
		System.out.println(result);
	}

}
