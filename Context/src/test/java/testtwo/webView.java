package testtwo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.transaction.xa.Xid;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class webView {

	static AndroidDriver<AndroidElement> driver;
	public static void main(String arg[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.1.102:5555");
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "selendroid");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobilous.android.appexe.apptslsampoorna.p404");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mobilous.android.appexe.core.AppExeMain");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		
		//setWebContentsDebuggingEnabled(true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<AndroidElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement btn = driver.findElement(By.id("com.mobilous.android.appexe.apptslsampoorna.p404:id/btn_yes"));
		btn.click();
		Thread.sleep(7000);
		List<AndroidElement> txtbox = driver.findElements(By.className("android.widget.EditText"));
		
		for(AndroidElement boxes: txtbox)
		{
			boxes.getText();
			boxes.getTagName();
		}
		txtbox.get(0).sendKeys("0000197872");
		txtbox.get(1).sendKeys("7872");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//android.widget.Button[@text='LOGIN']")).click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"Customer\")").click();
		Thread.sleep(7000);
		//driver.findElements(By.className("android.widget.Button")).get(12).click();
		//Thread.sleep(6000);
		driver.findElements(By.id("com.mobilous.android.appexe.apptslsampoorna.p404:id/rowContents")).get(4).click();
		Thread.sleep(8000);
		
		/* driver.findElement(MobileBy.id("android:id/button1")).click(); //for the first alert
		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		Thread.sleep(19000);
		// for context
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName: contextNames)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_chrome");
		
		*/
		driver.quit();
	}
}
