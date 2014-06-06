package howtomcatwork.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author li.jian
 * @date 2011-9-2 上午10:01:50
 */

public class SimpleSocket {

	public static void execute() throws UnknownHostException, IOException, InterruptedException {
		
		Socket socket = new Socket("www.baidu.com",80);
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));
		
		pw.println("GET / HTTP/1.1");
		
		pw.println();//和请求实体的换行分隔
		
		TimeUnit.SECONDS.sleep(3);//A
		
		
		String line = "";
		
		while((line = br.readLine())!=null){
			
			System.out.println(line);
			
		}
		
		br.close();
		pw.close();//为什么不能A出关闭，在那儿关闭总是抛出Socket Close Exception
		
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		execute();
		
	}
	
}
