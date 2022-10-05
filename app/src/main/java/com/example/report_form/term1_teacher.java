package com.example.report_form;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class term1_teacher extends Fragment {
/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public term1_teacher() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment term1_teacher.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static term1_teacher newInstance(String param1, String param2) {
        term1_teacher fragment = new term1_teacher();
        Bundle args = new Bundle();
      //  args.putString(ARG_PARAM1, param1);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_term1_teacher, container, false);
        // Inflate the layout for this fragment


       //term 1 link to subject activity

        Button term1 = view.findViewById(R.id.buttonTerm1Teacher);

        term1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(),Subjects.class);
                startActivity(intent);
            }
        });

//term 2 link to subject activity
        Button term2 = view.findViewById(R.id.buttonTerm2Teacher);

        term2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(),Subjects.class);
                startActivity(intent);
            }
        });



        //term 3 link to subject activity
        Button term3 = view.findViewById(R.id.buttonTerm3Teacher);

        term3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(),Subjects.class);
                startActivity(intent);
            }
        });

        return view;
    }
}