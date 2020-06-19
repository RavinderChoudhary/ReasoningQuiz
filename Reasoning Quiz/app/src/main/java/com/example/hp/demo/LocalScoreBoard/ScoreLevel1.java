package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel1 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel1);
        setTitle("Blood Relations Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Blood_relB,Blood_relI,Blood_relE;  // x 5
        Blood_relB=Blood_relI=Blood_relE=0;
        Blood_relB=dbHelper.getScoreBlood_relB();
        Blood_relI=dbHelper.getScoreBlood_relI();
        Blood_relE=dbHelper.getScoreBlood_relE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Blood_relB<10)       // x 3
        {
            s1.setText("0"+ Blood_relB);
        }
        else
        {
            s1.setText(""+ Blood_relB);
        }
        if(Blood_relI<10)
        {
            s2.setText("0"+ Blood_relI);
        }
        else
        {
            s2.setText(""+ Blood_relI);
        }
        if(Blood_relE<10)
        {
            s3.setText("0"+ Blood_relE);
        }
        else
        {
            s3.setText(""+ Blood_relE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
