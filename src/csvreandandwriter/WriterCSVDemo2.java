/*package csvreandandwriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import au.com.bytecode.opencsv.CSVWriter;

public class WriterCSVDemo2 {

	public static void main(String[] args) throws IOException {

		CSVWriter writer  = new CSVWriter(new OutputStreamWriter(new FileOutputStream("D:/a5.csv"),"GBK"));

		for (int i = 0;i< 100000;i++) {
		writer.writeNext("城,市,让,生,活,更,美,好".split(","));
		}

		writer.close();

		System.out.println("OK");

	}

}
*/