package com.example.hp.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.demo.DbHelper.DbHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    int score=0,scoreCod_dec=0,scoreBlood_rel=0,scoreDir_sense=0,scoreRandom=0,scoreAnalogy=0,scoreAlp_Test=0,scoreNumber_Series=0,scoreLogical_Seq=0,
    scoreNum_Ana = 0 , scoreSit_Reaction = 0, scoreVerify_Truth = 0 , scoreClassification = 0 , scoreEssential_Part = 0;//x
    DbHelper dbHelper = new DbHelper(this);
    Button btnWrongQstns;

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ImageView img;
    private TextView tvPerc;
    String tableName="",catName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        img = (ImageView) findViewById(R.id.imageView);
        btnWrongQstns = (Button) findViewById(R.id.btnWrongQstns);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
        rotate.setRepeatCount(1);
        img.startAnimation(rotate);
        //get text view
        TextView txtCorrectAns = (TextView) findViewById(R.id.txtCorrectAns);
        //get score
        final Bundle b = getIntent().getExtras();
        if (b.containsKey("scoreCod_dec")) {     // if key equals to one of the topic key
            scoreCod_dec = b.getInt("scoreCod_dec"); //
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreCod_dec(scoreCod_dec,tableName,catName);
            score = scoreCod_dec;
        } else if (b.containsKey("scoreBlood_rel")) {      // x 2
            scoreBlood_rel = b.getInt("scoreBlood_rel");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreBlood_rel(scoreBlood_rel,tableName,catName);
            score = scoreBlood_rel;
        } else if (b.containsKey("scoreDir_sense")) {
            scoreDir_sense = b.getInt("scoreDir_sense");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreDir_sense(scoreDir_sense,tableName,catName);
            score = scoreDir_sense;
        } else if (b.containsKey("scoreAnalogy")) {
            scoreAnalogy = b.getInt("scoreAnalogy");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreAnalogy(scoreAnalogy,tableName,catName);
            score = scoreAnalogy;
        } else if (b.containsKey("scoreAlp_Test")) {
            scoreAlp_Test = b.getInt("scoreAlp_Test");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreAlp_Test(scoreAlp_Test,tableName,catName);
            score = scoreAlp_Test;
        }else if (b.containsKey("scoreNumber_Series")) {
            scoreNumber_Series = b.getInt("scoreNumber_Series");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreNumber_Series(scoreNumber_Series,tableName,catName);
            score = scoreNumber_Series;
        }else if (b.containsKey("scoreLogical_Seq")) {
            scoreLogical_Seq = b.getInt("scoreLogical_Seq");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreLogical_Seq(scoreLogical_Seq,tableName,catName);
            score = scoreLogical_Seq;
        }else if (b.containsKey("scoreNum_Ana")) {
            scoreNum_Ana = b.getInt("scoreNum_Ana");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreNum_Ana(scoreNum_Ana,tableName,catName);
            score = scoreNum_Ana;
        }else if (b.containsKey("scoreSit_Reaction")) {
            scoreSit_Reaction = b.getInt("scoreSit_Reaction");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreSit_Reaction(scoreSit_Reaction,tableName,catName);
            score = scoreSit_Reaction;
        }else if (b.containsKey("scoreVerify_Truth")) {
            scoreVerify_Truth = b.getInt("scoreVerify_Truth");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreVerify_Truth(scoreVerify_Truth,tableName,catName);
            score = scoreVerify_Truth;
        }else if (b.containsKey("scoreClassification")) {
            scoreClassification = b.getInt("scoreClassification");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreClassification(scoreClassification,tableName,catName);
            score = scoreClassification;
        }else if (b.containsKey("scoreEssential_Part")) {
            scoreEssential_Part = b.getInt("scoreEssential_Part");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreEssential_Part(scoreEssential_Part,tableName,catName);
            score = scoreEssential_Part;
        }else if (b.containsKey("scoreRandom")){
            scoreRandom = b.getInt("scoreRandom");
            tableName=b.getString("section");
            dbHelper.insertScoreFinal(scoreRandom,tableName);
            score = scoreRandom;

        }
        else score = -1;

        txtCorrectAns.setText("Total Answered : 10" + "\n" + "Correct Answered : " + score + "\nWrong Answered : " + (10 - score));

        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        double perc = (score*4 - (10-score))*2.5; //
        DecimalFormat df = new DecimalFormat("##.###");
        tvPerc = (TextView) findViewById(R.id.tvPerc);
        tvPerc.setText(""+df.format(perc)+" %");

        btnWrongQstns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, WrongQuestion.class);
                //Bundle b = new Bundle();
                intent.putStringArrayListExtra("wrongQuestions", wrongQuests);
                intent.putStringArrayListExtra("selectedAnswer", selectedAnswers);
                intent.putStringArrayListExtra("actualAnswer", actualAnswers);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
