package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class StepDefinitions {

	private WebDriver driver;
	private Date date = new Date();
	private DateFormat df = new SimpleDateFormat("yyyyMMdd");
	private String todaysDate = df.format(date);

	@Given("I have opened the website in my browser")
	public void i_have_opened_the_website_in_my_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.mailchimp.com/signup/");
	}

	@Given("I have entered an {string} address")
	public void i_have_entered_an_address(String email) {
		WebElement emailInput = driver.findElement(By.id("email"));

		if (email.equals("email")) {
			emailInput.sendKeys(makeRandomString(5) + "@mail.com");
		} else if (email.equals("noEmail")) {
			// send nothing, clear to be sure it's empty
			emailInput.clear();
		}
	}

	@Given("I have also entered a {string}")
	public void i_have_also_entered_a_name(String username) {
		WebElement nameInput = driver.findElement(By.id("new_username"));

		if (username.equals("randomName")) {
			nameInput.sendKeys(makeRandomString(10) + todaysDate);
		} else if (username.equals("commonName")) {
			nameInput.sendKeys("username");
		} else if (username.equals("longName")) {
			nameInput.sendKeys(makeRandomString(101));
		}
	}

	@Given("I have also entered a password")
	public void i_have_also_entered_a_password() {
		// Password needs 8-50 char: lowercase + uppercase + number + special

		WebElement passwordInput = driver.findElement(By.id("new_password"));
		passwordInput.sendKeys("Abc123&/");
	}

	@When("I press Sign up")
	public void i_press_sign_up() {
		WebElement signUpButton = driver.findElement(By.id("create-account"));
		signUpButton.submit();
	}

	@Then("There should be a {string} on screen")
	public void there_should_be_a_on_screen(String result) {
		WebElement resultOnScreen;

		if (result.equals("Check your email")) {
			resultOnScreen = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));
			resultOnScreen = driver.findElement(By.tagName("h1"));
		} else {
			resultOnScreen = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.className("invalid-error")));
		}

		assertEquals(String.valueOf(result), resultOnScreen.getAttribute("textContent"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public String makeRandomString(int length) {
		String randomString = "";
		Random r = new Random();
		char c = ' ';
		int select;

		for (int i = 0; i < length; i++) {
			select = (int) (Math.random() * 2) + 1;
			if (select == 1) {
				c = (char) (r.nextInt(26) + 'a');
			} else if (select == 2) {
				c = (char) (r.nextInt(10) + '0');
			}
			randomString += c;
		}

		return randomString;
	}

}
