package calendar.with.skuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calendar_Skuli {
	WebDriver driver;

	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		// driver.close();
	}

	@Test
	public void Calendar_DateTime_Picker() throws FindFailed {
		Screen screen = new Screen();

		Pattern image = new Pattern(
				"D:\\amit\\Java_programs\\SikuliProject\\libs\\calendarwithsklulilibs\\calendarpicker.PNG");
		Pattern image1 = new Pattern(
				"D:\\amit\\Java_programs\\SikuliProject\\libs\\calendarwithsklulilibs\\specificdate.PNG");
		Pattern image2 = new Pattern(
				"D:\\amit\\Java_programs\\SikuliProject\\libs\\calendarwithsklulilibs\\timepicker.PNG");
		Pattern image3 = new Pattern(
				"D:\\amit\\Java_programs\\SikuliProject\\libs\\calendarwithsklulilibs\\specifictime.PNG");

		screen.click(image, 10);
		screen.click(image1, 10);
		screen.click(image2, 10);
		screen.click(image3, 10);
	}

}
