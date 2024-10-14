package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		//step1: Register / load my SQL database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2: Get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students_Table", "root", "root");
		//step3:create a SQL statement
		Statement state = conn.createStatement();
		String query = "select * from student";
		
		//step4: execute statement query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
		System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));	
		}
		conn.close();

	}

}
