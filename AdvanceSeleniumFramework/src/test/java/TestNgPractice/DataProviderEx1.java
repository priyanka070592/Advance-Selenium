package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 
{
	@Test(dataProvider = "dataProviderData")
	public void bookTickets(String src, String dest, int numOfPple)
	{
		System.out.println("Book tickets from" +src +"to"+ dest +" , " +numOfPple);
		
	}
	@DataProvider
	public Object[][] dataProviderData()
	{
		
		Object[][] objArr = new Object[2][3];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		objArr[0][2]=3;
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Mysore";
		objArr[1][2]=4;
		
		
		return objArr;
		
	}

}
