package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClass.Util;

public class LoginPage extends Util {
	
	
	//WebElement,constructor,public method .
	
			@FindBy(xpath=("//input[@class='_2IX_2- VJZDxU']"))
			private WebElement EmailId;
		     
			
			@FindBy(xpath=("//input[@type='password']"))
			private WebElement Password;
			
			@FindBy(xpath=("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"))
			private WebElement SubmitButton;
			
			
			public LoginPage(WebDriver driver)
			{
				
				PageFactory.initElements(driver, this);
			}		

			public void EmailId() throws IOException{
				
				EmailId.sendKeys(getConfigData("EmailId"));
			}
			
			public void Password() throws IOException {
				
		     Password.sendKeys(getConfigData("Password"));
			}
			
			public void SubmitButton() {
				
				SubmitButton.click();
			}
	}



