package chaiji1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class little {

	public static void main(String args[]) {

		try {
			FileWriter fw = new FileWriter("Test11.txt");
			BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
			String n = br.readLine();// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while (n != null) {
				System.out.println(n);
				String s1 = "del subd n=28" + n;
				String el = br.readLine(); // ���Ŷ���һ��
				s1 += " el=" + el + "\r\n";
				fw.write(s1, 0, s1.length());
				String s2 = "del subd n=28" + n.toString() + " st_ope=uas\r\n";
				fw.write(s2, 0, s2.length());
				fw.flush();
				n = br.readLine(); // ���Ŷ���һ��
			}
			fw.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
