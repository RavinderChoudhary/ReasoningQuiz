package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel6 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level6);
        setTitle("Number Series Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Number_SeriesB,Number_SeriesI,Number_SeriesE;  // x 5
        Number_SeriesB=Number_SeriesI=Number_SeriesE=0;
        Number_SeriesB=dbHelper.getScoreNumber_SeriesB();
        Number_SeriesI=dbHelper.getScoreNumber_SeriesI();
        Number_SeriesE=dbHelper.getScoreNumber_SeriesE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Number_SeriesB<10)       // x 3
        {
            s1.setText("0"+ Number_SeriesB);
        }
        else
        {
            s1.setText(""+ Number_SeriesB);
        }
        if(Number_SeriesI<10)
        {
            s2.setText("0"+ Number_SeriesI);
        }
        else
        {
            s2.setText(""+ Number_SeriesI);
        }
        if(Number_SeriesE<10)
        {
            s3.setText("0"+ Number_SeriesE);
        }
        else
        {
            s3.setText(""+ Number_SeriesE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
