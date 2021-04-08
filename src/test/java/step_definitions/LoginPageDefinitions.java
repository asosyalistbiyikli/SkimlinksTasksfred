package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.SignUpPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPageDefinitions {
	//I USED JAVA FAKER TO CREATE RANDOM DATA FOR MY TEST
    Faker faker = new Faker();
    SignUpPage signUpPage = new SignUpPage();
    String name = faker.name().firstName();
    String email =faker.internet().emailAddress();
    Actions actions = new Actions(Driver.get());

    @Given("the publisher on the SignUp page")
    public void thePublisherOnTheSignUpPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the publisher SignUp with valid credentials")
    public void thePublisherSignUpWithValidCredentials() {

        signUpPage.nameInput.sendKeys(name);
        signUpPage.emailInput.sendKeys(email);
        signUpPage.passwordInput.sendKeys("123456Ee.");
        signUpPage.checkbox.click();
        BrowserUtils.waitForClickablility(signUpPage.signUpButton,3);
        signUpPage.signUpButton.click();
    }

    @Then("the publisher should see Hi! message")
    public void thePublisherShouldSeeHiMessage() {
        Assert.assertTrue(signUpPage.hiMesssage.isDisplayed());
    }

    @When("the publisher SignUp with invalid password credential")
    public void thePublisherSignUpWithInvalidPasswordCredential() {
        signUpPage.nameInput.sendKeys(name);
        signUpPage.emailInput.sendKeys(email);
        signUpPage.passwordInput.sendKeys("123456Ee");
        signUpPage.checkbox.click();
    }

    @Then("the publisher should see password error message")
    public void thePublisherShouldSeePasswordErrorMessage() {
        Assert.assertTrue(signUpPage.passwordErrorMessage.isDisplayed());
    }

    @And("the SignUp should not be clickable")
    public void theSignUpShouldNotBeClickable() {
        Assert.assertTrue(signUpPage.signUpButtonDisabled.isDisplayed());
    }

    @When("the publisher SignUp with invalid email credential")
    public void thePublisherSignUpWithInvalidEmailCredential() throws InterruptedException {
        signUpPage.nameInput.sendKeys(name);
        signUpPage.emailInput.sendKeys("email");
        signUpPage.passwordInput.sendKeys("123456Ee.");
        //I USED DOUBLE CLICK FROM ACTIONS CLASS FOR TO AVOID GOOGLE CAPTHCA
        actions.doubleClick(signUpPage.checkbox).perform();
        BrowserUtils.waitForClickablility(signUpPage.checkbox,5);
        signUpPage.checkbox.click();
    }

    @Then("the publisher should see email error message")
    public void thePublisherShouldSeeEmailErrorMessage() {
        Assert.assertTrue(signUpPage.emailErrorMessage.isDisplayed());
    }

    @And("the publisher does not accept privacy policy")
    public void thePublisherDoesNotAcceptPrivacyPolicy() {
        signUpPage.checkboxSelected.click();
    }

    @When("the publisher SigUp with no credentials")
    public void thePublisherSigUpWithNoCredentials() {
        signUpPage.nameInput.sendKeys("");
        signUpPage.emailInput.sendKeys("");
        signUpPage.passwordInput.sendKeys("");
        //I USED DOUBLE CLICK FROM ACTIONS CLASS FOR TO AVOID GOOGLE CAPTHCA
        actions.doubleClick(signUpPage.checkbox).perform();
        BrowserUtils.waitForClickablility(signUpPage.checkbox,5);
        signUpPage.checkbox.click();
    }

    @Then("the publisher should see error messages")
    public void thePublisherShouldSeeErrorMessages() {
        Assert.assertTrue(signUpPage.nameErrorMessage.isDisplayed());
        Assert.assertTrue(signUpPage.emailNoInputErrorMessage.isDisplayed());
        Assert.assertTrue(signUpPage.passwordErrorMessage.isDisplayed());
    }

    @When("the publisher enters valid credentials")
    public void thePublisherEntersValidCredentials() throws InterruptedException {
        signUpPage.nameInput.sendKeys(name);
        signUpPage.emailInput.sendKeys(email);
        signUpPage.passwordInput.sendKeys("123456Ee.");
        Thread.sleep(3000);
        //I USED DOUBLE CLICK FROM ACTIONS CLASS FOR TO AVOID GOOGLE CAPTHCA
        actions.doubleClick(signUpPage.checkbox).perform();
        BrowserUtils.waitForClickablility(signUpPage.checkbox,5);
        signUpPage.checkbox.click();
    }
}
