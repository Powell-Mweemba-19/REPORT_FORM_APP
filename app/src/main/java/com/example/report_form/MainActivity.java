package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button loginB;

    // used in the  background animations
    private RelativeLayout myRelativeLayout;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
   TextView signUp = findViewById(R.id.signUp);

        loginB = findViewById(R.id.loginButton);
        // main activity buttons



        //on click listen for the main activity to link with the login activities

loginB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(),Report_Dashboard.class);
        startActivity(intent);
    }
});



//sign up  sett on click listener to direct you to the sign up page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),sign_Up_option.class);
                startActivity(intent);
            }
        });



        //bg color
        myRelativeLayout= (RelativeLayout) findViewById(R.id.mainLayout);
        animationDrawable = (AnimationDrawable) myRelativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();


    }

    //bg animation
    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable!=null);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (animationDrawable!=null)
        {
            if (!animationDrawable.isRunning())
            {
                animationDrawable.stop();
            }
        }
    }


}