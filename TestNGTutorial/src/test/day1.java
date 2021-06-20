package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {

	@AfterTest   // It will execute at the last i.e. at the end of all the tests case if user runs the java file or testng xml file
	public void lastExecution()  // will execute at the end of test name = "Personal Loan"
	{
		System.out.println("I will execute last");
	}
	
	//Title: How to run test with TestNG
	// You need to have @Test Annotations followed by method

	@AfterSuite  //It will execute at the last i.e. after the suite
	public void asuite()
	{
		System.out.println("I WILL EXECUTE AFTER EVERYTHING -- A Suite");
	}
	@Test (groups = {"Smoke"}) // Now this test method belong to the group named Smoke
	public void Demo() {  // TestNG require every method to be inside the main method
 System.out.println("hello"); // this code will run without main method
	}

	@Test
	public void SecondTest()
	{
		System.out.println("bye");
	}
}
