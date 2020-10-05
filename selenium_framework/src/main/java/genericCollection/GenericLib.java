package genericCollection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {
	
	public String getPropertyValue(String key)
	{
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(Constants.dirPath));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		String value = pro.getProperty(key);
		return value;
	}
	
	public Row exceldata(String sheetName,int rowNum)
	{
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(Constants.excelPath));
		} catch (EncryptedDocumentException e) {
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		return row;
	}
	
	public String getExcelValue(String sheet,int row,int cellNum)
	{
		String CellValue = exceldata(sheet, row).getCell(cellNum).getStringCellValue();
		return CellValue;
	}
	
	public void setExcelValue(String sheet,int row,int cell,String value)
	{
		exceldata(sheet, row).createCell(cell).setCellValue(value);
	}
	
	public void connectDB(String url,String userName,String password,String query)
	{
		/*Driver driver = new Driver();
		DriverManager.registerDriver(driver);*/
       Connection con = null;
	try {
		con = DriverManager.getConnection(url,userName,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		Statement st = con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	}

}
