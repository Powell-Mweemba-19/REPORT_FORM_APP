package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class signUp extends AppCompatActivity {


    //name to be used on the drop down
    String[] profession = {"Mathematics","English","Science","Computer Science","Social Science"};
    AutoCompleteTextView auto_Complete;
    ArrayAdapter<String> adapterItems;


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
        setContentView(R.layout.activity_sign_up);

        auto_Complete = findViewById(R.id.autoComplete);

        adapterItems = new ArrayAdapter<String>(this,R.layout.activity_list_items, profession);
        auto_Complete.setAdapter(adapterItems);




        //bg color
        myRelativeLayout= (RelativeLayout) findViewById(R.id.SignUpLayout);
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