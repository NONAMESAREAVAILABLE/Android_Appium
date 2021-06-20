package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
// import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
		openCalculator();
		}catch(Exception exp) {
			
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
				
		}
		
	}
    
	public static void openCalculator() throws MalformedURLException  {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("deviceName", "SM-M205F");
	//cap.setCapability("udid", "3401a603880b268f");
	cap.setCapability("udid", "192.168.137.85:5555");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "9");
	
	cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	
	driver = new AppiumDriver<MobileElement>(url, cap);
	
	System.out.println(" _______________________ ");
	System.out.println("|Application started....|");
	
	MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
	MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
	MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03"));
	MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
	MobileElement result = driver.findElement(By.className("android.widget.EditText"));
	
	// driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/bt_equal']"));
	
	two.click();
	plus.click();
	three.click();
	equals.click();
	
	String res = result.getText();
	System.out.println("|Result is: "+res+"           |");
	
	System.out.println("|  Pass                 |");
	System.out.println("|_______________________|");
	
	}
}
