package data;

import java.util.ArrayList;

public class Answer {
    int aid;
    int qid;
    ArrayList<String> jCodeList = new ArrayList<>();

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public ArrayList<String> getjCodeList() {
        return jCodeList;
    }

    public void setjCodeList(ArrayList<String> jCodeList) {
        this.jCodeList = jCodeList;
    }
}
