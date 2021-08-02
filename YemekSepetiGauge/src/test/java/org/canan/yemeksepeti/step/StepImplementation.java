package org.canan.yemeksepeti.step;


import com.thoughtworks.gauge.Step;
import org.canan.yemeksepeti.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepImplementation {

    Methods methods;


    public StepImplementation() {
        methods = new Methods();
    }

    @Step("<key> elementine <text> değeri yaz tıkla")
    public void sendKeysPressEnter(String key, String text) {
        methods.sendKeysPressEnter(methods.getBy(key), text);
    }

    @Step("<key> elementine tıkla")
    public void clickElement(String key) {
        methods.clickElement(methods.getBy(key));
    }

    @Step("<key> elementinde <text> değerini bul <optinalKey> tıkla")
    public void findElementGetText(String key, String text, String optinalKey) {
        methods.findElementGetTextClickOptionalKey(methods.getBy(key), text, methods.getBy(optinalKey));
    }

    @Step("<key> elementinde <text> değerini bul tıkla")
    public void findElementGetTextClick(String key, String text) {
        methods.findElementGetTextClick(methods.getBy(key),text);
    }
    @Step("<second> saniye bekle")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }

    @Step("<key> elementine <text> değerini seç")
    public void selectByVisibleText(String key, String text) {
        methods.selectByVisibleText(methods.getBy(key), text);
    }

    @Step("<key> elementine <text> değeri yaz")
    public void sendKeysElement(String key, String text) {
        methods.sendKeysElement(methods.getBy(key), text);
    }

  /*  @Step("<key> elementine <value> değerini seç")
    public void selectByValue(String key, String value) {
        methods.selectByValue(methods.getBy(key), value);
    }
*/
    @Step("<key> elementine <index> sırasındaki değeri seç")
    public void selectByIndex(String key, int index) {
        methods.selectByIndex(methods.getBy(key), index);
    }

}
