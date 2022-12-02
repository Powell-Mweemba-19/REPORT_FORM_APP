package com.example.report_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Report_card extends AppCompatActivity {

    EditText getSitNo;
    Button searchResults;
    ImageView back;
    TextView computerScienceMark, passedSub,mathMarks, englishMarks, scienceMarks, socialScienceMarks, computerScienceMarks, percent, comment;
    DatabaseReference reference;

    // creating a variable for 
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our 
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_report_card);

        getSitNo = findViewById(R.id.getNo);
        searchResults = findViewById(R.id.searchButton);
        back = findViewById(R.id.back);

        mathMarks = findViewById(R.id.math_marks);
        englishMarks = findViewById(R.id.english_marks);
        scienceMarks = findViewById(R.id.science_marks);
        socialScienceMarks = findViewById(R.id.social_science_marks);
        computerScienceMarks = findViewById(R.id.computer_studies_marks);
        percent = findViewById(R.id.percentage);
        comment = findViewById(R.id.comment);
       // passedSub = findViewById(R.id.passedSubject);





        // calling method
        // for getting data.


        searchResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String sitnum = getSitNo.getText().toString();

                    //getdata();
                    //studentQuary();

                    reference = FirebaseDatabase.getInstance().getReference().child("Results").child(sitnum);


                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.exists()) {

                                if (!sitnum.isEmpty()) {
                                    Toast.makeText(Report_card.this, "Successfully Read", Toast.LENGTH_SHORT).show();
                                    String math = snapshot.child("math").getValue().toString();
                                    String englishString = snapshot.child("english").getValue().toString();
                                    String scienceString = snapshot.child("science").getValue().toString();
                                    String socialScienceString = snapshot.child("social").getValue().toString();
                                    String computerScienceString = snapshot.child("computer").getValue().toString();
                                    String commentString = snapshot.child("status").getValue().toString();
                                    String percentageString = snapshot.child("percentage").getValue().toString();


                                    mathMarks.setText(math + "%");
                                    englishMarks.setText(englishString + "%");
                                    scienceMarks.setText(scienceString + "%");
                                    socialScienceMarks.setText(socialScienceString + "%");
                                    computerScienceMarks.setText(computerScienceString + "%");
                                    comment.setText(commentString);
                                    percent.setText(percentageString);


                                    int sub1 = Integer.parseInt(math);

                                    int[] Subject = new int[] {sub1};
                                    for(int x = 0; x >5; x++)
                                    {
                                        int count = 0;
                                        if(Subject[x] > 39)
                                        {
                                            count++;
                                        }
                                        passedSub.setText(count);
                                    }
                                }
                                else
                                {
                                    Toast.makeText(Report_card.this, "Please Enter ID number", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else
                            {
                                Toast.makeText(Report_card.this, "No Student found with such Details", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Report_card.this, "Please Enter ID number", Toast.LENGTH_SHORT).show();
                        }
                    });



            }
        });




    /*    searchResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sitNo = getSitNo.getText().toString();

                if (!sitNo.isEmpty()) {
                    //isUser(sitNo);
                } else {
                    Toast.makeText(Report_card.this, "Please Enter Sit number", Toast.LENGTH_SHORT).show();

                }
            }
        });*/

      back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),StudentDashBoard.class);
                startActivity(intent);
            }
        });

    }

   /* private void getdata() {


        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("Results");

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                mathMarks.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
*/
  /*  //quering for results form database
    private void studentQuary() {

     String studentNum = getSitNo.getText().toString();

     reference = FirebaseDatabase.getInstance().getReference("Results");


     Query checkStudent = reference.orderByChild("sitNumb").equalTo(studentNum);

     checkStudent.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {

             if (snapshot.exists())
             {

                 String idFromDB = snapshot.child(studentNum).child("sitNumb").getValue(String.class);

                 if(idFromDB.equals(studentNum)) {


                     String Mathematics = snapshot.child(studentNum).child("math").getValue(String.class);
                     String english = snapshot.child(studentNum).child("english").getValue(String.class);
                     String science = snapshot.child(studentNum).child("science").getValue(String.class);
                     String socialScience = snapshot.child(studentNum).child("social").getValue(String.class);
                     String computerScience = snapshot.child(studentNum).child("computer").getValue(String.class);
                     String percentage= snapshot.child(studentNum).child("percentage").getValue(String.class);
                     String staTus= snapshot.child(studentNum).child("status").getValue(String.class);

                     String eng = String.valueOf(snapshot.child("english"));
                     String Science = String.valueOf(snapshot.child("science"));
                     String social= String.valueOf(snapshot.child("social"));
                     String computer = String.valueOf(snapshot.child("computer"));


                     computerScienceMark.setText(eng);
                      mathMarks.setText(Science);
                     englishMarks.setText(social);
                     scienceMarks.setText(computer);


Toast.makeText(Report_card.this, "Successfully Read", Toast.LENGTH_SHORT).show();

                 }
             }
             else
             {
                 Toast.makeText(Report_card.this, "Failed to Read", Toast.LENGTH_SHORT).show();
             }
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
     }); */


}

