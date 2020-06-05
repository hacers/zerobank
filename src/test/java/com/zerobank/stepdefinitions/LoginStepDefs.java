package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }


    @When("the user enter the valid {string} and {string}")
    public void the_user_enter_the_valid_and(String username, String password) {
        BrowserUtils.waitFor(2);
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get(username), ConfigurationReader.get(password));
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle);
    }
    @Then("the title contains")
    public void the_title_contains(String title) {
        System.out.println("expectedTitle = " + title);
        Assert.assertTrue(Driver.get().getTitle().contains(title));
    }
    @When("the user enter the invalid {string} and {string}")
    public void the_user_enter_the_invalid_and(String username,String password) {
        BrowserUtils.waitFor(3);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }
    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
    }

    @Then("the error message is displayed")
    public void the_message_is_displayed(String error) {
        System.out.println("errorMessage = " + error);
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.error.getText().contains(error));
    }



}
