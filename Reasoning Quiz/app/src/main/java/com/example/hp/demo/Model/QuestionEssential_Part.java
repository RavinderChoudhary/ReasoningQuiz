package com.example.hp.demo.Model;

public class QuestionEssential_Part {
    private int ID12;
    private String QUESTION12;
    private String OPTA12;
    private String OPTB12;
    private String OPTC12;
    private String OPTD12;
    private String ANSWER12;
    private String CATEGORY12;


    public QuestionEssential_Part() {
        ID12 = 0;
        QUESTION12 = "";
        OPTA12 = "";
        OPTB12 = "";
        OPTC12 = "";
        OPTD12 = "";
        CATEGORY12="";
    }

    public QuestionEssential_Part(String qUESTION12, String oPTA12, String oPTB12, String oPTC12, String oPTD12,
                             String aNSWER12,String cATEGORY12) {

        QUESTION12 = qUESTION12;
        OPTA12 = oPTA12;
        OPTB12 = oPTB12;
        OPTC12 = oPTC12;
        OPTD12 = oPTD12;
        ANSWER12 = aNSWER12;
        CATEGORY12=cATEGORY12;
    }

    public int getID12() {
        return ID12;
    }

    public void setID12(int ID12) {
        this.ID12 = ID12;
    }

    public String getQUESTION12() {
        return QUESTION12;
    }

    public void setQUESTION12(String QUESTION12) {
        this.QUESTION12 = QUESTION12;
    }

    public String getOPTA12() {
        return OPTA12;
    }

    public void setOPTA12(String OPTA12) {
        this.OPTA12 = OPTA12;
    }

    public String getOPTB12() {
        return OPTB12;
    }

    public void setOPTB12(String OPTB12) {
        this.OPTB12 = OPTB12;
    }

    public String getOPTC12() {
        return OPTC12;
    }

    public void setOPTC12(String OPTC12) {
        this.OPTC12 = OPTC12;
    }

    public String getOPTD12() {
        return OPTD12;
    }

    public void setOPTD12(String OPTD12) {
        this.OPTD12 = OPTD12;
    }

    public String getANSWER12() {
        return ANSWER12;
    }

    public void setANSWER12(String ANSWER12) {
        this.ANSWER12 = ANSWER12;
    }

    public String getCATEGORY12() {
        return CATEGORY12;
    }

    public void setCATEGORY12(String CATEGORY12) {
        this.CATEGORY12 = CATEGORY12;
    }
}
