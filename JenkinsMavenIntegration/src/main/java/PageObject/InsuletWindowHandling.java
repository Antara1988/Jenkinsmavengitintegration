package PageObject;


import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ActionDriver.ActionDriver;
import Base.BaseClass;

public class InsuletWindowHandling extends BaseClass{
	
	@FindBy(xpath="//a[@class='menu-item external-processed']")
	WebElement OmnipodBtn;
	
	@FindBy(xpath="//a[@class='a_button a_cta bg-color-grape color-light borderless']")
	WebElement GetStartedBtn;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	WebElement ContactUsBtn;
	
	@FindBy(xpath="//div[@class='ot-sdk-container']")
	WebElement Alert;
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement AcceptAllcookiesBtn;
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement AAB;
	
	ActionDriver AD = new ActionDriver();
	WebDriver driver;
	
	public InsuletWindowHandling(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void omnipodClick() {
		AD.click(driver, AAB);
		AD.click(driver, OmnipodBtn);	
		AD.implicitWait(driver, 20);
	}
	
	public void search() throws InterruptedException {
		Set<String> windows=driver.getWindowHandles();
		
		System.out.println("----------------->"+windows);
		
		
		String MainWindow=(String) windows.toArray()[0];
		String OmnipodWindow =(String) windows.toArray()[1];
		AD.SwitchWindow(driver, OmnipodWindow);
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.alertIsPresent());
		AD.moveToElement(driver,Alert);
		AD.click(driver, AcceptAllcookiesBtn);
		AD.implicitWait(driver, 20);
		AD.moveToElement(driver, GetStartedBtn);
		AD.click(driver, GetStartedBtn);
		//Dimension d = new Dimension(1000,1000);
		//driver.manage().window().setSize(d);
		//AD.moveToElement(driver, AcceptAllcookiesBtn);	
		//Thread.sleep(30);		
		AD.SwitchToMainWindow(driver);
		AD.moveToElement(driver,ContactUsBtn);
		AD.click(driver, ContactUsBtn);
		
		
	}
	
	
}
