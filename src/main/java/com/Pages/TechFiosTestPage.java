package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechFiosTestPage extends BasePage {
	WebDriver driver;

	public TechFiosTestPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements
	@FindBy(how = How.CSS, using = "input[name='categorydata']") // *[@id='extra']/input[1]")
	WebElement ADD_CATEGORY_INSERT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")//"input[type="submit"][name='submit']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	By ALL_LINK_LOCATOR = By.tagName("a");
	By ALL_LINK_TEXTLOCATOR = By.xpath("//div[3]//descendant::a/span");
	String CATEGORYNAME_BEFOREPATH = "//div[3]/descendant::a[";
	String CATEGORYNAME_AFTERPATH = "]/span[1]";
	@FindBy(how=How.XPATH,using ="//body")WebElement CATEGORY_EXIST_ELEMENT;
	@FindBy(how=How.XPATH,using ="//body/span[1]")WebElement CATEGORY_DATATEXT_ELEMENT;
	By SELECT_ALLOPTIONS_LOCATOR=By.xpath("//div[4]//descendant::select[3]//option");
	String MONTH_DROPDOWN_BEFOREPATH = "//div[4]//descendant::select[3]/option[" ;
	String MONTH_DROPDOWN_AFTERPATH ="]";
	//name='due_month'

	// Intractable methods
	public String createRandomText(String categoryName, int outBound) {
		return createRandomString(categoryName, outBound);
	}

	public String insertAddCategory(String categoryName, int outBound) {
		String addedCategory = createRandomString(categoryName, outBound);
		explicitWait(driver, 10, ADD_CATEGORY_INSERT_ELEMENT);
		ADD_CATEGORY_INSERT_ELEMENT.sendKeys(addedCategory);
		return addedCategory;
	}
	public void insertAddCategory(String addedCategory) {
		ADD_CATEGORY_INSERT_ELEMENT.sendKeys(addedCategory);
	}

	public void clickAddCategoryButton() {
		explicitWait(driver, 10, ADD_CATEGORY_BUTTON_ELEMENT);
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}

	public List<WebElement> gellAllLinks() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElements(ALL_LINK_TEXTLOCATOR);
	}
	
public String getOneCategoryText() {
	String categoryName;
	WebElement CATEGORYNAME=driver.findElement(By.xpath(CATEGORYNAME_BEFOREPATH+2+CATEGORYNAME_AFTERPATH));
	explicitWait(driver, 10, CATEGORYNAME);
	categoryName =CATEGORYNAME.getText();
	return categoryName;
	}
public String getActualMessage() {
	return CATEGORY_EXIST_ELEMENT.getText();	
}
public String getActualCategoryData() {
	return CATEGORY_DATATEXT_ELEMENT.getText();	
}
public List <WebElement> allMonths() {
	return driver.findElements(SELECT_ALLOPTIONS_LOCATOR);
}

}
