package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class doit {

	public static void main(String args[]) {

		HSSFWorkbook wb = null;
		FileInputStream is = null;
		try {
			// 设置要读取的文件路径

			is = new FileInputStream("shuju.xls");
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new HSSFWorkbook(is);
			// 获得sheet工作簿
			HSSFSheet sheet = wb.getSheet("全部");
			HSSFRow row = null;
			HSSFCell cell = null;
			int[][] guhua = new int[200][30];
			int[][] kuandai = new int[200][30];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i); // 循环获取一行的中列
				cell = row.getCell(1);
				String string = cell.toString();
				if (string.equals("八里台镇大孙庄村楼")) {
					String addressString = row.getCell(3).toString();
//					System.out.println(addressString);
					for (int n = 0; n < addressString.length(); n++) { // 循环遍历字符串
//						System.out.println(addressString.charAt(n));
						if (Character.isDigit(addressString.charAt(n))) { // 用char包装类中的判断数字的方法判断每一个字符
							addressString = addressString.substring(n);
							break;
						}
					}
					
					
					addressString = addressString.replaceAll("--", "-");
					addressString = addressString.replaceAll("号楼", "-");
					addressString = addressString.replaceAll(" ", "");
					addressString = addressString.replaceAll("号", "-");
					addressString = addressString.replaceAll("楼", "-");
					addressString = addressString.replaceAll("门", "-");
					addressString = addressString.replaceAll("栋", "-");

//					System.out.println(addressString);
					String s[] = addressString.split("-");
					String type = row.getCell(2).toString();

					if (type.equals("固话")) {
//						System.out.println(i);
						
						if (s.length == 0) {
							guhua[1][1]++;
						} else if (s.length == 1) {
							if (isNumeric(s[0])) {
								guhua[Integer.parseInt(s[0])][1]++;
							}
							else{
								guhua[1][1]++;
							}
						} else {
							if (isNumeric(s[0]) && isNumeric(s[1])) {
								guhua[Integer.parseInt(s[0])][Integer
										.parseInt(s[1])]++;
							} else if (isNumeric(s[0]) && !isNumeric(s[1])) {
								guhua[Integer.parseInt(s[0])][1]++;
							} else {
								guhua[1][1]++;
							}
						}

					} else {
//						System.out.println(i + "");
						if (s.length == 0) {
							kuandai[1][1]++;
						} else if (s.length == 1) {
							if (isNumeric(s[0])) {
								kuandai[Integer.parseInt(s[0])][1]++;
							}
							else{
								kuandai[1][1]++;
							}
						} else {
							if (isNumeric(s[0]) && isNumeric(s[1])) {
								kuandai[Integer.parseInt(s[0])][Integer
										.parseInt(s[1])]++;
							} else if (isNumeric(s[0]) && !isNumeric(s[1])) {
								kuandai[Integer.parseInt(s[0])][1]++;
							} else {
								kuandai[1][1]++;
							}
						}
					}

					// System.out.println(addressString);

				}

			}
			for (int i = 0; i < 200; i++) {
				for (int j = 0; j < 30; j++) {
					if (guhua[i][j] != 0) {
						System.out.println(i + " " + j + " " + guhua[i][j]
								+ " " + kuandai[i][j]);
					}
				}
			}
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isNumeric(String str) {
		if (str.isEmpty()) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
