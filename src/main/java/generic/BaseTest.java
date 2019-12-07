
package main.java.generic;




import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.relevantcodes.extentreports.LogStatus;


//import com.relevantcodes.extentreports.LogStatus;


import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;




public abstract class BaseTest implements IAutoConst{

	protected static  int itrs;

	protected static int requestStartRowNum;

	 

	
	protected static   WebDriver driver=null;
	

	public static int REPEAT_MINUS = 100;
	
Logger APP_LOGS = Logger.getLogger("BaseTest");

	
	public static String scrshotFolderLoc;

	public static String excelpath ="D:\\eclipse-workspace\\PageObject2\\data\\preCondInput.xlsx";

	

	
	 final static String workingDir = System.getProperty("user.dir");
		
	  //  final static String filePath = "./test-output/MyReport.html";
	  final static String filePath = "\\test-output\\MyReport.html";

	  public static String path =workingDir+filePath;
	
	
	
	static int testRunId=000000;
	
	  public static String logfiletimestamp;


		 public static String downloadPath = null;
		
		public  static ExtentReports extent;
		public  static  ExtentTest extentTest; 
		
	//    public ExtentTest parentTest;
	  //  public ExtentTest childTest;
		private static ExtentHtmlReporter htmlReporter = null;

		
	    
//	    public  Map<Long, ExtentTest> parentContext = new HashMap<Long, ExtentTest>();
	    
		//  private static ThreadLocal parentTest = new ThreadLocal();
		//    private static ThreadLocal test = new ThreadLocal(); 
		
		
		public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
		public static ThreadLocal<ExtentTest> childTest = new ThreadLocal<ExtentTest>();
		
		public static ThreadLocal<ExtentTest> childTestnew = new ThreadLocal<ExtentTest>();
		
		
		public static Excel eLib = new Excel();

		
	///	String browserType = eLib.getCellValue(path,"PreCon", 1, 1);
		
		
	//	 int time = Integer.parseInt((eLib.getCellValue(path,"PreCon", 1, 2)).replace(".0", ""));
		
		
		 
			@BeforeSuite
			public void beforeSuite(){
		

			//	extent = ExtentManager.getExtentReport();
	
				

				htmlReporter = new ExtentHtmlReporter(workingDir+filePath);
				htmlReporter.config().setReportName("My Test Report");
				htmlReporter.config().setEncoding("utf-8");
				htmlReporter.config().setTheme(Theme.DARK);
			//	htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
				extent = new ExtentReports();
				extent.setSystemInfo("Platform", "Windows");
				extent.attachReporter(htmlReporter);
				
				
			}
		 
			@BeforeTest
		    public synchronized void beforeTest(XmlTest method) {
		   
			  ExtentTest tests = extent.createTest(method.getName());
				parentTest.set(tests); 
			  
			  
			  
	/*	
			  parentTest = ExtentTestManager
		                .startTest(result.getName() + " " + Thread.currentThread().getName(), "This is a simple test.")
		                .assignCategory(Thread.currentThread().getName());
					
			  parentContext.put(Thread.currentThread().getId(), parentTest);
			  
			  *
			  */
				
				
				
		    }
			
			
			 

			@Parameters({"iterations","rowStart"})

			 
			@BeforeClass
		

		 //   public synchronized void beforeClass(ITestContext result) {
		    public synchronized void beforeClass(ITestContext result,String iterations,String rowStart) {
		   

	            ExtentTest testclass = parentTest.get().createNode(getClass().getSimpleName());
				   
				   childTest.set(testclass);
			   

				   int start=Integer.parseInt(rowStart);

				   int itr=Integer.parseInt(iterations);

				    
                    itrs=itr;

			        requestStartRowNum=start;


		    }

		 
			
			   @BeforeMethod
			   
			   @Parameters({"browser"})
				
			    public synchronized void beforeMethod(Method method,String browser ) throws Exception
			   {

				  

			
				 
			 //      ExtentTestManager.getTest(method.getName()).log(LogStatus.INFO, "Test Started");
			  
			   	
			     //  ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.INFO, "TEST CASE STARTED IS -> "+method.getName()); //to add name in extent report

				     
					//  ExtentManager.getExtentReport().endTest(ExtentTestManager.getTest());        
				   
				 /*  
				   childTest = ExtentTestManager
			                .startTest(method.getName())
			                .assignCategory(Thread.currentThread().getName());   
					
				   
				   ExtentManager.getExtentReport().flush();
				   */
				   
				   ExtentTest testmethod = childTest.get().createNode(method.getName());
				   
				   childTestnew.set(testmethod);
				   
				   
				   
				   
					driver = getDriver(browser);
					
					
					driver.manage().window().maximize();
					        
			        
			    }
			  
	
	


		public static  RemoteWebDriver getDriver(String browser) throws Exception {

		
			 String fileName=null;
			   
	    	 Date d = new Date();
	    	 
	    	 
	 	    SimpleDateFormat format = new SimpleDateFormat(  "dd.MMMMM.yyyy.hh.mm");
	 	   

	 	   logfiletimestamp = "AutomationLog_TestRunId_"+format.format(d);
	 	   
	 	   
	 	   
		    System.setProperty("autologname",logfiletimestamp);

		      PropertyConfigurator.configure("Log4j.properties");
		    
        	String browserType = eLib.getCellValue(path,"PreCon", 1, 1);
	

    	return new RemoteWebDriver(new URL("http://192.168.225.33:4444/wd/hub"), getBrowserCapabilities(browser));
      
       
        	//	return new RemoteWebDriver(new URL("http://172.23.128.1:4444/wd/hub"), getBrowserCapabilities(browser));

        	
        	//	return new RemoteWebDriver(new URL("http://10.111.108.157:4444/wd/hub"), getBrowserCapabilities(browser));
			
			
		}
		
		public static DesiredCapabilities getBrowserCapabilities(String browser) throws Exception
		
		{
			
			
			
			
            DesiredCapabilities dr=null;

            
       //    RemoteWebDriver driver=null;
            
			switch (browser) 
			
			
			
			{
			case "firefox":
			
			System.out.println("Opening firefox driver");

		//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssrivastava4\\workspace\\PulseProject7\\driver\\chromedriver.exe");
		
			

			 DesiredCapabilities capability = new DesiredCapabilities().firefox();
	            capability.setBrowserName("firefox");
	            capability.setPlatform(Platform.WINDOWS);
	            
	         //   DesiredCapabilities capabillities = new DesiredCapabilities("firefox", "3.6.", Platform.WINDOWS);
	            capability.setCapability("job-name", "Fancy Firefox profile");
	            FirefoxProfile profile = new FirefoxProfile();
	            profile.setPreference("network.http.phishy-userpass-length", 255);
	            capability.setCapability(FirefoxDriver.PROFILE, profile);
	            
	            
	            
	            
			return DesiredCapabilities.firefox();
	            		
				
			case "chrome":
				System.out.println("Opening chrome driver");
			
			
				    DesiredCapabilities capability1 = DesiredCapabilities.chrome();
				    capability1.setBrowserName("chrome");
				    capability1.setPlatform(Platform.ANY);


				    ChromeOptions options = new ChromeOptions();
		          //  options.addArguments("--start-maximized");

				    return DesiredCapabilities.chrome();
					

				//	APP_LOGS.info("Chrome Browser opened");
				
				
				
			case "IE":
				System.out.println("Opening IE driver");
				return DesiredCapabilities.internetExplorer();
			default:
				System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
				return DesiredCapabilities.firefox();
				
				
			
			
			}
			
	
		
		}
		
	
		
		
		
	

		
		
		public static String getScreenshot(RemoteWebDriver driver, String screenshotName) throws IOException
		{
			
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir")+"/screenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}


		

@AfterMethod

	
		
		public void tearDown(ITestResult result) throws IOException
	{
			
		
		
			if(result.getStatus()==ITestResult.FAILURE){
	
			//	 ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed"+ result.getThrowable());
	
				childTestnew.get().fail(result.getThrowable());
				   	
			//		String imagePath=	getScreenshot(driver,result.getName());
	//	ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.FAIL,ExtentTestManager.getTest(getClass().getSimpleName()).addScreencast(imagePath));   
	
			
			
			
			}
			else if(result.getStatus()==ITestResult.SKIP){
		
				//ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());

				
				childTestnew.get().skip(result.getThrowable());
				
			}
			
			
			else if(result.getStatus()==ITestResult.SUCCESS){
				
				 //  ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

				   
				   	
			  //     ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS, "TEST CASE PASSED IS -> "+result.getName());

				
				childTestnew.get().pass("Test Passed");
				
				
			   	
		//				String imagePath=	getScreenshot(driver,result.getName());
		//	ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,ExtentTestManager.getTest(getClass().getSimpleName()).addScreencast(imagePath));   
		
			
			
			}
			
		//   parentContext.get(Thread.currentThread().getId()).appendChild(childTest);
	
			//parentTest.appendChild(childTest);
			
		//	parentTest.getRunStatus();
			//childTest.getRunStatus();
	
			//  ExtentManager.getExtentReport().endTest(ExtentTestManager.getTest());        
		   
			
			
			
			
		//	ExtentManager.getExtentReport().flush();
		     
			extent.flush();
		 //       driver.quit();
	
	}
	
	


	
	
@AfterSuite
public void testDown() {
   // extent.flush();
}
@AfterClass
public void afterClass() {
	
	//   ExtentTestManager.closeTest(parentTest);       
  //    ExtentManager.getExtentReport().flush();
    
	
	
      extent.flush();

	driver.quit();
}
			

				
		
		
		
	

		
		
			
}	





