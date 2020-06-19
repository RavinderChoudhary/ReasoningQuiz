package com.example.hp.demo.Model;

public class QuestionRandom {

    private int ID0;
    private String QUESTION0;
    private String OPTA0;
    private String OPTB0;
    private String OPTC0;
    private String OPTD0;
    private String ANSWER0;

    public QuestionRandom()
    {
        ID0 = 0;
        QUESTION0 = "";
        OPTA0 = "";
        OPTB0 = "";
        OPTC0 = "";
        OPTD0 = "";
    }
    public QuestionRandom(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD,
                          String aNSWER) {

        QUESTION0 = qUESTION;
        OPTA0 = oPTA;
        OPTB0 = oPTB;
        OPTC0 = oPTC;
        OPTD0 = oPTD;
        ANSWER0 = aNSWER;
    }

    public int getID0() {
        return ID0;
    }

    public void setID0(int ID0) {
        this.ID0 = ID0;
    }

    public String getQUESTION0() {
        return QUESTION0;
    }

    public void setQUESTION0(String QUESTION0) {
        this.QUESTION0 = QUESTION0;
    }

    public String getOPTA0() {
        return OPTA0;
    }

    public void setOPTA0(String OPTA0) {
        this.OPTA0 = OPTA0;
    }

    public String getOPTB0() {
        return OPTB0;
    }

    public void setOPTB0(String OPTB0) {
        this.OPTB0 = OPTB0;
    }

    public String getOPTC0() {
        return OPTC0;
    }

    public void setOPTC0(String OPTC0) {
        this.OPTC0 = OPTC0;
    }

    public String getOPTD0() {
        return OPTD0;
    }

    public void setOPTD0(String OPTD0) {
        this.OPTD0 = OPTD0;
    }

    public String getANSWER0() {
        return ANSWER0;
    }

    public void setANSWER0(String ANSWER0) {
        this.ANSWER0 = ANSWER0;
    }

}

