package GenericUtility;

import org.testng.ITestResult;

import org.testng.IRetryAnalyzer;
public class RetryAnalyser implements IRetryAnalyzer{

	int count=0;
	int retrylimit=2;
	public boolean retry(ITestResult result)
	{
	if(count<retrylimit)	
	{
		count++;
		return true;
		
	}
	return false;
	}
}
