package com.example.pablo.prueba7.Adapters;


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;

import org.json.JSONObject;


import java.util.List;



public class ordenes_adapter_result extends BaseAdapter implements AdapterView.OnItemClickListener {

    public Integer clvor;
    private LayoutInflater inflater;
    private Context mContext;


    private Request request=new Request();
    public static ProgressDialog dialogTrabajos;
    BarraCargar barraCargar = new BarraCargar();

    public ordenes_adapter_result(Context context, List<List<String>> Ordenessrc){
                mContext=context;
        inflater=LayoutInflater.from(mContext); }
        @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("APP","Click");
    }
    public  class viewHolder{
        private TextView status,contrato1,nombre,direccionOrd,orden,control;

    }
    @Override
    public int getCount() {
        return Array.Ordenessrc.get(0).size();

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
        dialogTrabajos= barraCargar.showDialog(mContext);
        Util.preferences = mContext.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        Util.editor = Util.preferences.edit();
        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.recycler_oq,null);

            holder.status=(TextView)convertView.findViewById(R.id.tv_estatus);
            holder.orden=(TextView)convertView.findViewById(R.id.tv_NOrden);
            holder.contrato1=(TextView)convertView.findViewById(R.id.tv_NContrato);
            holder.nombre=(TextView)convertView.findViewById(R.id.tv_Nombre);
            holder.direccionOrd=(TextView)convertView.findViewById(R.id.id_direccion);
            holder.control=(TextView)convertView.findViewById(R.id.controla);

            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }
        holder.nombre.setText(Array.Ordenessrc.get(2).get(position));
        holder.orden.setText(Array.Ordenessrc.get(0).get(position));
        holder.contrato1.setText(Array.Ordenessrc.get(1).get(position));
        holder.status.setText(Array.Ordenessrc.get(3).get(position));
        holder.direccionOrd.setText(Array.Ordenessrc.get(4).get(position));
        holder.control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTrabajos.show();
                Util.editor.putInt("ClvOrden", Integer.parseInt(Array.Ordenessrc.get(0).get(position)));
                Util.editor.commit();
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("Clv_Orden", Util.getClvOrden(Util.preferences));
                }catch (Exception e){}
                request.getDeepCons(mContext,jsonObject);
            }
        });
        return convertView;
    }
}