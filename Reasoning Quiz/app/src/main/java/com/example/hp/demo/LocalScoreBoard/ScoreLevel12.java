package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel12 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level12);
        setTitle("Essential Part Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Essential_PartB,Essential_PartI,Essential_PartE;  // x 5
        Essential_PartB=Essential_PartI=Essential_PartE=0;
        Essential_PartB=dbHelper.getScoreEssential_PartB();
        Essential_PartI=dbHelper.getScoreEssential_PartI();
        Essential_PartE=dbHelper.getScoreEssential_PartE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Essential_PartB<10)       // x 3
        {
            s1.setText("0"+ Essential_PartB);
        }
        else
        {
            s1.setText(""+ Essential_PartB);
        }
        if(Essential_PartI<10)
        {
            s2.setText("0"+ Essential_PartI);
        }
        else
        {
            s2.setText(""+ Essential_PartI);
        }
        if(Essential_PartE<10)
        {
            s3.setText("0"+ Essential_PartE);
        }
        else
        {
            s3.setText(""+ Essential_PartE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
