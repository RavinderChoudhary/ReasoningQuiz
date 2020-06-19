package com.example.hp.demo.Model;

public class UserModel {
    private int Alp_TestMarksB;
    private int Alp_TestMarksE;
    private int Alp_TestMarksI;
    private int AnalogyMarksB;
    private int AnalogyMarksE;
    private int AnalogyMarksI;
    private int Blood_relMarksB;//x 3
    private int Blood_relMarksE;
    private int Blood_relMarksI;
    private int ClassificationMarksB;
    private int ClassificationMarksE;
    private int ClassificationMarksI;
    private int Cod_decMarksB;
    private int Cod_decMarksE;
    private int Cod_decMarksI;
    private long createdAt;
    private int Dir_senseMarksB;
    private int Dir_senseMarksE;
    private int Dir_senseMarksI;
    private String displayName;
    private String email;
    private int Essential_PartMarksB;
    private int Essential_PartMarksE;
    private int Essential_PartMarksI;
    private int finalMarks;
    private int Logical_SeqMarksB;
    private int Logical_SeqMarksE;
    private int Logical_SeqMarksI;
    private int Num_AnaMarksB;
    private int Num_AnaMarksE;
    private int Num_AnaMarksI;
    private int Number_SeriesMarksB;
    private int Number_SeriesMarksE;
    private int Number_SeriesMarksI;
    private int Sit_ReactionMarksB;
    private int Sit_ReactionMarksE;
    private int Sit_ReactionMarksI;
    private int Verify_TruthMarksB;
    private int Verify_TruthMarksE;
    private int Verify_TruthMarksI;



    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String displayName, String email,long createdAt,int Blood_relMarksB,int Blood_relMarksI,int Blood_relMarksE,int Cod_decMarksB,int Cod_decMarksI,int Cod_decMarksE,
                     int Dir_senseMarksB,int Dir_senseMarksI,int Dir_senseMarksE,int AnalogyMarksB,int AnalogyMarksI,int AnalogyMarksE,
                     int Alp_TestMarksB,int Alp_TestMarksI,int Alp_TestMarksE,int Number_SeriesMarksB,int Number_SeriesMarksI, int Number_SeriesMarksE,
                     int Logical_SeqMarksB,int Logical_SeqMarksI,int Logical_SeqMarksE, int Num_AnaMarksB,int Num_AnaMarksI,int Num_AnaMarksE,
                     int Sit_ReactionMarksB,int Sit_ReactionMarksI,int Sit_ReactionMarksE, int Verify_TruthMarksB,int Verify_TruthMarksI,int Verify_TruthMarksE,
                     int ClassificationMarksB,int ClassificationMarksI,int ClassificationMarksE,int Essential_PartMarksB,int Essential_PartMarksI,int Essential_PartMarksE,int finalMarks) {
        this.Alp_TestMarksB=Alp_TestMarksB;
        this.Alp_TestMarksE=Alp_TestMarksE;
        this.Alp_TestMarksI=Alp_TestMarksI;
        this.AnalogyMarksB=AnalogyMarksB;
        this.AnalogyMarksE=AnalogyMarksE;
        this.AnalogyMarksI=AnalogyMarksI;
        this.Blood_relMarksB=Blood_relMarksB;//x 3
        this.Blood_relMarksE=Blood_relMarksE;
        this.Blood_relMarksI=Blood_relMarksI;
        this.ClassificationMarksB=ClassificationMarksB;
        this.ClassificationMarksE=ClassificationMarksE;
        this.ClassificationMarksI=ClassificationMarksI;
        this.Cod_decMarksB=Cod_decMarksB;
        this.Cod_decMarksE=Cod_decMarksE;
        this.Cod_decMarksI=Cod_decMarksI;
        this.createdAt = createdAt;
        this.Dir_senseMarksB=Dir_senseMarksB;
        this.Dir_senseMarksE=Dir_senseMarksE;
        this.Dir_senseMarksI=Dir_senseMarksI;
        this.displayName = displayName;
        this.email = email;
        this.Essential_PartMarksB=Essential_PartMarksB;
        this.Essential_PartMarksE=Essential_PartMarksE;
        this.Essential_PartMarksI=Essential_PartMarksI;
        this.finalMarks=finalMarks;
        this.Logical_SeqMarksB=Logical_SeqMarksB;
        this.Logical_SeqMarksE=Logical_SeqMarksE;
        this.Logical_SeqMarksI=Logical_SeqMarksI;
        this.Num_AnaMarksB=Num_AnaMarksB;
        this.Num_AnaMarksE=Num_AnaMarksE;
        this.Num_AnaMarksI=Num_AnaMarksI;
        this.Number_SeriesMarksB=Number_SeriesMarksB;
        this.Number_SeriesMarksE=Number_SeriesMarksE;
        this.Number_SeriesMarksI=Number_SeriesMarksI;
        this.Sit_ReactionMarksB=Sit_ReactionMarksB;
        this.Sit_ReactionMarksE=Sit_ReactionMarksE;
        this.Sit_ReactionMarksI=Sit_ReactionMarksI;
        this.Verify_TruthMarksB=Verify_TruthMarksB;
        this.Verify_TruthMarksE=Verify_TruthMarksE;
        this.Verify_TruthMarksI=Verify_TruthMarksI;

    }

    //1
    public int getBlood_relMarksB() {
        return Blood_relMarksB;
    }

    public void setBlood_relMarksB(int Blood_relMarksB) {
        this.Blood_relMarksB = Blood_relMarksB;
    }

    public int getBlood_relMarksI() {
        return Blood_relMarksI;
    }

    public void setBlood_relMarksI(int Blood_relMarksI) {
        this.Blood_relMarksI = Blood_relMarksI;
    }

    public int getBlood_relMarksE() {
        return Blood_relMarksE;
    }

    public void setBlood_relMarksE(int Blood_relMarksE) {
        this.Blood_relMarksE = Blood_relMarksE;
    }

    //2

    public int getCod_decMarksB() {
        return Cod_decMarksB;
    }

    public void setCod_decMarksB(int Cod_decMarksB) {
        this.Cod_decMarksB = Cod_decMarksB;
    }

    public int getCod_decMarksI() {
        return Cod_decMarksI;
    }

    public void setCod_decMarksI(int Cod_decMarksI) {
        this.Cod_decMarksI = Cod_decMarksI;
    }

    public int getCod_decMarksE() {
        return Cod_decMarksE;
    }

    public void setCod_decMarksE(int Cod_decMarksE) {
        this.Cod_decMarksE = Cod_decMarksE;
    }

    //3

    public int getDir_senseMarksB() {
        return Dir_senseMarksB;
    }

    public void setDir_senseMarksB(int Dir_senseMarksB) {
        this.Dir_senseMarksB = Dir_senseMarksB;
    }

    public int getDir_senseMarksI() {
        return Dir_senseMarksI;
    }

    public void setDir_senseMarksI(int Dir_senseMarksI) {
        this.Dir_senseMarksI = Dir_senseMarksI;
    }

    public int getDir_senseMarksE() {
        return Dir_senseMarksE;
    }

    public void setDir_senseMarksE(int Dir_senseMarksE) {
        this.Dir_senseMarksE = Dir_senseMarksE;
    }


    //4
    public int getAnalogyMarksB() {
        return AnalogyMarksB;
    }

    public void setAnalogyMarksB(int AnalogyMarksB) {
        this.AnalogyMarksB = AnalogyMarksB;
    }

    public int getAnalogyMarksI() {
        return AnalogyMarksI;
    }

    public void setAnalogyMarksI(int AnalogyMarksI) {
        this.AnalogyMarksI = AnalogyMarksI;
    }

    public int getAnalogyMarksE() {
        return AnalogyMarksE;
    }

    public void setAnalogyMarksE(int AnalogyMarksE) {
        this.AnalogyMarksE = AnalogyMarksE;
    }

    //5

    public int getAlp_TestMarksB() {
        return Alp_TestMarksB;
    }

    public void setAlp_TestMarksB(int Alp_TestMarksB) {
        this.Alp_TestMarksB = Alp_TestMarksB;
    }

    public int getAlp_TestMarksI() {
        return Alp_TestMarksI;
    }

    public void setAlp_TestMarksI(int Alp_TestMarksI) {
        this.Alp_TestMarksI = Alp_TestMarksI;
    }

    public int getAlp_TestMarksE() {
        return Alp_TestMarksE;
    }

    public void setAlp_TestMarksE(int Alp_TestMarksE) {
        this.Alp_TestMarksE = Alp_TestMarksE;
    }

    //6

    public int getNumber_SeriesMarksB() {
        return Number_SeriesMarksB;
    }

    public void setNumber_SeriesMarksB(int Number_SeriesMarksB) {
        this.Number_SeriesMarksB = Number_SeriesMarksB;
    }

    public int getNumber_SeriesMarksI() {
        return Number_SeriesMarksI;
    }

    public void setNumber_SeriesMarksI(int Number_SeriesMarksI) {
        this.Number_SeriesMarksI = Number_SeriesMarksI;
    }

    public int getNumber_SeriesMarksE() {
        return Number_SeriesMarksE;
    }

    public void setNumber_SeriesMarksE(int Number_SeriesMarksE) {
        this.Number_SeriesMarksE = Number_SeriesMarksE;
    }

    //7

    public int getLogical_SeqMarksB() {
        return Logical_SeqMarksB;
    }

    public void setLogical_SeqMarksB(int Logical_SeqMarksB) {
        this.Logical_SeqMarksB = Logical_SeqMarksB;
    }

    public int getLogical_SeqMarksI() {
        return Logical_SeqMarksI;
    }

    public void setLogical_SeqMarksI(int Logical_SeqMarksI) {
        this.Logical_SeqMarksI = Logical_SeqMarksI;
    }

    public int getLogical_SeqMarksE() {
        return Logical_SeqMarksE;
    }

    public void setLogical_SeqMarksE(int Logical_SeqMarksE) {
        this.Logical_SeqMarksE = Logical_SeqMarksE;
    }

    //8
    public int getNum_AnaMarksB() {
        return Num_AnaMarksB;
    }

    public void setNum_AnaMarksB(int Num_AnaMarksB) {
        this.Num_AnaMarksB = Num_AnaMarksB;
    }

    public int getNum_AnaMarksI() {
        return Num_AnaMarksI;
    }

    public void setNum_AnaMarksI(int Num_AnaMarksI) {
        this.Num_AnaMarksI = Num_AnaMarksI;
    }

    public int getNum_AnaMarksE() {
        return Num_AnaMarksE;
    }

    public void setNum_AnaMarksE(int Num_AnaMarksE) {
        this.Num_AnaMarksE = Num_AnaMarksE;
    }

    //9
    public int getSit_ReactionMarksB() {
        return Sit_ReactionMarksB;
    }

    public void setSit_ReactionMarksB(int Sit_ReactionMarksB) {
        this.Sit_ReactionMarksB = Sit_ReactionMarksB;
    }

    public int getSit_ReactionMarksI() {
        return Sit_ReactionMarksI;
    }

    public void setSit_ReactionMarksI(int Sit_ReactionMarksI) {
        this.Sit_ReactionMarksI = Sit_ReactionMarksI;
    }

    public int getSit_ReactionMarksE() {
        return Sit_ReactionMarksE;
    }

    public void setSit_ReactionMarksE(int Sit_ReactionMarksE) {
        this.Sit_ReactionMarksE = Sit_ReactionMarksE;
    }

    //10
    public int getVerify_TruthMarksB() {
        return Verify_TruthMarksB;
    }

    public void setVerify_TruthMarksB(int Verify_TruthMarksB) {
        this.Verify_TruthMarksB = Verify_TruthMarksB;
    }

    public int getVerify_TruthMarksI() {
        return Verify_TruthMarksI;
    }

    public void setVerify_TruthMarksI(int Verify_TruthMarksI) {
        this.Verify_TruthMarksI = Verify_TruthMarksI;
    }

    public int getVerify_TruthMarksE() {
        return Verify_TruthMarksE;
    }

    public void setVerify_TruthMarksE(int Verify_TruthMarksE) {
        this.Verify_TruthMarksE = Verify_TruthMarksE;
    }

    //11
    public int getClassificationMarksB() {
        return ClassificationMarksB;
    }

    public void setClassificationMarksB(int ClassificationMarksB) {
        this.ClassificationMarksB = ClassificationMarksB;
    }

    public int getClassificationMarksI() {
        return ClassificationMarksI;
    }

    public void setClassificationMarksI(int ClassificationMarksI) {
        this.ClassificationMarksI = ClassificationMarksI;
    }

    public int getClassificationMarksE() {
        return ClassificationMarksE;
    }

    public void setClassificationMarksE(int ClassificationMarksE) {
        this.ClassificationMarksE = ClassificationMarksE;
    }

    //12
    public int getEssential_PartMarksB() {
        return Essential_PartMarksB;
    }

    public void setEssential_PartMarksB(int Essential_PartMarksB) {
        this.Essential_PartMarksB = Essential_PartMarksB;
    }

    public int getEssential_PartMarksI() {
        return Essential_PartMarksI;
    }

    public void setEssential_PartMarksI(int Essential_PartMarksI) {
        this.Essential_PartMarksI = Essential_PartMarksI;
    }

    public int getEssential_PartMarksE() {
        return Essential_PartMarksE;
    }

    public void setEssential_PartMarksE(int Essential_PartMarksE) {
        this.Essential_PartMarksE = Essential_PartMarksE;
    }

    //

    public int getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(int finalMarks) {
        this.finalMarks = finalMarks;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(String recipientId) {
        this.mRecipientId = recipientId;
    }
}
