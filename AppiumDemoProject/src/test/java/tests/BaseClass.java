package tests;

import java.net.MalformedURLException;
import java.net.URL;

// import org.openqa.selenium.WebElhement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
// import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	static AppiumDriver<MobileElement> driver;
	
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		// try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//caps.setCapability("platformName" , "ANDROID");
		//OR
		//caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		//OR (Write any one of them)
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "3401a603880b268f");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	//	caps.setCapability(MobileCapabilityType.APP, "");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, caps);
	//	or use this, note:Appiumdriver is parent class of AndroidDriver and IOSDriver( they contains actions more 
	//	specific to Mobile type. Like ndroidDriver - More specific actions/functions for Android
	//	driver = new AndroidDriver<MobileElement>(url, caps);
	//	driver = new IOSDriver<MobileElement>(url, caps);
		
		
		/* }catch(Exception exp) {
			System.out.println("Cause is: "+exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		}*/
		
	}

	/*@Test
	public void sampleTest() {
		System.out.println("I am inside sample test... HELP ME!");
	}
	*/
	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
