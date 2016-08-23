package vc.zz.qduxsh.sensormonitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import android.os.Environment;

public class WriteExcel {
	public static boolean writeList(List<Accelerate_info> list) throws IOException{
		  //创建excel工作薄  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        //创建一个工作表sheet  
        HSSFSheet sheet = workbook.createSheet();  
        //创建第一行  
        for (int i = 0; i < list.size(); i++) {
        	HSSFRow row1 = sheet.createRow(i);//参数为行数，为行号-1  
        	//创建单元格  
        	HSSFCell cell_1_1 = row1.createCell(0);//参数为列数，从0开始  
        	cell_1_1.setCellValue(list.get(i)!=null?(list.get(i).getValue()+""):"null");  
        	HSSFCell cell_1_2 = row1.createCell(1);  
        	cell_1_2.setCellValue(list.get(i)!=null?new SimpleDateFormat("HH:mm:ss:SSS").format(new Date(list.get(i).getTime())):"null");  
			
		}
          
          
        //保存为xls文件  
        File file = new File(Environment.getExternalStorageDirectory()+"/SensorData.xls");  
        if(!file.exists()){  
            file.createNewFile();  
        }  
        FileOutputStream outputStream = new FileOutputStream(file);  
        workbook.write(outputStream);//HSSFWorkbook自带写出文件的功能  
        outputStream.close();
        System.out.println("写入成功");
		return true;  
          
	}
}
