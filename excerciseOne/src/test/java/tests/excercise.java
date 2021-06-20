package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class excercise {
	
	public static AndroidDriver<AndroidElement> driver;
	 public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	 {
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 caps.setCapability(MobileCapabilityType.UDID, "192.168.29.44:5555");
		 caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		 caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		 
		 URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver<AndroidElement>(url, caps);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		 return driver;
	 }

}
