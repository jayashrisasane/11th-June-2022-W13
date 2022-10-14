package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseClass1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanLoginpage {
	
	static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	  LoginPage lp;
	  HomePage hp;

	   @BeforeClass
	   public void beforeclass() {
		   
		   htmlReporter = BaseClass1.getHtmlReporter();
		   reports= BaseClass1.getExtentReports();
		   extentTest= BaseClass1.getExtentTest("VerifyUserCanLoginpage");		   
		   driver= BaseClass1.getDriver();

		 }

	   @BeforeMethod
	   public void beforemethod() {
		   
		   lp= new LoginPage(driver);
		   hp= new HomePage(driver);
		   
		   }
	   
	   @Test
	   public void VerifyUserCanLoginPage() throws InterruptedException, IOException {
		   lp.EmailId();
		   lp.Password();
		   lp.SubmitButton();
		  String name = hp.getprofilename();
		   
			 if(name.equalsIgnoreCase("Jayshri")) {
				 
		       System.out.println("Test case pass");
			 }else {
				 System.out.println("Test case Fail");
			 }
		   }
	   
	   @AfterMethod
	   public void aftermethod(ITestResult result) throws IOException {
		   
	 if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(Status.PASS,"Test: "+result.getName());
	}else if(result.getStatus()==ITestResult.FAILURE) {
		extentTest.log(Status.FAIL,"Test: "+result.getName());
		
	String path= lp.getScreenshot(driver, result.getName());
	extentTest.log(Status.FAIL,"Test: "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		
	}else if(result.getStatus()==ITestResult.SKIP) {
		extentTest.log(Status.SKIP,"Test: "+result.getName());
		}   
	   }
	   
	   @AfterClass
	   public void afterclass() 
	   {
		   reports.flush();
	   }
	   

}
