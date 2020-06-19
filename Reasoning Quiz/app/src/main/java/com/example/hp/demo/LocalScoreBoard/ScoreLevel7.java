package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel7 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level7);
        setTitle("Logical Sequence Of Words Score");   // x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int Logical_SeqB,Logical_SeqI,Logical_SeqE;  // x 5
        Logical_SeqB=Logical_SeqI=Logical_SeqE=0;
        Logical_SeqB=dbHelper.getScoreLogical_SeqB();
        Logical_SeqI=dbHelper.getScoreLogical_SeqI();
        Logical_SeqE=dbHelper.getScoreLogical_SeqE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(Logical_SeqB<10)       // x 3
        {
            s1.setText("0"+ Logical_SeqB);
        }
        else
        {
            s1.setText(""+ Logical_SeqB);
        }
        if(Logical_SeqI<10)
        {
            s2.setText("0"+ Logical_SeqI);
        }
        else
        {
            s2.setText(""+ Logical_SeqI);
        }
        if(Logical_SeqE<10)
        {
            s3.setText("0"+ Logical_SeqE);
        }
        else
        {
            s3.setText(""+ Logical_SeqE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
