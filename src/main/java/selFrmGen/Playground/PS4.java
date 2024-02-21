package selFrmGen.Playground;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PS4  {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rc03989\\OneDrive - Ryan LLC\\Documents\\Vikas\\PP-Se\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://www.example.com");

            // Adds the cookie into current browser context
            driver.manage().addCookie(new Cookie("key", "value"));
        } finally {
            driver.quit();
        }
    }
}


//driver.manage().addCookie(new Cookie("foo", "bar"));
//Cookie cookie1 = driver.manage().getCookieNamed("foo");
//System.out.println(cookie1);
//driver.manage().addCookie(new Cookie("test2", "cookie2"));
//Set<Cookie> cook = driver.manage().getCookies();
//System.out.println(cook);
