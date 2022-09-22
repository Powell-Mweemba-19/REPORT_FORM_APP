package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class signUp extends AppCompatActivity {


    //name to be used on the drop down
    String[] profession = {"Teacher","Pupil"};
    AutoCompleteTextView auto_Complete;
    ArrayAdapter<String> adapterItems;

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



    }
}