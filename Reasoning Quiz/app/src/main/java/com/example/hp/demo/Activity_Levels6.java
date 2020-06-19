package com.example.hp.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_Levels6 extends AppCompatActivity {

    LinearLayout beginner;
    LinearLayout intermediate;
    LinearLayout expert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__levels6);
        setTitle("Number Series Levels");  //x
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        beginner=(LinearLayout)findViewById(R.id.begin);
        intermediate=(LinearLayout)findViewById(R.id.inter);
        expert=(LinearLayout)findViewById(R.id.expert);
        Intent iin= getIntent();
        Bundle b=iin.getExtras();
        final String tableName;
        if(b!=null){
            tableName=(String)b.get("table_name");
            Log.d("Table Name",tableName);
        }
        else
        {
            tableName="";
        }


        beginner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Main2ActivitySec6.class);
                i.putExtra("table_name",tableName);
                i.putExtra("level_name","B");  // ###########
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Main2ActivitySec6.class);
                i.putExtra("table_name",tableName);
                i.putExtra("level_name","I");  // #############
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Main2ActivitySec6.class);
                i.putExtra("table_name",tableName);
                i.putExtra("level_name","E");
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