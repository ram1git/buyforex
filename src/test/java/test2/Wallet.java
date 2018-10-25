package test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wallet {
	
	public static WebDriver dr;
	public Properties prop;
	public FileInputStream fis;
	
	@BeforeTest
	
	public void before() throws IOException{
		
		
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\requests\\chromedriver.exe");
		dr=new ChromeDriver();*/
		dr=new FirefoxDriver();
		dr.get("https://wallethub.com/profile/test_insurance_company/");
		dr.manage().window().maximize();
		fis=new FileInputStream(System.getProperty("user.dir")+"//or.properties");
		prop=new Properties();
		prop.load(fis);
		
		
	}
	
	
	@Test
	
	
	public void test1() throws InterruptedException{
	    /*dr.findElement(By.xpath("//input[contains(@name,'em')or @placeholder='Email Address']")).sendKeys("qwqwq");
	    dr.findElement(By.xpath("//input[contains(@name,'pw1')or @placeholder='Password']")).sendKeys("dsdd");
	    dr.findElement(By.xpath("//input[contains(@name,'pw2')or @placeholder='Confirm Password']")).sendKeys("fffff");
	    dr.findElement(By.xpath("//span[contains(text(),'Get my free credit score & report')]")).click();
	    dr.findElement(By.xpath("//btn blue touch-element-cl")).click();*/
		Thread.sleep(25000);
		dr.findElement(By.xpath("//i[contains(@class,'af-icon-cross')]")).click();
		Thread.sleep(5000);
	Locatable we=(Locatable)dr.findElement(By.xpath("//div[contains(@class,'wh-rating-choices')]/descendant::div/descendant::a[4][contains(text(),'4')]"));
Coordinates c=	we.getCoordinates();

	EventFiringMouse em=new EventFiringMouse(dr,null);
	em.mouseMove(c);
	
WebElement rt=	dr.findElement(By.xpath("//div[contains(@class,'wh-rating-choices')]/descendant::div/descendant::a[4][contains(text(),'4')]"));
Actions act=new Actions(dr);
act.moveToElement(rt).build().perform();
dr.findElement(By.xpath("html/body/div[3]/div/div[2]/div[3]/a/span")).click();
Thread.sleep(3000);
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[1]/div/div/span[1]")).click();
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[1]/div/ul/li[2]/a")).click();
//dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[2]/div/span[1]/a[3]")).click();
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[3]/textarea")).sendKeys(prop.getProperty("text"));
//dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[2]/div/span[1]/a[3]")).click();
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[3]/div[2]/input")).click();	
Alert al=dr.switchTo().alert();
al.accept();
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[2]/div/span[1]/a[3]")).click();
dr.findElement(By.xpath("html/body/div[2]/main/div/div/div[2]/form/div[3]/div[2]/input")).click();
	}

}
