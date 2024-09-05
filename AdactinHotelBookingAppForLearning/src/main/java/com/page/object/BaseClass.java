package com.page.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver driver1;
	public String browser = "chrome";
	public static String User = "admin";
	public static String pass = "Mes@123";
	public static String URL = "https://adactinhotelapp.com/";
	public static String DataInsightReportFilePath = "D:\\E-PQR Test Document\\File for testing\\data insight report\\normalprob.xlsx";
	public static String EPQRNo = "";
	public BaseClass() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\drivers(C)\\chromedriver-win64 (5)\\chromedriver-win64\\chromedriver.exe");
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

				options.addArguments("--start-maximized");
				options.addArguments("--disable-web-security");
				options.addArguments("--no-proxy-server");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				options.setExperimentalOption("prefs", prefs);

//				options.setExperimentalOption("prefs", prefs);
//				options.addArguments("start-maximized");
//				
//				options.addArguments("--disable-extensions");
//				options.addArguments("--disable-notifications");
//				

				driver = new ChromeDriver(options);
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(URL);
		}
	}

	public void toBrowserLaunch(String browser1) {
		if (driver1 == null) {

			if (browser1.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\chromedriver.exe");
				driver1 = new ChromeDriver();
			} else if (browser1.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\geckodriver.exe");
				driver1 = new FirefoxDriver();
			} else if (browser1.equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\msedgedriver.exe");
				driver1 = new EdgeDriver();
			}
			driver1.manage().window().maximize();
			driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver1.get("http://192.168.11.77:5003/");
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {

		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public void setTextdriver1(WebElement element, String name) {
		if (driver1 != null) {
			System.out.println("driver  not null");

			if (name != null) {
				System.out.println(driver);
				System.out.println(driver1);
				element.click();
				element.clear();
				element.sendKeys(name);
			} else
				System.out.println("dirver null");
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public String selectFromDropDownIndex(WebElement element, int N) {
		Select obj = new Select(element);
		obj.selectByIndex(N);
		return obj.getFirstSelectedOption().getText();
	}

	public String getDefaultOption(WebElement element) {
		Select obj = new Select(element);
		WebElement option = obj.getFirstSelectedOption();

		String defaultItem = option.getText();

		return defaultItem;
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			// wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean allOptiondisplayed(List<WebElement> element, String[] arr) {
		boolean match = false;
		for (WebElement we : element) {

			for (int i = 0; i < arr.length; i++) {
				if (we.getText().equals(arr[i])) {

					match = true;

				}
			}
		}

		return match;
	}

	public void Mouseover(WebElement Element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(Element).build().perform();
	}

	public boolean defaultAscending(List<WebElement> list) throws IOException {
		boolean match = false;

		String[] str1 = new String[list.size() - 1];

		for (int i = 1; i < list.size(); i++) {
			str1[i - 1] = list.get(i).getText();
			// System.out.println(str1[i-1]);

		}

		String[] str2 = new String[list.size() - 1];
		for (int i = 0; i < str1.length; i++) {
			str2[i] = str1[i];
			// System.out.println(str2[i]);

		}

		Arrays.sort(str2);
		for (int i = 0; i < str2.length; i++) {

			// System.out.println(str2[i]);

		}

		for (int i = 0; i < str2.length; i++) {
			// System.out.println(i);
			// System.out.println(str1[i]);
			// System.out.println(str2[i]);

			if (str1[i].equals(str2[i])) {
				// System.out.println(str1[i]);
				// System.out.println(str2[i]);
				match = true;

			}
		}
		return match;

	}

	public boolean defaultAscendingAllValues(List<WebElement> list) throws IOException {
		boolean match = false;

		String[] str1 = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			str1[i] = list.get(i).getText();
			// System.out.println(str1[i]);

		}

		String[] str2 = new String[list.size()];
		for (int i = 0; i < str1.length; i++) {
			str2[i] = str1[i];
			// System.out.println(str2[i]);

		}

		Arrays.sort(str2);
		for (int i = 0; i < str2.length; i++) {
//			 System.out.println(i);
//			 System.out.println(str2[i]);

		}

		for (int i = 0; i < str2.length; i++) {
			// System.out.println(i);
//			System.out.println(str1[i]);
//		System.out.println(str2[i]);

			if (str1[i].equals(str2[i])) {
				// System.out.println(str1[i]);
				// System.out.println(str2[i]);
				match = true;

			}
		}
		return match;

	}

	public boolean AscendingTODescendingAllValues(List<WebElement> list) throws IOException {
		boolean match = false;

		String[] str1 = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			str1[i] = list.get(i).getText();
			// System.out.println(str1[i-1]);

		}

		String[] str2 = new String[list.size()];
		for (int i = 0; i < str1.length; i++) {
			str2[i] = str1[i];
			// System.out.println(str2[i]);

		}

		Arrays.sort(str2, Collections.reverseOrder());
		for (int i = 0; i < str2.length; i++) {

			// System.out.println(str2[i]);

		}

		for (int i = 0; i < str2.length; i++) {
			// System.out.println(i);
			// System.out.println(str1[i]);
			// System.out.println(str2[i]);

			if (str1[i].equals(str2[i])) {
				// System.out.println(str1[i]);
				// System.out.println(str2[i]);
				match = true;

			}
		}
		return match;

	}

	public boolean defaultAscendingAllValuesList(List<WebElement> list) throws IOException {
		boolean match = false;

		// String[] str1 = new String[list.size()];
		List str = new ArrayList<>();
		List str1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			str.add(list.get(i).getText());

			System.out.println(str.get(i));

		}

		for (int i = 0; i < list.size(); i++) {
			str1.add(str.get(i));

			// System.out.println(str1.get(i));

		}
		Collections.sort(str1);
		for (int i = 0; i < str1.size(); i++) {
			// str1.add(str.get(i));

			System.out.println(str1.get(i));

		}

		return true;
	}

	public String[] splitStringBySpace(WebElement element) {
		String str = element.getAttribute("innerText");
		String[] arr = str.split(" ");
		return arr;

	}

	public void loadPage(List<WebElement> MenuOptions, List<WebElement> subMenuOptions, String MenuName,
			String SubMenuName) throws InterruptedException {

		Thread.sleep(5000);
		// MenuOptions.get(0).click();
		for (int i = 0; i < MenuOptions.size(); i++) {
			if (MenuOptions.get(i).getText().equals(MenuName)) {
				MenuOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		for (int i = 0; i < subMenuOptions.size(); i++) {
			if (subMenuOptions.get(i).getText().contains(SubMenuName)) {
				subMenuOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public int getNoofRows(String fileLocation) throws FileNotFoundException, InterruptedException {

		try {

			FileInputStream inputStream = new FileInputStream(fileLocation);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum() + 1;
			System.out.println(rowCount);
			return rowCount;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//System.out.println(driver.getTitle());
		}

		return 0;
	}

	public int getNoofColumns(String fileLocation) throws FileNotFoundException, InterruptedException {

		try {

			FileInputStream inputStream = new FileInputStream(fileLocation);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int targetRowNum = 0;
			Row targetRow = sheet.getRow(targetRowNum);
			int lastColumnNum = targetRow.getLastCellNum();
			System.out.println(lastColumnNum);
			return lastColumnNum;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//System.out.println(driver.getTitle());
		}

		return 0;
	}

	public String getParticularCellValue(String fileLocation, int RNo, int CNo)
			throws FileNotFoundException, InterruptedException {
		String cellValue="";
		try {

			FileInputStream inputStream = new FileInputStream(fileLocation);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row targetRow = sheet.getRow(RNo);
//			if (targetRow == null) {
//				System.out.println("Row doesn't exist");
//			}
			org.apache.poi.ss.usermodel.Cell targetCell = targetRow.getCell(CNo);
//			if (targetCell == null) {
//				System.out.println("Cell doesn't exist");
//			}
			cellValue = targetCell.toString();
			//System.out.println("Value in the target cell: " + cellValue);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}

		return cellValue;
	}

	public String getTitlte() {
		return driver.getTitle();

	}

	public void refresh() {
		driver.navigate().refresh();

	}

	public void back() {
		driver.navigate().back();

	}

	public void quitDriver() {

		driver.quit();
	}

}
