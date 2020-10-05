package sss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Incognito {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver d = new ChromeDriver(options);
		d.get("https://google.com");
	}
}
