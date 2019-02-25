package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pablo.prueba7.CambioAparato;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


import java.util.ArrayList;



public class trabajos_adapter_result extends BaseAdapter {

    LayoutInflater inflatertrab;
    Context Cmcontext;

    ArrayList<String>trabajox;
    ArrayList<String>accionx;
    public static int ClaveTrabajo, isnet;

    public trabajos_adapter_result(Context context, ArrayList<String>trabajox, ArrayList<String>accionx){
        this.trabajox=trabajox;
        this.accionx=accionx;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflatertrab.inflate(R.layout.list_trabajos_items,null);

            holder.trabajo=convertView.findViewById(R.id.trabajov);
            holder.accion=convertView.findViewById(R.id.accionv);

            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }
        holder.trabajo.setText(Array.trabajox.get(position));
        holder.accion.setText(Array.accionx.get(position));
        ClaveTrabajo = Array.clavex.get(position);

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


                /*if ((accion.getText().toString().trim().equalsIgnoreCase("null"))){
                    accion.setEnabled(false);
                    accion.setText("---");
                }*/

            }
        });
        return convertView;
    }

}
