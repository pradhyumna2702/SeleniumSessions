package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"/Users/SPS/eclipse-workspace/SeleniumAssignment/src/main/java/com/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {

		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/SPS/Downloads/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/SPS/Downloads/chromedriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

	}

}
