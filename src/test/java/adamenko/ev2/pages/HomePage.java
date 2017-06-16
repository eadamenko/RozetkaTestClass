package adamenko.ev2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(xpath = "//li[@menu_id= '3361']/a")
  public WebElement smartphoneAndElectronicCategory2;

  By smartphoneCategoryFilterApplied = By.xpath("//li[@class= 'filter-active-i pos-fix']//a[contains(@onclick, '80003')]");

  By topSalesBadgeItems = By.xpath("//div[child::i[contains (@class, 'g-tag-icon-middle-popularity')]]/../..");

  By itemNames = By.xpath("./div[contains(@class, 'g-i-tile-i-title')]");

  By itemPrice = By.xpath(".//div[@class= 'g-price-uah']");

  @FindBy(xpath = "//li[contains(@class, 'pos-fix active')]/following-sibling::li[1]")
  public WebElement nextPageButton;

  public HomePage(WebDriver driver) {
    super(driver);
  }


  public void clickSmartphoneAndElectronicCategory() {
    Actions action = new Actions(driver);
    action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(smartphoneAndElectronicCategory2))).click().click().perform();
  }

  public void clickCategoryFilterByIndex(int index) {
    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[@class= 'm-cat-l-i-title-link'])[" + index + "]")))).click();
  }

  public boolean isSmartphoneCategoryApplied() {
    return driver.findElement(smartphoneCategoryFilterApplied).isDisplayed();
  }

  public void getTopItemData() {
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topSalesBadgeItems));
    List<WebElement> itemList = driver.findElements(topSalesBadgeItems);
    for (int i = 0; i < itemList.size(); i++) {
      System.out.println(itemList.get(i).findElement(itemNames).getText());
      System.out.println(itemList.get(i).findElement(itemPrice).getText());
    }
  }

  public boolean isNotOverThreeTopItemOnPage() {
    return driver.findElements(topSalesBadgeItems).size() <= 3;
  }

  public void clickNextPage() {
    Actions action = new Actions(driver);
    action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(nextPageButton))).click().perform();
  }


}
