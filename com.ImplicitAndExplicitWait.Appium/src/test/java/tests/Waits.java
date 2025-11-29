package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

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



public class Waits {
	static AndroidDriver<MobileElement> driver;
    static AndroidDriver<MobileElement> driverex;

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
	    DesiredCapabilities KOAS = new DesiredCapabilities();
		KOAS.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		KOAS.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9" );
		KOAS.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		KOAS.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		KOAS.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		KOAS.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");

		

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		/// AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, KOAS);
		driver = new AndroidDriver<MobileElement>(url, KOAS);
	    driverex = new AndroidDriver<MobileElement>(url, KOAS);
		
		driver.manage().timeouts().implicitlyWait(100L, TimeUnit.SECONDS); //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); -> in new appium client library
		Instant start = Instant.now();
		try {
		driver.findElement(MobileBy.id("android:id/button1")).click();
		}finally {
			Instant end = Instant.now();
			System.out.println("Total time is as follows:");
			System.out.println(Duration.between(start, end));
		}
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.ImageButton\").resourceId(\"io.selendroid.testapp:id/buttonStartWebview\")").click();
		
		WebDriverWait wait = new WebDriverWait(driverex, 5L);  //for new appium java client 8.x.x WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("io.selendroid.testapp:id/goBack"))).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.AccessibilityId("showPopupWindowButtonCD")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.quit();
	//driverex.quit();
		

	
	}

}
