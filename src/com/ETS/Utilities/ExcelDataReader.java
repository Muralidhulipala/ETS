package  com.ETS.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;


public class ExcelDataReader {

	int temp=0;
	  static ReadPropKey prop = new ReadPropKey();
	 // Logger log = Logger.getLogger(ExcelDataReader.class);

	    static FileInputStream fis = null;

	  public  FileInputStream getFileInputStream() throws IOException{
	    
	     String filepath = prop.readpropkey("testdata_file_path");
	    File srcfile = new File(filepath);
	    try {
	      fis = new FileInputStream(srcfile);
	    } catch (FileNotFoundException e) {

	      
	    //  System.exit(0);	
	    }
	    return fis;		
	  }
	  
	  
	  public  Object[][] getExceData() throws Exception{
		  int sheetno=sheetcount();
		  fis = getFileInputStream();
	    
	    System.out.println(sheetno);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(sheetno);
	    
	    int TotalNumberOfRows = (sheet.getLastRowNum());
	    System.out.println(TotalNumberOfRows);
	   int TotalNumberOfCols =(sheet.getRow(0).getLastCellNum());
	   System.out.println(TotalNumberOfCols);
	    String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];
	    int ci=0;
	    int cj=0;
	    for (int i = 1; i<=TotalNumberOfRows; i++,ci++){
	    	//int TotalNumberOfCols =sheet.getRow(i).getLastCellNum();
	        for (int j=0; j<TotalNumberOfCols; j++,cj++){
	          XSSFRow row = sheet.getRow(i);
	         // try
	          //{
	        	  if(row.getCell(j)==null)
	        	  {
	        		  //cell empty;
	        	  }
	        	  else
	        	  {
	        		  arrayExcelData[ci][j] = row.getCell(j).toString();
	        	  }
	      //		String cellData = row.getCell(j).toString();
	         
	          //}
	         // catch(Exception e)
	         // {
	        	  
	          
	          //}
	        }
	    }
	    wb.close();
	    return arrayExcelData;
	    
	  }
	    
public void resultexport(int r,String result) throws Exception
{
	
	 fis = getFileInputStream();
	   
	    
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(temp-1);
	    
	    int TotalNumberOfRows = (sheet.getLastRowNum());
	    System.out.println(TotalNumberOfRows);
	   int TotalNumberOfCols =(sheet.getRow(0).getLastCellNum());
	   System.out.println(TotalNumberOfCols);
	   for (int i = r; i<=TotalNumberOfRows; i++)
	   {
		  
		   
			   XSSFRow row = sheet.getRow(i);
			   //String val= row.getCell(TotalNumberOfCols+1).toString();
			   //if(val=="")
			   //{
			   Cell cell=row.createCell(TotalNumberOfCols+1);
				   //Cell cell= row.getCell(TotalNumberOfCols+1);
					  cell.setCellValue(result);
			   //}
			  
		   
	   }
	   FileOutputStream fileOut = new FileOutputStream( prop.readpropkey("testdata_file_path"));
       wb.write(fileOut);
       fileOut.close();
	   
}

		public  int sheetcount() throws IOException
		{
			fis = getFileInputStream();
		    
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		   int sheets=wb.getNumberOfSheets();
		   System.out.println(sheets);
		   if(sheets!=temp)
		   {
			   sheets=temp;
			   
		   }
		   temp=temp+1;
		   wb.close();
		   return sheets;
		}
		

}
	
	
