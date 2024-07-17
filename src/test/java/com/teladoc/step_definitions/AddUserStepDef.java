package com.teladoc.step_definitions;

import com.teladoc.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddUserStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);

    @Given("user is on main page of way2automation web app")
    public void user_is_on_main_page_of_way2automation_web_app() {
        System.out.println(driver.getTitle());
    }
    @When("user clicks on add user button window modal is visible")
    public void user_clicks_on_add_user_button_window_modal_is_visible() {
            mainPage.clickOnAddUserButton(driver);
    }
    @When("user adds a user with the following details {string} {string} {string} {string} {string} {string} {string}")
    public void user_adds_a_user_with_the_following_details(String firstName, String lastName, String username,
                                                            String password,  String role, String email, String cellphone) {

        mainPage.createUser(driver,firstName, lastName, username, password, role, email, cellphone);


    }
    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {

        mainPage.clickOnSaveButton(driver);

    }
    @Then("user validates test account ont the table")
    public void user_validates_test_account_ont_the_table() {

        mainPage.validateTestUser(driver);

    }



}
