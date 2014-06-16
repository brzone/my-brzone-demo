package common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GB2312ToUTF8 {
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * 此方法未测试通过。。。
		 * 
		 */
		
		String filePath = "E:\\giteclipse\\my-brzone-demo\\src\\common\\util\\StringUtil.java";
		
		File f = new File(filePath);
		System.out.println(f.getName());
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		
		String newFilePath = "E:\\giteclipse\\my-brzone-demo\\src\\common\\util\\" + f.getName().split("\\.")[0] + "-new" + "." +f.getName().split("\\.")[1] ;
		File newFile = new File(newFilePath);
		newFile.createNewFile();
		
		PrintWriter pw = new PrintWriter(newFile);
		BufferedWriter bw = new BufferedWriter(pw);
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			bw.write(new String(line.getBytes("GBK"),"UTF-8"));
			bw.write("\n");
		}
		
		bw.close();
		pw.close();
		br.close();
		fr.close();
		System.out.println("ok...");
	}

}
