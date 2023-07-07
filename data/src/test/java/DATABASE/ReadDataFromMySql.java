package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMySql {

	public static void main(String[] args) throws SQLException {
		//register or load the mysql database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//get connection to the databse
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashu","root","root");
	//create statement
Statement stat = connection.createStatement();
String selectQuery = "select* from mybatch";
ResultSet result = stat.executeQuery(selectQuery);
while(result.next())
{
	System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
	
}
connection.close();

	}

}
