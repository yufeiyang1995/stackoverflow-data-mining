package data;

import java.util.ArrayList;

public class Question {
    int qid;
    boolean qHasJCode;
    int aHasCode;
    int aHasNoCode;
    ArrayList<Integer> aidList = new ArrayList<>();
    ArrayList<String> jCodeList = new ArrayList<>();

    @Override
    public String toString() {
        String string = "{";
        string += "qid: " + qid + "; ";
        string += "qHasJCode: " + qHasJCode + "; ";
        string += "aHasCode: " + aHasCode + "; ";
        string += "aHasNoCode: " + aHasNoCode + ";}";
        return string;
    }

    /*
     * Getter & Setter
     */
    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public boolean isqHasJCode() {
        return qHasJCode;
    }

    public void setqHasJCode(boolean qHasJCode) {
        this.qHasJCode = qHasJCode;
    }

    public int getaHasCode() {
        return aHasCode;
    }

    public void setaHasCode(int aHasCode) {
        this.aHasCode = aHasCode;
    }

    public int getaHasNoCode() {
        return aHasNoCode;
    }

    public void setaHasNoCode(int aHasNoCode) {
        this.aHasNoCode = aHasNoCode;
    }

    public ArrayList<Integer> getAidList() {
        return aidList;
    }

    public void setAidList(ArrayList<Integer> aidList) {
        this.aidList = aidList;
    }

    public ArrayList<String> getjCodeList() {
        return jCodeList;
    }

    public void setjCodeList(ArrayList<String> jCodeList) {
        this.jCodeList = jCodeList;
    }
}
