import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyGloTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver= new ChromeDriver();
    }

    @Test
    public void increaseAmountOfItemByPlusButton(){
        driver.get("https://shop.myglo.by/catalog/glo-hyper-x2-belo-zolotoy/");
        //div[@class='btn btn--primary']
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='btn btn--primary']")));
        WebElement ageConfirmation = driver.findElement(By.xpath("//div[@class='btn btn--primary']"));
        ageConfirmation.click();
        //input[@class='counter-input js-counter-input']
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='counter-input js-counter-input']")));
        WebElement amountInput = driver.findElement(By.xpath("//input[@class='counter-input js-counter-input']"));
        amountInput.sendKeys(Keys.BACK_SPACE);
        amountInput.sendKeys("4");

        //button[@class='counter-btn counter-plus js-counter-plus']
        WebElement plusButton = driver.findElement(By.xpath("//button[@class='counter-btn counter-plus js-counter-plus']"));
        plusButton.click();
        Assert.assertEquals(amountInput.getAttribute("value"),"5","amount is not 5, its "+amountInput.getAttribute("value"));

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

}
