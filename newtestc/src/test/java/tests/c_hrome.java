package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class c_hrome {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID" );
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.1.102:5555");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.println("Start");

		driver.get("https://www.facebook.com");
		Thread.sleep(500);

		driver.findElementByXPath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/form/div[4]/div[1]/div/div/input").sendKeys("7979898011");;
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/form/div[4]/div[3]/div/div/div/div[1]/div/input")).sendKeys("divabf2dA");
		driver.findElementByXPath("//button[@name='login']").click();
		System.out.println("Finish");
		Thread.sleep(500);



		driver.quit();


	}}
