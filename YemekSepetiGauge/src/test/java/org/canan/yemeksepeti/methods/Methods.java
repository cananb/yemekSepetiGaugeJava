package org.canan.yemeksepeti.methods;

import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.canan.yemeksepeti.driver.DriverExec;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods {

    private static WebDriver driver;

    private static WebDriverWait wait;


    public Methods() {
        this.driver = DriverExec.driver;
        wait = new WebDriverWait(this.driver, 30);

    }


    public ElementInfo getElementInfo(String key) {
        return StoreHelper.INSTANCE.findElementInfoByKey(key);
    }

    public boolean containsKeyInElementInfoMap(String key) {
        return StoreHelper.INSTANCE.containsKey(key);
    }


    public By getBy(String key) {
        return ElementHelper.getElementInfoToBy(getElementInfo(key));
    }


    private WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    private List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void clickElement(By by) {
        findElement(by).click();
    }

    public void sendKeysElement(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void sendKeysPressEnter(By by, String text) {  //degeri yaz vetıkla (Enter islemi)
        findElement(by).sendKeys(text);
        findElement(by).sendKeys(Keys.ENTER);
    }


    public String getText(By by) {
        return findElement(by).getText();
    }//gönderilen elementin text ini alacak


    public Select getSelect(By by) {
        return new Select(findElement(by));
    } //HTML Tag i select olanlar için seçim yapar


    public void selectByVisibleText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    } //Texte tıkla yada texti seç

    public void selectByValue(By by, String value) {
        getSelect(by).selectByValue(value);
    }//Value değerini tıkla

    public void selectByIndex(By by, int index) {
        getSelect(by).selectByIndex(index);
    }


    public void findElementGetTextClickOptionalKey(By by, String text, By optionalBy) {

        List<WebElement> allRows = findElements(by);

        for (WebElement element : allRows) {
            if (element.getText().contains(text)) {
                element.findElement(optionalBy).click();
            }
        }


    }

    public void findElementGetTextClick(By by, String text) {

        List<WebElement> allRows = findElements(by);

        for (WebElement element : allRows) {
            if (element.getText().equals(text)) {
                element.click();
            }
        }


    }


}
