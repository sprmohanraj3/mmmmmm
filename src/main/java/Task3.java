import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task3 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace1\\TNQ\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wb = new WebDriverWait(driver, 10);
		WebElement wait = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
		wb.until(ExpectedConditions.visibilityOf(wait));
		wait.click();

		driver.findElement(By.id("email")).sendKeys("rammohanraj12@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Mohanrajece123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

		WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
		wb.until(ExpectedConditions.visibilityOf(women));

		Actions ac = new Actions(driver);
		ac.moveToElement(women).build().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Summer Dresses'][1]")).click();
		driver.findElement(By.xpath("//a[text()='List']")).click();
		Thread.sleep(2000);
		
		
		js.executeScript("window.scrollBy(0,200)");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[2]/h5/a")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
		driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
		
		WebElement m = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
		Select sc = new Select(m);
		sc.selectByIndex(2);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"color_11\"]")).click();
		
		

	}

}
