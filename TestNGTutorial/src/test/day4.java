package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	@Parameters({"URL"})  //It will take parametres defined in the testng xml file
	@Test
	public void webLoginHomeLoan(String paramstring)
	{
		//code
		System.out.println("WebloginHome");
		System.out.println(paramstring);
	}

	@Test
	public void MobileloginHomeLoan()
	{
		System.out.println("MobileLohginHomeloan-->");
		Assert.assertTrue(false);
	}
	
	@Test(groups= {"Smoke"})  // Now this test method belong to the group named Smoke
	public void LoginAPIHomeLoan()
	{
	System.out.println("ApiLoginHomeloan");	
	}
	// Right click on the Java project and then in the dropdown select refresh - then the test-output folder will apear, in that folder open index.html file if you want to see the reports
}

