package com.example.hp.demo.Model;

public class QuestionLogical_Seq {
    private int ID7;
    private String QUESTION7;
    private String OPTA7;
    private String OPTB7;
    private String OPTC7;
    private String OPTD7;
    private String ANSWER7;
    private String CATEGORY7;


    public QuestionLogical_Seq() {
        ID7 = 0;
        QUESTION7 = "";
        OPTA7 = "";
        OPTB7 = "";
        OPTC7 = "";
        OPTD7 = "";
        CATEGORY7="";
    }

    public QuestionLogical_Seq(String qUESTION7, String oPTA7, String oPTB7, String oPTC7, String oPTD7,
                             String aNSWER7,String cATEGORY7) {

        QUESTION7 = qUESTION7;
        OPTA7 = oPTA7;
        OPTB7 = oPTB7;
        OPTC7 = oPTC7;
        OPTD7 = oPTD7;
        ANSWER7 = aNSWER7;
        CATEGORY7=cATEGORY7;
    }

    public int getID7() {
        return ID7;
    }

    public void setID7(int ID7) {
        this.ID7 = ID7;
    }

    public String getQUESTION7() {
        return QUESTION7;
    }

    public void setQUESTION7(String QUESTION7) {
        this.QUESTION7 = QUESTION7;
    }

    public String getOPTA7() {
        return OPTA7;
    }

    public void setOPTA7(String OPTA7) {
        this.OPTA7 = OPTA7;
    }

    public String getOPTB7() {
        return OPTB7;
    }

    public void setOPTB7(String OPTB7) {
        this.OPTB7 = OPTB7;
    }

    public String getOPTC7() {
        return OPTC7;
    }

    public void setOPTC7(String OPTC7) {
        this.OPTC7 = OPTC7;
    }

    public String getOPTD7() {
        return OPTD7;
    }

    public void setOPTD7(String OPTD7) {
        this.OPTD7 = OPTD7;
    }

    public String getANSWER7() {
        return ANSWER7;
    }

    public void setANSWER7(String ANSWER7) {
        this.ANSWER7 = ANSWER7;
    }

    public String getCATEGORY7() {
        return CATEGORY7;
    }

    public void setCATEGORY7(String CATEGORY7) {
        this.CATEGORY7 = CATEGORY7;
    }
}
