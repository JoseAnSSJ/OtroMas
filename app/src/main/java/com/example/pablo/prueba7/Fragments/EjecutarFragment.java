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
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Calendar;

import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.jsonArrayap;


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
        dialogEjecutar.show();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("objSP_InsertaTbl_NoEntregados",jsonArrayap);
            request.send_aparat(getContext(),jsonObject);
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
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("contrato", DeepConsModel.Contrato);
                }catch (Exception e){}
                request.ReintentarComando(getActivity(),jsonObject);
                reiniciar.setEnabled(false);
            }
        });
        return view;
    }
public void Ejecutar(){
    String ab = "";
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);
    horaE = c.get(Calendar.HOUR);
    minutoE = c.get(Calendar.MINUTE);
    if (mesE < 10) {
        ab = "0" + mesE;
    } else {
        ab = String.valueOf(mesE);
    }
    String s = diaE + "-" + ab + "-" + +añoE;
    JSONObject jsonObject = new JSONObject();
    try{
        jsonObject.put("CLV_ORDEN", Util.getClvOrden(Util.preferences));
        jsonObject.put("Clv_Tecnico", Util.getClvTecnico(Util.preferences));
        jsonObject.put("OP2", 0);
        jsonObject.put("OPCION", "M");
        jsonObject.put("STATUS", HorasFragment.statusHora);
    }catch (Exception e){}
    fechaHoy = diaE + "/" + mesE + 1 + "/" + añoE;
    horaHoy = horaE + ":" + minutoE;
    eject.setEnabled(false);
    if (horas.ejecutada == 1) {
             request.getValidaOrdSer(getActivity(),jsonObject,DeepModoRSER("","",s));
    }
    if (horas.visita == 1) {
        request.getValidaOrdSer(getActivity(),jsonObject,DeepModoRSER(fechaHoy,"",""));
    }
    if (horas.visita1 == 1) {
        request.getValidaOrdSer(getActivity(),jsonObject,DeepModoRSER(DeepConsModel.Visita1,fechaHoy,""));
    }
}
public JSONObject DeepModoRSER(String v1,String v2,String eje){
        JSONObject jsonMordSer = new JSONObject();
    try {
        jsonMordSer.put("ClvFactura", DeepConsModel.Clv_FACTURA);
        jsonMordSer.put("ClvOrden", Util.getClvOrden(Util.preferences));
        jsonMordSer.put("ClvTecnico", Util.getClvTecnico(Util.preferences));
        jsonMordSer.put("ClvTipSer", DeepConsModel.Clv_TipSer);
        jsonMordSer.put("Contrato", DeepConsModel.Contrato);
        jsonMordSer.put("FecEje", eje);
        jsonMordSer.put("FecSol", DeepConsModel.Fec_Sol);
        jsonMordSer.put("Impresa", 1);
        jsonMordSer.put("ListadeArticulos", "");
        jsonMordSer.put("Obs", DeepConsModel.Obs);
        jsonMordSer.put("Status", HorasFragment.statusHora);
        jsonMordSer.put("TecnicoCuadrilla", InstalacionFragment.TecSecSelecc);
        jsonMordSer.put("Visita1", v1);
        jsonMordSer.put("Visita2", v2);
    }catch (Exception e){}
        return jsonMordSer;
}
}


