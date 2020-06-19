package com.example.hp.demo.Model;

public class QuestionNumber_Series {
    private int ID6;
    private String QUESTION6;
    private String OPTA6;
    private String OPTB6;
    private String OPTC6;
    private String OPTD6;
    private String ANSWER6;
    private String CATEGORY6;


    public QuestionNumber_Series() {
        ID6 = 0;
        QUESTION6 = "";
        OPTA6 = "";
        OPTB6 = "";
        OPTC6 = "";
        OPTD6 = "";
        CATEGORY6="";
    }

    public QuestionNumber_Series(String qUESTION6, String oPTA6, String oPTB6, String oPTC6, String oPTD6,
                             String aNSWER6,String cATEGORY6) {

        QUESTION6 = qUESTION6;
        OPTA6 = oPTA6;
        OPTB6 = oPTB6;
        OPTC6 = oPTC6;
        OPTD6 = oPTD6;
        ANSWER6 = aNSWER6;
        CATEGORY6=cATEGORY6;
    }

    public int getID6() {
        return ID6;
    }

    public void setID6(int ID6) {
        this.ID6 = ID6;
    }

    public String getQUESTION6() {
        return QUESTION6;
    }

    public void setQUESTION6(String QUESTION6) {
        this.QUESTION6 = QUESTION6;
    }

    public String getOPTA6() {
        return OPTA6;
    }

    public void setOPTA6(String OPTA6) {
        this.OPTA6 = OPTA6;
    }

    public String getOPTB6() {
        return OPTB6;
    }

    public void setOPTB6(String OPTB6) {
        this.OPTB6 = OPTB6;
    }

    public String getOPTC6() {
        return OPTC6;
    }

    public void setOPTC6(String OPTC6) {
        this.OPTC6 = OPTC6;
    }

    public String getOPTD6() {
        return OPTD6;
    }

    public void setOPTD6(String OPTD6) {
        this.OPTD6 = OPTD6;
    }

    public String getANSWER6() {
        return ANSWER6;
    }

    public void setANSWER6(String ANSWER6) {
        this.ANSWER6 = ANSWER6;
    }

    public String getCATEGORY6() {
        return CATEGORY6;
    }

    public void setCATEGORY6(String CATEGORY6) {
        this.CATEGORY6 = CATEGORY6;
    }
}
