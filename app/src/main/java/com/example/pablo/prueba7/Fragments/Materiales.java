package com.example.pablo.prueba7.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pablo.prueba7.R;

public class Materiales extends Fragment {

    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle onsavedInstanceState;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        super.onActivityCreated(onSaveInstanceState);
        View view = inflater.inflate(R.layout.activity_descarga, container, false);
        return view;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle OnsavedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        onsavedInstanceState = OnsavedInstanceState;
        super.onCreate(OnsavedInstanceState);
        View view  = inflater.inflate(R.layout.activity_descarga, container, false);


        return view;
    }
}
