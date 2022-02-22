import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MobileTesting {
    @Test
    public void checkMobilepayment() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);


        driver.get("https://next.privat24.ua/mobile");
        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        driver.findElement(phoneNumber).sendKeys("962142149");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        driver.findElement(amount).sendKeys("200");
        By numberdebitSource = By.xpath("//input[@data-qa-node='numberdebitSource']");
        driver.findElement(numberdebitSource).sendKeys("4093206288191961");
        By expiredebitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
        driver.findElement(expiredebitSource).sendKeys("0622");
        By cvvdebitSource = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        driver.findElement(cvvdebitSource).sendKeys("494");
        Thread.sleep(1500);
        By firstNamedebitSource = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        driver.findElement(firstNamedebitSource).sendKeys("Ronald");
        By lastNamedebitSource = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        driver.findElement(lastNamedebitSource).sendKeys("Clark");
        By submit = By.xpath("//button[@data-qa-node='submit']");
        driver.findElement(submit).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Сплатити')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Назад')]")).click();

        By operator = By.xpath("//span[@data-qa-node='nameB']");


        Assert.assertEquals("Kyivstar Ukraine",driver.findElement(operator).getText());
        Assert.assertEquals("4093 **** **** 1961",driver.findElement(By.xpath("//td[@data-qa-node='card']")).getText());
        Assert.assertEquals("200 UAH",driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());
        Assert.assertEquals(" UAH",driver.findElement(By.xpath("//span[@data-qa-node='commission-currency']")).getText());
        Assert.assertEquals("Поповнення мобільного",driver.findElement(By.xpath("//div[@data-qa-node='category']")).getText());
        Assert.assertEquals("Поповнення телефону. На номер +380962142149",driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());


    }

}
