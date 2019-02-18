package com.example.pablo.prueba7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMUESTRATRABAJOSQUEJASListResult;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.clvReport;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ejecutar1Fragment extends Fragment {

    Button eject;
    Request request = new Request();
    Array array = new Array();
    public static JSONObject jsonObject1 = new JSONObject();
    public static JSONObject jsonObject2 = new JSONObject();



    public static JSONArray jsonArray1 = new JSONArray();
    public static  String selectD;
    public static  String selectD1;
    public static  String selectD2;
    public static  String selectD3;
    public static  String selectT;
    public static  String selectT2;
    public static  String probm;
    public static  String Spin;






    public static JSONObject jsonObject3 = new JSONObject();
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
                processScreen();


                try {
                    jsonObject1.put("Clv_Queja", clvReport);
                     jsonObject1.put("Fecha_Ejecucion", selectD);
                     jsonObject1.put("TipoSolucion", Spin);
                     jsonObject1.put("Solucion", probm);
                     jsonObject1.put("Solucion", probm);
                     jsonObject2.put("Fecha_Ejecucion",selectT2);
                     jsonObject2.put("Fecha_Ejecucion",selectT);




                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    jsonObject2.put("Clave", clvReport);
                    jsonObject2.put("HoraFin",selectT2);
                    jsonObject2.put("HoraIni",selectT);
                    jsonObject2.put("HoraIni",selectT);

                } catch (JSONException e) {
                    e.printStackTrace();
                }






            }



        });



        return view;
    }

    public void processScreen() {
          selectD = HorasFragment.selectDate.getText().toString();
          selectD1=HorasFragment.selectDate1.getText().toString();
          selectD2=HorasFragment.selectDate2.getText().toString();
          selectD3=HorasFragment.selectDate3.getText().toString();
          selectT=HorasFragment.selectTime.getText().toString();
          selectT2=HorasFragment.selectTime2.getText().toString();
          probm= TrabajosFragment.problemReal.getText().toString();
          Spin= String.valueOf(TrabajosFragment.solucion.getSelectedItem());

    }


}
