package br.edu.utfpr.exemplomaven;

import br.edu.utfpr.classes.BuscarPage;
import br.edu.utfpr.classes.EntrarPage;
import br.edu.utfpr.classes.CadastroPage;
import br.edu.utfpr.classes.MainPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author renil
 */
public class Bugzila {

    private static String CHROMEDRIVER_LOCATION = "C:\\Users\\andre\\Desktop\\atividade14-master\\atividade14-master\\chromedriver.exe";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.redmine.org/");
    }

    @After
    public void after() {
        driver.close();
    }

    
    @Test
    public void Cadastro() {
        CadastroPage cadastroP = new CadastroPage(driver);
        
        MainPage mainP = cadastroP.setLogin("Andresssa")
                .setPassword("123asd")
                .setPasswordConfirmation("123asd")
                .setFirstname("Andressa")
                .setLastname("Leite")
                .setMail("andressalhenriques@gmail.com")
                .setLanguage("English")
                .addValid();
        //assertEquals("Sua conta foi ativada. Você pode acessá-la agora.", cadastroP.getConfirmation());
        assertEquals("Your account has been activated, You can now log in", cadastroP.getConfirmation());
    }
    
    @Test
    public void LoginValido() {
        EntrarPage entrar = new EntrarPage(driver);
        
        MainPage mainP = entrar.setUsername("Andresssa")
                .setPassword("123asd")
                .addValid();
        //assertEquals("Sua conta foi ativada. Você pode acessá-la agora.", cadastroP.getConfirmation());
        assertEquals("Logged in as Andresssa", entrar.getConfirmation());
    }
    
        
    @Test
    public void Busca() {
        BuscarPage buscar = new BuscarPage(driver);
        
        MainPage mainP = buscar.setBuscar("teste")
                .addValid();
        //assertEquals("Sua conta foi ativada. Você pode acessá-la agora.", cadastroP.getConfirmation());
        assertEquals("teste", buscar.getConfirmation());
    }
    
}
