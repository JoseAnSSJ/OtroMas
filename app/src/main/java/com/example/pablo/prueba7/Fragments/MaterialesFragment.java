package com.example.pablo.prueba7.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pablo.prueba7.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialesFragment extends Fragment {


    public MaterialesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_materiales, container, false);

        return view;
    }

}
