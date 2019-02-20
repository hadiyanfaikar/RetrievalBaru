package Model;

import java.util.ArrayList;

public class Term {

    private String term;
    private ArrayList<Posting> PostingList = new ArrayList<Posting>();

    public Term(String term) {
        this.term = term;
    }

    public int getNumberOfTerm() {
        return PostingList.size();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
