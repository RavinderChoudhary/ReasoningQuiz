package com.example.hp.demo.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.demo.R;

public class QuestionAnalogy extends AppCompatActivity {
    private int ID4;
    private String QUESTION4;
    private String OPTA4;
    private String OPTB4;
    private String OPTC4;
    private String OPTD4;
    private String ANSWER4;
    private String CATEGORY4;


    public QuestionAnalogy() {
        ID4 = 0;
        QUESTION4 = "";
        OPTA4 = "";
        OPTB4 = "";
        OPTC4 = "";
        OPTD4 = "";
        CATEGORY4="";
    }

    public QuestionAnalogy(String qUESTION4, String oPTA4, String oPTB4, String oPTC4, String oPTD4,
                             String aNSWER4,String cATEGORY4) {

        QUESTION4 = qUESTION4;
        OPTA4 = oPTA4;
        OPTB4 = oPTB4;
        OPTC4 = oPTC4;
        OPTD4 = oPTD4;
        ANSWER4 = aNSWER4;
        CATEGORY4=cATEGORY4;
    }

    public int getID4() {
        return ID4;
    }

    public void setID4(int ID4) {
        this.ID4 = ID4;
    }

    public String getQUESTION4() {
        return QUESTION4;
    }

    public void setQUESTION4(String QUESTION4) {
        this.QUESTION4 = QUESTION4;
    }

    public String getOPTA4() {
        return OPTA4;
    }

    public void setOPTA4(String OPTA4) {
        this.OPTA4 = OPTA4;
    }

    public String getOPTB4() {
        return OPTB4;
    }

    public void setOPTB4(String OPTB4) {
        this.OPTB4 = OPTB4;
    }

    public String getOPTC4() {
        return OPTC4;
    }

    public void setOPTC4(String OPTC4) {
        this.OPTC4 = OPTC4;
    }

    public String getOPTD4() {
        return OPTD4;
    }

    public void setOPTD4(String OPTD4) {
        this.OPTD4 = OPTD4;
    }

    public String getANSWER4() {
        return ANSWER4;
    }

    public void setANSWER4(String ANSWER4) {
        this.ANSWER4 = ANSWER4;
    }

    public String getCATEGORY4() {
        return CATEGORY4;
    }

    public void setCATEGORY4(String CATEGORY4) {
        this.CATEGORY4 = CATEGORY4;
    }
}
