package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GeeksPage {

    public GeeksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='HomePageSearchContainer_homePageSearchContainer_container_input__1LS0r']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@class='SearchModalArticleCard_searchModalArticleCard_content_heading__hB4a_']")
    public WebElement firstElement;

    @FindBy(xpath = "(//span[@title])[1]")
    public WebElement firstArticle;

    @FindBy(xpath = "(//h1)[1]")
    public WebElement articleTitle;

    @FindBy(xpath = "//*[text()='Table of Content']")
    public WebElement tableOfContent;

    @FindBy(xpath = "//button[@class='signinButton gfg_loginModalBtn']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[text()='Sign Up']")
    public WebElement signUpTab;

    @FindBy(xpath = "//*[text()='An email has been sent to your given address. Please click the link in the mail to continue.']")
    public WebElement afterSignUpAlert;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Institutes/Organizations']")
    public WebElement organizationsField;

    @FindBy(xpath = "//*[@class='rc-anchor-logo-img rc-anchor-logo-img-portrait']")
    public WebElement reCaptcha;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signUpSubmitButton;

    @FindBy(xpath = "//*[@class='optionItem']")
    public WebElement firstOption;




}
