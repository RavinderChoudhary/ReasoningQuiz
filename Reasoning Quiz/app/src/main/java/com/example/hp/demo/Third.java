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
import com.example.hp.demo.LeaderBoard.Finale.LeaderBoardAcSecF;
import com.example.hp.demo.LeaderBoard.LeaderLevel1;
import com.example.hp.demo.LeaderBoard.LeaderLevel10;
import com.example.hp.demo.LeaderBoard.LeaderLevel11;
import com.example.hp.demo.LeaderBoard.LeaderLevel12;
import com.example.hp.demo.LeaderBoard.LeaderLevel2;
import com.example.hp.demo.LeaderBoard.LeaderLevel3;
import com.example.hp.demo.LeaderBoard.LeaderLevel4;
import com.example.hp.demo.LeaderBoard.LeaderLevel5;
import com.example.hp.demo.LeaderBoard.LeaderLevel6;
import com.example.hp.demo.LeaderBoard.LeaderLevel7;
import com.example.hp.demo.LeaderBoard.LeaderLevel8;
import com.example.hp.demo.LeaderBoard.LeaderLevel9;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel1;
import com.example.hp.demo.LocalScoreBoard.ScoreLevel2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {

    public FirebaseAuth.AuthStateListener mAuthListener;
    public String mCurrentUserUid;
    public FirebaseAuth mAuth;
    public DatabaseReference mUserRefDatabase;

    ImageView leaderBoard1,leaderBoard2,leaderBoard3,leaderBoard4,leaderBoard5,leaderBoard6,leaderBoard7,leaderBoard8,leaderBoard9,
    leaderBoard10,leaderBoard11,leaderBoard12,leaderBoard;
    ChildEventListener mChildEventListener;

    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_third, container, false);

        setAuthInstance();
        setDatabaseInstance();
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

        leaderBoard1 = (ImageView) rootview.findViewById(R.id.imgl1);  // x
        leaderBoard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Blood Relations",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel1.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard2 = (ImageView) rootview.findViewById(R.id.imgl2);
        leaderBoard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Coding - Decoding",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel2.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard3 = (ImageView) rootview.findViewById(R.id.imgl3);
        leaderBoard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Direction Sense",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel3.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard4 = (ImageView) rootview.findViewById(R.id.imgl4);
        leaderBoard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Analogy Sense",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel4.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard5 = (ImageView) rootview.findViewById(R.id.imgl5);
        leaderBoard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Alphabet Test",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel5.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard6 = (ImageView) rootview.findViewById(R.id.imgl6);
        leaderBoard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Series",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel6.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard7 = (ImageView) rootview.findViewById(R.id.imgl7);
        leaderBoard7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Logical Sequence Of Words",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel7.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard8 = (ImageView) rootview.findViewById(R.id.imgl8);
        leaderBoard8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Analogies",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel8.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard9 = (ImageView) rootview.findViewById(R.id.imgl9);
        leaderBoard9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Situation Reaction Test",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel9.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard10 = (ImageView) rootview.findViewById(R.id.imgl10);
        leaderBoard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Verification of Truth of the Statement",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel10.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard11 = (ImageView) rootview.findViewById(R.id.imgl11);
        leaderBoard11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Classification",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel11.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard12 = (ImageView) rootview.findViewById(R.id.imgl12);
        leaderBoard12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Essential Part",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderLevel12.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard = (ImageView) rootview.findViewById(R.id.imgl13);
        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Final Test1",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getActivity().getApplicationContext(), LeaderBoardAcSecF.class);
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
}
