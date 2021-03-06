package com.example.hp.demo.LeaderBoard.Number_Series;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.demo.Adapter.LeaderBoardSec1B;
import com.example.hp.demo.Adapter.LeaderBoardSec6B;
import com.example.hp.demo.Adapter.LeaderBoardSec6I;
import com.example.hp.demo.Model.UserModel;
import com.example.hp.demo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoard_NS_I extends AppCompatActivity {

    RecyclerView mUsersRecyclerView;
    private List<String> mUsersKeyList;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mUserRefDatabase;
    private ChildEventListener mChildEventListener;
    private LeaderBoardSec6I leaderBoardAdapterSec1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board__ns__i);
        mUsersRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_usersNS_I);
        setAuthInstance();
        setUsersDatabase();
        setUserRecyclerView();
        setUsersKeyList();
        setAuthListener();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setUsersDatabase() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    }

    private void setUserRecyclerView() {
        leaderBoardAdapterSec1 = new LeaderBoardSec6I(this, new ArrayList<UserModel>());  // x
        mUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUsersRecyclerView.setHasFixedSize(true);
        //leaderBoardAdapterSec1.sortingScore();
        mUsersRecyclerView.setAdapter(leaderBoardAdapterSec1);

    }

    private void setUsersKeyList() {
        mUsersKeyList = new ArrayList<String>();
    }

    private void setAuthListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    queryAllUsers();
                } else {
                    // User is signed out
                }
            }
        };
    }

    private void queryAllUsers() {
        clearCurrentUsers();
        mChildEventListener = getChildEventListener();
        mUserRefDatabase.limitToFirst(50).addChildEventListener(mChildEventListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        clearCurrentUsers();

        if (mChildEventListener != null) {
            mUserRefDatabase.removeEventListener(mChildEventListener);
        }

    }

    private void clearCurrentUsers() {
        leaderBoardAdapterSec1.clear();
        mUsersKeyList.clear();
    }

    private ChildEventListener getChildEventListener() {
        return new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.exists()){

                    String userUid = dataSnapshot.getKey();
                    if(dataSnapshot.hasChildren()) {
                        UserModel recipient = dataSnapshot.getValue(UserModel.class);
                        if(recipient != null) {
                            recipient.setRecipientId(userUid);
                            mUsersKeyList.add(userUid);
                            leaderBoardAdapterSec1.refill(recipient);
                        }
                    }

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()) {
                    String userUid = dataSnapshot.getKey();

                    UserModel user = dataSnapshot.getValue(UserModel.class);

                    int index = mUsersKeyList.indexOf(userUid);
                    if(index > -1) {
                        leaderBoardAdapterSec1.changeUser(index, user);
                    }

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
