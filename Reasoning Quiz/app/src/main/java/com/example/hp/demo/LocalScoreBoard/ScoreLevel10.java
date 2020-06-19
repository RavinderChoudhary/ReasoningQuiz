package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel10 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level10);
        setTitle("Verification of Truth of the Statement Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Verify_TruthB,Verify_TruthI,Verify_TruthE;  // x 5
        Verify_TruthB=Verify_TruthI=Verify_TruthE=0;
        Verify_TruthB=dbHelper.getScoreVerify_TruthB();
        Verify_TruthI=dbHelper.getScoreVerify_TruthI();
        Verify_TruthE=dbHelper.getScoreVerify_TruthE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Verify_TruthB<10)       // x 3
        {
            s1.setText("0"+ Verify_TruthB);
        }
        else
        {
            s1.setText(""+ Verify_TruthB);
        }
        if(Verify_TruthI<10)
        {
            s2.setText("0"+ Verify_TruthI);
        }
        else
        {
            s2.setText(""+ Verify_TruthI);
        }
        if(Verify_TruthE<10)
        {
            s3.setText("0"+ Verify_TruthE);
        }
        else
        {
            s3.setText(""+ Verify_TruthE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
