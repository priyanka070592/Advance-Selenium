package TestNgPractice;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HardAsserEx {


		@Test
		public void m1() {
			String expData = "Qspiders";
			String actData = "Qspiders";
			Assert.assertEquals(actData, expData);
			System.out.println("Gud evng");
		}

		@Test
		public void m2()

		{
			System.out.println("Hello");
		}
	}

