package loginpage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {

	@Test(dataProvider = "loginTestData")
	public void loginTest1(String userName, String password, String browserName) {
		beforeClass(browserName);
		LoginPage login = new LoginPage(driver);
		login.login(userName, password);
		afterClass();
	}

	@DataProvider(name = "loginTestData",parallel = true)
	public Object[][] getLoginTestData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "stc123";
		data[0][1] = "12345";
		data[0][2] = "chrome";

		data[1][0] = "stc123";
		data[1][1] = "12345";
		data[1][2] = "firefox";

		return data;
	}

}
