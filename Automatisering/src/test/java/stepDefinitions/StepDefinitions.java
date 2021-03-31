package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I have opened the website in my browser")
	public void i_have_opened_the_website_in_my_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.mailchimp.com/signup/");
	}

	@Given("I have entered an {string} address")
	public void i_have_entered_an_address(String email) {
		// find element and sendKeys
		if (email.equals("email")) {
			// email = 'random mail'@mail.com
		} else if (email.equals("")) {
			// send nothing
		}
	}

	@Given("I have also entered a {string} name")
	public void i_have_also_entered_a_name(String username) {
		// find element and sendKeys

		if (username.equals("name")) {
			// name = make random username
		} else if (username.equals("sameName")) {
			// name = same name as above
		} else if (username.equals("longName")) {
			// name = random name with 101 char
		}
	}

	@Given("I have also entered a {string}")
	public void i_have_also_entered_a(String password) {
		// find element and sendKeys
		// password = Abc123&/
	}

	@When("I press Sign up")
	public void i_press_sign_up() {
		// find element and click
	}

	@Then("There should be a {string} on screen")
	public void there_should_be_a_on_screen(String message) {

//		find element
//		
//		assertEquals(String.valueOf(message), ??element.getAttribute("value")?? );
		
		driver.close();
	}

}
