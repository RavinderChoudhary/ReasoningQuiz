package com.example.hp.demo;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.v7.app.AlertDialog.*;


public class First extends Fragment  {

    ImageView imgClick1,imgClick2,imgClick3,imgClick4,imgClick5,imgClick6,imgClick7,imgClick8,imgClick9,imgClick10,imgClick11,imgClick12;//x
    public FirebaseAuth.AuthStateListener mAuthListener;
    public String mCurrentUserUid;
    public FirebaseAuth mAuth;
    public DatabaseReference mUserRefDatabase;

    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.fragment_first, container, false);


        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            getActivity().finish();
            Intent i = new Intent(getActivity().getBaseContext(),Activity_Login.class);
            getActivity().startActivity(i);

        }


        setAuthListener();
        setAuthInstance();
        imgClick1 = (ImageView) rootview.findViewById(R.id.imgview1);  //x
        imgClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Blood Relations",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels1.class);
                i.putExtra("table_name","TBR");
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick2 = (ImageView) rootview.findViewById(R.id.imgview2); //
        imgClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Coding - Decoding",Toast.LENGTH_SHORT).show(); //
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels2.class); //
                i.putExtra("table_name","TCD");
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick3 = (ImageView) rootview.findViewById(R.id.imgview3); //
        imgClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Direction Sense",Toast.LENGTH_SHORT).show(); //
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels3.class); //
                i.putExtra("table_name","TDS");
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick4 = (ImageView) rootview.findViewById(R.id.imgview4); //
        imgClick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Analogy",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels4.class); //x
                i.putExtra("table_name","TA");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick5 = (ImageView) rootview.findViewById(R.id.imgview5); //
        imgClick5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Alphabet Test",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels5.class); //x
                i.putExtra("table_name","TAT");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick6 = (ImageView) rootview.findViewById(R.id.imgview6); //
        imgClick6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Series",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels6.class); //x
                i.putExtra("table_name","TNS");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick7 = (ImageView) rootview.findViewById(R.id.imgview7); //
        imgClick7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Logical Sequence Of Words",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels7.class); //x
                i.putExtra("table_name","TLS");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick8 = (ImageView) rootview.findViewById(R.id.imgview8); //
        imgClick8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Number Analogies",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels8.class); //x
                i.putExtra("table_name","TNA");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick9 = (ImageView) rootview.findViewById(R.id.imgview9); //
        imgClick9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Situation Reaction Test",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels9.class); //x
                i.putExtra("table_name","TSR");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick10 = (ImageView) rootview.findViewById(R.id.imgview10); //
        imgClick10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Verification of Truth of the Statement",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels10.class); //x
                i.putExtra("table_name","TVT");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick11 = (ImageView) rootview.findViewById(R.id.imgview11); //
        imgClick11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Classification",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels11.class); //x
                i.putExtra("table_name","TC");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        imgClick12 = (ImageView) rootview.findViewById(R.id.imgview12); //
        imgClick12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Essential Part",Toast.LENGTH_SHORT).show(); //x
                Intent i = new Intent(getActivity().getBaseContext(), Activity_Levels12.class); //x
                i.putExtra("table_name","TEP");//x
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        // Inflate the layout for this fragment
        return rootview;
    }

    public void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }


    public void setAuthListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();  // current user object

                // if user has already an account then it need not to be login
                if (user != null) {
                    mCurrentUserUid = user.getUid();
                }
            }
        };
    }


    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

}
