package com.example.report_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentSignUp extends AppCompatActivity {


    // used in the  background animations
    private RelativeLayout myRelativeLayout;
    private AnimationDrawable animationDrawable;



    //input edit text
    EditText inputEmail, inputPassword;
    Button submit;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    //instance of the firebase
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_student_sign_up);


        //edit text input

        inputEmail = findViewById(R.id.Email);
        inputPassword = findViewById(R.id.signUpPasswordEdit);
        submit = findViewById(R.id.loginButton);
        progressDialog = new ProgressDialog(this);

        //fire base linking
        mAuth =FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        //bg color
        myRelativeLayout= (RelativeLayout) findViewById(R.id.StudentSignUpLayout);
        animationDrawable = (AnimationDrawable) myRelativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();


        //submit function
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PerformAuth();
            }
        });
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

    ////function to validate the input
    private void PerformAuth()
    {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();


        if(!email.matches(emailPattern))
        {
            inputEmail.setError("Enter valid Email");
        }
        else if(password.isEmpty() || password.length()<6)
        {
            inputPassword.setError("invalid PassWord!!");
        }
        else
        {
            progressDialog.setMessage("Please wait while Loading.....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            //creating user
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        //opening new activity
                        sendUserToNextActivity();
                        Toast.makeText(StudentSignUp.this, "Successfully Signed Up!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(StudentSignUp.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    //sending the user to new activity once verified
    private void sendUserToNextActivity() {


        startActivity(new Intent(StudentSignUp.this, dashboard_teacher.class));
        finish();
    }

}