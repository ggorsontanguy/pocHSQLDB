package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.services.BusinessService;

@Component
public class AppWorker {

	@Autowired
	private BusinessService service;

	public void doWork() {
		System.out.println(String.format("%s started work", AppWorker.class));
		
		String value = service.getValue();
		
		System.out.println(String.format("Work value is [%s]", value));
	}

}
