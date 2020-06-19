package com.example.hp.demo.Model;

public class QuestionDir_sense {
    private int ID3;
    private String QUESTION3;
    private String OPTA3;
    private String OPTB3;
    private String OPTC3;
    private String OPTD3;
    private String ANSWER3;
    private String CATEGORY3;

    public QuestionDir_sense()
    {
        ID3 = 0;
        QUESTION3 = "";
        OPTA3 = "";
        OPTB3 = "";
        OPTC3 = "";
        OPTD3 = "";
        CATEGORY3="";
    }
    public QuestionDir_sense(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD,
                            String aNSWER, String cATEGORY) {

        QUESTION3 = qUESTION;
        OPTA3 = oPTA;
        OPTB3 = oPTB;
        OPTC3 = oPTC;
        OPTD3 = oPTD;
        ANSWER3 = aNSWER;
        CATEGORY3=cATEGORY;
    }

    public int getID3() {
        return ID3;
    }

    public void setID3(int ID3) {
        this.ID3 = ID3;
    }

    public String getQUESTION3() {
        return QUESTION3;
    }

    public void setQUESTION3(String QUESTION3) {
        this.QUESTION3 = QUESTION3;
    }

    public String getOPTA3() {
        return OPTA3;
    }

    public void setOPTA3(String OPTA3) {
        this.OPTA3 = OPTA3;
    }

    public String getOPTB3() {
        return OPTB3;
    }

    public void setOPTB3(String OPTB3) {
        this.OPTB3 = OPTB3;
    }

    public String getOPTC3() {
        return OPTC3;
    }

    public void setOPTC3(String OPTC3) {
        this.OPTC3 = OPTC3;
    }

    public String getOPTD3() {
        return OPTD3;
    }

    public void setOPTD3(String OPTD3) {
        this.OPTD3 = OPTD3;
    }

    public String getANSWER3() {
        return ANSWER3;
    }

    public void setANSWER3(String ANSWER3) {
        this.ANSWER3 = ANSWER3;
    }

    public String getCATEGORY3() {
        return CATEGORY3;
    }

    public void setCATEGORY3(String CATEGORY3) {
        this.CATEGORY3 = CATEGORY3;
    }
}
