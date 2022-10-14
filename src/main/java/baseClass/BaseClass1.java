package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass1 {
	
	static WebDriver driver;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	static ExtentTest extentTest;
	
	
	public static WebDriver getDriver() {
		
		if(driver== null) {
			
		WebDriverManager.chromedriver().setup();
		
		
     //System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browsers\\chromedriver.exe");
		
		driver = new ChromeDriver();	
			 
	    driver.get("https://www.flipkart.com/");
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	    
	    return driver;
	}
	
	public static ExtentHtmlReporter getHtmlReporter() {
		
		if(htmlReporter == null){
			
		htmlReporter = new ExtentHtmlReporter("ExtentReports\\reports.html");
		}
		return htmlReporter;
	}
    public static ExtentReports getExtentReports() {
	    if (reports==null) {
	    	reports= new ExtentReports();
			reports.attachReporter(htmlReporter);
		}
	    return reports;
	    }
    
    public static ExtentTest getExtentTest(String testname) {
    	
    	 extentTest= reports.createTest(testname);
    	 return extentTest;
    }
     
}


