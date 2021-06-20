package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class UiAutomator {

	static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

			driver.findElement(MobileBy.id("android:id/button1")).click(); //for the first alert
			System.out.println(driver.findElements(By.className("android.widget.Button")).size());
			List<MobileElement> button = driver.findElements(By.className("android.widget.Button"));
			
			for(MobileElement widButton:button)  //  Enhanced for loop (in List Collection class
			{
			System.out.println(widButton.isDisplayed());	
			System.out.println(widButton.getText());
			System.out.println(widButton.getAttribute("resource-id"));
			}
			System.out.println("====");
			System.out.println("    ");
			System.out.println("====");
			
			System.out.println(driver.findElements(By.className("android.widget.LinearLayout")).size());
			List<MobileElement> linearlayout = driver.findElements(By.className("android.widget.LinearLayout"));
			System.out.println("    ");
			int i = 1;
			for(MobileElement widLinLa:linearlayout)
			{
				
				if(i==1) {
				System.out.println(i+"st Element");}
				else if(i==2) {
					System.out.println(i+"nd Element");	
				}
				else if(i==3)
				{
					System.out.println(i+"rd Element");
				}
				else {
					System.out.println(i+"th Element");
				}
				System.out.println(widLinLa.isEnabled());
				System.out.println(widLinLa.isDisplayed());
				System.out.println(widLinLa.getAttribute("resource-id"));
				System.out.println("----------------------------------------");
				i= i+1;
			}
			MobileElement layoutfive = driver.findElements(By.className("android.widget.LinearLayout")).get(4);
			layoutfive.findElements(By.className("android.widget.Button")).get(1).click();
			System.out.println("***********");
			System.out.println(driver.findElements(By.id("//*[contains(@text, 'Dismiss')]")).size());
			System.out.println(driver.findElements(By.className("android.widget.TextButton")).size());
			System.out.println("***********");
			Thread.sleep(5000);
		driver.quit();

	}

}
