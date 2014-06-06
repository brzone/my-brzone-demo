package ex01.pyrmont;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

/* 
 HTTP Response = Status-Line 
 *(( general-header | response-header | entity-header ) CRLF) 
 CRLF 
 [ message-body ] 
 Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF 
 */

public class Response {

	private static final int BUFFER_SIZE = 1024;
	
	/*主要是从Request中获取请求的url地址*/
	Request request;
	
	/*通过OutputStream向请求的客户端发送数据*/
	OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			System.out.println("web_root:" + HttpServer.WEB_ROOT);
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch != -1) {
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			} else {
				// file not found
				
				//反应头和反应实体，应该有俩个\r\n
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-Length: 30\r\n" + "\r\n" +

						"<h1>" +request.getUri() +"File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			// thrown if cannot instantiate a File object
			System.out.println(e.toString());
		} finally {
			if (fis != null)
				fis.close();
		}
	}
}
