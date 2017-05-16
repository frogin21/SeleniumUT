/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newseleniumtest;

import static bsh.Console.main;
import static bsh.Remote.main;
import static com.mycompany.newseleniumtest.Main.main;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author rahmatzailani
 */
public class coba {
    

    public  void latihan (String browser) throws InterruptedException {
       //Instantiate the webdriver object:
WebDriver driver= new FirefoxDriver();
JavascriptExecutor jse = (JavascriptExecutor)driver;


//Open the web
driver.get ("http://dev.uangteman.com/admin/");
driver.manage().window().maximize();

 Thread.sleep(1500);
driver.findElement(By.name("bu_name")).sendKeys("rahmat_cs");
driver.findElement(By.name("bu_passwd")).sendKeys("testing");
driver.findElement(By.cssSelector("button[class='btn btn-orange btn-squared pull-right ladda-button']")).click();

Thread.sleep(2500);
jse.executeScript("window.scrollBy(0,1500)", "");
jse.executeScript("window.scroll(0,1500)", "");

WebElement scroll = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/form/table/tbody/tr[1]/td[12]/span"));
JavascriptExecutor js = (JavascriptExecutor)driver; 
jse.executeScript(
    "document.getElementByxpath('/html/body/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/form/table/tbody/tr[1]/td[12]/span').scrollLeft += 250", "");

//Get page title in selenium webdriver
String actual=driver.getTitle();

}
}


