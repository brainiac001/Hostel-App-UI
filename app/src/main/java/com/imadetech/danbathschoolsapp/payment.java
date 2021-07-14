package com.imadetech.danbathschoolsapp;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.imadetech.danbathschoolsapp.Model.Products;

public class payment extends AppCompatActivity {

String url = "404";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_payment);

        DatabaseReference pay = FirebaseDatabase.getInstance().getReference().child("Payment");
        pay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Products profile = dataSnapshot.getValue(Products.class);
                if (profile!=null) {

                    url = profile.getPdescription();

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //System.out.println("The read failed: " + databaseError.getCode());
            }
        });



        Button LoginButton = (Button) findViewById(R.id.pay_btn);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(url.equals("404")){
                    Toast.makeText(getBaseContext(), "Unable to Complete Request, Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }else{
                    if(url.equals("")){
                        Toast.makeText(getBaseContext(), "Payment Platform not yet Initialized", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getBaseContext(), "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();

                        customtab();
                    }
                }


            }
        });

    }

    private void customtab()
    {

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();


        try {
            customTabsIntent.intent.setPackage("com.android.chrome");
            customTabsIntent.launchUrl(this, Uri.parse(url) );
            builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));

        } catch (Exception e) {
            try {
                customTabsIntent.intent.setPackage("com.opera.browser");
                customTabsIntent.launchUrl(this, Uri.parse(url) );
                builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
            } catch (Exception f) {

                try {
                    customTabsIntent.intent.setPackage("com.UCMobile.intl");
                    customTabsIntent.launchUrl(this, Uri.parse(url) );
                    builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
                } catch (Exception g) {
                    customTabsIntent.intent.setPackage(null);
                    customTabsIntent.launchUrl(this, Uri.parse(url));
                    builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));


                }

            }
        }}

}
