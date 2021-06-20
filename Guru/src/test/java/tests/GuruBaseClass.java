package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GuruBaseClass {

	static AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {

	    try {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.137.51:5555");
	//	caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		
		caps.setJavascriptEnabled(true);  // Important for hybrid apps

		caps.setCapability("apppackage", "com.vector.guru99");
		caps.setCapability("appActivity", "com.vector.guru99.BaseActivity");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, caps);
	  	}catch(Exception exp)
		{
			System.out.println("Cause is:"+exp.getCause());
			System.out.println("Message is:"+exp.getMessage());
			exp.printStackTrace();
		}  
	}
	
/*	@AfterTest
	public void teardown() {
		driver.quit();
	}
*/
}
