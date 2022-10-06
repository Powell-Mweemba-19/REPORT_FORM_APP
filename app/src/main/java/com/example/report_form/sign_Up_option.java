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

public class sign_Up_option extends AppCompatActivity {


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

        setContentView(R.layout.activity_sign_up_option);


        //buttons to link to the sign up activity for the teacher and student
        Button studentSignUp = findViewById(R.id.SignButtonStudent);
        Button teacherSignUp = findViewById(R.id.SignButtonTeacher);

        //student sign up
        studentSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent to open the student sign up activity
                Intent intent = new Intent(view.getContext(), StudentSignUp.class);
                startActivity(intent);
            }
        });


        //teacher sign up
        teacherSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent to open the teacher sign up activity
                Intent intent = new Intent(view.getContext(), signUp.class);
                startActivity(intent);
            }
        });



        //bg color
        myRelativeLayout= (RelativeLayout) findViewById(R.id.SignUpOptionLayout);
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