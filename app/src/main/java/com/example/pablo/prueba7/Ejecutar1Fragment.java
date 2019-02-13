package com.example.pablo.prueba7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pablo.prueba7.Request.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ejecutar1Fragment extends Fragment {

    Button eject;
    Request request = new Request();
    public Ejecutar1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar2, container, false);
        eject = view.findViewById(R.id.ejec);

        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                eject.setEnabled(false);
                

            }
        });



        return view;
    }


}
