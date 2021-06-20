package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Message {

	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.messaging");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY , ".ui.view.main.WithActivity");
	 
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.findElement(By.id("com.samsung.android.messaging:id/fab")).click();
		driver.findElement(By.id("com.samsung.android.messaging:id/recipients_editor_to")).sendKeys("7979898011");
		Thread.sleep(3000);
		driver.findElement(By.id("com.samsung.android.messaging:id/message_edit_text")).click();
		driver.findElement(By.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("Message"); //sendKeys("Message");
		System.out.println("done");
		Thread.sleep(5000);
		driver.findElement(By.id("com.samsung.android.messaging:id/send_button1")).click();
		Thread.sleep(25000);
		driver.quit();
		
	}

}
