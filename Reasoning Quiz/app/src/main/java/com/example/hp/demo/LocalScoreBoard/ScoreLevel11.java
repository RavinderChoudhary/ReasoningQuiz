package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel11 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level11);
        setTitle("Classification Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int ClassificationB,ClassificationI,ClassificationE;  // x 5
        ClassificationB=ClassificationI=ClassificationE=0;
        ClassificationB=dbHelper.getScoreClassificationB();
        ClassificationI=dbHelper.getScoreClassificationI();
        ClassificationE=dbHelper.getScoreClassificationE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(ClassificationB<10)       // x 3
        {
            s1.setText("0"+ ClassificationB);
        }
        else
        {
            s1.setText(""+ ClassificationB);
        }
        if(ClassificationI<10)
        {
            s2.setText("0"+ ClassificationI);
        }
        else
        {
            s2.setText(""+ ClassificationI);
        }
        if(ClassificationE<10)
        {
            s3.setText("0"+ ClassificationE);
        }
        else
        {
            s3.setText(""+ ClassificationE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
