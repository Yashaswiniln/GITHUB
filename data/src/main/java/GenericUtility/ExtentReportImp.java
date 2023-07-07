package GenericUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		/* STEP3 Create test method during the testexecution start*/
		report.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		//step4 log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
	}
	public void onTestFailure(ITestResult result) {
	//step5 log the fail method
		String testName=result.getMethod().getMethodName();
		System.out.println("execute");
	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot/"+testName+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		//step6 log the skip method
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		//step1 Extent Report Configuration
		Date d = new Date();
		System.out.println(d);
		d.toString().replace(":", "-").replace("", "*");
		ExtentSparkReporter htmlReport=new	ExtentSparkReporter	(new File ("ExtentReports.html"));
	htmlReport.config().setDocumentTitle("Vtiger ExtentReport");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("AUTOMATION TESTING");
	//step2 attach the physical report and do the system confguration
	report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("OS", "Windows10");
	report.setSystemInfo("Environment", "Automation Testing");
	
	report.setSystemInfo("url", "http://localhost:8888/");
	report.setSystemInfo("Reporter Name", "YASHU");
	}
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	

}
