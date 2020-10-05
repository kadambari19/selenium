package sss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateTextBox {

	public static void validate(String input)
	{
		WebDriver d = new ChromeDriver();
		d.get("https://google.com");
		WebElement element = d.findElement(By.name("q"));
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		Assert.assertEquals(attribute.equals(""), false);
		System.out.println("condition");
	}
	
	public static void main(String[] args) {
		validate("dbhgfyureguih");
	}
	
}
