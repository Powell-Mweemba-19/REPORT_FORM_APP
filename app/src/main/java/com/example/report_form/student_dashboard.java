package com.example.report_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;

public class student_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //code to remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_dashbord);

        final DrawerLayout studentLayout = findViewById(R.id.studentLayout);

        // code to open the side bar/ side menu
     /*   findViewById(R.id.imageViewStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentLayout.openDrawer(GravityCompat.START);
            }
        });*/

        // displaying icons
      /*  NavigationView navigationView = findViewById(R.id.navigaionView);
      * navigationView.setItemIconTintList(null);

*/
        //intent
        //Intent intent = new Intent(navigationView.getContext(),Admin_Dashbord.class);
        //startActivity(intent);
        // opening navigation icons once clicked

        NavController navController = Navigation.findNavController(this, R.id.naviHostFragement);
        //findNavController(R.id.myNavHostFragment).navigate(R.id.to_someFragment)


        // this is the error code if opened it the app we force c;ose
      //  NavigationUI.setupWithNavController(navigationView, navController);

    }


}