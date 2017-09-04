package Selenium_Test;

import java.lang.reflect.Method;



public class Driver {
	// static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", "D:/Report/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:/Report/chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:/Report/ie.exe");
		String testCase = "TC9";
		Reusable.startReport(testCase, "D:/Report/", "IE");
		Method tc = Automation.class.getMethod(testCase);
		tc.invoke(tc);
		
		Reusable.bw.close();

	}
	/*
	 * String dt_path = "D:/Report/TestSuite.xls"; String[][] recData =
	 * Reusable.readXlSheet(dt_path,
	 * "Sheet1");System.out.println(recData.length);
	 * 
	 * for (int i = 2; i < recData.length ; i++) {
	 * 
	 * String execute = recData[i][1];
	 * 
	 * if (execute.equalsIgnoreCase("Y")) {
	 * 
	 * try {
	 * 
	 * System.setProperty("webdriver.gecko.driver","D:/Report/geckodriver.exe");
	 * 
	 * String testCase = recData[i][2];
	 * 
	 * System.out.println(testCase); Reusable.startReport(testCase,
	 * "D:/Report/", "FireFox"); /* Java Reflection
	 */
	/*
	 * Method tc = Automation.class.getMethod(testCase); tc.invoke(tc);
	 * 
	 * Reusable.bw.close();
	 * 
	 * } catch (Exception e) { System.out.println(e); } } }
	 */
}
