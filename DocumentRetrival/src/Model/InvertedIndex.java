/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class InvertedIndex {

    private ArrayList<Document> listOfDocument = new ArrayList<Document>();
    private ArrayList<Term> dictionary = new ArrayList<Term>();

    public InvertedIndex() {
    }

    public ArrayList<Term> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<Term> dictionary) {
        this.dictionary = dictionary;
    }

    public ArrayList<Document> getListOfDocument() {
        return listOfDocument;
    }

    public void setListOfDocument(ArrayList<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    public void addNewDocument(Document document) {
        listOfDocument.add(document);
    }

    public ArrayList<Posting> getUnsortedPostingList() {
        // siapkan posting List
        ArrayList<Posting> list = new ArrayList<Posting>();
        // buat node Posting utk listofdocument
        for (int i = 0; i < listOfDocument.size(); i++) {
            // buat listOfTerm dari document ke -i
            String[] termResult = listOfDocument.get(i).getListofTerm();
            // loop sebanyak term dari document ke i
            for (int j = 0; j < termResult.length; j++) {
                // buat object tempPosting
                Posting tempPosting = new Posting(termResult[j],
                        listOfDocument.get(i));
                list.add(tempPosting);
            }
        }
        return list;
    }

    public ArrayList<Posting> getSortedPostingList() {
        //siapkan posting list
        ArrayList<Posting> list = new ArrayList<Posting>();
        //panggil list yang belum terurut
        list = this.getUnsortedPostingList();
        //urutkan
        Collections.sort(list);
        return list;
    }

    public ArrayList<Posting> search(String query) {
        MakeDictionary();
        String tempQuery[] = query.split(" ");
        for (int i = 0; i < tempQuery.length; i++) {
            String string = tempQuery[i];
        }
        return null;
    }

    public ArrayList<Posting> SearchOneWord(String word) {
        Term tempTerm = new Term(word);
        if (getDictionary().isEmpty()) {
            return null;
        } else {
            int PositionTerm = Collections.binarySearch(dictionary, tempTerm);
            if (PositionTerm < 0) {
                //tidak ditemukan
                return null;
            } else {
                return dictionary.get(PositionTerm).getPostingList();
            }
        }
    }

    public ArrayList<Posting> Intersection(ArrayList<Posting> p1, ArrayList<Posting> p2) {
        ArrayList<Posting> list1 = new ArrayList<Posting>();
        for (Posting posting : p1) {
            list1.add(posting);
        }
        ArrayList<Posting> list2 = new ArrayList<Posting>();
        for (Posting posting : p2) {
            if (list2.contains(p2)) {
                list2.addAll(p2);
            }
        }
        return Intersection(p1, p2);
    }

    public void MakeDictionary() {
        // buat posting list term terurut
        ArrayList<Posting> list = getSortedPostingList();
        // looping buat list of term (dictionary)
        for (int i = 0; i < list.size(); i++) {
            // cek dictionary kosong?
            if (getDictionary().isEmpty()) {
                // buat term
                Term term = new Term(list.get(i).getTerm());
                // tambah posting ke posting list utk term ini
                term.getPostingList().add(list.get(i));
                // tambah ke dictionary
                getDictionary().add(term);
            } else {
                // dictionary sudah ada isinya
                Term tempTerm = new Term(list.get(i).getTerm());
                // pembandingan apakah term sudah ada atau belum
                // luaran dari binarysearch adalah posisi
                int position = Collections.binarySearch(getDictionary(), tempTerm);
                if (position < 0) {
                    // term baru
                    // tambah postinglist ke term
                    tempTerm.getPostingList().add(list.get(i));
                    // tambahkan term ke dictionary
                    getDictionary().add(tempTerm);
                } else {
                    // term ada
                    // tambahkan postinglist saja dari existing term
                    getDictionary().get(position).
                            getPostingList().add(list.get(i));
                    // urutkan posting list
                    Collections.sort(getDictionary().get(position)
                            .getPostingList());
                }
                // urutkan term dictionary
                Collections.sort(getDictionary());
            }

        }
    }
}
