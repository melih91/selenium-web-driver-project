package com.smugmug.cucumber_project;

import cucumber.api.java.en.*;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefinition {

    WebDriver driver;

    @Given("^Smugmug WebSitesine Gidilir$")
    public void smugmug_WebSitesine_Gidilir() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");

        System.out.println("Going to smugmug.com" );
        driver = new ChromeDriver();
        driver.navigate().to("https://www.smugmug.com/");
    }
    
    @When("^Login Sayfasına Gidilir$")
    public void login_Sayfasına_Gidilir() throws Throwable {
    	 System.out.println("Login Sayfasina Gidilir." );
         driver.findElement(By.xpath("//*[@id='sm-marketing-right-header']/ul/li[3]/div/a")).click();
    }
    @When("^Kullanici adi ve Sifre Girilir$")
    public void kullanici_adi_ve_Sifre_Girilir() throws Throwable {
    	driver.findElement(By.name("username")).sendKeys("*****@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("*****");
        driver.findElement(By.xpath("//*[@id='sm-page-content']/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/form/div[4]/button")).click();
        Thread.sleep(1600);
    }

	@Then("^Fotograf Paylasim Ekranina Gidilir$")
	public void fotograf_Paylasim_Ekranina_Gidilir() throws Throwable {
		 driver.findElement(By.xpath("//*[@id='sm-page-content']/div/div[2]/div[3]/div/div")).click();
	     Thread.sleep(1600);
	     driver.findElement(By.xpath("//*[@id='sm-getting-started-container']/div/button")).click(); 
	    
	}
	@Then("^Fotograf Yuklenir\\.$")
	public void fotograf_Yuklenir() throws Throwable {
		 driver.findElement(By.xpath("//*[@id='sm-getting-started-container']/div/div[1]/div/div/div[2]/div/div/div/div[1]/div/div/h3/button")).click();
	     StringSelection ss = new StringSelection("C:\\Users\\Admin\\Desktop\\fotograf.jpg");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     Robot robot = new Robot();
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	@Then("^Fotograf Yukleme Basarili Sekilde Gerceklesmistir\\.$")
	public void fotograf_Yukleme_Basarili_Sekilde_Gerceklesmistir() throws Throwable {
	    Thread.sleep(10000);
		driver.quit();
	}
}
