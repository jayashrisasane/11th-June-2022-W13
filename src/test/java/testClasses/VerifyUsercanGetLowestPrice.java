package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class VerifyUsercanGetLowestPrice {
	
	
	static WebDriver driver; 
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;

	 LoginPage lp;
	 HomePage hp;
	
	@BeforeClass
	public void beforeClass() {
		
	htmlReporter = BaseClass1.getHtmlReporter();
    reports= BaseClass1.getExtentReports();
    extentTest= BaseClass1.getExtentTest("VerifyUsercanGetLowestPrice");	
		
   driver= BaseClass1.getDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
	lp = new LoginPage(driver);
	hp= new HomePage(driver);
		
		}
	
	@Test(priority=1)
	public void VerifyUserCanOnProduct() {
		
	String actualText= 	hp.SearchProduct();
	
	if(actualText.contains("Showing 1 –")) {
		
		System.out.println("Test case is passed");
	}else {
		Assert.fail();
		}
				
	}
	
	@Test(priority=2)
	public void verifyUsercanGetLowestPrice() {
		
		List<String> lowestEachPageList = new ArrayList<>();
		
		for(int i=1;i<=5;i++) {
			
			if(i!=1) {
			
			hp.switchToPage(i);
			
			}
		lowestEachPageList.add(hp.getProductPriceList());
		}
		
		System.out.println(lowestEachPageList);		
	}
		
		@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
			
	if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(Status.PASS,"Test: "+result.getName());
	}else if(result.getStatus()==ITestResult.FAILURE) {
		extentTest.log(Status.FAIL,"Test: "+result.getName());
	String path= hp.getScreenshot(driver, result.getName());
	extentTest.log(Status.FAIL,"Test: "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}else if(result.getStatus()==ITestResult.SKIP) {
		extentTest.log(Status.SKIP,"Test: "+result.getName());
	}   
	}
	
	@AfterClass
	public void afterclass() {
		reports.flush();
		
			}
	}



