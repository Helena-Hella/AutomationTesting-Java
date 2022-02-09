package org.atesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test_ST03 {

    public static void main( String[] args ) {

        //сценарий № ST03
        // https://docs.google.com/spreadsheets/d/17vVFh3LsMxSimpUgE6RfR_M9Ien71A6h/edit#gid=1406038737

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // на полный экран
        options.addArguments("--incognito"); // режим инкогнито вкл
        options.addArguments("disable-popup-blocking"); // блокируем всплывающие окна

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // неявное ожидание
        driver.get("https://www.saucedemo.com/");

        // авторизация standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // ложим товар в корзину и удаляем его
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();

        driver.quit(); //закрываем браузер
    }
}
