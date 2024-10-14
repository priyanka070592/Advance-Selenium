package generic_utility;

import java.util.Random;

public class Java_Utility 
{

		
		/**
		 * This method is used to avoid duplicates
		 * 
		 * @return
		 */
		public int getRandonNum() {
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
			return ranNum;
		}

	}

