package saxparsexml;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class TestSAXHandler {
	  public TestSAXHandler() {
	  }
	  public static void main(String[] args) {
	    try{
	      //初始化与解析
	      SAXHandler handler = new SAXHandler();
	      SAXParserFactory saxparserfactory = SAXParserFactory.newInstance();
	      SAXParser saxparser = saxparserfactory.newSAXParser();
	 
	      saxparser.parse(new File("D:/aa/brzone.txt"), handler);
	      //解析完后获取解析信息
	      HashMap<String, String> hashMap = handler.getHashMap();
	      System.out.println("姓名\t年龄\t学院\t学院领导\t电话\t\t备注");
	     /* for(int i=0;i<hashMap.size();i+=6){
	        
	    	int j=i/6;
	        System.out.print(hashMap.get("name"+j)+"\t");
	        System.out.print(hashMap.get("person-age"+j)+"\t");
	        System.out.print(hashMap.get("college"+j)+"\t");
	        System.out.print(hashMap.get("college-leader"+j)+"\t");
	        System.out.print(hashMap.get("telephone"+j)+"\t");
	        System.out.println(hashMap.get("notes"+j)+"\t");
	      }*/
	      
	     System.out.println(hashMap);
	      
	      for(int i=0;i<hashMap.size();i++){
		        
		    	
		        System.out.print(hashMap.get("name"+i)+"\t");
		        System.out.print(hashMap.get("person-age"+i)+"\t");
		        System.out.print(hashMap.get("college"+i)+"\t");
		        System.out.print(hashMap.get("college-leader"+i)+"\t");
		        System.out.print(hashMap.get("telephone"+i)+"\t");
		        System.out.println(hashMap.get("notes"+i)+"\t");
		      }
	      
	      
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }
	  }
	}