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

    @FindBy(tagName = "h1")
    public WebElement articleTitle;

    @FindBy(xpath = "//*[text()='Table of Content']")
    public WebElement tableOfContent;




}
