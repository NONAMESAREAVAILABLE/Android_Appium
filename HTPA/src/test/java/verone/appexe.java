package verone;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class appexe {

	public static AndroidDriver<AndroidElement> driver;
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M205F");
		caps.setCapability(MobileCapabilityType.UDID, "192.168.29.44:5555");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobilous.android.appexe.apptslsampoorna.p2");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mobilous.android.appexe.core.AppExeMain");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<AndroidElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
		
		Set<String> contexts = driver.getContextHandles();
		
		for(String contextName :contexts)
		{
			System.out.println(contextName);
		}
		
		driver.quit();
	}

}
