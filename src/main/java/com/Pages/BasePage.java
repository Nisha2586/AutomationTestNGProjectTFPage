package com.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	public void explicitWait(WebDriver driver,int timeInSec,WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public List<WebElement> selectDropDownMenu(WebElement webElement) {
		Select sel = new Select(webElement);
		return sel.getAllSelectedOptions();
	}
	public int randomGenNum(int boundaryNum) {
		return new Random().nextInt(boundaryNum);
	}
	public String createRandomString(String categoryName,int outBound) {
		return (categoryName+randomGenNum(outBound));
	}

}
