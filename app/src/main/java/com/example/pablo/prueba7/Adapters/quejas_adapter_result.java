package com.example.pablo.prueba7.Adapters;import android.content.Context;import android.content.Intent;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.BaseAdapter;import android.widget.Button;import android.widget.TextView;import com.example.pablo.prueba7.Listas.Array;import com.example.pablo.prueba7.MainReportes;import com.example.pablo.prueba7.R;import com.example.pablo.prueba7.Request.Request;import java.util.ArrayList;public class quejas_adapter_result extends BaseAdapter {    LayoutInflater inflater;    Context mContext;    ArrayList<String> Queja;    ArrayList<String>contratoQ;    ArrayList<String>nombreQ;    ArrayList<String>statusQ;    Request request=new Request();    public static Integer clvReport;    public static String contratoReport;    public static Integer contratoB;    public quejas_adapter_result(Context context, ArrayList<String>Queja,ArrayList<String>nombreQ,ArrayList<String>contratoQ,ArrayList<String>statusQ){        this.Queja=Queja;        this.contratoQ=contratoQ;        this.nombreQ=nombreQ;        this.statusQ=statusQ;        mContext=context;        inflater=LayoutInflater.from(mContext);    }    public  class viewHolder{        TextView statusq,contratoq,nombreq;        Button quejaq;    }    @Override    public int getCount() {        return Array.Queja.size();    }    @Override    public Object getItem(int position) {        return position;    }    @Override    public long getItemId(int position) {        return position;    }    @Override    public View getView(final int position, View convertView, ViewGroup parent) {        final quejas_adapter_result.viewHolder holder;        if (convertView == null) {            holder = new quejas_adapter_result.viewHolder();            convertView=inflater.inflate(R.layout.list_quejas_items,null);            holder.statusq=(TextView)convertView.findViewById(R.id.statusq);            holder.quejaq=(Button)convertView.findViewById(R.id.quejaq);            holder.contratoq=(TextView)convertView.findViewById(R.id.contratoq);            holder.nombreq=(TextView)convertView.findViewById(R.id.nombreq);            convertView.setTag(holder);        }        else {            holder=(quejas_adapter_result.viewHolder)convertView.getTag();        }        holder.nombreq.setText(Array.nombreQ.get(position));        holder.quejaq.setText(Array.Queja.get(position));        holder.contratoq.setText(Array.contratoQ.get(position));        holder.statusq.setText(Array.statusQ.get(position));        holder.quejaq.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Intent intento1 = new Intent(mContext, MainReportes.class);                mContext.startActivity(intento1);                //request.getDeepCons();                clvReport=Integer.valueOf(Queja.get(position));                contratoReport=String.valueOf(Array.contratoQ.get(position));//                 contratoB=Integer.parseInt(String.valueOf(Array.Asigna.get(position)));            }        });        return convertView;    }}