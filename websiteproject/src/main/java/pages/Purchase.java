package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import base.Base;

public class Purchase extends Base {

	@FindBy(xpath="//span[@class='_10Ermr']//span[1]")
	WebElement search;

	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	WebElement placeOrd;

	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]")
	WebElement cart;

	public void search() throws IOException {
		Test=report.createTest("search page");
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Purchase.class);
		PageFactory.initElements(driver,this);
		try {

			//searching product
			driver.findElement(By.className("_3704LK")).sendKeys(Base.excel().getRow(1).getCell(2).getStringCellValue());
			driver.findElement(By.className("L0Z3Pu")).submit();
			//taking search pg screenshot 
			File searchPg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(searchPg,new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\searchPage.jpg"));

			//Explicit wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(search));
			//getting string values for assert
			String prdAss= search.getText();
			if(prdAss.contains("mobiles")) {
				testPass("product search verified ");
				log.info("search page pass");
			}else {
				testFail("searched product is not shown");
				log.info("search page fail");
			}
			
			Assert.assertEquals(prdAss, "mobiles");
			//Selecting product
			String tb = Keys.chord(Keys.CONTROL,Keys.ENTER);
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a")).sendKeys(tb);

			//store window ids in array list
			ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
			//switch to active tab
			driver.switchTo().window(wid.get(1));  

			String window2= driver.getWindowHandle();
			System.out.println(window2);
		}
		catch (Exception e) {
			testFail(e.getMessage());
			log.warn("error in search page source code");
		}
	}
	public void cart() throws IOException {
		Test=report.createTest("cart page");
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Purchase.class);
		try {

			PageFactory.initElements(driver,this);

			//Taking cart page screenshot 
			File crtPg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(crtPg,new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\cartPage.jpg"));

			//		String window2= driver.getWindowHandle();
			//		System.out.println(window2);
			//page down using actions
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			//Explicit wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			//clicking cart button
			wait.until(ExpectedConditions.visibilityOf(cart));

			cart.click();
			//clicking place order button
			wait.until(ExpectedConditions.visibilityOf(placeOrd));
			placeOrd.click();

			testPass("cart page verified");
			log.info("cart page is verified");
		}
		catch (Exception e) {
			testFail(e.getMessage());
			log.warn("error in cart page source code ");
		}
	}
}
