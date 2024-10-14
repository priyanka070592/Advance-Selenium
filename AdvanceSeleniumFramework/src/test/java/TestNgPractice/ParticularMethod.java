package TestNgPractice;

import org.testng.annotations.Test;

public class ParticularMethod {
	
	
	//if don't want to execute one particular method	

	@Test
	public void createContact()
	{
		
	System.out.println("contact created");

	}

	@Test(enabled = false)
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	
	
	
	
	//if independent method is fail then dependent method also will skip

		/*@Test
		public void createContact()
		{
			.
			System.out.println(arr[5]);
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
			System.out.println("delete contact");*/
			
			
			
			
		}
	}
