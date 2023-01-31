package Domaci1Youtube;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube {

    public static void main(String[] args) throws InterruptedException {

        //Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBox.sendKeys("youtube");
        searchBox.sendKeys(Keys.ENTER);

        WebElement youtube = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        youtube.click();

        WebElement youtubeBox = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        youtubeBox.sendKeys("Paha vaanii marko haavisto");
        youtubeBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        WebElement paha = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[5]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"));
        paha.click();

        Thread.sleep(3000);

        driver.quit();







    }
}
