package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	
	public void loadConfig() throws FileNotFoundException {
		
		prop= new Properties();
		FileInputStream fip= new FileInputStream("C:\\Users\\Antara\\eclipse-workspace\\JenkinsMavenIntegration\\Configuration\\Config.properties");
		System.out.println(fip.toString());
		try {
			prop.load(fip);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
	
	public void openBrowser(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if (BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
			
		}
		else if (BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
			
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	public void openUrl() {
		try {
			loadConfig();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("Url"));
		//driver.get("https://www.macys.com/?trackingid=486x887349&m_sc=sem&m_sb=Google&m_tp=Text&m_ac=Google_Trademark&m_ag=GGL_Trademark_Core_Macys_Exact&m_cn=GGL_Trademark_Core_Exact&m_pi=go_cmp-10091130926_adg-102928468058_ad-605549892883_kwd-13122476_dev-c_ext-_prd-&gclid=Cj0KCQjw3a2iBhCFARIsAD4jQB1S37BFJAdisliPHQYSNX2MmSFrCPaiSFJuwmowMP3WzJ4LT-5HjpoaApboEALw_wcB\r\n"
		//		+ "");
	}
	
	
	
}
