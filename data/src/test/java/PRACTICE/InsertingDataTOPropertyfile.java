package PRACTICE;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertingDataTOPropertyfile {

	public static void main(String[] args) throws Throwable {
	Properties pro = new Properties ();
	pro.setProperty("browser","chrome");
	pro.setProperty("url", "http://localhost:8888/");
	pro.setProperty("username","admin");
	pro.setProperty("password", "admin");
	FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/com.properties.txt");
	//FileOutputStream fout = new FileOutputStream(System.getProperty("/src/test/resources/com.properties.txt"));
	pro.store(fout, "Common Data");
	fout.close();
		// TODO Auto-generated method stub

	}

}