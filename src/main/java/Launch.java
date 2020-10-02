import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launch {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace1\\TNQ\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wb = new WebDriverWait(driver, 10);
		WebElement wait = driver.findElement(By.xpath("//div[@id='contact-link']/a"));
		wb.until(ExpectedConditions.visibilityOf(wait));

		wait.click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		if (title.equals("Contact us - My Store")) {
			WebElement subHead = driver.findElement(By.xpath("//select[@id='id_contact']"));
			Select sc = new Select(subHead);
			sc.selectByIndex(2);
			driver.findElement(By.xpath("//input[@class='form-control grey validate']"))
					.sendKeys("rammohanraj12@gmail.com");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);

			/*
			 * File f = new File("C:\\Users\\HP\\Downloads\\check leaf.jpg"); try {
			 * 
			 * Robot r=new Robot(); StringSelection selection=new
			 * StringSelection(f.getAbsolutePath());
			 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
			 * null); r.keyPress(KeyEvent.VK_CONTROL); r.keyPress(KeyEvent.VK_V);
			 * r.setAutoDelay(3000); r.keyRelease(KeyEvent.VK_CONTROL);
			 * r.keyRelease(KeyEvent.VK_V);
			 * 
			 * r.keyPress(KeyEvent.VK_ENTER); r.keyRelease(KeyEvent.VK_ENTER); } catch
			 * (AWTException e) { e.printStackTrace(); }
			 */

			//WebElement addFile = driver.findElement(By.xpath("//input[@type='file']//following::span[2]"));
			WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
			//addFile.click();
			addFile.sendKeys("C:\\Users\\HP\\Downloads\\check leaf.jpg");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='form-group'][1]/textarea"))
					.sendKeys("Hi this is mohanraj i am intrested in this position");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
		}

		driver.quit();

	}

}
