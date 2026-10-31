
package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVerificationPage {

    public ContactVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Verify First Name
    @FindBy(id = "dtlview_First Name")
    public WebElement firstName;

    // Verify Last Name
    @FindBy(id = "dtlview_Last Name")
    public WebElement lastName;

    // Verify Birthdate
    @FindBy(id = "dtlview_Birthdate")
    public WebElement birthdate;
}
