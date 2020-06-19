package com.example.hp.demo.Model;

public class QuestionNum_Ana {
    private int ID8;
    private String QUESTION8;
    private String OPTA8;
    private String OPTB8;
    private String OPTC8;
    private String OPTD8;
    private String ANSWER8;
    private String CATEGORY8;


    public QuestionNum_Ana() {
        ID8 = 0;
        QUESTION8 = "";
        OPTA8 = "";
        OPTB8 = "";
        OPTC8 = "";
        OPTD8 = "";
        CATEGORY8="";
    }

    public QuestionNum_Ana(String qUESTION8, String oPTA8, String oPTB8, String oPTC8, String oPTD8,
                             String aNSWER8,String cATEGORY8) {

        QUESTION8 = qUESTION8;
        OPTA8 = oPTA8;
        OPTB8 = oPTB8;
        OPTC8 = oPTC8;
        OPTD8 = oPTD8;
        ANSWER8 = aNSWER8;
        CATEGORY8=cATEGORY8;
    }

    public int getID8() {
        return ID8;
    }

    public void setID8(int ID8) {
        this.ID8 = ID8;
    }

    public String getQUESTION8() {
        return QUESTION8;
    }

    public void setQUESTION8(String QUESTION8) {
        this.QUESTION8 = QUESTION8;
    }

    public String getOPTA8() {
        return OPTA8;
    }

    public void setOPTA8(String OPTA8) {
        this.OPTA8 = OPTA8;
    }

    public String getOPTB8() {
        return OPTB8;
    }

    public void setOPTB8(String OPTB8) {
        this.OPTB8 = OPTB8;
    }

    public String getOPTC8() {
        return OPTC8;
    }

    public void setOPTC8(String OPTC8) {
        this.OPTC8 = OPTC8;
    }

    public String getOPTD8() {
        return OPTD8;
    }

    public void setOPTD8(String OPTD8) {
        this.OPTD8 = OPTD8;
    }

    public String getANSWER8() {
        return ANSWER8;
    }

    public void setANSWER8(String ANSWER8) {
        this.ANSWER8 = ANSWER8;
    }

    public String getCATEGORY8() {
        return CATEGORY8;
    }

    public void setCATEGORY8(String CATEGORY8) {
        this.CATEGORY8 = CATEGORY8;
    }
}
