package Practice.PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeSidebarPage1 {

 // Mislim da je bolje da cim se kreira nova klasa u Pages paketu,
 // odmah se deklarise i kreira objekat u Base paketu !!!

 // Umesto HomePage preimenovacemo stranicu u SidebarPage;
 // zato sto, kad god udjemo na neku drugu stranicu, svi ti dugmici su opet prisutni;
 // da radimo s elementima na Home page koji su izvan te trake, ostavili bismo naziv.
 // Kad god imamo ELEMENTE koji se pojavljuju i na SVIM drugim stranicama, za njih pravimo POSEBNU KLASU.

 // Stranice nisu samo one koje su tako obelezene na sajtu. Npr. Home page, Practice page..
 // Vec je svaka nova stranica koja se pojavi (npr. u okviru Practice page), za nas novi page u Intelliju.
 // Dok se logujemo na Practice, to je jedna stranica, kad se ulogujemo druga stranica itd.

 public WebDriver driver;   // 1. ovde kuca public
 public WebDriverWait wdwait;

 // 3. Kreiramo web elemente ovde

 WebElement homeButton;
 WebElement practiceButton;
 WebElement coursesButton;
 WebElement blogButton;
 WebElement contactButton;


 // 2. Sada kreiramo konstruktor za nas driver - ALT + INSERT

 public PracticeSidebarPage1(WebDriver driver, WebDriverWait wdwait) {
  this.driver = driver;
  this.wdwait = wdwait;
 }

 // 4. Kreiremo getere za sve ove elemente; umesto return ubacujemo putanju do elementa;
 //    i sada, kad budemo hteli da pristupimo ovim elementima, ne zovemo njih direktno,
 //    vec METODU getHomeButton npr.

 public WebElement getHomeButton() {
  return driver.findElement(By.linkText("Home"));
 }

 public WebElement getPracticeButton() {
  return driver.findElement(By.id("menu-item-20"));
 }

 public WebElement getCoursesButton() {
  return driver.findElement(By.linkText("Courses"));
 }

 public WebElement getBlogButton() {
  return driver.findElement(By.linkText("Blog"));
 }

 public WebElement getContactButton() {
  return driver.findElement(By.linkText("Contact"));
 }

 // 5. Svaka Page klasa ima: web elemente koje pronalazimo
 // i akcije nad tim elementima!
 // (koje vizuelno odvajamo)
 // Sada pravimo metode za akcije koje zelimo da sprovedemo.

 //----------------------------------

 public void clickOnHomeButton() {   // metodama dajemo imena istovetna akcijama u Test Casevima

  getHomeButton().click();
 }

 public void clickOnPracticeButton() {

  getPracticeButton().click();
 }

 public void clickOnCoursesButton() {
  getCoursesButton().click();
 }

 public void clickOnBlogButton() {
  getBlogButton().click();
 }

 public void clickOnContactButton() {
  getContactButton().click();
 }



}
