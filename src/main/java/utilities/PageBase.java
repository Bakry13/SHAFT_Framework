package utilities;

import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends TestBase {
    public static WebDriverWait wait;
    BrowserActions browserActions = new BrowserActions();

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            Thread.sleep(2000);
            element = getDriver().findElement(locator);
            scrollPageToElement(element);

        } catch (Exception ignored) {
//            System.out.println("Element with locator: [" + locator + "] not exist.");
//            e.printStackTrace();
        }
        return element;
    }

    //get element by index
    public WebElement getElementByIndex(By locator, int index) {
        WebElement element = getDriver().findElements(locator).get(index);
        scrollPageToElement(element);
        return element;
    }

    public void waitForElementShow(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not visible on the current DOM");
        }
    }
    //get index of element
    public int getIndexOfListByText(By locator, String selectionText) {
        int index = 0;
        List<WebElement> elementList = getDriver().findElements(locator);
        for (WebElement element : elementList) {
            System.out.println(element.getText());
            if (selectionText.contains(element.getText())) {
                if (element.getText().equals("-")) continue; //check for "-" is specialized because of access ID
                index = elementList.indexOf(element);
                break;
            }
        }
        return index;
    }

    //Scroll to a specific element using Locator
    public void scrollPageToElement(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).build().perform();
            highlightElement(element);
            unhighlightElement(element);
        } catch (Exception ignored) {
//            e.printStackTrace();
        }
    }

    //To highlight which button and field the script is currently clicking or typing in
    public void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", element);
    }

    //To remove the highlight
    public void unhighlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].removeAttribute('style','')", element);
    }

    //retrieve WebElement using xpath with different attributes(use to define any WebElements Object)
    public WebElement retrieveElementByAttributeValue(String attribute, String value) {
        return getDriver().findElement(By.xpath("//*[@" + attribute + "='" + value + "']"));
    }

    //used to force click on element using WebElement with java script(include scroll and wait)
    public void forceClickOnElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);
    }

    //Switching to frame
    public void switchToFrame(By frameLocator) {
        WebElement frame = getElement(frameLocator);
        getDriver().switchTo().frame(frame);
    }

    //get list size
    public int getListSize(By locator) {
        return getDriver().findElements(locator).size();
    }

    //press tab
    public void pressTab(By locator) {
        getDriver().findElement(locator).sendKeys(Keys.TAB);
    }

    //press enter
    public void pressEnter(By locator) {
        getDriver().findElement(locator).sendKeys(Keys.ENTER);
    }

    public void relaunchBrowser()
    {
        browserActions.closeCurrentWindow();
        setDriver();
    }

    public void openNewTab()
    {
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    public void switchToTab(int tabNumber)
    {
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabNumber));
    }

    public void navigateToPage(String url) {
        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println(url);
        getDriver().navigate().to(url);
    }

    public void switchToAnotherTab(int index)
    {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(index));
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }
}