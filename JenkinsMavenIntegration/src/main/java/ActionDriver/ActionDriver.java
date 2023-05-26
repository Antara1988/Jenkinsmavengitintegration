package ActionDriver;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import Base.BaseClass;

public class ActionDriver extends BaseClass{


	public void scrollByVisible(WebDriver driver,WebElement element) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoview();", element);	
	}


	public void click(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public boolean Displaymethod(WebDriver driver,WebElement element) {
		
		//boolean flag = driver.findElement(By.xpath("//div[@id='logo']")).isDisplayed();
		boolean flag = element.isDisplayed();
		System.out.println("---------------------------->"+flag);
		if(flag)
		{
			System.out.println("Element is Displayed");

		}
		else
			System.out.println("Element is not displayed");
		return flag;
	}


	public void entertxt(WebElement element, String data) {


		try {

			element.clear();
			element.sendKeys(data);
		}

		catch(Exception e){

			System.out.println("Not able to find the element" +e);
		}
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public boolean selectByIndex(WebElement element, int Index ) {
		Select s= new Select(element);

		s.selectByIndex(Index);
		return true;



	}

	public boolean selectByValue(WebElement element, String value) {
		Select s= new Select(element);

		s.selectByValue(value);;
		return true;

	}

	public boolean selectByVisisbelText(WebElement element,String text) {
		Select s= new Select(element);

		s.selectByVisibleText(text);
		return true;
	}

	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}
	public void mouseHover(WebElement ele) {
		boolean flag=false;
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).build().perform();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.out.println("The Mouse Hover action is performed");
			}
			else
			{
				System.out.println("The mouse Hover action is not performed");
			}
		}
	}

	public void JSclick(WebDriver driver, WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click", ele);

	}

	public void SwitchToFrameByIndex(WebDriver driver,int index) {
		boolean flag= false;
		try {
			driver.switchTo().frame(index);
			flag=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(flag)
			{
				System.out.println("The frame with index"+index +"selected");
			}
			else
				System.out.println("The frame with indes"+index+"not selected");
		}

	}
	public void SwithToFrameById(WebDriver driver,String id) {
		boolean flag= false;
		try {
			driver.switchTo().frame(id);
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				System.out.println("The frame with index"+id +"selected");
			}
			else
				System.out.println("The frame with index\"+id +\"not selected");
		}
	}
	public void SwithToFrameByName(WebDriver driver,String name) {
		boolean flag= false;
		try {
			driver.switchTo().frame(name);
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				System.out.println("The frame with index"+name +"selected");
			}
			else
				System.out.println("The frame with index"+name +"not selected");
		}
	}

	public boolean switchToDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void moveToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Actions act= new Actions(driver);
		act.moveToElement(element).build().perform();	
	}

	public void dragandDrop(WebDriver driver,WebElement source,WebElement target) {

		boolean flag=false;
		try {
			Actions act= new Actions(driver);
			act.dragAndDrop(source, target).perform();;
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag)
			{
				System.out.println("DRag and drop action is performed");
			}
			else
			{
				System.out.println("DRag and drop action is not performed");
			}
		}
	}

	public void DragandDropoffset(WebDriver driver,WebElement source, int x,int y) {
		boolean flag = false;
		try {
			Actions act = new Actions(driver);
			act.dragAndDropBy(source, x, y).build().perform();;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(flag) {
				System.out.println("DRag and drop action is performed");
			}
			else
				System.out.println("DRag and drop action is not performed");
		}

	}
	public void rightClick(WebDriver driver, WebElement ele) {
		try {
			Actions act= new Actions(driver);
			act.contextClick(ele).perform();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public void WindowHandlesByTitle(WebDriver driver, String windowTitle,int numofWindows) {

		Set<String> windowList = driver.getWindowHandles();
		String[] arr1= new String[0];
		String[] array = windowList.toArray(arr1);
		//String[] arr=  windowList.toArray(new String[0]);
		driver.switchTo().window(array[numofWindows-1]);
		String ActualTitle= driver.getTitle();

		if(ActualTitle.contains(windowTitle))
		{
			System.out.println("Navigated to the window with title"+windowTitle);
		}
		else
			System.out.println("Didn't navigated to the window with title"+windowTitle);
	}

	public void SwitchWindow(WebDriver driver,String window) {
		//Set<String> Windows= driver.getWindowHandles();
		//Object[] win= Windows.toArray();
		driver.switchTo().window(window.toString());


	}
	
	
	public void SwitchToMainWindow(WebDriver driver) {
		Set<String> windows= driver.getWindowHandles();
		Object[] win= windows.toArray();
		driver.switchTo().window(win[0].toString());
	}


	public void AccepAlert(WebDriver driver,WebElement element) {
		Alert Aa= driver.switchTo().alert();
		Aa.accept();
		String Actualmsg= element.getText();
		//boolean result= Actualmsg.equalsIgnoreCase(text);
		//System.out.println(result);

	}
	public void DismissAlert(WebDriver driver,WebElement element) {
		Alert Aa= driver.switchTo().alert();
		Aa.dismiss();
		String Actualmsg= element.getText();
		//boolean result= Actualmsg.equalsIgnoreCase(text);
		//System.out.println(result);

	}
	public boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}

	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	public String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}

	public void implicitWait(WebDriver driver,int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void ExplicitWait(WebDriver driver,WebElement element,int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
