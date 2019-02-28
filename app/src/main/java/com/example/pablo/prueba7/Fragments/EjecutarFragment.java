package com.example.pablo.prueba7.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Fragments.InstalacionFragment;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.Services.Services;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/EjecutarFragment.java
import static com.example.pablo.prueba7.Listas.Array.recibixnew;
=======
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/EjecutarFragment.java


/**
 * A simple {@link Fragment} subclass.
 */
public class EjecutarFragment extends Fragment {

    public static Button reiniciar;
    public static Button eject;
<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/EjecutarFragment.java
=======

>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/EjecutarFragment.java
    EditText edt1;
    public static TextView msgEjecutarOrd;
    int añoE, mesE, diaE,a;
    public static LocalTime ini,fin;
    InstalacionFragment horas = new InstalacionFragment();
    public static String horaIni,horaFin, fecha;
    Request request = new Request();
    public EjecutarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        // Inflate the layout for this fragment
        super.onActivityCreated(onSaveInstanceState);
        View view = inflater.inflate(R.layout.fragment_ejecutar, container, false);
        reiniciar = view.findViewById(R.id.restart);
        eject = view.findViewById(R.id.ejec);
        msgEjecutarOrd = view.findViewById(R.id.msgEjecutarOrd);

        reiniciar.setEnabled(false);

        eject.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(recibixnew.size()==0){
                    Toast.makeText(getContext(), "Ningun aparato seleccionado", Toast.LENGTH_LONG).show();
                }else{
                    request.send_aparat();
                }


a=0;
                horaIni = String.valueOf(horas.selectTime.getText());
                horaFin = String.valueOf(horas.selectTime2.getText());
                if(horas.ejecutada==1) {
                    try {
                        ini = LocalTime.parse(horaIni);
                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        a=1;
                    }
                    try {
                        fin = LocalTime.parse(horaFin);

                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        a=1;
                    }
                    if(a==0){
                        ValidacionHoras();
                    }
                }
                if(horas.visita==1){
                    ValidacionVisita();
                }
                reiniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        request.ReintentarComando(getActivity());
                        reiniciar.setEnabled(false);
                    }
                });


            }
        });
        return view;
    }
<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/EjecutarFragment.java
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ValidacionHoras(){
        String dateEje = String.valueOf(horas.selectDate.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final Calendar c = Calendar.getInstance();
        añoE = c.get(Calendar.YEAR);
        mesE = c.get(Calendar.MONTH);
        diaE = c.get(Calendar.DAY_OF_MONTH);

        if(mesE<10){
            fecha = (diaE) + "/0" + (mesE + 1) + "/" + añoE;
        }else{
            fecha = (diaE) + "/" + (mesE + 1) + "/" + añoE;
        }
        if(horas.ejecutada==1) {
            try {
                if (sdf.parse(DeepConsModel.Fec_Sol).compareTo(sdf.parse(dateEje))<1) {
                    if(sdf.parse(fecha).compareTo(sdf.parse(dateEje))<1){
                        if (ini.isBefore(fin)) {
                            eject.setEnabled(false);
                            request.getValidaOrdSer(getActivity());
                        }
                        if (ini.isAfter(fin)) {
                            Toast.makeText(getActivity(), "La hora fin no puede der igual o mayor a la hora inicio", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                } else {
=======
@RequiresApi(api = Build.VERSION_CODES.O)
public void ValidacionHoras(){
    String dateEje = String.valueOf(horas.selectDate.getText());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);

    if(mesE<10){
        fecha = (diaE) + "/0" + (mesE + 1) + "/" + añoE;
    }else{
        fecha = (diaE) + "/" + (mesE + 1) + "/" + añoE;
    }
    if(horas.ejecutada==1) {
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).compareTo(sdf.parse(dateEje))<1) {
                if(sdf.parse(fecha).compareTo(sdf.parse(dateEje))<1){
                    if (ini.isBefore(fin)) {
                        eject.setEnabled(false);
                           request.getValidaOrdSer(getActivity());
                    }
                    if (ini.isAfter(fin)) {
                        Toast.makeText(getActivity(), "La hora fin no puede der igual o mayor a la hora inicio", Toast.LENGTH_LONG).show();
                    }
                }else {
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/EjecutarFragment.java
                    Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
            }
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
        }
    }

}
@RequiresApi(api = Build.VERSION_CODES.O)
public void ValidacionVisita(){
    String visita1 = String.valueOf(horas.selectDate1.getText());
    String visita2 = String.valueOf(horas.selectDate2.getText());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);

    if(mesE<10){
        fecha = (diaE+1) + "/0" + (mesE + 1) + "/" + añoE;
    }else{
        fecha = (diaE+1) + "/" + (mesE + 1) + "/" + añoE;
    }

    if(horas.visita==1){
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).before(sdf.parse(visita1))) {
                if (sdf.parse(fecha).after(sdf.parse(visita1))) {
                    Toast.makeText(getActivity(), "Fecha bien Visita", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getActivity(), "La fecha de visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(getActivity(), "La fecha de visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
            }
        }catch (ParseException e){
            Toast.makeText(getActivity(), "VisitaFecha mal"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    if(horas.visita1==1){
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).after(sdf.parse(visita1))) {
                if (sdf.parse(fecha).after(sdf.parse(visita1))) {
                    if(sdf.parse(visita1).after(sdf.parse(visita2))){
                        Toast.makeText(getActivity(), "Fecha bienV", Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(getActivity(), "La fecha de visita 2 no puede ser menor a la fecha de visita 1 ni mayor a la fecha actual", Toast.LENGTH_LONG).show();
                }
            }
        }catch (ParseException e){
            Toast.makeText(getActivity(), "Fecha mal, visita", Toast.LENGTH_LONG).show();
        }
    }

}
}