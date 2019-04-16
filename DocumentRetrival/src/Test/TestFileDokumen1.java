
package Test;

import Model.Document;
import Model.InvertedIndex;
import java.io.File;
import java.util.ArrayList;


public class TestFileDokumen1 {
    public static void main(String[] args) {
        File dir = new File("test");
        InvertedIndex index = new InvertedIndex();
        index.readDirectory(dir);
        ArrayList<Document> listDoc = index.getListOfDocument();
        for (int i = 0; i < args.length; i++) {
            Document doc = listDoc.get(i);
            System.out.println("Content : "+doc.getId());
            System.out.println(doc.getContent());
        }
    }
}
