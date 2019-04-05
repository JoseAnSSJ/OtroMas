package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Activitys.MainReportes;
import com.example.pablo.prueba7.R;

import java.util.ArrayList;

import static com.example.pablo.prueba7.Listas.Array.Quejassrc;

public class quejas_adapter_result extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    public static Integer clvReport;
    public static String contratoReport;

    public quejas_adapter_result(Context context){

        mContext=context;
        inflater=LayoutInflater.from(mContext);

    }
    public  class viewHolder{
        TextView statusq,contratoq,nombreq,direccion,quejaq,control;
    }
    @Override
    public int getCount() {
        return Quejassrc.get(0).size();
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
        final quejas_adapter_result.viewHolder holder;
        if (convertView == null) {
            holder = new quejas_adapter_result.viewHolder();
            convertView=inflater.inflate(R.layout.recycler_oq,null);
            holder.statusq=(TextView)convertView.findViewById(R.id.tv_estatus);
            holder.quejaq=(TextView) convertView.findViewById(R.id.tv_NOrden);
            holder.contratoq=(TextView)convertView.findViewById(R.id.tv_NContrato);
            holder.nombreq=(TextView)convertView.findViewById(R.id.tv_Nombre);
            holder.direccion=(TextView)convertView.findViewById(R.id.id_direccion);
            holder.control=(TextView)convertView.findViewById(R.id.controla);
            convertView.setTag(holder); }
        else {
            holder=(quejas_adapter_result.viewHolder)convertView.getTag();
        }
        holder.nombreq.setText(Quejassrc.get(2).get(position));
        holder.quejaq.setText(Quejassrc.get(0).get(position));
        holder.contratoq.setText(Quejassrc.get(1).get(position));
        holder.statusq.setText(Quejassrc.get(3).get(position));
        holder.direccion.setText(Quejassrc.get(4).get(position));
        holder.control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento1 = new Intent(mContext, MainReportes.class);
                mContext.startActivity(intento1);
                clvReport=Integer.valueOf(Quejassrc.get(0).get(position));
                contratoReport=String.valueOf(Quejassrc.get(1).get(position));
            }
        });
        return convertView;
    }
}
