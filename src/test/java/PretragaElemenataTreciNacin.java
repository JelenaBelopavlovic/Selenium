import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PretragaElemenataTreciNacin {

    @FindBy (css = "option[selected = 'selected']")
    public WebElement Placeholder;

    //primer za prethodni element kako izgleda u DOM-u
    //<option value="1" selected="selected">Option 1</option>

    @FindBy(css = "tag[attribute = 'value']")
    public WebElement element;


    // KAKO mozemo da kreiramo CSS?
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


    // Ovo je malo kompleksniji nacin trazenja elementa, zato nisam hteo ranije da pokazem,
    // ali ovo je bio nacin kako smo mi trazili sve elemente kada su developeri pravili custom id

    // Dakle postoji obican ID elementa koji su nam rekli da nisu jedinstveni i skloni su promenama
    // jer oni sa njima rade sta god, ali da ce napraviti "data-testid" koji ce biti samo za nas



   // Ako zelite malo da "popunite" CV, mozete da vezbate sa novim projektom tako sto
    // umesto TestNG koristite JUnit biblioteku.
    // Malo istrazite koja je razlika izmedju TestNG i JUnit
    // pa mozete oba skilla da stavite u CV.

}
