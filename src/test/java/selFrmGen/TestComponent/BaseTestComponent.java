package selFrmGen.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import selFrmGen.PageObjects.LoginPage;

//import pages.LoginPage;

public class BaseTestComponent {
	
	public WebDriver driver;
	public selFrmGen.PageObjects.LoginPage login; 

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\selFrmGen\\Resources\\GlobalData.properties");
//		\\src\\main\\java\\selFrmGen\\Resources\\GlobalData.properties
//		\\src\\resources\\GlobalData.properties
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod (alwaysRun=true)//@BeforeTest 
	public LoginPage launchApp() throws IOException {
		driver = initializeDriver();
		login = new LoginPage(driver); //Creating object of LoginPage
		login.goTo();
		return login;
	}
	
	@AfterMethod (alwaysRun=true)//@AfterTest 
	public void closeBrowser() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), //System.getProperty("user.dir")+"\\src\\data\\login.json" 
				StandardCharsets.UTF_8);
		
		//String to HashMap using Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		//{map, map}
		return data;
	}
}
