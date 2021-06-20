package test2;

import org.testng.annotations.Test;

public class day1 {

	//Title: How to run test with TestNG
	// You need to have @Test Annotations followed by method
		
	@Test
	public void Demo() {  // TestNG require every method to be inside the main method
 System.out.println("hello"); // this code will run without main method
	}

	@Test
	public void SecondTest()
	{
		System.out.println("bye");
	}
}
