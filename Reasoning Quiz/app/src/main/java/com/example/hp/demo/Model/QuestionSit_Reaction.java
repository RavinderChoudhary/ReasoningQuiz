package com.example.hp.demo.Model;

public class QuestionSit_Reaction {
    private int ID9;
    private String QUESTION9;
    private String OPTA9;
    private String OPTB9;
    private String OPTC9;
    private String OPTD9;
    private String ANSWER9;
    private String CATEGORY9;


    public QuestionSit_Reaction() {
        ID9 = 0;
        QUESTION9 = "";
        OPTA9 = "";
        OPTB9 = "";
        OPTC9 = "";
        OPTD9 = "";
        CATEGORY9="";
    }

    public QuestionSit_Reaction(String qUESTION9, String oPTA9, String oPTB9, String oPTC9, String oPTD9,
                             String aNSWER9,String cATEGORY9) {

        QUESTION9 = qUESTION9;
        OPTA9 = oPTA9;
        OPTB9 = oPTB9;
        OPTC9 = oPTC9;
        OPTD9 = oPTD9;
        ANSWER9 = aNSWER9;
        CATEGORY9=cATEGORY9;
    }

    public int getID9() {
        return ID9;
    }

    public void setID9(int ID9) {
        this.ID9 = ID9;
    }

    public String getQUESTION9() {
        return QUESTION9;
    }

    public void setQUESTION9(String QUESTION9) {
        this.QUESTION9 = QUESTION9;
    }

    public String getOPTA9() {
        return OPTA9;
    }

    public void setOPTA9(String OPTA9) {
        this.OPTA9 = OPTA9;
    }

    public String getOPTB9() {
        return OPTB9;
    }

    public void setOPTB9(String OPTB9) {
        this.OPTB9 = OPTB9;
    }

    public String getOPTC9() {
        return OPTC9;
    }

    public void setOPTC9(String OPTC9) {
        this.OPTC9 = OPTC9;
    }

    public String getOPTD9() {
        return OPTD9;
    }

    public void setOPTD9(String OPTD9) {
        this.OPTD9 = OPTD9;
    }

    public String getANSWER9() {
        return ANSWER9;
    }

    public void setANSWER9(String ANSWER9) {
        this.ANSWER9 = ANSWER9;
    }

    public String getCATEGORY9() {
        return CATEGORY9;
    }

    public void setCATEGORY9(String CATEGORY9) {
        this.CATEGORY9 = CATEGORY9;
    }
}
