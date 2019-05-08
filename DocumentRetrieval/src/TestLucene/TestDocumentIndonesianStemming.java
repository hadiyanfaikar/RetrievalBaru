
package TestLucene;

import Model.Document;

public class TestDocumentIndonesianStemming {
    public static void main(String[] args) {
        Document doc = new Document(1,"Menteri sedang pergi berbelanja di pusat perbelanjaan "
                + "Namun, ibunya melarangnya pergi kesana karena tempat itu sangat berbahaya.");
        doc.IndonesiaStemming();
        System.out.println(doc);
        
    }
}
