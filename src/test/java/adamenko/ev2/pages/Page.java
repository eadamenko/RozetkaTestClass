package adamenko.ev2.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;
  
  

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 20);
    wait.ignoring(StaleElementReferenceException.class);
  }
  
  

  public String getTitle() {
    return driver.getTitle();
  }

}
