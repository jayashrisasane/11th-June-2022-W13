package utilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	
	public static void waitTillElementApear(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		   
		 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitTillElementApear(WebDriver driver,WebElement element ,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		   
		 wait.until(ExpectedConditions.visibilityOf(element));
		 }
		 
    public static WebElement waitTillElementApear(WebDriver driver,By element,int time) {
				
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
				   
    return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				
			}
    
    public static String getConfigData(String key) throws IOException {
    	
    	FileInputStream file= new FileInputStream("Configuration\\confi.properties");
    	
    	Properties prop= new Properties();
    	
    	prop.load(file);
    	
    	return prop.getProperty(key);
    }
    
    public static String getScreenshot(WebDriver driver,String methodName) throws IOException {
    	
    	String path= "Screenshots\\"+methodName+".png";
    	TakesScreenshot ts= (TakesScreenshot)driver;
    	
    	File Source= ts.getScreenshotAs(OutputType.FILE);
    	File des = new File(path);
    	FileHandler.copy(Source, des);
    	
    	return path;
    	
    }
    	
    public static void hoverToElement(WebDriver driver,WebElement element) {
    	
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    	}
    
	
}
