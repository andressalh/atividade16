/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andre
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement username;
    WebElement password;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public String getUsername() {
        return username.getText();
    }
    public String getPassword(){
        return password.getText();
    }

    

}
