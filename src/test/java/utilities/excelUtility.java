package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle stlye;
	String path;

	
public excelUtility(String path) {
		this.path=path;
	}
	
	public  int getRowCount(String xlfile, String xlSheet) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	public int getCellCount(String xlfile, String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	
	public String getCellData(String xlfile, String xlsheet,int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
	    cell=row.getCell(cellnum);
	
		String data;
		try {
			//data=cell.toString();
			DataFormatter formatter= new DataFormatter();
			data=formatter.formatCellValue(cell); //Returns the formatted value of a cell as string regardless of cell type
		}
		catch(Exception e){
			data="";
			
		}
		wb.close();
		fi.close();
		return data; 
		
		
	}
	public static void setCellData(String xlfile, String xlsheet, int rownum, int cellnum, String data) throws IOException {
		
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			
			cell=row.createCell(cellnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
	}
	

