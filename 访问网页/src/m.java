import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class m {
	public static void main(String args[]) {
		try {
			URL url = new URL("http://www.baidu.com");
			// ������
	        URLConnection conn = url.openConnection();

	        // �õ�������
	        InputStream is = conn.getInputStream();

	        // ����IO�����÷���д��һ��Ҫ��Ϥ
	        OutputStream os = new FileOutputStream("baidu.txt");

	        byte[] buffer = new byte[2048];
	        int length = 0;
	        String html="";
	        while (-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer, 0, length);
	            html+=buffer;
	        }
	        is.close();
	        System.out.print(html);
	        os.close();
		} catch (MalformedURLException e) {
			// exception handler code here
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
