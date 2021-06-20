package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class tests {

	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
		test();
		System.out.println("printed 1");
		}catch(Exception exp) {
		System.out.println("printed");	
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
		System.out.println("printed");
				
		}
		
	}
    
	public static void test() throws MalformedURLException, InterruptedException  {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();
		
		// path = C:\\Users\\divya\\eclipse-workspace\\appiumtutor
		//File app = new File(".\\src\\test\\resources\\apps\\selendroid-test-app-0.17.0.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
	//cap.setCapability(MobileCapabilityType.UDID, "3401a603880b268f");
	cap.setCapability("udid", "192.168.43.44:5555");
	cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	// cap.setCapability(MobileCapabilityType.APP, "app");
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
	
	/* For Current Opened Activity On Your Mobile Phone:
	 First enter command:
 adb shell


Shell will open
then enter command(obviously after m20lte:/ $ )
 dumpsys window windows | grep -E 'mCurrentFocus'
*/
	
	//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	//cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	
	driver = new AndroidDriver<MobileElement>(url, cap);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Thread.sleep(3000);
	
	
	System.out.println(" _______________________ ");
	System.out.println("|Application started....|");
	
	driver.quit();
		service.stop();
	
	}
}
