package com.example.hp.demo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel1;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel10;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel11;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel12;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel2;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel3;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel4;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel5;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel6;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel7;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel8;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel9;
import com.example.hp.demo.LocalScoreBoard.ScoreLevelFinal;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second extends Fragment {


    public FirebaseAuth.AuthStateListener mAuthListener;
    public String mCurrentUserUid;
    public FirebaseAuth mAuth;
    public DatabaseReference mUserRefDatabase;

    ImageView yourScore1,yourScore2,yourScore3,yourScore4,yourScore5,yourScore6,yourScore7,yourScore8,yourScore9,yourScore10,yourScore11,yourScore12,yourScore;
    ChildEventListener mChildEventListener;


    public Second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_second, container, false);

        setAuthInstance();
        setDatabaseInstance();

        if(mAuth.getCurrentUser() == null)
            goToLogin();

        DbHelper dbHelper = new DbHelper(getActivity());
        int Alp_TestMarksB=dbHelper.getScoreAlp_TestB();
        int Alp_TestMarksI=dbHelper.getScoreAlp_TestI();
        int Alp_TestMarksE=dbHelper.getScoreAlp_TestE();
        int AnalogyMarksB=dbHelper.getScoreAnalogyB();
        int AnalogyMarksI=dbHelper.getScoreAnalogyI();
        int AnalogyMarksE=dbHelper.getScoreAnalogyE();
        int Blood_relMarksB=dbHelper.getScoreBlood_relB();      // x 3
        int Blood_relMarksI=dbHelper.getScoreBlood_relI();
        int Blood_relMarksE=dbHelper.getScoreBlood_relE();
        int ClassificationMarksB=dbHelper.getScoreClassificationB();
        int ClassificationMarksI=dbHelper.getScoreClassificationI();
        int ClassificationMarksE=dbHelper.getScoreClassificationE();
        int Cod_decMarksB=dbHelper.getScoreCod_decB();
        int Cod_decMarksI=dbHelper.getScoreCod_decI();
        int Cod_decMarksE=dbHelper.getScoreCod_decE();
        int Dir_senseMarksB=dbHelper.getScoreDir_senseB();
        int Dir_senseMarksI=dbHelper.getScoreDir_senseI();
        int Dir_senseMarksE=dbHelper.getScoreDir_senseE();
        int Essential_PartMarksB=dbHelper.getScoreEssential_PartB();
        int Essential_PartMarksI=dbHelper.getScoreEssential_PartI();
        int Essential_PartMarksE=dbHelper.getScoreEssential_PartE();
        int finalMarks=dbHelper.getScoreRandom();
        int Logical_SeqMarksB=dbHelper.getScoreLogical_SeqB();
        int Logical_SeqMarksI=dbHelper.getScoreLogical_SeqI();
        int Logical_SeqMarksE=dbHelper.getScoreLogical_SeqE();
        int Num_AnaMarksB=dbHelper.getScoreNum_AnaB();
        int Num_AnaMarksI=dbHelper.getScoreNum_AnaI();
        int Num_AnaMarksE=dbHelper.getScoreNum_AnaE();
        int Number_SeriesMarksB=dbHelper.getScoreNumber_SeriesB();
        int Number_SeriesMarksI=dbHelper.getScoreNumber_SeriesI();
        int Number_SeriesMarksE=dbHelper.getScoreNumber_SeriesE();
        int Sit_ReactionMarksB=dbHelper.getScoreSit_ReactionB();
        int Sit_ReactionMarksI=dbHelper.getScoreSit_ReactionI();
        int Sit_ReactionMarksE=dbHelper.getScoreSit_ReactionE();
        int Verify_TruthMarksB=dbHelper.getScoreVerify_TruthB();
        int Verify_TruthMarksI=dbHelper.getScoreVerify_TruthI();
        int Verify_TruthMarksE=dbHelper.getScoreVerify_TruthE();




        //

        String userId = mAuth.getCurrentUser().getUid();

        mUserRefDatabase.child("users").child(userId).child("Alp_TestMarksB").setValue(Alp_TestMarksB);
        mUserRefDatabase.child("users").child(userId).child("Alp_TestMarksI").setValue(Alp_TestMarksI);
        mUserRefDatabase.child("users").child(userId).child("Alp_TestMarksE").setValue(Alp_TestMarksE);
        mUserRefDatabase.child("users").child(userId).child("AnalogyMarksB").setValue(AnalogyMarksB);
        mUserRefDatabase.child("users").child(userId).child("AnalogyMarksI").setValue(AnalogyMarksI);
        mUserRefDatabase.child("users").child(userId).child("AnalogyMarksE").setValue(AnalogyMarksE);
        mUserRefDatabase.child("users").child(userId).child("Blood_relMarksB").setValue(Blood_relMarksB); // x 3
        mUserRefDatabase.child("users").child(userId).child("Blood_relMarksI").setValue(Blood_relMarksI);
        mUserRefDatabase.child("users").child(userId).child("Blood_relMarksE").setValue(Blood_relMarksE);
        mUserRefDatabase.child("users").child(userId).child("ClassificationMarksB").setValue(ClassificationMarksB);
        mUserRefDatabase.child("users").child(userId).child("ClassificationMarksI").setValue(ClassificationMarksI);
        mUserRefDatabase.child("users").child(userId).child("ClassificationMarksE").setValue(ClassificationMarksE);
        mUserRefDatabase.child("users").child(userId).child("Cod_decMarksB").setValue(Cod_decMarksB);
        mUserRefDatabase.child("users").child(userId).child("Cod_decMarksI").setValue(Cod_decMarksI);
        mUserRefDatabase.child("users").child(userId).child("Cod_decMarksE").setValue(Cod_decMarksE);
        mUserRefDatabase.child("users").child(userId).child("Dir_senseMarksB").setValue(Dir_senseMarksB);
        mUserRefDatabase.child("users").child(userId).child("Dir_senseMarksI").setValue(Dir_senseMarksI);
        mUserRefDatabase.child("users").child(userId).child("Dir_senseMarksE").setValue(Dir_senseMarksE);
        mUserRefDatabase.child("users").child(userId).child("Essential_PartMarksB").setValue(Essential_PartMarksB);
        mUserRefDatabase.child("users").child(userId).child("Essential_PartMarksI").setValue(Essential_PartMarksI);
        mUserRefDatabase.child("users").child(userId).child("Essential_PartMarksE").setValue(Essential_PartMarksE);
        mUserRefDatabase.child("users").child(userId).child("finalMarks").setValue(finalMarks);
        mUserRefDatabase.child("users").child(userId).child("Logical_SeqMarksB").setValue(Logical_SeqMarksB);
        mUserRefDatabase.child("users").child(userId).child("Logical_SeqMarksI").setValue(Logical_SeqMarksI);
        mUserRefDatabase.child("users").child(userId).child("Logical_SeqMarksE").setValue(Logical_SeqMarksE);
        mUserRefDatabase.child("users").child(userId).child("Num_AnaMarksB").setValue(Num_AnaMarksB);
        mUserRefDatabase.child("users").child(userId).child("Num_AnaMarksI").setValue(Num_AnaMarksI);
        mUserRefDatabase.child("users").child(userId).child("Num_AnaMarksE").setValue(Num_AnaMarksE);
        mUserRefDatabase.child("users").child(userId).child("Number_SeriesMarksB").setValue(Number_SeriesMarksB);
        mUserRefDatabase.child("users").child(userId).child("Number_SeriesMarksI").setValue(Number_SeriesMarksI);
        mUserRefDatabase.child("users").child(userId).child("Number_SeriesMarksE").setValue(Number_SeriesMarksE);
        mUserRefDatabase.child("users").child(userId).child("Sit_ReactionMarksB").setValue(Sit_ReactionMarksB);
        mUserRefDatabase.child("users").child(userId).child("Sit_ReactionMarksI").setValue(Sit_ReactionMarksI);
        mUserRefDatabase.child("users").child(userId).child("Sit_ReactionMarksE").setValue(Sit_ReactionMarksE);
        mUserRefDatabase.child("users").child(userId).child("Verify_TruthMarksB").setValue(Verify_TruthMarksB);
        mUserRefDatabase.child("users").child(userId).child("Verify_TruthMarksI").setValue(Verify_TruthMarksI);
        mUserRefDatabase.child("users").child(userId).child("Verify_TruthMarksE").setValue(Verify_TruthMarksE);




        yourScore1 = (ImageView) rootview.findViewById(R.id.imgs1);   // x
        yourScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Blood Relations",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel1.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


        yourScore2 = (ImageView) rootview.findViewById(R.id.imgs2);  //
        yourScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Coding - Decoding",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel2.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore3 = (ImageView) rootview.findViewById(R.id.imgs3);  //
        yourScore3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Direction Sense",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel3.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore4 = (ImageView) rootview.findViewById(R.id.imgs4);  //
        yourScore4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Analogy Sense",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel4.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore5 = (ImageView) rootview.findViewById(R.id.imgs5);  //
        yourScore5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Alphabet Test",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel5.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore6 = (ImageView) rootview.findViewById(R.id.imgs6);  //
        yourScore6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Series",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel6.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore7 = (ImageView) rootview.findViewById(R.id.imgs7);  //
        yourScore7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Logical Sequence Of Words",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel7.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore8 = (ImageView) rootview.findViewById(R.id.imgs8);  //
        yourScore8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Analogies",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel8.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore9 = (ImageView) rootview.findViewById(R.id.imgs9);  //
        yourScore9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Situation Reaction Test",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel9.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore10 = (ImageView) rootview.findViewById(R.id.imgs10);  //
        yourScore10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Verification of Truth of the Statement",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel10.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore11 = (ImageView) rootview.findViewById(R.id.imgs11);  //
        yourScore11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Classification",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel11.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        yourScore12 = (ImageView) rootview.findViewById(R.id.imgs12);  //
        yourScore12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Essential Part",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevel12.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        yourScore = (ImageView) rootview.findViewById(R.id.imgs13);  //
        yourScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Final Test1",Toast.LENGTH_SHORT).show(); //

                Intent i= new Intent(getActivity().getApplicationContext(), ScoreLevelFinal.class); //
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        // Inflate the layout for this fragment
        return rootview;
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }
    /*
    @Override
    public boolean onSupportNavigateUp(){
        getActivity().finish();
        return true;
    }
    */
    private void goToLogin() {
        Intent intent = new Intent(getActivity(), Activity_Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // LoginActivity is a New Task
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // The old task when coming back to this activity should be cleared so we cannot come back to it.
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
