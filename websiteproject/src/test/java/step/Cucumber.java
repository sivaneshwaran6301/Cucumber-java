package step;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.Purchase;
import pages.Signin;


public class Cucumber extends Base  {

	Signin sg = new Signin();
	Purchase pg = new Purchase();


	@Given("open website")
	public void open_website() {

		sg.openwebsite();
	}

	@When("enter invalid input")
	public void enter_invalid_input() throws IOException {

		sg.invalidsignin();
	}

	@When("enter valid input")
	public void enter_valid_input() throws IOException {

		sg.validsignin();
	}

	@When("click on login button")
	public void click_on_login_button() throws IOException {

		sg.loginbutton();
	}

	@Then("login happens")
	public void login_happens() throws IOException {
		sg.validinput();
	}

	@Then("failed to login")
	public void failed_to_login() throws  IOException {
		sg.invalidinput();	
	}

	@When("search product")
	public void search_product() throws IOException {
		pg.search();


	}
	@When("add to cart and payment")
	public void add_to_cart_and_payment() throws IOException {
		pg.cart();
	}

	@Then("close browser")
	public void close_browser() {
		Test=report.createTest("cart page");
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Cucumber.class);
		log.info("closing browser");
		//closing browser
		driver.quit();
	}
	
	
	
@After
public void end_report() {
	   sg.endreport();
	   System.out.println("hooks works");
	}

}
