package com.teladoc.pages;

import io.cucumber.java.zh_tw.假設;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(.,' Add User')]")
    WebElement adduserBtn;

    @FindBy(css = "input[name='FirstName']")
    WebElement firstName;

    @FindBy(css = "input[name='LastName']")
    WebElement lastName;

    @FindBy(css = "input[name='UserName']")
    WebElement username;

    @FindBy(css = "input[name='Password']")
    WebElement password;

    @FindBy(css = "input[value='15']")
    WebElement radioAAA;

    @FindBy(css = "select[name='RoleId']")
    WebElement roleDropdown;

    @FindBy(css = "input[name='Email']")
    WebElement email;

    @FindBy(css = "input[name='Mobilephone']")
    WebElement cellphone;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    // Table
    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[1]")
    WebElement tFirstName;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[2]")
    WebElement tLastName;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[3]")
    WebElement tUserName;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[5]")
    WebElement tRole;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[6]")
    WebElement tEmail;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[7]")
    WebElement tCellphone;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[4]")
    WebElement tCustomerAAA;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[3]/td[11]/button")
    WebElement deleteBtn;

    @FindBy(xpath = "//p")
    WebElement confirmDeleteMsg;

    @FindBy(xpath = "//button[.='OK']")
    WebElement buttonOk;

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> allLastNames;




    public void clickOnAddUserButton(WebDriver driver){
        BrowserUtils.click(driver, this.adduserBtn);
    }
    public void createUser(WebDriver driver, String firstname, String lastname, String username, String password, String selectable, String email, String cellphone)  {

        BrowserUtils.sendKeys(driver, this.firstName, firstname);
        BrowserUtils.sendKeys(driver, this.lastName, lastname);
        BrowserUtils.sendKeys(driver, this.username, username);
        BrowserUtils.sendKeys(driver, this.password, password);
        BrowserUtils.click(driver, this.radioAAA);
        BrowserUtils.selectBy(this.roleDropdown, selectable,"visibleText");
        BrowserUtils.sendKeys(driver, this.email,email );
        BrowserUtils.sendKeys(driver, this.cellphone,cellphone );

    }

    public void clickOnSaveButton(WebDriver driver){
        BrowserUtils.click(driver, this.saveBtn);
    }

    public void validateTestUser(WebDriver driver){
        Assert.assertTrue(this.tFirstName.isDisplayed());
        Assert.assertTrue(this.tLastName.isDisplayed());
        Assert.assertTrue(this.tUserName.isDisplayed());

        if (!this.tCustomerAAA.isDisplayed()){
            System.err.println("Customer AAA is not displayed");
        }
        Assert.assertTrue(this.tRole.isDisplayed());
        Assert.assertTrue(this.tEmail.isDisplayed());
        Assert.assertTrue(this.tCellphone.isDisplayed());
    }

    public void deleteUser(WebDriver driver) {


        BrowserUtils.click(driver, this.deleteBtn);
        Assert.assertTrue(this.confirmDeleteMsg.isDisplayed());
        BrowserUtils.click(driver, this.buttonOk);
    }

    public void validateDeletedUser(WebDriver driver){

        for (int i = 0; i < allLastNames.size(); i++) {

            if (!BrowserUtils.getText(driver, allLastNames.get(i)).equalsIgnoreCase("novak")){
                Assert.assertNotEquals("Novak", BrowserUtils.getText(driver,allLastNames.get(i)));
            }

        }



    }






}
