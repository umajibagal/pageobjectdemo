package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id="loginname")
	private WebElement txtLogin;
	
	@FindBy(id="loginname")
	private WebElement txtPassword;
	
	@FindBy(id="loginname")
	private WebElement btnSubmit;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName,String password) {
		txtLogin.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnSubmit.click();
	}

}
