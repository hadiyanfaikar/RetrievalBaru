package TestLucene;

import org.apache.lucene.analysis.id.IndonesianStemmer;

public class TestIndonesiaStemmer {

    public static void main(String[] args) {
        IndonesianStemmer stem = new IndonesianStemmer();
        String term = "membunuh";
        char stemTerm[] = term.toCharArray();
        int hasil = stem.stem(stemTerm, term.length(), true);
        System.out.println(hasil);
        System.out.println(stemTerm);
        String result = stemTerm.toString();
        result = result.substring(0, hasil);
        System.out.println(result.toString());
    }
}
