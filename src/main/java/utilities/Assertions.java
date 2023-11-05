package utilities;

import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static org.testng.Assert.*;

public class Assertions extends PageBase {
    //================================Assertions By locator============================
 //=================================Assert on existence of element=====================
    public void assertElementExist(By locator) {
        Validations.assertThat().element(getDriver(), locator).exists().perform();
//      assert getElement(locator).isDisplayed();
    }

    public void assertElementNotExist(By locator) {
        Validations.assertThat().element(getDriver(), locator).doesNotExist().perform();
//        try {
//            assert getElement(locator).isDisplayed();
//            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist");
//            Assert.fail();
//        } catch (Exception e) {
//            System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist.");
//        }
    }
//============================assert if element is enabled=================================
    public void assertElementEnabled(By locator) {
//        try {
//            Thread.sleep(2000);
//        } catch(InterruptedException e) {
//            System.out.println("got interrupted!");
//        }
//        Boolean buttonStatus = Boolean.valueOf(ElementActions.getAttribute(getDriver(),locator, "disabled"));
//        Validations.assertThat().object(buttonStatus).isFalse().perform();
            assertTrue(getElement(locator).isEnabled());
    }

    public void assertElementDisabled(By locator) {
//        try {
//            Thread.sleep(2000);
//        }
//        catch (Exception ignored){
//
//        }
//        Boolean buttonStatus = Boolean.valueOf(ElementActions.getAttribute(getDriver(),locator, "disabled"));
//        Validations.assertThat().object(buttonStatus).isTrue().perform();
           assertFalse(getElement(locator).isEnabled());
    }
    public void assertButtonEnabled(By locator, String disabledClassName) {
//      Boolean isDisabled = Boolean.valueOf(ElementActions.getAttribute(getDriver(),locator, disabledClassName));
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
//        assertTrue((!isDisabled));
        Validations.assertThat().object(isDisabled).isFalse().perform();
    }

    public void assertButtonDisabled(By locator, String disabledClassName) {
//      Boolean isDisabled = Boolean.valueOf(ElementActions.getAttribute(getDriver(),locator, disabledClassName));
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
//      assertFalse((!isDisabled));
        Validations.assertThat().object(isDisabled).isTrue().perform();
    }
//===================================Assert element text=====================================
    public void assertElementText(By locator, String text) {
//      String elementText = ElementActions.getText(getDriver(),locator);
        String elementText;
        elementText = getElement(locator).getText();
//      assertEquals(elementText, text);
        Validations.assertThat().object(elementText).isEqualTo(text).perform();
    }

    public void assertTextContainsElementTextByIndex(By locator, String text,int index) {
//        String elementText = getElementByIndex(locator, index).getText();
        String elementText;
        elementText = getElementByIndex(locator,index).getText();
//        assertTrue(text.contains(elementText));
        Validations.assertThat().object(text).contains(elementText).perform();
    }

    public void assertTextContainsElementText(By locator, String text) {
//        String elementText = ElementActions.getText(getDriver(),locator);
        String elementText;
        elementText = getElement(locator).getText();
//        assertTrue(text.contains(elementText));
        Validations.assertThat().object(text).contains(elementText).perform();
    }

    public void assertElementTextContainsText(By locator, String text) {
//        String elementText = ElementActions.getText(getDriver(),locator);
        String elementText;
        elementText = getElement(locator).getText();
//        assertTrue(elementText.contains(text));
        Validations.assertThat().object(elementText).contains(text).perform();
    }

    public void assertElementTextNotEqual(By locator, String text) {
//        String elementText = ElementActions.getText(getDriver(),locator);
        String elementText;
        elementText = getElement(locator).getText();
//        assertNotEquals(elementText, text);
        Validations.assertThat().object(elementText).doesNotEqual(text).perform();
    }

    public void assertAttributeValueContainsText(By locator, String attribute, String text) {
        String attributeValue = getElement(locator).getAttribute(attribute);
        assertTrue(attributeValue.contains(text));
    }
    //===================================Assert list size=====================================
    public void assertListSize(By locator, String size) {
        String listSize;
        int listSizeInt = getDriver().findElements(locator).size();
        listSize = Integer.toString(listSizeInt);
//        assertEquals(listSize, size);
        Validations.assertThat().object(listSize).isEqualTo(size).perform();
    }

    public void assertListSizeNotEqual(By locator, String size) {
        String listSize = "";
        int listSizeInt = getDriver().findElements(locator).size();
        listSize = Integer.toString(listSizeInt);
//        assertNotEquals(listSize, size);
        Validations.assertThat().object(listSize).doesNotEqual(size).perform();
    }
    //========================================================================================
    //================================Assertions By Element============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(WebElement element) {
        assert element.isDisplayed();
    }

    public void assertElementNotExist(WebElement element) {
        try {
            assert element.isDisplayed();
            System.out.println("Assertions failed - Element exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element does not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    public void assertElementDisabled(WebElement element) {
        assertFalse(element.isEnabled());
    }

    public void assertButtonEnabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertEquals(elementText, text);
    }
    public void assertTextContainsElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertTrue(text.contains(elementText));
    }

    public void assertElementTextContainsText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertTrue(elementText.contains(text));
    }

    public void assertElementTextNotEqual(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertNotEquals(elementText, text);
    }
    //===================================Assert list size=====================================
    public void assertListSize(List<WebElement> element, String size) {
        String listSize = "";
        int listSizeInt = element.size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
    }
    public void assertListSizeNotEqual(List<WebElement> element, String size) {
        String listSize = "";
        int listSizeInt = element.size();
        listSize = Integer.toString(listSizeInt);
        assertNotEquals(listSize, size);
    }
 //==============================================================================================
}
