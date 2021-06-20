package com.edureka.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\divya\\Pictures\\Selenium\\Browser drivers\\Browser drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com/");
        driver.manage().window().maximize();
        // driver.findElement(By.className("BHzsHc")).click();
        driver.findElement(By.id("identifierId")).sendKeys("divab658@gmail.com");
        //driver.findElement(By.className("RveJvd snByac")).click(); 
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("behnchod@");
      //  driver.findElement(By.name("password")).sendKeys("behnchod@");
        driver.findElement(By.id("passwordNext")).click();
        String at = driver.getTitle();
        String et =	"gmail";
        driver.close();
        if(at.equalsIgnoreCase(et))
        {
        	System.out.println("Test Successful");
        }
        else
        {
        	System.out.println("Test Failed");
        }
	}

}
