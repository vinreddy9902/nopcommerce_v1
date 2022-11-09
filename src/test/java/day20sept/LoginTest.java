package day20sept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		// open URL
		driver.get("https://www.saucedemo.com/");
		
		// Enter user name
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		// click on login
		driver.findElement(By.name("login-button")).click();
		
		driver.close();

	}

}
