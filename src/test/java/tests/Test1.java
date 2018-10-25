package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testbase.Base1;

public class Test1 extends Base1 {

	public static WebDriver dr;
	public static WebDriverWait w;

	@BeforeTest(alwaysRun = true)
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\requests\\chromedriver1.exe");
		dr=new ChromeDriver();
	//	dr = new FirefoxDriver();
		dr.get("http://staging.buyforexonline.com/admin");
		dr.manage().window().maximize();
		w=new WebDriverWait(dr,10);

	}

	@Test(alwaysRun = true)
	public void test1() {

		System.out.println("first test");

	}

	@Test(dataProvider = "dp",priority=1)
	public void test2(String username, String password, String runmode) {
	

		dr.findElement(
				By.xpath("//input[contains(@id,'YumUserLogin_username')]"))
				.sendKeys(username);
		dr.findElement(
				By.xpath("//input[contains(@id,'YumUserLogin_password')]"))
				.sendKeys(password);
		/*dr.findElement(
				By.xpath("//input[contains(@id,'YumUserLogin_username')]"))
				.clear();
		dr.findElement(
				By.xpath("//input[contains(@id,'YumUserLogin_password')]"))
				.clear();*/

		 dr.findElement(By.xpath("//input[contains(@name,'yt0')]")).click();

	}

	@DataProvider
	public String[][] dp() {
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData2");
		return testRecords;

	}
	
	
	@Test(priority=2,dependsOnMethods="test2")
	
	public void test3( ){
		
	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Admin')]"))).click();	
		
	}

}
