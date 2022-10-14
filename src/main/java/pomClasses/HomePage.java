package pomClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilClass.Util;

public class HomePage extends Util {
		
		WebDriver driver;
		
		@FindBy(xpath=(("//div[text()='Jayshri']")))
		private WebElement profilename;
		
		@FindBy(xpath=("//input[@class='_3704LK']"))
		 private WebElement searchControl;
		
		@FindBy(xpath=("//span[@class='_10Ermr']"))
		private WebElement intialtext;
		
		@FindBy(xpath=("//div[@class='_30jeq3 _1_WHN1']"))
		private List<WebElement> productPricelist;
		
		
		
		public HomePage(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
			this.driver=driver;
		}

	   public String getprofilename() throws InterruptedException    
	   {
		  Thread.sleep(2000);
		   
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		   
		   WebElement p =wait.until(ExpectedConditions.visibilityOf(profilename));
		   
		   String name = p.getText();
		   return name;
		   
		   
	   }
	   
	   public String SearchProduct()  {
		   
		   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		   
		   WebElement k= wait.until(ExpectedConditions.visibilityOf(searchControl));
		    k.sendKeys("realme");
		    k.sendKeys(Keys.ENTER);
		    
		    
		    WebElement k1= wait.until(ExpectedConditions.visibilityOf(intialtext));
		    
		    String productText= k1.getText();
		    
		    return productText;
		    
	}
	   
	   public String getProductPriceList() {
		   
		   List<Integer> priceList= new ArrayList<>();
		   
		   for(WebElement priceElement :productPricelist) {
			   
		priceList.add(Integer.parseInt(priceElement.getText().replace("₹", "").replace(",", "")));
			   
		  }
	          System.out.println(priceList);
	          
	          Collections.sort(priceList);
	          
	          return priceList.get(0).toString();
	          
	          
	 }

	   public void switchToPage(int a) {
	 
	    	   
	  driver.findElement(By.xpath("//a[@class='ge-49M' and text()='"+a+"']")).click();
	 
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ge-49M _2Kfbh8'and text()='"+a+"']"))).click();
	}
	   
			

	}
	
