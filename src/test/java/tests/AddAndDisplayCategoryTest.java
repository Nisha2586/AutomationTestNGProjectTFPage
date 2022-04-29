package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.TechFiosTestPage;

import util.BrowserFactory;



public class AddAndDisplayCategoryTest {
	WebDriver driver;
	TechFiosTestPage techFiosTestPage;
	String RandomText;
	String categoryName;
	String CATEGORYNAME_BEFOREPATH = "//div[3]/descendant::a[";
	String CATEGORYNAME_AFTERPATH = "]/span[1]";
	SoftAssert softAssert = new SoftAssert();
	//String inputCategory="test";
	//int outbound=1000;
	
	@Test(priority =0)
	@Parameters({"inputCategory","outbound"})
	public void addNewCategory(String inputCategory,int outbound) throws InterruptedException{
			driver = BrowserFactory.init();
			techFiosTestPage = PageFactory.initElements(driver, TechFiosTestPage.class);
			RandomText =	techFiosTestPage.insertAddCategory(inputCategory,outbound);
			System.out.println(RandomText);
			techFiosTestPage.clickAddCategoryButton();
			Thread.sleep(5000);
						
			List<WebElement> list1 =techFiosTestPage.gellAllLinks();
			categoryName=list1.get(list1.size()-1).getText();
			if(categoryName.equals(RandomText)){
			System.out.println("Added New Category Is Displayed :" + categoryName);
			}else {
			//techFiosTestPage.explicitWait(driver, 10, list1.get(list1.size()-1));
			int i=list1.size();
			do {
				try {
			WebElement CATEGORYNAME=driver.findElement(By.xpath(CATEGORYNAME_BEFOREPATH+i+CATEGORYNAME_AFTERPATH));
			System.out.println(CATEGORYNAME.getText());
			//techFiosTestPage.explicitWait(driver, 10, CATEGORYNAME);
			categoryName =CATEGORYNAME.getText();
			if(categoryName==RandomText) {
				System.out.println("Added New Category Is Displayed :" + categoryName);
				break;
				}
			i--;
			}catch(Exception e){
			break;
				}
			}while(techFiosTestPage.gellAllLinks() !=null);
			}
			//Actual Expected
			softAssert.assertEquals(categoryName, RandomText);
			
	} 
	
}
