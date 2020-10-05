package sss;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataDriven {

	Sheet sh;
	public Sheet method(String fPath,String sheet) throws Throwable
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(fPath));
		sh = wb.getSheet(sheet);
		return sh;	
	}
	
	public int getRowCount(String sheet) 
	{
		int lastRowNum = sh.getLastRowNum();
		return lastRowNum;		
	}
	
	public String getExcelValue(int row,int cell)
	{
		Row ro = sh.getRow(row);
		String cellValue = ro.getCell(cell).getStringCellValue();	
		return cellValue;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		int rowCount = getRowCount("sheet1");
		Object[][] objArr = new Object[rowCount][1];
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0] = getExcelValue(i, 0);
		}
		return objArr;
		
	}
	
}
