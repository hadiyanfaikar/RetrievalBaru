
package Test;

import Model.Document;
import java.io.File;

public class TestFileDokumen {
     public static void main(String[] args) {
        Document doc = new Document();
        File file = new File("doc1.txt");
        doc.readFile(1, file);
        System.out.println("Isi Dokumen:");
        System.out.println(doc.getContent());
    }
}
