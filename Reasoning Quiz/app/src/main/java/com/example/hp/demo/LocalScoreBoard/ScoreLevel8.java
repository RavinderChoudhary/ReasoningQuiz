package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel8 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level8);
        setTitle("Number Analogies Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Num_AnaB,Num_AnaI,Num_AnaE;  // x 5
        Num_AnaB=Num_AnaI=Num_AnaE=0;
        Num_AnaB=dbHelper.getScoreNum_AnaB();
        Num_AnaI=dbHelper.getScoreNum_AnaI();
        Num_AnaE=dbHelper.getScoreNum_AnaE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Num_AnaB<10)       // x 3
        {
            s1.setText("0"+ Num_AnaB);
        }
        else
        {
            s1.setText(""+ Num_AnaB);
        }
        if(Num_AnaI<10)
        {
            s2.setText("0"+ Num_AnaI);
        }
        else
        {
            s2.setText(""+ Num_AnaI);
        }
        if(Num_AnaE<10)
        {
            s3.setText("0"+ Num_AnaE);
        }
        else
        {
            s3.setText(""+ Num_AnaE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
