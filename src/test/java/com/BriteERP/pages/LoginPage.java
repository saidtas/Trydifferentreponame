package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver= Driver.getDriver();

    private WebDriverWait wait = new WebDriverWait(driver , 10) ;


    @FindBy(id="login")
    public WebElement usernameElement;

    @FindBy(name ="password")
    public WebElement passwordElement ;

    @FindBy(css="button[type='submit']")
    public WebElement loginButtonElement;

    @FindBy(css="[class='alert alert-danger']")
    public WebElement errorMessageElement;


    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }


}
