package TestLucene;

import Model.Document;

public class TestDocumentWithoutStopWord {

    public static void main(String[] args) {
        Document doc = new Document(1, "He was a man with gun");
        System.out.println("With Stop Word");
        System.out.println(doc);
        System.out.println("Without Stop word");
        doc.removeStopWords();
        System.out.println(doc);
    }
}
