package util;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.Pages.BasePage;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;
	
	
	public static void config() {
		try {
	InputStream input = new FileInputStream("src\\main\\java\\config\\Config.properties");
	Properties prop = new Properties();
	prop.load(input);
	browser=prop.getProperty("browser");
	url=prop.getProperty("url");
	
	}catch(IOException e){
		e.printStackTrace();
		}
	}
	//BeforeClass
	public static WebDriver init() {
		config();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
			}
	
	@AfterClass
	public static void tearDowm() {
		driver.close();
		driver.quit();
	}

}
