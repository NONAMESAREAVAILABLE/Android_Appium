package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestHardwareKeys {

	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
		test();
		}catch(Exception exp) {
			
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
				
		}
		
	}
    
	public static void test() throws MalformedURLException, InterruptedException  {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();
		
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
	cap.setCapability(MobileCapabilityType.UDID, "3401a603880b268f");
	cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
	

	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	
	driver = new AndroidDriver<MobileElement>(url, cap);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Thread.sleep(3000);
	
	
	System.out.println(" _______________________ ");
	System.out.println("|Application started....|");
	System.out.println(" _______________________ ");
	
	driver.findElement(By.id("android:id/button1")).click(); // for "OK" button of Alert.if Alert is on the same activity, then only alert buttons are clickable
	driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();  // chrome button
	Thread.sleep(3000);
	System.out.println("Pressed chrome key");
	driver.pressKey(new KeyEvent(AndroidKey.BACK));  // How to press back key: pressKey is an function under Interface PressesKey. pressKey takes an KeyEvent Object as argument and KeyEvent is a class under interface nativekey which takes an ENUM named AndroidKey as argument  
	Thread.sleep(3000);
	driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).click();
	
	/* How to press Android ( or Keyboard Key or Android Hardware Key ) Key */ 
	driver.pressKey(new KeyEvent(AndroidKey.A));
	driver.pressKey(new KeyEvent(AndroidKey.P));
	driver.pressKey(new KeyEvent(AndroidKey.P));
	driver.pressKey(new KeyEvent(AndroidKey.I));
	driver.pressKey(new KeyEvent(AndroidKey.U));
	driver.pressKey(new KeyEvent(AndroidKey.M));
	
	Thread.sleep(2000);
	
	driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).clear();
	
	Thread.sleep(3000);
	/* Sending keys using Actions Class */
	
	Actions actions = new Actions(driver);
	actions.sendKeys("New Appium").perform();
	
	Thread.sleep(3000);
	
	driver.toggleWifi();  // How to toggle ( turn state of wifi, like if it's on then this will turn it off ) Wifi. toggleWifi() function is taken from interface SupportsNetworkStateManagement //MAybe not works for new Android Devices
	Thread.sleep(3000);

	try {
	driver.toggleAirplaneMode();  // How to toggle ( turn state of AirplaneMode, like if it's on then this will turn it off ) AirplaneMode. toggleAirplaneMode() function is taken from interface SupportsNetworkStateManagement
	}catch(Throwable T) {
	System.out.println("Airplane mode active");	
	}
	
	/* 
	 Right but if you are turning off like if you are in an airplane mode your steps might not communicate
So what I'll do I'll put it in a try block behind the ladder.
	 */
	
	
	
	Thread.sleep(4000);
	driver.pressKey(new KeyEvent(AndroidKey.HOME));  // How to press HOME key
	Thread.sleep(4000);
	driver.longPressKey(new KeyEvent(AndroidKey.HOME));  // How to press HOME key for long time so that google Assistant opens up
	driver.quit();
		service.stop();
	
	}
}
