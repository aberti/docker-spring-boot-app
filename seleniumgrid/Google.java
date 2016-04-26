package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Google {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://fixer.pl/");
		selenium.start();
	}

	@Test
	public void testGoogle() throws Exception {
		selenium.open("/");
		selenium.type("id=inputSearchtext", "wirus");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//button[@type='button']");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=flogo");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=inputSearchtext", "komputer");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Konsole do gier");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.service-btn.text-center > button.btn.btn-fgreen");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(text(),'Poproś o\n                oferty')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=flogo");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Zostań Fixerem");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(text(),'Zarejestruj\n                się')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=button.btn.btn-default");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
