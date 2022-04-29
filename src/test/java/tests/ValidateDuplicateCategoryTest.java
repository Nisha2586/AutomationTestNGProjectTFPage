package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.TechFiosTestPage;

import util.BrowserFactory;

public class ValidateDuplicateCategoryTest {
	WebDriver driver;
	TechFiosTestPage techFiosTestPage;
	boolean val;

	@Test(priority = 0)
	public void addNewCategory() {
		driver = BrowserFactory.init();
		techFiosTestPage = PageFactory.initElements(driver, TechFiosTestPage.class);
		String categoryText = techFiosTestPage.getOneCategoryText();
		System.out.println("Already Existing Category Data : " + categoryText);
		techFiosTestPage.insertAddCategory(categoryText);
		techFiosTestPage.clickAddCategoryButton();

//		String windowHandle = driver.getWindowHandle();
//		driver.switchTo().window(windowHandle);
		
		String actualMessage = techFiosTestPage.getActualMessage();
		String actualCategoryData = techFiosTestPage.getActualCategoryData();
		System.out.println(actualCategoryData);
		String ExpectedMessage = "The category you want to add already exists: "+categoryText+".";
		String ExpectedCategoryData = categoryText;
		if(actualMessage.contains(ExpectedMessage)) {
			System.out.println(actualMessage);
			val=true;
		}
		Assert.assertEquals(val, true);
		Assert.assertEquals(actualCategoryData, ExpectedCategoryData);
	}

}
