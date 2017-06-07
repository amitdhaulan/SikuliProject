package test.sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class SikuliTesting {
	public static WebElement element;

	public static void main(String[] args) throws FindFailed {
		Screen screen = new Screen();

		Pattern image = new Pattern("D:\\amit\\Java_programs\\SikuliProject\\libs\\testiungskulilibs\\gmail.PNG");
		Pattern image1 = new Pattern("D:\\amit\\Java_programs\\SikuliProject\\libs\\testiungskulilibs\\signin.PNG");
		/*
		 * Pattern image2 = new
		 * Pattern("D:\\amit\\Java_programs\\SikuliProject\\libs\\uname.PNG");
		 * Pattern image3 = new
		 * Pattern("D:\\amit\\Java_programs\\SikuliProject\\libs\\password.PNG")
		 * ; Pattern image4 = new
		 * Pattern("D:\\amit\\Java_programs\\SikuliProject\\libs\\next.PNG");
		 */
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		/* screen.wait(image, 10); */

		screen.click(image, 10);
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("------------------->" + winHandle);
			driver.switchTo().window(winHandle);
		}

		screen.click(image1, 10);
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("------------------->" + winHandle);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
			driver.switchTo().window(winHandle);
		}

		// Using sikuli.
		/*
		 * screen.type(image2, "amitkumar025@gmail.com", 10);
		 * screen.click(image4, 10);
		 */

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("//input[@id='identifierId']"));
		element.sendKeys("amitkumar025");

		By by = By.xpath("//span[.='Next']");
		by.findElement(element).click();

		
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		
		element.sendKeys("<>");

		by.findElement(element).click();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Inbox (6) - amitkumar025@gmail.com - Gmail");

	}
}
