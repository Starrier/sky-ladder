package org.starrier.sky.ladder.basic.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author starrier
 * @date 2020/11/27
 */
public class PdfReaderTest {

    public static void main(String[] args) throws IOException {

        PdfReaderTest pf = new PdfReaderTest();
        String s = pfdReaderTest();

    }

    public static String pfdReaderTest() throws IOException {
        File pdfFile = new File("/Users/starrier/Downloads/nacos.pdf");
        PDDocument document = PDDocument.load(pdfFile);
        // 获取页码
        int pages = document.getNumberOfPages();

        // 读文本内容
        PDFTextStripper stripper = new PDFTextStripper();
        ;

        // 设置按顺序输出
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pages);
        String content = stripper.getText(document);
        System.out.println(content);
        return content;
    }

}
