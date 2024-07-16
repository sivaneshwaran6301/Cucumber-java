package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import base.Base;

public class Signin extends Base {

	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement Email;

	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement Password;

	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement Login;


	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div[1]/div/div")
	WebElement validAss;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]")
	WebElement invalidAss;



	public void validsignin() throws IOException {
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Signin.class);
		try {
			//clicking login button after cancel 
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			driver.findElement(By.className("uiU-ZX")).submit();
		}
		catch (Exception e) {
			//clicking login button
			driver.findElement(By.className("uiU-ZX")).click();
		}
		System.out.println(driver.findElement(By.className("_36KMOx")).getText());
		//entering userid
		Email.sendKeys(prop.getProperty("username"));
		//System.out.println(Base.excel().getRow(2).getCell(1).getStringCellValue());
		byte[] pass= Base64.decodeBase64(Base.excel().getRow(1).getCell(1).getStringCellValue());
		//UG9pbnRicmVha2VyQA==
		//entering password
		Password.sendKeys(new String(pass));
		log.info("entering valid input in signin page");

	}
	public void invalidsignin() throws IOException {
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Signin.class);
		try {
			//clicking login button after cancel 
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			driver.findElement(By.className("_1_3w1N")).submit();
		}
		catch (Exception e) {
			//clicking login button
			driver.findElement(By.className("_1_3w1N")).click();
		}


		//entering userid
		Email.sendKeys(prop.getProperty("username"));


		byte[] pass= Base64.decodeBase64(Base.excel().getRow(2).getCell(1).getStringCellValue());
		//entering password
		Password.sendKeys(new String(pass));
		System.out.println(new String(pass));
		log.info("entering invalid input in signin page");
	}

	public void loginbutton() {
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		//clicking login button
		Login.click();
		Logger log = Logger.getLogger(Base.class);
		log.info("clicking login button");
	}

	public void validinput() throws IOException {
		Test=report.createTest("Signin page with valid input");
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Signin.class);
		try {
			PageFactory.initElements(driver,this);
			//Explicit wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(validAss));
			String validass=validAss.getText();
		
			//taking signin page screenshot
			File signIn=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(signIn,new File( "C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\signIn.jpg"));
			
			if(validass.contains("My Account")) {
				testPass("login pass for valid input ");
				log.info("login pass for valid input");
			}
			else {
				testFail("fail due to invalid assert");
				log.info("fail due to invalid assert in valid input");
			}
		}
		catch (Exception e) {

			testFail(e.getMessage());
			log.warn("error in valid input source code");
		}
	}
	public void invalidinput() throws IOException {
		Test=report.createTest("Signin page with invalid input");
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Signin.class);
		try {
			PageFactory.initElements(driver,this);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			//Explicit wait
			wait.until(ExpectedConditions.visibilityOf(invalidAss));

			String invalidass=invalidAss.getText();
			//Taking signin page screenshot
			File signInvalid = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(signInvalid,new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\signInvalid.jpg"));
			if(invalidass .contains("Your username or password is incorrect")) {

				testPass("login pass for invalid input");
				log.info("login pass for invalid input");
			}
			else {
				testFail("fail due to invalid assert");
				log.info("fail due to invalid assert");
			}
		}
		catch (Exception e) {
			testFail(e.getMessage());
			
			log.warn("error in invalid input source code");
		}

	}

}