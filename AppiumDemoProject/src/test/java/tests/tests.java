package tests;

//import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;




public class tests extends BaseClass{
	/*
	@Test
	public void testOne(){
		
		driver.get("https://google.com/");
	comment  System.out.println("completed till here");
	 comment   MobileElement a = driver.findElementByClassName("android.widget.EditText");
	comment	 List elementsOne = (List) driver.findElementsByByClassName("gLFyf gsfi");
	comment	locator problem may come by using name or className as locator so instead use xpath
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Automation"); 
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        System.out.println("Completed test One....");
	}  
	*/
	// if I change the name of the function to TestTwo it will run first
/*	@Test
	public void testTwo() {             
		// driver.get("https://google.com/");
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Divya"); 
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        System.out.println("Completed test two....");	
		
	} */
	
	@Test
	public void loginTest() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).click();
		System.out.println("Here");
	   // driver.findElement(By.xpath("//div[@id='content']/div[5]")).clear();
	    driver.findElement(By.xpath("//div[@id='content']/div[5]")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@id='txtPassword']")).click();
	    driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
	    driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	    driver.findElement(By.id("btnLogin")).click();
	    driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	

	
		
} 



