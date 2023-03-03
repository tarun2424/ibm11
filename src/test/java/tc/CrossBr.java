package tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBr {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Software\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Software\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Software\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browser is not correct");
		}
	}	
		@Test
		public void petStoreTC1() throws InterruptedException {
			driver.get("https://petstore.octoperf.com");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Enter")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign In")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@id,'ripe')]")).sendKeys("j2ee");
			driver.findElement(By.xpath("//body/div[@id='Content']/div[@id='Catalog']/form[1]/p[2]/input[2]")).clear();
			Thread.sleep(2000);
			driver.findElement(By.name("password")).sendKeys("j2ee");
			Thread.sleep(2000);
			driver.findElement(By.name("signon")).click();
			Thread.sleep(2000);
			driver.quit();

		}
}
