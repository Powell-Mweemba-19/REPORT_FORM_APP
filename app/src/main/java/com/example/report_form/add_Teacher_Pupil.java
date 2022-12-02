package com.example.report_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * POWELL MWEEMBA CREATED ON 21 SEP 2022
 * A simple {@link Fragment} subclass.
 * Use the {@link //add_Teacher_Pupil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add_Teacher_Pupil extends Fragment {

    //Button for add pupil and teacher
    // private Button add_teacher, add_pupil;

 /* // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public add_Teacher_Pupil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment add_Teacher_Pupil.
     */
    // TODO: Rename and change types and number of parameters
   /* public static add_Teacher_Pupil newInstance(String param1, String param2) {
        add_Teacher_Pupil fragment = new add_Teacher_Pupil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    */
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add__teacher__pupil, container, false);


        /*
           The add_teacher and the add_pupil onclick listener will display a toast message to the admin once the data has been uploaded into the database
         */


        // function will be adding pupils to the database once the button has been clicked
        Button add_teacher = view.findViewById(R.id.addTeachers);

        add_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Teachers added", Toast.LENGTH_SHORT).show();
            }
        });


        // function will be adding pupils to the database once the button has been clicked
        Button add_pupil = view.findViewById(R.id.addPupils);

        add_pupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Pupils Added", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


}