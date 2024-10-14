package TestNgPractice;

import org.testng.annotations.Test;

/*Priority:
		When ever we execute testNg class , by default all the test methods will be executed based on Alphabetical order, in order to change the order of Execution, we go for priority.*/

public class PriorityMethod {

			@Test(priority = 0)
			public void createContact()
			{

			System.out.println("contact created");

			}
		    @Test(priority = -1)
			public void modifyContact()
			{
				System.out.println("modify contact");
			}
			
			@Test(priority = 1)
			public void deleteContact()
			{
				System.out.println("delete contact");
			}
		}


