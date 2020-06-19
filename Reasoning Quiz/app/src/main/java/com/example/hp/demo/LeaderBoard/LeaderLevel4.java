package com.example.hp.demo.LeaderBoard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hp.demo.LeaderBoard.Analogy.LeaderBoard_A_B;
import com.example.hp.demo.LeaderBoard.Analogy.LeaderBoard_A_E;
import com.example.hp.demo.LeaderBoard.Analogy.LeaderBoard_A_I;
import com.example.hp.demo.LeaderBoard.Blood_Relations.LeaderBoard_BR_B;
import com.example.hp.demo.LeaderBoard.Blood_Relations.LeaderBoard_BR_E;
import com.example.hp.demo.LeaderBoard.Blood_Relations.LeaderBoard_BR_I;
import com.example.hp.demo.R;

public class LeaderLevel4 extends AppCompatActivity {

    LinearLayout beginner;
    LinearLayout intermediate;
    LinearLayout expert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_level4);
        setTitle("Analogy LeaderBoard");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        beginner=(LinearLayout)findViewById(R.id.begin);
        intermediate=(LinearLayout)findViewById(R.id.inter);
        expert=(LinearLayout)findViewById(R.id.expert);

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), LeaderBoard_A_B.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), LeaderBoard_A_I.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), LeaderBoard_A_E.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
