package com.example.report_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class remove_Teacher_Pupil extends Fragment {

    //name to be used on the drop down
    String[] profession = {"Teacher","Pupil"};
    AutoCompleteTextView auto_Complete;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view =  inflater.inflate(R.layout.fragment_remove__teacher__pupil, container, false);

        auto_Complete =  view.findViewById(R.id.autoCompletePro);

        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(getActivity(),androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, profession);
        auto_Complete.setAdapter(adapterItems);

        auto_Complete.setAdapter(adapterItems);
        // Inflate the layout for this fragment
        return view;
    }
}