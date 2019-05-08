package TestPDFBox;

import Model.Document;
import java.io.File;

public class TestDocumentReadPDF {

    public static void main(String[] args) {
        //Loading an existing document
        File file = new File("pdf_reader.pdf");
        Document doc = new Document();
        doc.setId(1);
        doc.ReadPDFFile(file);
        System.out.println(doc);
    }
}
