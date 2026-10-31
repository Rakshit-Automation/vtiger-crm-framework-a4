
package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewContact {

    public CreatenewContact(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Contacts section
    @FindBy(linkText = "Contacts")
    public WebElement contact;

    // Create Contact icon
    @FindBy(xpath = "//img[@alt='Create Contact...']")
    public WebElement plusicon;

    // Contact form elements
    @FindBy(name = "salutationtype")
    public WebElement salutationDD;

    @FindBy(name = "firstname")
    public WebElement firstNameField;

    @FindBy(name = "lastname")
    public WebElement lastNameField;

    // Organization selection popup
    @FindBy(xpath = "(//*[local-name()='img' and @alt='Select'])[1]")
    public WebElement organizationSelect;

    @FindBy(xpath = "//a[text()='vtigerCRM Inc']")
    public WebElement organizationOption;

    // Contact details
    @FindBy(name = "birthday")
    public WebElement birthdate;

    @FindBy(id = "assistant")
    public WebElement assistantName;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(name = "leadsource")
    public WebElement leadSourceDD;

    @FindBy(id = "phone")
    public WebElement officePhoneField;

    // Save button
    @FindBy(css = "input[title='Save [Alt+S]']")
    public WebElement save;
}
