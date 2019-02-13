package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;

import java.util.ArrayList;


public class Servicios_Adapter extends BaseAdapter  {

Array array = new Array();
    LayoutInflater inflater;
    Context mcontext;
    ArrayList<String> selectedStrings = new ArrayList<String>();


    public Servicios_Adapter (Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }



    public static class viewHolder{
        public static CheckBox check;

    }

    @Override
    public int getCount() {
        return array.serviciosAparatos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;


        if (convertView == null) {

            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.activity_asignados_list,null);

            holder.check=convertView.findViewById(R.id.chekServicios);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.check.setText(array.serviciosAparatos.get(position));

    holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    selectedStrings.add(String.valueOf(holder.check.getText()));
                }else{
                  //  selectedStrings.remove(String.valueOf(holder.check.getText()));
                }
                if(selectedStrings.size()!=0){
                    for (int a=0; a<selectedStrings.size(); a++){
                        Log.d("asdasd", selectedStrings.get(a));
                }

            }

            /////////

            /////////////


        }
    });

        return convertView;
    }

}
