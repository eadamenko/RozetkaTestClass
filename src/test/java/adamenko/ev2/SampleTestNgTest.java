package adamenko.ev2;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import adamenko.ev2.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }
  
  @Test
  public void MainTest() {
    driver.get(baseUrl);
    homepage.clickSmartphoneAndElectronicCategory();
    homepage.clickCategoryFilterByIndex(1); //phone categoty
    homepage.clickCategoryFilterByIndex(1); //smartphone category
    Assert.assertTrue(homepage.isSmartphoneCategoryApplied(), "Smartphone category applied");

    for (int i = 0; i < 3; i++) {
      homepage.getTopItemData();
      homepage.clickNextPage();
    }
    Assert.assertTrue(homepage.isNotOverThreeTopItemOnPage(), "Not over three TopItems on page");
  }
  
}
