package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Constuctor for PageFactory.initElements(driver,this)
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	
	
	//@FindAll({})-> autohealing ,or operator between locator.
	
	//@FindBys({})-> And operator betweeen locator.
	
	
	
	public WebElement getUsername() {
		return username;
		
	}
	public WebElement getPassword() {
		return password;
		
	}
	
	

}
