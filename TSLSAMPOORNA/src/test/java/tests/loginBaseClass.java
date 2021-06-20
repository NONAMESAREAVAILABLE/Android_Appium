package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

// import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class loginBaseClass {
	
	static AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		try {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.137.72:5555");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		
		caps.setCapability("apppackage", "com.mobilous.android.appexe");
		caps.setCapability("appActivity", "com.mobilous.android.appexe.core.AppExeMain");
		
		// 	2730c609-64e4-41d4-81cd-2a064cfd2020
		//  f2d2e7e2-4577-49a5-886f-d270acebfed3
	    //  eb036611-f18d-45f3-b9a8-bea336b16f0e

        
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, caps); 
		
		
		}catch(Exception exp)
		{
			System.out.println("Cause is:"+exp.getCause());
			System.out.println("Message is:"+exp.getMessage());
			exp.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		// driver.quit();	
		
	}
}
