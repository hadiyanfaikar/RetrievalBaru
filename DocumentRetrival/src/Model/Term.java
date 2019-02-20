package Model;

import java.util.ArrayList;

public class Term implements Comparable<Term>{

    private String term;
    private ArrayList<Posting> PostingList = new ArrayList<Posting>();

    public Term(String term) {
        this.term = term;
    }

    public ArrayList<Posting> getPostingList() {
        return PostingList;
    }

    public void setPostingList(ArrayList<Posting> PostingList) {
        this.PostingList = PostingList;
    }

    public int getNumberOfDocument() {
        return PostingList.size();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public int compareTo(Term o) {
        return term.compareToIgnoreCase(o.getTerm());
    }
}
