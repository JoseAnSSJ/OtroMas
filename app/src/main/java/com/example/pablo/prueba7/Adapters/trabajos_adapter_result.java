package com.example.pablo.prueba7.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Activitys.CambioAparato;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static com.example.pablo.prueba7.Listas.Array.clavex;
import static com.example.pablo.prueba7.Listas.Array.recibixnew;


import static com.example.pablo.prueba7.Services.Services.jsonObject;

public class trabajos_adapter_result extends BaseAdapter {
    private LayoutInflater inflatertrab;
    private Context Cmcontext;
    int trabajo,clv;
    private int Clave,clvTra;
    private boolean stat;
    public static int ClaveTrabajo;
    private boolean ftth=false;
    public static String descr;
    public static boolean rapg =false;
    public static ProgressDialog dialogTrabajos;
    public static JSONArray jsonArrayap = new JSONArray();



    public trabajos_adapter_result(Context context){

        Cmcontext=context;
        inflatertrab=LayoutInflater.from(Cmcontext);
        inflatertrab=LayoutInflater.from(context);
    }
    public class viewHolder{
        TextView trabajo,accion,control;
        CheckBox recibi;
    }
    @Override
    public int getCount() {
        return Array.trabajox.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        Util.preferences = Cmcontext.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        Util.editor = Util.preferences.edit();

        dialogTrabajos= new BarraCargar().showDialog(Cmcontext);
try{
    dialogTrabajos.dismiss();
}catch (Exception e){}
        if (convertView == null) {
            holder = new viewHolder();
            convertView=inflatertrab.inflate(R.layout.recycler_trabajo,null);
            holder.trabajo=(TextView)convertView.findViewById(R.id.tv_Descripcion);
            holder.accion=(TextView)convertView.findViewById(R.id.tv_Accion);
            holder.recibi=(CheckBox)convertView.findViewById(R.id.check_recibi);
            holder.control=(TextView)convertView.findViewById(R.id.click);
            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }
        holder.trabajo.setText(Array.trabajox.get(position));
        holder.accion.setText(Array.accionx.get(position));
        holder.recibi.setChecked(Array.recibix.get(position));
        trabajo = Array.clv_trabajox.get(position);
        clv = Array.clavex.get(position);

        rapg=true;
        holder.recibi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Iterator<List<GetBUSCADetOrdSerListResult>> itData1 = Array.dataTrabajos.iterator();
        List<GetBUSCADetOrdSerListResult> dat1 = (List<GetBUSCADetOrdSerListResult>) itData1.next();
        Util.editor.putInt("Clv",clv);
        Util.editor.putInt("ClvTrabajo", trabajo);
        Util.editor.commit();

        if(holder.recibi.isChecked()){
            dat1.get(position).setSeRealiza(true);
            recibixnew=new ArrayList<>();
            for(int i=0;i<dat1.size();i++){
               recibixnew.add(dat1.get(i).getSeRealiza());
            }
            if (trabajo==1272||trabajo==18||trabajo==1273||trabajo==16||trabajo==1270||trabajo==14||trabajo==1204) {
                Toast.makeText(Cmcontext, "Acción no asignada", Toast.LENGTH_SHORT).show();
                holder.recibi.setChecked(false);
                rapg=false;
            }
        }
    }
});



        holder.control.setOnClickListener(new View.OnClickListener() {
            private int isnet;
            @Override
            public void onClick(View v) {
                isnet=0;


                Request request = new Request();
                if (trabajo==1272) {
                    dialogTrabajos.show();
                    JSONObject jsonObject = new JSONObject();
                    try{
                        jsonObject.put("clv_orden", Util.getClvOrden(Util.preferences));
                    }catch (Exception e){}
                    request.getArbSer(Cmcontext,jsonObject);
                }
                if (trabajo==1270) {
                    dialogTrabajos.show();
                    JSONObject jsonObject = new JSONObject();
                    try{
                        jsonObject.put("clv_orden", Util.getClvOrden(Util.preferences));
                    }catch (Exception e){}
                    request.getArbSer(Cmcontext,jsonObject);
                    isnet=1;
                }
                if (trabajo==1204) {
                    dialogTrabajos.show();
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                     ftth=true;
                    intento.putExtra("ftth", ftth);
                    intento.putExtra("clv",clv);
                    Cmcontext.startActivity(intento);
                }
                if (trabajo==16) {
                    dialogTrabajos.show();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("clv_orden", Util.getClvOrden(Util.preferences));
                        jsonObject.put("Clave", clv);
                    }catch (Exception e){}
                    request.getCAMDO(Cmcontext,jsonObject);
                }
                if (trabajo==1273) {
                    dialogTrabajos.show();
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                    ftth=false;
                    intento.putExtra("ftth",ftth);
                    intento.putExtra("clv",clv);
                    Cmcontext.startActivity(intento);

                }
                if (trabajo==18) {
                    dialogTrabajos.show();
                    JSONObject jsonObject = new JSONObject();
                    try{
                        jsonObject.put("Clave", clv);
                        jsonObject.put("Clv_Orden", Util.getClvOrden(Util.preferences));
                        jsonObject.put("Contrato", DeepConsModel.Contrato);
                    }catch (Exception e){}
                    request.getExtencionesAdicionales(Cmcontext,jsonObject);
                }

            }
        });
        return convertView;
    }
    public void norec(){
        Iterator<List<GetBUSCADetOrdSerListResult>> itData1 = Array.dataTrabajos.iterator();
        List<GetBUSCADetOrdSerListResult> dat1 = (List<GetBUSCADetOrdSerListResult>) itData1.next();
        for(int i=0;i<dat1.size();i++){
        stat=(recibixnew.get(i));
            Clave =Integer.valueOf( clavex.get(i));
            clvTra=Integer.valueOf(Array.clv_trabajox.get(i));
            descr=String.valueOf(Array.trabajox.get(i));

        if (stat==false){
            System.out.println("statusx"+stat);
        try{
            jsonObject = new JSONObject();
            jsonObject.put("Clave", Clave);
            jsonObject.put("Clv_Orden", Util.getClvOrden(Util.preferences));
            jsonObject.put("Clv_Trabajo", clvTra);
            jsonObject.put("Descripcion", descr);
            jsonObject.put("Obs", JSONObject.NULL);
            jsonObject.put("SeRealiza", true);
            jsonObject.put("recibi", stat);
            jsonArrayap.put(jsonObject);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
    }

}
