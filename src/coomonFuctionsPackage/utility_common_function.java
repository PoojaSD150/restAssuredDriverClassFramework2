package coomonFuctionsPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_common_function {
	public static void evidencefilecreator(String filename,String requestbody ,String responsebody) throws IOException {
		File newfile = new File("C:\\Users\\Dr Kale\\Desktop\\testing document\\staticRest" +filename+".txt");
		System.out.println("a new text file creaated to record request and response of the API :"+newfile.getName());
		
		FileWriter datawrite= new FileWriter(newfile);
		datawrite.write( "request body:" +requestbody+"\n\n" );
		datawrite.write("response body:" +responsebody);
		datawrite.close();
		System.out.println("requestbody and responsebody are saved in" +newfile.getName());
	}	

	public static ArrayList<String> readDataExcel (String sheetname,String testcasename ) throws IOException
	{
		ArrayList<String>ArrayData=new ArrayList<String>();
		
		//Step1:create object of file input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\Dr Kale\\Desktop\\testing document\\RestAssured\\BOOK.xlsx");
		
		//step2:access the excel file
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//step3:access the sheet name
		int countofsheet=workbook.getNumberOfSheets();
		
		for(int i=0 ; i< countofsheet ; i++) {
			String filesheetname=workbook.getSheetName(i);
			
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4:access the row from where the data is suppose  to fetch
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				Iterator<Row> rows=sheet.iterator();
				 
				 // Row r =rows.next();
				  
				   while(rows.hasNext()) {
					   Row r2=rows.next();
					   
					   if(r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename)) {
						   Iterator<Cell>cellvalues=r2.cellIterator();
						    
						    while(cellvalues.hasNext()) {
						    	 String testdata=cellvalues.next().getStringCellValue();
						    	 
						    	  ArrayData.add(testdata);
						    	  
						    }
					
					   }
				   }
			}
		}
			
		    workbook.close();
		    return ArrayData;
		}
	}

