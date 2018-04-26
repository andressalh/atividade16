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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author andre
 */
public class CadastroPage extends BasePage{

    WebElement user_login;
    WebElement user_password;
    WebElement user_password_confirmation;
    WebElement user_firstname;
    WebElement user_lastname;
    WebElement user_mail;
    WebElement user_language;
    


    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement cadastro1Button;
    
    @FindBy(xpath = "//*[@id=\"new_user\"]/input[3]")
    WebElement cadastroButton;

    public CadastroPage(WebDriver drive) {
        super(drive);
        cadastro1Button.click();
    }
    
    public CadastroPage setLogin(String login) {
        user_login.clear();
        user_login.sendKeys(login);
        return this;
    }
    
    public CadastroPage setPassword(String senha) {
        user_password.clear();
        user_password.sendKeys(senha);
        return this;
    }
    
    public CadastroPage setPasswordConfirmation(String senha) {
        user_password_confirmation.clear();
        user_password_confirmation.sendKeys(senha);
        return this;
    }
    
    public CadastroPage setFirstname(String nome) {
        user_firstname.clear();
        user_firstname.sendKeys(nome);
        return this;
    }
    
    public CadastroPage setLastname(String sobrenome) {
        user_lastname.clear();
        user_lastname.sendKeys(sobrenome);
        return this;
    }
    
    public CadastroPage setMail(String email) {
        user_mail.clear();
        user_mail.sendKeys(email);
        return this;
    }
    
    
    public CadastroPage setLanguage(String idioma) {
        Select select = new Select(user_language);
        select.selectByVisibleText(idioma);
  
        return this;
    }
    
    public String getConfirmation() {
        return driver.findElement(By.id("flash_notice")).getText();
    }
    
    public MainPage addValid() {
        cadastroButton.click();
        return new MainPage(driver);
    }
    public CadastroPage addInvalid() {
         return this;
    }

    
    
}
