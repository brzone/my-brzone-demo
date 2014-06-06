package saxparsexml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAX extends DefaultHandler{

    public TestSAX(){
        super();
    }
    
    public void startElement(String uri, String localName, String qName, Attributes atts)throws SAXException{
        /*if(qName.equalsIgnoreCase("person")){
            String age=atts.getValue("age");
            if(age!=null)
                System.out.println("age: "+age);
            else System.out.println("age: 20");
        }
        else if(qName.equalsIgnoreCase("name")){
            tagName="name";
        }
        else if(qName.equalsIgnoreCase("college")){
            tagName="college";
        }
        else if(qName.equalsIgnoreCase("telephone")){
            tagName="telephone";
        }
        else if(qName.equalsIgnoreCase("notes")){
            tagName="notes";
        }*/
        if("person".equals(qName)){
            String age=atts.getValue("age");
            if(age!=null)
                System.out.println("age: "+age);
            else System.out.println("age: 20");
        }
        if("name".equals(qName) || "college".equals(qName) || "telephone".equals(qName) || "notes".equals(qName))
            tagName=qName;
        
    }
    
    public void characters(char[] ch, int start, int length)throws SAXException{
        String text=new String(ch,start,length);
        
        if("name".equals(tagName)){
            System.out.println("name: "+text);
        }
        else if("college".equals(tagName)){
            System.out.println("college: "+text);
        }
        else if("telephone".equals(tagName)){
            System.out.println("telephone: "+text);
        }
        else if("notes".equals(tagName)){
            System.out.println("notes: "+text);
        }
        tagName=null;
    }
    
    private String tagName=null;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            TestSAX testSAX=new TestSAX();
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            parser.parse(new File("D:/aa/brzone.txt"), testSAX);
        }
        catch(IOException e){
            e.printStackTrace(); 
        }catch(SAXException e){
            e.printStackTrace(); 
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }

}
