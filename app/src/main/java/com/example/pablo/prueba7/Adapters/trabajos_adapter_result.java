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
import com.example.pablo.prueba7.CambioDom;
import com.example.pablo.prueba7.ExtensionesAdi;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Orden;
import com.example.pablo.prueba7.Post.RecibiAparato;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.Trabajos;
import com.example.pablo.prueba7.asignacion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Listas.Array.clavex;

import static com.example.pablo.prueba7.Listas.Array.recibix;
import static com.example.pablo.prueba7.Post.RecibiAparato.jsonArrayap;
import static com.example.pablo.prueba7.Post.RecibiAparato.jsonObject;

import static com.example.pablo.prueba7.Trabajos.trabajos;

public class trabajos_adapter_result extends BaseAdapter {

    LayoutInflater inflatertrab;
    Context Cmcontext;
    Context context;
    ArrayList<String>trabajox;
    ArrayList<String>accionx;
    ArrayList<Boolean>recibix;
    public static int Clave, isnet,clvTra;
    public static boolean stat;
    RecibiAparato RA =new RecibiAparato();
    //public static Boolean[]recib=new Boolean[Array.accionx.size()];
    public static String descr;
    public static int x=0;
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

        /////////////
       // clvor = Integer.valueOf(Array.ordensrc.get(position));


        holder.recibi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    stat=Boolean.valueOf(Array.recibix.get(position));
                    Clave =Integer.valueOf( clavex.get(position));
                    clvTra=Integer.valueOf(Array.clv_trabajox.get(position));
                    descr=String.valueOf(Array.trabajox.get(position));

                    stat=true;

                     try{
                        jsonObject = new JSONObject();
                        jsonObject.put("Clave", Clave);
                        jsonObject.put("Clv_Orden", clvor);
                        jsonObject.put("Clv_Trabajo", clvTra);
                        jsonObject.put("Descripcion", descr);
                        jsonObject.put("Obs", null);
                        jsonObject.put("SeRealiza", true);
                        jsonObject.put("recibi", stat);
                    }
                     catch (JSONException e) {
                         e.printStackTrace();
                     }
                    x++;

                 Ra.agregaap();

                  /*  try {
                        RA.recibiapar();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                }
            }






        });

        ///////////
        holder.accion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                isnet=0;

                Request request = new Request();
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISTVA - Instalación de Servicio de TV")) {
                    request.getArbSer(Cmcontext);
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();

                }

                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISNET - Instalación de Servicio de Internet")) {
                    request.getArbSer(Cmcontext);
                    isnet=1;
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();

                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAG - Cambio de tipo de aparato  FTTH")) {
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                    Cmcontext.startActivity(intento);
                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAMDO - Cambio De Domicilio")) {
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();
                    request.getCAMDO(Cmcontext);

                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAT - Cambio De Tipo De Aparato")) {
                    Intent intento = new Intent(Cmcontext, CambioAparato.class);
                    Cmcontext.startActivity(intento);

                }
                if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CONEX - Contratación De Extensión")) {
                    Toast.makeText(Cmcontext, "Espere", Toast.LENGTH_LONG).show();
                    request.getExtencionesAdicionales(Cmcontext);

                }

                if ((holder.accion.getText().toString().trim().equalsIgnoreCase("null"))){
                    holder.accion.setEnabled(false);
                    holder.accion.setText("---");
                }

            }
        });
        return convertView;
    }

}
