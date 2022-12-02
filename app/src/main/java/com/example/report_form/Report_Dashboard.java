package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class Report_Dashboard extends AppCompatActivity {

    //fire base
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    Button submit,calcute;
    EditText email,sitNum,fullName,math,english,socialScience,computerScience,science,status,percent ,passedSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_report_dashboard);


        ImageView backToTeacher = findViewById(R.id.backToTeacher);

        fullName = findViewById(R.id.name);
        email = findViewById(R.id.emailR);
        sitNum = findViewById(R.id.seatno);
        math = findViewById(R.id.subject1);
        english = findViewById(R.id.subject2);
        science = findViewById(R.id.subject3);
        computerScience = findViewById(R.id.subject4);
        socialScience = findViewById(R.id.subject5);
       status = findViewById(R.id.status);
        //passedSub = findViewById(R.id.passedSubjectTeacher);

        submit = findViewById(R.id.Upload);
        calcute = findViewById(R.id.cal);
        percent = findViewById(R.id.percentage);


        //method to calculate the percentage
        calcute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString();
                String username1= fullName.getText().toString();
                String sitNumber=sitNum.getText().toString();
                String subjec1=math.getText().toString();
                String subjec2=english.getText().toString();
                String subjec3=science.getText().toString();
                String subjec4=computerScience.getText().toString();
                String subjec5=socialScience.getText().toString();
                String stringPassedSubject = passedSub.getText().toString();
                if(!TextUtils.isEmpty(email1)&&
                        !TextUtils.isEmpty(username1)
                        &&!TextUtils.isEmpty(sitNumber)
                        &&!TextUtils.isEmpty(subjec1)
                        &&!TextUtils.isEmpty(subjec2)
                        &&!TextUtils.isEmpty(subjec3)
                        &&!TextUtils.isEmpty(subjec4)
                        &&!TextUtils.isEmpty(subjec5)) {
                    calculatepercentage();

                }
                else{
                    Toast.makeText(Report_Dashboard.this, "Please Enter info in all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //on click listener to upload data
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();

                //specificing the root node in the fire database to store data
                reference = rootNode.getReference("Results");


                //get all the values
                String fullname = fullName.getText().toString();
                String emailString = email.getText().toString();
                String sitNumber = sitNum.getText().toString();
                String statusString = status.getText().toString();
                String percentage = percent.getText().toString();

                //subjects
                String Math = math.getText().toString();
                String eng = english.getText().toString();
                String Science = science.getText().toString();
                String ComputerScience = computerScience.getText().toString();
                String SocialScience = socialScience.getText().toString();

                Student student = new Student(fullname,emailString,sitNumber,Math,eng,Science,ComputerScience,SocialScience,statusString,percentage);
                reference.child(sitNumber).setValue(student);
                Toast.makeText(Report_Dashboard.this, "Data Upload into the database", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        backToTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),dashboard_teacher.class);
                startActivity(intent);
            }
        });
    }


    //method to calculate percentage

    private void calculatepercentage() {
        double sub1= Double.parseDouble(math.getText().toString());
        double sub2= Double.parseDouble(english.getText().toString());
        double sub3= Double.parseDouble(science.getText().toString());
        double sub4= Double.parseDouble(computerScience.getText().toString());
        double sub5= Double.parseDouble(socialScience.getText().toString());

        double total=((sub1+sub2+sub3+sub4+sub5)/500)*100;

        String decimalFormat=new DecimalFormat("##.##").format(total);
        percent.setText(decimalFormat+"%");


        if(sub1<40||sub2<40||sub3<40||sub4<40||sub5<40){
            status.setText("passed");
        }
        else{

           status.setText("fail");

        }

    }



}