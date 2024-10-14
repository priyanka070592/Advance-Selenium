package TestNgPractice;

import org.testng.annotations.Test;

public class InvocationCount {
	
	//Invocation count: Same test-script executed with multiple times with same test data.
	
	
	@Test(priority = 0, invocationCount = 2)
	public void createContact()
	{

	System.out.println("contact created");

	}
    @Test(priority = 1)
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(priority = 2)
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
