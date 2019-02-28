package com.example.pablo.prueba7.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pablo.prueba7.R;

public class Materiales extends Fragment {

    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        super.onActivityCreated(onSaveInstanceState);
        rootView = inflater.inflate(R.layout.activity_descarga, container, false);
        return rootView;
    }
}
