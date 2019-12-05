package main.java.generic;


import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	static Xls_Reader reader;
	
/*	
public static int getdatafromexcelnew()
	
	{
		
		String path="C:\\Users\\Admin\\eclipse-workspace\\PageObject1\\data\\data.xlsx";
		
		
	//	ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		int rowNum;
		
		
		 String[] myData = {};
		
		try {
			
			
			
			reader=new Xls_Reader(path);
		}
		
		 catch (Exception e)
		{
			
			e.printStackTrace();
			
		}
		
		for ( rowNum=2;rowNum<=Excel.getRowCount(path, "Sheet1");rowNum++)

			
			
		{
              myData[rowNum]=reader.getCellData("Sheet1", "Email", rowNum);
		
		
		
		}
		return rowNum;
		
	}*/

	public static ArrayList<String> getdatafromexcel()
	
	{
		
		String path="D:\\eclipse-workspace\\PageObject2\\data\\data.xlsx";
		
		
	//	ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		ArrayList<String> myData=new ArrayList<String>();
		
		
		try {
			
			
			
			reader=new Xls_Reader(path);
		}
		
		 catch (Exception e)
		{
			
			e.printStackTrace();
			
		}
		
		for (int rowNum=2;rowNum<=Excel.getRowCount(path, "Sheet1");rowNum++)

			
			
		{
			     //   String FirstName=reader.getCellData("Sheet1", "FirstName", rowNum);

				//	String LastName=reader.getCellData("Sheet1", "LastName", rowNum);

				//	String Birthday=reader.getCellData("Sheet1", "Birthday", rowNum);

			//		String Gender=reader.getCellData("Sheet1", "Gender", rowNum);

		            String Email=reader.getCellData("Sheet1", "Email", rowNum);
		
		        //     String PhoneNumber=reader.getCellData("Sheet1", "PhoneNumber", rowNum);
		
		
	          //   	String Subject=reader.getCellData("Sheet1", "Subject", rowNum);
	
		
	            // 	Object ob[] = {FirstName,LastName,Birthday,Gender,Email,PhoneNumber,Subject};
				
		
	            // 	myData.add(ob);
	             	
			        myData.add(Email);
		
		
		}
		return myData;
		
	}
	
	public static String getCellValue(String path,String sheet,int r,int c){
		String value="";
		try{
			
			
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));		
			value=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		
		
		
		}
		catch(Exception e){	
		}
		return value;
	}
	
	
	
	public static int getRowCount(String path,String sheet){
		int row=0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));		
			row=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){	
		}
		return row;
	}
	
		
	
	
	
}









