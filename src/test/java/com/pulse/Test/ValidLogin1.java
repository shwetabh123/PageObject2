package com.pulse.Test;

import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import main.java.generic.BasePage;
import main.java.generic.BaseTest;
import main.java.generic.Excel;
import main.java.generic.Xls_Reader;

import main.java.com.pulse.Page.Author;
import main.java.com.pulse.Page.CompanyDirectory;
import main.java.com.pulse.Page.HomePage;
import main.java.com.pulse.Page.LoginPage;

//@Listeners(generic.RealGuru99TimeReport.class)

public class ValidLogin1 extends BaseTest {

	// public static ExtentReports extent;
	// public static ExtentTest extentTest;

	private static final String SheetName = null;

	LoginPage l = new LoginPage(driver);

	BasePage b = new BasePage(driver);

	public static Xls_Reader reader = new Xls_Reader(excelpath);

	public static String appURL = "https://colorlib.com/etc/regform/colorlib-regform-4/";

	public static String appURL1 = "https://in.yahoo.com/";

	public static String appURL2 = "https://www.sabtv.com/en_in/";

	public static String appURL3 = "https://economictimes.indiatimes.com/";

	static Excel eLib = new Excel();

	public static String url = eLib.getCellValue(excelpath, "PreCon", 1, 0);

	public static String logfiletimestamp;

	/*
	 * @Parameters({"iterations","rowStart","testdata"})
	 * 
	 * @BeforeClass
	 * 
	 * 
	 * public synchronized void beforeClass(String iterations,String rowStart,String
	 * testdata) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * int start=Integer.parseInt(rowStart);
	 * 
	 * int itr=Integer.parseInt(iterations);
	 * 
	 * 
	 * l.itrs=itr;
	 * 
	 * l.requestStartRowNum=start;
	 * 
	 * 
	 * }
	 */

	/*
	 * @DataProvider(name="Authentication")
	 * 
	 * public Iterator<String> gettestdata() {
	 * 
	 * 
	 * // ArrayList<Object[]>testdata= Excel.getdatafromexcel();
	 * 
	 * ArrayList<String>testdata= Excel.getdatafromexcel();
	 * 
	 * 
	 * return testdata.iterator();
	 * 
	 * }
	 * 
	 */

	@DataProvider(name = "iterations")

	public static Object[] iterations()

	{

		int iterations = itrs;

		Object ob[] = new Object[iterations];

		int j = 1;

		for (int i = 0; i < iterations; i++, j++)

		{

			ob[i] = j;

		}

		return ob;

	}

	@Test(priority = 1, dataProvider = "iterations")

	public void TC1(int request) throws IOException, Exception {

		int i;

		i = requestStartRowNum;

		LoginPage l = new LoginPage(driver);

		BasePage b = new BasePage(driver);

		childTestnew.get().log(Status.INFO, "Logged   into      " + appURL);

		driver.get(appURL);

		Thread.sleep(10000);

		// String myData =reader.getCellData("Sheet1", "Email", i);

		String[] arr = l.WorkQueueValidate(SheetName, i);

		for (i = 0; i < arr.length; i++)

		{
			System.out.print(arr[i] + ", ");

			childTestnew.get().log(Status.INFO, "data entered is " + arr[i]);

		}

		// childTestnew.get().log(Status.INFO, "data entered is "+arr);

		requestStartRowNum++;

		driver.quit();

		// i++;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * // @Parameters({"srowNum", "erowNum"}) // @Test
	 * 
	 * @Test(dataProvider="Authentication") // (description =
	 * "This test case is to verify that the firstname and lastname is entered.",
	 * groups= {"abc"}) //(retryAnalyzer=DynamicRetryAnalyzer.class)
	 * 
	 * 
	 * public void TC1(String FirstName,String LastName,String Birthday,String
	 * Gender,String Email,String PhoneNumber,String Subject) throws IOException,
	 * Exception {
	 * 
	 * // public void TC1(String srowNum,String erowNum) throws IOException,
	 * Exception {
	 * 
	 * 
	 * LoginPage l=new LoginPage(driver);
	 * 
	 * 
	 * BasePage b=new BasePage(driver);
	 * 
	 * 
	 * // childTestnew.get().log(Status.INFO, "Running "+method.getName());
	 * 
	 * // childTestnew.get().assignCategory("smoke testing ");
	 * 
	 * 
	 * childTestnew.get().log(Status.INFO, "Logged   into      "+appURL);
	 * 
	 * 
	 * 
	 * 
	 * // driver.navigate().to(appURL); driver.get(appURL);
	 * 
	 * 
	 * Thread.sleep(10000);
	 * 
	 * 
	 * b.set(driver,"FirstName",FirstName);
	 * 
	 * Thread.sleep(1000); b.set(driver,"LastName", LastName); Thread.sleep(1000);
	 * b.set(driver,"Birthday", Birthday); Thread.sleep(1000);
	 * b.set(driver,"Email",Email); Thread.sleep(1000); b.set(driver,"PhoneNumber",
	 * PhoneNumber); Thread.sleep(1000);
	 ***************************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 * WebElement
	 * button=driver.findElement(By.xpath("//iframe[@title=\"New Registration\"]"));
	 * 
	 * driver.switchTo().frame(button);
	 * 
	 * 
	 * 
	 * b.set(driver,"typegooglesearch","Google"); Thread.sleep(10000);
	 * 
	 * 
	 * // childTestnew.get().log(Status.INFO, "entered text is      ");
	 * 
	 * String cell= b.get("typegooglesearch");
	 * 
	 * 
	 * Thread.sleep(10000); System.out.println(cell);
	 * 
	 * // childTestnew.get().log(Status.INFO, "text read is      "+cell);
	 * 
	 * 
	 * 
	 * Thread.sleep(10000);
	 *********************************************************************
	 * 
	 * 
	 * 
	 * // System.out.println(cellvalue);
	 * 
	 * 
	 * b.typenew(driver,"typegooglesearch","Google");
	 * 
	 * 
	 * 
	 * 
	 * childTestnew.get().log(Status.INFO, "Typing in Google search ");
	 * 
	 * 
	 * b.Click(driver,"typegooglesearch");
	 * 
	 * 
	 * childTestnew.get().log(Status.INFO, "Clicking in Google search textbox ");
	 * 
	 * 
	 * 
	 * b.Click(driver, "GoogleSearch");
	 * 
	 * childTestnew.get().log(Status.INFO, "Clicking in Google search button ");
	 * 
	 * 
	 * 
	 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,
	 * "Log from threadId: " + Thread.currentThread().getId());
	 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.INFO,
	 * "Log from threadId: " + Thread.currentThread().getId());
	 * 
	 * 
	 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,
	 * "username is Typed ");
	 * 
	 * 
	 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.INFO,
	 * "Snapshot below: ");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
	 * LogStatus.PASS);
	 * 
	 * 
	 * driver.quit();
	 * 
	 * }
	 */

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	  // @Test (description = "This test case verifies whether the radio button single is selected.")
	  
	  
	  //(retryAnalyzer=DynamicRetryAnalyzer.class)
	  
	  //(description = "This test case verifies whether the radio button single is selected.")
	  
	  
	  @Test (description =  "This test case verifies whether the radio button single is selected.")
	  
	  
	  public void TC2(Method method) throws InterruptedException {
	  
	  
	  
	  driver.navigate().to(appURL1); 
	  childTestnew.get().log(Status.INFO, "Running "+method.getName());
	  
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Au Register Forms by Colorlib";
	  
	  
	  assertEquals(actualTitle,expectedTitle);
	  
	  
	  // childTestnew.get().assignCategory("smoke testing ");
	  
	  
	  childTestnew.get().log(Status.INFO, "Verifying Title "+appURL);
	  
		/*
		 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,
		 * "Log from threadId: " + Thread.currentThread().getId());
		 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.INFO,
		 * "Log from threadId: " + Thread.currentThread().getId());
		 * 
		 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,
		 * "username is Typed ");
		 * 
		 * 
		 * ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.INFO,
		 * "Snapshot below: ");
		 * 
		 * 
		 * 
		 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
		 * LogStatus.PASS);
		 */
	  
	  driver.quit();
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 

	/*
	 * @Test public void testValidLogin1() throws Exception
	 * 
	 * {
	 * 
	 * 
	 * 
	 * driver.navigate().to(url);
	 * 
	 * 
	 * 
	 * String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0); String
	 * pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1); String
	 * accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	 * 
	 * String cb=Excel.getCellValue(XLPATH,"Author",1,3);
	 * 
	 * 
	 * 
	 * LoginPage l=new LoginPage(driver);
	 * 
	 * 
	 * 
	 * BasePage b=new BasePage(driver);
	 * 
	 * driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(un);;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * l.setPassword(pw);
	 * 
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * l.clickLogin();
	 * 
	 * Thread.sleep(30000);
	 * 
	 * 
	 * l.dropdowntheaccount(accnt); Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * l.clickselect(); Thread.sleep(5000);
	 * 
	 * 
	 * HomePage h=new HomePage(driver);
	 * 
	 * driver.close();
	 * 
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.PASS, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * 
	 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
	 * LogStatus.PASS);
	 * 
	 * driver.close();
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void testValidLogin2() throws Exception
	 * 
	 * {
	 * 
	 * 
	 * driver.navigate().to(url);
	 * 
	 * 
	 * Randomaplphanumber R=new Randomaplphanumber();
	 * 
	 * String r= R.Random();
	 * 
	 * String un=Excel.getCellValue(XLPATH,"ValidLogin",2,0); String
	 * pw=Excel.getCellValue(XLPATH,"ValidLogin",2,1); String
	 * accnt=Excel.getCellValue(XLPATH,"ValidLogin",2,2);
	 * 
	 * String cb=Excel.getCellValue(XLPATH,"Author",1,3);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * LoginPage l=new LoginPage(driver);
	 * 
	 * 
	 * 
	 * BasePage b=new BasePage(driver);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(un);;
	 * 
	 * 
	 * // r= BaseTest.getScreenshot(driver, method.getName());
	 * 
	 * 
	 * 
	 * 
	 * l.setPassword(pw);
	 * 
	 * Thread.sleep(25000);
	 * 
	 * 
	 * 
	 * 
	 * // r= BaseTest.getScreenshot(driver, method.getName());
	 * 
	 * 
	 * 
	 * l.clickLogin();
	 * 
	 * Thread.sleep(25000);
	 * 
	 * 
	 * 
	 * l.dropdowntheaccount(accnt); Thread.sleep(25000);
	 * 
	 * 
	 * 
	 * l.clickselect(); Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * HomePage h=new HomePage(driver);
	 * 
	 * 
	 * 
	 * 
	 * driver.close();
	 * 
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.PASS, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
	 * LogStatus.PASS);
	 * 
	 * }
	 */

}
