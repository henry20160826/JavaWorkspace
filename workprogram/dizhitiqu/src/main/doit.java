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
			// ����Ҫ��ȡ���ļ�·��

			is = new FileInputStream("shuju.xls");
			// HSSFWorkbook�൱��һ��excel�ļ���HSSFWorkbook�ǽ���excel2007֮ǰ�İ汾��xls��
			// ֮��汾ʹ��XSSFWorkbook��xlsx��
			wb = new HSSFWorkbook(is);
			// ���sheet������
			HSSFSheet sheet = wb.getSheet("ȫ��");
			HSSFRow row = null;
			HSSFCell cell = null;
			int[][] guhua = new int[200][30];
			int[][] kuandai = new int[200][30];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i); // ѭ����ȡһ�е�����
				cell = row.getCell(1);
				String string = cell.toString();
				if (string.equals("����̨�����ׯ��¥")) {
					String addressString = row.getCell(3).toString();
//					System.out.println(addressString);
					for (int n = 0; n < addressString.length(); n++) { // ѭ�������ַ���
//						System.out.println(addressString.charAt(n));
						if (Character.isDigit(addressString.charAt(n))) { // ��char��װ���е��ж����ֵķ����ж�ÿһ���ַ�
							addressString = addressString.substring(n);
							break;
						}
					}
					
					
					addressString = addressString.replaceAll("--", "-");
					addressString = addressString.replaceAll("��¥", "-");
					addressString = addressString.replaceAll(" ", "");
					addressString = addressString.replaceAll("��", "-");
					addressString = addressString.replaceAll("¥", "-");
					addressString = addressString.replaceAll("��", "-");
					addressString = addressString.replaceAll("��", "-");

//					System.out.println(addressString);
					String s[] = addressString.split("-");
					String type = row.getCell(2).toString();

					if (type.equals("�̻�")) {
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
