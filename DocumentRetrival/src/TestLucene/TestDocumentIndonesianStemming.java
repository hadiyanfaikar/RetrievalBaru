
package TestLucene;

import Model.Document;

public class TestDocumentIndonesianStemming {
    public static void main(String[] args) {
        Document doc = new Document(1,"Dia sedang pergi berbelanja di pusat perbelanjaan.");
        doc.IndonesiaStemming();
        System.out.println(doc);
        
    }
}
