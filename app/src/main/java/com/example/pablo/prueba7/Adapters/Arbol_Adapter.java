package com.example.pablo.prueba7.Adapters;

import android.content.Context;
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
import com.example.pablo.prueba7.Activitys.asignado;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Activitys.asignacion.Asignacion;
import static com.example.pablo.prueba7.Activitys.asignacion.aceptarmedio;
import static com.example.pablo.prueba7.Activitys.asignacion.layoutMedio;
import static com.example.pablo.prueba7.Activitys.asignacion.siguiente;
import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.viewHolder.medio;


public class Arbol_Adapter extends BaseAdapter {
    private Request request = new Request();
    private LayoutInflater inflater;
    private Context mcontext;
    public static int clv_unicaNet, clv_Medio, posi, d, f,h;
    public static int c=0;
    public static String dato;
    private Array array = new Array();
    public static int a=0;
    public static ArrayList<Integer> DeletChildren = new ArrayList<Integer>();
    public static ArrayList<String> DeletMedio = new ArrayList<String>();


    public Arbol_Adapter(Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }

    public static class viewHolder{
        public static TextView nombre;
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
        final children dataChild= new children();
        convertView=inflater.inflate(R.layout.activity_aparato_asignado_medio_list,null);
        holder.listaAparatos = convertView.findViewById(R.id.ListaAparatos);
        holder.nombre=convertView.findViewById(R.id.textservicio);
        holder.medio=convertView.findViewById(R.id.medio);
        holder.checkBox=convertView.findViewById(R.id.chek);


        convertView.setTag(holder);


        ///////////////

        ///////////////

        a=0;
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

            for(d = 0; d<dat4.get(position).children.size(); d++){
                c=0;
                String hijo="";
                hijo = dat4.get(position).children.get(d).Nombre + dat4.get(position).children.get(d).getDetalle();
                array.children.add(hijo);
                ArrayAdapter arrayAdapter1 = new ArrayAdapter(mcontext, android.R.layout.simple_list_item_checked,array.children);
                holder.listaAparatos.setAdapter(arrayAdapter1);
                asignacion.aceptarAsignacion.setEnabled(false);
                for(int l=0; l<dat4.size(); l++){
                    if(dat4.get(l).children!=null){
                        asignacion.aceptarAsignacion.setEnabled(true);
                    }
                }

                holder.listaAparatos.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                holder.listaAparatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position3, long id) {

                        if(holder.listaAparatos.isItemChecked(position3)==true){
                            Arbol_Adapter.DeletMedio.clear();
                            String abc= String.valueOf(position);
                            DeletChildren.add(Integer.valueOf(dat4.get(position).children.get(position3).getClv_Aparato()+abc));
                        }
                        if(holder.listaAparatos.isItemChecked(position3)==false){
                            DeletChildren.clear();
                           }




                    }
                });
                holder.listaAparatos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }

int d=0;
        f=0;
        h=0;
     for(int c=0; c<dat4.size(); c++){
            if(dat4.get(c).Detalle!=""){
                d=d+1;
            }
            if(d!=dat4.size()){

            }else{
                siguiente.setEnabled(true);
            }
     }
    /* if(trabajos_adapter_result.isnet==1){
         for(int e=0; e<dat.size();e++){
             if(dat.get(e).IdMedio==1){
                 f=1;
             }
         }
     }
     if(f==1){
         asignacion.aceptarAsignacion.setEnabled(true);
     }else{
         for(int g=0; g<dat.size();g++){
             if(dat.get(g).children.size()>0){
                 h=h+1;
             }
         }
     }
     if(h==1){
         asignacion.aceptarAsignacion.setEnabled(true);
     }*/

        ////////////////////


        final int[] m = {1};
        ////////////////////////////////

        holder.medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacion.aceptarAsignacion.setVisibility(View.GONE);
                asignacion.cancelarAsigancion.setVisibility(View.GONE);
                siguiente.setVisibility(View.GONE);
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData1 = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat1 =  itData1.next();
                clv_unicaNet = dat1.get(position).getClv_UnicaNet();



                request.getMedSer(mcontext);
                posi = position;
                ////
                layoutMedio.setVisibility(View.VISIBLE);
                Asignacion.setVisibility(View.GONE);
                siguiente.setEnabled(false);


            }
        });
        aceptarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (m[0] == 1) {
                    Toast.makeText(mcontext, "Debe de llenar el campo 'Medio'", Toast.LENGTH_LONG).show();
                } else {


                    asignacion.aceptarAsignacion.setVisibility(View.VISIBLE);
                    asignacion.cancelarAsigancion.setVisibility(View.VISIBLE);
                    siguiente.setVisibility(View.VISIBLE);

                    layoutMedio.setVisibility(View.GONE);
                    Asignacion.setVisibility(View.VISIBLE);
                    siguiente.setEnabled(true);
                    //////
                    medio.setVisibility(View.GONE);

                    a=0;
                    Asignacion.setAdapter(Arbol_Adapter.this);


                }

            }
        });
        asignacion.cancelarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacion.aceptarAsignacion.setVisibility(View.VISIBLE);
                asignacion.cancelarAsigancion.setVisibility(View.VISIBLE);
                siguiente.setVisibility(View.VISIBLE);
                layoutMedio.setVisibility(View.GONE);
                Asignacion.setVisibility(View.VISIBLE);
                siguiente.setEnabled(true);
            }
        });
        asignacion.spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                if (position1 != 0) {
                    m[0] = 2;
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itdata3 = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat3 = itdata3.next();
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData2 = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat2 = itData2.next();
                    dato = dat3.get(position1-1).getDescripcion();
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
                      Arbol_Adapter.DeletMedio.clear();
                       DeletMedio.add(dat4.get(position).IdMedio+dat4.get(position).Detalle);
                }if(holder.checkBox.isChecked()==false){
                  Arbol_Adapter.DeletMedio.clear();

               }

            }
        });

        return convertView;
    }
}
