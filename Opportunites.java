package Automation_Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunites {

	public static void main(String[] args) throws InterruptedException {
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
		WebElement Opp = driver.findElement(By.xpath("//p[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", Opp);
		driver.findElement(By.xpath("(//a[@title='New']//div)[1]")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Guru");
		String verify = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='19']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String result = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]//a")).getAttribute("title");
		
		if(result.contains(verify)) {
			System.out.println("Opportunity "+result+" Was Created");
		}
		else {
			System.out.println("Failed");
		}
		Thread.sleep(2000);
			driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
