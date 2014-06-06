//package csvreandandwriter;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import au.com.bytecode.opencsv.CSVReader;
//import au.com.bytecode.opencsv.CSVWriter;
//
//public class WriterCSVDemo {
//
//	public static void main(String[] args) throws IOException {
//
//
//		CSVWriter writer  = new CSVWriter(new FileWriter("D://a.csv"));
//
//		List<String[]> list = new ArrayList<String[]>();
//
//		list.add("name sex age".split(" "));
//
//		for (int i = 0;i< 88888;i++) {
//
//		list.add("brzone female 18".split(" "));
//		}
//
//		writer.writeAll(list);
//		writer.close();
//
//		System.out.println("Writer OK !");
//
//	/*	CSVReader reader = new CSVReader(new FileReader("D://a.csv"));
//
//		String[] line  = null;
//
//		while((line = reader.readNext())!= null) {
//
//			System.out.println(line[0] + "\t" + line[1] + "\t" + line[2]);
//
//		}
//
//		reader.close();*/
//
//
//	}
//
//
//}
