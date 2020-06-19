package com.example.hp.demo.Model;

public class QuestionAlp_Test {
    private int ID5;
    private String QUESTION5;
    private String OPTA5;
    private String OPTB5;
    private String OPTC5;
    private String OPTD5;
    private String ANSWER5;
    private String CATEGORY5;


    public QuestionAlp_Test() {
        ID5 = 0;
        QUESTION5 = "";
        OPTA5 = "";
        OPTB5 = "";
        OPTC5 = "";
        OPTD5 = "";
        CATEGORY5="";
    }

    public QuestionAlp_Test(String qUESTION5, String oPTA5, String oPTB5, String oPTC5, String oPTD5,
                             String aNSWER5,String cATEGORY5) {

        QUESTION5 = qUESTION5;
        OPTA5 = oPTA5;
        OPTB5 = oPTB5;
        OPTC5 = oPTC5;
        OPTD5 = oPTD5;
        ANSWER5 = aNSWER5;
        CATEGORY5=cATEGORY5;
    }

    public int getID5() {
        return ID5;
    }

    public void setID5(int ID5) {
        this.ID5 = ID5;
    }

    public String getQUESTION5() {
        return QUESTION5;
    }

    public void setQUESTION5(String QUESTION5) {
        this.QUESTION5 = QUESTION5;
    }

    public String getOPTA5() {
        return OPTA5;
    }

    public void setOPTA5(String OPTA5) {
        this.OPTA5 = OPTA5;
    }

    public String getOPTB5() {
        return OPTB5;
    }

    public void setOPTB5(String OPTB5) {
        this.OPTB5 = OPTB5;
    }

    public String getOPTC5() {
        return OPTC5;
    }

    public void setOPTC5(String OPTC5) {
        this.OPTC5 = OPTC5;
    }

    public String getOPTD5() {
        return OPTD5;
    }

    public void setOPTD5(String OPTD5) {
        this.OPTD5 = OPTD5;
    }

    public String getANSWER5() {
        return ANSWER5;
    }

    public void setANSWER5(String ANSWER5) {
        this.ANSWER5 = ANSWER5;
    }

    public String getCATEGORY5() {
        return CATEGORY5;
    }

    public void setCATEGORY5(String CATEGORY5) {
        this.CATEGORY5 = CATEGORY5;
    }
}
