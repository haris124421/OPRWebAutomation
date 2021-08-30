package SiteAdministration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class UpdateTestResult
{
	public void updateResult(ArrayList<TestResult> objresultlst) throws IOException
	{
		try
		{
			
			  File file= new File("C:\\Selenium\\Book1.xlsx");
			  FileInputStream inputStream = new FileInputStream(file);
			  XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
			  for (Iterator<TestResult> iterator = objresultlst.iterator(); iterator.hasNext();)
			  {
				  try {
					  
					  
					  
					  String ValidatedBy = "Automation";
					  TestResult testResult = (TestResult) iterator.next();
						
						
						
						 
					  XSSFSheet sheet = workbook.getSheet(testResult.SheetName);
					  
					  XSSFCellStyle CellStyle = workbook.createCellStyle();
					  CellStyle.setAlignment(HorizontalAlignment.CENTER);
					  CellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
					  CellStyle.setWrapText(true);
					  
					  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
					  LocalDateTime now = LocalDateTime.now(); 
					   
					  int totalRow = sheet.getLastRowNum() + 1;
					  
					  for (int i = 9; i<totalRow ; i++) {
						  try {
							  XSSFRow r=sheet.getRow(i);
							  if(r==null)
								  continue;
						  
						 	  
						  String ce = r.getCell(1).getStringCellValue();
						  
						  if (ce.contains(testResult.TestCaseID)) {
							  r.createCell(8).setCellValue(testResult.Status);
							  r.getCell(8).setCellStyle(CellStyle);
							  r.createCell(9).setCellValue(ValidatedBy);
							  r.getCell(9).setCellStyle(CellStyle);
							  r.createCell(16).setCellValue(dtf.format(now));
							  System.out.println("Result Updated in Validation Sheet for TestCaseID: "+testResult.TestCaseID);

						  }
					  }
					  catch(Throwable e) {
						  System.out.println("Error : " +e);
					  }
					  }
					  
					  
					  
				  }
				  catch(Throwable e) {
					  System.out.println("Error : " +e);
				  }
				  
			  }
			  FileOutputStream outFile = new FileOutputStream (file);
			  workbook.write(outFile);
			  outFile.close();
			  workbook.close();
			  
			
		}
		 catch(Throwable e)
		{
			  System.out.println("Error : " +e);
		  }
	}
}






