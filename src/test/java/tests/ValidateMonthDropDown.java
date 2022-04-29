package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.TechFiosTestPage;

import util.BrowserFactory;


public class ValidateMonthDropDown {
	WebDriver driver;
	TechFiosTestPage techFiosTestPage;
	String MONTH_DROPDOWN_BEFOREPATH = "//div[4]//descendant::select[3]/option[" ;
	String MONTH_DROPDOWN_AFTERPATH ="]";
	String[] dropdownmonth=new String[12];

	@Test
	public void validateAllmonths() {
	driver = BrowserFactory.init();
	techFiosTestPage = PageFactory.initElements(driver, TechFiosTestPage.class);
	
	List<WebElement> list = techFiosTestPage.allMonths();
	System.out.println(list.size());
	
	int i=2;
	int j=0;
	do {
		try {
			WebElement dropdownMonth = driver.findElement(By.xpath(MONTH_DROPDOWN_BEFOREPATH+i+MONTH_DROPDOWN_AFTERPATH));
			dropdownmonth[j]=dropdownMonth.getText();
			System.out.println(dropdownmonth[j]);
			i++;
			j++;
		}catch(Exception e) {break;
		}	
	}while (list.size()!=0);

	
//	for(int i=2 ;i<(list.size()) ;i++) {
//		for(int j=0 ;j>(i) ;j++) {
//			WebElement dropdownMonth = driver.findElement(By.xpath(MONTH_DROPDOWN_BEFOREPATH+i+MONTH_DROPDOWN_AFTERPATH));
//			dropdownmonth[j]=dropdownMonth.getText();
//			System.out.println(dropdownmonth[j]);
//		}
//		}
//		}
	String[] actualMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		
	Assert.assertEquals(actualMonths, dropdownmonth);
}
}