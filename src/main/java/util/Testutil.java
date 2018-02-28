package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testutil 
{

	static XSSFWorkbook book;
	static XSSFSheet sheet1;
	static File src;
	static FileInputStream fis;
	
	public static Object[][] getTestData(int sheetnum) 
	{
		
		try 
		
		{
			src = new File("C:\\Users\\krishnaraddih\\Desktop\\Selenium\\dataProvider\\xlsFile\\data.xlsx");
			
			fis = new FileInputStream(src);
			
			book = new XSSFWorkbook(fis);
				
		} 
		
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
       sheet1 = book.getSheetAt(sheetnum);
		
		Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet1.getLastRowNum();i++)
			for(int k=0;k<sheet1.getRow(0).getLastCellNum();k++)
			    data[i][k] = sheet1.getRow(i+1).getCell(k).toString();
			
		return data;
		
	    //book.close();
		
	}

	
	
}

