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
			// ����Ҫ��ȡ���ļ�·��

			is = new FileInputStream("d://1.xls");
			// HSSFWorkbook�൱��һ��excel�ļ���HSSFWorkbook�ǽ���excel2007֮ǰ�İ汾��xls��
			// ֮��汾ʹ��XSSFWorkbook��xlsx��
			wb = new HSSFWorkbook(is);
			wb1 = new HSSFWorkbook(is1);
			// ���sheet������
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFSheet sheet1 = wb1.getSheetAt(0);
			HSSFRow row = null;
			HSSFRow row1 = null;
			HSSFCell cell = null;
			HSSFCell cell1 = null;
			int jsum=168;
			for (int i = 1; i < 109; i++) {
				row1 = sheet1.getRow(i); // ѭ����ȡһ�е�����
				cell1 = row1.getCell(1);
				double phone1 = cell1.getNumericCellValue();
				for (int j = 1; j < jsum; j++) {
					row = sheet.getRow(j); // ѭ����ȡһ�е�����
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

			// ������е��У�����Ԫ��

			// ��õ�Ԫ���е�ֵ������õ�Ԫ���ֵΪ���֣�����ʹ��getNumericCellValue����Ϊ�ַ�����ᱨ��
			// ���ȡ���ֵ����print2����
			// double msg = cell.getNumericCellValue();
			// DecimalFormat df = new DecimalFormat("############### ");//
			// // 16λ����λ����С��λ
			// String temp = df.format(msg);
			// System.out.println(temp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
