package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class draganddrop {

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
		service.start();	
		File app = new File(".\\src\\test\\resources\\apps\\DRAGDROP.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9" );
		caps.setCapability(MobileCapabilityType.UDID, "192.168.43.44:5555");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//	caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, caps); 
		
		driver.findElement(By.id("android:id/button1")).click();
		
		// driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		 driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[contains(@text,'Basic usage playground')]")).click();
		 List<MobileElement> elements = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

         TouchAction actions = new TouchAction(driver);
         actions.press(ElementOption.element(elements.get(0))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.element(elements.get(3))).release().perform();
		

		Thread.sleep(2000);

		driver.quit();
		service.stop();
	}

}
