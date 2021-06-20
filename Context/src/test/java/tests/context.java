package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class context {

	public static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
	caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
	caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
    caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
    caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
    
    URL url = new URL("http://127.0.0.1:4723/wd/hub");
    
    driver = new AndroidDriver<AndroidElement>(url, caps);
    
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    
    driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
    
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"India\").instance(0))").click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Divya");
    Thread.sleep(2000);
	
    driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    
    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    driver.findElements(By.className("android.widget.CheckBox")).get(0).click();

    Set<String> contextNames = driver.getContextHandles();
    for(int i=0; i<=0; i++) {
    for(String contextName : contextNames)
    {
    	System.out.println(contextName);
    }
    }
    Thread.sleep(5000);
    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();  
    System.out.println("here");
    
    
    for(int i=0; i<=10; i++) {
    for(String contextName : contextNames)
    {
    	System.out.println(contextName);
    }
    }/*
 //   driver.context((String) contextNames.toArray()[1]);
    driver.findElementByName("q").sendKeys("search");
    driver.findElementByName("q").sendKeys(Keys.ENTER);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    
    driver.context("NATIVE_APP");*/
    Thread.sleep(5000);
    
    driver.quit();
	}

}
