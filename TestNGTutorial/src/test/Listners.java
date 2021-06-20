package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// NOTE: IN TESTNG.XML YOU HAVE TO TELL WHERE THIS LISTNERS CODE IS LOCATED OTHETWISE IT WOULD NOT WORK

//ITestListener (it is an interface defined in TestNG java file)  interface which implements Testng listners
public class Listners implements ITestListener  // Listners listens to any event in the code
{
	// THE BELOW METHODS ARE COPIED FROM ITestListener INTERFACE DECLARATION
	
	
	  /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
      @Override //It will execute even if you do not put Override annotation. Use the annotation according to the use.  
	  public void onTestStart(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test succeeds.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS
		   */
          
		  public void onTestSuccess(ITestResult result) {
		   
			  //THIS IS IMPLEMENTED
        	  System.out.println("8=====D");
        	  System.out.println("onTestSuccess Listners class");
        	  System.out.println(" ");
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
		  public void onTestFailure(ITestResult result) {
			//THIS IS IMPLEMENTED
        	  System.out.println("OOOOOOOOO");
        	  System.out.println("onTestFailure Listners class"+result.getName()); //result.getTestName() will print the name of the test which got failed.
        	  System.out.println(" ");
		  }

		  /**
		   * Invoked each time a test is skipped.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SKIP
		   */
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a method fails but has been annotated with successPercentage and this failure
		   * still keeps it within the success percentage requested.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
		   */
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test fails due to a timeout.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   */
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  /**
		   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
		   * and calling all their Configuration methods.
		   *
		   * @param context The test context
		   */
		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
		   * and all their Configuration methods have been called.
		   *
		   * @param context The test context
		   */
		  public void onFinish(ITestContext context) {
		    // not implemented
		  }

}
