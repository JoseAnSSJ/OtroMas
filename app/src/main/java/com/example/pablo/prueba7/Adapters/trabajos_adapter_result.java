package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.widget.TextView;
import android.widget.Toast;


import com.example.pablo.prueba7.CambioAparato;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Orden;
import com.example.pablo.prueba7.Post.RecibiAparato;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Listas.Array.clavex;


import static com.example.pablo.prueba7.Listas.Array.recibix;
import static com.example.pablo.prueba7.Listas.Array.recibixnew;
import static com.example.pablo.prueba7.Post.RecibiAparato.jsonArrayap;
import static com.example.pablo.prueba7.Post.RecibiAparato.jsonObject;
import static com.example.pablo.prueba7.asignacion.jsonObject2;
import static java.util.Arrays.asList;


public class trabajos_adapter_result extends BaseAdapter {

    LayoutInflater inflatertrab;
    Context Cmcontext;

    ArrayList<String>trabajox;
    ArrayList<String>accionx;
    ArrayList<Boolean>recibix;
    public static int Clave, isnet,clvTra;
    public static  int lugar,co;
    public static boolean stat,statx;


    Request request = new Request();
    RecibiAparato RA =new RecibiAparato();
    //public static Boolean[]recib=new Boolean[Array.accionx.size()];
    public static String descr;
    public static int cont=0;
    RecibiAparato Ra =new RecibiAparato();

    public trabajos_adapter_result(Context context, ArrayList<String>trabajox, ArrayList<String>accionx,ArrayList<Boolean>recibix){
        this.trabajox=trabajox;
        this.accionx=accionx;
        this.recibix=recibix;
        Cmcontext=context;
        inflatertrab=LayoutInflater.from(Cmcontext);
        inflatertrab=LayoutInflater.from(context);
    }

    public class viewHolder{
        TextView trabajo;
        Button accion;

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
        lugar=position;
        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflatertrab.inflate(R.layout.list_trabajos_items,null);


            holder.trabajo=(TextView)convertView.findViewById(R.id.trabajov);
            holder.accion=(Button)convertView.findViewById(R.id.accionv);
            holder.recibi=(CheckBox)convertView.findViewById(R.id.recibiap);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.trabajo.setText(Array.trabajox.get(position));
        holder.accion.setText(Array.accionx.get(position));
        holder.recibi.setChecked(Array.recibix.get(position));

        ClaveTrabajo = Array.clavex.get(position);


        /////////////
       // clvor = Integer.valueOf(Array.ordensrc.get(position));

holder.recibi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Iterator<List<GetBUSCADetOrdSerListResult>> itData1 = Array.dataTrabajos.iterator();
        List<GetBUSCADetOrdSerListResult> dat1 = (List<GetBUSCADetOrdSerListResult>) itData1.next();

        if(holder.recibi.isChecked()){
            dat1.get(position).setSeRealiza(true);
            recibixnew=new ArrayList<>();
            for(int i=0;i<dat1.size();i++){
               recibixnew.add(dat1.get(i).getSeRealiza());
            }

            if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISTVA - Instalación de Servicio de TV")
                    ||(holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CONEX - Contratación De Extensión")
                    ||(holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAT - Cambio De Tipo De Aparato")
                    ||(holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAMDO - Cambio De Domicilio")
                    ||(holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISNET - Instalación de Servicio de Internet")
                    ||(holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAG - Cambio de tipo de aparato  FTTH")) {
                Toast.makeText(Cmcontext, "Acción no asignada", Toast.LENGTH_SHORT).show();
                holder.recibi.setChecked(false);
            }
        }
    }
});





        ///////////
        holder.accion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                isnet=0;

                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISNET - Instalación de Servicio de Internet")) {

                    request.getArbSer(Cmcontext);
                    isnet=1;
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();

                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAG - Cambio de tipo de aparato  FTTH")) {
                    holder.recibi.setChecked(false);
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                    Cmcontext.startActivity(intento);
                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAMDO - Cambio De Domicilio")) {
                    holder.recibi.setChecked(false);
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();
                    request.getCAMDO(Cmcontext);

                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAT - Cambio De Tipo De Aparato")) {
                    holder.recibi.setChecked(false);
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                    Cmcontext.startActivity(intento);
                   // request.getDeepCAPAT(Cmcontext);


                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CONEX - Contratación De Extensión")) {
                    holder.recibi.setChecked(false);
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();
                    request.getExtencionesAdicionales(Cmcontext);



                if ((holder.accion.getText().toString().trim().equalsIgnoreCase("null"))){
                    holder.accion.setText("---");
                    holder.accion.setEnabled(false);
                }

                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISTVA - Instalación de Servicio de TV")) {
                    holder.recibi.setChecked(false);
                    request.getArbSer(Cmcontext);
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();


                }


                /*if ((accion.getText().toString().trim().equalsIgnoreCase("null"))){
                    accion.setEnabled(false);
                    accion.setText("---");
                }*/

            }
        });
        return convertView;
    }


    public void norec(){

        Iterator<List<GetBUSCADetOrdSerListResult>> itData1 = Array.dataTrabajos.iterator();
        List<GetBUSCADetOrdSerListResult> dat1 = (List<GetBUSCADetOrdSerListResult>) itData1.next();
        //dat1.get(cont).setSeRealiza(true);

        for(int i=0;i<dat1.size();i++){
        stat=Boolean.valueOf(recibixnew.get(i));
           // stat=Boolean.valueOf(Array.recibix.get(cont));
            Clave =Integer.valueOf( clavex.get(i));
            clvTra=Integer.valueOf(Array.clv_trabajox.get(i));
            descr=String.valueOf(Array.trabajox.get(i));

        if (stat==false){
        try{
            jsonObject = new JSONObject();
            jsonObject2 = new JSONObject();
            jsonObject.put("Clave", Clave);
            jsonObject.put("Clv_Orden", clvor);
            jsonObject.put("Clv_Trabajo", clvTra);
            jsonObject.put("Descripcion", descr);
            jsonObject.put("Obs", null);
            jsonObject.put("SeRealiza", true);
            jsonObject.put("recibi", stat);
            jsonArrayap.put(i,jsonObject);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
        try {
            jsonObject2.put("objSP_InsertaTbl_NoEntregados",jsonArrayap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
