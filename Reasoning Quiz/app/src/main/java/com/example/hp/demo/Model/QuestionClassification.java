package com.example.hp.demo.Model;

public class QuestionClassification {
    private int ID11;
    private String QUESTION11;
    private String OPTA11;
    private String OPTB11;
    private String OPTC11;
    private String OPTD11;
    private String ANSWER11;
    private String CATEGORY11;


    public QuestionClassification() {
        ID11 = 0;
        QUESTION11 = "";
        OPTA11 = "";
        OPTB11 = "";
        OPTC11 = "";
        OPTD11 = "";
        CATEGORY11="";
    }

    public QuestionClassification(String qUESTION11, String oPTA11, String oPTB11, String oPTC11, String oPTD11,
                             String aNSWER11,String cATEGORY11) {

        QUESTION11 = qUESTION11;
        OPTA11 = oPTA11;
        OPTB11 = oPTB11;
        OPTC11 = oPTC11;
        OPTD11 = oPTD11;
        ANSWER11 = aNSWER11;
        CATEGORY11=cATEGORY11;
    }

    public int getID11() {
        return ID11;
    }

    public void setID11(int ID11) {
        this.ID11 = ID11;
    }

    public String getQUESTION11() {
        return QUESTION11;
    }

    public void setQUESTION11(String QUESTION11) {
        this.QUESTION11 = QUESTION11;
    }

    public String getOPTA11() {
        return OPTA11;
    }

    public void setOPTA11(String OPTA11) {
        this.OPTA11 = OPTA11;
    }

    public String getOPTB11() {
        return OPTB11;
    }

    public void setOPTB11(String OPTB11) {
        this.OPTB11 = OPTB11;
    }

    public String getOPTC11() {
        return OPTC11;
    }

    public void setOPTC11(String OPTC11) {
        this.OPTC11 = OPTC11;
    }

    public String getOPTD11() {
        return OPTD11;
    }

    public void setOPTD11(String OPTD11) {
        this.OPTD11 = OPTD11;
    }

    public String getANSWER11() {
        return ANSWER11;
    }

    public void setANSWER11(String ANSWER11) {
        this.ANSWER11 = ANSWER11;
    }

    public String getCATEGORY11() {
        return CATEGORY11;
    }

    public void setCATEGORY11(String CATEGORY11) {
        this.CATEGORY11 = CATEGORY11;
    }
}
