package Automation_Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Task {

	public static void main(String[] args) {
		
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("task");
		driver.findElement(By.xpath("//mark[text()='Task']")).click();
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[4]")).click();
		WebElement New = driver.findElement(By.xpath("(//span[@class='slds-truncate']//span)[1]"));
		driver.executeScript("arguments[0].click()", New);
		driver.findElement(By.xpath("//div[contains(@class,'slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right')]//input")).sendKeys("Bootcamp");
		String val = driver.findElement(By.xpath("//div[contains(@class,'slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right')]//input")).getAttribute("value");
		driver.findElement(By.xpath("//a[text()='Not Started']")).click();
		driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String result = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]/a")).getAttribute("title");
		System.out.println(result);
		
		if(val.contains(result)) {
			System.out.println("Task Was Created");
		}
		else{
			System.out.println("Failed");
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
