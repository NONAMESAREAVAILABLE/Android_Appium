package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorJava {

	static AndroidDriver<MobileElement> driver;
	// public MobileElement frame;
	

	@BeforeSuite
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
	//	caps.setCapability(MobileCapabilityType.UDID, "3401a603880b268f");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        
		// frame = driver.findElement(By.className("android.widget.FrameLayout"));
		try{
			driver.findElement(MobileBy.AccessibilityId("No formula")).click();
			//Thread.sleep(10000);
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}catch(Exception e)

		{
		System.out.println("choose theme not visible");	
		}
         
	}

	@Test
	public void add()
	{
		driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_8")).click();
		System.out.println("1st command");
		driver.findElement(MobileBy.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(MobileBy.id("com.google.android.calculator:id/eq")).click();
		String result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
	}
	
    @AfterSuite
    public void tearDown() {
    	driver.quit();
    	
    }

}
