package itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;


import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

/**
 * use itext produced pdf ,the pdf has words,picture,tables.
 *
 * @author Jian Lee
 * @mail brzone@126.com
 * @date 2012-11-15 下午03:09:23
 */
public class HelloPDF {

	private PdfPCell middle(PdfPCell cell) {
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		return cell;
	}

	public void createPDF() throws DocumentException, IOException {

		String filePath = "hello.pdf";

		// 前面路径是simsun.ttc的路径，后面,1是固定格式，我放在lib目录下
		//由于windows和Linux的文件路径符号不同，需要用File.separator
		String ttcFile = "lib" + File.separator+ "simsun.ttc,1";

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, new FileOutputStream(filePath));

		document.open();

		// 第一个参数是可以输出中文，第二个参数是字体的大小，第三个参数是粗体
		Font chineseFont = new Font(BaseFont.createFont(ttcFile,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 20, Font.BOLD);

		Paragraph pragraph = new Paragraph("Fastview 系统邮件月度简报", chineseFont);

		// 设置文字居中
		pragraph.setAlignment(Image.MIDDLE);

		document.add(pragraph);


		Paragraph pragraph2 = new Paragraph("（2012年11月份）", chineseFont);

		// 设置文字居中
		pragraph2.setAlignment(Image.MIDDLE);

		document.add(pragraph2);

		//换行
		document.add(new Paragraph("\n", chineseFont));

		Font chineseFontNoBold = new Font(BaseFont.createFont(ttcFile,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 17);

		//列表  ，可以有制表符，前面有  1,2,3............
		List itextList = new List(true, 10);

		//这里设置3个列表项
		ListItem firstItem = new ListItem("  报警发生及处理情况", chineseFontNoBold);
		ListItem secondItem = new ListItem("  消防设施故障发生及处理情况.",
				chineseFontNoBold);
		ListItem thirdItem = new ListItem("  消防设施巡检情况", chineseFontNoBold);

		//第一个项添加了下面一些东西。。。
		firstItem.add(new Paragraph("（一） 真实报警", chineseFontNoBold));
		firstItem.add(new Paragraph(" 　全市本月发生真实报警次数：2次。", chineseFontNoBold));
		firstItem.add(new Paragraph("\n", chineseFont));

		firstItem.add(new Paragraph("（二） 真实报警数据分析", chineseFontNoBold));
		firstItem.add(new Paragraph(" 1、累计报警对比", chineseFontNoBold));

		firstItem.add(new Paragraph(
						" 　　　　截止11月底，今年全市发生20起真实报警，当月报警环比降低1起，降低33.33%，与去年同期相比增加1起，增加26.5%。",
						chineseFontNoBold));

		firstItem.add(new Paragraph("\n", chineseFont));
		firstItem.add(new Paragraph("★近三年真实报警走势图", chineseFontNoBold));
		// ★★★★☆
		Image gif = Image.getInstance("aa.jpg");

		// 设置图片居中
		gif.setAlignment(Image.MIDDLE);

		firstItem.add(gif);

		firstItem.add(new Paragraph("\n", chineseFont));
		firstItem.add(new Paragraph("\n", chineseFont));

		firstItem.add(new Paragraph("★各区县近3年真实报警数据汇总", chineseFontNoBold));

		Image gifbb = Image.getInstance("bb.jpg");

		// 设置图片居中
		gifbb.setAlignment(Image.MIDDLE);

		firstItem.add(gifbb);

		firstItem.add(new Paragraph("★在网设备统计表", chineseFontNoBold));
		//小字体
		Font chineseFont2 = new Font(BaseFont.createFont(ttcFile,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, Font.BOLD);

		firstItem.add(new Paragraph("\n", chineseFont2));

		//8列
		PdfPTable table = new PdfPTable(8);

		table.setHorizontalAlignment(Element.ALIGN_CENTER);

		table.setTotalWidth(new float[]{ 70,70,70,70,70,70,70,70,});
        table.setLockedWidth(true);

        String[] header = new String[]{"类型","在网设备","本月数量(台）",
        		"本月新增（台）","本月减少（台）","完好设备（台）","设备完好率","完好环比（台）"};

        //头部信息
        for(String h : header) {

        	PdfPCell mycell = middle(new PdfPCell(new Phrase(h,chineseFont2)));
        	//加个颜色，
        	mycell.setBackgroundColor(BaseColor.YELLOW);

        	table.addCell(mycell);


        }

        //消防主机
        PdfPCell xiaofangCell = new PdfPCell(new Phrase("消防主机",chineseFont2));

        Map<String,java.util.List<String>> xiaofang = new HashMap<String, java.util.List<String>>();
       String xiaofangStringMsg = "智能型主机,295,2,1,288,97.63%,15,改造型报警主机," +
       		                      "1414,0,0,1414,100.00%,32," +
       		                       "早期烟雾告警主机,2999,0,0,2988,99.63%,7,防火防盗监控系统主机,2644,1,1,2618,99.02%," +
       		                       "60,小计,7352,3,2,7308,99.40%,114";
        xiaofang.put("xiaofang", Arrays.asList(xiaofangStringMsg.split(",")));

        //占五行
        xiaofangCell.setRowspan(5);

        table.addCell(middle(xiaofangCell));

        //小字体
        Font chineseFontNoBold2 = new Font(BaseFont.createFont(ttcFile,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13);

        for(String h : xiaofang.get("xiaofang")) {
        	table.addCell(middle(new PdfPCell(new Phrase(h,chineseFontNoBold2))));

        }

        //探头
        PdfPCell tantouCell = new PdfPCell(new Phrase("探头",chineseFont2));
        table.addCell(middle(tantouCell));

        //探头数据
        String tantouStringMsg = "探头,107571,406,200,107350,99.79%,3039";
        for(String h : tantouStringMsg.split(",")) {
        	table.addCell(middle(new PdfPCell(new Phrase(h,chineseFontNoBold2))));

        }

        //联网设备
        PdfPCell liangwangCell = new PdfPCell(new Phrase("联网设备",chineseFont2));

        liangwangCell.setRowspan(4);


        table.addCell(middle(liangwangCell));



        String liangwangStringMsg = "采集设备,3539,1,1,3497,98.81%,415," +
        							"网关设备,5047,3,1,5029,99.25%,626," +
        							"其它设备,426,1,2,389,90.16%,-14," +
        							"小计,9012,5,4,6222,98.46%,1027";

        Map<String,java.util.List<String>> liangwang = new HashMap<String, java.util.List<String>>();
        liangwang.put("liangwang", Arrays.asList(liangwangStringMsg.split(",")));

        for(String h : liangwang.get("liangwang")) {
        	table.addCell(middle(new PdfPCell(new Phrase(h,chineseFontNoBold2))));

        }



        firstItem.add(table);


		//添加其他的项
		itextList.add(firstItem);
		itextList.add(secondItem);
		itextList.add(thirdItem);

		//文档添加列表
		document.add(itextList);

		//结束。
		document.close();

	}

	public static void main(String[] args) throws DocumentException,
			IOException {

		new HelloPDF().createPDF();

	}

}
