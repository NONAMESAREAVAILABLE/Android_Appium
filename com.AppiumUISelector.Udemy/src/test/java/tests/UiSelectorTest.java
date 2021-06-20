package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

 // import org.openqa.selenium.By;
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

public class UiSelectorTest {

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		/* AppiumDriverLocalService service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();*/

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
		
		driver.findElement(MobileBy.id("android:id/button1")).click(); //for the first alert
		
		// driver.findElement(MobileBy.xpath("//*[contains(@content-desc, 'showPopupWindowButtonCD')]")).click();
		
		// driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Display Popup Window\")").click();
		
		// driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Display Popup Window\")").click();
		
		// driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\").checked(true)").click();
		
		  System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\")").size());
		  
		  System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").size());
		  
		  MobileElement button = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").get(1);
		  button.click();
		  
		// service.stop();
	}

}
