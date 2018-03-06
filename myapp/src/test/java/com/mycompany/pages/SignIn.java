package com.mycompany.pages;

import com.mycompany.utils.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    WebDriver driver;

    @FindBy(id="identifierId")
    private WebElement username;

    @FindBy(xpath="//span[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement password;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void userLogin(String email, String pwd) {
        username.sendKeys(email);
        nextButton.click();
        password.sendKeys(pwd);
        WebDriverUtility.waitFor(2);
        nextButton.click();
    }

}
