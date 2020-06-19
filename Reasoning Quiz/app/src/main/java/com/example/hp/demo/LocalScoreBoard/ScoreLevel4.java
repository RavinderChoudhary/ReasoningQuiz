package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel4 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level4);  // replace
        setTitle("Analogy Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int AnalogyB,AnalogyI,AnalogyE;  // x 5
        AnalogyB=AnalogyI=AnalogyE=0;
        AnalogyB=dbHelper.getScoreAnalogyB();
        AnalogyI=dbHelper.getScoreAnalogyI();
        AnalogyE=dbHelper.getScoreAnalogyE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(AnalogyB<10)       // x 3
        {
            s1.setText("0"+ AnalogyB);
        }
        else
        {
            s1.setText(""+ AnalogyB);
        }
        if(AnalogyI<10)
        {
            s2.setText("0"+ AnalogyI);
        }
        else
        {
            s2.setText(""+ AnalogyI);
        }
        if(AnalogyE<10)
        {
            s3.setText("0"+ AnalogyE);
        }
        else
        {
            s3.setText(""+ AnalogyE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
