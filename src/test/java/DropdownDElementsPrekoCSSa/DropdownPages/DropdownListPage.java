package DropdownDElementsPrekoCSSa.DropdownPages;

import DropdownDElementsPrekoCSSa.DropdownBase.DropdownBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropdownListPage extends DropdownBaseTest {
    public DropdownListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    public WebElement DropdownList;

    @FindBy(css = "option[selected = 'selected']")
    public List<WebElement> Placeholder;


    // kako mozemo da kreiramo CSS?
    // u inspect ide na strelicom na value, copy - copy selector
    // i kopira gore nakon znaka jednako: css =
    // (kada u inspect stoji #dropdown, taj hashtag je kao oznaka za ID)
    // ali mu je nesiguran ovaj nacin, pa bira drugi.

    // svi tagovi u inspect (on ga sad zove HTML): a href, div, option.. zovu se nodovi.
    // s leve strane imamo atribute, ovde pise value,
    // a sa desne imamo vrednost toga (1)

    // pisemo:
    //  @FindBy(css = "tag[value = '1']")
    //  public WebElement element;

    // sad ce program da otvori HTML i da trazi node option,
    // a potom onaj option koji ima value 1, znaci to je element koji trazimo

    // TEMPLATE kako traziti nesto preko CSSa:

    // @FindBy(css = "tag[atribute = 'value']")
    // public WebElement element;

    // znaci, otvorimo HTML, trazimo koji tag, koji atribut u koja je vrednost tog atributa

    //tag - <div> <select> <value>
    //attribute - atributi taga koji imaju neke vrednosti
    //value - vrednost tog atributa
    //primer za prethodni element kako izgleda u DOM-u
    //<option value="1" selected="selected">Option 1</option>


    //------------------------

    public String getPlaceholderText() {
        return Placeholder.get(0).getText();
    }


}
