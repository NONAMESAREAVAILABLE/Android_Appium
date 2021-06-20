package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class tests extends GuruBaseClass {
	
	@Test
	public void test() throws InterruptedException {
	
		Thread.sleep(5000);
		System.out.println("pass");
		
		MobileElement AppName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]"));
		
		//  //android.widget.TextView[@id='android:id/action_bar_title']"
		// AppName.click();
		
		TouchActions action = new TouchActions(driver);
		action.singleTap(AppName);
		action.perform();
		
	   /* String AppNameText = AppName.getText();
		String ExpectedAppName = "Guru99";
		
		if(AppNameText.equals(ExpectedAppName))
		{
			System.out.println("PASS:EXPECTED RESULT1");
			System.out.println("\n");
		}
		else
		{
			System.out.println("FAIL:EXPECTED RESULT1");
			System.out.println("\n");
		}
		
		*/
	}
	

}
