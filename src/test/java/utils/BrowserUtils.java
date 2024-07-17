package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {


    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        switch (methodName) {
            case "visibleText":
                select.selectByVisibleText(value);
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;

            default:
                System.out.println("Please choose correct select method");
        }

    }

    public static void click(WebDriver driver, WebElement element) {


        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException | NoSuchElementException e) {

            System.err.println("Exception occurred while attempting to click on an element " + e.getMessage());

        }

    }

    public static void sendKeys(WebDriver driver, WebElement element, String keys) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(keys);

        }catch (ElementNotInteractableException | NoSuchElementException e){
            System.err.println("Exception occurred when attempting to send keys" + e.getMessage());
        }

    }

    public static String getText(WebDriver driver, WebElement element){
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            text= wait.until(ExpectedConditions.visibilityOf(element)).getText();
        }catch (NoSuchElementException e){
            System.err.println("no text visible" + e.getMessage());
        }
        return text;
    }


}
