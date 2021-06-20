package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@Test(groups = {"Smoke"})  // Now this test method belong to the group named Smoke
	public void ploan() {
		System.out.println("ploan");
	}
	
	@BeforeTest    // It will execute before any test. If user runs through xml file or if user runs normal java application
	public void prerequisite() // Will execute at the start of test name = "Personal Loan"l
	{
		System.out.println("I will execute first");
	}

}
