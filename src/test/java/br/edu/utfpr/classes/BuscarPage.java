/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andre
 */
public class BuscarPage extends BasePage {

    WebElement q;
    WebElement confirmation;

    @FindBy(xpath = "//*[@id=\"q\"]")
    WebElement loginButton;

    public BuscarPage setBuscar(String busca) {
        q.clear();
        q.sendKeys(busca);
        return this;
    }

    public BuscarPage(WebDriver drive) {
        super(drive);
    }

    public String getConfirmation() {
        return driver.findElement(By.id("search-input")).getText();
    }

    public MainPage addValid() {
        loginButton.submit();
        return new MainPage(driver);
    }
}
