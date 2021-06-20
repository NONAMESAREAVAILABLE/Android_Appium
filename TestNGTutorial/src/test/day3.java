package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	//Order of test cases execution of testng depends on the alphabetical order
	
    @BeforeClass // will execute before every mehod in the class where it is defined.
    public void beforeClass()
    {
    	System.out.println("will execute before any method in the class day3");
    }
    
    @Parameters({"URL", "APIKey/username"})      // Passing two parameters
	@Test(groups = {"Smoke"})  // Now this test method belong to the group named Smoke
	public void webLoginCarLoan(String url, String key)   // Two variables input because there are two parameters which are passed. 
	{
		//code
		System.out.println("Weblogincar");
		System.out.println(url);
		System.out.println(key);
	}

	@Test(enabled=false) //Helper attribute, if enabled = false then the method will not get executed; the method will get skipped; like if there is any error in the method
	public void MobileloginCarLoan()
	{
		System.out.println("MobileLohginCarloan");
	}
	
	@Test(timeOut= 4000)// this test method will not fail for 40 seconds or 4000 milliseconds
	public void MobileSignInCarLoan()
	{
		System.out.println("MobileSignInCarLoan");
	}
	
	@BeforeMethod // It will execute before every method, specific to class file i.e. even if you run it using testng xml it will only execute for the methods of the class where it is defined
	public void bmethod()
	{
		System.out.println("before method");
	}
	
	@AfterMethod  // It will execute after every method, specific to class file i.e. even if you run it using testng xml it will only execute for the methods of the class where it is defined
	public void afmethod()
	{
		System.out.println("after method");
		System.out.println(" ");
	}
	@Parameters({"URL"}) //It will take parametres defined in the testng xml file
	@Test(enabled=true) // testng helper annotation if the value of enabled is false then test will not get executed
	public void MobileSignOutCarLoan(String paramsuite)
	{
		System.out.println("MobileSignOutCarLoan");
		System.out.println(paramsuite);
	}
	
	@Test(dataProvider = "getData")
	public void dataProvide(String username, String password)  // two variable inputs because each parameter set contain two values
	{
		System.out.println("+++++");
		System.out.println("dataProvider");
		System.out.println(username+"  " +password);
		System.out.println("*****");
	}
	
	
	@BeforeSuite  //It will execute first in a suite i.e. before anything in the suite
	public void bsuite()
	{
		System.out.println("I WILL EXCECUTE BEFORE EVERYTHING --bsuite ");
	}
	
	@AfterClass //will execute after every method in the class where it is defined
    public void afterClass()
    {
    	System.out.println("will execute after any method in the class day3");
    }
    	
	@Test(dependsOnMethods= {"webLoginCarLoan","MobileSignOutCarLoan"}) //testng helper annotation; APICarLoan will execute after "webLoginCarLoan","MobileSignOutCarLoan" gets executed. 
	public void APICarLoan()
	{
	System.out.println("ApiLoginCarloan");	
	}
	
	//Parameterizing with multiple data sets by running tests with multiple combination
	@DataProvider
	public Object[][] getData()
	{
		//1st combination username password - good credit history = row
		//2nd username password - no credit history
		//3rd set - fradulent credit history
		Object[][] data = new Object[3][2];
		
		//1st combination
		data[0][0] = "firstusername";
		data[0][1] = "firstpassword";
		// columns in the row are nothing but values for that particular combination(row) 
		
		//2nd combination
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		
		//3rd combination
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		return data;
	}
	
	
}
