
package Test;

import Model.Document;
import Model.InvertedIndex;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class TestFileDokumen2 {
     public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File dir = fc.getSelectedFile();
            index.readDirectory(dir); 
        }
        
        ArrayList<Document> listDoc = index.getListOfDocument();
        for (int i = 0; i < args.length; i++) {
            Document doc = listDoc.get(i);
            System.out.println("Content : "+doc.getId());
            System.out.println(doc.getContent());
        }
    }
}
