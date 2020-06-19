package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel3 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel3);
        setTitle("Direction Sense Score");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Dir_senseB, Dir_senseI, Dir_senseE;
        Dir_senseB=Dir_senseI=Dir_senseE=0;
        Dir_senseB=dbHelper.getScoreDir_senseB();
        Dir_senseI=dbHelper.getScoreDir_senseI();
        Dir_senseE=dbHelper.getScoreDir_senseE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Dir_senseB<10)
        {
            s1.setText("0"+ Dir_senseB);
        }
        else
        {
            s1.setText(""+ Dir_senseB);
        }
        if(Dir_senseI<10)
        {
            s2.setText("0"+ Dir_senseI);
        }
        else
        {
            s2.setText(""+ Dir_senseI);
        }
        if(Dir_senseE<10)
        {
            s3.setText("0"+ Dir_senseE);
        }
        else
        {
            s3.setText(""+ Dir_senseE);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
