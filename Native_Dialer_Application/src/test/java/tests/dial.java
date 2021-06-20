package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class dial {

	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.dialer");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY , "com.samsung.android.dialer.DialtactsActivity");
	 
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
		
		// System.out.println(driver.findElements(MobileBy.className("android.widget.FrameLayout")).size());
		driver.findElement(MobileBy.id("com.samsung.android.dialer:id/digits")).sendKeys("9798980");
		//driver.findElement(MobileBy.id("com.samsung.android.dialer:id/eight")).click();
		// driver.findElement(MobileBy.id("com.samsung.android.dialer:id/zero")).click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.RelativeLayout\").resourceId(\"com.samsung.android.dialer:id/one\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.RelativeLayout\").resourceId(\"com.samsung.android.dialer:id/one\")").click();
		List<MobileElement> dial = driver.findElements(MobileBy.className("android.widget.FrameLayout"));
		//int i = 0;
	/*	for(MobileElement frame:dial) {
			System.out.println("----");
			System.out.println(i++);
			System.out.println(frame.isEnabled());
			System.out.println(frame.isDisplayed());
			System.out.println(frame.getAttribute("resource-id"));
			System.out.println("----");
		}*/
		dial.get(6).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
		driver.findElement(MobileBy.id("android:id/button1")).click();
		
		driver.findElement(MobileBy.id("com.samsung.android.dialer:id/contactlist_tab_button")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.FrameLayout")));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		System.out.println(driver.findElements(MobileBy.className("android.widget.Button")).size());
		List<MobileElement> buttons = driver.findElements(MobileBy.className("android.widget.Button"));
		buttons.get(0).click();
		List<MobileElement> check = driver.findElements(MobileBy.className("android.widget.CheckBox"));
		check.get(0).click();
		
		driver.findElement(MobileBy.id("com.samsung.android.contacts:id/button2")).click();
		driver.findElement(MobileBy.id("com.samsung.android.contacts:id/nameEdit")).sendKeys("Appium Contact");
		TouchActions tap =new TouchActions(driver);
		MobileElement elem = driver.findElement(By.id("com.samsung.android.contacts:id/titleLayout"));
		tap.moveToElement(elem, 300, 100).click();
		// driver.findElement(MobileBy.id("com.samsung.android.contacts:id/forCursorEdit")).click();
		try {
		driver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text, 'Phone')]")).click();
		}catch (NoSuchElementException e)
		{
			System.out.println("exception:"+e);
		}
		try {
			driver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text, 'Phone')]")).sendKeys("1111111111");driver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text, 'Phone')]")).click();
		}catch (Exception e)
		{
			System.out.println("exception:" + e);
		}
		// driver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text, 'Phone')]")).sendKeys("1111111111");
		driver.findElement(MobileBy.id("com.samsung.android.contacts:id/menu_done")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
