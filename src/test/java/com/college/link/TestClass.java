package com.college.link;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @BeforeClass
    public void openBrowser() {
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(alwaysRun = true, description = "create and verify a customer")
    public void testStep1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click='manager()']")));
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click='addCust()']")));
        driver.findElement(By.cssSelector("button[ng-click='addCust()']")).click();

        // pio eukolos aytos o locator "input[ng-model='fName']"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='First Name :']/following-sibling::input")));
        driver.findElement(By.xpath("//label[text()='First Name :']/following-sibling::input")).sendKeys("alex");

        driver.findElement(By.xpath("//label[text()='Last Name :']/following-sibling::input")).sendKeys("galano");

        driver.findElement(By.xpath("//label[text()='Post Code :']/following-sibling::input")).sendKeys("33333");

        driver.findElement(By.xpath("//button[text()='Add Customer']")).click();

        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("button[ng-click='showCust()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='searchCustomer']")));
        driver.findElement(By.cssSelector("input[ng-model='searchCustomer']")).sendKeys("alex");
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='alex']")).isDisplayed());
    }


        @Test(alwaysRun = true, description = "Open Account", dependsOnMethods = "testStep1")
        public void testStep2(){
        driver.findElement(By.cssSelector("button[ng-click='openAccount()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
        new Select(driver.findElement(By.id("userSelect"))).selectByVisibleText("alex galano");

        new Select(driver.findElement(By.id("currency"))).selectByVisibleText("Dollar");

        driver.findElement(By.xpath("//button[text()='Process']")).click();

        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click='showCust()']")));
        driver.findElement(By.cssSelector("button[ng-click='showCust()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='searchCustomer']")));
        driver.findElement(By.cssSelector("input[ng-model='searchCustomer']")).sendKeys("galano");
        String text = driver.findElement(By.xpath("//td[text()='galano']/following-sibling::td[2]/span")).getText();
        Assert.assertTrue(!text.isBlank());
    }

    @Test(alwaysRun = true, description = "make a deposit-verify transaction", dependsOnMethods = "testStep2")
    public void testStep3() throws InterruptedException {

        driver.findElement(By.xpath("//button[text()='Home']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Customer Login']")));
        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
        new Select(driver.findElement(By.id("userSelect"))).selectByVisibleText("alex galano");

        driver.findElement(By.xpath("//button[text()='Login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click='deposit()'")));
        driver.findElement(By.cssSelector("button[ng-click='deposit()'")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='amount']")));
        driver.findElement(By.cssSelector("input[ng-model='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//button[text()='Deposit']")).click();

        driver.findElement(By.cssSelector("button[ng-click='transactions()']")).click();

        Thread.sleep(2000);
        driver.navigate().refresh();  //αυτό το κάνουμε λόγω του bug της εφαρμογήε
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='1000']")).isDisplayed());

    }

    @AfterClass(alwaysRun = true)
    public void close() {
        driver.close();
    }

}




