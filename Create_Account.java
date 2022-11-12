package Automation_Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Account {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container slds-context-bar__button slds-button forceHeaderButton salesforceIdentityAppLauncherHeader')]")).click();
		WebElement view = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click()", view);
		WebElement Acc = driver.findElement(By.xpath("//p[text()='Accounts']"));
		driver.executeScript("arguments[0].click()", Acc);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Guru");
		String name = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");		
		driver.findElement(By.xpath("//label[text()='Ownership']")).click();
		driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String result = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]//a")).getAttribute("title");
		
		if(result.contains(name)) {
			System.out.println("Account Creating Success");
		}
		else {
			System.out.println("Account Not Created");
		}
		
		
		
		

	}

}
