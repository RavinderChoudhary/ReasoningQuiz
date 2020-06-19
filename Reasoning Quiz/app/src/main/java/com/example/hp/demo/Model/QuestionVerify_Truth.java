package com.example.hp.demo.Model;

public class QuestionVerify_Truth {
    private int ID10;
    private String QUESTION10;
    private String OPTA10;
    private String OPTB10;
    private String OPTC10;
    private String OPTD10;
    private String ANSWER10;
    private String CATEGORY10;


    public QuestionVerify_Truth() {
        ID10 = 0;
        QUESTION10 = "";
        OPTA10 = "";
        OPTB10 = "";
        OPTC10 = "";
        OPTD10 = "";
        CATEGORY10="";
    }

    public QuestionVerify_Truth(String qUESTION10, String oPTA10, String oPTB10, String oPTC10, String oPTD10,
                             String aNSWER10,String cATEGORY10) {

        QUESTION10 = qUESTION10;
        OPTA10 = oPTA10;
        OPTB10 = oPTB10;
        OPTC10 = oPTC10;
        OPTD10 = oPTD10;
        ANSWER10 = aNSWER10;
        CATEGORY10=cATEGORY10;
    }

    public int getID10() {
        return ID10;
    }

    public void setID10(int ID10) {
        this.ID10 = ID10;
    }

    public String getQUESTION10() {
        return QUESTION10;
    }

    public void setQUESTION10(String QUESTION10) {
        this.QUESTION10 = QUESTION10;
    }

    public String getOPTA10() {
        return OPTA10;
    }

    public void setOPTA10(String OPTA10) {
        this.OPTA10 = OPTA10;
    }

    public String getOPTB10() {
        return OPTB10;
    }

    public void setOPTB10(String OPTB10) {
        this.OPTB10 = OPTB10;
    }

    public String getOPTC10() {
        return OPTC10;
    }

    public void setOPTC10(String OPTC10) {
        this.OPTC10 = OPTC10;
    }

    public String getOPTD10() {
        return OPTD10;
    }

    public void setOPTD10(String OPTD10) {
        this.OPTD10 = OPTD10;
    }

    public String getANSWER10() {
        return ANSWER10;
    }

    public void setANSWER10(String ANSWER10) {
        this.ANSWER10 = ANSWER10;
    }

    public String getCATEGORY10() {
        return CATEGORY10;
    }

    public void setCATEGORY10(String CATEGORY10) {
        this.CATEGORY10 = CATEGORY10;
    }
}
