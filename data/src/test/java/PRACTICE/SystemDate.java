package PRACTICE;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class SystemDate {

	public static void main(String[] args) {
	/* Date d = new Date();
		System.out.println(d);
		String date = d.toString().replace(" ", "_").replace(":", "");
		System.out.println(date);*/
		
	LocalDateTime localDateTime =LocalDateTime.now();
	String date = localDateTime.toString().replace(" ", "_").replace(":", "/");
		File dest=new File("./ScreenShot/\"+testName+\".png)");
	System.out.println(date);
}
}