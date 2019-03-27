package com.example.pablo.prueba7.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;

import java.util.Calendar;



/**
 * A simple {@link Fragment} subclass.
 */
public class EjecutarFragment extends Fragment {

    public static Button reiniciar;
    public static Button eject;
    public static String fechaHoy,horaHoy;
    public static View ejecutar;
    public static TextView msgEjecutarOrd;
    public static int añoE, mesE, diaE,horaE,minutoE;
    private  InstalacionFragment horas = new InstalacionFragment();
    private Request request = new Request();
    public static ProgressDialog dialogEjecutar;
    public EjecutarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        dialogEjecutar= new BarraCargar().showDialog(getContext());

        View view = inflater.inflate(R.layout.fragment_ejecutar, container, false);
        reiniciar = view.findViewById(R.id.restart);
        eject = view.findViewById(R.id.ejec);
        msgEjecutarOrd = view.findViewById(R.id.msgEjecutarOrd);
        ejecutar = view.findViewById(R.id.ejecutarLay);

        reiniciar.setEnabled(false);
if(request.isnet==true){
    ejecutar.setVisibility(View.VISIBLE);
}else{
    ejecutar.setVisibility(View.GONE);
}
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEjecutar.show();
if(request.rapagejecutar==true){
    if (Array.recibixnew.size() == 0) {
        Toast.makeText(getContext(), "Ningun aparato seleccionado", Toast.LENGTH_LONG).show();
        dialogEjecutar.dismiss();
    } else {
        try {
          //  request.send_aparat(getContext());
            //**************************************
         Ejecutar();
            ////////*************************

        } catch (Exception e) {
            Toast.makeText(getContext(), "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
            dialogEjecutar.dismiss();
        }
    }
}else {
Ejecutar();
    ////////*************************
}

                }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogEjecutar.show();
                //request.ReintentarComando(getActivity());
                reiniciar.setEnabled(false);
            }
        });
        return view;
    }
public void Ejecutar(){
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);
    horaE = c.get(Calendar.HOUR);
    minutoE = c.get(Calendar.MINUTE);

    if (horas.ejecutada == 1) {
        fechaHoy = diaE + "/" + mesE + 1 + "/" + añoE;
        horaHoy = horaE + ":" + minutoE;
        eject.setEnabled(false);
       // request.getValidaOrdSer(getActivity());

    }
    if (horas.visita == 1) {

    }
    if (horas.visita1 == 1) {

    }
}

}


