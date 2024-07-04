package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeeksPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class GeeksTest {

    GeeksPage geeksPage = new GeeksPage();

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
//        The user verifies table of content appears.
    }




}
