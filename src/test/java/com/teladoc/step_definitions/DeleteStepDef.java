package com.teladoc.step_definitions;

import com.teladoc.pages.MainPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class DeleteStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);

    @Then("user clicks on x button to delete the user")
    public void user_clicks_on_x_button_to_delete_the_user(){
        mainPage.deleteUser(driver);
    }
    @Then("user verifies that user is deleted")
    public void user_verifies_that_user_is_deleted() {
        mainPage.validateDeletedUser(driver);
    }
}
