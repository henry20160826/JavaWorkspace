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
			// 设置要读取的文件路径
			fs = new POIFSFileSystem(new FileInputStream("d:\\book.xls"));
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new HSSFWorkbook(fs);
			// 获得sheet工作簿
			HSSFSheet sheet = wb.getSheetAt(0);
			// // 获得行
			// HSSFRow row = sheet.getRow(4);
			// // 获得行中的列，即单元格
			// HSSFCell cell = row.getCell(1);
			// 获得单元格中的值，这里该单元格的值为数字，所以使用getNumericCellValue，如为字符串则会报错
			// 如何取别的值，见print2方法
			// double msg = cell.getNumericCellValue();
			// DecimalFormat df = new DecimalFormat("############### ");//
			// 16位整数位，两小数位
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
		String s1 = "由于信号问题，造成用户无法正常使用，申请为用户减免费用";
		String s2 = "由于优惠资费争议，申请为用户减免费用";
		String s3 = "用户现场服务投诉，申请为用户减免费用";
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
		
		System.out.println(haomaf+s+"，请领导审批");
		
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
//					s = s + temp + "：" + feiyong + "元，";
//				} else if (i % 3 == 1) {
//					s = s + temp + "：" + feiyong + "元，";
//				} else {
//					s = s + temp + "：" + feiyong + "元，";
//				}
//			}
//		}
//		if (true == ifprint) {
//			HSSFCell cell = row.getCell(1);
//			double haoma = cell.getNumericCellValue();
//			DecimalFormat df = new DecimalFormat("###########");
//			String haomaf = df.format(haoma);
//			System.out.println(haomaf);
//			//System.out.println(s + "请领导审批");
////			System.out.println(sum);
	//	}

	}
}
