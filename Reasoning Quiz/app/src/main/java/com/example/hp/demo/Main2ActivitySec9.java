package com.example.hp.demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.Model.QuestionBlood_rel;
import com.example.hp.demo.Model.QuestionSit_Reaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2ActivitySec9 extends AppCompatActivity {

    List<QuestionSit_Reaction> quesList1;   // x
    public int score=0;
    int ctr1=1;
    QuestionSit_Reaction currentQ1;   //x
    TextView txtQuestion1;
    RadioGroup grp;
    RadioButton rda1, rdb1, rdc1, rdd1;
    Button butNext1;
    Random random1 = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime1;
    public ArrayList<String> wrongQuestListSit_Reaction = new ArrayList<String>();   // x 3
    public ArrayList<String> selectedAnsSit_Reaction = new ArrayList<String>();
    public ArrayList<String> actualAnswerSit_Reaction = new ArrayList<String>();
    int number;
    ProgressBar progressBar;
    int progress = 1;
    String tableName="",catName="";
    TextView qstnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_sec9);
        qstnNo = (TextView)findViewById(R.id.qstnNo);

        Intent iin=getIntent();
        Bundle b=iin.getExtras();

        if(b!=null){
            tableName=(String)b.get("table_name");
            catName=(String)b.get("level_name");
            Log.d("Table Name",tableName);
            Log.d("Level Name",catName);
        }
        number=0;
        DbHelper db= new DbHelper(this);
        textViewTime1 = (TextView)findViewById(R.id.textViewTime);
        final Main2ActivitySec9.CounterClass timer = new Main2ActivitySec9.CounterClass(600000, 1000);  //
        timer.start();
        quesList1=db.getAllQuestions9(tableName,catName); //x
        for(int i=0;i<11;i++){
            while(true){
                int next = random1.nextInt(11);
                if(!list.contains(next))
                {
                    list.add(next);
                    break;
                }
            }
        }

        currentQ1 = quesList1.size() == 0 ? null : quesList1.get(list.get(0));
        txtQuestion1=(TextView)findViewById(R.id.textView1);
        rda1=(RadioButton)findViewById(R.id.radio0);
        rdb1=(RadioButton)findViewById(R.id.radio1);
        rdc1=(RadioButton)findViewById(R.id.radio2);
        rdd1=(RadioButton)findViewById(R.id.radio3);
        butNext1=(Button)findViewById(R.id.button1);
        setQuestionView();   // set question related thing
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        butNext1.setEnabled(false);   // next button not work until some option is choosen
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {   // if select any radio button
                if(i== R.id.radio0 || i == R.id.radio1 || i==R.id.radio2 || i == R.id.radio3)
                    butNext1.setEnabled(true);
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);       // progress bar of max length : 10
        progressBar.setProgress(1);    // intial progress bar of length : 1
        butNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ1 == null) {
                    Toast.makeText(getApplicationContext(),"No questions in database!",Toast.LENGTH_SHORT).show();
                    return;
                }
                progress = progress+1;
                progressBar.setProgress(progress);   // set inc progress bar
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());  // take check button id

                if (currentQ1.getANSWER9().equals(answer.getText())) {  // compare database answer to current answer
                    score++;    // inc score
                }
                else
                {
                    wrongQuestListSit_Reaction.add(number, currentQ1.getQUESTION9());   // add current wrong question   x 3
                    selectedAnsSit_Reaction.add(number, answer.getText().toString());   // add current selected answer
                    actualAnswerSit_Reaction.add(number, currentQ1.getANSWER9());    // add current correct answer
                    number++;
                }
                grp.clearCheck();  // clear check option
                butNext1.setEnabled(false);   // again set button to not wrong state
                if (ctr1 < 11) {
                    if (ctr1 == 10) {
                        butNext1.setText("End Test");       // at last showing end test on button
                    }
                    currentQ1 = quesList1.get(list.get(ctr1));   // get ctr1 th question in list
                    setQuestionView();  // set question details
                } else {
                    timer.onFinish();
                    timer.cancel();
                }
            }
        });

    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime1.setText(hms);
        }

        @Override
        public void onFinish() {
            showResult();
        }
    }

    public void showResult(){
        Intent intent = new Intent(Main2ActivitySec9.this, ResultActivity.class);
        Bundle b = new Bundle();  // creating the object of bundle class
        b.putInt("scoreSit_Reaction", score);//Your score       x
        b.putString("section",tableName);//Your table name
        b.putString("category",catName);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestListSit_Reaction);   // string array list  x 3
        intent.putStringArrayListExtra("selectedAnswer", selectedAnsSit_Reaction);
        intent.putStringArrayListExtra("actualAnswer", actualAnswerSit_Reaction);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    private void setQuestionView(){
        txtQuestion1.setText(currentQ1.getQUESTION9());   // set question
        rda1.setText(currentQ1.getOPTA9());
        rdb1.setText(currentQ1.getOPTB9());             // set options
        rdc1.setText(currentQ1.getOPTC9());
        rdd1.setText(currentQ1.getOPTD9());
        if(ctr1<10)
            qstnNo.setText("0" + ctr1 + "/10");         //  see whether number is having ten's place or not
        else
            qstnNo.setText("" + ctr1+ "/10");
        ctr1++;      // increment question number
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("If you close all your progress would not be saved... Do you wish to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        alert.show();
    }
}
