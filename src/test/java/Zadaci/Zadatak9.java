package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak9 {

    public static void main(String[] args) throws InterruptedException {

        //undo - CTRL + Z

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");

        Thread.sleep(3000);
        WebElement puppies = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[3]/div[8]"));
        puppies.click();

        WebElement textBox1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[6]/div[3]/div[1]/textarea"));
        textBox1.click();
        textBox1.sendKeys("New Year holidays in the imagination");

        WebElement textBox2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[6]/div[4]/div[1]/textarea"));
        textBox2.click();
        textBox2.sendKeys("New Year holidays with Canva & Test Cases");

        Thread.sleep(3000);
        WebElement generate = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generate.click();

















    }
}
