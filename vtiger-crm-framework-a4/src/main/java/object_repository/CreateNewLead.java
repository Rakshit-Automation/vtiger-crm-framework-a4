package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewLead {

	public CreateNewLead(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Leads")
	public WebElement leadSection;

	@FindBy(css = "img[alt='Create Lead...']")
	public WebElement plusicon;

	@FindBy(name = "firstname")
	public WebElement firstNameField;

	@FindBy(name = "lastname")
	public WebElement lastNameField;

	@FindBy(name = "company")
	public WebElement companyField;

	@FindBy(name = "designation")
	public WebElement titleField;

	@FindBy(name = "leadsource")
	public WebElement leadSourceDD;

	@FindBy(name = "industry")
	public WebElement industryDD;

	@FindBy(name = "annualrevenue")
	public WebElement revenueField;

	@FindBy(name = "noofemployees")
	public WebElement employeesField;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "phone")
	public WebElement phoneField;

	@FindBy(id = "mobile")
	public WebElement mobileField;

	@FindBy(name = "website")
	public WebElement websiteField;

}
