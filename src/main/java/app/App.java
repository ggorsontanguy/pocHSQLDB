package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext context;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AppWorker worker = context.getBean(AppWorker.class);
		worker.doWork();
	}
}
