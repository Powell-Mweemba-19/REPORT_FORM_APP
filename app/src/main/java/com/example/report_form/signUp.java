package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class signUp extends AppCompatActivity {

    //id generator
    UUID id = UUID.randomUUID();
    String ID = id.toString();
    //name to be used on the drop down
    String[] profession = {"Mathematics","English","Science","Computer Science","Social Science"};
    AutoCompleteTextView auto_Complete;
    ArrayAdapter<String> adapterItems;

    //hooks to xml tags
    Button submit;
    EditText email,passWord,fullName;
    RadioButton Male, female, math, english, science, computerScience, socialScience;

    // used in the  background animations
    private RelativeLayout myRelativeLayout;
    private AnimationDrawable animationDrawable;

    //ids
    static Integer count = 0;


//fire base
    FirebaseDatabase rootNode;
  DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);



        //xml tags
        fullName = findViewById(R.id.full_Name);
        email = findViewById(R.id.email);
        passWord = findViewById(R.id.signUpPasswordEdit);

        Male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        math = findViewById(R.id.math);
        english = findViewById(R.id.english);
        science = findViewById(R.id.science);
        computerScience = findViewById(R.id.Computer_Science);
        socialScience = findViewById(R.id.Social_Science);
        submit = findViewById(R.id.submitButton);


        //reference to child


        //bg color
        myRelativeLayout= (RelativeLayout) findViewById(R.id.SignUpLayout);
        animationDrawable = (AnimationDrawable) myRelativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                rootNode = FirebaseDatabase.getInstance();

                //specificing the root node in the fire database to store data
                reference = rootNode.getReference("Teacher");


                //get all the values
                String fullname = fullName.getText().toString();
                String password = passWord.getText().toString();
                String emailString = email.getText().toString();

                //gender
                String genderMale = Male.getText().toString();
                String genderFemale = female.getText().toString();

                //subjects
                String Math = math.getText().toString();
                String eng = english.getText().toString();
                String Science = science.getText().toString();
                String ComputerScience = computerScience.getText().toString();
                String SocialScience = socialScience.getText().toString();

                String id = getUserIdBy(fullname,emailString,password);

             if (Male.isChecked() && math.isChecked())
             {
                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,Math,genderMale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else if (Male.isChecked() && english.isChecked())
                 {

                     //instance of class Teacher
                     Teacher teacher = new Teacher(fullname,password,emailString,eng,genderMale);
                     reference.child(id).setValue(teacher);
                     startActivity(new Intent(signUp.this, dashboard_teacher.class));
                     finish();
                 }
             else if (Male.isChecked() && science.isChecked())
             {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,Science,genderMale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }

             else if (Male.isChecked() && computerScience.isChecked())
             {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,ComputerScience,genderMale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else if (Male.isChecked() && socialScience.isChecked()) {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname, password, emailString, SocialScience, genderMale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }


             //if else for male radio button
             else if (female.isChecked() && math.isChecked())
             {
                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,Math,genderFemale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else if (female.isChecked() && english.isChecked())
             {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,eng,genderFemale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else if (female.isChecked() && science.isChecked())
             {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,Science ,genderFemale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }

             else if (female.isChecked() && computerScience.isChecked())
             {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname,password,emailString,ComputerScience ,genderFemale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else if (female.isChecked() && socialScience.isChecked()) {

                 //instance of class Teacher
                 Teacher teacher = new Teacher(fullname, password, emailString,SocialScience, genderFemale);
                 reference.child(id).setValue(teacher);
                 startActivity(new Intent(signUp.this, dashboard_teacher.class));
                 finish();
             }
             else
                 System.out.println("Choose option");
       //instance of class Teacher
               /* Teacher teacher = new Teacher(fullname,password,emailString);
                reference.child(id).setValue(teacher);*/
            }

        });
    }



    //method to assign id to user
    public static String getUserIdBy(String fulltName, String email, String password) {


        String res1 = fulltName.substring(0, 3);
        String res2 = email.isEmpty() ? "0" : email.substring(0, 1);
        String res3 = password.substring(0, 3);
        String res4 = res1 + res2 + res3;
        String res5 = count.toString().length() == 1 ? ("00" + count)
                : count.toString().length() == 2 ? ("0" + count) : count.toString();
        count = count + 1;
        String finalResult = res4 + res5;
        return finalResult;

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