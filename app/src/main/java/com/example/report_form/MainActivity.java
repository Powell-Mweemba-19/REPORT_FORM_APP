package com.example.report_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button loginB;

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

        setContentView(R.layout.activity_main);
   TextView signUp = findViewById(R.id.signUp);


        //edit text input

        inputEmail = findViewById(R.id.EmailLogin);
        inputPassword = findViewById(R.id.passwordLogin);
        loginB = findViewById(R.id.loginButton);
        progressDialog = new ProgressDialog(this);
ImageView google = findViewById(R.id.google);
        ImageView twitter = findViewById(R.id.twitter);
        ImageView facebook = findViewById(R.id.facebook);

        //fire base linking
        mAuth =FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();



        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ulr ="https://www.google.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ulr));
                startActivity(i);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ulr ="https://www.twitter.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ulr));
                startActivity(i);
            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ulr ="https://www.facebook.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ulr));
                startActivity(i);
            }
        });
        // main activity buttons



        //on click listen for the main activity to link with the login activities

loginB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //method to perform login

        performLogin();
       /*Intent intent = new Intent(view.getContext(),Report_Dashboard.class);
        startActivity(intent);
*/

    }
});



//sign up   on click listener to direct you to the sign up page for teacher
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),StudentSignUp.class);
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






    //checking if user exits in data base



    // method to perform login for student
    private void performLogin() {

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
            progressDialog.setMessage("Please wait while Login.....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
//
//                        //firebase reference
//                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");
//
//                        //querying for email and password in firebase
//                        Query checkUser = reference.orderByChild("email").equalTo(email);
//
//                        //searching for user name with specific password
//                        String passWordFromDB = snapshot.child(email).child("password").getValue(String.class);
//
//                        if(passWordFromDB.equals(password))
//                        {
//
//                            inputEmail.setError(null);
//                            inputEmail.setEnabled(false);
//
//                            //get the fields form database and display it to another intent
//                            String fullNameFromDB = snapshot.child(email).child("fullName").getValue(String.class);
//                            // String emailFromDB = snapshot.child(userEnteredEmail).child("email").getValue(String.class);
//                            String subjectFromDB = snapshot.child(email).child("subject").getValue(String.class);
//                            String idFromDB = snapshot.child(email).child("id").getValue(String.class);
//
//
//
//
//                            Intent intent = new Intent(getApplicationContext(),dashboard_teacher.class);
//
//                            //getting values from the database and passing them to the next intent
//                            intent.putExtra("id",idFromDB);
//                            intent.putExtra("fullName",fullNameFromDB);
//                            intent.putExtra("subject",subjectFromDB );
//
//                            startActivity(intent);
//                        }
//                        else if(!passWordFromDB.equals(email))
//                        {
//                            inputPassword.setError("Wrong Password");
//                            //pointing on specific field
//                            inputPassword.requestFocus();
//                        }
                            //opening new activity
                            sendUserToNextActivity();


                        Toast.makeText(MainActivity.this, "Successfully Login!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }


}

 /*  private void isUser() {

        String userEnteredEmail = inputEmail.getText().toString();
        String userEnteredPassword = inputPassword.getText().toString();

        //firebase reference
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");

        //querying for email and password in firebase
        Query checkUser = reference.orderByChild("email").equalTo(userEnteredEmail);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //checking if user exits
                if (snapshot.exists())
                {
                    //email

                    //searching for user name with specific password
                    String passWordFromDB = snapshot.child(userEnteredPassword).child("password").getValue(String.class);

                    if(passWordFromDB.equals(userEnteredPassword))
                    {

                        inputEmail.setError(null);
                        inputEmail.setEnabled(false);

                        //get the fields form database and display it to another intent
                        String fullNameFromDB = snapshot.child(userEnteredEmail).child("fullName").getValue(String.class);
                        // String emailFromDB = snapshot.child(userEnteredEmail).child("email").getValue(String.class);
                        String subjectFromDB = snapshot.child(userEnteredEmail).child("subject").getValue(String.class);
                        String idFromDB = snapshot.child(userEnteredEmail).child("id").getValue(String.class);




                        Intent intent = new Intent(getApplicationContext(),dashboard_teacher.class);

                        //getting values from the database and passing them to the next intent
                        intent.putExtra("id",idFromDB);
                        intent.putExtra("fullName",fullNameFromDB);
                        intent.putExtra("subject",subjectFromDB );

                        startActivity(intent);
                    }
                    else
                    {
                        inputPassword.setError("Wrong Password");
                        //pointing on specific field
                        inputPassword.requestFocus();
                    }
                }
                else
                {
                    inputEmail.setError("User does not Exits");
                    Toast.makeText(MainActivity.this,"User Does not not exits",Toast.LENGTH_SHORT).show();
                    //pointing on specific field
                    inputEmail.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }*/


    ///validating user teacher email
  /*  private boolean validateUsername() {
        String val = inputEmail.getText().toString();

        if(val.isEmpty())
        {
            inputEmail.setError("Field can not be empty");
            return false;
        }
        else
        {
            inputEmail.setError(null);
            return true;
        }
    }

    //validating password
    private boolean validatePassword() {
        String val = inputEmail.getText().toString();

        if(val.isEmpty())
        {
            inputEmail.setError("Field can not be empty");
            return false;
        }
        else
        {
            inputEmail.setError(null);
            return true;
        }
    }
    //login user teacher
    public void loginUser(View view)
    {

        //validating login
        if(!validateUsername() | !validatePassword())
        {
            return;
        }
        else
        {
            isUser();
        }
    }

*/
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

    //sending the user to new activity once verified
    private void sendUserToNextActivity() {


        startActivity(new Intent(MainActivity.this, dashboard_teacher.class));
        finish();
    }
    }