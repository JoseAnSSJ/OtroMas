package com.example.pablo.prueba7.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Activitys.Reportes;
import com.example.pablo.prueba7.Request.Request;

<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/Ejecutar1Fragment.java
import java.util.Date;
import java.util.Iterator;
import java.util.List;
=======
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/Ejecutar1Fragment.java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ejecutar1Fragment extends Fragment {

    Button eject;
    Request request = new Request();
    HorasFragment horas = new HorasFragment();
    int rañoE, rmesE, rdiaE,ra;
    public static LocalTime rini,rfin;
    public static String rhoraIni,rhoraFin, rfecha, fecha_sol="";
    public Ejecutar1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar2, container, false);
<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/Ejecutar1Fragment.java
        eject = view.findViewById(R.id.ejec1);
        hora1I=HorasFragment.reportesselectTime.getText().toString();
        horafin=HorasFragment.reportesselectTime2.getText().toString();
        solution= TrabajosFragment.proble.getText().toString();

=======
        eject = view.findViewById(R.id.ejec);
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/Ejecutar1Fragment.java
        Iterator<List<GetQuejasListResult>> itData = Array.dataReport.iterator();
                    List<GetQuejasListResult> dat =  itData.next();
                    char[] caracteres = dat.get(0).getFechaSoliciutud().toCharArray();
                    fecha_sol="";
                    for(int i=0; i<10; i++){

                        fecha_sol = fecha_sol+caracteres[i];
                    }
        eject.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                ra=0;
                rhoraIni = String.valueOf(horas.reportesselectTime.getText());
                rhoraFin = String.valueOf(horas.reportesselectTime2.getText());
                if(horas.reporteEjecutada==1) {
                    try {
                        rini = LocalTime.parse(rhoraIni);
                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        ra=1;
                    }
                    try {
                        rfin = LocalTime.parse(rhoraFin);
                        ValidacionHoras();
                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        ra=1;
                    }
                    if(ra==0){
                        ValidacionHoras();
                    }
                }
                if(horas.repotteVisita==1){
                    ValidacionVisita();
                }


                

            }
        });



        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ValidacionHoras(){
        String dateEje = String.valueOf(horas.reportesselectDate.getText());
<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/Ejecutar1Fragment.java
       // String visita1 = String.valueOf(horas.reportesselectDate1.getText());
        //String visita2 = String.valueOf(horas.reportesselectDate2.getText());
=======
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/Ejecutar1Fragment.java
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final Calendar c = Calendar.getInstance();
        rañoE = c.get(Calendar.YEAR);
        rmesE = c.get(Calendar.MONTH);
        rdiaE = c.get(Calendar.DAY_OF_MONTH);

        if(rmesE<10){
            rfecha = (rdiaE+1) + "/0" + (rmesE + 1) + "/" + rañoE;
        }else{
            rfecha = (rdiaE+1) + "/" + (rmesE + 1) + "/" + rañoE;
        }
        if(horas.reporteEjecutada==1) {
            try {
                if (sdf.parse(fecha_sol).compareTo(sdf.parse(dateEje))<1)  {
                    if(sdf.parse(rfecha).compareTo(sdf.parse(dateEje))<1){
                        if (rini.isBefore(rfin)) {
<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Fragments/Ejecutar1Fragment.java
                            request.getGuardaHoraReporte(getContext());
                            request.getGuardaCampos(getContext());
                            Intent intent1 = new Intent(getActivity(), Reportes.class);
                            startActivity(intent1);
                            request.getListQuejas();

                            //Toast.makeText(getActivity(), "Hora bien y Fecha bien", Toast.LENGTH_LONG).show();

=======
                            Toast.makeText(getActivity(), "Hora bien y Fecha bien", Toast.LENGTH_LONG).show();
>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/Ejecutar1Fragment.java
                        }
                        if (rini.isAfter(rfin)) {
                            Toast.makeText(getActivity(), "La hora fin no puede der igual o mayor a la hora inicio", Toast.LENGTH_LONG).show();
                        }
                    }else {
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
        String visita1 = String.valueOf(horas.reportesselectDate1.getText());
        String visita2 = String.valueOf(horas.reportesselectDate2.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final Calendar c = Calendar.getInstance();
        rañoE = c.get(Calendar.YEAR);
        rmesE = c.get(Calendar.MONTH);
        rdiaE = c.get(Calendar.DAY_OF_MONTH);

        if(rmesE<10){
            rfecha = (rdiaE+1) + "/0" + (rmesE + 1) + "/" + rañoE;
        }else{
            rfecha = (rdiaE+1) + "/" + (rmesE + 1) + "/" + rañoE;
        }

        if(horas.repotteVisita==1){
            try {
                if (sdf.parse(fecha_sol).compareTo(sdf.parse(visita1))<1) {
                    if (sdf.parse(rfecha).compareTo(sdf.parse(visita1))<1) {
                        Toast.makeText(getActivity(), "Fecha bien Visita", Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(getActivity(), "La fecha de visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "La fecha de visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                }
            }catch (ParseException e){
                Toast.makeText(getActivity(), "VisitaFecha mal", Toast.LENGTH_LONG).show();
            }
        }
        if(horas.reporteVisita1==1){
            try {
                if (sdf.parse(fecha_sol).after(sdf.parse(visita1))) {
                    if (sdf.parse(rfecha).after(sdf.parse(visita1))) {
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
