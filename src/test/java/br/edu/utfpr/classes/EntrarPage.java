package br.edu.utfpr.classes;


import br.edu.utfpr.classes.BasePage;
import br.edu.utfpr.classes.CadastroPage;
import br.edu.utfpr.classes.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andre
 */
public class EntrarPage extends BasePage {
    
    WebElement username;
    WebElement password;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input\n")
    WebElement login1Button;
    
    public EntrarPage(WebDriver drive) {
        super(drive);
        loginButton.click();
    }
    
    public EntrarPage setUsername(String name) {
        username.clear();
        username.sendKeys(name);
        return this;
    }
    
    public EntrarPage setPassword(String senha) {
        password.clear();
        password.sendKeys(senha);
        return this;
    }
    
    public String getConfirmation() {
        return driver.findElement(By.id("loggedas")).getText();
    }
    public MainPage addValid() {
        login1Button.click();
        return new MainPage(driver);
    }

 
}
