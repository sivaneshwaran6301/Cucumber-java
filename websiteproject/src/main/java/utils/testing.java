package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.base.CaseFormat;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testing {
	public static Properties prop;
	public static WebDriver driver;
public static void main(String[] args) {
	prop= new Properties();
	try {
		prop.load(new FileInputStream("src/main/java/config/config.properties"));
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	String browser = prop.getProperty("browsername");
	char br = browser.charAt(0);
	switch (br){
	case 'c' :
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case 'e':
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	default:
		System.out.println("no input ");
	
	}
		//Activate chrome driver
//		
//	
//	if(prop.getProperty("browsername").matches("edge")) {
//		//Activate edge driver
//		//	}
}
}
