package app.services;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utils.HsqlDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class BusinessServiceTest {

	private static HsqlDatabase database;

	@Autowired
	private BusinessService service;

	@BeforeClass
	public static void onlyOnce() {
		database = new HsqlDatabase();
		database.setUp("test");
	}

	@Test
	public void foo() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID=1001, FirstName=John_Test, LastName=Doe_Test\n");
		sb.append("ID=1002, FirstName=James_Test, LastName=Brown_Test\n");
		sb.append("ID=1003, FirstName=Andrew_Test, LastName=Green_Test\n");

		String expectedValue = sb.toString();
		String actualValue = service.getValue();

		Assert.assertEquals("Service returns data that isn't deployed from \"test\" context", expectedValue,
				actualValue);
	}

}
