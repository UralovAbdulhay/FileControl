package uz.tatu.filecontrol.tests;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocxTest {

    public static void main(String[] args) throws IOException {

        File file = new File("files/salom.abs");

        long l = System.currentTimeMillis();
        try (XWPFDocument doc = new XWPFDocument()) {

            // create a paragraph
            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);

            // set font
            XWPFRun r1 = p1.createRun();
            r1.setBold(true);
            r1.setItalic(true);
            r1.setFontSize(22);
            r1.setFontFamily("New Roman");
            r1.setText("I am first paragraph. qale");

            // save it to .docx file
            try (FileOutputStream out = new FileOutputStream(file)) {
                doc.write(out);
            }

        }

        System.out.println(System.currentTimeMillis() - l);

    }

}
