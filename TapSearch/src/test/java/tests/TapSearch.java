package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
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
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TapSearch {

	static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<AndroidElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("android:id/button1")).click(); //for the first alert
		
		AndroidElement ImageLayout = driver.findElement(MobileBy.id("io.selendroid.testapp:id/imageView"));
		// Finding a Element using already found layout
	    ImageLayout.findElement(MobileBy.AccessibilityId("startUserRegistrationCD")).click();
		Thread.sleep(1000);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(152, 348)).perform();
		// tap() documentation
		// https://appium.github.io/java-client/io/appium/java_client/TouchAction.html#tap-io.appium.java_client.touch.offset.PointOption-

		Actions actions = new Actions(driver);
		actions.sendKeys("New Appium").perform();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		
		TouchAction act2 = new TouchAction(driver);
		act2.tap(PointOption.point(127, 696));
		TouchAction act3 = new TouchAction(driver);
		act3.tap(PointOption.point(103, 820)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).getClass();
		
		MultiTouchAction mixer = new MultiTouchAction(driver);
		mixer.add(act2).add(act3).perform();
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
