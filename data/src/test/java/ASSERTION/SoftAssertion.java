package ASSERTION;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false, false);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}
	
	@Test
	public void m2()
	{
		String expData="Yashu";
		String actData="Yash";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actData,expData);
		soft.assertAll();
}
}

