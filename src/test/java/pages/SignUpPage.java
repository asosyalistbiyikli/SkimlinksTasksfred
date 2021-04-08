package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage extends BasePage{
    public SignUpPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@name='contact']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;
    @FindBy (xpath = "//div[@class='hl-checkbox__tick hl-checkbox--dark']")
    public WebElement checkbox;
    @FindBy (xpath = "//button[@class='hl-button large primary expand']")
    public WebElement signUpButton;
    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement hiMesssage;
    @FindBy(xpath = "//div[@class='hl-field-message hl-field-message--error'][contains(text(),'7 or more characters')]")
    public WebElement passwordErrorMessage;
    @FindBy(xpath = "//div[@class='hl-field-message hl-field-message--error'][contains(text(),'valid email')]")
    public WebElement emailErrorMessage;
    @FindBy(xpath = "//div[@class='hl-field-message hl-field-message--error'][contains(text(),'Field is required')]")
    public WebElement nameErrorMessage;
    @FindBy (xpath = "//button[@class='hl-button large primary expand disabled']")
    public WebElement signUpButtonDisabled;
    @FindBy(xpath = "//div[@class='hl-checkbox__tick hl-checkbox__tick--checked hl-checkbox--dark']")
    public WebElement checkboxSelected;
    @FindBy (xpath = "//div[@class='hl-field-message hl-field-message--error'][contains(text(),'Field is required')][1]")
    public WebElement emailNoInputErrorMessage;


}
