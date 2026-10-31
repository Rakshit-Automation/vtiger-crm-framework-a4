package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadVerificationPage {
	public LeadVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	//save
	@FindBy(css="input[title='Save [Alt+S]']")
	public WebElement save;
    // First Name
    @FindBy(id = "dtlview_First Name")
    public WebElement firstName;

    // Last Name
    @FindBy(id = "dtlview_Last Name")
    public WebElement lastName;

    // Company
    @FindBy(id = "dtlview_Company")
    public WebElement company;

    // Industry
    @FindBy(id = "dtlview_Industry")
    public WebElement industry;

    // Phone
    @FindBy(id = "dtlview_Phone")
    public WebElement phone;
}
