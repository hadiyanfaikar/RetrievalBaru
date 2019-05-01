package TestLucene;

import Model.Document;

public class TestDocumentWithStemmedContent {

    public static void main(String[] args) {
        Document doc = new Document(1,"He was a man with gun");
        System.out.println("Without Stemming");
        System.out.println(doc);
        System.out.println("With Stemming");
        doc.stemming();
        System.out.println(doc);
    }
}
