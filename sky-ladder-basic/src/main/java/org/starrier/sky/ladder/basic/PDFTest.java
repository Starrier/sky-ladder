package org.starrier.sky.ladder.basic;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

import static java.lang.System.err;

/**
 * @author starrier
 * @date 2020/11/27
 */
public class PDFTest {

    public static void main(String[] args) {

        PDFTest pdfTest = new PDFTest();
        pdfTest.createHelloDocument();
    }

    public void createPDF() {
        try (final PDDocument document = new PDDocument()) {
            final PDPage emptyPage = new PDPage();
            document.addPage(emptyPage);
            document.save("EmptyPage.pdf");
        } catch (IOException ioEx) {
            err.println(ioEx);
        }
    }

    private void createHelloDocument() {
        final PDPage singlePage = new PDPage();
        final PDFont courierBoldFont = PDType1Font.COURIER_BOLD;
        final int fontSize = 12;
        try (final PDDocument document = new PDDocument()) {
            document.addPage(singlePage);
            final PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
            contentStream.beginText();
            contentStream.setFont(courierBoldFont, fontSize);
            contentStream.newLineAtOffset(150, 750);
            contentStream.showText("Hello PDFBox");
            contentStream.endText();
            contentStream.close();  // Stream must be closed before saving document.

            document.save("HelloPDFBox.pdf");
        } catch (IOException ioEx) {
            err.println(
                    "Exception while trying to create simple document - " + ioEx);
        }
    }
}
