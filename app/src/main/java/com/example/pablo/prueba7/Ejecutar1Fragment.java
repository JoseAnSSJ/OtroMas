package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;

import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.clvReport;
import static com.example.pablo.prueba7.Services.Services.clavequeja;
import static com.example.pablo.prueba7.Services.Services.opcion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


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
    public static String hora1I, horafin,solution;
    public static Date datetime;
    public Ejecutar1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar2, container, false);
        eject = view.findViewById(R.id.ejec);
        hora1I=HorasFragment.reportesselectTime.getText().toString();
        horafin=HorasFragment.reportesselectTime2.getText().toString();
        solution=TrabajosFragment.proble.getText().toString();

        Iterator<List<GetQuejasListResult>> itData = Array.dataReport.iterator();
        List<GetQuejasListResult> dat = (List<GetQuejasListResult>) itData.next();
        char[] caracteres = dat.get(0).getFechaSoliciutud().toCharArray();
        fecha_sol="";
        for(int i=0; i<10; i++){

            fecha_sol = fecha_sol+caracteres[i];
        }

        eject.setOnClickListener(new View.OnClickListener() {




            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                request.getGuardaHoraReporte(getContext());
                request.getGuardaCampos(getContext());
                Intent intent1 = new Intent(getActivity(), Reportes.class);
                request.getListQuejas();
                startActivity(intent1);



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
        if(horas.reporteEjecutada==1) {
            try {
                if (sdf.parse(fecha_sol).before(sdf.parse(dateEje))) {
                    if(sdf.parse(rfecha).after(sdf.parse(dateEje))){
                        if (rini.isBefore(rfin)) {
                            //Toast.makeText(getActivity(), "Hora bien y Fecha bien", Toast.LENGTH_LONG).show();

                        }
                        if (rini.isAfter(rfin)) {
                            Toast.makeText(getActivity(), "La hora fin no puede der igual o mayor a la hora inicio", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                } else {
                    //  (sdf.parse(DeepConsModel.Fec_Sol).before(sdf.parse(dateEje)))
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
                if (sdf.parse(fecha_sol).before(sdf.parse(visita1))) {
                    if (sdf.parse(rfecha).after(sdf.parse(visita1))) {
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
