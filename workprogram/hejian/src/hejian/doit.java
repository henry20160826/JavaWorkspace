package hejian;

import java.io.FileInputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class doit {
	private static double sum = 0;

	public static void main(String args[]) {
		HSSFWorkbook wb = null;
		POIFSFileSystem fs = null;
		try {
			// ����Ҫ��ȡ���ļ�·��
			fs = new POIFSFileSystem(new FileInputStream("d:\\book.xls"));
			// HSSFWorkbook�൱��һ��excel�ļ���HSSFWorkbook�ǽ���excel2007֮ǰ�İ汾��xls��
			// ֮��汾ʹ��XSSFWorkbook��xlsx��
			wb = new HSSFWorkbook(fs);
			// ���sheet������
			HSSFSheet sheet = wb.getSheetAt(0);
			// // �����
			// HSSFRow row = sheet.getRow(4);
			// // ������е��У�����Ԫ��
			// HSSFCell cell = row.getCell(1);
			// ��õ�Ԫ���е�ֵ������õ�Ԫ���ֵΪ���֣�����ʹ��getNumericCellValue����Ϊ�ַ�����ᱨ��
			// ���ȡ���ֵ����print2����
			// double msg = cell.getNumericCellValue();
			// DecimalFormat df = new DecimalFormat("############### ");//
			// 16λ����λ����С��λ
			// String temp = df.format(msg);
			// System.out.println(temp);
			// 420
			for (int i = 0; i < 905; i++) {
				doOne(sheet, i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void doOne(HSSFSheet sheet, int i) {
		String s1 = "�����ź����⣬����û��޷�����ʹ�ã�����Ϊ�û��������";
		String s2 = "�����Ż��ʷ����飬����Ϊ�û��������";
		String s3 = "�û��ֳ�����Ͷ�ߣ�����Ϊ�û��������";
		String s = null;
		if (i % 3 == 0) {
			s = s1;
		} else if (i % 3 == 1) {
			s = s2;
		} else {
			s = s3;
		}

		HSSFRow row = sheet.getRow(i);
		HSSFCell cell = row.getCell(0);
		double haoma = cell.getNumericCellValue();
		DecimalFormat df = new DecimalFormat("###########");
		String haomaf = df.format(haoma);
		
		System.out.println(haomaf+s+"�����쵼����");
		
//		boolean ifprint = false;
//		for (int j = 3; j < 41; j++) {
//			HSSFCell cell = row.getCell(j);
//			double feiyong = cell.getNumericCellValue();
//			if (feiyong != 0 && feiyong >= 200) {
//				ifprint = true;
//				if (feiyong >= 499) {
//					feiyong = 499;
//				}
//				sum += feiyong;
////				System.out.println(feiyong+"");
//				HSSFCell cellyue = yuefen.getCell(j);
//				double douyue = cellyue.getNumericCellValue();
//				DecimalFormat df = new DecimalFormat("######");
//				String temp = df.format(douyue);
//				if (i % 3 == 0) {
//					s = s + temp + "��" + feiyong + "Ԫ��";
//				} else if (i % 3 == 1) {
//					s = s + temp + "��" + feiyong + "Ԫ��";
//				} else {
//					s = s + temp + "��" + feiyong + "Ԫ��";
//				}
//			}
//		}
//		if (true == ifprint) {
//			HSSFCell cell = row.getCell(1);
//			double haoma = cell.getNumericCellValue();
//			DecimalFormat df = new DecimalFormat("###########");
//			String haomaf = df.format(haoma);
//			System.out.println(haomaf);
//			//System.out.println(s + "���쵼����");
////			System.out.println(sum);
	//	}

	}
}
