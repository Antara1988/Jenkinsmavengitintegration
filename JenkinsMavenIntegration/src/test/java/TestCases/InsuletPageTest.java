package TestCases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.BaseClass;
import PageObject.InsuletWindowHandling;

public class InsuletPageTest extends BaseClass{
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest test;

	
	@BeforeTest
	public void setExtent()
	{
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("TesterName","Antara Maiti");
		extent.setSystemInfo("Browser","Chrome");	
	}		
	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser) {

		openBrowser(browser);
		openUrl();

	}
	@AfterMethod(enabled=false)
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()== ITestResult.FAILURE) {
			test.log(Status.FAIL,"Test Case Failed Is "+result.getTestName());
			test.log(Status.FAIL,"Test Case Failed Is "+result.getThrowable());
			
			String screenshotPath=InsuletPageTest.getScreenshot(driver,result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);
			
			
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP,"Test Case Skipped Is "+result.getTestName());
			
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.SKIP,"Test Case passed Is "+result.getTestName());
			
		}		
		driver.quit();
	}
		
	public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		String DateName= new SimpleDateFormat("yyyymmddhhss").format(new Date(0));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String Destination =System.getProperty(("user.dir")+"/Screenshots"+ScreenshotName+DateName+".png");
				File FinalDestination= new File(Destination);
				FileUtils.copyFile(source, FinalDestination);
				return Destination;
		
	}
	
	@Test()
	public void omnipodTest() throws InterruptedException {
		test=extent.createTest("OmniPodTest");
		InsuletWindowHandling In= new InsuletWindowHandling(driver);
		In.omnipodClick();
		In.search();
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();	
	}
	
	
	
	
	
	
}
