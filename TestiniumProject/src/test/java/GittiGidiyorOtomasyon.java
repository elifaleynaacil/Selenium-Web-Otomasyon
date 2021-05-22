import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class GittiGidiyorOtomasyon {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/uye-girisi");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\'L-UserNameField\']")).sendKeys("rhett.anselmo@fineoak.org");
        driver.findElement(By.xpath("//*[@id=\'L-PasswordField\']")).sendKeys("Test-1234");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='gg-login-enter']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\'main-header\']/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys("bilgisayar");
        //arama kısmına  bilgisayar kelimesi yazılıyor
        driver.findElement(By.xpath("//*[@id=\'main-header\']/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
        //butona basılır ve bilgisayar kelimesi aratılır.
        driver.findElement(By.xpath("//ul[@class='clearfix']//li[2]//a")).click();
        //2.sayfaya geçilir
        driver.findElement(By.xpath("//ul[@class='catalog-view clearfix products-container']//li[3]//a")).click();
        //2.sayfadaki 3. ürüne girlir.
        driver.findElement(By.xpath("//input[@id=\'add-to-basket\']")).click();
        // Seçilen 3. ürün sepete eklenir
        String first = driver.findElement(By.xpath("//*[@id='sp-price-highPrice']")).getText();
        String second = driver.findElement(By.xpath("//*[@id=\'cart-item-476733948\']/div[2]/div[5]/div[1]/div[2]/strong")).getText();
        Assert.assertEquals(first,second); //eşitmi kontrolu
        driver.quit(); // kapat





    }

}
