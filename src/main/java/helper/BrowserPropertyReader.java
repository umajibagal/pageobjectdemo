package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserPropertyReader {
	Properties property;

	
	
	public BrowserPropertyReader() {
		property = new Properties();

		FileInputStream fs=null;
		try {
			fs = new FileInputStream(new File("src/main/resources/configs/browser.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowserName() {
		return property.getProperty("browserName");
	}
	public String getUrl() {
		return property.getProperty("url");
	}

	public int getImplicitWait() {
		return Integer.parseInt(property.getProperty("implicitWait"));
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(property.getProperty("pageLoadTimeOut"));
	}

}
