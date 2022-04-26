package uz.tatu.filecontrol.tests;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadParseDocument2 {

    public static void main(String[] args) throws IOException {

        String fileName = "files/salom.docx";

        try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(fileName)))) {

            // output the same as 8.1
            List<XWPFParagraph> list = doc.getParagraphs();
            for (XWPFParagraph paragraph : list) {
                System.out.println(paragraph.getText());
                System.out.println("************************************");
            }

        }

    }

}