package GenericUtility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ListenerClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		System.out.println("execute");
	/*	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot/"+testName+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
TakesScreenshot screen =(TakesScreenshot)BaseClass.sdriver;
File src=screen.getScreenshotAs(OutputType.FILE);
LocalDateTime localDateTime =LocalDateTime.now();
localDateTime.toString().replace(" ", "").replace(":", "/");
File dest=new File("./ScreenShot/\"+testName+\".png)");
try
{
	FileUtils.copyFile(src, dest);
}
catch(Exception e)
{
	e.printStackTrace();
	System.out.println("problem is saving screenshot");
}
		
		
			
		

}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}