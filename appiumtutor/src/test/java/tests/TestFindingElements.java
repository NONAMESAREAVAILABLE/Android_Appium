package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestFindingElements {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		/*
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();
		*/
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		//cap.setCapability(MobileCapabilityType.UDID, "3401a603880b268f");
		cap.setCapability("udid", "192.168.43.44:5555");
		cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		// cap.setCapability(MobileCapabilityType.APP, "app");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("android:id/button1")).click(); // for OK button of first alert
		
		// driver.findElement(MobileBy.id("io.selendroid.testapp:id/visibleButtonTest")).click();
		
		// AccessibilityId - Fastest and most recommended/used locator strategy. It is cross platform can be used both in Android and ios
		// In Android AccessibilityId is used using content-desc property , in ios used using AccessibilityId
		// driver.findElement(MobileBy.AccessibilityId("visibleButtonTestCD")).click();
		
		//xpath are a bit slow, * - used when you don't know the tag name
		//Syntax of xpath    //tagname[@attribute='value']
		//driver.findElement(MobileBy.xpath("//*[@content-desc='visibleButtonTestCD']")).click();
		// or
		// driver.findElement(MobileBy.xpath("//*[@text='Display text view']")).click();
		// Working in this case but it may not work in other application since text "Display text view" is too big
		// So you can do this:
		// driver.findElement(MobileBy.xpath("//*[contains(@text,'Display text')]")).click();
		// but make sure that the text "Display text" is not with any other element on that page
		
		//it may happen that there are two elements with this text.
		//One could have a different tag and another one could have a different tag.
		//So how to get tag name. You'll find most of the time that the class name is only the tag name.
		//So in android you can do like this
		// driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Display text')]")).click();
		// or you can also use parent class name
		driver.findElement(MobileBy.xpath("//android.widget.LinearLayout/android.widget.Button[contains(@text,'Display text')]")).click();
		
		
		// to get xml documentation of Android app , use attach session of appium inspector
		
		
		Thread.sleep(30000);
		
		
		driver.quit();
	//	service.stop();

	}

}
