package generic_utility;

    import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Properties;

	public class File_Utility {
		/**
		 * this method is use to read data from from properties_file
		 * 
		 * @param key
		 * @return
		 * @throws Throwable
		 */

		public String getKeyAndValuePair(String key) throws Throwable {
			FileInputStream fis = new FileInputStream(IPathConstants.filepath);

			// step2:- load all the keys to Properties class
			Properties pro = new Properties();
			pro.load(fis);

			// Step3:- call keys from properties file
			String Value = pro.getProperty(key);
			return Value;
		}
	}

