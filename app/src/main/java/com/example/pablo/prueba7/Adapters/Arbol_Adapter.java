package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Activitys.asignacion;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Activitys.asignacion.Asignacion;
import static com.example.pablo.prueba7.Activitys.asignacion.aceptarAsignacion;
import static com.example.pablo.prueba7.Activitys.asignacion.aceptarmedio;
import static com.example.pablo.prueba7.Activitys.asignacion.layoutMedio;
import static com.example.pablo.prueba7.Activitys.asignacion.siguiente;
import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.viewHolder.medio;


public class Arbol_Adapter extends BaseAdapter {
    private Request request = new Request();
    private LayoutInflater inflater;
    private Context mcontext;
    private int  clv_Medio, posi;
    private String dato;
    private Array array = new Array();
    public static ArrayList<Integer> DeletChildren = new ArrayList<Integer>();
    public static ArrayList<String> DeletMedio = new ArrayList<String>();
    public Arbol_Adapter(Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }
    public static class viewHolder{
        private TextView nombre;
        public static Button medio;
        private ListView listaAparatos;
        private CheckBox checkBox;


    }
    @Override
    public int getCount() {
        return Array.nombreArbol.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        holder = new viewHolder();
        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
        final List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4 = itData.next();
        convertView=inflater.inflate(R.layout.activity_aparato_asignado_medio_list,null);
        holder.listaAparatos = convertView.findViewById(R.id.ListaAparatos);
        holder.nombre=convertView.findViewById(R.id.textservicio);
        holder.medio=convertView.findViewById(R.id.medio);
        holder.checkBox=convertView.findViewById(R.id.chek);
        convertView.setTag(holder);

        /////////////////////
        Validar(dat4);
        //////////////Llenar nombres///////////////////////////
        if(dat4.get(position).getIdMedio()==0){
            holder.nombre.setText(array.nombreArbol.get(position));
            holder.checkBox.setVisibility(View.GONE);

        }else{

            holder.nombre.setText(dat4.get(position).getNombre()+" ("+dat4.get(position).getDetalle()+")");
            holder.medio.setVisibility(View.INVISIBLE);
            holder.checkBox.setVisibility(View.VISIBLE);
        }if(dat4.get(position).children.size()==0){
        }else{
            holder.listaAparatos.setVisibility(View.VISIBLE);
            array.children = new ArrayList<>();
            holder.checkBox.setVisibility(View.GONE);
            Arbol_Adapter.DeletChildren.clear();
            for(int d = 0; d<dat4.get(position).children.size(); d++){
                String hijo="";
                hijo = dat4.get(position).children.get(d).Nombre + dat4.get(position).children.get(d).getDetalle();
                array.children.add(hijo);
                ArrayAdapter arrayAdapter1 = new ArrayAdapter(mcontext, android.R.layout.simple_list_item_checked,array.children);
                holder.listaAparatos.setAdapter(arrayAdapter1);
                holder.listaAparatos.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                holder.listaAparatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position3, long id) {

                        if(holder.listaAparatos.isItemChecked(position3)==true){
                            String abc= String.valueOf(position);
                            DeletChildren.add(Integer.valueOf(dat4.get(position).children.get(position3).getClv_Aparato()+abc));
                        }
                        if(holder.listaAparatos.isItemChecked(position3)==false){
                            String abc= String.valueOf(position);
                            DeletChildren.remove(Integer.valueOf(dat4.get(position).children.get(position3).getClv_Aparato()+abc));
                           }
                    }
                });
            }
        }
        /////////////////////////////////////////////
            Validar(dat4);
        /////////////
     final int[] m = {1};
     holder.medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ocultar(8,8,8,8,0,8);
                siguiente.setEnabled(false);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("ClvUnicaNet", dat4.get(position).getClv_UnicaNet());
                }catch (Exception e){}
                request.getMedSer(mcontext,jsonObject);
                posi = position;
            }
        });
        aceptarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (m[0] == 1) {
                    Toast.makeText(mcontext, "Debe de llenar el campo 'Medio'", Toast.LENGTH_LONG).show();
                } else {
                    Ocultar(0,0,0,0,8,0);
                    medio.setVisibility(View.GONE);
                    Asignacion.setAdapter(Arbol_Adapter.this);
                    Validar(dat4);
                }
            }
        });
        asignacion.cancelarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ocultar(0,0,0,0,8,0);
            }
        });
        asignacion.spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                if (position1 != 0) {
                    m[0] = 2;
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData2 = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat2 = itData2.next();
                    dato = dat2.get(position1-1).getDescripcion();
                    try {
                        clv_Medio = dat2.get(position1).getIdMedio();
                    } catch (Exception e) {
                        clv_Medio = dat2.get(position1 - 1).getIdMedio();
                    }
                    dat4.get(posi).setIdMedio(clv_Medio);
                    dat4.get(posi).setDetalle(dato);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               if(holder.checkBox.isChecked()==true){
                       DeletMedio.add(dat4.get(position).IdMedio+dat4.get(position).Detalle);
                }if(holder.checkBox.isChecked()==false){
                  Arbol_Adapter.DeletMedio.remove(dat4.get(position).IdMedio+dat4.get(position).Detalle);

               }

            }
        });

        return convertView;
    }
    public void Validar(List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4){
        int d=0;
        for(int c=0; c<dat4.size(); c++){
            if(dat4.get(c).Detalle==null||dat4.get(c).Detalle.equals("")){
                d=d+1;
            }
            if(d>=1){
                siguiente.setEnabled(false);
            }else{
                siguiente.setEnabled(true);
            }
        }
        int g=0;
        for(int f=0; f<dat4.size(); f++){
            if(dat4.get(f).children.size()==0){
                g=g+1;
            }
        }
        if(g>=1){
            aceptarAsignacion.setEnabled(false);
        }else{
            aceptarAsignacion.setEnabled(true);
        }
    }
    public void Ocultar(int eliminar,int aceptar, int cancelar, int sig, int layout, int asignar){
        asignacion.eliminarAparato.setVisibility(eliminar);
        asignacion.aceptarAsignacion.setVisibility(aceptar);
        asignacion.cancelarAsigancion.setVisibility(cancelar);
        siguiente.setVisibility(sig);
        layoutMedio.setVisibility(layout);
        Asignacion.setVisibility(asignar);
    }

}
