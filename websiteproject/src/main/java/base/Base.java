package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Report;



public class Base{
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports report = Report.report() ;
	public static ExtentTest Test;

	static Logger log = Logger.getLogger(Base.class);
	public void openwebsite() {
		//setting log4j properties
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		prop= new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/config/config.properties"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//setting the log info for browser
		log.info("opening"+prop.getProperty("browserName")+"browser");
	
		String browser = prop.getProperty("browserName");
		char br = browser.charAt(0);
		switch (br){
		case 'c' :
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case 'e':
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			break;
		default:
			System.out.println("no input ");
		}
		//maximize current window
		driver.manage().window().maximize();

		//load url in browser
		driver.get(prop.getProperty("url"));


	}

	public  void testPass(String report) {
		//Test pass report
		Test.log(Status.PASS, report);
	}
	public void testFail(String report) throws IOException {
		//Test fail report
		Test.log(Status.FAIL, report);
		//Attach fail screenshot in the report
		failScreenShot();
	}

	public  void failScreenShot() throws IOException {
		//Taking failed screenshot 
		File failSs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp =new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		Files.copy(failSs,new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\failscreenshot\\"+timeStamp+".jpg"));
		Test.addScreenCaptureFromPath("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\Screenshots\\failscreenshot\\"+timeStamp+".jpg");
	}
	public static XSSFSheet excel() throws IOException {
		String filelocation = "C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\websiteproject\\src\\resource\\data.xlsx";
		@SuppressWarnings("resource")
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		return sheet;
	}
	
	public void endreport() {
		PropertyConfigurator.configure("src/main/java/config/log4j.properties");
		Logger log = Logger.getLogger(Base.class);

		//using report flush to end report
		report.flush();
		log.info("report ready to view");
	}



}