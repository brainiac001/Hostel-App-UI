package com.imadetech.danbathschoolsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.imadetech.danbathschoolsapp.Model.Products;

import java.util.Timer;
import java.util.TimerTask;

//import com.google.firebase.messaging.FirebaseMessaging;

public class Main2Activity extends AppCompatActivity {
    public  int appUsedCount;
    Context context;
    String category, activityurl;
    private AlertDialog myAlertDialog, myAlertDialogconnect;
    private int timeout = 0;
    private Boolean dialoguestate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main2);
        SharedPreferences preferences = getSharedPreferences("progress", MODE_PRIVATE);
        appUsedCount = preferences.getInt("appUsedCount",0);
        appUsedCount++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("appUsedCount", appUsedCount);
        editor.apply();
        //FirebaseMessaging.getInstance().subscribeToTopic("seatos");
        if (appUsedCount==20 || appUsedCount==40 || appUsedCount==70 || appUsedCount==100|| appUsedCount==140){
            AskForRating(appUsedCount);
        } else {

        }



        LinearLayout ly6 = findViewById(R.id.ly6);
        ly6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Website";
                openWebVievActivity();
            }
        });
        TextView gallerytext = findViewById(R.id.gallerytext);
        gallerytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                startActivity(new Intent(Main2Activity.this, gallery.class));
            }
        });

        ImageView iv_background = findViewById(R.id.iv_background);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv_background.getDrawable();
        animationDrawable.start();
        iv_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                startActivity(new Intent(Main2Activity.this, gallery.class));
            }
        });


                LinearLayout ly1 = findViewById(R.id.ly1);
        ly1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Newsletter";
                openWebVievActivity();
            }
        });
        LinearLayout ly2 = findViewById(R.id.ly2);
        ly2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
            category = "Events";
            openWebVievActivity();
            }

        });
        LinearLayout ly3 = findViewById(R.id.ly3);
        ly3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Elearning";
                openWebVievActivity();  }
        });
        LinearLayout ly4 = findViewById(R.id.ly4);
        ly4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Staff";
                openWebVievActivity();
            }
        });
        LinearLayout ly5 = findViewById(R.id.ly5);
        ly5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Calendar";
                openWebVievActivity();
                 }

        });

        LinearLayout ly7 = findViewById(R.id.ly7);
        ly7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Timetable";
                openWebVievActivity();
                }

        });
        LinearLayout ly8 = findViewById(R.id.ly8);
        ly8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
               startActivity(new Intent(getBaseContext(), payment.class));
            }
        });

        LinearLayout ly9 = findViewById(R.id.ly9);
        ly9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                category = "Student Portal";
                openWebVievActivity();
            }
        });





        LinearLayout ly11 = findViewById(R.id.ly11);
        ly11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {


                startActivity(new Intent(getBaseContext(), aboutus.class));


            }
        });
    }

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    @Override
    public void onBackPressed(){
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap back twice to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

    private void AskForRating(int _appUsedCount){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Rate "+getString(R.string.school_name)+" App");
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setMessage("Thanks for using this app. If you like "+getString(R.string.school_name)+" App please rate us! Your feedback is important for us!");
        alert.setPositiveButton("YES",new Dialog.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton){
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
                appUsedCount = -300;
                SharedPreferences preferences = getSharedPreferences("progress", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("appUsedCount", appUsedCount);
                editor.apply();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();


    }

    private void openWebVievActivity(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean connected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        if (connected == true) {
            DatabaseReference pay = FirebaseDatabase.getInstance().getReference().child(category);
            pay.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Products profile = dataSnapshot.getValue(Products.class);
                    if (profile!=null) {

                        activityurl = profile.getPid();
                        Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
                        intent.putExtra("category", category);
                        intent.putExtra("activityurl", activityurl);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getBaseContext(), "Connection to server failed please check your internet connection and try again", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //System.out.println("The read failed: " + databaseError.getCode());
                }
            });

        }
        else{
            //loadingBar.dismiss();
            Toast.makeText(getBaseContext(), "No internet connection, make sure you turn on your internet location", Toast.LENGTH_LONG).show();

        }
           dialoguestate = false;
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
                connectedRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean connected = snapshot.getValue(Boolean.class);
                        if (connected) {
                            timeout = 0;

                        } else {
                            timeout = timeout+1;
                            if(timeout==30){
                                Dialogueconnect();
                                timeout=0;}

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });


            }
        }, 10000, 1000);


    }
    private void Dialogueconnect(){

        if( myAlertDialogconnect != null && myAlertDialogconnect.isShowing()) {

        }else {
            if(!dialoguestate) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Connect to a Network");
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setMessage("To open "+category+" turn on mobile data or connect to a Wi-Fi.");
                alert.setPositiveButton("OK", new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialoguestate = true;
                    }
                });

                try {
                    myAlertDialogconnect = alert.create();
                    myAlertDialogconnect.show();
                } catch (Exception e) {

                }
            }
        }
    }
}
