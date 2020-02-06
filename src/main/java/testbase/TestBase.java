package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helper.BrowserPropertyReader;

public class TestBase {
	protected WebDriver driver;
	private BrowserPropertyReader browserPropertyReader = new BrowserPropertyReader();

	public static ThreadLocal<WebDriver> localdriver = new ThreadLocal<WebDriver>();
	
	
	
	public void setWebDriver() {
		localdriver.set(driver);
	}
	
	public WebDriver getWebDriver() {
		return localdriver.get();
	}
	
	public void beforeClass(String browserName) {
		
		openBrowser(browserName);
		
		setWebDriver();
		
		getWebDriver().get(browserPropertyReader.getUrl());
		getWebDriver().manage().timeouts().pageLoadTimeout(browserPropertyReader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		getWebDriver().manage().timeouts().implicitlyWait(browserPropertyReader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		getWebDriver().manage().window().maximize();
	}

	private void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserPropertyReader.getBrowserName().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	}
	
	public void afterClass() {
		if (getWebDriver() != null) {
			getWebDriver().close();
		}
	}
}
