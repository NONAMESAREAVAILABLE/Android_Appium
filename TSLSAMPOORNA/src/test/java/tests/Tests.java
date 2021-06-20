package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
// import io.appium.java_client.android.AndroidDriver;



public class Tests extends loginBaseClass {
	
  //  static AndroidDriver<MobileElement> drive = new AndroidDriver<MobileElement>();

	@Test
	public void LoginTest() {
		MobileElement Userid = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
		MobileElement Password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
		MobileElement Login = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button[2]"));

		Userid.sendKeys("0000654321");
		Password.sendKeys("1234");
		Login.click();

		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		System.out.println("=================================================================");
		String str = driver.currentActivity();
		System.out.println(str);
		System.out.println("pass");
	}


}
