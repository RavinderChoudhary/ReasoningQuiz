package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel9 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level9);
        setTitle("Situation Reaction Test Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Sit_ReactionB,Sit_ReactionI,Sit_ReactionE;  // x 5
        Sit_ReactionB=Sit_ReactionI=Sit_ReactionE=0;
        Sit_ReactionB=dbHelper.getScoreSit_ReactionB();
        Sit_ReactionI=dbHelper.getScoreSit_ReactionI();
        Sit_ReactionE=dbHelper.getScoreSit_ReactionE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Sit_ReactionB<10)       // x 3
        {
            s1.setText("0"+ Sit_ReactionB);
        }
        else
        {
            s1.setText(""+ Sit_ReactionB);
        }
        if(Sit_ReactionI<10)
        {
            s2.setText("0"+ Sit_ReactionI);
        }
        else
        {
            s2.setText(""+ Sit_ReactionI);
        }
        if(Sit_ReactionE<10)
        {
            s3.setText("0"+ Sit_ReactionE);
        }
        else
        {
            s3.setText(""+ Sit_ReactionE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
