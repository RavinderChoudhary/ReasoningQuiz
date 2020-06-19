package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel2 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel2);
        setTitle("Coding - Decoding Score");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Cod_decB,Cod_decI,Cod_decE;
        Cod_decB=Cod_decI=Cod_decE=0;
        Cod_decB=dbHelper.getScoreCod_decB();
        Cod_decI=dbHelper.getScoreCod_decI();
        Cod_decE=dbHelper.getScoreCod_decE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Cod_decB<10)
        {
            s1.setText("0"+ Cod_decB);
        }
        else
        {
            s1.setText(""+ Cod_decB);
        }
        if(Cod_decI<10)
        {
            s2.setText("0"+ Cod_decI);
        }
        else
        {
            s2.setText(""+ Cod_decI);
        }
        if(Cod_decE<10)
        {
            s3.setText("0"+ Cod_decE);
        }
        else
        {
            s3.setText(""+ Cod_decE);
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
