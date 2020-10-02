import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Capture {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace1\\TNQ\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php?controller=contact");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wb = new WebDriverWait(driver, 10);
		WebElement wait = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		wb.until(ExpectedConditions.visibilityOf(wait));

		String title = driver.getTitle();
		if (title.equals("Contact us - My Store")) {

			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\Users\\HP\\eclipse-workspace1\\TNQ\\src\\screen shots.png"));
		}
		driver.quit();

	}
}