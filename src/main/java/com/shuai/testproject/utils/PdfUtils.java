package com.shuai.testproject.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


/**
 * @author shuai
 */
public class PdfUtils {

    private static final Logger logger = LoggerFactory.getLogger(PdfUtils.class);

    public static void setResponseContentType(HttpServletResponse response, String fileName) {
        try {
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".pdf");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void downloadPdf(Map<String, String> dataMap, HttpServletResponse response) {
        // 定义全局的字体静态变量
        Font titlefont;
        Font headfont;
        Font keyfont = null;
        Font textfont = null;
        Font content = null;
        Font space = null;
        Font space1 = null;
        Font space2 = null;
        Font space3 = null;
        // 最大宽度
        try {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titlefont = new Font(bfChinese, 16, Font.BOLD);
            headfont = new Font(bfChinese, 14, Font.BOLD);
            keyfont = new Font(bfChinese, 22, Font.BOLD);
            textfont = new Font(bfChinese, 15, Font.NORMAL);
            content = new Font(bfChinese, 16, Font.NORMAL);
            space = new Font(bfChinese, 5, Font.NORMAL);
            space1 = new Font(bfChinese, 20, Font.NORMAL);
            space2 = new Font(bfChinese, 20, Font.NORMAL);
            space3 = new Font(bfChinese, 3, Font.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseFont bf;
        Font font = null;
        try {
            //创建字体
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            //使用字体并给出颜色
            font = new Font(bf, 36, Font.BOLD, BaseColor.RED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document document = new Document(new Rectangle(PageSize.A4));

        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            //打开PDF文件
            document.open();
            //设置内容
            Paragraph paragraph = new Paragraph("文档标题", font);
            //居中设置
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            //日期
            Paragraph paragraph8 = new Paragraph(dataMap.get("${date}"), content);
            //向右
            paragraph8.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph8);

            document.add(new Paragraph("\n", space1));
            //落款
            Paragraph paragraph9 = new Paragraph(dataMap.get("${inspectionTeamLeaderInfo}"), content);
            paragraph9.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph9);

            //页尾横线
            document.add(new Paragraph("\n", space2));
            document.add(new Paragraph("\n", space2));
            LineSeparator lineEnd = new LineSeparator(3f, 100, BaseColor.RED, Element.ALIGN_CENTER, 0f);
            document.add(lineEnd);
            document.add(new Paragraph("\n", space3));
            LineSeparator lineEnd1 = new LineSeparator(1f, 100, BaseColor.RED, Element.ALIGN_CENTER, 0f);
            document.add(lineEnd1);


            //关闭文档
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导出pdf失败：{}", e);
        }


    }

}
