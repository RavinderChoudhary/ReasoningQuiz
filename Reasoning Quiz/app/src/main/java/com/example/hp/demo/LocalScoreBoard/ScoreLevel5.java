package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel5 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level5);
        setTitle("Alphabet Test Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Alp_TestB,Alp_TestI,Alp_TestE;  // x 5
        Alp_TestB=Alp_TestI=Alp_TestE=0;
        Alp_TestB=dbHelper.getScoreAlp_TestB();
        Alp_TestI=dbHelper.getScoreAlp_TestI();
        Alp_TestE=dbHelper.getScoreAlp_TestE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);

        if(Alp_TestB<10)       // x 3
        {
            s1.setText("0"+ Alp_TestB);
        }
        else
        {
            s1.setText(""+ Alp_TestB);
        }
        if(Alp_TestI<10)
        {
            s2.setText("0"+ Alp_TestI);
        }
        else
        {
            s2.setText(""+ Alp_TestI);
        }
        if(Alp_TestE<10)
        {
            s3.setText("0"+ Alp_TestE);
        }
        else
        {
            s3.setText(""+ Alp_TestE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
