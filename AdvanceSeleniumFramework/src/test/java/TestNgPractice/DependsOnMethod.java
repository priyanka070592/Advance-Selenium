package TestNgPractice;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void createContact()
	{

	System.out.println("contact created");

	}

	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
