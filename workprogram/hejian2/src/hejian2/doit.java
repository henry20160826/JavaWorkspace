package hejian2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class doit {

	public static void main(String args[]) {
		
		
		HSSFWorkbook wb = null;
		HSSFWorkbook wb1 = null;
		FileInputStream is = null;
		FileInputStream is1 = null;
		try {
			// 设置要读取的文件路径

			is = new FileInputStream("d://1.xls");
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new HSSFWorkbook(is);
			wb1 = new HSSFWorkbook(is1);
			// 获得sheet工作簿
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFSheet sheet1 = wb1.getSheetAt(0);
			HSSFRow row = null;
			HSSFRow row1 = null;
			HSSFCell cell = null;
			HSSFCell cell1 = null;
			int jsum=168;
			for (int i = 1; i < 109; i++) {
				row1 = sheet1.getRow(i); // 循环获取一行的中列
				cell1 = row1.getCell(1);
				double phone1 = cell1.getNumericCellValue();
				for (int j = 1; j < jsum; j++) {
					row = sheet.getRow(j); // 循环获取一行的中列
					cell = row.getCell(1);
					System.out.println(i + "," + j);
					double phone = cell.getNumericCellValue();
					if (phone == phone1) {
						// for(int k=3;k<41;k++)
						// cell.setCellValue();
						sheet.removeRow(row);
						jsum--;
						break;
					}
				}
			}
			FileOutputStream os = new FileOutputStream("d://1.xls");
			wb.write(os);
			is.close();
			os.close();

			// 获得行中的列，即单元格

			// 获得单元格中的值，这里该单元格的值为数字，所以使用getNumericCellValue，如为字符串则会报错
			// 如何取别的值，见print2方法
			// double msg = cell.getNumericCellValue();
			// DecimalFormat df = new DecimalFormat("############### ");//
			// // 16位整数位，两小数位
			// String temp = df.format(msg);
			// System.out.println(temp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
