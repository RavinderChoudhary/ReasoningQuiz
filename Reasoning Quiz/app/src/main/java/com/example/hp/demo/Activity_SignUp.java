package com.example.hp.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.demo.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Activity_SignUp extends AppCompatActivity {
    EditText username;
    EditText uemail;
    EditText upassword;
    EditText urepassword;
    Button btn_Sign_Up;
    Button btn_Already_Member;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private boolean isTaken=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.edusername);
        uemail = (EditText) findViewById(R.id.edemail);
        upassword = (EditText) findViewById(R.id.edpass);
        urepassword = (EditText) findViewById(R.id.edrepass);
        btn_Sign_Up = (Button) findViewById(R.id.button1);
        btn_Already_Member = (Button) findViewById(R.id.btn_Already_Member);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            Intent i = new Intent(getApplicationContext(),Activity_Login.class);
            startActivity(i);
            finish();
        }

        setAuthInstance();
        setDatabaseInstance();


        btn_Already_Member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        btn_Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterUser();
            }
        });
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
        // if user already has account exist then move the user to mainActivity
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    private void setDatabaseInstance() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public boolean validate() {
        boolean valid = true;

        String name = username.getText().toString();
        String email = uemail.getText().toString();
        String password = upassword.getText().toString();
        String reEnterPassword = urepassword.getText().toString();
        if (name.isEmpty()) {
            username.setError("Enter user name");
            valid = false;
        } else {
            username.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            uemail.setError("Enter a valid email address");
            valid = false;
        } else {
            uemail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 10) {
            upassword.setError("Entered password must be greater than 5 and maximum upto 10");
            valid = false;
        } else {
            upassword.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            urepassword.setError("Password Do not match");
            valid = false;
        } else {
            urepassword.setError(null);
        }
        return valid;
    }

    private void onRegisterUser() {
        String name = username.getText().toString();
        Log.d("Name", "" + name);

        if (!validate()) {
            // if not valid data do nothing
        } else {
            signUp(getUserEmail(), getUserPassword());
        }
    }


    private String getUserDisplayName() {
        return username.getText().toString().trim();
    }

    private String getUserEmail() {
        return uemail.getText().toString().trim();
    }

    private String getUserPassword() {
        return upassword.getText().toString().trim();
    }



    private void signUp(String email, String password) {
        final ProgressDialog progressDialog = new ProgressDialog(Activity_SignUp.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()) {
                    FirebaseUser firebaseUserLcl = mAuth.getCurrentUser();
                    String userId = firebaseUserLcl.getUid();
                    UserModel user = buildNewUser();
                    FirebaseDatabase.getInstance().getReference("users").child(userId).setValue(user);
                    createUserNames();
                    goToMainActivity();
                }
                else {
                    Toast.makeText(getApplicationContext(), "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //x
    private int getBlood_relMarksB() { return 0; } // 1.Blood Relations
    private int getBlood_relMarksI(){ return 0; }
    private int getBlood_relMarksE(){ return 0; }
    //
    private int getCod_decMarksB() { return 0; } // 2.Coding - Decoding
    private int getCod_decMarksI() { return 0; }
    private int getCod_decMarksE() { return 0; }

    private int getDir_senseMarksB() { return 0; } // 3.Direction Sense
    private int getDir_senseMarksI() { return 0; }
    private int getDir_senseMarksE() { return 0; }

    private int getAnalogyMarksB() { return 0; } //  4.Analogy
    private int getAnalogyMarksI() { return 0; }
    private int getAnalogyMarksE() { return 0; }

    private int getAlp_TestMarksB() { return 0; } // 5.Alphabet Test
    private int getAlp_TestMarksI() { return 0; }
    private int getAlp_TestMarksE() { return 0; }

    private int getNumber_SeriesMarksB() { return 0; } // 6.Number Series
    private int getNumber_SeriesMarksI() { return 0; }
    private int getNumber_SeriesMarksE() { return 0; }

    private int getLogical_SeqMarksB() { return 0; } // 7.Logical Sequence Of Words
    private int getLogical_SeqMarksI() { return 0; }
    private int getLogical_SeqMarksE() { return 0; }

    private int getNum_AnaMarksB() { return 0; } // 8.Number Analogies
    private int getNum_AnaMarksI() { return 0; }
    private int getNum_AnaMarksE() { return 0; }

    private int getSit_ReactionMarksB() { return 0; } // 9.Situation Reaction Test
    private int getSit_ReactionMarksI() { return 0; }
    private int getSit_ReactionMarksE() { return 0; }

    private int getVerify_TruthMarksB() { return 0; } // 10.Verification of Truth of the Statement
    private int getVerify_TruthMarksI() { return 0; }
    private int getVerify_TruthMarksE() { return 0; }

    private int getClassificationMarksB() { return 0; } // 11.Classification
    private int getClassificationMarksI() { return 0; }
    private int getClassificationMarksE() { return 0; }

    private int getEssential_PartMarksB() { return 0; } // 12.Essential Part
    private int getEssential_PartMarksI() { return 0; }
    private int getEssential_PartMarksE() { return 0; }

    private int getFinalMarks()
    {
        return 0;
    }



    private void goToMainActivity() {
        Intent intent = new Intent(Activity_SignUp.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void createUserNames() {
        FirebaseDatabase.getInstance().getReference("userNames").child(getUserDisplayName()).setValue(true);
    }
    private UserModel buildNewUser() {
        return new UserModel(
                getUserDisplayName(),
                getUserEmail(),
                new Date().getTime(),
                getBlood_relMarksB(),// x 3
                getBlood_relMarksI(),
                getBlood_relMarksE(),
                getCod_decMarksB(),
                getCod_decMarksI(),
                getCod_decMarksE(),
                getDir_senseMarksB(),
                getDir_senseMarksI(),
                getDir_senseMarksE(),
                getAnalogyMarksB(),
                getAnalogyMarksI(),
                getAnalogyMarksE(),
                getAlp_TestMarksB(),
                getAlp_TestMarksI(),
                getAlp_TestMarksE(),
                getNumber_SeriesMarksB(),
                getNumber_SeriesMarksI(),
                getNumber_SeriesMarksE(),
                getLogical_SeqMarksB(),
                getLogical_SeqMarksI(),
                getLogical_SeqMarksE(),
                getNum_AnaMarksB(),
                getNum_AnaMarksI(),
                getNum_AnaMarksE(),
                getSit_ReactionMarksB(),
                getSit_ReactionMarksI(),
                getSit_ReactionMarksE(),
                getVerify_TruthMarksB(),
                getVerify_TruthMarksI(),
                getVerify_TruthMarksE(),
                getClassificationMarksB(),
                getClassificationMarksI(),
                getClassificationMarksE(),
                getEssential_PartMarksB(),
                getEssential_PartMarksI(),
                getEssential_PartMarksE(),
                getFinalMarks()
        );
    }
    @Override
    public void onBackPressed(){

        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }
}

