package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MyScrollUtil {

	static AndroidDriver<AndroidElement> driver;
	
	static AndroidElement ScrollByText(String text, AndroidDriver<AndroidElement> driver) //Scroll to an Element By Text
	{  
		AndroidElement element = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		return element;
	} 
	
	static AndroidElement ScrollToElement(By by, AndroidDriver<AndroidElement> driver)
	{
		AndroidElement element = null;
        Dimension size = driver.manage().window().getSize();
        System.out.println(size.height);
        int anchor = size.width/2;
        int starty = size.height - 20;
        int endy = 40;
        int maxmscroll = 11;
        int i;
        for(i =1; i < maxmscroll; i++ )
        {
        	try {
        		TouchAction action = new TouchAction(driver);
        		action.press(PointOption.point(anchor, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(anchor, endy)).release().perform();
        		element = driver.findElement(by);
        		i = maxmscroll;
        		}catch(NoSuchElementException e)
        	{
        			System.out.println("Element not found. Attempt Times:"+ i);
        	}
        }
        return element;
	}
	
	public static void scrolldown(AndroidDriver<AndroidElement> driver)
	{
		Dimension size = driver.manage().window().getSize();
		int anchorx = size.width/2;
		int starty = 800;
		int endy = size.height - 200;
		
		scroll(anchorx, starty, anchorx, endy, driver);
	}
	
	public static void scroll(int startx, int starty, int endx, int endy, AndroidDriver<AndroidElement> driver)
	{
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, endy)).release().perform();
		
	}
	
	public static void mutliaction(AndroidDriver<AndroidElement> driver)
	{
		TouchAction action1 = new TouchAction(driver).tap(PointOption.point(250, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
		TouchAction action2 = new TouchAction(driver).tap(PointOption.point(250, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
		TouchAction action3 = new TouchAction(driver).tap(PointOption.point(250, 450));
		
		MultiTouchAction act = new MultiTouchAction(driver);
		act.add(action1).add(action2).add(action3).perform();
	}
	
	public static void main(String arg[]) throws MalformedURLException, InterruptedException
	{
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in); 
		
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		 caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID" );
		 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		 caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobeta.android.demodslv");
		 caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mobeta.android.demodslv.Launcher");
		 
		 URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver<AndroidElement>(url , caps);
		 
		 driver.findElement(By.id("android:id/button1")).click();
		 
		 driver.findElements(MobileBy.id("com.mobeta.android.demodslv:id/activity_desc")).get(0).click();
		 System.out.println("Enter the Record Name");
		 String element = input.nextLine();
		 ScrollByText(element, driver);
		 Thread.sleep(3000);
		 System.out.println("ok");
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 Thread.sleep(1000);
		 driver.findElements(MobileBy.id("com.mobeta.android.demodslv:id/activity_desc")).get(0).click();
		 ScrollToElement(By.xpath("//android.widget.TextView[contains(@text, 'Mark Turner')]"), driver);
		 Thread.sleep(3000);
		 System.out.println("ok");
		 scrolldown(driver);
		 Thread.sleep(3000);
		 System.out.println("ok");
		 driver.quit();
		 
		 
	}

}
