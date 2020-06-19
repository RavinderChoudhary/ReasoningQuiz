package com.example.hp.demo.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.demo.Model.QuestionAlp_Test;
import com.example.hp.demo.Model.QuestionAnalogy;
import com.example.hp.demo.Model.QuestionBlood_rel;
import com.example.hp.demo.Model.QuestionClassification;
import com.example.hp.demo.Model.QuestionCod_dec;
import com.example.hp.demo.Model.QuestionDir_sense;
import com.example.hp.demo.Model.QuestionEssential_Part;
import com.example.hp.demo.Model.QuestionLogical_Seq;
import com.example.hp.demo.Model.QuestionNum_Ana;
import com.example.hp.demo.Model.QuestionNumber_Series;
import com.example.hp.demo.Model.QuestionRandom;
import com.example.hp.demo.Model.QuestionSit_Reaction;
import com.example.hp.demo.Model.QuestionVerify_Truth;
import com.google.android.gms.common.api.Batch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d
    private static final String KEY_CAT="category"; //category
    private static final String TABLE_QUEST1 = "TBR";  //x
    private static final String TABLE_QUEST2 = "TCD";  //
    private static final String TABLE_QUEST3 = "TDS";
    private static final String TABLE_QUEST4 = "TA";
    private static final String TABLE_QUEST5 = "TAT";
    private static final String TABLE_QUEST6 = "TNS";
    private static final String TABLE_QUEST7 = "TLS";
    private static final String TABLE_QUEST8 = "TNA";
    private static final String TABLE_QUEST9 = "TSR";
    private static final String TABLE_QUEST10 = "TVT";
    private static final String TABLE_QUEST11 = "TC";
    private static final String TABLE_QUEST12 = "TEP";
    private static final String TABLE_QUEST0 = "Final_Table";     //

    public static final String TABLE_SCORE="score";
    public static final String SCORE_KEY_ID="id";
    public static final String SCORE_KEY_SECTION="section";
    public static final String SCORE_KEY_CAT="category";
    public static final String SCORE_KEY_SCORE="score";

    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;

        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql1);
        addQuestionsBlood_rel(); //x

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST2 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql2);
        addQuestionsCod_dec();

        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST3 + " ( "                // x
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql3);
        addQuestionsDir_sense();

        String sql4 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST4 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql4);
        addQuestionsAnalogy();

        String sql5 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST5 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql5);
        addQuestionsAlp_Test();

        String sql6 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST6 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql6);
        addQuestionsNumber_Series();

        String sql7 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST7 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql7);
        addQuestionsLogical_Seq();

        String sql8 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST8 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql8);
        addQuestionsNum_Ana();

        String sql9 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST9 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql9);
        addQuestionsSit_Reaction();

        String sql10 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST10 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql10);
        addQuestionsVerify_Truth();

        String sql11 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST11 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql11);
        addQuestionsClassification();

        String sql12 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST12 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql12);
        addQuestionsEssential_Part();

        String sql0 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST0 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql0);
        addQuestionsRandom();

        String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE_SCORE+" ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_CAT+ " TEXT, "+ SCORE_KEY_SCORE+" INTEGER)";
        db.execSQL(sql);
    }

    private void addQuestionsBlood_rel() {   // x
        QuestionBlood_rel q1 = new QuestionBlood_rel("Pointing to a girl in the photograph, Ajay said, 'Her mother's brother is the only son of my mother's father.' How is the girl's mother related to Ajay?","Mother","Sister","Aunt","Grandmother","Aunt","B");
        this.addQuestionBlood_rel(q1);
        QuestionBlood_rel q2 = new QuestionBlood_rel("If 'X $ Y' means 'X is father of Y'; 'X # Y' means 'X is mother of Y'; 'X × Y' means 'X is sister of Y', then how is D related to N in N # A $ B × D ?","Nephew","Grandson","Granddaughter","Cannot be Determined","Cannot be Determined","B");
        this.addQuestionBlood_rel(q2);
        QuestionBlood_rel q3 = new QuestionBlood_rel("Pointing to a photograph, Vipul said, 'She is the daughter of my grandfather's only son.' How is Vipul related to the girl in the photograph?","Father","Brother","Cousin","Uncle","Brother","B");
        this.addQuestionBlood_rel(q3);
        QuestionBlood_rel q4 = new QuestionBlood_rel("A is B's sister. C is B's mother. D is C's father. E is D's mother. Then, how is A related to D?","Grandfather","Grandmother","Daughter","Granddaughter","Granddaughter","B");
        this.addQuestionBlood_rel(q4);
        QuestionBlood_rel q5 = new QuestionBlood_rel("Pointing to a photograph, a man said, 'I have no brother or sister but that man's father is my father's son.' Whose photograph was it?","His own","His Son","His Father","His Grandfather","His Son","B");
        this.addQuestionBlood_rel(q5);
        QuestionBlood_rel q6 = new QuestionBlood_rel("There are six children playing. Football namely A, B, C, D, E, and E. A and E are a brother. F is the sister of E, C is the only son of A's. Uncle B and D are the daughters of the brother of C's father. How is D related to A?","Uncle","Sister","Niece","Cousin","Cousin","B");
        this.addQuestionBlood_rel(q6);
        QuestionBlood_rel q7 = new QuestionBlood_rel("Ravi said to Seeta, 'Your mother is the daughter of my grandmother'. How are Ravi and Seeta related?","Uncle - Niece","Father - Daughter","Cousin","None of these","Cousin","B");
        this.addQuestionBlood_rel(q7);
        QuestionBlood_rel q8 = new QuestionBlood_rel(" If A is the brother of B; B is the sister of C; and C is the father of D, how D is related to A?","Brother","Sister","Nephew","Cannot be determined","Cannot be determined","B");
        this.addQuestionBlood_rel(q8);
        QuestionBlood_rel q9 = new QuestionBlood_rel("Pointing to a photograph of a boy Suresh said, 'He is the son of the only son of my mother.' How is Suresh related to that boy?","Brother","Uncle","Cousin","Father","Father","B");
        this.addQuestionBlood_rel(q9);
        QuestionBlood_rel q10 = new QuestionBlood_rel("Introducing a girl, a boy said, 'She is the daughter of the mother of the daughter of my aunt.' How is the girl related to the boy?","Cousin","Niece","Daughter","Aunt","Cousin","B");
        this.addQuestionBlood_rel(q10);
        QuestionBlood_rel q11 = new QuestionBlood_rel("How is my father's mother's only child's son's mother related to my father?","Sister","Mother","Grandmother","Wife","Wife","E");
        this.addQuestionBlood_rel(q11);
        QuestionBlood_rel q12 = new QuestionBlood_rel("John introduces Mary as the daughter of the only son of my father’s wife. How is Mary related to john?","Daughter","Sister","Sister-in-law","Cousin","Daughter","E");
        this.addQuestionBlood_rel(q12);
        QuestionBlood_rel q13 = new QuestionBlood_rel("A and B are young ones of C. If C is the father of A but B is not the son of C. How are B and C related","Niece and Uncle","Daughter and Father","Niece and Uncle","Daughter and Mother","Daughter and Father","E");
        this.addQuestionBlood_rel(q13);
        QuestionBlood_rel q14 = new QuestionBlood_rel("Pointing to the lady in the photograph, Mrinalini said, 'Her son’s father is the only son-in-law of my mother'. How is Mrinalini related to the lady?","Sister","Mother","Cousin","None of these","None of these","E");
        this.addQuestionBlood_rel(q14);
        QuestionBlood_rel q15 = new QuestionBlood_rel("Pointing at a photo, Dinesh said, 'His father is the only son of my mother.' The photo belongs to- :","Dinesh","Dinesh's brother","Dinesh's father","Dinesh's son","Dinesh's son","E");
        this.addQuestionBlood_rel(q15);
        QuestionBlood_rel q16 = new QuestionBlood_rel("Pointing to a man, a woman said, 'His mother is the only daughter of my mother.' How is the woman related to the man?","Mother","Daughter","Sister","Grandmother","Mother","E");
        this.addQuestionBlood_rel(q16);
        QuestionBlood_rel q17 = new QuestionBlood_rel("A’s mother is the only daughter of B’s father. How is B’s husband related to A?","Uncle","Brother","Father","Grandfather","Father","E");
        this.addQuestionBlood_rel(q17);
        QuestionBlood_rel q18 = new QuestionBlood_rel("Pointing to a gentleman, Shalini said, 'His only brother is the father of my son’s father.' How is the gentleman related to Shalini?","Grandfather","Uncle","Brother","Father","Uncle","E");
        this.addQuestionBlood_rel(q18);
        QuestionBlood_rel q19 = new QuestionBlood_rel("Pointing towards a person in a photograph, Anjali said, 'He is the only son of the father of my sister's brother.' How is that person is related to Anjali?","Anjali Father","Anjali Mother","Anjali Brother","Maternal Uncle","Anjali Brother","E");
        this.addQuestionBlood_rel(q19);
        QuestionBlood_rel q20 = new QuestionBlood_rel("Prasanna said, 'This girl is the wife of the grandson of my mother.' Who is Prasanna to the girl?","Husband","Father","Father–in–law","Grandfather","Husband","E");
        this.addQuestionBlood_rel(q20);
        QuestionBlood_rel q21 = new QuestionBlood_rel("A man said to a lady's, Your mother's husband's sister is my aunt?. How is that lady related to that man?","Daughter","Sister","Granddaughter","Mother","Sister","I");
        this.addQuestionBlood_rel(q21);
        QuestionBlood_rel q22 = new QuestionBlood_rel("P and Q are brothers of R. Q is son of S and T. S is the daughter of U. A is the father-in-law of T. B is son of U. What is the relationship of Q to B?","Nephew","Neice","Maternal Uncle","Paternal Aunt","Nephew","I");
        this.addQuestionBlood_rel(q22);
        QuestionBlood_rel q23 = new QuestionBlood_rel("Looking at a portrait of a man, Harsh said, 'His mother is the wife of my father's son. Brothers and sisters I have none.' At whose portrait was Harsh looking?","His son","His nephew","His Uncle","His Cousin","His son","I");
        this.addQuestionBlood_rel(q23);
        QuestionBlood_rel q24 = new QuestionBlood_rel("E is brother of A. M is brother of A. His father of M. T is wife of H. How is A related to T?","Son","Daughter","Son or Daughter","Data inadequate","Son or Daughter","I");
        this.addQuestionBlood_rel(q24);
        QuestionBlood_rel q25 = new QuestionBlood_rel("Pointing to a girl in the photograph. Amar said, 'Her mother's brother is the only son of my mother's father.' How the girl's mother related to Amar?","Mother","Sister","Aunt","Grandmother","Aunt","I");
        this.addQuestionBlood_rel(q25);
        QuestionBlood_rel q26 = new QuestionBlood_rel("Pointing to a photograph of a boy Suresh said, 'He is the son of the only son of my mother.' How is Suresh related to that boy?","Brother","Uncle","Cousin","Father","Father","I");
        this.addQuestionBlood_rel(q26);
        QuestionBlood_rel q27 = new QuestionBlood_rel("If A + B means A is the mother of B; A - B means A is the brother B; A % B means A is the father of B and A x B means A is the sister of B, which of the following shows that P is the maternal uncle of Q?","Q - N + M x P","P + S x N - Q","P - M + N x Q","Q - S % P","P - M + N x Q","I");
        this.addQuestionBlood_rel(q27);
        QuestionBlood_rel q28 = new QuestionBlood_rel("If A is the brother of B; B is the sister of C; and C is the father of D, how D is related to A?","Brother","Sister","Nephew","Cannot be determined","Cannot be determined","I");
        this.addQuestionBlood_rel(q28);
        QuestionBlood_rel q29 = new QuestionBlood_rel("If A + B means A is the brother of B; A - B means A is the sister of B and A x B means A is the father of B. Which of the following means that C is the son of M?","M - N x C + F","F - C + N x M","N + M - F x C","M x N - C + F","M x N - C + F","I");
        this.addQuestionBlood_rel(q29);
        QuestionBlood_rel q30 = new QuestionBlood_rel("Introducing a boy, a girl said, 'He is the son of the daughter of the father of my uncle.' How is the boy related to the girl?","Brother","Nephew","Uncle","Son-in-law","Brother","I");
        this.addQuestionBlood_rel(q30);
        QuestionBlood_rel q31 = new QuestionBlood_rel("Pointing to a photograph Lata says, 'He is the son of the only son of my grandfather.' How is the man in the photograph related to Lata?","Brother","Uncle","Cousin","Data is inadequate","Brother","B");
        this.addQuestionBlood_rel(q31);
        QuestionBlood_rel q32 = new QuestionBlood_rel("If A + B means A is the brother of B; A x B means A is the son of B; and A % B means B is the daughter of A then which of the following means M is the maternal uncle of N?","M + O x N","M % O x N + P","M + O % N","None of these","None of these","E");
        this.addQuestionBlood_rel(q32);
        QuestionBlood_rel q33 = new QuestionBlood_rel("Pointing to a photograph. Bajpai said, 'He is the son of the only daughter of the father of my brother.' How Bajpai is related to the man in the photograph?","Nephew","Brother","Father","Maternal Uncle","Maternal Uncle","I");
        this.addQuestionBlood_rel(q33);
        QuestionBlood_rel q34 = new QuestionBlood_rel("Pointing a photograph X said to his friend Y, 'She is the only daughter of the father of my mother.' How X is related to the person of photograph?","Daughter","Son","Nephew","Can not be decided","Son","B");
        this.addQuestionBlood_rel(q34);
        QuestionBlood_rel q35 = new QuestionBlood_rel("Pointing to a woman, Abhijit said, 'Her granddaughter is the only daughter of my brother.' How is the woman related to Abhijit?","Sister","Grandmother","Mother-in-law","Mother","Mother","E");
        this.addQuestionBlood_rel(q35);
        QuestionBlood_rel q36 = new QuestionBlood_rel("Amit said - 'This girl is the wife of the grandson of my mother'. How is Amit related to the girl?","Brother","Grandfather","Husband","Father-in-law","Father-in-law","I");
        this.addQuestionBlood_rel(q36);
    } // 1

    public void addQuestionBlood_rel(QuestionBlood_rel quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION1());
        values.put(KEY_ANSWER, quest.getANSWER1());
        values.put(KEY_OPTA, quest.getOPTA1());
        values.put(KEY_OPTB, quest.getOPTB1());
        values.put(KEY_OPTC, quest.getOPTC1());
        values.put(KEY_OPTD, quest.getOPTD1());
        values.put(KEY_CAT,quest.getCATEGORY1());
        // Inserting Row
        dbase.insert(TABLE_QUEST1, null, values);
    }

    private void addQuestionsCod_dec(){      //
        QuestionCod_dec q1 = new QuestionCod_dec("In a certain code 'MISSIONS' is written as 'MSIISNOS'. How is 'ONLINE' written in that code?","OLNNIE","ONILEN","NOILEN","Incremental","OLNNIE","B");
        this.addQuestionCod_dec(q1);
        QuestionCod_dec q2 = new QuestionCod_dec("If in a certain language, MADRAS is coded as NBESBT, how is BOMBAY coded in that code?","CPNCBX","CPNCBZ","CPOCBZ","CQOCBZ","CPNCBZ","B");
        this.addQuestionCod_dec(q2);
        QuestionCod_dec q3 = new QuestionCod_dec("If PAINT is coded as 74128 and EXCEL IS CODED AS 93596 then how would you encode ACCEPT?","455978","547978","554978","735961","455978","B");
        this.addQuestionCod_dec(q3);
        QuestionCod_dec q4 = new QuestionCod_dec("In a code language if POSE is coded as OQNPRTDF, then the word TYPE will be coded as","SUXZOQFD","SUXZQOFD","SUXZOQDF","SUXZQODE","SUXZOQDF","B");
        this.addQuestionCod_dec(q4);
        QuestionCod_dec q5 = new QuestionCod_dec("If in a certain code, MICROWAVE is written as LJBSNXZWD, how is POPULAR written in that code?","QBIKVPAV","OPKVPAV","OPOVKBQ","KBQVOPA","OPOVKBQ","B");
        this.addQuestionCod_dec(q5);
        QuestionCod_dec q6 = new QuestionCod_dec("If the TAP is coded as SZO, then how is FREEZE coded?","ATSSTS","EQDDYD","ESDDYD","EQDDZD","EQDDYD","B");
        this.addQuestionCod_dec(q6);
        QuestionCod_dec q7 = new QuestionCod_dec("In a certain code IMTITJU is written as TMIIUJT. How is TEMREMP written in that code?","METERPM","METRPME","ETRMMEP","MTERPME","METRPME","B");
        this.addQuestionCod_dec(q7);
        QuestionCod_dec q8 = new QuestionCod_dec("If in a certain code ROPE is coded as 6821, CHAIR is coded as 73456 what will be the code for CRAPE?","73456","76421","77246","77123","76421","B");
        this.addQuestionCod_dec(q8);
        QuestionCod_dec q9 = new QuestionCod_dec("In a certain code ABRACADABRA is coded as ZYIZXZWZYIZ. How will the word HOCUSPOCUS be coded in that code language?","SLXFHKLXFH","SLXZHKLXFH","SLXFHKMXFH","SLXFHILXFH","SLXFHKLXFH","B");
        this.addQuestionCod_dec(q9);
        QuestionCod_dec q10 = new QuestionCod_dec("If white is called blue, blue is called red, red is called yellow, yellow is called green, green is called black, black is called violet and violet is called orange, what would be the colour of human blood?","Red","Green","Yellow","Violet","Yellow","B");
        this.addQuestionCod_dec(q10);
        QuestionCod_dec q11 = new QuestionCod_dec("Which of the following code for ‘plan’?","%N5","@E4","&N4","#E6","&N4","B");
        this.addQuestionCod_dec(q11);
        QuestionCod_dec q12 = new QuestionCod_dec(" In a certain language, the word CASUAL is coded as DZUSDI. How is the word ZODIAC coded in that language?","AMFGDZ","ANGFDZ","ANFGDZ","ANFGDY","ANFGDZ","B");
        this.addQuestionCod_dec(q12);
        QuestionCod_dec q13 = new QuestionCod_dec("If in a certain language FASHION is coded as FOIHSAN, how is PROBLEM coded in that code?","PELBROM","PRBOELM","PELBORM","RPBOELM","PELBORM","I");
        this.addQuestionCod_dec(q13);
        QuestionCod_dec q14 = new QuestionCod_dec("In a certain code FIRE is coded as DGPC. What will be the last letter of the coded word for SHOT.","Q","R","S","P","R","I");
        this.addQuestionCod_dec(q14);
        QuestionCod_dec q15 = new QuestionCod_dec(" If TOUR is written as 1234, CLEAR is written as 56784 and SPARE is written as 90847, find the code for CARE","1247","4847","5247","5847","5847","I");
        this.addQuestionCod_dec(q15);
        QuestionCod_dec q16 = new QuestionCod_dec(" If SNOW is coded as 7100, then WALL will be coded as","5000","4700","4800","4000","4000","I");
        this.addQuestionCod_dec(q16);
        QuestionCod_dec q17 = new QuestionCod_dec("In a certain code, TOGETHER is written as RQEGRJCT. In the same code, PAROLE will be written as,","RYPQJG","RCPQJG","NCPQJG","NCPQJC","NCPQJG","I");
        this.addQuestionCod_dec(q17);
        QuestionCod_dec q18 = new QuestionCod_dec("In a defense message, GET AWAY, FIRE BACKWARD, MOVE SLOW is coded as BEN CDCI, QHOE PCTL DCOX, ZMWE VFMD. Based on this coding system, find the code for the following words:","OVER","DEADLY","REWARD","All of these","All of these","I");
        this.addQuestionCod_dec(q18);
        QuestionCod_dec q19 = new QuestionCod_dec("If D=4 and COVER=63, then BASIS=?","54","50","49","55","50","I");
        this.addQuestionCod_dec(q19);
        QuestionCod_dec q20 = new QuestionCod_dec("In the certain code, is ‘LOUD’ is written as ‘JQSF’ then which of the following English word will be coded as ‘PKQG’?","RISE","ROPE","ROAD","RICE","RISE","I");
        this.addQuestionCod_dec(q20);
        QuestionCod_dec q21 = new QuestionCod_dec("In certain language “BEAUTY“ is coded as “DGCWVA”, how is “UGLINESS“ coded in that language?","WINKPGUU","WINLQUVW","UGNKPUGK","UGKPUUGL","WINKPGUU","I");
        this.addQuestionCod_dec(q21);
        QuestionCod_dec q22 = new QuestionCod_dec("If in a code language, COULD is written as BNTKC and MARGIN is written as LZQFHM, how will MOULDING be written in that code?","CHMFINTK","LNKTCHMF","LNTKCHMF","NITKHCMF","LNTKCHMF","I");
        this.addQuestionCod_dec(q22);
        QuestionCod_dec q23 = new QuestionCod_dec("If'HJSM' means 'GIRL', what does 'RNES' mean?","BOYS","COWS","TOYS","SOFT","SOFT","E");
        this.addQuestionCod_dec(q23);
        QuestionCod_dec q24 = new QuestionCod_dec("In a certain code ‘RATIONAL’ is written as ‘TARNOILA’. How would ‘BRUTAL’ be written in that code?","UBRTAL","URBLAT","UBRATL","URBTAL","URBLAT","E");
        this.addQuestionCod_dec(q24);
        QuestionCod_dec q25 = new QuestionCod_dec("In a certain code ‘PURPOSE’ is written as ‘UPPRSOE’. How would ‘WATER’ be written in that code?","WATRE","AWTRE","AWETR","WEATR","AWETR","E");
        this.addQuestionCod_dec(q25);
        QuestionCod_dec q26 = new QuestionCod_dec("In a certain code ‘FORGIVE’ is written as ‘DPPHGWC’. How would ‘REQUEST’ be written in that code?","PFOVCUR","TFOVCRU","POFCVUR","None of these","None of these","E");
        this.addQuestionCod_dec(q26);
        QuestionCod_dec q27 = new QuestionCod_dec("If CALM is written as HEOO , YEAR may be written as","DHDS","DTDH","DDHT","DIDT","DIDT","E");
        this.addQuestionCod_dec(q27);
        QuestionCod_dec q28 = new QuestionCod_dec("If CALM is written as XZON, YEAR may be written as","BVZI","BZVI","BVIZ","BVZJ","BVZI","E");
        this.addQuestionCod_dec(q28);
        QuestionCod_dec q29 = new QuestionCod_dec("If CALM is written as LKZB, YEAR may be written as","BQDX","QZNX","QZDX","QDBX","QZDX","E");
        this.addQuestionCod_dec(q29);
        QuestionCod_dec q30 = new QuestionCod_dec("If CALM is written as AYJK, YEAR may be written as","WCYP","WCXP","CWXP","PWXY","WCYP","E");
        this.addQuestionCod_dec(q30);
        QuestionCod_dec q31 = new QuestionCod_dec("If CALM written as ZDIP, YEAR may be written as","ZXHV","HVXZ","VHXU","VHWZ","VHXU","E");
        this.addQuestionCod_dec(q31);
        QuestionCod_dec q32 = new QuestionCod_dec("In a certain code ‘EASIER’ is written as TGKUCG. How is CUTTER written in that code?","TWVVGE","TGWWVE","TGVVWE","TVGVWE","TGVVWE","E");
        this.addQuestionCod_dec(q32);
        QuestionCod_dec q33 = new QuestionCod_dec("f ‘MEANDER’ is coded as ‘4515459’, then ‘MATHEMATICS’ is coded as","6 7 2 5 0 6 2 3 0 7 6","4 1 2 8 5 4 1 2 9 3 1","4 5 0 3 8 4 0 1 8 5 4","5 7 1 5 9 4 1 3 9 5 5","4 1 2 8 5 4 1 2 9 3 1","E");
        this.addQuestionCod_dec(q33);
        QuestionCod_dec q34 = new QuestionCod_dec("In a certain code ‘RATIONAL’ is written as ‘TARNOILA’. How would ‘BRUTAL’ be written in that code","UBRTAL","URBLAT","UBRATL","URBTAL","URBLAT","I");
        this.addQuestionCod_dec(q34);
        QuestionCod_dec q35 = new QuestionCod_dec("If CALM is written as AYJK, YEAR may be written as-","WCYP","WCXP","CWXP","PWXY","WCYP","E");
        this.addQuestionCod_dec(q35);
        QuestionCod_dec q36 = new QuestionCod_dec("In a certain language, the word CASUAL is coded as DZUSDI. How is the word ZODIAC coded in that language","AMFGDZ","ANGFDZ","ANFGDZ","ANFGDY","ANFGDZ","B");
        this.addQuestionCod_dec(q36);
    }   //2

    public void addQuestionCod_dec(QuestionCod_dec quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION2());
        values.put(KEY_ANSWER, quest.getANSWER2());
        values.put(KEY_OPTA, quest.getOPTA2());
        values.put(KEY_OPTB, quest.getOPTB2());
        values.put(KEY_OPTC, quest.getOPTC2());
        values.put(KEY_OPTD, quest.getOPTD2());
        values.put(KEY_CAT,quest.getCATEGORY2());
        // Inserting Row
        dbase.insert(TABLE_QUEST2, null, values);   //  TABLE_QUEST
    }

    private void addQuestionsDir_sense() {
        QuestionDir_sense q1 = new QuestionDir_sense("One morning after sunrise, Suresh was standing facing a pole. The shadow of the pole fell exactly to his right. To which direction was he facing?","East","West","South","Data is inadequate","Data is inadequate","B");
        this.addQuestionDir_sense(q1);
        QuestionDir_sense q2 = new QuestionDir_sense("I am facing East. Turning to the right I go 20 m, then turning to the left I go 20 m and turning to the right I go 20 m, then again turning to the right I go 40 m and then again I go 40 m to the right. In which direction am I from my original position?","West","North","South","East","West","B");
        this.addQuestionDir_sense(q2);
        QuestionDir_sense q3 = new QuestionDir_sense("A man is facing west. He turns 45 degrees in the clockwise direction and then another 180 degrees in the same direction and then 270 degrees in the anticlockwise direction. Find which direction he is facing now?","South-West","West","South","East-South","South-West","B");
        this.addQuestionDir_sense(q3);
        QuestionDir_sense q4 = new QuestionDir_sense("A river flows west to east and on the way turns left and goes in a semi-circle round a hillock, and then turns left at right angles. In which direction in the river finally flowing?","East","West","North","South","East","B");
        this.addQuestionDir_sense(q4);
        QuestionDir_sense q5 = new QuestionDir_sense("A rat runs 20 towards East and turns to the right, runs 10 and turns to the right, runs 9 and again turns to left, runs 5 and then turns to left, runs 12 and finally turns to left and runs 6. Now, which direction is the rat facing?","North","South","East","West","North","B");
        this.addQuestionDir_sense(q5);
        QuestionDir_sense q6 = new QuestionDir_sense("One morning Udai and Vishal were talking to each other face to face at a crossing. If Vishal’s shadow was exactly to the left of Udai, which direction was Udai facing?","North","South","East","West","North","B");
        this.addQuestionDir_sense(q6);
        QuestionDir_sense q7 = new QuestionDir_sense("Y is in the East of X which is in the North of Z. If P is in the South of Z, then in which direction of Y, is P?","None of these","North","South","South-East","None of these","B");
        this.addQuestionDir_sense(q7);
        QuestionDir_sense q8 = new QuestionDir_sense("A river flows west to east and on the way turns left and goes in a semi-circle round a hillock, and then turns left at right angles. In which direction in the river finally flowing?","North","South","East","West","East","B");
        this.addQuestionDir_sense(q8);
        QuestionDir_sense q9 = new QuestionDir_sense("Prasanna went 15 km to the west from my house, then turned left and walked 20 km. He then turned East and walked 25 km and finally turning left covered 20 km. How far was he from his house?","10 kms","20 kms","30 kms","40 kms","10 kms","B");
        this.addQuestionDir_sense(q9);
        QuestionDir_sense q10 = new QuestionDir_sense(" A child is looking for his father. He went 90 metres in the east before turning to his right. He went 20 metres before turning to his right again to look for his father at his uncle’s place 30 metres from this point. His father was not there. From there, he went 100 metres to his north before meeting his father in a street. How far did the son meet his father from the starting point?","80 m","100 m","140 m","180 m","100 m","B");
        this.addQuestionDir_sense(q10);
        QuestionDir_sense q11 = new QuestionDir_sense("Airplanes A, B, C and D started flight towards east. After flying 125 kms planes A and D flew towards right while planes B and C flew towards left. After 115 km, planes B and C flew towards their left while planes A and D also turned towards their left. In which directions are the airplanes A, B, D, C respectively flying now?","North, South, East, West","East, West, West, East","East, West, East, West","South, North, North, South","East, West, East, West","B");
        this.addQuestionDir_sense(q11);
        QuestionDir_sense q12 = new QuestionDir_sense("According to P # R $ A * U, in which direction is U with respect to P?","West","East","North","South","North","I");
        this.addQuestionDir_sense(q12);
        QuestionDir_sense q13 = new QuestionDir_sense("K is 40 m South-West of L. If M is 40 m South-East of L, then M is in which direction of K?","East","West","North-East","South","East","I");
        this.addQuestionDir_sense(q13);
        QuestionDir_sense q14 = new QuestionDir_sense("A child is looking for his father. He went 90 meters in the east before turning to his right. He went 20 meters before turning to is right again to look for his father at his uncle's place 30 meters from this point. His father was not there. From there, he went 100 meters to his north before meeting his father in a street. How far did the son meet his father from starting point?","80 metre","90 metre","100 metre","110 meter","100 meter","I");
        this.addQuestionDir_sense(q14);
        QuestionDir_sense q15 = new QuestionDir_sense("Going 30m to the west of her house, Shalini turns left and goes another 40m. From this point, she takes a right turn and goes 15m to reach her school. Which direction is shalini facing now?","North - East","West","South - West","None","West","I");
        this.addQuestionDir_sense(q15);
        QuestionDir_sense q16 = new QuestionDir_sense("Starting from a point, Raju walked 12 m North, he turned right and walked 10 km, he again turned right and walked 12 m, then he turned left and walked 5 m. How far is he now and in which direction from the starting point?","27 m towards East","5 m towards East","10 m towards West","15 m towards East","15 m towards East","I");
        this.addQuestionDir_sense(q16);
        QuestionDir_sense q17 = new QuestionDir_sense("A man walks 1 km to East and then he turns to South and walks 5 km. Again he turns to East and walks 2 km. After this, he turns to North and walks 9 km. Now, how far is he from his starting point?","3 Km","4 Km","5 Km","7 Km","5 Km","I");
        this.addQuestionDir_sense(q17);
        QuestionDir_sense q18 = new QuestionDir_sense("A man walks point A to north direction. He takes a right turn then he takes a left turn he takes again left turn. Which direction is he facing now?","East","West","South","None of these","West","I");
        this.addQuestionDir_sense(q18);
        QuestionDir_sense q19 = new QuestionDir_sense("A man is facing north-west. He turns 90° in the clockwise direction, then 180° in the anticlockwise direction and then another 90° in the same direction. Which direction\n" +
                "is he facing now?","South","West","South-west","South-east","South-east","I");
        this.addQuestionDir_sense(q19);
        QuestionDir_sense q20 = new QuestionDir_sense("From his house, Lokesh went 15 kms to the North. Then he turned West and covered 10 kms. Then he turned South and covered 5 kms. Finally, turning to East, he covered 10 kms. In which direction is he from his house?","North","South","West","East","North","I");
        this.addQuestionDir_sense(q20);
        QuestionDir_sense q21 = new QuestionDir_sense("Kunal walks 10 km towards North. From there he walks 6 Km towards South. Then, he walks 3 Km towards east. How far and in which direction is he with reference to his starting point?","5 Km North","5 Km South","5 Km East","5 Km North-East","5 Km North-East","I");
        this.addQuestionDir_sense(q21);
        QuestionDir_sense q22 = new QuestionDir_sense("A and B start walking in opposite directions. A covers 2 km and B covers 4 km. Then, A turns right and walks 4 km while B turns left and walks 3 km. How far is each from the starting point?","10 km","8 km","5 km","10 km","5 km","I");
        this.addQuestionDir_sense(q22);
        QuestionDir_sense q23 = new QuestionDir_sense("Radha moves towards South-east, a distance of 7 Km, then she moves towards West and travels a distance of 14 m. From here, she moves towards North-west a distance of 7 m and finally, she moves a distance of 4 m towards East and stood at that point. How far is the starting point from where she stood?","3 m","4 m","10 m","11 m","10 m","I");
        this.addQuestionDir_sense(q23);
        QuestionDir_sense q24 = new QuestionDir_sense("One morning Udai and Vishal were talking to each other face to face at a crossing. If Vishal's shadow was exactly to the left of Udai, which direction was Udai facing?","North","South","East","West","North","E");
        this.addQuestionDir_sense(q24);
        QuestionDir_sense q25 = new QuestionDir_sense("Y is in the East of X which is in the North of Z. If P is in the South of Z, then in which direction of Y, is P?","North","South","South-East","None of these","None of these","E");
        this.addQuestionDir_sense(q25);
        QuestionDir_sense q26 = new QuestionDir_sense("If South-East becomes North, North-East becomes West and so on. What will West become?","North-East","North-West","South-East","South-West","South-East","E");
        this.addQuestionDir_sense(q26);
        QuestionDir_sense q27 = new QuestionDir_sense("A man walks 5 km toward south and then turns to the right. After walking 3 km he turns to the left and walks 5 km. Now in which direction is he from the starting place?","West","South","North-East","South-West","South-West","E");
        this.addQuestionDir_sense(q27);
        QuestionDir_sense q28 = new QuestionDir_sense("Rahul put his timepiece on the table in such a way that at 6 P.M. hour hand points to North. In which direction the minute hand will point at 9.15 P.M. ?","North","South","South-East","West","West","E");
        this.addQuestionDir_sense(q28);
        QuestionDir_sense q29 = new QuestionDir_sense("Rasik walked 20 m towards north. Then he turned right and walks 30 m. Then he turns right and walks 35 m. Then he turns left and walks 15 m. Finally he turns left and walks 15 m. In which direction and how many metres is he from the starting position?","15 m West","30 m East","30 m West","45 m East","45 m East","E");
        this.addQuestionDir_sense(q29);
        QuestionDir_sense q30 = new QuestionDir_sense("Starting from the point X, Jayant walked 15 m towards west. He turned left and walked 20 m. He then turned left and walked 15 m. After this he turned to his right and walked 12 m. How far and in which directions is now Jayant from X?","32 m, South","47 m, East","42 m, North","27 m, South","32 m, South","E");
        this.addQuestionDir_sense(q30);
        QuestionDir_sense q31 = new QuestionDir_sense("One evening before sunset Rekha and Hema were talking to each other face to face. If Hema's shadow was exactly to the right of Hema, which direction was Rekha facing?","North","South","East","Data is inadequate","South","E");
        this.addQuestionDir_sense(q31);
        QuestionDir_sense q32 = new QuestionDir_sense("A boy rode his bicycle Northward, then turned left and rode 1 km and again turned left and rode 2 km. He found himself 1 km west of his starting point. How far did he ride northward initially?","1 Km","2 Km","3 Km","5 km","2 Km","E");
        this.addQuestionDir_sense(q32);
        QuestionDir_sense q33 = new QuestionDir_sense("K is 40 m South-West of L. If M is 40 m South-East of L, then M is in which direction of K?","East","West","North-East","South","East","E");
        this.addQuestionDir_sense(q33);
    }  //3

    public void addQuestionDir_sense(QuestionDir_sense quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION3());
        values.put(KEY_ANSWER, quest.getANSWER3());
        values.put(KEY_OPTA, quest.getOPTA3());
        values.put(KEY_OPTB, quest.getOPTB3());
        values.put(KEY_OPTC, quest.getOPTC3());
        values.put(KEY_OPTD, quest.getOPTD3());
        values.put(KEY_CAT,quest.getCATEGORY3());
        // Inserting Row
        dbase.insert(TABLE_QUEST3, null, values);
    }

    private void addQuestionsAnalogy() {   // x
        QuestionAnalogy q1 = new QuestionAnalogy("Paw : Cat :: Hoof : ?","Lamb","Elephant","Lion","Horse","Horse","B");
        this.addQuestionAnalogy(q1);
        QuestionAnalogy q2 = new QuestionAnalogy("Complete analogous pair: Moon : Satellite : : Earth : ?","Sun","Planet","Solar System","Asteroid","Planet","B");
        this.addQuestionAnalogy(q2);
        QuestionAnalogy q3 = new QuestionAnalogy("Man : Biography :: Nation : ?","Leader","People","Geography","History","History","B");
        this.addQuestionAnalogy(q3);
        QuestionAnalogy q4 = new QuestionAnalogy("the evening is to morning as dinner is to?","breakfast","soup","coffee","time","breakfast","B");
        this.addQuestionAnalogy(q4);
        QuestionAnalogy q5 = new QuestionAnalogy("Architect : Building :: Sculptor : ?","Statue","Museum","Chisel","Stone","Stone","B");
        this.addQuestionAnalogy(q5);
        QuestionAnalogy q6 = new QuestionAnalogy("Crime is related to Police in the same way as Flood is related to","Dam","River","Rain","Reservoir","Dam","B");
        this.addQuestionAnalogy(q6);
        QuestionAnalogy q7 = new QuestionAnalogy("Oxygen : Burn : : Carbon dioxide : ?","Isolate","Foam","Extinguish","Explode","Extinguish","B");
        this.addQuestionAnalogy(q7);
        QuestionAnalogy q8 = new QuestionAnalogy("Cube is related to Square in the same way as Square is related to","Line","Triangle","Point","Plane","Line","B");
        this.addQuestionAnalogy(q8);
        QuestionAnalogy q9 = new QuestionAnalogy("As ‘Grain’ is related to ‘Salt’, similarly ‘Chip’ is related to which among the following options?","pottery","wood","grass","glass","glass","B");
        this.addQuestionAnalogy(q9);
        QuestionAnalogy q10 = new QuestionAnalogy("TRIAL : JURY :: ?","dispute : arbiter","poll : contestant","championship : spectator","conference : speaker","dispute : arbiter","B");
        this.addQuestionAnalogy(q10);
        QuestionAnalogy q11 = new QuestionAnalogy("“Kandla” is to “Gujarat” as “Cochin” is to___?","Karnataka","Goa","Kerala","Chennai","Kerala","E");
        this.addQuestionAnalogy(q11);
        QuestionAnalogy q12 = new QuestionAnalogy("Nature : Neglect : : Denigrate : ?","Reveal","Extol","Recognize","Calumniate","Extol","E");
        this.addQuestionAnalogy(q12);
        QuestionAnalogy q13 = new QuestionAnalogy("Thermometer : Temperature","Millimeter : Scale","Length : Breadth","Solar Energy : Sun","Cardiograph : Heart rate","Cardiograph : Heart rate","E");
        this.addQuestionAnalogy(q13);
        QuestionAnalogy q14 = new QuestionAnalogy("Army : Soldier :: School : ?","Principal","Teacher","Student","Peon","Student","E");
        this.addQuestionAnalogy(q14);
        QuestionAnalogy q15 = new QuestionAnalogy("Cricket : Pitch ::","Ship : Dock","Boat : Harbour","Boxing : Ring","Wrestling : Track","Boxing : Ring","E");
        this.addQuestionAnalogy(q15);
        QuestionAnalogy q16 = new QuestionAnalogy("As ‘After’ is related to ‘Before’, similarly ‘Successor’ is related to which among the following options?","second","past","historic","predecessor","predecessor","E");
        this.addQuestionAnalogy(q16);
        QuestionAnalogy q17 = new QuestionAnalogy("Choose the correct alternative.","acaa","acba","cabc","cacc","cabc","E");
        this.addQuestionAnalogy(q17);
        QuestionAnalogy q18 = new QuestionAnalogy("Race: Fatigue as:","French: Athlete","Fast: Hunger","Art: Bug","Walking: Running","Fast: Hunger","E");
        this.addQuestionAnalogy(q18);
        QuestionAnalogy q19 = new QuestionAnalogy("Carbon : Diamond :: Corundum : ?","Garnet","Ruby","Pukhraj","Pearl","Ruby","E");
        this.addQuestionAnalogy(q19);
        QuestionAnalogy q20 = new QuestionAnalogy("Venerate : Worship : : Extol : ?","Glorify","Recommend","Homage","Compliment","Glorify","E");
        this.addQuestionAnalogy(q20);
        QuestionAnalogy q21 = new QuestionAnalogy("Ship is related to Captain in the same way as Newspaper is related to","Publisher","Reader","Editor","Printer","Editor","I");
        this.addQuestionAnalogy(q21);
        QuestionAnalogy q22 = new QuestionAnalogy("Complete analogous pair: Fear : Threat : : Anger : ?","Panic","Compulsion","Provocation","Force","Provocation","I");
        this.addQuestionAnalogy(q22);
        QuestionAnalogy q23 = new QuestionAnalogy("Grain : Stock : : Stick : ?","String","Collection","Heap","Bundle","Bundle","I");
        this.addQuestionAnalogy(q23);
        QuestionAnalogy q24 = new QuestionAnalogy("Fog : Visibility :: AIDS : ?","Health","Resistance","Death","Virus","Resistance","I");
        this.addQuestionAnalogy(q24);
        QuestionAnalogy q25 = new QuestionAnalogy("Ice: Coldness:: Earth:?","Weight","Jungle","Gravitatism","Sea","Gravitatism","I");
        this.addQuestionAnalogy(q25);
        QuestionAnalogy q26 = new QuestionAnalogy("CUP : LIP :: BIRD : ?","BUSH","GRASS","FOREST","BEAK","GRASS","I");
        this.addQuestionAnalogy(q26);
        QuestionAnalogy q27 = new QuestionAnalogy("Flow : River :: Stagnant : ?","Rain","Stream","Pool","Canal","Pool","I");
        this.addQuestionAnalogy(q27);
        QuestionAnalogy q28 = new QuestionAnalogy("Paw : Cat :: Hoof : ?","Lamb","Elephant","Lion","Horse","Horse","I");
        this.addQuestionAnalogy(q28);
        QuestionAnalogy q29 = new QuestionAnalogy("Ornithologist : Bird :: Archaeologist : ?","Islands","Mediators","Archaeology","Aquatic","Archaeology","I");
        this.addQuestionAnalogy(q29);
        QuestionAnalogy q30 = new QuestionAnalogy("Peacock : India :: Bear : ?","Australia","America","Russia","England","Russia","I");
        this.addQuestionAnalogy(q30);
        QuestionAnalogy q31 = new QuestionAnalogy("REASON : SFBTPO :: THINK : ?","SGHMJ","UIJOL","UHNKI","UJKPM","UIJOL","B");
        this.addQuestionAnalogy(q31);
        QuestionAnalogy q32 = new QuestionAnalogy("Carbon : Diamond :: Corundum : ?","Garnet","Ruby","Pukhraj","Pearl","Ruby","E");
        this.addQuestionAnalogy(q32);
        QuestionAnalogy q33 = new QuestionAnalogy("NATION : ANTINO :: HUNGRY : ?","HNUGRY","UHNGYR","YRNGUH","UNHGYR","UHNGYR","I");
        this.addQuestionAnalogy(q33);
    }  //4

    public void addQuestionAnalogy(QuestionAnalogy quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION4());
        values.put(KEY_ANSWER, quest.getANSWER4());
        values.put(KEY_OPTA, quest.getOPTA4());
        values.put(KEY_OPTB, quest.getOPTB4());
        values.put(KEY_OPTC, quest.getOPTC4());
        values.put(KEY_OPTD, quest.getOPTD4());
        values.put(KEY_CAT,quest.getCATEGORY4());
        // Inserting Row
        dbase.insert(TABLE_QUEST4, null, values);
    }

    private void addQuestionsAlp_Test() {   // x
        QuestionAlp_Test q1 = new QuestionAlp_Test("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z. Which letter in this alphabet is the eighth letter to the right of the letter and which is the tenth letter to the left of the last but one letter of the alphabet?","X","W","I","H","W","B");
        this.addQuestionAlp_Test(q1);
        QuestionAlp_Test q2 = new QuestionAlp_Test("How many pairs of letters are there in the word 'NURSING\" which have as many letters between then as in the alphabet?","One","Three","Five","Six","Three","B");
        this.addQuestionAlp_Test(q2);
        QuestionAlp_Test q3 = new QuestionAlp_Test("Arrange the given words Alphabetical Order and choose the one that comes first.","Science","Scrutiny","Scripture","Scramble","Science","B");
        this.addQuestionAlp_Test(q3);
        QuestionAlp_Test q4 = new QuestionAlp_Test("If it is possible to from a word with the first, fourth, seventh and eleventh letters in the word 'SPHERVLVODS' write the second letter of thet word. Otherwise, X is the answer.?","S","E","L","O","E","B");
        this.addQuestionAlp_Test(q4);
        QuestionAlp_Test q5 = new QuestionAlp_Test("In the word ECONOMETRICS, if the first and second, third and forth, forth and fifth, fifth and sixth words are interchanged up to the last letter, what would be the tenth letter from right?","O","R","N","I","N","B");
        this.addQuestionAlp_Test(q5);
        QuestionAlp_Test q6 = new QuestionAlp_Test("If the following five words are arranged in alphabetical order, which word will come in the middle?","Electric","Elector","Elect","Electrode","Electric","B");
        this.addQuestionAlp_Test(q6);
        QuestionAlp_Test q7 = new QuestionAlp_Test("Find the 11th letter to the left of 20th letter from left in the English alphabet.","D","J","K","I","I","B");
        this.addQuestionAlp_Test(q7);
        QuestionAlp_Test q8 = new QuestionAlp_Test("If the letters are there in word BACKLASH each of which is as far away from the beginning of the word, as it is from the beginning of the English alphabet?","One","Two","Three","Four","Two","B");
        this.addQuestionAlp_Test(q8);
        QuestionAlp_Test q9 = new QuestionAlp_Test("Which letter comes in the middle of 20th letter from left and 21st letter from right?","L","M","N","O","M","B");
        this.addQuestionAlp_Test(q9);
        QuestionAlp_Test q10 = new QuestionAlp_Test("In dictionary, which word comes fourth in arrangement?","Propense","Prophet","Prong","Propine","Propine","B");
        this.addQuestionAlp_Test(q10);
        QuestionAlp_Test q11 = new QuestionAlp_Test("In the following question, five words are given. Find out which word will come in the middle, if all the five words are arranged alphabetically as in a dictionary.","Savour","Save","Savage","Sausage","Save","E");
        this.addQuestionAlp_Test(q11);
        QuestionAlp_Test q12 = new QuestionAlp_Test("Answer the given questions based the following English Alphabet Series A B C D E F G H I J K L M N O P Q R S T U V W X Y Z. Which is the 8th letter from your left?","E","H","I","S","H","E");
        this.addQuestionAlp_Test(q12);
        QuestionAlp_Test q13 = new QuestionAlp_Test("In each of the following questions, four words are given. Which of them will come at the second if all of them are arranged alphabetically as in a dictionary?","Entry","Efflorescent","Entreat","Ensure","Ensure","E");
        this.addQuestionAlp_Test(q13);
        QuestionAlp_Test q14 = new QuestionAlp_Test("If each of the twelve digits on a watch is replaced by English vowels a, e, i, o, u in sequence (1 by a, 2 by e, and so on and so forth), the hour hand will be between which pair of vowels at 9.30 a.m.?","ae","ei","ou","ua","ou","E");
        this.addQuestionAlp_Test(q14);
        QuestionAlp_Test q15 = new QuestionAlp_Test("If the letters in the word RUTHENIUM are rearranged in the alphabatical order, which letter will be second to the right of middle letter?","I","T","N","R","T","E");
        this.addQuestionAlp_Test(q15);
        QuestionAlp_Test q16 = new QuestionAlp_Test("What should come next in the following letter sequence? A A B A B C A B C D A B C D E A B C D","A","E","C","B","E","E");
        this.addQuestionAlp_Test(q16);
        QuestionAlp_Test q17 = new QuestionAlp_Test("Arrange the given words in alphabetical order and choose the one that comes at the second plac","Bathing","Banking","Backing","Banishing","Banishing","E");
        this.addQuestionAlp_Test(q17);
        QuestionAlp_Test q18 = new QuestionAlp_Test("Arrange the following words will come in middle if all of them are arranged alphabetically as in a dictionary?","Tennis","Tendon","Tender","Tempest","Tendon","E");
        this.addQuestionAlp_Test(q18);
        QuestionAlp_Test q19 = new QuestionAlp_Test("How many pairs of letters are there in the word \" CASTRAPHONE\" which have as many letters between them in the word as in the alphabet?","3","4","5","6","6","E");
        this.addQuestionAlp_Test(q19);
        QuestionAlp_Test q20 = new QuestionAlp_Test("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z .Which letter in this alphabet is the eighth letter to the right of the letter and  which is tenth letter to the left of the last but one letter of the alphabet?","X","W","I","H","W","E");
        this.addQuestionAlp_Test(q20);
        QuestionAlp_Test q21 = new QuestionAlp_Test("Arrange these words in alphabetical order and tick the one that comes last 1. Abandon  2. Actuate  3. Accumulate  4. Acquit   5. Achieve","Actuate","Accumulate","Acquit","Achieve","Actuate","I");
        this.addQuestionAlp_Test(q21);
        QuestionAlp_Test q22 = new QuestionAlp_Test("How many pairs of letters in the word 'CHAIRS' have as many letters between them in the word as in the alphabet?","2","3","1","4","2","I");
        this.addQuestionAlp_Test(q22);
        QuestionAlp_Test q23 = new QuestionAlp_Test("What should come next in the following letter sequence? A A B A B C A B C D A B C D E A B C D","A","E","C","B","E","I");
        this.addQuestionAlp_Test(q23);
        QuestionAlp_Test q24 = new QuestionAlp_Test("How many meaningful English words can be formed with the letters ESRO using each letter only once in each word?","None","One","Two","Three","Three","I");
        this.addQuestionAlp_Test(q24);
        QuestionAlp_Test q25 = new QuestionAlp_Test("S L U A Y J V E I O N Q G Z B D R H . What will come in place of question (?) mark in the following series : LA  UJ  YI  EG  ?","ZH","IB","NR","QH","QH","I");
        this.addQuestionAlp_Test(q25);
        QuestionAlp_Test q26 = new QuestionAlp_Test("LAP  BUT  CAR  SON  HID .If the positions of the first and the third alphabets of each of the words are interchanged, which of the following would form a meaningful word in the new arrangement?","HID","SON","Both LAP and BUT","Both CAR and LAP","Both LAP and BUT","I");
        this.addQuestionAlp_Test(q26);
        QuestionAlp_Test q27 = new QuestionAlp_Test("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z. Which letter is in the middle of 13th letter from the left and 4th letter from the right?","R","I","J","S","R","I");
        this.addQuestionAlp_Test(q27);
        QuestionAlp_Test q28 = new QuestionAlp_Test("2 3 B 9 V 5 L S R F P .If one is subtracted from each of the numbers, which of the following will be the fourth to the right of the tenth from the right ?","4","8","2","1","4","I");
        this.addQuestionAlp_Test(q28);
        QuestionAlp_Test q29 = new QuestionAlp_Test("If the first and second letters in the word DEPRESSION' were interchanged, also the third and the fourth letters, the fifth and the sixth letters and so on, which of the following would be the seventh letter from the right ?","R","O","S","P","P","I");
        this.addQuestionAlp_Test(q29);
        QuestionAlp_Test q30 = new QuestionAlp_Test("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z. If the first half of English alphabet is reversed and the second half of the English alphabet is left undisturbed then which letter will be 10th to the left of 16th letter from the left?","H","F","Z","U","H","I");
        this.addQuestionAlp_Test(q30);
        QuestionAlp_Test q31 = new QuestionAlp_Test("If in the word 'DISTURBANCE', the first letter is interchanged with the last letter, the second letter is interchanged with the tenth letter and so on, which letter would come after the letter T in the newly formed word ?","S","I","T","N","S","B");
        this.addQuestionAlp_Test(q31);
        QuestionAlp_Test q32 = new QuestionAlp_Test("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z. Which letter is in the middle between the ninth letter from the right and eighth letter from the left in the given alphabets?","N","O","L","M","M","E");
        this.addQuestionAlp_Test(q32);
        QuestionAlp_Test q33 = new QuestionAlp_Test("Tract of land used for raising crops or livestock.","A field","A farm","Both A & B","None of the above","Both A & B","I");
        this.addQuestionAlp_Test(q33);
    }  //5

    public void addQuestionAlp_Test(QuestionAlp_Test quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION5());
        values.put(KEY_ANSWER, quest.getANSWER5());
        values.put(KEY_OPTA, quest.getOPTA5());
        values.put(KEY_OPTB, quest.getOPTB5());
        values.put(KEY_OPTC, quest.getOPTC5());
        values.put(KEY_OPTD, quest.getOPTD5());
        values.put(KEY_CAT,quest.getCATEGORY5());
        // Inserting Row
        dbase.insert(TABLE_QUEST5, null, values);
    }

    private void addQuestionsNumber_Series() {   // x
        QuestionNumber_Series q1 = new QuestionNumber_Series("Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?","(1/3)","(1/8)","(2/8)","(1/16)","(1/8)","B");
        this.addQuestionNumber_Series(q1);
        QuestionNumber_Series q2 = new QuestionNumber_Series("26, 12, 10, 16, ?","50","52","53","56","56","B");
        this.addQuestionNumber_Series(q2);
        QuestionNumber_Series q3 = new QuestionNumber_Series("Look carefully for the pattern, and then choose which pair of numbers comes next.\n" +
                "2 44 4 41 6 38 8","10 12","35 32","34 9","35 10","35 10","B");
        this.addQuestionNumber_Series(q3);
        QuestionNumber_Series q4 = new QuestionNumber_Series("In the following question, a number series is given with one term missing. Choose the correct alternative that will same pattern and fill in the blank spaces.: 1, 4, 9, 16, 25, x","35","36","48","49","36","B");
        this.addQuestionNumber_Series(q4);
        QuestionNumber_Series q5 = new QuestionNumber_Series("4, 7, 12, .., 28, 39","19","24","14","16","19","B");
        this.addQuestionNumber_Series(q5);
        QuestionNumber_Series q6 = new QuestionNumber_Series("32 31 32 29 32 27 32","25 32","31 32","29 32","25 30","25 32","B");
        this.addQuestionNumber_Series(q6);
        QuestionNumber_Series q7 = new QuestionNumber_Series("3 2 2 5 5 5 7 8 8 9 11 11 ?","12","11","9","14","11","B");
        this.addQuestionNumber_Series(q7);
        QuestionNumber_Series q8 = new QuestionNumber_Series("What is the next number in this sequence?\n" +
                "1, 3, 8, 19, 42, 89, ..?..","108","184","167","97","184","B");
        this.addQuestionNumber_Series(q8);
        QuestionNumber_Series q9 = new QuestionNumber_Series("1, 9, 25, 49, ?, 121. What will come at the place of question mark?","100","91","81","64","81","B");
        this.addQuestionNumber_Series(q9);
        QuestionNumber_Series q10 = new QuestionNumber_Series("30, 34, 43, 59, 84, 120,?","169","148","153","176","169","B");
        this.addQuestionNumber_Series(q10);
        QuestionNumber_Series q11 = new QuestionNumber_Series("What should come in place of the question mark '?' in the following number series?\n" +
                "2916, 972, ?, 108, 36, 12","324","234","248","391","324","E");
        this.addQuestionNumber_Series(q11);
        QuestionNumber_Series q12 = new QuestionNumber_Series("17, 22, 27, 32, …... ? …....","33","35","38","37","37","E");
        this.addQuestionNumber_Series(q12);
        QuestionNumber_Series q13 = new QuestionNumber_Series("25, 75, 35, 70, 45, …... ? …....","65","60","55","85","65","E");
        this.addQuestionNumber_Series(q13);
        QuestionNumber_Series q14 = new QuestionNumber_Series("4, 6, 9, 13,","15","12","18","17","18","E");
        this.addQuestionNumber_Series(q14);
        QuestionNumber_Series q15 = new QuestionNumber_Series("42 40 38 35 33 31 28","25 22","26 23","26 24","25 23","26 23","E");
        this.addQuestionNumber_Series(q15);
        QuestionNumber_Series q16 = new QuestionNumber_Series("5, 12, 23, 50, 141, ?","415","430","439","488","488","E");
        this.addQuestionNumber_Series(q16);
        QuestionNumber_Series q17 = new QuestionNumber_Series("210 209 213 186 202 (?)","138","77","177","327","77","E");
        this.addQuestionNumber_Series(q17);
        QuestionNumber_Series q18 = new QuestionNumber_Series("2, 7, 14, 23, ?, 47","31","28","34","38","34","E");
        this.addQuestionNumber_Series(q18);
        QuestionNumber_Series q19 = new QuestionNumber_Series("10,100,200,310,....","420","400","410","430","430","E");
        this.addQuestionNumber_Series(q19);
        QuestionNumber_Series q20 = new QuestionNumber_Series("22, 21, 23, 22, 24, 23, ___ ?","23","25","22","26","25","E");
        this.addQuestionNumber_Series(q20);
        QuestionNumber_Series q21 = new QuestionNumber_Series("2 11 38 197 1172 8227 65806","11","38","197","1172","1172","I");
        this.addQuestionNumber_Series(q21);
        QuestionNumber_Series q22 = new QuestionNumber_Series("Find the next in the sequence\n" +
                "5, 21, 69, 213, 645, ?","1935","1815","1941","1290","1941","I");
        this.addQuestionNumber_Series(q22);
        QuestionNumber_Series q23 = new QuestionNumber_Series("2, 12, 36, 80, 150, ?","250","252","200","270","252","I");
        this.addQuestionNumber_Series(q23);
        QuestionNumber_Series q24 = new QuestionNumber_Series("16 19 21 30 46 71 107","19","21","30","46","19","I");
        this.addQuestionNumber_Series(q24);
        QuestionNumber_Series q25 = new QuestionNumber_Series("In the following question, a number series is given with one term missing. Choose the correct alternative that will the same pattern and fill in the blank spaces.: 1, 6, 13, 22, 33.","44","45","46","47","46","I");
        this.addQuestionNumber_Series(q25);
        QuestionNumber_Series q26 = new QuestionNumber_Series("Find the missing number in the series?\n" +
                "\n" +
                "4, 18, ?, 100, 180, 294, 448","48","50","58","60","48","I");
        this.addQuestionNumber_Series(q26);
        QuestionNumber_Series q27 = new QuestionNumber_Series("Find the missing number in the following series?\n" +
                "\n" +
                "3, 5, 5, 19, 7, 41, 9, ?","71","61","79","69","71","I");
        this.addQuestionNumber_Series(q27);
        QuestionNumber_Series q28 = new QuestionNumber_Series("Find the wrong number in the series.\n" +
                "\n" +
                "1, 2, 6, 15, 31, 56, 91","31","15","56","91","91","I");
        this.addQuestionNumber_Series(q28);
        QuestionNumber_Series q29 = new QuestionNumber_Series("1, 2, 3, 10, ?, 9802","99","199","299","299","99","I");
        this.addQuestionNumber_Series(q29);
        QuestionNumber_Series q30 = new QuestionNumber_Series("Find out the wrong term in the series 2, 3, 4, 4, 6, 8, 9, 12, 16","9","12","16","8","9","I");
        this.addQuestionNumber_Series(q30);
        QuestionNumber_Series q31 = new QuestionNumber_Series("8, 15, 28, 53, ?, 199","101","102","103","104","102","B");
        this.addQuestionNumber_Series(q31);
        QuestionNumber_Series q32 = new QuestionNumber_Series("Find the wrong number in the series.\n" +
                "\n" +
                "3, 8, 15, 24, 34, 48, 63","24","15","34","48","34","E");
        this.addQuestionNumber_Series(q32);
        QuestionNumber_Series q33 = new QuestionNumber_Series("Find out the wrong term in the series 2, 5, 10, 50, 500, 5000","5000","500","10","50","5000","I");
        this.addQuestionNumber_Series(q33);
    }  //6

    public void addQuestionNumber_Series(QuestionNumber_Series quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION6());
        values.put(KEY_ANSWER, quest.getANSWER6());
        values.put(KEY_OPTA, quest.getOPTA6());
        values.put(KEY_OPTB, quest.getOPTB6());
        values.put(KEY_OPTC, quest.getOPTC6());
        values.put(KEY_OPTD, quest.getOPTD6());
        values.put(KEY_CAT,quest.getCATEGORY6());
        // Inserting Row
        dbase.insert(TABLE_QUEST6, null, values);
    }

    private void addQuestionsLogical_Seq() {   // x
        QuestionLogical_Seq q1 = new QuestionLogical_Seq("Arrange the words given below in a meaningful sequence.\n" +
                "\n" +
                "1.Presentation  2.Recommendation  3. Arrival  4.Discussion  5.Introduction","5, 3, 4, 1, 2","3, 5, 4, 2, 1","3, 5, 1, 4, 2","5, 3, 1, 2, 4","3, 5, 1, 4, 2","B");
        this.addQuestionLogical_Seq(q1);
        QuestionLogical_Seq q2 = new QuestionLogical_Seq("Arrange the words given below in a meaningful sequence.\n" +
                "\n" +
                "1. Poverty   2. Population   3. Death    4. Unemployment    5. Disease","2, 3, 4, 5, 1","3, 4, 2, 5, 1","2, 4, 1, 5, 3","1, 2, 3, 4, 5","2, 4, 1, 5, 3","B");
        this.addQuestionLogical_Seq(q2);
        QuestionLogical_Seq q3 = new QuestionLogical_Seq("Arrange the following in a logical order :\n" +
                "\n" +
                "1. Shoulder     2. Wrist     3. Elbow     4. Palm     5. Finger","2, 4, 5, 3, 1","3, 1, 4, 2, 5","3, 4, 5, 2, 1","5, 4, 2, 3, 1","5, 4, 2, 3, 1","B");
        this.addQuestionLogical_Seq(q3);
        QuestionLogical_Seq q4 = new QuestionLogical_Seq("Arrange the following in a logical order :\n" +
                "\n" +
                "1. Euphoria     2. Happiness     3. Ambivalence     4. Ecstasy     5. Pleasure","1, 4, 2, 5, 3","2, 1, 3, 4, 5","3, 2, 5, 1, 4","4, 1, 3, 2, 5","3, 2, 5, 1, 4","B");
        this.addQuestionLogical_Seq(q4);
        QuestionLogical_Seq q5 = new QuestionLogical_Seq("Arrange the words given below in a meaningful sequence.\n" +
                "\n" +
                "1.Caste  2. Family  3. Newly married Couple  4.Clan  5.Species","2, 3, 1, 4, 5","3, 4, 5, 1, 2","3, 2, 1, 4, 5","4, 5, 3, 2, 1","3, 2, 1, 4, 5","B");
        this.addQuestionLogical_Seq(q5);
        QuestionLogical_Seq q6 = new QuestionLogical_Seq("Arrange the words given below in a meaningful sequence.\n" +
                "\n" +
                "1.Elephant  2.Cat  3.Mosquito  4.Tiger    5. Whale","5, 3, 1, 2, 4","3, 2, 4, 1, 5","1, 3, 5, 4, 2","2, 5, 1, 4, 3","3, 2, 4, 1, 5","B");
        this.addQuestionLogical_Seq(q6);
        QuestionLogical_Seq q7 = new QuestionLogical_Seq("3, 2, 4, 1, 5","PSRQ","SVUT","MNPO","KNML","MNPO","B");
        this.addQuestionLogical_Seq(q7);
        QuestionLogical_Seq q8 = new QuestionLogical_Seq("Choose the correct order\n" +
                "\n" +
                "1) is   2) at   3) TV   4) film   5) midnight   6) a    7) on   8) great   9) There","9, 1, 6, 8, 7, 4, 3, 2, 5","9, 1, 6, 8, 4, 7, 3, 5, 3","9, 1, 6, 8, 4, 7, 3, 2, 5","9, 6, 1, 8, 4, 7, 3, 2, 5","9, 1, 6, 8, 4, 7, 3, 2, 5","B");
        this.addQuestionLogical_Seq(q8);
        QuestionLogical_Seq q9 = new QuestionLogical_Seq("Arrange the given words in a meaningful sequence.\n" +
                "\n" +
                "1.  Ceiling    2.  Room    3. Floor     4. Walls     5. Foundation","5,4,1,3,2","5,4,3,1,2","4,5,3,1,2","4,5,1,2,3","5,4,1,3,2","B");
        this.addQuestionLogical_Seq(q9);
        QuestionLogical_Seq q10 = new QuestionLogical_Seq("Rita ? into the cellar.\n" +
                "\n" +
                "Which of the following words best suitable in the place of '?'","ascended","rescinded","descended","intended","descended","B");
        this.addQuestionLogical_Seq(q10);
        QuestionLogical_Seq q11 = new QuestionLogical_Seq("Arrange the words given below in a meaningful sequence.\n" +
                "\n" +
                "1. Heel  2. Shoulder  3. Skull  4. Neck  5. Knee  6. Chest  7. Thigh  8. Stomach  9. Face  10. Hand","3, 4, 7, 9, 2, 5, 8, 10, 6, 1","3, 9, 4, 2, 10, 6, 8, 7, 5, 1","2, 4, 7, 10, 1, 5, 8, 9, 6, 3","4, 7, 10, 1, 9, 6, 2, 5, 8, 3","3, 9, 4, 2, 10, 6, 8, 7, 5, 1","E");
        this.addQuestionLogical_Seq(q11);
        QuestionLogical_Seq q12 = new QuestionLogical_Seq("Arrange the following words in an appropriate order\n" +
                "\n" +
                "1. Rainbow   2. Rain   3. Sun    4. Happy    5. Child","4, 2, 3, 5, 1","4, 5, 1, 2, 3","2, 1, 4, 5, 3","2, 3, 1, 5, 4","2, 3, 1, 5, 4","E");
        this.addQuestionLogical_Seq(q12);
        QuestionLogical_Seq q13 = new QuestionLogical_Seq("Five plays K, L, M, N and O are to be staged from Monday to Friday of a week. On each day, only one play will be staged. N or O should not be either the first or last to be staged. O should be immediately followed by M. L should be staged immediately after N. One play is staged between K and L.\n" +
                "\n" +
                "Which is the second play to be staged ?","L","O","M","N","N","E");
        this.addQuestionLogical_Seq(q13);
        QuestionLogical_Seq q14 = new QuestionLogical_Seq("Choose the word which gives best meaning to the sentence from the given options.\n" +
                "\n" +
                "His recent success ______ him more arrogant than what he used to be","make","have make","was making","has made","has made","E");
        this.addQuestionLogical_Seq(q14);
        QuestionLogical_Seq q15 = new QuestionLogical_Seq("Arrange the given words in a meaningful sequence.\n" +
                "\n" +
                "1. Adult     2. Child    3. Infant     4. Boy    5. Adolescent","1, 3, 4, 5, 2","2, 3, 5, 4, 1","2, 3, 4, 1, 5","3, 2, 4, 5, 1","3, 2, 4, 5, 1","E");
        this.addQuestionLogical_Seq(q15);
        QuestionLogical_Seq q16 = new QuestionLogical_Seq("Arrange the given words in a meaningful sequence.\n" +
                "\n" +
                "1. Rainbow     2. Rain     3. Sun     4. Happy     5. Child","4, 2, 3, 5, 1","2, 3, 1, 5, 4","4, 5, 1, 2, 3"," 2, 1, 4, 5, 3","2, 3, 1, 5, 4","E");
        this.addQuestionLogical_Seq(q16);
        QuestionLogical_Seq q17 = new QuestionLogical_Seq("Arrange the given words in a meaningful sequence.\n" +
                "\n" +
                "1. Grain   2. Plant    3.Sandwich    4. Bread    5. Dough","1,2,5,4,3","2,1,4,5,3","2,1,5,4,3","2,1,4,5,3","2,1,5,4,3","E");
        this.addQuestionLogical_Seq(q17);
        QuestionLogical_Seq q18 = new QuestionLogical_Seq("Arrange the given words in a meaningful sequence.\n" +
                "\n" +
                "1. Flat     2. Home    3. Building   4. Society   5. Place","5,4,3,1,2","5,4,3,2,1","4,3,1,2,5","4,5,3,1,2","5,4,3,1,2","E");
        this.addQuestionLogical_Seq(q18);
        QuestionLogical_Seq q19 = new QuestionLogical_Seq("If the first and second digits are interchanged in each number from the following set of numbers, and then the numbers are arranged in descending order, which number will be second ?\n" +
                "\n" +
                "376  438  476  389  567","376","567","389","476","476","E");
        this.addQuestionLogical_Seq(q19);
        QuestionLogical_Seq q20 = new QuestionLogical_Seq("HZF, IWH, KSJ, NNL, ?","THN","RGM","SHM","RHN","RHN","E");
        this.addQuestionLogical_Seq(q20);
        QuestionLogical_Seq q21 = new QuestionLogical_Seq("If Laxmi is taller than Ramya but shorter than Susmitha and Ramya is as tall as Hema but taller than Avanthi, then Hema is :","shorter than Ramya","taller than Avanthi","taller than susmitha","shorter than Laxmi","shorter than Laxmi","I");
        this.addQuestionLogical_Seq(q21);
        QuestionLogical_Seq q22 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Obstacle\n" +
                "ii. Obscure\n" +
                "iii. Obsession\n" +
                "iv. Obstruct","iii, iv, i, ii","i, iv, iii, ii","ii, iii, i, iv","iv, iii, ii, i","ii, iii, i, iv","I");
        this.addQuestionLogical_Seq(q22);
        QuestionLogical_Seq q23 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Fabric\n" +
                "ii. Face\n" +
                "iii. Failure\n" +
                "iv. Faculty","iv, ii, i, iii","iii, iv, ii, i","iv, iii, i, iI","i, ii, iv, iii","i, ii, iv, iii","I");
        this.addQuestionLogical_Seq(q23);
        QuestionLogical_Seq q24 = new QuestionLogical_Seq("Arrange the following words as per order in the dictionary\n" +
                "\n" +
                "1. Maternity\n" +
                "2. Matriarchy\n" +
                "3. Matchbox\n" +
                "4. Matricide","3,1,2,4","4,3,1,2","3,4,1,2","1,3,4,2","3,1,2,4","I");
        this.addQuestionLogical_Seq(q24);
        QuestionLogical_Seq q25 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Permanence\n" +
                "ii. Permanent\n" +
                "iii. Permafrost\n" +
                "iv. Permeability","ii, iii, iv, i","iii, ii, i, iv","iv, ii, i, iii","iii, i, ii, iv","iii, i, ii, iv","I");
        this.addQuestionLogical_Seq(q25);
        QuestionLogical_Seq q26 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Apparent\n" +
                "ii. Appointed\n" +
                "iii. Apostate\n" +
                "iv. Apparel","ii, i, iv, iii","iii,ii,iv,i","iii,iv,i,ii","iii,iv,ii,i","iii,iv,i,ii","I");
        this.addQuestionLogical_Seq(q26);
        QuestionLogical_Seq q27 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "1. Book\n" +
                "2. Bread\n" +
                "3. Butter\n" +
                "4. Bayern\n" +
                "5. Bulb","42135","41253","42153","41235","41253","I");
        this.addQuestionLogical_Seq(q27);
        QuestionLogical_Seq q28 = new QuestionLogical_Seq("Arrange the following words as per order in the dictionary.\n" +
                "\n" +
                "1. Defect 2.Defence 3.Deerstalker 4.Defensive","2 , 3 , 1, 4","1, 3, 2, 4","4, 3, 1, 2","3, 1, 2, 4","3, 1, 2, 4","I");
        this.addQuestionLogical_Seq(q28);
        QuestionLogical_Seq q29 = new QuestionLogical_Seq("Find the missing term in the letter series. BGL, DIN, ___, HMR","FKP","FPK","GLQ","EJO","FKP","I");
        this.addQuestionLogical_Seq(q29);
        QuestionLogical_Seq q30 = new QuestionLogical_Seq("Arrange the following words as per order in the dictionary. 1.Exploit 2.Explosive 3.Exponent 4.Exposition 5.Explore","1,3,4,5,2","1,5,2,3,4","1,5,3,2,4","1,2,5,3,4","1,5,2,3,4","I");
        this.addQuestionLogical_Seq(q30);
        QuestionLogical_Seq q31 = new QuestionLogical_Seq("From the given words, select the word which cannot be formed using the letters of the given word.\n" +
                "\n" +
                "SMOTHERS","THOSE","METRO","STORE","TEARS","TEARS","B");
        this.addQuestionLogical_Seq(q31);
        QuestionLogical_Seq q32 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Examination\n" +
                "ii. Explicit\n" +
                "iii. Expenditure\n" +
                "iv. Experience","i, iv, iii, ii","i, ii, iii, iv","i, iv, ii, iii","i, iii, iv, ii","i, iii, iv, ii","E");
        this.addQuestionLogical_Seq(q32);
        QuestionLogical_Seq q33 = new QuestionLogical_Seq("Arrange the given words in the sequence in which they occur in the dictionary.\n" +
                "\n" +
                "i. Harmony\n" +
                "ii. Harness\n" +
                "iii. Honey\n" +
                "iv. Harangue","iii,ii,i,iv","iv,i,iii,ii","iv,ii,i,iii","iv,i,ii,iii","iv,i,ii,iii","I");
        this.addQuestionLogical_Seq(q33);
    }  //7

    public void addQuestionLogical_Seq(QuestionLogical_Seq quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION7());
        values.put(KEY_ANSWER, quest.getANSWER7());
        values.put(KEY_OPTA, quest.getOPTA7());
        values.put(KEY_OPTB, quest.getOPTB7());
        values.put(KEY_OPTC, quest.getOPTC7());
        values.put(KEY_OPTD, quest.getOPTD7());
        values.put(KEY_CAT,quest.getCATEGORY7());
        // Inserting Row
        dbase.insert(TABLE_QUEST7, null, values);
    }

    private void addQuestionsNum_Ana() {   // x
        QuestionNum_Ana q1 = new QuestionNum_Ana("6 : 18 : : 4 : ?", "2", "6", "8", "16", "8", "B");
        this.addQuestionNum_Ana(q1);
        QuestionNum_Ana q2 = new QuestionNum_Ana("14 : 9 :: 26 : ?", "12", "13", "31", "15", "15", "B");
        this.addQuestionNum_Ana(q2);
        QuestionNum_Ana q3 = new QuestionNum_Ana("583 : 293 : : 488 : ?", "291", "378", "487", "581", "378", "B");
        this.addQuestionNum_Ana(q3);
        QuestionNum_Ana q4 = new QuestionNum_Ana("7 : 48 :: 12 :: ?", "143", "84", "121", "112", "143", "B");
        this.addQuestionNum_Ana(q4);
        QuestionNum_Ana q5 = new QuestionNum_Ana("5 : 150 :: 8 : __", "520", "516", "584", "576", "576", "B");
        this.addQuestionNum_Ana(q5);
        QuestionNum_Ana q6 = new QuestionNum_Ana("441 : 462 :: 841 : ?", "800", "830", "870", "890", "870", "B");
        this.addQuestionNum_Ana(q6);
        QuestionNum_Ana q7 = new QuestionNum_Ana("42 : 56 : : 110 : ?", "18", "126", "132", "140", "132", "B");
        this.addQuestionNum_Ana(q7);
        QuestionNum_Ana q8 = new QuestionNum_Ana("Find the missing number .\n" +
                "25 : 36 :: 49 : _", "61", "63", "65", "60", "60", "B");
        this.addQuestionNum_Ana(q8);
        QuestionNum_Ana q9 = new QuestionNum_Ana("3 : 9 : : 4 : .....", "12", "16", "18", "24", "16", "B");
        this.addQuestionNum_Ana(q9);
        QuestionNum_Ana q10 = new QuestionNum_Ana("5:124::8: ...........", "511", "650", "400", "850", "511", "B");
        this.addQuestionNum_Ana(q10);
        QuestionNum_Ana q11 = new QuestionNum_Ana("583 is related to 293 in the same way as 488 is related to____", "291", "378", "487", "581", "378", "E");
        this.addQuestionNum_Ana(q11);
        QuestionNum_Ana q12 = new QuestionNum_Ana("Find the missing numbre.\n" +
                "11 : 25:: 17 : _", "33", "28", "41", "37", "37", "E");
        this.addQuestionNum_Ana(q12);
        QuestionNum_Ana q13 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "26 : 5 : : 65 : ?", "6", "7", "8", "9", "8", "E");
        this.addQuestionNum_Ana(q13);
        QuestionNum_Ana q14 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "14 : 9 : : 26 : ?", "12", "13", "15", "31", "15", "E");
        this.addQuestionNum_Ana(q14);
        QuestionNum_Ana q15 = new QuestionNum_Ana("96 : 9 : : 72: _____", "27", "25", "35", "14", "25", "E");
        this.addQuestionNum_Ana(q15);
        QuestionNum_Ana q16 = new QuestionNum_Ana("14 : 9 : : 26 : ?", "12", "13", "15", "31", "15", "E");
        this.addQuestionNum_Ana(q16);
        QuestionNum_Ana q17 = new QuestionNum_Ana("42 : 20 : : 64 : ?", "31", "32", "33", "34", "31", "E");
        this.addQuestionNum_Ana(q17);
        QuestionNum_Ana q18 = new QuestionNum_Ana("324 : 400 ::576 : __", "625", "729", "784", "900", "625", "E");
        this.addQuestionNum_Ana(q18);
        QuestionNum_Ana q19 = new QuestionNum_Ana("25: 37: : 49: ?", "41", "56", "60", "65", "65", "E");
        this.addQuestionNum_Ana(q19);
        QuestionNum_Ana q20 = new QuestionNum_Ana("123 : 6 :: 234 : .......", "24", "28", "32", "36", "24", "E");
        this.addQuestionNum_Ana(q20);
        QuestionNum_Ana q21 = new QuestionNum_Ana("26 : 5 : : 65 : ?", "6", "7", "8", "9", "8", "I");
        this.addQuestionNum_Ana(q21);
        QuestionNum_Ana q22 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "7 : 56 : : 9 : ?", "63", "81", "90", "99", "90", "I");
        this.addQuestionNum_Ana(q22);
        QuestionNum_Ana q23 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "21 : 3 : : 574 : ?", "23", "82", "97", "113", "82", "I");
        this.addQuestionNum_Ana(q23);
        QuestionNum_Ana q24 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "14 : 9 : : 26 : ?", "12", "13", "15", "31", "15", "I");
        this.addQuestionNum_Ana(q24);
        QuestionNum_Ana q25 = new QuestionNum_Ana("\tChoose the best alternative.\n" +
                "149 : 238 : :  159 : ?", "169", "248", "261", "268", "248", "I");
        this.addQuestionNum_Ana(q25);
        QuestionNum_Ana q26 = new QuestionNum_Ana("\tChoose the best alternative.\n" +
                "42 : 56 : : 110 : ?", "18", "132", "136", "140", "132", "I");
        this.addQuestionNum_Ana(q26);
        QuestionNum_Ana q27 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "8 : 28 : : 27 : ?", "55", "63", "64", "65", "65", "I");
        this.addQuestionNum_Ana(q27);
        QuestionNum_Ana q28 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "68 : 130 : : ? : 350", "210", "216", "222", "240", "222", "I");
        this.addQuestionNum_Ana(q28);
        QuestionNum_Ana q29 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "42 : 56 ; ; 72 : ?", "81", "90", "92", "100", "90", "I");
        this.addQuestionNum_Ana(q29);
        QuestionNum_Ana q30 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "7584 : 5362 : :  4673 : ?", "2367", "2451", "2531", "None of these", "2451", "I");
        this.addQuestionNum_Ana(q30);
        QuestionNum_Ana q31 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "0.16 : 0.0016 : : 1.02 : ?", "0.0102", "0.102", "1.020", "10.20", "0.0102", "B");
        this.addQuestionNum_Ana(q31);
        QuestionNum_Ana q32 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "583 : 293 : : 488 : ?", "291", "378", "487", "581", "378", "E");
        this.addQuestionNum_Ana(q32);
        QuestionNum_Ana q33 = new QuestionNum_Ana("Choose the best alternative.\n" +
                "16 : 56 : : 32 : ?", "96", "112", "118", "128", "112", "I");
        this.addQuestionNum_Ana(q33);
    }  // 8

    public void addQuestionNum_Ana(QuestionNum_Ana quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION8());
        values.put(KEY_ANSWER, quest.getANSWER8());
        values.put(KEY_OPTA, quest.getOPTA8());
        values.put(KEY_OPTB, quest.getOPTB8());
        values.put(KEY_OPTC, quest.getOPTC8());
        values.put(KEY_OPTD, quest.getOPTD8());
        values.put(KEY_CAT,quest.getCATEGORY8());
        // Inserting Row
        dbase.insert(TABLE_QUEST8, null, values);
    }

    private void addQuestionsSit_Reaction() {   // x
        QuestionSit_Reaction q1 = new QuestionSit_Reaction("You are in a bus. The bus reaches your stop but still you have not purchased the ticket because of heavy rush. What will you do?","Jump out quickly to avoid embarrassment","call the conductor, give him the money and get the ticket","Hand the money to someone sitting nearby to give it to the conductor","Give the money to the driver","call the conductor, give him the money and get the ticket","B");
        this.addQuestionSit_Reaction(q1);
        QuestionSit_Reaction q2 = new QuestionSit_Reaction("You have made some silly mistakes which have been pointed out to you. You will:","laugh it away.","get angry.","feel miserable.","feel thankful.","feel thankful.","B");
        this.addQuestionSit_Reaction(q2);
        QuestionSit_Reaction q3 = new QuestionSit_Reaction("You are interviewed for a new job. Which of the following questions is most important to you?","Opportunities for promotion","Remuneration you will be paid","Scope to develop your ideas and use them to improve the working of the organization","All the above are equally important","All the above are equally important","B");
        this.addQuestionSit_Reaction(q3);
        QuestionSit_Reaction q4 = new QuestionSit_Reaction("Select the most appropriate alternative as the answer.: You are walking down the street and suddenly you see two hundred rupee notes on the pavement. What action will you take?","Pocket it yourself.","Leave it where it is.","Give the money to a beggar.","Deposit it to the nearest police station.","Deposit it to the nearest police station.","B");
        this.addQuestionSit_Reaction(q4);
        QuestionSit_Reaction q5 = new QuestionSit_Reaction("While going on a scooter, you find someone has been hurt by your vehicle, you would","Try to run away from the spot immediately","stop your vehicle and say 'I am sorry'","Take him to doctor and arrange for his medical aid","pay compensation for the injury and in this way","Take him to doctor and arrange for his medical aid","B");
        this.addQuestionSit_Reaction(q5);
        QuestionSit_Reaction q6 = new QuestionSit_Reaction("You find that the person whom you call friend has been cheating you. What would you do?","Make him realize his mistake","Break relations with him","Tell other friends about him","Give him tit for tat","Make him realize his mistake","B");
        this.addQuestionSit_Reaction(q6);
        QuestionSit_Reaction q7 = new QuestionSit_Reaction("Your friend has not invited you to his marriage party. You will:","hold it against him","attend the ceremony","send him your best wishes","ignore the whole affair","send him your best wishes","B");
        this.addQuestionSit_Reaction(q7);
        QuestionSit_Reaction q8 = new QuestionSit_Reaction("You are living in a college hostel. The dal served to you in the mess has a lot of stones. What would you do?\n","Leave eating the dal altogether.","Bring the matter to the notice of mess in charge.","Speak to the cook about changing the dal.","Buy your own dal and cook it in your room.","Bring the matter to the notice of mess in charge.","B");
        this.addQuestionSit_Reaction(q8);
        QuestionSit_Reaction q9 = new QuestionSit_Reaction("If in the examination hall, you find that the question paper is too tough to be answered satisfactorily by you, the best thing to do for you is to:","tell the examiner that the questions are out of course.","provoke the candidates to walk out of the examination hall.","try to know something from your neighbour.","try to solve the questions as much as you know with a cool head.","try to solve the questions as much as you know with a cool head.","B");
        this.addQuestionSit_Reaction(q9);
        QuestionSit_Reaction q10 = new QuestionSit_Reaction("You are having tea in your office, some of the tea spills on your clothes. You will","call the peon to wipe off the tea from your clothes","yourself wipe off the tea from your clothes","hide the stain marks","ask the peon to fetch clothes from your house","yourself wipe off the tea from your clothes","B");
        this.addQuestionSit_Reaction(q10);
        QuestionSit_Reaction q11 = new QuestionSit_Reaction("You are playing football in a park. When you kick the ball, it strikes and breaks the window pane of a nearby house. You would :","demand your ball back from the house owner","say that it was no fault of yours","stealthily get your ball back","apologize to the house owner and contribute to replace the glass","apologize to the house owner and contribute to replace the glass","E");
        this.addQuestionSit_Reaction(q11);
        QuestionSit_Reaction q12 = new QuestionSit_Reaction("On reaching the railway station, you find that the train you wanted to catch is just to start and there is hardly any time for purchasing the ticket. The best thing for you is to","rush to the train rather than miss it and inform the T.T.I. at the next stoppage about your inability to purchase the ticket","rush to the train and perform your journey quietly","first purchase the ticket and then catch the train if it is there","miss the train rather than take the risk of boarding the moving train","rush to the train rather than miss it and inform the T.T.I. at the next stoppage about your inability to purchase the ticket","E");
        this.addQuestionSit_Reaction(q12);
        QuestionSit_Reaction q13 = new QuestionSit_Reaction(" While travelling in your car, certain persons stop you on the way asking you to take an injured child to the hospital. You would","ask them to leave your way and then drive away","Ask them to first call the police","Immediately take the child to a hospital","Get out of the car and some other person to help","Immediately take the child to a hospital","E");
        this.addQuestionSit_Reaction(q13);
        QuestionSit_Reaction q14 = new QuestionSit_Reaction("A person managing the front office of an organization should have","Patience","Leadership","Discipline","Personality","Patience","E");
        this.addQuestionSit_Reaction(q14);
        QuestionSit_Reaction q15 = new QuestionSit_Reaction("You are in the parking area of a shopping complex. And suddenly the electricity fails and there is total darkness. You will","Shout for help","Wait till the lights come","Crawl towards your vehicle","Try and take help from someone around","Crawl towards your vehicle","E");
        this.addQuestionSit_Reaction(q15);
        QuestionSit_Reaction q16 = new QuestionSit_Reaction("While attending your friend's party, you see your friend's muffler catching fire from the candle on the table behind him. you would :","ask your friend to see behind him.","rush to call friend's mother.","rush and taking out the muffler from his neck, drop it our water in it.","take out the muffler and throw it away.","rush and taking out the muffler from his neck, drop it our water in it.","E");
        this.addQuestionSit_Reaction(q16);
        QuestionSit_Reaction q17 = new QuestionSit_Reaction("When you see a blind man trying to cross the road, you","wait till he crosses the road","ask someone to help him","go and help him","ignore and move on","go and help him","E");
        this.addQuestionSit_Reaction(q17);
        QuestionSit_Reaction q18 = new QuestionSit_Reaction("You are the guest at a dinner. The host asks you to take one more chapati after your stomach is full. You would:","make a blunt refuse.","take the chapati.","politely say that the food was too good and you have already eaten much.","make a bad face at him.","politely say that the food was too good and you have already eaten much.","E");
        this.addQuestionSit_Reaction(q18);
        QuestionSit_Reaction q19 = new QuestionSit_Reaction("Your bathroom tap is leaking and is a constant source of an irritating noise. You would","sleep with pillows upon your ears","put a bucket underneath","call a plumber to repair the tap","try to put up a cork upon the mouth of the tap","call a plumber to repair the tap","E");
        this.addQuestionSit_Reaction(q19);
        QuestionSit_Reaction q20 = new QuestionSit_Reaction("While travelling on a train, you notice a man from the coach behind yours fall off the train. You would :","pull the alarm chain so that the train may stop and the man may be helped.","shout at the falling man asking him to get up quickly and entrain.","jump off the train to assist the falling man.","wait till the train stops at the next station and inform the railway authorities there.","pull the alarm chain so that the train may stop and the man may be helped.","E");
        this.addQuestionSit_Reaction(q20);
        QuestionSit_Reaction q21 = new QuestionSit_Reaction("You are interviewed for a new job. Which of the following questions is most important to you?","Opportunities for promotion","Remuneration you will be paid","Scope to develop your ideas and use them to improve the working of the organization","All the above are equally important","All the above are equally important","I");
        this.addQuestionSit_Reaction(q21);
        QuestionSit_Reaction q22 = new QuestionSit_Reaction("Which is the best quality in a man?","Sincerity","Ability to please others","Talk politely","Ability to work hard","Sincerity","I");
        this.addQuestionSit_Reaction(q22);
        QuestionSit_Reaction q23 = new QuestionSit_Reaction(" You are moving across the road on a scooter when you observe that two boys on a bike snatch a lady's gold chain and side away. You would","console the women","chase the boys to catch hold of them","inform the police about the matter","stand and see what happens","chase the boys to catch hold of them","I");
        this.addQuestionSit_Reaction(q23);
        QuestionSit_Reaction q24 = new QuestionSit_Reaction("You are playing in your friend's house when he gets stuck with a nacked electric wire. You would :","hold him by the arms and try to set him free","hold the wire and pull it away","pull off the wire with a wooden stick","send for the doctor","pull off the wire with a wooden stick","I");
        this.addQuestionSit_Reaction(q24);
        QuestionSit_Reaction q25 = new QuestionSit_Reaction("Your classmate who is usually very energetic and happy all the time looks very down and upset. You will","Wait for him to come up and tell you the reason","Go up to him and ask the reason","Carry on with your work","Tell one of your friends to go and talk to him","Go up to him and ask the reason","I");
        this.addQuestionSit_Reaction(q25);
        QuestionSit_Reaction q26 = new QuestionSit_Reaction("You are passing by a river and you know swimming. Suddenly, you hear the cry o f a drowning child. You would :","dive into the river to save him.","wait to see if some other person is there to help","look for professional divers","console the child’s parents","dive into the river to save him.","I");
        this.addQuestionSit_Reaction(q26);
        QuestionSit_Reaction q27 = new QuestionSit_Reaction("You are in the parking area of a shopping complex. And, suddenly the electricity fails and there is total darkness. You will ","try and take help from someone around","crawl towards your vehicle","shout for help","wait till the lights come","crawl towards your vehicle","I");
        this.addQuestionSit_Reaction(q27);
        QuestionSit_Reaction q28 = new QuestionSit_Reaction("If you find yourself in a situation where you are required to make a power - point presentation and you are already bogged down by too much work, as the manager what would you do?","Cancel the seminar and reschedule according to your convenience","Take an alternative mode of presentation","Prioritize your work and try to squeeze out time for it","Pass the buck to your subordinate, you are the boss, no one can question you","Prioritize your work and try to squeeze out time for it","I");
        this.addQuestionSit_Reaction(q28);
        QuestionSit_Reaction q29 = new QuestionSit_Reaction("On reaching the railway station, you find that the train you wanted to catch is just to start and there is hardly any time for purchasing the ticket. The best thing for you is to :","rush to the train and perform your journey quietly.","rush to the train rather than miss it and inform the T.T.I. at the next stoppage about your inability to purchase the ticket.","miss the train rather than take the risk of boarding the moving train.","first purchase the ticket and then catch the train if it is there.","rush to the train rather than miss it and inform the T.T.I. at the next stoppage about your inability to purchase the ticket.","I");
        this.addQuestionSit_Reaction(q29);
        QuestionSit_Reaction q30 = new QuestionSit_Reaction("You are returning home from school. On the way, you find a sealed envelope in a street, fully addressed with unused stamps on it You would :","remove the stamps and destroy the envelope.","leave it there as it was and walk away","post it at the nearest letter box.","open the envelope, find out who has dropped it by mistake, and send it to him if possible.","post it at the nearest letter box.","I");
        this.addQuestionSit_Reaction(q30);
        QuestionSit_Reaction q31 = new QuestionSit_Reaction("While travelling in a train, you observe some college students pulling the alarm chain simply to get down at their desired point. You would :","let them pull the chain but check them from detraining.","with the help of some passengers, check them from doing so","inform the guard of the train as soon as it stops.","keep quiet and do nothing.","with the help of some passengers, check them from doing so","B");
        this.addQuestionSit_Reaction(q31);
        QuestionSit_Reaction q32 = new QuestionSit_Reaction("You are returning home from school. On the way, you find a sealed envelope in a street, fully addressed with unused stamps on it You would :","remove the stamps and destroy the envelope.","leave it there as it was and walk away","post it at the nearest letter box.","open the envelope, find out who has dropped it by mistake, and send it to him if possible.","post it at the nearest letter box.","E");
        this.addQuestionSit_Reaction(q32);
        QuestionSit_Reaction q33 = new QuestionSit_Reaction("An Angry customer wants to meet the senior manager for grievance reporting. What will you do?","Be patient and try to cool him down","Talk to him yourself","Tell him it is not easy to meet the senior manager","Try to remove his inconveniences by consulting seniors","Be patient and try to cool him down","I");
        this.addQuestionSit_Reaction(q33);
    } // 9

    public void addQuestionSit_Reaction(QuestionSit_Reaction quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION9());
        values.put(KEY_ANSWER, quest.getANSWER9());
        values.put(KEY_OPTA, quest.getOPTA9());
        values.put(KEY_OPTB, quest.getOPTB9());
        values.put(KEY_OPTC, quest.getOPTC9());
        values.put(KEY_OPTD, quest.getOPTD9());
        values.put(KEY_CAT,quest.getCATEGORY9());
        // Inserting Row
        dbase.insert(TABLE_QUEST9, null, values);
    }

    private void addQuestionsVerify_Truth() {   // x
        QuestionVerify_Truth q1 = new QuestionVerify_Truth("A tree always has which of the following_______","Shadow","Leaves","Branches","Roots","Roots","B");
        this.addQuestionVerify_Truth(q1);
        QuestionVerify_Truth q2 = new QuestionVerify_Truth("Choose the best alternative as the answer.: Which of the following a 'Drama' must have?","Actors","Story","Sets","Director","Story","B");
        this.addQuestionVerify_Truth(q2);
        QuestionVerify_Truth q3 = new QuestionVerify_Truth("A school always has …………","Principal","Building","Library","Teachers","Teachers","B");
        this.addQuestionVerify_Truth(q3);
        QuestionVerify_Truth q4 = new QuestionVerify_Truth("Rose forms a group of Plants","Sometimes","Always","Never","Often","Always","B");
        this.addQuestionVerify_Truth(q4);
        QuestionVerify_Truth q5 = new QuestionVerify_Truth("Which one of the following is always found in \"Bravery\"?","Experience","Power","Courage","Knowledge","Courage","B");
        this.addQuestionVerify_Truth(q5);
        QuestionVerify_Truth q6 = new QuestionVerify_Truth("What is found necessary in milk?","Cream","Curd","Water","Whiteness","Whiteness","B");
        this.addQuestionVerify_Truth(q6);
        QuestionVerify_Truth q7 = new QuestionVerify_Truth("A race always has","Referee","Spectators","Rivals","Prize","Rivals","B");
        this.addQuestionVerify_Truth(q7);
        QuestionVerify_Truth q8 = new QuestionVerify_Truth("In India a widow can marry her brother-in-law although a man cannot marry the sister of his dead wife","Always often","Sometimes","Often","Never","Sometimes","B");
        this.addQuestionVerify_Truth(q8);
        QuestionVerify_Truth q9 = new QuestionVerify_Truth("A bulb always has","Filament","Light","Glass","Current","Filament","B");
        this.addQuestionVerify_Truth(q9);
        QuestionVerify_Truth q10 = new QuestionVerify_Truth("Cricket always has","Stamps","Pitch","Glove","Bat","Bat","B");
        this.addQuestionVerify_Truth(q10);
        QuestionVerify_Truth q11 = new QuestionVerify_Truth("A song always has","Words","Chorus","Musician","Tymbal","Words","E");
        this.addQuestionVerify_Truth(q11);
        QuestionVerify_Truth q12 = new QuestionVerify_Truth("A window always has","Curtain","Panes","Grill","None of these","None of these","E");
        this.addQuestionVerify_Truth(q12);
        QuestionVerify_Truth q13 = new QuestionVerify_Truth("A chocolate always has","Wrapper","Cocoa","Nuts","Milk","Cocoa","E");
        this.addQuestionVerify_Truth(q13);
        QuestionVerify_Truth q14 = new QuestionVerify_Truth("Which of the following is always associated with TREE?","Roots","Flowers","Leaves","Fruits","Roots","E");
        this.addQuestionVerify_Truth(q14);
        QuestionVerify_Truth q15 = new QuestionVerify_Truth("Which one of the following is always with ‘Bargain’?","Exchange","Sumptuousness","Triviality","Eloquence","Exchange","E");
        this.addQuestionVerify_Truth(q15);
        QuestionVerify_Truth q16 = new QuestionVerify_Truth("A boy is sitting at the back seat of a car. When the driver suddenly starts moving the car (in forward direction), the boy experiences a backward force?","Always","Never","Often","Sometimes","Always","E");
        this.addQuestionVerify_Truth(q16);
        QuestionVerify_Truth q17 = new QuestionVerify_Truth("Which of the following an animal always has?","lungs","Skin","Heart","Life","Life","E");
        this.addQuestionVerify_Truth(q17);
        QuestionVerify_Truth q18 = new QuestionVerify_Truth("A river always has","Banks","Fishes","Weeds","Boats","Banks","E");
        this.addQuestionVerify_Truth(q18);
        QuestionVerify_Truth q19 = new QuestionVerify_Truth("A fan always has","Switch","Blades","Current","Wires","Blades","E");
        this.addQuestionVerify_Truth(q19);
        QuestionVerify_Truth q20 = new QuestionVerify_Truth("If Ramesh is going early in the morning towards the south the sun will be visible at his opposite side to right side:","Never","Sometimes","Often","Always","Always","E");
        this.addQuestionVerify_Truth(q20);
        QuestionVerify_Truth q21 = new QuestionVerify_Truth("Quilt always has …………","Cotton","Cover","Print","Tags","Cotton","I");
        this.addQuestionVerify_Truth(q21);
        QuestionVerify_Truth q22 = new QuestionVerify_Truth("Choose the best alternative as the answer.: A mirror always","Reflects","Retracts","Distorts","Refracts","Reflects","I");
        this.addQuestionVerify_Truth(q22);
        QuestionVerify_Truth q23 = new QuestionVerify_Truth("A hill always has","Height","Trees","Animals","Water","Height","I");
        this.addQuestionVerify_Truth(q23);
        QuestionVerify_Truth q24 = new QuestionVerify_Truth("A scenery always has ________","Rivers","Mountains","Paints","Composition","Composition","I");
        this.addQuestionVerify_Truth(q24);
        QuestionVerify_Truth q25 = new QuestionVerify_Truth("Hydrogen is lighter than Hydrogen .Hydrogen is lighter than helium.Therefore,Oxygen is the heaviest of the three gases","False","Probably false","True","Can't say","Can't say","I");
        this.addQuestionVerify_Truth(q25);
        QuestionVerify_Truth q26 = new QuestionVerify_Truth("Atmosphere always has","Oxygen","Air","Moisture","Dust","Air","I");
        this.addQuestionVerify_Truth(q26);
        QuestionVerify_Truth q27 = new QuestionVerify_Truth("The presence ofcalcium in milk makes it white.Rice,too,is white.Therefore rice also contains calcium","False","Probably true","True","Can't say","Can't say","I");
        this.addQuestionVerify_Truth(q27);
        QuestionVerify_Truth q28 = new QuestionVerify_Truth("Controversy always involves","Dislike","Injustice","Disagreement","Anger","Disagreement","I");
        this.addQuestionVerify_Truth(q28);
        QuestionVerify_Truth q29 = new QuestionVerify_Truth("A child must have had ","Toys","Friends","Parents","Education","Parents","I");
        this.addQuestionVerify_Truth(q29);
        QuestionVerify_Truth q30 = new QuestionVerify_Truth("People who are bald are generally of the intellectual type.Arun is bald.Therefore Arun is an intellectual","False","Probably true","True","Can't say","Probably true","I");
        this.addQuestionVerify_Truth(q30);
        QuestionVerify_Truth q31 = new QuestionVerify_Truth("Which of the following statements is correct?","I am very happy to start this Program","I am too happy to start this Program","Both A & B","None","I am very happy to start this Program","B");
        this.addQuestionVerify_Truth(q31);
        QuestionVerify_Truth q32 = new QuestionVerify_Truth("Which of the following is associated with diamond?","Brilliance","Conductivity","Sharpness","Hardness","Hardness","E");
        this.addQuestionVerify_Truth(q32);
        QuestionVerify_Truth q33 = new QuestionVerify_Truth("Which of the following is always with bargain?","Sumptuousness","Exchange","Triviality","Eloquence","Exchange","I");
        this.addQuestionVerify_Truth(q33);
    } //10

    public void addQuestionVerify_Truth(QuestionVerify_Truth quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION10());
        values.put(KEY_ANSWER, quest.getANSWER10());
        values.put(KEY_OPTA, quest.getOPTA10());
        values.put(KEY_OPTB, quest.getOPTB10());
        values.put(KEY_OPTC, quest.getOPTC10());
        values.put(KEY_OPTD, quest.getOPTD10());
        values.put(KEY_CAT,quest.getCATEGORY10());
        // Inserting Row
        dbase.insert(TABLE_QUEST10, null, values);
    }

    private void addQuestionsClassification() {   // x
        QuestionClassification q1 = new QuestionClassification("Choose the word which is least like other words in the group.","Zebra","Lion","Tiger","Horse","Horse","B");
        this.addQuestionClassification(q1);
        QuestionClassification q2 = new QuestionClassification("Choose the word which is least like the others word in a group?","Carrot","Ginger","Potato","Tomato","Tomato","B");
        this.addQuestionClassification(q2);
        QuestionClassification q3 = new QuestionClassification("In this question, five words have been given, out of which four are alike in some manner and the fifth one is different. Choose out the odd one?","Potassium","Silicon","Zirconium","Gallium","Potassium","B");
        this.addQuestionClassification(q3);
        QuestionClassification q4 = new QuestionClassification("Choose out the odd one?","Ant","Bee","Moth","Spider","Spider","B");
        this.addQuestionClassification(q4);
        QuestionClassification q5 = new QuestionClassification("Choose or find odd word: Garnet , Ruby , Graphite , Emerald , Topaz","Garnet","Ruby","Graphite","Emerald","Graphite","B");
        this.addQuestionClassification(q5);
        QuestionClassification q6 = new QuestionClassification("Choose the word which is least like the others word in a group?","Calendar","Date","Day","Month","Calendar","B");
        this.addQuestionClassification(q6);
        QuestionClassification q7 = new QuestionClassification("Find the odd one out","crusade","campaign","expedition","cruise","cruise","B");
        this.addQuestionClassification(q7);
        QuestionClassification q8 = new QuestionClassification("In the following questions, a set of similar terms is given in which one of the term is odd and does not fit in the given set. You have to choose the term which does NOT fit in the set.","1089","729","529","DISK","644","B");
        this.addQuestionClassification(q8);
        QuestionClassification q9 = new QuestionClassification("Choose the number which is different from others in the group.","17","27","37","29","27","B");
        this.addQuestionClassification(q9);
        QuestionClassification q10 = new QuestionClassification("Choose the word which is different from the rest.","Cap","Turban","Helmet","Veil","Veil","B");
        this.addQuestionClassification(q10);
        QuestionClassification q11 = new QuestionClassification("Find the odd one out","Circle : Arc","Chair : Leg","Flower : Petal","Cover : Page","Cover : Page","E");
        this.addQuestionClassification(q11);
        QuestionClassification q12 = new QuestionClassification("Choose the word which is least like the other words.","Sun","Moon","Mars","Universe","Universe","E");
        this.addQuestionClassification(q12);
        QuestionClassification q13 = new QuestionClassification("Find the odd term from the given alternatives.","AOU","EOI","UIE","ALO","ALO","E");
        this.addQuestionClassification(q13);
        QuestionClassification q14 = new QuestionClassification("Choose the odd one.","Snake","Whale","Crocodile","Lizard","Whale","E");
        this.addQuestionClassification(q14);
        QuestionClassification q15 = new QuestionClassification("Choose the odd one out","Table","Cupboard","Chair","Paper Weight","Paper Weight","E");
        this.addQuestionClassification(q15);
        QuestionClassification q16 = new QuestionClassification("Choose the word which is different from the rest.","Rigveda","Yajurveda","Atharvaveda","Ayurveda","Ayurveda","E");
        this.addQuestionClassification(q16);
        QuestionClassification q17 = new QuestionClassification(" In each of the following questions three out of four alternatives contain letters of the alphabet placed in a particular form. Find the one that does not belong to the group.","RNMQ","GDCF","LIHK","AXWZ","RNMQ","E");
        this.addQuestionClassification(q17);
        QuestionClassification q18 = new QuestionClassification("Which word does NOT belong with the others?","branch","dirt","leaf","root","dirt","E");
        this.addQuestionClassification(q18);
        QuestionClassification q19 = new QuestionClassification("Choose the odd one out","Screw","Hammer","Pin","Needle","Hammer","E");
        this.addQuestionClassification(q19);
        QuestionClassification q20 = new QuestionClassification("Choose the number which is different from others in the group.","37","45","49","65","49","E");
        this.addQuestionClassification(q20);
        QuestionClassification q21 = new QuestionClassification("Choose the odd one out.","Saw : Wood","Pen : Paper","Author : Book","Chalk : Blackboard","Author : Book","I");
        this.addQuestionClassification(q21);
        QuestionClassification q22 = new QuestionClassification("Choose the word which is least like the others word in a group?","Day","Calendar","Date","Month","Calendar","I");
        this.addQuestionClassification(q22);
        QuestionClassification q23 = new QuestionClassification("Choose the word which is least like the others word in a group?","Sister","Friend","Father","Brother","Friend","I");
        this.addQuestionClassification(q23);
        QuestionClassification q24 = new QuestionClassification("Choose out the odd one.","Tortoise","Duck","Whale","Snake","Whale","I");
        this.addQuestionClassification(q24);
        QuestionClassification q25 = new QuestionClassification("Find the odd letters from the given alternatives.","RKD","UNG","MTF","SLE","MTF","I");
        this.addQuestionClassification(q25);
        QuestionClassification q26 = new QuestionClassification("Find the odd one out","crusade","campaign","expedition","cruise","cruise","I");
        this.addQuestionClassification(q26);
        QuestionClassification q27 = new QuestionClassification("Four of the following five are alike in a certain way and so form a group. which one does not belong to that group?","Tooth","Chin","Nose","Ear","Chin","I");
        this.addQuestionClassification(q27);
        QuestionClassification q28 = new QuestionClassification("Three of the following four are alike in a certain way and hence form a group. Which is the one that does not belong to that group?","Shirt","Shoe","Ring","Cobbler","Cobbler","I");
        this.addQuestionClassification(q28);
        QuestionClassification q29 = new QuestionClassification("Choose the number pair/group which is different from others?","7: 22","12 : 37","8 : 33","15 : 46","8 : 33","I");
        this.addQuestionClassification(q29);
        QuestionClassification q30 = new QuestionClassification("In the following question select the one which is different from the other three responses .","DEB","RTP","HIF","NOL","RTP","I");
        this.addQuestionClassification(q30);
        QuestionClassification q31 = new QuestionClassification("Choose out the odd one","Lion","Bear","Cheetah","Leopard","Bear","B");
        this.addQuestionClassification(q31);
        QuestionClassification q32 = new QuestionClassification("Four of the following five are alike in a certain way and so form a group. which one does not belong to that group?","Metre","Furlong","Yard","Acre","Acre","E");
        this.addQuestionClassification(q32);
        QuestionClassification q33 = new QuestionClassification("Three of the following four are alike in a certain way and hence form a group. Which is the one that does not belong to that group?","Clove","Cinnamon","Pepper","Apricot","Apricot","I");
        this.addQuestionClassification(q33);
    } //11

    public void addQuestionClassification(QuestionClassification quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION11());
        values.put(KEY_ANSWER, quest.getANSWER11());
        values.put(KEY_OPTA, quest.getOPTA11());
        values.put(KEY_OPTB, quest.getOPTB11());
        values.put(KEY_OPTC, quest.getOPTC11());
        values.put(KEY_OPTD, quest.getOPTD11());
        values.put(KEY_CAT,quest.getCATEGORY11());
        // Inserting Row
        dbase.insert(TABLE_QUEST11, null, values);
    }

    private void addQuestionsEssential_Part() {   // x
        QuestionEssential_Part q1 = new QuestionEssential_Part("school","student","report card","test","learning","student","B");
        this.addQuestionEssential_Part(q1);
        QuestionEssential_Part q2 = new QuestionEssential_Part("harvest","autumn","stockpile","tractor","crop","crop","B");
        this.addQuestionEssential_Part(q2);
        QuestionEssential_Part q3 = new QuestionEssential_Part("book","friction","pages","pictures","learning","pages","B");
        this.addQuestionEssential_Part(q3);
        QuestionEssential_Part q4 = new QuestionEssential_Part("guitar","band","teacher","songs","strings","strings","B");
        this.addQuestionEssential_Part(q4);
        QuestionEssential_Part q5 = new QuestionEssential_Part("DISEASE","Cure","Patient","Cause","Doctor","Cause","B");
        this.addQuestionEssential_Part(q5);
        QuestionEssential_Part q6 = new QuestionEssential_Part("desert","cactus","arid","oasis","flat","arid","B");
        this.addQuestionEssential_Part(q6);
        QuestionEssential_Part q7 = new QuestionEssential_Part("Pain","cut","nuisance","burn","hurt","hurt","B");
        this.addQuestionEssential_Part(q7);
        QuestionEssential_Part q8 = new QuestionEssential_Part("Knowledge","Teacher","Wisdom","Learning","Power","Learning","B");
        this.addQuestionEssential_Part(q8);
        QuestionEssential_Part q9 = new QuestionEssential_Part("College","Projects","Knowledge","Professor","Canteen","Professor","B");
        this.addQuestionEssential_Part(q9);
        QuestionEssential_Part q10 = new QuestionEssential_Part("autograph","athlete","actor","signature","pen","signature","B");
        this.addQuestionEssential_Part(q10);
        QuestionEssential_Part q11 = new QuestionEssential_Part("election","president","November","voter","nation","voter","E");
        this.addQuestionEssential_Part(q11);
        QuestionEssential_Part q12 = new QuestionEssential_Part("Shoe","Sole","Leather","Laces","Walking","Sole","E");
        this.addQuestionEssential_Part(q12);
        QuestionEssential_Part q13 = new QuestionEssential_Part("monopoly","corrupt","exclusive","rich","gigantic","exclusive","E");
        this.addQuestionEssential_Part(q13);
        QuestionEssential_Part q14 = new QuestionEssential_Part("Language","Tongue","Slang","Writing","Words","Words","E");
        this.addQuestionEssential_Part(q14);
        QuestionEssential_Part q15 = new QuestionEssential_Part("\"A ______ could not exist without ______.\". Find the word that names a necessary part of the underlined word.\n" +
                "wedding","love","church","ring","marriage","marriage","E");
        this.addQuestionEssential_Part(q15);
        QuestionEssential_Part q16 = new QuestionEssential_Part("respiration","mouth","circulation","oxygen","carbon monoxide","oxygen","E");
        this.addQuestionEssential_Part(q16);
        QuestionEssential_Part q17 = new QuestionEssential_Part("diploma","principal","curriculum","employment","graduation","graduation","E");
        this.addQuestionEssential_Part(q17);
        QuestionEssential_Part q18 = new QuestionEssential_Part("swimming","pool","bathing suit","water","life jacket","water","E");
        this.addQuestionEssential_Part(q18);
        QuestionEssential_Part q19 = new QuestionEssential_Part("lightning","electricity","thunder","brightness","rain","electricity","E");
        this.addQuestionEssential_Part(q19);
        QuestionEssential_Part q20 = new QuestionEssential_Part("gala","celebration","tuxedo","appetizer","orator","celebration","E");
        this.addQuestionEssential_Part(q20);
        QuestionEssential_Part q21 = new QuestionEssential_Part("pain","cut","burn","nuisance","hurt","hurt","I");
        this.addQuestionEssential_Part(q21);
        QuestionEssential_Part q22 = new QuestionEssential_Part("infirmary","surgery","disease","patient","receptionist","patient","I");
        this.addQuestionEssential_Part(q22);
        QuestionEssential_Part q23 = new QuestionEssential_Part("facsimile","picture","image","mimeograph","copier","image","I");
        this.addQuestionEssential_Part(q23);
        QuestionEssential_Part q24 = new QuestionEssential_Part("culture","civility","education","agriculture","customs","customs","I");
        this.addQuestionEssential_Part(q24);
        QuestionEssential_Part q25 = new QuestionEssential_Part("bonus","reward","raise","cash","employer","reward","I");
        this.addQuestionEssential_Part(q25);
        QuestionEssential_Part q26 = new QuestionEssential_Part("antique","rarity","artifact","aged","prehistoric","aged","I");
        this.addQuestionEssential_Part(q26);
        QuestionEssential_Part q27 = new QuestionEssential_Part("itinerary","map","route","travel","guidebook","route","I");
        this.addQuestionEssential_Part(q27);
        QuestionEssential_Part q28 = new QuestionEssential_Part("orchestra","violin","stage","musician","soloist","musician","I");
        this.addQuestionEssential_Part(q28);
        QuestionEssential_Part q29 = new QuestionEssential_Part("dimension","compass","ruler","inch","measure","measure","I");
        this.addQuestionEssential_Part(q29);
        QuestionEssential_Part q30 = new QuestionEssential_Part("sustenance","nourishment","water","grains","menu","nourishment","I");
        this.addQuestionEssential_Part(q30);
        QuestionEssential_Part q31 = new QuestionEssential_Part("ovation","outburst","bravo","applause","encore","applause","B");
        this.addQuestionEssential_Part(q31);
        QuestionEssential_Part q32 = new QuestionEssential_Part("vertebrate","backbone","reptile","mammal","animal","backbone","E");
        this.addQuestionEssential_Part(q32);
        QuestionEssential_Part q33 = new QuestionEssential_Part("provisions","groceries","supplies","gear","caterers","supplies","I");
        this.addQuestionEssential_Part(q33);
    } //12

    public void addQuestionEssential_Part(QuestionEssential_Part quest) {  // x

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION12());
        values.put(KEY_ANSWER, quest.getANSWER12());
        values.put(KEY_OPTA, quest.getOPTA12());
        values.put(KEY_OPTB, quest.getOPTB12());
        values.put(KEY_OPTC, quest.getOPTC12());
        values.put(KEY_OPTD, quest.getOPTD12());
        values.put(KEY_CAT,quest.getCATEGORY12());
        // Inserting Row
        dbase.insert(TABLE_QUEST12, null, values);
    }

    private void addQuestionsRandom() {
        QuestionRandom q1 = new QuestionRandom("From what location are the 1st computer instructions available on boot up?","ROM BIOS","CPU","boot.ini","CONFIG.SYS","ROM BIOS");
        this.addQuestionRandom(q1);
        QuestionRandom q2 = new QuestionRandom("What could cause a fixed disk error.","No-CD installed","bad ram","slow processor","Incorrect CMOS settings","Incorrect CMOS settings");
        this.addQuestionRandom(q2);
        QuestionRandom q3 = new QuestionRandom("Missing slot covers on a computer can cause?","over heat","power surges","EMI","incomplete path for ESD","over heat");
        this.addQuestionRandom(q3);
        QuestionRandom q4 = new QuestionRandom("When installing PCI NICS you can check the IRQ availability by looking at","dip switches","CONFIG.SYS","jumper settings","motherboard BIOS","motherboard BIOS");
        this.addQuestionRandom(q4);
        QuestionRandom q5 = new QuestionRandom("With respect to a network interface card, the term 10/100 refers to","protocol speed","a fiber speed","megabits per seconds","minimum and maximum server speed","megabits per seconds");
        this.addQuestionRandom(q5);
        QuestionRandom q6 = new QuestionRandom("Which Motherboard form factor uses one 20 pin connector","ATX","All of the above","BABY AT","AT","ATX");
        this.addQuestionRandom(q6);
        QuestionRandom q7 = new QuestionRandom("A hard disk is divided into tracks which are further subdivided into:","clusters","sectors","vectors","heads","sectors");
        this.addQuestionRandom(q7);
        QuestionRandom q8 = new QuestionRandom("A wrist grounding strap contains which of the following:","Surge protector","Capacitor","Voltmeter","Resistor","Resistor");
        this.addQuestionRandom(q8);
        QuestionRandom q9 = new QuestionRandom("Which standard govern parallel communications?","RS232","RS-232a","CAT 5","IEEE 1284","IEEE 1284");
        this.addQuestionRandom(q9);
        QuestionRandom q10 = new QuestionRandom("In laser printer technology, what happens during the conditioning stage?","The corona wire places a uniform positive charge on the paper","A uniform negative charge is placed on the photosensitive drum","A uniform negative charge is placed on the toner","All of the above","A uniform negative charge is placed on the photosensitive drum");
        this.addQuestionRandom(q10);
        QuestionRandom q11 = new QuestionRandom("What product is used to clean smudged keys on a keyboard?","TMC solvent","Silicone spray","Denatured alcohol","All-purpose cleaner","All-purpose cleaner");
        this.addQuestionRandom(q11);
        QuestionRandom q12 = new QuestionRandom("ESD would cause the most damage to which component?","Power supply","Expansion board","Monitor","Keyboard","Expansion board");
        this.addQuestionRandom(q12);
        QuestionRandom q13 = new QuestionRandom("To view any currently running Terminate Stay Resident (TSR's) programs you could type:","Memory","MEM","Memmaker","SYS /M","MEM");
        this.addQuestionRandom(q13);
        QuestionRandom q14 = new QuestionRandom("Which type of system board is the MOST likely candidate for processor upgrading if you want maximum performance and future compatibility?","ML","PCI","EISA","ISA","PCI");
        this.addQuestionRandom(q14);
        QuestionRandom q15 = new QuestionRandom("Which peripheral port provides the FASTEST throughput to laser printers?","RS-232","SCSI","Parallel","Serial","Parallel");
        this.addQuestionRandom(q15);
        QuestionRandom q16 = new QuestionRandom("The mouse pointer moves erratically, what is the possible cause? The mouse","ball is dirty","is not connected","driver is not installed properly","has an incorrect IRQ setting","ball is dirt");
        this.addQuestionRandom(q16);
        QuestionRandom q17 = new QuestionRandom("Voltage is measured:","in parallel","in series","after breaking the circuit","after checking resistance","in parallel");
        this.addQuestionRandom(q17);
        QuestionRandom q18 = new QuestionRandom("Your customer tells you the print quality of their dot matrix printer is light then dark. Which of the following could cause the problem.","Paper slippage","Improper ribbon advancement","Paper thickness","Head position","Improper ribbon advancement");
        this.addQuestionRandom(q18);
        QuestionRandom q19 = new QuestionRandom("The 34-pin connection on an I/O card is for?","Floppy drive","SCSI drive","IDE drive","Zip drive","Floppy drive");
        this.addQuestionRandom(q19);
        QuestionRandom q20 = new QuestionRandom("The terms \"red book\", \"yellow book\", and \"orange book\" refer to:","SCSI","ide","floppy drive technology","CD-ROM standards","CD-ROM standards");
        this.addQuestionRandom(q20);
        QuestionRandom q21 = new QuestionRandom("On the 16-bit ISA bus, IRQ2 is elevated to which higher level Interrupt?","9","11","13","15","9");
        this.addQuestionRandom(q21);
        QuestionRandom q22 = new QuestionRandom("To view any currently running Terminate Stay Resident (TSR's) programs you could type:","Memory","MEM","SYS/M","Memmaker","MEM");
        this.addQuestionRandom(q22);
        QuestionRandom q23 = new QuestionRandom("Which part of the laser printer should NOT be exposed to sunlight?","Transfer corona assembly","PC drum","Primary corona wire","PC drumPrimary corona wire","PC drum");
        this.addQuestionRandom(q23);
        QuestionRandom q24 = new QuestionRandom("After doing a low-level format, what would be the next step in configuring the hard drive in a system?","Format DOS partition","Install operating system","Configure DMA channel and back-up interrupt","Partition had disk","Format DOS partition");
        this.addQuestionRandom(q24);
        QuestionRandom q25 = new QuestionRandom("Resistance is measured in ?","Volts","Amps","Watts","Ohms","Ohms");
        this.addQuestionRandom(q25);
        QuestionRandom q26 = new QuestionRandom("What command is used to reset a MODEM when using the AT Command Set?","ATR","ATZ","DTR","DCE","ATZ");
        this.addQuestionRandom(q26);
        QuestionRandom q27 = new QuestionRandom("When installing a SCSI CD-ROM drive, you must set the CD-ROM SCSI adapter to:","B0007","An unused SCSI address","The same address as the SCSI device before the CD-ROM","SCSI ID=1","An unused SCSI address");
        this.addQuestionRandom(q27);
        QuestionRandom q28 = new QuestionRandom("Pick the correct choice for the 80386SXCPU.","16 bit word size, 16 bit data path","32 bit word size, 16 bit data path","8 bit word size, 32 bit data path","32 bit word size, 8 bit data path","32 bit word size, 16 bit data path");
        this.addQuestionRandom(q28);
        QuestionRandom q29 = new QuestionRandom("In Inkjet technology the droplets of ink are deflected by?","multi directional nozzles","electronically charged plates","high pressure plates","electro static absorbtion","multi directional nozzles");
        this.addQuestionRandom(q29);
        QuestionRandom q30 = new QuestionRandom("What tool is used to test serial and parallel ports?","high volt probe","cable scanner","loop backs (wrap plugs)","sniffer","loop backs (wrap plugs)");
        this.addQuestionRandom(q30);
        QuestionRandom q31 = new QuestionRandom("ESD would cause the most damage to which component?","Power supply","Expansion board","Monitor","Keyboard","Expansion board");
        this.addQuestionRandom(q31);
        QuestionRandom q32 = new QuestionRandom("What is the highest binary number that can be referred to on a three position jumper block?","4","6","F","1","1");
        this.addQuestionRandom(q32);
        QuestionRandom q33 = new QuestionRandom("What voltage does a Pentium system use?","+12 volts","+ 5 volts","+ 5 volts","+3.3 volts","+3.3 volts");
        this.addQuestionRandom(q33);
        QuestionRandom q34 = new QuestionRandom("A numeric error code check: A 17xx indicates a problem with:","CMOS","ROM BIOS","DMA controller","hard drive or controller","hard drive or controller");
        this.addQuestionRandom(q34);
        QuestionRandom q35 = new QuestionRandom("Which provides the fastest access to large video files?","Optical drives","IDE hard drives","SCSI hard drives","EIDE hard drives","SCSI hard drives");
        this.addQuestionRandom(q35);
        QuestionRandom q36 = new QuestionRandom("A 25-pin female connector on the back of your computer will typically be:","Serial port 1","A parallel port","Docking","COM2 port","A parallel port");
        this.addQuestionRandom(q36);
        QuestionRandom q37 = new QuestionRandom("You were installing an application in Windows 95, and the computer crashes, what do you do?","press alt + Ctrl + delete, twice","press alt + Ctrl + delete, and end task","press the reset button on the computer","turn off computer and boot from a floppy disk","turn off computer and boot from a floppy disk");
        this.addQuestionRandom(q37);
        QuestionRandom q38 = new QuestionRandom("RS-232 is a standard that applies to:","serial ports","parallel ports","game ports","networks","serial ports");
        this.addQuestionRandom(q38);
        QuestionRandom q39 = new QuestionRandom("You just installed a new IDE hard drive, but your system BIOS will not recognize the new drive, what should you check first.","cable sequence","jumpers on the hard drive","drivers that need to be loaded","hard drive manufacturer web site information","drivers that need to be loaded");
        this.addQuestionRandom(q39);
        QuestionRandom q40 = new QuestionRandom("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed");
        this.addQuestionRandom(q40);
        QuestionRandom q41 = new QuestionRandom("What is the best ground for a conductive work bench?","AC outlet","Ground to bend","To another device","Chassis ground","AC outlet");
        this.addQuestionRandom(q41);
        QuestionRandom q42 = new QuestionRandom("Topically, how many type III PC cards can you insert in a laptop","1","2","3","4","1");
        this.addQuestionRandom(q42);
        QuestionRandom q43 = new QuestionRandom("What is the first thing you could do to check for damage to a printer after receiving it?","Run MSD diagnostics","Attach it to a PC and print something","Check the cables","Unbox it and examine it for physical damage","Unbox it and examine it for physical damage");
        this.addQuestionRandom(q43);
        QuestionRandom q44 = new QuestionRandom("You have a system that periodically locks up. You have ruled out software, and now suspect that it is hardware. What should you do first that could help you narrow it down to the component at fault?","rotate the RAM","replace the RAM","replace the level 2 cache SIMM","disable the CPU cache in CMOS","disable the CPU cache in CMOS");
        this.addQuestionRandom(q44);
        QuestionRandom q45 = new QuestionRandom("What's the best way to protect your hard drive data?","regular backups","periodically defrag it","run chkdsk at least once a week","run scandisk at least once a week","regular backups");
        this.addQuestionRandom(q45);
        QuestionRandom q46 = new QuestionRandom("On a dot matrix printer, you should never lubricate which part?","carriage rails","printhead pins","paper advance bearings","carriage bearings","printhead pins");
        this.addQuestionRandom(q46);
        QuestionRandom q47 = new QuestionRandom("How many devices can be used on a single SCSI bus? Keep in mind that the SCSI host adapter counts as a device.","1","8","20","10","8");
        this.addQuestionRandom(q47);
        QuestionRandom q48 = new QuestionRandom("Match the device driver HIMEM.SYS to its operation.","Supports (ANSI) terminal emulation","Manages the use of extended memory","Uses expanded memory on a 80386 processor","Supports code page switching","Manages the use of extended memory");
        this.addQuestionRandom(q48);
        QuestionRandom q49 = new QuestionRandom("_____ help prevent power surges.","Surge suppressor","Spike protector","UPS system","High-grade multi-meter","Surge suppressor");
        this.addQuestionRandom(q49);
        QuestionRandom q50 = new QuestionRandom("The digital multimeter is set for DC, Ohm and 20k. You will read _____ while measuring a good 2 amp fuse.","0.00","0.02","0.20","2.00","0.00");
        this.addQuestionRandom(q50);
        QuestionRandom q51 = new QuestionRandom("An anti static strap uses a small _____ to make sure you do not become the least path of resistance to the ground?","capacitor","diode","transistor","resistor","resistor");
        this.addQuestionRandom(q51);
        QuestionRandom q52 = new QuestionRandom("If the memory slots have 30 pins then the chip is a?","DIMM","SIMM","SDRAM","All of the above","SIMM");
        this.addQuestionRandom(q52);
        QuestionRandom q53 = new QuestionRandom("Laser Jet printer speeds are measured in pages per minute (ppm) what do we use to measure dot-matrix printers?","lines per inch","lines per sheet","characters per inch","characters per second","characters per second");
        this.addQuestionRandom(q53);
        QuestionRandom q54 = new QuestionRandom("Which values are held in CMOS for the hard drive","size (heads, cylinders, sectors)","IRQ","Free space","Virus alert","size (heads, cylinders, sectors)");
        this.addQuestionRandom(q54);
        QuestionRandom q55 = new QuestionRandom("Which of the following would be a logical first step in troubleshooting a PC?","Check the computer CMOS","Define the circumstances of the problem","Call the vendor","Define what applications are being used","Define the circumstances of the problem");
        this.addQuestionRandom(q55);
        QuestionRandom q56 = new QuestionRandom("Which DOS driver is used to emulate expanded memory?","Himem.sys","EMM386.exe","Mem386.sys","Ramdrive.sys","EMM386.exe");
        this.addQuestionRandom(q56);
        QuestionRandom q57 = new QuestionRandom("For a Macintosh to print successfully, the System Folder must contain:","File sharing software","A printer enabler","The apple Garamond font set","A printer driver","A printer driver");
        this.addQuestionRandom(q57);
        QuestionRandom q58 = new QuestionRandom("Which component must be vacuumed or replaced during preventative maintenance on a laser printer?","Scanning mirror","Toner cartridge","Ozone filter","All of the above","Ozone filter");
        this.addQuestionRandom(q58);
        QuestionRandom q59 = new QuestionRandom("Which device uses a DMA channel?","Modem","Network Card","Sound Card","All of the above","Sound Card");
        this.addQuestionRandom(q59);
        QuestionRandom q60 = new QuestionRandom("When is the risk for electrostatic discharge the greatest?","Day time","High humidity","Low humidity","Night time","Low humidity");
        this.addQuestionRandom(q60);
        QuestionRandom q61 = new QuestionRandom("A modem could be attached to which port?","Parallel port","ASYNC port","Keyboard connector","Video port","Parallel port");
        this.addQuestionRandom(q61);
        QuestionRandom q62 = new QuestionRandom("What device prevents power interruptions, resulting in corrupted data?","Battery back-up unit","Surge protector","Multiple SIMMs strips","Data guard system","Battery back-up unit");
        this.addQuestionRandom(q62);
        QuestionRandom q63 = new QuestionRandom("SCSI must be terminated with?","Dip switch","Resistor","BNC","All of the above","Resistor");
        this.addQuestionRandom(q63);
        QuestionRandom q64 = new QuestionRandom("In a computer with an eide adapter, where should you connect an ATA CD-ROM drive?","on the floppy bus","on the primary IDE","on the secondary IDE","on the SCSI bus","on the secondary IDE");
        this.addQuestionRandom(q64);
        QuestionRandom q65 = new QuestionRandom("What is the highest binary number that can be referred to on a three position jumper block?","4","6","5","1","1");
        this.addQuestionRandom(q65);
        QuestionRandom q66 = new QuestionRandom("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed");
        this.addQuestionRandom(q66);
        QuestionRandom q67 = new QuestionRandom("IRQ6 is typically reserved for:","The floppy","The keyboard controller","LPT2","The modem","The floppy");
        this.addQuestionRandom(q67);
        QuestionRandom q68 = new QuestionRandom("Which would you do first when troubleshooting a faulty monitor?","Check its connections to the computer and power source","Use a meter to check the CRT and internal circuitry for continuity","Power down the monitor, then turn it on again to see if that corrects the problem","Power down the computer, then turn it on again to see if that corrects the problem","Check its connections to the computer and power source");
        this.addQuestionRandom(q68);
        QuestionRandom q69 = new QuestionRandom("To install a second IDE drive into a computer, you must:","Set the master-slave jumper to slave on the second drive","Use the IDE configuration software to set the new drive as slave","Verify that you define the new drive as D: in the CMOS setup","Verify that you attach the drive to the connector at the end of the ribbon cable","Set the master-slave jumper to slave on the second drive");
        this.addQuestionRandom(q69);
        QuestionRandom q70 = new QuestionRandom("Why does a successfully mapped network drive disappear every time you boot the computer?","The computer you are connected to has moved","You didn't click reconnect on log on","The map statement is not in the autoexec.bat file","The last drive was not set correctly","The map statement is not in the autoexec.bat file");
        this.addQuestionRandom(q70);
        QuestionRandom q71 = new QuestionRandom("What do you need to check serial and parallel port?","Port adapter","Logic probe","Loopback plug","All of the above","Loopback plug");
        this.addQuestionRandom(q71);
        QuestionRandom q72 = new QuestionRandom("You have a PC with no video* Which of the following is LEAST likely to be causing the problem?","defective RAM (bank zero)","defective microprocessor","crashed hard drive","loose video card","crashed hard drive");
        this.addQuestionRandom(q72);
        QuestionRandom q73 = new QuestionRandom("To test for AC ripple on a PC power supply, you would set the volt/ohm meter for:","DC voltage scale","AC voltage","OHM scale","Farad scale","AC voltage");
        this.addQuestionRandom(q73);
        QuestionRandom q74 = new QuestionRandom("You get a CMOS checksum error during bootup. What is most likely the cause?","power supply is bad","BIOS needs updating","CMOS battery is nearing end of life","hard drive types are incorrectly defined","CMOS battery is nearing end of life");
        this.addQuestionRandom(q74);
        QuestionRandom q75 = new QuestionRandom("On the 16-bit ISA bus, IRQ2 is elevated to which higher level interrupt?","9","11","13","15","9");
        this.addQuestionRandom(q75);
        QuestionRandom q76 = new QuestionRandom("After trying to unload a TSR, you get an error message saying that other TSRs were loaded after the one you tried to remove. Which of the following commands could you use to see the current load order?","MEM /P","MEMMAKER","MEM /C","SYS:","SYS:");
        this.addQuestionRandom(q76);
        QuestionRandom q77 = new QuestionRandom("What is a common language that computers use to talk with one another on a network","client","adapter","protocol","operating systems","protocol");
        this.addQuestionRandom(q77);
        QuestionRandom q78 = new QuestionRandom("Which DOS driver is used to emulate expanded memory?","Himem.sys","EMM386.exe","Mem386.sys","Ramdrive.sys","EMM386.exe");
        this.addQuestionRandom(q78);
        QuestionRandom q79 = new QuestionRandom("Which should you use for cleaning Mylar-protected LCD screens?","Ammonia window cleaner","Non-abrasive cleanser","Anti-static wipes","Alcohol-impregnated wipes","Non-abrasive cleanser");
        this.addQuestionRandom(q79);
        QuestionRandom q80 = new QuestionRandom("What could cause a fixed disk error?","No-CD installed","Bad RAM","Slow processor","Incorrect CMOS settings","Incorrect CMOS settings");
        this.addQuestionRandom(q80);
        QuestionRandom q81 = new QuestionRandom("ESD potential decreases with the use of:","De-ionizing fans","A wrist strap","Rubber gloves with matching cap","A static meter","A wrist strap");
        this.addQuestionRandom(q81);
        QuestionRandom q82 = new QuestionRandom("Which of the following FRUs would be considered both an input/output device?","Video board","SCSI host adapter","System board CPU","All of the above","SCSI host adapter");
        this.addQuestionRandom(q82);
        QuestionRandom q83 = new QuestionRandom("A COM port is a _____ port.","parallel","serial","static","multi","serial");
        this.addQuestionRandom(q83);
        QuestionRandom q84 = new QuestionRandom("Which device is on IRQ 6?","Keyboard","IDE","Floppy drive","Video card","Floppy drive");
        this.addQuestionRandom(q84);
        QuestionRandom q85 = new QuestionRandom("A system has two IDE hard drives that are each divided into primary and extended partitions, which drive letter is assigned to the primary partition of the second drive?","C","D","E","F","D");
        this.addQuestionRandom(q85);
        QuestionRandom q86 = new QuestionRandom("What is the most significant difference between the USB and IEEE1394 standards?","IEEE 1394 is faster","USB does not support USB","USB is plug and play","IEEE 1394 is hot swappable","IEEE 1394 is faster");
        this.addQuestionRandom(q86);
        QuestionRandom q87 = new QuestionRandom("When connecting two internal SCSI hard disks to a computer, where do you connect the second hard drive?","Any open SCSI port on the computer","A Serial port on the first host adapter","An open parallel port on the computer","An open SCSI port on the first hard drive","Any open SCSI port on the computer");
        this.addQuestionRandom(q87);
        QuestionRandom q88 = new QuestionRandom("When connecting a ribbon cable to a connector, how do you know which direction to plug it in?","The red line in the cable goes to the highest pin number","The colored line in the cable goes to pin #1","It does not matter","The blue or red line in the cable goes away from the power connector","The colored line in the cable goes to pin #1");
        this.addQuestionRandom(q88);
        QuestionRandom q89 = new QuestionRandom("What is the first step in diagnosing a completely dead computer at the client site that was working the day before.","Test the power supply","replace the CMOS battery","check the AC outlet","reseat the hard drive controller cable","check the AC outlet");
        this.addQuestionRandom(q89);
        QuestionRandom q90 = new QuestionRandom("What specification covers PC hard cards?","SCSI","ISA"," PCMCIA","MFM","PCMCIA");
        this.addQuestionRandom(q90);
        QuestionRandom q91 = new QuestionRandom("Which common bus specification provides the fastest data transfer rate?","VL bus","ISA","PCI","All of the above","PCI");
        this.addQuestionRandom(q91);
        QuestionRandom q92 = new QuestionRandom("Modems use transmission.","synchronous","asynchronous","timed interval","ata","asynchronous");
        this.addQuestionRandom(q92);
        QuestionRandom q93 = new QuestionRandom("A 6xx indicates a problem with the:","floppy drive","hard drive","keyboard","CD ROM","floppy drive");
        this.addQuestionRandom(q93);
        QuestionRandom q94 = new QuestionRandom("A sound card typically uses which IRQ?","6","5","15","1","5");
        this.addQuestionRandom(q94);
        QuestionRandom q95 = new QuestionRandom("During preventative maintenance on a dot matrix printer, do NOT lubricate:","Platen assembly","Print head pulley","Print head pins","Paper advance gear bushings","Print head pins");
        this.addQuestionRandom(q95);
        QuestionRandom q96 = new QuestionRandom("You see the message \"invalid media device\" after installing a new hard drive. What do you do next?","Format","Fdisk","Partition","Add the OS","Format");
        this.addQuestionRandom(q96);
        QuestionRandom q97 = new QuestionRandom("What is the modem hang up command?","ATHU","ATH","ATZ","ATX","ATH");
        this.addQuestionRandom(q97);
        QuestionRandom q98 = new QuestionRandom("What expansion types do most pll/plll motherboards support?","MCA, PCI","ISA, EISA","ISA, PCI, AGP","ISA, VESA, PCI","ISA, PCI, AGP");
        this.addQuestionRandom(q98);
        QuestionRandom q99 = new QuestionRandom("When installing an internal modem, all of the following IRQ's can be used except?","5","10","14","All of the above","14");
        this.addQuestionRandom(q99);
        QuestionRandom q100 = new QuestionRandom("An IRQ allow interface cards to:","Interrupt the CPU to request service","Pass data to the CPU to be processed","Pass data from one card to another","Pass data to the computers memory","Interrupt the CPU to request service");
        this.addQuestionRandom(q100);
        QuestionRandom q101 = new QuestionRandom("What is the decimal equivalent of the binary number 10111","21","23","39","42","23");
        this.addQuestionRandom(q101);
        QuestionRandom q102 = new QuestionRandom("In order to write on a floppy disk with your IBM PC, you must first","digitize it","format it","compile it","hardware it","format it");
        this.addQuestionRandom(q102);
        QuestionRandom q103 = new QuestionRandom("What is the term for a temporary storage area tha componsates for differences in data rate and data flow between devices ?","Buffer","Bus","Channel","Modem","Buffer");
        this.addQuestionRandom(q103);
        QuestionRandom q104 = new QuestionRandom("How many colour dots make up one colour pixel on a screen ?","256","16","3","1","3");
        this.addQuestionRandom(q104);
        QuestionRandom q105 = new QuestionRandom("One of the things that separates a TERMINAL from a PC is that the terminal does not have a what ?","Keyboard","Monitor","Power Cord","CPU","CPU");
        this.addQuestionRandom(q105);
        QuestionRandom q106 = new QuestionRandom("Data is stored on diskette in what form ?","Ink","Laser Bubble","Magnetism","Circuits","Magnetism");
        this.addQuestionRandom(q106);
        QuestionRandom q107 = new QuestionRandom("The smallest visual element on a video monitor is called what ?","Character","Pixel","Byte","Kwerk","Pixel");
        this.addQuestionRandom(q107);
        QuestionRandom q108 = new QuestionRandom("The type of data storage that is considered to be volatile is ?","R-O-M","R-A-M","TAPE","DISK","R-A-M");
        this.addQuestionRandom(q108);
        QuestionRandom q109 = new QuestionRandom("What natural element is the primary ingredient in computer chips ?","Silicon","Carbon","Iron","Uranium","Silicon");
        this.addQuestionRandom(q109);
        QuestionRandom q110 = new QuestionRandom("Where do you find a write protect notch ?","On a computer chip","On a punched card","In a read only memory","On a floppy disk","On a floppy disk");
        this.addQuestionRandom(q110);
        QuestionRandom q111 = new QuestionRandom("Which of the following languages is more suited to a structured program?","PL/1","FORTRAN","BASIC","PASCAL","PASCAL");
        this.addQuestionRandom(q111);
        QuestionRandom q112 = new QuestionRandom("A computer assisted method for the recording and analyzing of existing or hypothetical systems is","Data transmission","Data flow","Data capture","Data processing","Data flow");
        this.addQuestionRandom(q112);
        QuestionRandom q113 = new QuestionRandom("The brain of any computer system is","ALU","CPU","Memory","Control unit","CPU");
        this.addQuestionRandom(q113);
        QuestionRandom q114 = new QuestionRandom("What difference does the 5th generation computer have from other generation computers?","Technological advancement","Scientific code","Object Oriented Programming","All of the above","Technological advancement");
        this.addQuestionRandom(q114);
        QuestionRandom q115 = new QuestionRandom("Which of the following computer language is used for artificial intelligence?","FORTRAN","PROLOG","C","COBOL","PROLOG");
        this.addQuestionRandom(q115);
        QuestionRandom q116 = new QuestionRandom("The tracks on a disk which can be accessed without repositioning the R/W heads is","Surface","Cylinder","Cluster","All of the above","Cylinder");
        this.addQuestionRandom(q116);
        QuestionRandom q117 = new QuestionRandom("Which of the following is the 1's complement of 10?","01","110","11","10","01");
        this.addQuestionRandom(q117);
        QuestionRandom q118 = new QuestionRandom("A section of code to which control is transferred when a processor is interrupted is known as","M","SVC","IP","MDR","M");
        this.addQuestionRandom(q118);
        QuestionRandom q119 = new QuestionRandom("Which part interprets program instructions and initiate control operations.","Input","Storage unit","Logic unit","Control unit","Control unit");
        this.addQuestionRandom(q119);
        QuestionRandom q120 = new QuestionRandom("The binary system uses powers of","2","10","8","16","2");
        this.addQuestionRandom(q120);
        QuestionRandom q121 = new QuestionRandom("A computer program that converts assembly language to machine language is","Compiler","Interpreter","Assembler","Comparator","Assembler");
        this.addQuestionRandom(q121);
        QuestionRandom q122 = new QuestionRandom("The time required for the fetching and execution of one simple machine instruction is","Delay time","CPU cycle","Real time","Seek time","CPU cycle");
        this.addQuestionRandom(q122);
        QuestionRandom q123 = new QuestionRandom("The time for which a piece of equipment operates is called","Seek time","Effective time","Access time","Real time","Effective time");
        this.addQuestionRandom(q123);
        QuestionRandom q124 = new QuestionRandom("Binary numbers need more places for counting because","They are always big numbers","Any no. of 0's can be added in front of them","Binary base is small","0's and l's have to be properly spaced apart","Binary base is small");
        this.addQuestionRandom(q124);
        QuestionRandom q125 = new QuestionRandom("Which access method is used for obtaining a record from a cassette tape?","Direct","Sequential","Random","All of the above","Sequential");
        this.addQuestionRandom(q125);
        QuestionRandom q126 = new QuestionRandom("Any type of storage that is used for holding information between steps in its processing is","CPU","Primary storage","Intermediate storage","Internal storage","Intermediate storage");
        this.addQuestionRandom(q126);
        QuestionRandom q127 = new QuestionRandom("A name applied by Intel corp. to high speed MOS technology is called","HDLC","LAP","HMOS","SDLC","HMOS");
        this.addQuestionRandom(q127);
        QuestionRandom q128 = new QuestionRandom("A program component that allows structuring of a program in an unusual way is known as","Correlation","Coroutine","Diagonalization","Quene","Coroutine");
        this.addQuestionRandom(q128);
        QuestionRandom q129 = new QuestionRandom("The radian of a number system","Is variable","Has nothing to do with digit position value","Equals the number of its distinct counting digits","Is always an even number","Equals the number of its distinct counting digits");
        this.addQuestionRandom(q129);
        QuestionRandom q130 = new QuestionRandom("The section of the CPU that selects, interprets and sees to the execution of program instructions","Memory","Register unit","Control unit","ALU","Control unit");
        this.addQuestionRandom(q130);
        QuestionRandom q131 = new QuestionRandom("Which type of system puts the user into direct conversation with the computer through a keyboard?","Real time processing","Interactive computer","Batch processing","Time sharing","Interactive computer");
        this.addQuestionRandom(q131);
        QuestionRandom q132 = new QuestionRandom("The term referring to evacuating the content of some part of the machine is known as","Dump","Enhancement","Down","Compiler","Dump");
        this.addQuestionRandom(q132);
        QuestionRandom q133 = new QuestionRandom("A single packet on a data link is known as","Path","Frame","Block","Group","Frame");
        this.addQuestionRandom(q133);
        QuestionRandom q134 = new QuestionRandom("The process of communicating with a file from a terminal is","Interactive","Interrogation","Heuristic","All of the above","Interrogation");
        this.addQuestionRandom(q134);
        QuestionRandom q135 = new QuestionRandom("A common boundary between two systems is called","Interdiction","Interface","Surface","None of the above","Interface");
        this.addQuestionRandom(q135);
        QuestionRandom q136 = new QuestionRandom("The examination and changing of single bits or small groups of his within a word is called","Bit","Byte","Bit manipulation","Bit slice","Bit manipulation");
        this.addQuestionRandom(q136);
        QuestionRandom q137 = new QuestionRandom("Which computer has been designed to be as compact as possible?","Mini","Super computer","Micro computer","Mainframe","Micro computer");
        this.addQuestionRandom(q137);
        QuestionRandom q138 = new QuestionRandom("Which method is used to connect a remote computer?","Device","Dialup","Diagnostic","Logic circuit","Dialup");
        this.addQuestionRandom(q138);
        QuestionRandom q139 = new QuestionRandom("How many bit code is used by Murray code for TELEPRINTER machines.","4","5","9","25","5");
        this.addQuestionRandom(q139);
        QuestionRandom q140 = new QuestionRandom("The symbols used in an assembly language are","Codes","Mnemonics","Assembler","All of the above","Mnemonics");
        this.addQuestionRandom(q140);
        QuestionRandom q141 = new QuestionRandom("The 2's complement of a binary no. is obtained by adding.....to its 1's complement.","0","1","10","12","1");
        this.addQuestionRandom(q141);
        QuestionRandom q142 = new QuestionRandom("A systems programming language for microcomputers in the Intel family is","PL/C","PL/CT","PL/M","PLA","PL/M");
        this.addQuestionRandom(q142);
        QuestionRandom q143 = new QuestionRandom("A datum that indicates some important state in the content of input or output is","Sequence","Sentinel","SIO","Sibling","Sentinel");
        this.addQuestionRandom(q143);
        QuestionRandom q144 = new QuestionRandom("Which is a non-standard version of a computing language?","PROLOG","APL","Army","PL/1","Army");
        this.addQuestionRandom(q144);
        QuestionRandom q145 = new QuestionRandom("Which of the following is still useful for adding numbers?","EDSAC","ENIAC","Abacus","UNIVAC","Abacus");
        this.addQuestionRandom(q145);
        QuestionRandom q146 = new QuestionRandom("The average time necessary for the correct sector of a disk to arrive at the read write head is _____","Down time","Seek time","Rotational delay","Access time","Rotational delay");
        this.addQuestionRandom(q146);
        QuestionRandom q147 = new QuestionRandom("A number that is used to control the form of another number is known as","Map","Mask","Mamtossa","Marker","Mask");
        this.addQuestionRandom(q147);
        QuestionRandom q148 = new QuestionRandom("A general purpose single-user microcomputer designed to be operated by one person at a time is","Special-purpose computer","KIPS","M","PC","PC");
        this.addQuestionRandom(q148);
        QuestionRandom q149 = new QuestionRandom("ASCII stands for","American standard code for information interchange","All purpose scientific code for information interchange","American security code for information interchange","American Scientific code for information interchange","American standard code for information interchange");
        this.addQuestionRandom(q149);
        QuestionRandom q150 = new QuestionRandom("Which device of computer operation dispenses with the use of the keyboard?","Joystick","Light pen","Mouse","Touch","Mouse");
        this.addQuestionRandom(q150);
        QuestionRandom q151 = new QuestionRandom("The microcomputer, Intel MCS-80 is based on the widely used Intel","8080 microprocessor","8085 microprocessor","8086 microprocessor","8082 microprocessor","8080 microprocessor");
        this.addQuestionRandom(q151);
        QuestionRandom q152 = new QuestionRandom("Which is a machine-oriented high-level language for the GEC 4080 series machines.","LOGO","SNOBOL","Babbage","ALGOL","Babbage");
        this.addQuestionRandom(q152);
        QuestionRandom q153 = new QuestionRandom("A program that is employed in the development, repair or enhancement of other programs is known as","System software","Software tool","Applications program","Utility program","Software tool");
        this.addQuestionRandom(q153);
        QuestionRandom q154 = new QuestionRandom("Any storage device added to a computer beyond the immediately usable main storage is known as","Floppy disk","Hard disk","Backing store","Punched card","Backing store");
        this.addQuestionRandom(q154);
        QuestionRandom q155 = new QuestionRandom("Which output device is used for translating information from a computer into pictorial form on paper.","Mouse","Plotter","Touch panel","Card punch","Plotter");
        this.addQuestionRandom(q155);
        QuestionRandom q156 = new QuestionRandom("The list of coded instructions is called","Computer program","Algorithm","Flowchart","Utility programs","Computer program");
        this.addQuestionRandom(q156);
        QuestionRandom q157 = new QuestionRandom("A technique used by codes to convert an analog signal into a digital bit stream is known as","Pulse code modulation","Pulse stretcher","Query processing","Queue management","Pulse code modulation");
        this.addQuestionRandom(q157);
        QuestionRandom q158 = new QuestionRandom("An optical input device that interprets pencil marks on paper media is","O.M.R","Punch card reader","Optical scanners","Magnetic tape","O.M.R");
        this.addQuestionRandom(q158);
        QuestionRandom q159 = new QuestionRandom("Most important advantage of an IC is its","Easy replacement in case of circuit failure","Extremely high reliability","Reduced cost","Low power consumption","Extremely high reliability");
        this.addQuestionRandom(q159);
        QuestionRandom q160 = new QuestionRandom("Data division is the third division of a _____ program.","COBOL","BASIC","PASCAL","FORTH","COBOL");
        this.addQuestionRandom(q160);
        QuestionRandom q161 = new QuestionRandom("Which language was devised by Dr. Seymour Aubrey Papert?","APL","COBOL","LOGO","FORTRAN","LOGO");
        this.addQuestionRandom(q161);
        QuestionRandom q162 = new QuestionRandom("A program that converts computer data into some code system other than the normal one is known as","Encoder","Simulation","Emulator","Coding","Encoder");
        this.addQuestionRandom(q162);
        QuestionRandom q163 = new QuestionRandom("A device designed to read information encoded into a small plastic card is","Magnetic tape","Badge reader","Tape puncher","Card puncher","Badge reader");
        this.addQuestionRandom(q163);
        QuestionRandom q164 = new QuestionRandom("A hybrid computer uses a _____ to convert digital signals from a computer into analog signals.","Modulator","Demodulator","Modem","Decoder","Modem");
        this.addQuestionRandom(q164);
        QuestionRandom q165 = new QuestionRandom("A group of magnetic tapes, videos or terminals usually under the control of one master is","Cylinder","Cluster","Surface","Track","Cluster");
        this.addQuestionRandom(q165);
        QuestionRandom q166 = new QuestionRandom("Any device that performs signal conversion is","Modulator","Modem","Keyboard","Plotter","Modulator");
        this.addQuestionRandom(q166);
        QuestionRandom q167 = new QuestionRandom("Codes consisting of light and dark marks which may be optically read is known as","Mnemonics","Bar code","Decoder","All of the above","Bar code");
        this.addQuestionRandom(q167);
        QuestionRandom q168 = new QuestionRandom("A type of channel used to connect a central processor and peripherals which uses multipling is known as","Modem","Network","Multiplexer","All of the above","Multiplexer");
        this.addQuestionRandom(q168);
        QuestionRandom q169 = new QuestionRandom("The first generation of computers available was based on the bit micro processors.","4","8","16","64","8");
        this.addQuestionRandom(q169);
        QuestionRandom q170 = new QuestionRandom("The complete picture of data stored in database is known as","Record","Schema","System flowchart","DBMS","Schema");
        this.addQuestionRandom(q170);
        QuestionRandom q171 = new QuestionRandom("Which of the following is intended to be used in all applications runs on mainframe computers.","LOGO","APL","PL/1","OCCAM","PL/1");
        this.addQuestionRandom(q171);
        QuestionRandom q172 = new QuestionRandom("A language which is close to that used within the computer is","High-level language","Assembly language","Low-level language","All of the above","Low-level language");
        this.addQuestionRandom(q172);
        QuestionRandom q173 = new QuestionRandom("Which is a unit representing the no bits of discrete.","Baud","Byte","Bit","All of the above","Baud");
        this.addQuestionRandom(q173);
        QuestionRandom q174 = new QuestionRandom("The device that can both feed data into and accept data from a computer is","ALU","CPU","Input-Output device","All of the above","Input-Output device");
        this.addQuestionRandom(q174);
        QuestionRandom q175 = new QuestionRandom("The personnel who deals with the computer & its management put together are called","Software","Humanware","Firmware","Hardware","Humanware");
        this.addQuestionRandom(q175);
        QuestionRandom q176 = new QuestionRandom("A modern digital computer has","Extremely high speed","Large memory","Almost unlimited array","All of the above","All of the above");
        this.addQuestionRandom(q176);
        QuestionRandom q177 = new QuestionRandom("Which of the following can store information in the form of microscopic pits on metal disks.","Laser disks","Tape cassettes","RAM cartridge","Punched cards","Laser disks");
        this.addQuestionRandom(q177);
        QuestionRandom q178 = new QuestionRandom("A device for converting handwritten impressions into coded characters & positional coordinates for input to a computer is","Touch panel","Mouse","Wand","Writing tablet","Writing tablet");
        this.addQuestionRandom(q178);
        QuestionRandom q179 = new QuestionRandom("A storage system for small amounts of data is","Magnetic card","Magnetic tape","Punched card","Optical mark reader","Magnetic card");
        this.addQuestionRandom(q179);
        QuestionRandom q180 = new QuestionRandom("Which is another name for functional language?","Machine","Application language","Low-level language","High-level language","Application language");
        this.addQuestionRandom(q180);
        QuestionRandom q181 = new QuestionRandom("Compilers and interpreters are themselves","High-level language","Codes","Programs","Mnemonics","Programs");
        this.addQuestionRandom(q181);
        QuestionRandom q182 = new QuestionRandom("A compiler means","A person who compiles source programs","The same thing as a programmer","Keypunch operator","A program which translates source program into object program","A program which translates source program into object program");
        this.addQuestionRandom(q182);
        QuestionRandom q183 = new QuestionRandom("A pen shaped device which can sense light, and is used to point at spots on a video screen.","Mouse","Light pen","Joystick","Plotter","Light pen");
        this.addQuestionRandom(q183);
        QuestionRandom q184 = new QuestionRandom("A notation used to express clearly on algorithm is known as","Algorithmic language","Assembly language","Machine language","High level language","Algorithmic language");
        this.addQuestionRandom(q184);
        QuestionRandom q185 = new QuestionRandom("Compression of digital data for efficient storage is","Buffer","CPU","Packing","Field","Packing");
        this.addQuestionRandom(q185);
        QuestionRandom q186 = new QuestionRandom("An operating system intended for use on microprocessor based systems that support a single user is","PC-DOS","MS-DOS","UNIX","CP/M","CP/M");
        this.addQuestionRandom(q186);
        QuestionRandom q187 = new QuestionRandom("Which programming language is based on Algol 60.","PILOT","SNOBOL","ADA","SIMULA","SIMULA");
        this.addQuestionRandom(q187);
        QuestionRandom q188 = new QuestionRandom("Computer memory consists of","RAM","ROM","PROM","All of the above","All of the above");
        this.addQuestionRandom(q188);
        QuestionRandom q189 = new QuestionRandom("A path by which communication is achieved between a central processor and other devices is called","Audit trail","Network","Bus","Channel","Bus");
        this.addQuestionRandom(q189);
        QuestionRandom q190 = new QuestionRandom("A stand-alone system which produces one page of printed output at a time is","Page printer","Line printer","Laser printer","Dot matrix printer","Page printer");
        this.addQuestionRandom(q190);
        QuestionRandom q191 = new QuestionRandom("A memory that does not change its contents without external causes is known as","Dynamic memory","Static memory","RAM","EEPROM","Static memory");
        this.addQuestionRandom(q191);
        QuestionRandom q192 = new QuestionRandom("The report card and merit list forms the","Output data","Data processing","Central Processing","Input data","Output data");
        this.addQuestionRandom(q192);
        QuestionRandom q193 = new QuestionRandom("A number which is stored and processed but not in the standard exponential form is called","Floating point number","Fixed point number","Octal number","Decimal number","Fixed point number");
        this.addQuestionRandom(q193);
        QuestionRandom q194 = new QuestionRandom("A memory that holds micro programs is","Core memory","ROM","RAM","Control memory","ROM");
        this.addQuestionRandom(q194);
        QuestionRandom q195 = new QuestionRandom("A device invented by Dr. Bobeck in 1966, for mass storage of data is","Punched paper tape","Magnetic bubble storage","Magnetic tape","Magnetic disk","Magnetic bubble storage");
        this.addQuestionRandom(q195);
        QuestionRandom q196 = new QuestionRandom("The organization and interconnection of the various components of a computer system is","Architecture","Networks","Graphics","Designing","Architecture");
        this.addQuestionRandom(q196);
        QuestionRandom q197 = new QuestionRandom("Which of the following is the coding of data so that is can't be easily understood if intercepted.","Barcode","Decoder","Encryption","Mnemonics","Encryption");
        this.addQuestionRandom(q197);
        QuestionRandom q198 = new QuestionRandom("RAM is used as a short memory because it is","Volatile","Has small capacity","Is very expensive","Is programmable","Volatile");
        this.addQuestionRandom(q198);
        QuestionRandom q199 = new QuestionRandom("A modern electronic computer is a machine that is meant for","Doing quick mathematical calculations","Input storage, manipulation of outputting of data","Electronic data processing","Performing repetitive tasks accurately","Input storage, manipulation of outputting of data");
        this.addQuestionRandom(q199);
        QuestionRandom q200 = new QuestionRandom("Which is a device that changes information into digital form?","Modem","Digitizer","Mouse","Light pen","Digitizer");
        this.addQuestionRandom(q200);
        QuestionRandom q201 = new QuestionRandom("Which backup method is quickest and requires the least amount of backup storage space ?","Daily","Normal","Differential","Incremental","Incremental");
        this.addQuestionRandom(q201);
        QuestionRandom q202 = new QuestionRandom("Scan disk checks and fixes ____.","Tape drives","Hard drives","CD-ROM drives","DVD-ROM drives","Hard drives");
        this.addQuestionRandom(q202);
        QuestionRandom q203 = new QuestionRandom("Where is the DIR command located ?","C:|WINDOWS","COMMAND.COM","C:|WINDOWS|SYSTEM","C:|WINDOWS|COMMAND","COMMAND.COM");
        this.addQuestionRandom(q203);
        QuestionRandom q204 = new QuestionRandom("Which command allows you to view or edit configuration files ?","SYSEDIT","REGEDIT","CFGEDIT","AUTOEDIT","SYSEDIT");
        this.addQuestionRandom(q204);
        QuestionRandom q205 = new QuestionRandom("Which utility is the best for editing Windows 95 registry ?","Edit","Regedit","Reged32","Device Manager","Regedit");
        this.addQuestionRandom(q205);
        QuestionRandom q206 = new QuestionRandom("Which files determines the multiboot configuration of Windows 9x ?","IO.SYS","SYSTEM.INI","MSDOS.SYS","CONFIG.SYS","MSDOS.SYS");
        this.addQuestionRandom(q206);
        QuestionRandom q207 = new QuestionRandom("Which key strokes switch a user between simultaneously running applications in windows ?","FN+TAB","ALT+TAB","CTRL+TAB","SHIFT+TAB","ALT+TAB");
        this.addQuestionRandom(q207);
        QuestionRandom q208 = new QuestionRandom("WHat type of file is the Windows 9x registry ?","Flat text file","Relational database","Hierarchical databse","Spread sheet template","Hierarchical databse");
        this.addQuestionRandom(q208);
        QuestionRandom q209 = new QuestionRandom("Wich of these statements would be found in the autoexec.bat file ?","FILES=40","PATH=C:\\;","DOS=HIGH,UMB","DEVICE=HIMEM.SYS","PATH=C:\\;");
        this.addQuestionRandom(q209);
        QuestionRandom q210 = new QuestionRandom("What is the proper command to install the Windows 2000 Recovery Console as a start up option if the CD Rom is Drive E ?","E:|i386\\SETUP.EXE\\CONSOLE","E:|i386\\CONSOLE.EXE\\INSTALL","E:|i386\\WINNT32.EXE\\CMDCONS","E:|i386\\WIN2000.EXE\\RECOVERY","E:|i386\\WINNT32.EXE\\CMDCONS");
        this.addQuestionRandom(q210);
        QuestionRandom q211 = new QuestionRandom("The part of machine level instruction, which tells the central processor what has to be done, is","Operation code","Address","Locator","Flip-Flop","Operation code");
        this.addQuestionRandom(q211);
        QuestionRandom q212 = new QuestionRandom("Which of the following refers to the associative memory?","the address of the data is generated by the CPU","the address of the data is supplied by the users","there is no need for an address i.e. the data is used as an address","the data are accessed sequentially","there is no need for an address i.e. the data is used as an address");
        this.addQuestionRandom(q212);
        QuestionRandom q213 = new QuestionRandom("To avoid the race condition, the number of processes that may be simultaneously inside their critical section is","8","16","1","0","1");
        this.addQuestionRandom(q213);
        QuestionRandom q214 = new QuestionRandom("A system program that combines the separately compiled modules of a program into a form suitable for execution","assembler","assembler","cross compiler","load and go","linking loader");
        this.addQuestionRandom(q214);
        QuestionRandom q215 = new QuestionRandom("Process is","program in High level language kept on disk","contents of main memory","a program in execution","a job in secondary memory","a program in execution");
        this.addQuestionRandom(q215);
        QuestionRandom q216 = new QuestionRandom("Addressing structure","defines the fundamental method of determining effective operand addresses","are variations in the use of fundamental addressing structures, or some associated actions which are related to addressing","performs indicated operations on two fast registers of the machine and leave the result in one of the registers","all of the above","defines the fundamental method of determining effective operand addresses");
        this.addQuestionRandom(q216);
        QuestionRandom q217 = new QuestionRandom("all of the above","is a hardware memory device which denotes the location of the current instruction being executed","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory","contains the address of the memory location that is to be read from or stored into","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"");
        this.addQuestionRandom(q217);
        QuestionRandom q218 = new QuestionRandom("The strategy of allowing processes that are logically runnable to be temporarily suspended is called","preemptive scheduling","non preemptive scheduling","shortest job first","shortest job first","preemptive scheduling");
        this.addQuestionRandom(q218);
        QuestionRandom q219 = new QuestionRandom("The LRU algorithm","pages out pages that have been used recently","pages out pages that have not been used recently","pages out pages that have been least used recently","pages out the first page in a given area","pages out pages that have been least used recently");
        this.addQuestionRandom(q219);
        QuestionRandom q220 = new QuestionRandom("Which of the following systems software does the job of merging the records from two files into one?","Security software","Utility program","Networking software","Documentation system","Utility program");
        this.addQuestionRandom(q220);
        QuestionRandom q221 = new QuestionRandom("Fork is","the dispatching of a task","the creation of a new job","the creation of a new process","increasing the priority of a task","the creation of a new process");
        this.addQuestionRandom(q221);
        QuestionRandom q222= new QuestionRandom("Thrashing","is a natural consequence of virtual memory systems","can always be avoided by swapping","always occurs on large computers","can be caused by poor paging algorithms","can be caused by poor paging algorithms");
        this.addQuestionRandom(q222);
        QuestionRandom q223 = new QuestionRandom("Supervisor state is","never used","entered by programs when they enter the processor","required to perform any I/O","only allowed to the operating system","only allowed to the operating system");
        this.addQuestionRandom(q223);
        QuestionRandom q224 = new QuestionRandom("Which of the following instruction steps, would be written within the diamond-shaped box, of a flowchart?","S = B - C","IS A<10","PRINT A","DATA X,4Z","IS A<10");
        this.addQuestionRandom(q224);
        QuestionRandom q225 = new QuestionRandom("Which of the following statements is false?","the technique of storage compaction involves moving all occupied areas of storage to one end or other of main storage","compaction does not involve relocation of programs","compaction is also know as garbage collection","the system must stop everything while it performs the compaction","compaction does not involve relocation of programs");
        this.addQuestionRandom(q225);
        QuestionRandom q226 = new QuestionRandom("Interprocess communication","is required for all processes","is usually done via disk drives","is never necessary","allows processes to synchronize activity","allows processes to synchronize activity");
        this.addQuestionRandom(q226);
        QuestionRandom q227 = new QuestionRandom("Which of the following functions is(are) performed by the loader","allocate space in memory for the programs and resolve symbolic references between object decks","adjust all address dependent locations, such as address constants, to correspond to the allocated space","physically place the machine instructions and data into memory","All of the above","All of the above");
        this.addQuestionRandom(q227);
        QuestionRandom q228 = new QuestionRandom("User-Friendly Systems are:","required for object-oriented programming","easy to develop","common among traditional mainframe operating systems","becoming more common","becoming more common");
        this.addQuestionRandom(q228);
        QuestionRandom q229 = new QuestionRandom("Which of the following addressing modes, facilitates access to an operand whose location is defined relative to the beginning of the data structure in which it appears?","ascending","sorting","index","indirect","index");
        this.addQuestionRandom(q229);
        QuestionRandom q230 = new QuestionRandom("While running DOS on a PC, which command would be used to duplicate the entire diskette?","COPY","DISKCOPY","CHKDSK","TYPE","DISKCOPY");
        this.addQuestionRandom(q230);
        QuestionRandom q231 = new QuestionRandom("Memory","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time-slicing of the CPU's time to allow quick response to each user.","is the device where information is stored");
        this.addQuestionRandom(q231);
        QuestionRandom q232 = new QuestionRandom("Which of the following rules out the use of GO TO?","Flowchart","HIPO-DIAGRAMS","Nassi-Shneiderman diagram","All of the above","Nassi-Shneiderman diagram");
        this.addQuestionRandom(q232);
        QuestionRandom q233 = new QuestionRandom("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader");
        this.addQuestionRandom(q233);
        QuestionRandom q234 = new QuestionRandom("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader");
        this.addQuestionRandom(q234);
        QuestionRandom q235 = new QuestionRandom("Which of the following are loaded into main memory when the computer is booted?","internal command instructions","external command instructions","utility programs","word processing instructions","internal command instructions");
        this.addQuestionRandom(q235);
        QuestionRandom q236 = new QuestionRandom("The FIFO algorithm","executes first the job that last entered the queue","executes first the job that first entered the queue","execute first the job that has been in the queue the longest","executes first the job with the least processor needs","executes first the job that first entered the queue");
        this.addQuestionRandom(q236);
        QuestionRandom q237 = new QuestionRandom("What is the name given to the organized collection of software that controls the overall operation of a computer?","Working system","Peripheral system","Operating system","Controlling system","Operating system");
        this.addQuestionRandom(q237);
        QuestionRandom q238 = new QuestionRandom("The principle of locality of reference justifies the use of","reenterable","non reusable","virtual memory","cache memory","cache memory");
        this.addQuestionRandom(q238);
        QuestionRandom q239 = new QuestionRandom("The register or main memory location which contains the effective address of the operand is known as","pointer","indexed register","special location","scratch pad","pointer");
        this.addQuestionRandom(q239);
        QuestionRandom q240 = new QuestionRandom("Assembly code data base is associated with","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.","a permanent table of decision rules in the form of patterns for matching with the uniform symbol table to discover syntactic structure.","consists of a full or partial list or the token's as they appear in the program. Created by Lexical analysis and used for syntax analysis and interpretation.","a permanent table which lists all key words and special symbols of the language in symbolic form.","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.");
        this.addQuestionRandom(q240);
        QuestionRandom q241 = new QuestionRandom("Thrashing can be avoided if","the pages, belonging to the working set of the programs, are in main memory","the speed of CPU is increased","the speed of I/O processor is increased","all of the above","the pages, belonging to the working set of the programs, are in main memory");
        this.addQuestionRandom(q241);
        QuestionRandom q242 = new QuestionRandom("In analyzing the compilation of PL/I program, the term \"Lexical analysis\" is associated with","recognition of basic syntactic constructs through reductions.","recognition of basic elements and creation of uniform symbols","creation of more optional matrix.","use of macro processor to produce more optimal assembly code","recognition of basic elements and creation of uniform symbols");
        this.addQuestionRandom(q242);
        QuestionRandom q243 = new QuestionRandom("Resolution of externally defined symbols is performed by","Linker","Loader","Compiler","Assembler","Linker");
        this.addQuestionRandom(q243);
        QuestionRandom q244 = new QuestionRandom("System generation:","is always quite simple","is always very difficult","varies in difficulty between systems","requires extensive tools to be understandable","varies in difficulty between systems");
        this.addQuestionRandom(q244);
        QuestionRandom q245 = new QuestionRandom("The Memory Address Register","is a hardware memory device which denotes the location of the current instruction being executed.","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory.","contains the address of the memory location that is to be read from or stored into.","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\".","contains the address of the memory location that is to be read from or stored into.");
        this.addQuestionRandom(q245);
        QuestionRandom q246 = new QuestionRandom("In virtual memory systems, Dynamic address translation","is the hardware necessary to implement paging","stores pages at a specific location on disk","is useless when swapping is used","is part of the operating system paging algorithm","is the hardware necessary to implement paging");
        this.addQuestionRandom(q246);
        QuestionRandom q247 = new QuestionRandom("Fragmentation of the file system","occurs only if the file system is used improperly","can always be prevented","can be temporarily removed by compaction","is a characteristic of all file systems","can be temporarily removed by compaction");
        this.addQuestionRandom(q247);
        QuestionRandom q248 = new QuestionRandom("A non-relocatable program is one which","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.","consists of a program and relevant information for its relocation.","can itself performs the relocation of its address-sensitive portions.","all of the above","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.");
        this.addQuestionRandom(q248);
        QuestionRandom q249 = new QuestionRandom("Which of the following are(is) Language Processor(s)","assembles","compilers","interpreters","All of the above","All of the above");
        this.addQuestionRandom(q249);
        QuestionRandom q250 = new QuestionRandom("In which addressing mode the effective address of the operand is the contents of a register specified in the instruction and after accessing the operand, the contents of this register is incremented to point to the next item in the list?","index addressing","indirect addressing","auto increment","auto decrement","auto increment");
        this.addQuestionRandom(q250);
        QuestionRandom q251 = new QuestionRandom("The memory allocation scheme subject to \"external\" fragmentation is","segmentation","swapping","pure demand paging","multiple contiguous fixed partitions","segmentation");
        this.addQuestionRandom(q251);
        QuestionRandom q252 = new QuestionRandom("While working with MS-DOS, which command will you use to transfer a specific file from one disk to another?","DISKCOPY","COPY","RENAME","FORMAT","COPY");
        this.addQuestionRandom(q252);
        QuestionRandom q253 = new QuestionRandom("What is the name of the operating system for the laptop computer called MacLite?","Windows","DOS","MS-DOS","OZ","OZ");
        this.addQuestionRandom(q253);
        QuestionRandom q254 = new QuestionRandom("In which addressing mode the contents of a register specified in the instruction are first decremented, and then these contents are used as the effective address of the operands?","index addressing","indirect addressing","auto increment","auto decrement","auto decrement");
        this.addQuestionRandom(q254);
        QuestionRandom q255 = new QuestionRandom("What is the name given to the values that are automatically provided by software to reduce keystrokes and improve a computer user's productivity?","Defined values","Fixed values","Default values","Special values","Default values");
        this.addQuestionRandom(q255);
        QuestionRandom q256 = new QuestionRandom("Page stealing","is a sign of an efficient system","is taking page frames from other working sets","should be the tuning goal","is taking larger disk spaces for pages paged out","is taking page frames from other working sets");
        this.addQuestionRandom(q256);
        QuestionRandom q257 = new QuestionRandom("In MS-DOS 5.0, which is the number that acts as a code to uniquely identify the software product?","MS","DOS","MS DOS","5.0","5.0");
        this.addQuestionRandom(q257);
        QuestionRandom q258 = new QuestionRandom("Bug means","A logical error in a program","A difficult syntax error in a program","Documenting programs using an efficient documentation tool","All of the above","A logical error in a program");
        this.addQuestionRandom(q258);
        QuestionRandom q259 = new QuestionRandom("Memory management is :","not used in modern operating system","replaced with virtual memory on current systems","not used on multiprogramming systems","critical for even the simplest operating systems","critical for even the simplest operating systems");
        this.addQuestionRandom(q259);
        QuestionRandom q260 = new QuestionRandom("The initial value of the semaphore that allows only one of the many processes to enter their critical sections, is","8","1","16","0","1");
        this.addQuestionRandom(q260);
        QuestionRandom q261 = new QuestionRandom("The Register - to - Register (RR) instructions","have both their operands in the main store.","which perform an operation on a register operand and an operand which is located in the main store, generally leaving the result in the register, except in the case of store operation when it is also written into the specified storage location.","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.","all of the above","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.");
        this.addQuestionRandom(q261);
        QuestionRandom q262 = new QuestionRandom("A page fault","is an error is a specific page","occurs when a program accesses a page of memory","is an access to a page not currently in memory","is a reference to a page belonging to another program","is an access to a page not currently in memory");
        this.addQuestionRandom(q262);
        QuestionRandom q263 = new QuestionRandom("An algorithm is best described as","A computer langage","A step by step procedure for solving a problem","A branch of mathematics","All of the above","A step by step procedure for solving a problem");
        this.addQuestionRandom(q263);
        QuestionRandom q264 = new QuestionRandom("The process of transferring data intended for a peripheral device into a disk (or intermediate store) so that it can be transferred to peripheral at a more convenient time or in bulk, is known as","multiprogramming","spooling","caching","virtual programming","spooling");
        this.addQuestionRandom(q264);
        QuestionRandom q265 = new QuestionRandom("Block caches or buffer caches are used","to improve disk performance","to handle interrupts","to increase the capacity of the main memory","to speed up main memory read operation","to improve disk performance");
        this.addQuestionRandom(q265);
        QuestionRandom q266 = new QuestionRandom("Which of the following statements is false?","a small page size causes large page tables","internal fragmentation is increased with small pages","a large page size causes instructions and data that will not be referenced brought into primary storage","I/O transfers are more efficient with large pages","internal fragmentation is increased with small pages");
        this.addQuestionRandom(q266);
        QuestionRandom q267 = new QuestionRandom("The action of parsing the source program into the proper syntactic classes is known as","syntax analysis","lexical analysis","interpretation analysis","general syntax analysis","lexical analysis");
        this.addQuestionRandom(q267);
        QuestionRandom q268 = new QuestionRandom("Which, of the following is not true about the description of a decision table?","A decision table is easy to modify","A decision table is directly understood by the computer","A decision table is easy to understand","All of the above","A decision table is directly understood by the computer");
        this.addQuestionRandom(q268);
        QuestionRandom q269 = new QuestionRandom("Trojan-Horse programs","are legitimate programs that allow unauthorized access","do not usually work","are hidden programs that do not show up on the system","usually are immediately discovered","are legitimate programs that allow unauthorized access");
        this.addQuestionRandom(q269);
        QuestionRandom q270 = new QuestionRandom("When did IBM release the first version of disk operating system DOS version 1.0?","1981","1982","1983","1984","1981");
        this.addQuestionRandom(q270);
        QuestionRandom q271 = new QuestionRandom("Which of the following is false about disk when compared to main memory?","non-volatile","longer storage capacity","lower price per bit","faster","faster");
        this.addQuestionRandom(q271);
        QuestionRandom q272 = new QuestionRandom("Producer consumer problem can be solved using","semaphores","event counters","monitors","all of the above","all of the above");
        this.addQuestionRandom(q272);
        QuestionRandom q273 = new QuestionRandom("Most of the microcomputer's operating systems like Apple DOS, MS DOS and PC DOS etc. are called disk operating systems because","they are memory resident","they are initially stored on disk","they are available on magnetic tapes","they are partly in primary memory and partly on disk","they are initially stored on disk");
        this.addQuestionRandom(q273);
        QuestionRandom q274 = new QuestionRandom("The CPU, after receiving an interrupt from an I/O device","halts for a predetermined time","hands over control of address bus and data bus to the interrupting device","branches off to the interrupt service routine immediately","branches off to the interrupt service routine after completion of the current instruction","branches off to the interrupt service routine after completion of the current instruction");
        this.addQuestionRandom(q274);
        QuestionRandom q275 = new QuestionRandom("Seeks analysis","is used for analyzing paging problems","is used for analyzing control-unit busy problems","is only shown on real-time displays","is used for analyzing device busy problems","is used for analyzing device busy problems");
        this.addQuestionRandom(q275);
        QuestionRandom q276 = new QuestionRandom("Which is a permanent database in the general model of compiler?","Literal Table","Identifier Table","Terminal Table","Source code","Terminal Table");
        this.addQuestionRandom(q276);
        QuestionRandom q277 = new QuestionRandom("What is the name of the technique in which the operating system of a computer executes several programs concurrently by switching back and forth between them?","Partitioning","Multitasking","Windowing","Paging","Multitasking");
        this.addQuestionRandom(q277);
        QuestionRandom q278 = new QuestionRandom("Operating system","links a program with the subroutines it references","provides a layered, user-friendly interface","enables the programmer to draw a flowchart","all of the above","provides a layered, user-friendly interface");
        this.addQuestionRandom(q278);
        QuestionRandom q279 = new QuestionRandom("Software that measures, monitors, analyzes, and controls real-world events is called:","system software","real-time software","scientific software","business software","real-time software");
        this.addQuestionRandom(q279);
        QuestionRandom q280 = new QuestionRandom("The details of all external symbols and relocation formation (relocation list or map) is provided to linker by","Macro processor","Translator","Loader","Editor","Translator");
        this.addQuestionRandom(q280);
        QuestionRandom q281 = new QuestionRandom("The macro processor must perform","recognize macro definitions and macro calls","save the macro definitions","expand macros calls and substitute arguments","all of the above","all of the above");
        this.addQuestionRandom(q281);
        QuestionRandom q282 = new QuestionRandom("A development strategy whereby the executive control modules of a system are coded and tested first, is known as","Bottom-up development","Top-down development","Left-Right development","All of the above","Top-down development");
        this.addQuestionRandom(q282);
        QuestionRandom q283 = new QuestionRandom("Which of the following is helpful in evaluating applications software what will best suit your needs?","recommendations by other users","computer magazines","objective software reviews","all of the above","all of the above");
        this.addQuestionRandom(q283);
        QuestionRandom q284 = new QuestionRandom("What problem is solved by Dijkstra's banker's algorithm?","mutual exclusion","deadlock recovery ","deadlock avoidance","cache coherence","deadlock avoidance");
        this.addQuestionRandom(q284);
        QuestionRandom q285 = new QuestionRandom("The dispatcher","actually schedules the tasks into the processor","puts tasks in I/O wait","is always small and simple","never changes task priorities","actually schedules the tasks into the processor");
        this.addQuestionRandom(q285);
        QuestionRandom q286 = new QuestionRandom("System programs such as Compilers are designed so that they are","reenterable","non reusable","serially usable","recursive","reenterable");
        this.addQuestionRandom(q286);
        QuestionRandom q287 = new QuestionRandom("IBM released its first PC in 1981. Can you name the operating system which was most popular at that time?","MS-DOS","PC-DOS","OS/360","CP/M","CP/M");
        this.addQuestionRandom(q287);
        QuestionRandom q288 = new QuestionRandom("If the number of bits in a virtual address of a program is 16 and the page size is 0.5 K bytes, the number of pages in the virtual address space is","16","32","64","128","128");
        this.addQuestionRandom(q288);
        QuestionRandom q289 = new QuestionRandom("Which table is a permanent database that has an entry for each terminal symbol.","Terminal table","Reductions","Identifier table","Literal table","Terminal table");
        this.addQuestionRandom(q289);
        QuestionRandom q290 = new QuestionRandom("The function(s) of the Syntax phase is(are)","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.","to build a literal table and an identifier table","to build a uniform symbol table","to parse the source program into the basic elements or tokens of the language.","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.");
        this.addQuestionRandom(q290);
        QuestionRandom q291 = new QuestionRandom("Swapping","works best with many small partitions","allows many programs to use memory simultaneously","allows each program in turn to use the memory","does not work with overlaying33","allows each program in turn to use the memory");
        this.addQuestionRandom(q291);
        QuestionRandom q292 = new QuestionRandom("A disk scheduling algorithm in an operating system causes the disk arm to move back and forth across the disk surface in order to service all requests in its path. This is a","First come first served","Shortest Seek Time First (SSTE)","Scan","FIFO","Scan ");
        this.addQuestionRandom(q292);
        QuestionRandom q293 = new QuestionRandom("A translator is best described as","an application software","a system software","a hardware component","all of the above","a system software");
        this.addQuestionRandom(q293);
        QuestionRandom q294 = new QuestionRandom("Data encryption","is mostly used by public networks","is mostly used by financial networks","cannot be used by private installations","is not necessary, since data cannot be intercepted","is mostly used by financial networks");
        this.addQuestionRandom(q294);
        QuestionRandom q295 = new QuestionRandom("What is the name given to the process of initializing a microcomputer with its operating system?","Cold booting","Booting","Warm booting","Boot recording","Booting");
        this.addQuestionRandom(q295);
        QuestionRandom q296 = new QuestionRandom("The function(s) of the Storage Assignment is (are)","to assign storage to all variables referenced in the source program.","to assign storage to all temporary locations that are necessary for intermediate results","to assign storage to literals, and to ensure that the storage is allocate and appropriate locations are initialized.","all of the above","all of the above");
        this.addQuestionRandom(q296);
        QuestionRandom q297 = new QuestionRandom("A Processor","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time of the CPU's time to allow quick response to each user","is a device that performs a sequence of operations specified by instructions in memory");
        this.addQuestionRandom(q297);
        QuestionRandom q298 = new QuestionRandom("With MS-DOS which command will divide the surface of the blank floppy disk into sectors and assign a unique address to each one?","FORMAT command","FAT command","VER command","CHKDSK command","FORMAT command");
        this.addQuestionRandom(q298);
        QuestionRandom q299 = new QuestionRandom("Multiprogramming","is a method of memory allocation by which the program is subdivided into equal portions, or pages and core is subdivided into equal portions or blocks.","consists of those addresses that may be generated by a processor during execution of a computation","is a method of allocating processor time.","allows multiple programs to reside in separate areas of core at the time","allows multiple programs to reside in separate areas of core at the time");
        this.addQuestionRandom(q299);
        QuestionRandom q300 = new QuestionRandom("A translator which reads an entire programme written in a high level language and converts it into machine language code is:","assembler","translator","compiler","system software","compiler");
        this.addQuestionRandom(q300);

    }

    public void addQuestionRandom(QuestionRandom quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION0());
        values.put(KEY_ANSWER, quest.getANSWER0());
        values.put(KEY_OPTA, quest.getOPTA0());
        values.put(KEY_OPTB, quest.getOPTB0());
        values.put(KEY_OPTC, quest.getOPTC0());
        values.put(KEY_OPTD, quest.getOPTD0());
        // Inserting Row
        dbase.insert(TABLE_QUEST0, null, values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<QuestionBlood_rel> getAllQuestions1(String tname, String lname)  //x
    {
        List<QuestionBlood_rel> quesList1= new ArrayList<QuestionBlood_rel>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionBlood_rel quest1 = new QuestionBlood_rel();
                quest1.setID1(cursor.getInt(0));
                quest1.setQUESTION1(cursor.getString(1));
                quest1.setANSWER1(cursor.getString(2));
                quest1.setOPTA1(cursor.getString(3));
                quest1.setOPTB1(cursor.getString(4));
                quest1.setOPTC1(cursor.getString(5));
                quest1.setOPTD1(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionCod_dec> getAllQuestions2(String tname, String lname)
    {
        List<QuestionCod_dec> quesList1= new ArrayList<QuestionCod_dec>();
        String selectQuery2 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery2, null);  //e
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionCod_dec quest1 = new QuestionCod_dec();
                quest1.setID2(cursor.getInt(0));
                quest1.setQUESTION2(cursor.getString(1));
                quest1.setANSWER2(cursor.getString(2));
                quest1.setOPTA2(cursor.getString(3));
                quest1.setOPTB2(cursor.getString(4));
                quest1.setOPTC2(cursor.getString(5));
                quest1.setOPTD2(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionDir_sense> getAllQuestions3(String tname, String lname)
    {
        List<QuestionDir_sense> quesList1= new ArrayList<QuestionDir_sense>();
        String selectQuery3 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery3, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionDir_sense quest1 = new QuestionDir_sense();
                quest1.setID3(cursor.getInt(0));
                quest1.setQUESTION3(cursor.getString(1));
                quest1.setANSWER3(cursor.getString(2));
                quest1.setOPTA3(cursor.getString(3));
                quest1.setOPTB3(cursor.getString(4));
                quest1.setOPTC3(cursor.getString(5));
                quest1.setOPTD3(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionAnalogy> getAllQuestions4(String tname, String lname)  //x
    {
        List<QuestionAnalogy> quesList1= new ArrayList<QuestionAnalogy>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionAnalogy quest1 = new QuestionAnalogy();
                quest1.setID4(cursor.getInt(0));
                quest1.setQUESTION4(cursor.getString(1));
                quest1.setANSWER4(cursor.getString(2));
                quest1.setOPTA4(cursor.getString(3));
                quest1.setOPTB4(cursor.getString(4));
                quest1.setOPTC4(cursor.getString(5));
                quest1.setOPTD4(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionAlp_Test> getAllQuestions5(String tname, String lname)  //x
    {
        List<QuestionAlp_Test> quesList1= new ArrayList<QuestionAlp_Test>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionAlp_Test quest1 = new QuestionAlp_Test();
                quest1.setID5(cursor.getInt(0));
                quest1.setQUESTION5(cursor.getString(1));
                quest1.setANSWER5(cursor.getString(2));
                quest1.setOPTA5(cursor.getString(3));
                quest1.setOPTB5(cursor.getString(4));
                quest1.setOPTC5(cursor.getString(5));
                quest1.setOPTD5(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionNumber_Series> getAllQuestions6(String tname, String lname)  //x
    {
        List<QuestionNumber_Series> quesList1= new ArrayList<QuestionNumber_Series>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionNumber_Series quest1 = new QuestionNumber_Series();
                quest1.setID6(cursor.getInt(0));
                quest1.setQUESTION6(cursor.getString(1));
                quest1.setANSWER6(cursor.getString(2));
                quest1.setOPTA6(cursor.getString(3));
                quest1.setOPTB6(cursor.getString(4));
                quest1.setOPTC6(cursor.getString(5));
                quest1.setOPTD6(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionLogical_Seq> getAllQuestions7(String tname, String lname)  //x
    {
        List<QuestionLogical_Seq> quesList1= new ArrayList<QuestionLogical_Seq>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionLogical_Seq quest1 = new QuestionLogical_Seq();
                quest1.setID7(cursor.getInt(0));
                quest1.setQUESTION7(cursor.getString(1));
                quest1.setANSWER7(cursor.getString(2));
                quest1.setOPTA7(cursor.getString(3));
                quest1.setOPTB7(cursor.getString(4));
                quest1.setOPTC7(cursor.getString(5));
                quest1.setOPTD7(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionNum_Ana> getAllQuestions8(String tname, String lname)  //x
    {
        List<QuestionNum_Ana> quesList1= new ArrayList<QuestionNum_Ana>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionNum_Ana quest1 = new QuestionNum_Ana();
                quest1.setID8(cursor.getInt(0));
                quest1.setQUESTION8(cursor.getString(1));
                quest1.setANSWER8(cursor.getString(2));
                quest1.setOPTA8(cursor.getString(3));
                quest1.setOPTB8(cursor.getString(4));
                quest1.setOPTC8(cursor.getString(5));
                quest1.setOPTD8(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionSit_Reaction> getAllQuestions9(String tname, String lname)  //x
    {
        List<QuestionSit_Reaction> quesList1= new ArrayList<QuestionSit_Reaction>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionSit_Reaction quest1 = new QuestionSit_Reaction();
                quest1.setID9(cursor.getInt(0));
                quest1.setQUESTION9(cursor.getString(1));
                quest1.setANSWER9(cursor.getString(2));
                quest1.setOPTA9(cursor.getString(3));
                quest1.setOPTB9(cursor.getString(4));
                quest1.setOPTC9(cursor.getString(5));
                quest1.setOPTD9(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionVerify_Truth> getAllQuestions10(String tname, String lname)  //x
    {
        List<QuestionVerify_Truth> quesList1= new ArrayList<QuestionVerify_Truth>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionVerify_Truth quest1 = new QuestionVerify_Truth();
                quest1.setID10(cursor.getInt(0));
                quest1.setQUESTION10(cursor.getString(1));
                quest1.setANSWER10(cursor.getString(2));
                quest1.setOPTA10(cursor.getString(3));
                quest1.setOPTB10(cursor.getString(4));
                quest1.setOPTC10(cursor.getString(5));
                quest1.setOPTD10(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionClassification> getAllQuestions11(String tname, String lname)  //x
    {
        List<QuestionClassification> quesList1= new ArrayList<QuestionClassification>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionClassification quest1 = new QuestionClassification();
                quest1.setID11(cursor.getInt(0));
                quest1.setQUESTION11(cursor.getString(1));
                quest1.setANSWER11(cursor.getString(2));
                quest1.setOPTA11(cursor.getString(3));
                quest1.setOPTB11(cursor.getString(4));
                quest1.setOPTC11(cursor.getString(5));
                quest1.setOPTD11(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionEssential_Part> getAllQuestions12(String tname, String lname)  //x
    {
        List<QuestionEssential_Part> quesList1= new ArrayList<QuestionEssential_Part>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionEssential_Part quest1 = new QuestionEssential_Part();
                quest1.setID12(cursor.getInt(0));
                quest1.setQUESTION12(cursor.getString(1));
                quest1.setANSWER12(cursor.getString(2));
                quest1.setOPTA12(cursor.getString(3));
                quest1.setOPTB12(cursor.getString(4));
                quest1.setOPTC12(cursor.getString(5));
                quest1.setOPTD12(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }

    public List<QuestionRandom> getAllQuestions0(String tname)
    {
        List<QuestionRandom> quesList1= new ArrayList<QuestionRandom>();
        String selectQuery1 = "SELECT  * FROM " + tname ;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionRandom quest1 = new QuestionRandom();
                quest1.setID0(cursor.getInt(0));
                quest1.setQUESTION0(cursor.getString(1));
                quest1.setANSWER0(cursor.getString(2));
                quest1.setOPTA0(cursor.getString(3));
                quest1.setOPTB0(cursor.getString(4));
                quest1.setOPTC0(cursor.getString(5));
                quest1.setOPTD0(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }



    public boolean insertScoreBlood_rel(int scoreBlood_rel,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreBlood_rel);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreCod_dec(int scoreCod_dec, String tname, String cname){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreCod_dec);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreDir_sense(int scoreDir_sense, String tname, String cname) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreDir_sense);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreAnalogy(int scoreAnalogy,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreAnalogy);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreAlp_Test(int scoreAlp_Test,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreAlp_Test);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreNumber_Series(int scoreNumber_Series,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreNumber_Series);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreLogical_Seq(int scoreLogical_Seq,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreLogical_Seq);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreNum_Ana(int scoreNum_Ana,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreNum_Ana);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreSit_Reaction(int scoreSit_Reaction,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreSit_Reaction);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreVerify_Truth(int scoreVerify_Truth,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreVerify_Truth);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreClassification(int scoreClassification,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreClassification);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreEssential_Part(int scoreEssential_Part,String tname, String cname) {  //x
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreEssential_Part);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }

    public boolean insertScoreFinal(int scoreRandom, String tname){
        SQLiteDatabase db = this.getWritableDatabase();
        String cname=null;
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreRandom);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1)
            return false;
        else
            return true;
    }



    public int getScoreBlood_relB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreBlood_relI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreBlood_relE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreCod_decB() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreCod_decI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreCod_decE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreDir_senseB() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreDir_senseI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreDir_senseE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAnalogyB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST4 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAnalogyI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST4 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAnalogyE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST4 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAlp_TestB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST5 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAlp_TestI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST5 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreAlp_TestE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST5 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 6

    public int getScoreNumber_SeriesB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST6 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreNumber_SeriesI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST6 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreNumber_SeriesE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST6 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 7

    public int getScoreLogical_SeqB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST7 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreLogical_SeqI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST7 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreLogical_SeqE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST7 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 8

    public int getScoreNum_AnaB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST8 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreNum_AnaI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST8 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreNum_AnaE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST8 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 9

    public int getScoreSit_ReactionB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST9 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreSit_ReactionI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST9 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreSit_ReactionE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST9 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 10

    public int getScoreVerify_TruthB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST10 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreVerify_TruthI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST10 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreVerify_TruthE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST10 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 11

    public int getScoreClassificationB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST11 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreClassificationI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST11+"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreClassificationE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST11 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    // 12

    public int getScoreEssential_PartB() {   // x 3
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST12 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreEssential_PartI() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST12 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }

    public int getScoreEssential_PartE() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST12 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }
    //

    public int getScoreRandom() {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST0+"'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
    }


}
