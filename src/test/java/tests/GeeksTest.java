package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeeksPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.Driver.driver;

public class GeeksTest {

    GeeksPage geeksPage = new GeeksPage();
    String mainPageWH = driver.getWindowHandle();

    @Test
    public void geeksSearchTest() {
        //    The user navigates to GeeksforGeeks.org

        Driver.getDriver().get(ConfigReader.getProperty("ggUrl"));
//    The user enters "linked list" to the search bar.


//    The user hits "Enter"
        geeksPage.searchBox.sendKeys("linked list" + Keys.ENTER);

        ReusableMethods.bekle(3);

//    The user validates "linked list" keyword appears on the result list.
        String expectedResult = "linked list";
        String actualResult = geeksPage.firstElement.getText().toLowerCase();

        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void geeksSearchNegativeTest(){
        Driver.getDriver().get(ConfigReader.getProperty("ggUrl"));
        geeksPage.searchBox.sendKeys("euro 2024" + Keys.ENTER);
        ReusableMethods.bekle(2);
        String expectedResult = "euro 2024";
        String actualResult = geeksPage.firstElement.getText().toLowerCase();

        Assert.assertFalse(actualResult.contains(expectedResult));

    }

    @DataProvider
    public static Object[][] geeksDataProvider(){
        String[][] searchData = {{"da%ta"}, {"py6hon"}, {"data-types"}};
        return searchData;
    }

    @Test(dataProvider = "geeksDataProvider")
    public void geeksSearchSymbolsTest(String keyword){

        Driver.getDriver().get(ConfigReader.getProperty("ggUrl"));
        geeksPage.searchBox.sendKeys(keyword + Keys.ENTER);

        ReusableMethods.bekle(2);

        String expectedResult = keyword;

        Assert.assertFalse(geeksPage.firstElement.getText().toLowerCase().contains(keyword));

    }

    @Test
    public void geeksArticleContentTest(){
//        The user navigates to GeeksforGeeks.org
        Driver.getDriver().get(ConfigReader.getProperty("ggUrl"));
//        The user clicks the first topic title on homepage.
        geeksPage.firstArticle.click();
        ReusableMethods.bekle(1);
//        The user validates the article header contains topic title.
        // String keywordToValidate = geeksPage.firstArticle.getText();
        //S tring titleToCheck = geeksPage.articleTitle.getText();

        // Assert.assertTrue(titleToCheck.contains(keywordToValidate));
//        The user verifies table of content appears.

        String newPageTitle = "Introduction to Tree Data Structure - GeeksforGeeks";
        ReusableMethods.titleIleWindowDegistir(newPageTitle, driver);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", geeksPage.tableOfContent);

        ReusableMethods.bekle(2);
        Assert.assertTrue(geeksPage.tableOfContent.isDisplayed());
    }

    @Test
    public void geeksPositiveSignUpTest() throws IOException {
//        The user navigates to GeeksforGeeks.org
        Driver.getDriver().get(ConfigReader.getProperty("ggUrl"));
//        The user clicks the Sign In button.
        geeksPage.signInButton.click();
        ReusableMethods.bekle(1);
//        The user clicks Sign Up tab.
        geeksPage.signUpTab.click();
//        The user types in email, password and institution information.≈
        geeksPage.emailField.sendKeys(ConfigReader.getProperty("validEmail"));
        geeksPage.passwordField.sendKeys(ConfigReader.getProperty("validPass"));
        geeksPage.organizationsField.sendKeys(ConfigReader.getProperty("validInstitute"));
        ReusableMethods.bekle(1);
        geeksPage.firstOption.click();

        // The user takes screenshot.
        ReusableMethods.getScreenshot("signUp");
//        The user clicks recaptcha.
        driver.switchTo().frame(0);
        geeksPage.reCaptcha.click();
        driver.switchTo().defaultContent();
        ReusableMethods.bekle(2);
//        The user submits the info by clicking Sign Up button.
        geeksPage.signUpSubmitButton.click();
        ReusableMethods.bekle(1);
//        The user validates submission.
        Assert.assertTrue(geeksPage.afterSignUpAlert.isDisplayed());


    }




}
