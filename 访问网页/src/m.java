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
			// 打开连接
	        URLConnection conn = url.openConnection();

	        // 得到输入流
	        InputStream is = conn.getInputStream();

	        // 关于IO流的用法和写法一定要熟悉
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
