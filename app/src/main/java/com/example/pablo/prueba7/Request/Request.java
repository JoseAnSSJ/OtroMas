package com.example.pablo.prueba7.Request;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.pablo.prueba7.Activitys.Orden;
import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Activitys.CambioDom;

import com.example.pablo.prueba7.Activitys.CambioAparato;
import com.example.pablo.prueba7.Adapters.TablaAdapter;
import com.example.pablo.prueba7.Fragments.EjecutarFragment;
import com.example.pablo.prueba7.Activitys.ExtensionesAdi;
import com.example.pablo.prueba7.Fragments.HorasFragment;



import com.example.pablo.prueba7.Activitys.Inicio;
import com.example.pablo.prueba7.Fragments.InstalacionFragment;
import com.example.pablo.prueba7.Fragments.Materiales;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Listas.Example;
import com.example.pablo.prueba7.Listas.Example1;
import com.example.pablo.prueba7.Listas.Example2;
import com.example.pablo.prueba7.Listas.Example3;
import com.example.pablo.prueba7.Listas.JSONApaTipDis;
import com.example.pablo.prueba7.Listas.JSONApaTipo;
import com.example.pablo.prueba7.Listas.JSONAparatosDisponibles;
import com.example.pablo.prueba7.Listas.JSONArbolServicios;
import com.example.pablo.prueba7.Listas.JSONCAMDO;
import com.example.pablo.prueba7.Listas.JSONCLIAPA;
import com.example.pablo.prueba7.Listas.JSONDescripcionArticulosBit;
import com.example.pablo.prueba7.Listas.JSONDetalleBitacora;
import com.example.pablo.prueba7.Listas.JSONLlenaExtenciones;
import com.example.pablo.prueba7.Listas.JSONMediosSer;
import com.example.pablo.prueba7.Listas.JSONNombreTecnico;
import com.example.pablo.prueba7.Listas.JSONPreDescarga;
import com.example.pablo.prueba7.Listas.JSONReporteCliente;
import com.example.pablo.prueba7.Listas.JSONReportes;
import com.example.pablo.prueba7.Listas.JSONResponseTecnico;
import com.example.pablo.prueba7.Listas.JSONServicioAsignado;
import com.example.pablo.prueba7.Listas.JSONServiciosAparatos;
import com.example.pablo.prueba7.Listas.JSONSolucion;
import com.example.pablo.prueba7.Listas.JSONStatusApa;
import com.example.pablo.prueba7.Listas.JSONTecSec;
import com.example.pablo.prueba7.Listas.JSONTecSecReport;
import com.example.pablo.prueba7.Listas.JSONTipoAparatos;
import com.example.pablo.prueba7.Listas.QuejasList;
import com.example.pablo.prueba7.Activitys.Login;
import com.example.pablo.prueba7.Activitys.MainActivity;
import com.example.pablo.prueba7.Activitys.MainReportes;
import com.example.pablo.prueba7.Modelos.CambioAparatoDeepModel;
import com.example.pablo.prueba7.Modelos.ChecaSiExtencionesModel;
import com.example.pablo.prueba7.Modelos.ConsultaIpModel;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.DescripcionArticuloModel;
import com.example.pablo.prueba7.Modelos.DetalleBitacoraModel;
import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Modelos.GetCheca_si_tiene_CAMDOModel;
import com.example.pablo.prueba7.Modelos.GetConTecnicoAgendaResult;
import com.example.pablo.prueba7.Modelos.GetDameDatosCAMDOResult;
import com.example.pablo.prueba7.Modelos.GetDameListadoOrdenesAgendadasResult;
import com.example.pablo.prueba7.Modelos.GetDameSerDelCliFacListResult;
import com.example.pablo.prueba7.Modelos.GetDeepMODORDSERModel;
import com.example.pablo.prueba7.Modelos.GetDeepValidaQuejaCompaniaAdicModel;
import com.example.pablo.prueba7.Modelos.GetListAparatosDisponiblesByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetListTipoAparatosByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetMUESTRATRABAJOSQUEJASListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraAparatosDisponiblesListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraRelOrdenesTecnicosListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraServiciosRelTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTecnicosAlmacenListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.Modelos.GetSP_StatusAparatosListResult;
import com.example.pablo.prueba7.Modelos.Get_ClvTecnicoResult;
import com.example.pablo.prueba7.Modelos.GetdameSerDELCliresumenResult;
import com.example.pablo.prueba7.Modelos.GetuspBuscaContratoSeparado2ListResult;
import com.example.pablo.prueba7.Modelos.InfoClienteModelo;
import com.example.pablo.prueba7.Modelos.ListadoQuejasAgendadas;
import com.example.pablo.prueba7.Modelos.LlenaExtencionesModel;
import com.example.pablo.prueba7.Modelos.OrdSer;
import com.example.pablo.prueba7.Modelos.dameTblPreDescargaMaterialResultModel;
import com.example.pablo.prueba7.Modelos.ProximaCitaModel;
import com.example.pablo.prueba7.Modelos.Queja;
import com.example.pablo.prueba7.Modelos.TipoMaterialModel;
import com.example.pablo.prueba7.Modelos.UserModel;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Services.Services;
import com.example.pablo.prueba7.Fragments.TrabajosFragment;
import com.example.pablo.prueba7.Activitys.asignacion;
import com.example.pablo.prueba7.Activitys.asignado;
import com.example.pablo.prueba7.sampledata.Service;
import com.google.gson.JsonObject;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pablo.prueba7.Activitys.ExtensionesAdi.txtExtencion;
import static com.example.pablo.prueba7.Fragments.EjecutarFragment.msgEjecutarOrd;
import static com.example.pablo.prueba7.Fragments.EjecutarFragment.reiniciar;
import static com.example.pablo.prueba7.Fragments.Trabajos.adaptertrabajos;
import static com.example.pablo.prueba7.Fragments.Trabajos.trabajos;
import static com.example.pablo.prueba7.Listas.Array.Asigna;
import static com.example.pablo.prueba7.Listas.Array.Asigna1;
import static com.example.pablo.prueba7.Fragments.TrabajosFragment.solucion;
import static java.util.Arrays.asList;

public class Request extends AppCompatActivity {
    Services services = new Services();

    Array array = new Array();
    CambioDom c = new CambioDom();
    public static String clave_tecnico,msgComando="",sigueinteTipo,siguenteContrato,sigueinteHora,siguenteCalle,sigueinteNumero,siguenteColonia;
    public static String nombre_tecnico;
    public static boolean cambioA, isnet;
    public static Long abc;
    public static String Obs;
    public static int clvP;
    public static int tecC;
    public static String fechaSl;
    public int reintentaB;
    public static String extencionesE;
    public  static ArrayAdapter adapterTecSec,adapterTecSecR;
    public static boolean pieza=false;
    public static String contraroMA,obsMA,statusMA;
    public static Integer nExtenciones=0;
    public static String reintentarComando;
    public static boolean rapagejecutar=false;
    public static String ciudadcmdo,localidadcmdo,coloniacmdo,callecmdo,numerocmdo,numeroicmdo,telefonocmdo,callencmdo,callescmdo,calleecmdo,calleocmdo,casacmdo;
    JsonObject jsonConsultaIp;
    String a = "Seleccione tecnico secundario";
    String f = "Seleccione tipo de solucion";
    Arbol_Adapter adapter;

    public static boolean b = false;

    public static String datos[];


    ///////////////////Token///////////////////////////
    public void getReviews(final Context context) {

        final List<String> lista = new ArrayList();

        Services restApiAdapter = new Services();
        Service service = restApiAdapter.getClientService();
        Call<JsonObject> call = service.getDataUser();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //Peticion de datos sobre el Json "LogOnResult"
Log.d("asd","ad");
                if (response.code() == 200) {
                    JsonObject userJson = response.body().getAsJsonObject("LogOnResult");
                    Log.d("response2", userJson.get("Usuario").getAsString());
                    Log.d("response3", userJson.get("Token").getAsString());
                    //Introduccion de datos del request en el Modelo para poder usarlos
                    UserModel user = new UserModel(
                            userJson.get("Usuario").getAsString(),
                            userJson.get("Token").getAsString(),
                            userJson.get("Codigo").getAsString(),
                            userJson.get("IdUsuario").getAsInt()
                    );
                    getClv_tecnico(context);
                }else{
                    Login.showProgress(false);
                    Toast.makeText(context, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
                b = true;


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //////////////////Clave Tecnico////////////////////////////
    public void getClv_tecnico(final Context context) {
        Service service = null;
        try {
            service = services.getTecService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONResponseTecnico> call = service.getDataTec();
        call.enqueue(new Callback<JSONResponseTecnico>() {
            @Override
            public void onResponse(Call<JSONResponseTecnico> call, Response<JSONResponseTecnico> response) {
                //Guardar Body del request en JSONResponseTecnico ya que lo regresa como una lista
                if(response.code()==200){
                    JSONResponseTecnico jsonResponse = response.body();
                    //Pide datos sobre el Json Get_ClvTecnicoResult haciendo referencia al JsonResponse donde se guardo
                    array.datatec = new ArrayList<List<Get_ClvTecnicoResult>>(asList(jsonResponse.Get_ClvTecnicoResult()));
                    //Se crea un Iterator con la lista para que se pueda recorrer con la informacion
                    Iterator<List<Get_ClvTecnicoResult>> iteData = array.datatec.iterator();
                    while (iteData.hasNext()) {
                        List<Get_ClvTecnicoResult> data = (List<Get_ClvTecnicoResult>) iteData.next();
                        //Se recorre la lista y se guarla la informacion en el Modelo
                        for (int i = 0; i < data.size(); i++) {
                            Log.d("response9", data.get(i).clv_tecnico);
                            Log.d("nombre", data.get(i).tecnico);
                        }
                        clave_tecnico = data.get(0).clv_tecnico;
                        nombre_tecnico = data.get(0).tecnico;

                        services.claveTecnico = Integer.parseInt(data.get(0).clv_tecnico);

                        //     MainActivity.NombreTec.setText(data.get(0).tecnico);

                    }
                    getProximaCita(context);

                }else{
                    Toast.makeText(context, "Error al conseguir clave Tecnico", Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<JSONResponseTecnico> call, Throwable t) {

            }
        });
    }

    ///////////////////Proxima Cita///////////////////////////
    public void getProximaCita(final Context context) {
        Service service = null;
        try {
            service = services.getProxService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JsonObject> call = service.getDataProx();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    try{
                        JsonObject userJson = response.body().getAsJsonObject("GetDameSiguienteCitaResult");
                        Log.d("response4", userJson.get("Calle").toString());
                        ProximaCitaModel user = new ProximaCitaModel(
                                userJson.get("Calle").getAsString(),
                                userJson.get("Clave").getAsInt(),
                                userJson.get("Colonia").getAsString(),
                                userJson.get("Contrato").getAsString(),
                                userJson.get("Hora").getAsString(),
                                userJson.get("NUMERO").getAsString(),
                                userJson.get("Tipo").getAsString()
                        );
                        sigueinteTipo= user.Tipo;
                        siguenteContrato = user.Contrato;
                        sigueinteHora= user.Hora;
                        siguenteCalle = user.Calle;
                        sigueinteNumero= user.NUMERO;
                        siguenteColonia =user.Colonia;
                    }catch (Exception e){
                    }
                    getOrdenes(context);

                }else{
                    Toast.makeText(context, "Error al conseguir siguiente Cita", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    ///////////////////Status,Observaciones, ORDENES///////////////////////////
    public void getOrdenes(final Context context) {
        Service service = null;
        try {
            service = services.getOrdSerService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<Example> call = service.getDataOrdenes();


        call.enqueue(new Callback<Example>() {


            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.code()==200){
                    Example jsonResponse = response.body();
                    try {
                        array.dataord = new ArrayList<List<OrdSer>>(asList(jsonResponse.getDameOrdenesQuejasTotalesResult.getOrdSer()));
                        Iterator<List<OrdSer>> itData = array.dataord.iterator();
                        while (itData.hasNext()) {
                            List<OrdSer> dat = (List<OrdSer>) itData.next();
                            for (int i = 0; i < dat.size(); i++) {
                                Log.d("response9", dat.get(i).getStatus());
                                Log.d("response10", String.valueOf(dat.get(i).getTotal()));
                                if (dat.get(i).getStatus().equals("Ejecutada")) {
                                    try {
                                        Inicio.OE = dat.get(i).getTotal();

                                    } catch (Exception e) {
                                        Inicio.OE = 0;
                                    }
                                }
                                if (dat.get(i).getStatus().equals("Pendiente")) {
                                    try {
                                        Inicio.OP = dat.get(i).getTotal();
                                    } catch (Exception e) {
                                        Inicio.OP = 0;
                                    }
                                }
                                if (dat.get(i).getStatus().equals("Visita")) {
                                    try {
                                        Inicio.OV = dat.get(i).getTotal();
                                    } catch (Exception e) {
                                        Inicio.OV = 0;
                                    }

                                }
                                if (dat.get(i).getStatus().equals("En Proceso")) {
                                    try {
                                        Inicio.OEP = dat.get(i).getTotal();
                                    } catch (Exception e) {
                                        Inicio.OEP = 0;
                                    }
                                }
                                if (dat.get(i).getStatus().equals("otro")) {
                                    try {
                                        Inicio.OO = dat.get(i).getTotal();
                                    } catch (Exception e) {
                                        Inicio.OO = 0;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        Inicio.OE = 0;
                        Inicio.OP = 0;
                        Inicio.OV = 0;
                        Inicio.OEP = 0;
                        Inicio.OO = 0;
                    }
                    getQuejas(context);
                }else{
                    Toast.makeText(context, "Error al conseguir todas las ordenes", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

    /////////////////Lista de ordenes/////////////////////////////
    public void getListQuejas(final Context context) {

        Service service = null;
        try {
            service = services.getListQuejasService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<QuejasList> call = service.getQuejasAgendadas();
        call.enqueue(new Callback<QuejasList>() {


            @Override
            public void onResponse(Call<QuejasList> call, Response<QuejasList> response) {
                if(response.code()==200){
                    QuejasList jsonResponse = response.body();

                    array.dataquejas = new ArrayList<List<ListadoQuejasAgendadas>>(asList(jsonResponse.GetDameListadoQuejasAgendadasResult()));
                    Iterator<List<ListadoQuejasAgendadas>> itData = array.dataquejas.iterator();
                    while (itData.hasNext()) {
                        List<ListadoQuejasAgendadas> dat = (List<ListadoQuejasAgendadas>) itData.next();
                        Array.Queja.clear();
                        Array.nombreQ.clear();
                        Array.statusQ.clear();
                        Array.contratoQ.clear();
                        Array.Direccion.clear();
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("Clave Reporte", String.valueOf(dat.get(i).getClvQueja()));
                            Log.d("Contrato", dat.get(i).getContrato());
                            Log.d("Nombre", dat.get(i).getNombre());
                            Log.d("Status", dat.get(i).getStatus());
                            Log.d("Calle", dat.get(i).getCalle());
                            Log.d("NUMERO", dat.get(i).getNUMERO());
                            Log.d("Colonia", dat.get(i).getColonia());




                            Array.Queja.add(String.valueOf(dat.get(i).getClvQueja()));
                            Array.contratoQ.add(String.valueOf(dat.get(i).getContrato()));
                            Array.nombreQ.add(String.valueOf(dat.get(i).getNombre()));
                            Array.statusQ.add(String.valueOf(dat.get(i).getStatus()));
                            Array.Direccion.add(String.valueOf(dat.get(i).getColonia()+", "+dat.get(i).getCalle()+", "+dat.get(i).getNUMERO()));

                        }
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir clave Tecnico", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<QuejasList> call, Throwable t) {

            }


        });

    }
    public void getListOrd(final Context context) {

        Service service = null;
        try {
            service = services.getListOrdService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<Example1> call = service.getDataListOrd();
        call.enqueue(new Callback<Example1>() {


            @Override
            public void onResponse(Call<Example1> call, Response<Example1> response) {
                if(response.code()==200){
                    Example1 jsonResponse = response.body();
                    array.dataagenda = new ArrayList<List<GetDameListadoOrdenesAgendadasResult>>(asList(jsonResponse.getGetDameListadoOrdenesAgendadasResult()));
                    Iterator<List<GetDameListadoOrdenesAgendadasResult>> itData = array.dataagenda.iterator();
                    while (itData.hasNext()) {
                        List<GetDameListadoOrdenesAgendadasResult> dat = (List<GetDameListadoOrdenesAgendadasResult>) itData.next();
                        Array.ordensrc.clear();
                        Array.nombresrc.clear();
                        Array.statusrc.clear();
                        Array.contratosrc.clear();
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("Clave de orden", String.valueOf(dat.get(i).getClvOrden()));
                            Log.d("Contrato", dat.get(i).getContrato());
                            Log.d("Nombre", dat.get(i).getNombre());
                            Log.d("Status", dat.get(i).getStatus());

                            Array.ordensrc.add(String.valueOf(dat.get(i).getClvOrden()));
                            Array.contratosrc.add(String.valueOf(dat.get(i).getContrato()));
                            Array.nombresrc.add(String.valueOf(dat.get(i).getNombre()));
                            Array.statusrc.add(String.valueOf(dat.get(i).getStatus()));
                            Array.direccionsrc.add(String .valueOf(dat.get(i).getNumero()+", "+dat.get(i).getCalle()+", "+dat.get(i).getColonia()));
                        }
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir lista de ordenes", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Example1> call, Throwable t) {

            }


        });

    }


    //////////////////Quejas////////////////////////////
    public void getQuejas(final Context context) {
        Service service = null;
        try {
            service = services.getOrdSerService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<Example> call = service.getDataOrdenes();

        call.enqueue(new Callback<Example>() {


            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.code()==200){
                    Example jsonResponse = response.body();
                    array.dataque = new ArrayList<List<Queja>>(asList(jsonResponse.getDameOrdenesQuejasTotalesResult.getQueja()));
                    Iterator<List<Queja>> itData = array.dataque.iterator();
                    while (itData.hasNext()) {
                        List<Queja> dat = (List<Queja>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("response7", dat.get(i).getStatus());
                            Log.d("response8", String.valueOf(dat.get(i).getTotal()));
                            if (dat.get(i).getStatus().equals("Ejecutada")) {
                                try {
                                    Inicio.RE = dat.get(i).getTotal();

                                } catch (Exception e) {
                                    Inicio.RE = 0;
                                }
                            }
                            if (dat.get(i).getStatus().equals("Pendiente")) {
                                try {
                                    Inicio.RP = dat.get(i).getTotal();
                                } catch (Exception e) {
                                    Inicio.RP = 0;
                                }
                            }
                            if (dat.get(i).getStatus().equals("Visita")) {
                                try {
                                    Inicio.RV = dat.get(i).getTotal();
                                } catch (Exception e) {
                                    Inicio.RV = 0;
                                }

                            }
                            if (dat.get(i).getStatus().equals("En Proceso")) {
                                try {
                                    Inicio.REP = dat.get(i).getTotal();
                                } catch (Exception e) {
                                    Inicio.REP = 0;
                                }
                            }
                            if (dat.get(i).getStatus().equals("otro")) {
                                try {
                                    Inicio.RO = dat.get(i).getTotal();
                                } catch (Exception e) {
                                    Inicio.RO = 0;
                                }
                            }
                        }

                    }
                    Login.showProgress(false);
                    Intent intento = new Intent(context, Inicio.class);
                    intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intento);

                    try{
                        //       Inicio.Grafica(Inicio.pieChart);
                        //       Inicio.pieChart.refreshDrawableState();
                    }catch (Exception e){
                        //     Inicio.pieChart.refreshDrawableState();
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir lista de quejas", Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }


        });
    }



    ///////////////////Consuta pantalla ordenes///////////////////////////
    public void getDeepCons(final Context context) {

        Service service = null;
        try {
            service = services.getDeepConsService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JsonObject> call = service.getDataDeepCons();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    JsonObject userJson = response.body().getAsJsonObject("GetDeepConsultaOrdSerResult");
                    try {
                        DeepConsModel user = new DeepConsModel(
                                userJson.get("Clv_FACTURA").getAsInt(),
                                userJson.get("Contrato").getAsInt(),
                                userJson.get("ContratoCom").getAsString(),
                                userJson.get("STATUS").getAsString(),
                                userJson.get("Obs").getAsString(),
                                userJson.get("Clv_Orden").getAsInt(),
                                userJson.get("Clv_TipSer").getAsInt(),
                                userJson.get("Fec_Sol").getAsString()
                        );
                    }catch (Exception e){
                        DeepConsModel user = new DeepConsModel(
                                userJson.get("Clv_FACTURA").getAsInt(),
                                userJson.get("Contrato").getAsInt(),
                                userJson.get("ContratoCom").getAsString(),
                                userJson.get("STATUS").getAsString(),
                                userJson.get("Obs").getAsJsonNull().toString(),
                                userJson.get("Clv_Orden").getAsInt(),
                                userJson.get("Clv_TipSer").getAsInt(),
                                userJson.get("Fec_Sol").getAsString()
                        );
                    }
                    getTrabajos(context);
                    try {
                        contraroMA=(String.valueOf(DeepConsModel.getContatoCom()));
                    } catch (Exception e) {

                    }
                    try {
                        obsMA=(String.valueOf(DeepConsModel.Obs));
                    } catch (Exception e) {

                    }


                    try {
                        if (DeepConsModel.STATUS.equals("E")) {
                            statusMA=("Ejecutada");

                        } else if (DeepConsModel.STATUS.equals("P")) {
                            statusMA=("Pendiente");

                        } else if (DeepConsModel.STATUS.equals("V")) {
                            statusMA=("En Visita");
                        }
                    } catch (Exception e) {

                    }


                }else{
                    Toast.makeText(context, "Error al conseguir datos de la orden", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    /////////////////Informacion del Cliente/////////////////////////////
    public void getInfoCliente(final Context context) {

        Service service = null;
        try {
            service = services.getInfoClienteService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JsonObject> call = service.getDataInfoCliente();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200) {
                    try{
                        JsonObject userJson = response.body().getAsJsonObject("GetDeepBUSCLIPORCONTRATO_OrdSerResult");
                        InfoClienteModelo user = new InfoClienteModelo(
                                userJson.get("CALLE").getAsString(),
                                userJson.get("CIUDAD").getAsString(),
                                userJson.get("COLONIA").getAsString(),
                                userJson.get("Compania").getAsString(),
                                userJson.get("NOMBRE").getAsString(),
                                userJson.get("NUMERO").getAsString()
                        );
                    }catch (Exception e){

                    }


                    // MainActivity.Empresa.setText(InfoClienteModelo.Compania);
                    MainActivity.Direccion.setText(InfoClienteModelo.CALLE + " " + InfoClienteModelo.NUMERO + " " + InfoClienteModelo.COLONIA);
                    MainActivity.Nombre.setText(InfoClienteModelo.NOMBRE);
                }
                else{
                    Toast.makeText(context, "Error al conseguir informacion del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    /////////////////ServiciosdelCliente/////////////////////////////
    public void getServicios(final Context context) {

        Service service = null;
        try {
            service = services.getServiciosService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<Example2> call = service.getDataServicios();
        call.enqueue(new Callback<Example2>() {


            @Override
            public void onResponse(Call<Example2> call, Response<Example2> response) {
                if(response.code()==200) {
                    ArrayList<String> resumen = new ArrayList<>();
                    Example2 jsonResponse = response.body();
                    array.dataclientes = new ArrayList<List<GetdameSerDELCliresumenResult>>(asList(jsonResponse.getdameSerDELCliresumenResult()));
                    Iterator<List<GetdameSerDELCliresumenResult>> itData = array.dataclientes.iterator();
                    while (itData.hasNext()) {
                        List<GetdameSerDELCliresumenResult> dat = (List<GetdameSerDELCliresumenResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            String a = "";
                            a = dat.get(i).getResumen() + '\n';
                            resumen.add(i, a);
                        }
                        MainActivity.InfoServicios.setText(resumen.toString());

                    }
                }else{
                    Toast.makeText(context, "Error al conseguir servicios del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {

            }


        });
    }

    /////////////////////////////informacion trabajos//////////////////////////////
    public void getTrabajos(final Context context) {
        Service service = null;
        try {
            service = services.getTrabajoService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<Example3> call = service.getDataTrabajos();
        call.enqueue(new Callback<Example3>() {
            @Override
            public void onResponse(Call<Example3> call, Response<Example3> response) {
                if(response.code()==200){
                    isnet =false;
                    Example3 jsonResponse = response.body();
                    array.dataTrabajos = new ArrayList<List<GetBUSCADetOrdSerListResult>>(asList(jsonResponse.getGetBUSCADetOrdSerListResult()));
                    Iterator<List<GetBUSCADetOrdSerListResult>> itData = array.dataTrabajos.iterator();
                    Array.trabajox.clear();
                    Array.accionx.clear();
                    while (itData.hasNext()) {
                        List<GetBUSCADetOrdSerListResult> dat = (List<GetBUSCADetOrdSerListResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("response11", dat.get(i).getDescripcion());
                            dat.get(i).setSeRealiza(false);
                            Array.trabajox.add(String.valueOf(dat.get(i).getDescripcion()));
                            Array.accionx.add(String.valueOf(dat.get(i).getAccion()));
                            Array.clavex.add(dat.get(i).getClave());
                            Array.clv_trabajox.add(dat.get(i).getClvTrabajo());
                            Array.recibix.add(dat.get(i).getSeRealiza());
                            if(dat.get(i).getClvTrabajo()==1270){
                                isnet=true;
                            }
                            if(dat.get(i).getClvTrabajo()==1203){
                                rapagejecutar=true;
                            }
                        }
                        Intent intento1 = new Intent(context, MainActivity.class);
                        context.startActivity(intento1);
                        try{
                            trabajos.setAdapter(adaptertrabajos);
                        }catch (Exception e){

                        }



                    }
                }else{
                    Toast.makeText(context, "Error al conseguir trabajos", Toast.LENGTH_LONG).show();
                }




            }

            @Override
            public void onFailure(Call<Example3> call, Throwable t) {

            }

        });

    }

    ////TecnicoSecundario////
    public void getTecSec(final Context context){
        Array.clv_tecnicoSecundario = new ArrayList<Integer>();
        Array.clv_tecnicoSecundario.add(0,-1);

        Service service = null;
        try {
            service = services.getTecSecService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONTecSec> call = service.getDataTecSec();
        call.enqueue(new Callback<JSONTecSec>() {
            @Override
            public void onResponse(Call<JSONTecSec> call, Response<JSONTecSec> response) {
                if (response.code() == 200) {
                    JSONTecSec jsonResponse = response.body();
                    Array.dataTecSec = new ArrayList<>(asList(jsonResponse.GetMuestraRelOrdenesTecnicosListResult()));
                    Iterator<List<GetMuestraRelOrdenesTecnicosListResult>> itdata = Array.dataTecSec.iterator();
                    while (itdata.hasNext()) {
                        List<GetMuestraRelOrdenesTecnicosListResult> dat = itdata.next();
                        datos = new String[dat.size() + 1];
                        int j = 1;
                        datos[0] = a;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("responsetecsec", dat.get(i).getNOMBRE());
                            datos[j] = dat.get(i).getNOMBRE();
                            Array.clv_tecnicoSecundario.add(j, dat.get(i).getCLV_TECNICO());

                            j = j + 1;
                        }

                        adapterTecSec = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        InstalacionFragment.TecSec.setAdapter(adapterTecSec);


                        InstalacionFragment.Obs.setText(String.valueOf(DeepConsModel.Obs));

                    }

                }else{
                    Toast.makeText(context, "Error al conseguir lista de tecnicos secundarios", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<JSONTecSec> call, Throwable t) {

            }
        });
    }

    public void getExtencionesAdicionales(final Context context) {

        Service service = null;
        try {
            service = services.getExtencionAdiService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getDataExtencionAdi();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if(response1.code()==200){
                    String string = String.valueOf(response1.body().getAsJsonPrimitive("GetCONCONEXResult"));
                    extencionesE=string;
                    Intent intento = new Intent(context, ExtensionesAdi.class);
                    context.startActivity(intento);
                }else{
                    Toast.makeText(context, "Error al conseguir extenciones adicionales", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
////ClientesAparato////

    public void getCliApa(final Context context) {

        Service service = null;
        try {
            service = services.getCliApaService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONCLIAPA> call = service.getDataCliApa();
        call.enqueue(new Callback<JSONCLIAPA>() {


            @Override
            public void onResponse(Call<JSONCLIAPA> call, Response<JSONCLIAPA> response) {
                if(response.code()==200){
                    JSONCLIAPA jsonResponse = response.body();
                    array.dataCliApa = new ArrayList<List<GetListClienteAparatosResult>>(asList(jsonResponse.GetListClienteAparatosResult()));
                    Iterator<List<GetListClienteAparatosResult>> itdata = array.dataCliApa.iterator();
                    while (itdata.hasNext()) {
                        List<GetListClienteAparatosResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Aparato";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("responseAparatosCliente", String.valueOf(dat.get(i).Descripcion));
                            datos[j] = dat.get(i).getMac();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        CambioAparato.aparato.setAdapter(adapter);
                        try {
                            CambioAparato.aparato.setSelection(CambioAparato.obtenerPosicionAC(CambioAparatoDeepModel.AparatoCliente));
                            getStatusApa(context);
                        } catch (Exception e) {

                        }

                    }
                }else{
                    Toast.makeText(context, "Error al conseguir aparatos del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONCLIAPA> call, Throwable t) {

            }
        });
    }

    ////Status Aparato////
    public void getStatusApa(final Context context) {
        Service service = services.getStatusApa();
        Call<JSONStatusApa> call = service.getDataStatusApa();
        call.enqueue(new Callback<JSONStatusApa>() {
            @Override
            public void onResponse(Call<JSONStatusApa> call, Response<JSONStatusApa> response) {
                if(response.code()==200) {
                    JSONStatusApa jsonResponse = response.body();
                    array.dataStaApa = new ArrayList<List<GetSP_StatusAparatosListResult>>(asList(jsonResponse.GetSP_StatusAparatosListResult()));
                    Iterator<List<GetSP_StatusAparatosListResult>> itdata = array.dataStaApa.iterator();
                    while (itdata.hasNext()) {
                        List<GetSP_StatusAparatosListResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Estado";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("responseStatus", dat.get(i).Concepto);
                            datos[j] = dat.get(i).getConcepto();
                            j = j + 1;
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        CambioAparato.estado.setAdapter(adapter);
                        try {
                            CambioAparato.estado.setSelection(CambioAparato.obtenerPosicionSA(CambioAparatoDeepModel.StatusEntrega));
                            getApaTipo(context);
                        } catch (Exception e) {

                        }
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir estatus del aparato", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONStatusApa> call, Throwable t) {

            }

        });
    }

    ////TipoAparato////
    public void getApaTipo(final Context context) {
        Service service = null;
        try {
            service = services.getApaTipoService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONApaTipo> call = service.getDataApaTipo();
        call.enqueue(new Callback<JSONApaTipo>() {


            @Override
            public void onResponse(Call<JSONApaTipo> call, Response<JSONApaTipo> response) {
                if(response.code()==200) {
                    try{
                        Iterator<List<GetListClienteAparatosResult>> itdata1 = Array.dataCliApa.iterator();
                        List<GetListClienteAparatosResult> dat1 = itdata1.next();
                        CambioAparato.idArticulo = dat1.get(CambioAparato.obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar)).getIdArticulo();
                        CambioAparato.contrato = dat1.get(CambioAparato.obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar)).getControNet();

                    }catch (Exception e){

                    }
                    JSONApaTipo jsonResponse = response.body();
                    array.dataApaTipo = new ArrayList<List<GetListTipoAparatosByIdArticuloResult>>(asList(jsonResponse.GetListTipoAparatosByIdArticuloResult()));
                    Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = array.dataApaTipo.iterator();
                    while (itdata.hasNext()) {
                        List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Tipo de Aparato";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("responseIdArticulo", String.valueOf(dat.get(i).IdArticulo));
                            datos[j] = dat.get(i).getNombre();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        CambioAparato.tipoAparato.setAdapter(adapter);
                        try{
                            Iterator<List<GetListClienteAparatosResult>> itdata1 = Array.dataCliApa.iterator();
                            List<GetListClienteAparatosResult> dat1 = itdata1.next();
                            CambioAparato.idArticulo = dat1.get(CambioAparato.obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar)).getIdArticulo();
                            CambioAparato.contrato = dat1.get(CambioAparato.obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar)).getControNet();
                            CambioAparato.tipoAparato.setSelection(CambioAparato.obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar));
                            getApaTipDis(context);
                        }catch (Exception e){

                        }
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir tipo de aparato", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONApaTipo> call, Throwable t) {

            }
        });
    }

    ////AparatoDisponible////
    public void getApaTipDis(final Context context) {

        Service service = null;
        try {
            service = services.getApaTipDisService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONApaTipDis> call = service.getDataApaTipDis();
        call.enqueue(new Callback<JSONApaTipDis>() {


            @Override
            public void onResponse(Call<JSONApaTipDis> call, Response<JSONApaTipDis> response) {
                if(response.code()==200) {
                    try{
                        Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata1 = Array.dataApaTipo.iterator();
                        List<GetListTipoAparatosByIdArticuloResult> dat1 = itdata1.next();
                        CambioAparato.idArticulo2 = dat1.get(CambioAparato.obtenerPosicionA(CambioAparatoDeepModel.AparatoAsignar)).getIdArticulo();
                    }catch (Exception e){

                    }
                    JSONApaTipDis jsonResponse = response.body();
                    array.dataApaTipDis = new ArrayList<List<GetListAparatosDisponiblesByIdArticuloResult>>(asList(jsonResponse.GetListAparatosDisponiblesByIdArticuloResult()));
                    Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata = array.dataApaTipDis.iterator();
                    while (itdata.hasNext()) {
                        List<GetListAparatosDisponiblesByIdArticuloResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccine Aparato Disponible";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("responseClv_aparato", String.valueOf(dat.get(i).Clv_Aparato));
                            datos[j] = dat.get(i).getDescripcion();
                            j = j + 1;
                        }
                        //////////////////////
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        CambioAparato.aparatoAsignar.setAdapter(adapter);
                        try{

                            CambioAparato.aparatoAsignar.setSelection(CambioAparato.obtenerPosicionA(CambioAparatoDeepModel.AparatoAsignar));
                        }catch (Exception e){

                        }
                        ///////////////////////////
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir aparatos disponibles", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONApaTipDis> call, Throwable t) {

            }
        });
    }
    public void getDeepCAPAT(final Context context) {

        Services restApiAdapter = new Services();
        Service service = restApiAdapter.getDeepCAPATService();
        Call<JsonObject> call = service.getDeepCAPAT();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //Peticion de datos sobre el Json "LogOnResult"
                if(response.code()==200) {
                    CambioAparatoDeepModel.StatusEntrega = "";
                    JsonObject userJson = response.body().getAsJsonObject("GetCambioAparatoDeepResult");
                    try {
                        CambioAparatoDeepModel user = new CambioAparatoDeepModel(
                                userJson.get("AparatoAsignar").getAsInt(),
                                userJson.get("AparatoCliente").getAsInt(),
                                userJson.get("TipoAparatoAsignar").getAsInt(),
                                userJson.get("StatusEntrega").getAsString()
                        );
                        getCliApa(context);




                    } catch (Exception e) {
                        getCliApa(context);
                        getStatusApa(context);
                    }

                }else{
                    Toast.makeText(context, "Error al conseguir datos de cambio de aparato", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void getCAMDO(final Context context) {
        Service service = null;
        try {
            service = services.getCAMODOService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONCAMDO> call = service.getDataCAMDO();
        call.enqueue(new Callback<JSONCAMDO>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JSONCAMDO> call, Response<JSONCAMDO> response) {
                if(response.code()==200){
                    try{
                        JSONCAMDO jsonResponse = response.body();
                        array.dataCAMDO = new ArrayList<List<GetDameDatosCAMDOResult>>(asList(jsonResponse.getDameDatosCAMDOResult()));
                        Iterator<List<GetDameDatosCAMDOResult>> itdata = array.dataCAMDO.iterator();
                        while (itdata.hasNext()) {
                            List<GetDameDatosCAMDOResult> dat = itdata.next();
                            String datos[] = new String[dat.size()];
                            for (int i = 0; i < dat.size(); i++) {
                                Log.d("casa", dat.get(i).getCasa());
                            }
                            ciudadcmdo=dat.get(0).Ciudad;
                            localidadcmdo=dat.get(0).localidad;
                            coloniacmdo=dat.get(0).colonia;
                            callecmdo=dat.get(0).calle;
                            numerocmdo= String.valueOf(dat.get(0).NUMERO);
                            numeroicmdo=dat.get(0).Num_int;
                            telefonocmdo=dat.get(0).TELEFONO;
                            callencmdo=dat.get(0).calleNorte;
                            callescmdo=dat.get(0).calleSur;
                            calleecmdo=dat.get(0).calleEste;
                            calleocmdo=dat.get(0).calleOeste;
                            casacmdo=dat.get(0).Casa;
                            Intent intento = new Intent(context, CambioDom.class);
                            context.startActivity(intento);
                        }
                    }catch (Exception e){
                        ciudadcmdo="";
                        localidadcmdo="";
                        coloniacmdo="";
                        callecmdo="";
                        numerocmdo="";
                        numeroicmdo="";
                        telefonocmdo="";
                        callencmdo="";
                        callescmdo="";
                        calleecmdo="";
                        calleocmdo="";
                        casacmdo="";
                        Intent intento = new Intent(context, CambioDom.class);
                        context.startActivity(intento);
                    }




                }else{
                    Toast.makeText(context, "Error al conseguir datos de cambio de domicilio", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONCAMDO> call, Throwable t) {

            }
        });
    }

    /////////////////////////////Arbol Servicios//////////////////////////////
    public void getArbSer(final Context context) {
        Service service = null;
        try {
            service = services.getArbolSerService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONArbolServicios> call = service.getDataArbSer();
        call.enqueue(new Callback<JSONArbolServicios>() {
            @Override
            public void onResponse(Call<JSONArbolServicios> call, Response<JSONArbolServicios> response) {
                if(response.code()==200){

                    array.nombreArbol.clear();
                    JSONArbolServicios jsonResponse = response.body();
                    array.dataArbSer = new ArrayList<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>>(asList(jsonResponse.GetMuestraArbolServiciosAparatosPorinstalarListResult()));
                    Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData4 = array.dataArbSer.iterator();
                    while (itData4.hasNext()) {
                        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4 = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData4.next();

                        for (int i = 0; i < dat4.size(); i++) {
                            Log.d("response21", String.valueOf(dat4.get(i).getIdMedio()));
                            array.nombreArbol.add(dat4.get(i).getNombre());
                        }
                    }
                    Intent intento25 = new Intent(context, asignacion.class);
                    context.startActivity(intento25);
                }else{
                    Toast.makeText(context, "Error al conseguir datos de la orden", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONArbolServicios> call, Throwable t) {

            }

        });

    }

    /////////////////////////////Medios Servicios//////////////////////////////
    public void getMedSer(final Context context) {
        Service service = null;
        try {
            service = services.getMediosSerService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONMediosSer> call = service.getDataMedSer();
        call.enqueue(new Callback<JSONMediosSer>() {
            @Override
            public void onResponse(Call<JSONMediosSer> call, Response<JSONMediosSer> response) {
                if(response.code()==200) {
                    array.medio.clear();
                    JSONMediosSer jsonResponse = response.body();
                    array.dataMedSer = new ArrayList<List<GetMuestraMedioPorServicoContratadoListResult>>(asList(jsonResponse.GetMuestraMedioPorServicoContratadoListResult()));
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData = array.dataMedSer.iterator();
                    while (itData.hasNext()) {
                        List<GetMuestraMedioPorServicoContratadoListResult> dat = (List<GetMuestraMedioPorServicoContratadoListResult>) itData.next();
                        array.medio.add("Selecionar Medio");
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("response22", dat.get(i).getDescripcion());
                            array.medio.add(dat.get(i).getDescripcion());
                        }
                    }
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.medio);
                    asignacion.spinnerMedio.setAdapter(adapter1);
                }else{
                    Toast.makeText(context, "Error al conseguir Clave Tecnico", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<JSONMediosSer> call, Throwable t) {

            }

        });

    }

    /////////////////////////////Tipo de Aparatos//////////////////////////////
    public void getTipoAparatos(final Context context) {
        Service service = null;
        try {
            service = services.getTipoAparatosService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONTipoAparatos> call = service.getDataTipoAparatos();
        call.enqueue(new Callback<JSONTipoAparatos>() {
            @Override
            public void onResponse(Call<JSONTipoAparatos> call, Response<JSONTipoAparatos> response) {
                if(response.code()==200) {
                    array.tipoAparato.clear();
                    JSONTipoAparatos jsonResponse = response.body();
                    array.dataTipoAparatos = new ArrayList<List<GetMuestraTipoAparatoListResult>>(asList(jsonResponse.GetMuestraTipoAparatoListResult()));
                    Iterator<List<GetMuestraTipoAparatoListResult>> itData = array.dataTipoAparatos.iterator();
                    array.tipoAparato.add("Seleccione aparato");
                    while (itData.hasNext()) {
                        List<GetMuestraTipoAparatoListResult> dat = itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("response23", dat.get(i).getNombre());
                            array.tipoAparato.add(dat.get(i).getNombre());
                        }
                    }
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.tipoAparato);
                    asignado.spinnerAparato.setAdapter(adapter1);

                }else{
                    Toast.makeText(context, "Error al conseguir tipos de aparatos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONTipoAparatos> call, Throwable t) {

            }

        });

    }

    /////////////////////////////Aparatos Disponibles//////////////////////////////
    public void getAparatosDisponibles(final Context context) {
        Service service = null;
        try {
            service = services.getAparatosDisponiblesService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONAparatosDisponibles> call = service.getDataAparatosDisponibles();
        call.enqueue(new Callback<JSONAparatosDisponibles>() {
            @Override
            public void onResponse(Call<JSONAparatosDisponibles> call, Response<JSONAparatosDisponibles> response) {
                if(response.code()==200) {
                    array.aparatoDisponibles.clear();
                    JSONAparatosDisponibles jsonResponse = response.body();
                    array.dataAparatosDisponibles = new ArrayList<List<GetMuestraAparatosDisponiblesListResult>>(asList(jsonResponse.GetMuestraAparatosDisponiblesListResult()));
                    Iterator<List<GetMuestraAparatosDisponiblesListResult>> itData = array.dataAparatosDisponibles.iterator();
                    while (itData.hasNext()) {
                        List<GetMuestraAparatosDisponiblesListResult> dat = (List<GetMuestraAparatosDisponiblesListResult>) itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            array.aparatoDisponibles.add(dat.get(i).getDescripcion());
                        }
                    }
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.aparatoDisponibles);
                    asignado.spinneraparatoDisponible.setAdapter(adapter1);
                }else{
                    Toast.makeText(context, "Error al conseguir aparatos disponibles", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<JSONAparatosDisponibles> call, Throwable t) {

            }

        });

    }

    /////////////////////////////Servicios Aparatos//////////////////////////////
    public void getServiciosAparatos(final Context context) {
        Service service = null;
        try {
            service = services.getServiciosAparatosService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONServiciosAparatos> call = service.getDataServiciosAparatos();
        call.enqueue(new Callback<JSONServiciosAparatos>() {
            @Override
            public void onResponse(Call<JSONServiciosAparatos> call, Response<JSONServiciosAparatos> response) {
                if(response.code()==200) {
                    array.serviciosAparatos.clear();
                    JSONServiciosAparatos jsonResponse = response.body();
                    array.dataserviciosAparatos = new ArrayList<List<GetMuestraServiciosRelTipoAparatoListResult>>(asList(jsonResponse.GetMuestraServiciosRelTipoAparatoListResult()));
                    Iterator<List<GetMuestraServiciosRelTipoAparatoListResult>> itData = array.dataserviciosAparatos.iterator();
                    while (itData.hasNext()) {
                        List<GetMuestraServiciosRelTipoAparatoListResult> dat = (List<GetMuestraServiciosRelTipoAparatoListResult>) itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            array.serviciosAparatos.add(dat.get(i).getNombre());
                            Log.d("ertgf", array.serviciosAparatos.get(i));

                        }

                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_checked, array.serviciosAparatos);
                    asignado.serviciosAparato.setAdapter(arrayAdapter);

                }else{
                    Toast.makeText(context, "Error al conseguir servicios de aparatos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONServiciosAparatos> call, Throwable t) {

            }

        });

    }

    public void getAceptatAsignacino(final Context context) {


        Services getAceptarAsigService = new Services();
        Service service = null;
        try {
            service = getAceptarAsigService.getAceptarAsigService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JsonObject> call = service.getDataAceptarAsig();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (response.code() == 200) {
                    Toast.makeText(context, "aparato agregado", Toast.LENGTH_LONG).show();
                    finish();

                }else{
                    Toast.makeText(context, "Error al aceptar asignacion", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    ////////////////////////////////////////INFO CLIENTE Reportes///////////////////////////////////////



    ////////////////////////////////////TIPO DE SOLUCION///////////////////////////////////////////////
    public void getSolucuion(final Context context) {
        Array.clv_Soluc = new ArrayList<Integer>();
        Array.clv_Soluc.add(0,-1);

        Service service = null;
        try {
            service = services.getSolocionService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONSolucion> call = service.getSolut();
        call.enqueue(new Callback<JSONSolucion>() {


            @Override
            public void onResponse(Call<JSONSolucion> call, Response<JSONSolucion> response) {
                if(response.code()==200) {
                    JSONSolucion jsonResponse = response.body();
                    array.dataSOL = new ArrayList<List<GetMUESTRATRABAJOSQUEJASListResult>>((asList(jsonResponse.getGetMUESTRATRABAJOSQUEJASListResult())));
                    Iterator<List<GetMUESTRATRABAJOSQUEJASListResult>> itdata = array.dataSOL.iterator();
                    while (itdata.hasNext()) {
                        List<GetMUESTRATRABAJOSQUEJASListResult> dat = itdata.next();

                        datos = new String[dat.size() + 1];
                        int j = 1;
                        datos[0] = f;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("descripcion", String.valueOf(dat.get(i).dESCRIPCION));
                            Log.d("occ", String.valueOf(dat.get(i).cLVTRABAJO));
                            datos[j] = dat.get(i).getDESCRIPCION();

                            Array.clv_Soluc.add(j, dat.get(i).getCLVTRABAJO());

                            j = j + 1;

                            //clvQ=dat.get(i).getCLVTRABAJO();

                        }


                        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        solucion.setAdapter(adapter);
                    }
                }else{
                    Toast.makeText(context, "Error al conseguir soluciones", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONSolucion> call, Throwable t) {

            }
        });
    }
    //////////////////////////////////////////Reporte del Cliente//////////////////////////////////////////////////////////////////////

    public void getReportesC(final Context context) {
        Service service = null;
        try {
            service = services.getReporteCService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONReporteCliente> call = service.getRPC();
        call.enqueue(new Callback<JSONReporteCliente>() {
            @Override
            public void onResponse(Call<JSONReporteCliente> call, Response<JSONReporteCliente> response) {
                if(response.code()==200) {
                    JSONReporteCliente jsonResponse = response.body();
                    array.dataReport = new ArrayList<List<GetQuejasListResult>>(asList(jsonResponse.getGetQuejasListResult()));


                    Iterator<List<GetQuejasListResult>> itData = array.dataReport.iterator();
                    while (itData.hasNext()) {
                        List<GetQuejasListResult> dat = (List<GetQuejasListResult>) itData.next();
                        for (int i = 0; i < dat.size(); ++i) {
                            Log.d("response40", dat.get(i).getObservaciones());
                            Log.d("response41", dat.get(i).getProblema());
                            Log.d("response42", dat.get(i).getPrioridad());
                            Log.d("response43", dat.get(i).getClasificacionProblema());

                            Asigna.add(dat.get(i).getPrioridad());
                            Asigna1.add(dat.get(i).getClasificacionProblema());
                            Obs = dat.get(i).observaciones;
                            clvP = dat.get(i).clvPrioridadQueja;
                            tecC = dat.get(i).tecnicoCuadrilla;

                            TrabajosFragment.prioridad.setText(String.valueOf(dat.get(i).getPrioridad()));
                            TrabajosFragment.clasific.setText(String.valueOf(dat.get(i).getClasificacionProblema()));
                            TrabajosFragment.desc.setText(String.valueOf(dat.get(i).getObservaciones()));
                            TrabajosFragment.problm.setText(String.valueOf(dat.get(i).getProblema()));
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<JSONReporteCliente> call, Throwable t) {

            }

        });

    }

    /////////////////Nombre Tecnico//////

    public void getnombretec(Context context) {
        Service service = null;
        try {
            service = services.getNombreService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONNombreTecnico> call = service.getNom();
        call.enqueue(new Callback<JSONNombreTecnico>() {
            @Override
            public void onResponse(Call<JSONNombreTecnico> call, Response<JSONNombreTecnico> response) {
                if(response.code()==200) {
                    JSONNombreTecnico jsonResponse = response.body();
                    array.dataNom = new ArrayList<List<GetConTecnicoAgendaResult>>(Collections.singleton(asList(jsonResponse.getGetConTecnicoAgendaResult())));


                    Iterator<List<GetConTecnicoAgendaResult>> itData = array.dataNom.iterator();
                    while (itData.hasNext()) {
                        List<GetConTecnicoAgendaResult> dat = (List<GetConTecnicoAgendaResult>) itData.next();
                        for (int i = 0; i < dat.size(); ++i) {
                            Log.d("response50", dat.get(i).getTecnico());


                            MainReportes.NombreTec1.setText(String.valueOf(dat.get(i).getTecnico()));
                            // TrabajosFragment.problm.setText(String.valueOf(dat.get(i).getProblema()));

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONNombreTecnico> call, Throwable t) {

            }


        });
    }

    //////////////////////////////////////servicios asiggnados ///////////////////////////////////////////
    public void getServiciosAsignados() {
        Service service = null;
        try {
            service = services.getAsignadosService();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONServicioAsignado> call = service.getServ();
        call.enqueue(new Callback<JSONServicioAsignado>() {
            @Override
            public void onResponse(Call<JSONServicioAsignado> call, Response<JSONServicioAsignado> response) {
                if(response.code()==200) {
                    JSONServicioAsignado jsonResponse = response.body();


                    array.dataServ = new ArrayList<List<GetDameSerDelCliFacListResult>>((asList(jsonResponse.getGetDameSerDelCliFacListResult())));


                    Iterator<List<GetDameSerDelCliFacListResult>> itData = array.dataServ.iterator();
                    while (itData.hasNext()) {
                        List<GetDameSerDelCliFacListResult> dat = (List<GetDameSerDelCliFacListResult>) itData.next();
                        for (int i = 0; i < dat.size(); ++i) {
                            Log.d("response60", dat.get(i).getServicio());


                            MainReportes.infoA.setText("    " + dat.get(0).getServicio() + '\n' + "    " + dat.get(1).getServicio() + '\n' + "    " +
                                    dat.get(2).getServicio() + '\n' + dat.get(3).getServicio() + '\n' + dat.get(4).getServicio()
                                    + '\n' + dat.get(5).getServicio() + '\n' + dat.get(6).getServicio() + '\n' + dat.get(7).getServicio() + '\n' + "    " + dat.get(8).getServicio());

                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<JSONServicioAsignado> call, Throwable t) {

            }


        });
    }

    public void getReportes(final Context context) {
        Service service = null;
        try {
            service = services.getMediosReportes();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<JSONReportes> call = service.getReport();
        call.enqueue(new Callback<JSONReportes>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JSONReportes> call, Response<JSONReportes> response) {
                if(response.code()==200){
                    JSONReportes jsonResponse = response.body();
                    array.dataRep = new ArrayList<List<GetuspBuscaContratoSeparado2ListResult>>(asList(jsonResponse.getGetuspBuscaContratoSeparado2ListResult()));


                    Iterator<List<GetuspBuscaContratoSeparado2ListResult>> itData = array.dataRep.iterator();
                    while (itData.hasNext()) {
                        List<GetuspBuscaContratoSeparado2ListResult> dat = (List<GetuspBuscaContratoSeparado2ListResult>) itData.next();
                        for (int i = 0; i < dat.size(); ++i) {
                            Log.d("response100", dat.get(i).getNombre());
                            Log.d("response101", dat.get(i).getApellidoPaterno());
                            Log.d("response102", ((String.valueOf(dat.get(i).getContratoBueno()))));
                            Log.d("response103", dat.get(i).getCONTRATO());


                            MainReportes.Nombre1.setText(dat.get(i).getNombre() + "  " + dat.get(i).getApellidoPaterno() + "  " + dat.get(i).getApellidoMaterno());
                            MainReportes.Direccion1.setText(dat.get(i).getCALLE() + "  " + dat.get(i).getNUMERO() + "  " + dat.get(i).getCOLONIA());
                            MainReportes.contrato1.setText(dat.get(i).getCONTRATO());
                            MainReportes.ciudad1.setText(dat.get(i).getCIUDAD());

                            if (response.code() == 200) {
                                abc = dat.get(i).contratoBueno;
                                getServiciosAsignados();
                            }



                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<JSONReportes> call, Throwable t) {

            }

        });

    }

    public void getTecSecR(final Context context) {
        Array.Clv_TecSecR = new ArrayList<Integer>();
        Array.Clv_TecSecR.add(0,-1);

        Service service = null;
        try {
            service = services.getTecSecRService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JSONTecSecReport> call = service.getTec();
        call.enqueue(new Callback<JSONTecSecReport>() {


            @Override
            public void onResponse(Call<JSONTecSecReport> call, Response<JSONTecSecReport> response) {
                if(response.code()==200){
                    JSONTecSecReport jsonResponse = response.body();
                    array.dataTECSEC = new ArrayList<List<GetMuestraTecnicosAlmacenListResult>>((asList(jsonResponse.getGetMuestraTecnicosAlmacenListResult())));
                    Iterator<List<GetMuestraTecnicosAlmacenListResult>> itdata = array.dataTECSEC.iterator();
                    while (itdata.hasNext()) {

                        List<GetMuestraTecnicosAlmacenListResult> dat = itdata.next();
                        datos = new String[dat.size() + 1];
                        int j = 1;
                        datos[0] = a;
                        for (int i = 0; i < dat.size(); i++) {
                            Log.d("descripcion81", String.valueOf(dat.get(i).getNombre()));
                            datos[j] = dat.get(i).getNombre();
                            Array.Clv_TecSecR.add(j, dat.get(i).getClvTecnico());

                            j = j + 1;

                        }

                        adapterTecSecR = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        HorasFragment.TecSec1.setAdapter(adapterTecSecR);


                    }
                }
            }

            @Override
            public void onFailure(Call<JSONTecSecReport> call, Throwable t) {

            }


        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void getValidaOrdSer(final Context context) {

        Service service = null;
        try {
            service = services.getValidaOrdSerService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getVALIOrdSer();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if(response1.code()==200){
                    String string1 = String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult"));

                    if(String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult")).length()==2){
                        getChecaCAMDO(context);
                        Log.d("exito","1");
                    }else{
                        EjecutarFragment.eject.setEnabled(true);
                        Toast.makeText(context,"Error"+string1,Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void getChecaCAMDO(final Context context) {

        Service service = null;
        try {
            service = services.getChecaCAMDOService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getChecaCAMDO();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if(response1.code()==200){
                    JsonObject jsonObject = response1.body().getAsJsonObject("GetCheca_si_tiene_camdoResult");
                    //  String string = String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult"));
                    // txtExtencion.setText(string);
                    GetCheca_si_tiene_CAMDOModel checa = new GetCheca_si_tiene_CAMDOModel(
                            jsonObject.get("Error").getAsString()
                    );
                    if (checa.Error.equals("0")) {
                        getAddRelOrdUsu(context);
                        Log.d("exito","2");
                    } else {
                        Toast.makeText(context, "Error" + checa.Error, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void getAddRelOrdUsu(final Context context) {

        Service service = null;
        try {
            service = services.getADDRELORDUSUService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getADDRELORDUSU();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                Log.d("exito","llego al 3");
                if(response1.code()==200){
                    getDeepMODORDSER(context);
                    Log.d("exito","3");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }


    public void getDeepMODORDSER(final Context context) {

        Service service = null;
        try {
            service = services.getDeppMODORDSERService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getMODORDSER();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {

                Log.d("exito","llego al 4");
                if (response1.code() == 200) {
                        getGuardaHora(context);
                        Log.d("exito","4");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void getGuardaHora(final Context context) {

        Service service = null;
        try {
            service = services.getGuardaHoraService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getGuardaHora();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {


                if(response1.code()==200){
                    getGuardaOrdSerAparatos(context);
                    Log.d("exito","5");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void getGuardaOrdSerAparatos(final Context context) {

        Service service = null;
        try {
            service = services.getGuardaOrdSerAparatosService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getGUARDAOrdSerAparatos();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                Log.d("exito","llega a 6");
                //String string1 = String.valueOf(response1.body().getAsJsonPrimitive("AddSP_LLena_Bitacora_OrdenesResult"));
                if (response1.code() == 200) {
                    addLlenaBitacora(context);
                    Log.d("exito","6");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void addLlenaBitacora(final Context context) {

        Service service = null;
        try {
            service = services.getAddLlenaBitacoraService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getLLENABITACORA_ORD();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                int IS=0;
                if(response1.code()==200){
                    if(String.valueOf(response1.body().getAsJsonPrimitive("AddSP_LLena_Bitacora_OrdenesResult")).equals("-1")){
                        Iterator<List<GetBUSCADetOrdSerListResult>> itData = Array.dataTrabajos.iterator();
                        List<GetBUSCADetOrdSerListResult> dat =  itData.next();
                        for(int a=0; a<dat.size(); a++){
                            if(dat.get(a).getClvTrabajo()==1270||dat.get(a).getClvTrabajo()==1271||dat.get(a).getClvTrabajo()==1272){
                                IS=1;
                            }
                        }
                        if(IS==1){
                            GuardaCoordenadas(context);
                            Log.d("exito","7");
                        }else{
                            Intent intent = new Intent(context, Orden.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            context.startActivity(intent);
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }


    ////////////////////////Ejecutar Reporte/////////////
    public void getValidaReporte(final Context context) {

        Service service = null;
        try {
            service = services.getValidaInfoReportes();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getValidaRep();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if (response1.code() == 200) {
                    JsonObject jsonObject = response1.body().getAsJsonObject("GetDeepValidaQuejaCompaniaAdicResult");
                    GetDeepValidaQuejaCompaniaAdicModel checa = new GetDeepValidaQuejaCompaniaAdicModel(
                            jsonObject.get("BaseIdUser").getAsInt()
                    );



                    if (checa.getBaseIdUser() == 0) {

                    }
                }
            }


            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //////////////////horas///////////////
    public void getGuardaHoraReporte(final Context context) {

        Service service = null;
        try {
            service = services.getGuardaHoraReporte();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getHiHf();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if (response1.code() == 200) {
                    if (String.valueOf(response1.body().getAsJsonPrimitive("GetGuardaHoraOrdenResult")).equals(0)) {

                        getValidaReporte(context);

                        Log.d("exito","8");

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    ///////////////////guardar campos///////////
    public void getGuardaCampos(final Context context) {

        Service service = null;
        try {
            service = services.getGuardaInfoReportes();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getLLenaReporte();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                // Log.d("wer","asd");
                if (response1.code() == 200) {
                    if (String.valueOf(response1.body().getAsJsonPrimitive("UpdateQuejasResult")).equals(-1)) {
                        Log.d("exito","9");

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    ////////////////////////////////////////////////////////////////
    public void GuardaCoordenadas(final Context context) {

        Service service = null;
        try {
            service = services.getGuardaCoordenadasService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getGuardaCoordenadas();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                reintentaB=0;

                if(response1.code()==200){
                    ConsultaIp(context);
                    Log.d("exito","10");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void ConsultaIp(final Context context) {

        Service service = null;
        try {
            service = services.getConsultaIpService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getConsultaIp();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if(response1.code()==200){
                    jsonConsultaIp = new JsonObject();
                    jsonConsultaIp = response1.body().getAsJsonObject("GetConsultaIpPorContratoResult");
                    ConsultaIpModel user = new ConsultaIpModel(
                            jsonConsultaIp.get("AplicaReintentar").getAsBoolean(),
                            jsonConsultaIp.get("Msg").getAsString()
                    );
                    reintentarComando = String.valueOf(user.AplicaReintentar);
                    msgComando = user.Msg;
                    for(int a=0;a<1;a++){
                        if(reintentarComando.equals("true")){
                            reiniciar.setEnabled(true);
                            msgEjecutarOrd.setText(Request.msgComando);
                        }else{
                            if(msgComando.length()>3){
                                msgEjecutarOrd.setText(msgComando);
                                Login.esperar(5);
                                ((Activity)context).finish();
                            }else{
                                Login.esperar(3);
                                retry(call);
                            }
                        }
                    }




                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("error", t.getMessage());
            }

            public  void retry(Call<JsonObject> call){
                call.clone().enqueue(this);
            }
        });


    }
    public void ReintentarComando(final Context context) {
        reintentaB=0;
        Service service = null;
        try {
            service = services.getReintentarComandoService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getReintentaComando();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {

                if(response1.code()==200){
                    ConsultaIp(context);
                    msgEjecutarOrd.setText("");
                    reiniciar.setEnabled(true);
                    Log.d("exito","11");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void SetCambioAparato(final Context context) {

        Service service = null;
        try {
            service = services.getCAPATService();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.getCAPAT();
        call.enqueue(new Callback<JsonObject>() {


            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {

                if(response1.code()==200){
                    Toast.makeText(context, "Se ha guardado el aparato correctamente", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(context, "Error al agregar el aparato", Toast.LENGTH_SHORT).show();
                    cambioA=false;
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void send_aparat() {

        adaptertrabajos.norec();

        Service service = null;
        try {
            service = services.recibiapar();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<JsonObject> call = service.noent();
        call.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if (response1.code() == 200) {
                    Toast.makeText(getApplicationContext(), "Envio de aparatos con exito", Toast.LENGTH_SHORT);
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });
    }
//////////////

    public void getChecaExt(final Context context) {
        Service service = null;
        service = services.getChecaExtService();
        Call<JsonObject> call = service.getChecaExt();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    JsonObject userJson = response.body().getAsJsonObject("GetUspChecaSiTieneExtensionesResult");
                    ChecaSiExtencionesModel user = new ChecaSiExtencionesModel(
                            userJson.get("BND").getAsInt(),
                            userJson.get("NUMEXT").getAsInt()
                    );
                    if(user.BND==1){
                        MuestraBit(context);
                        LlenaExt(context);
                        nExtenciones=user.BND;

                    }else{
                        MuestraBit(context);
                    }
                }



            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }



    public void MuestraBit(final Context context) {
        Service service = null;
        service = services.getMuestraBitService();

        Call<JSONDetalleBitacora> call = service.getMuestraBit();
        call.enqueue(new Callback<JSONDetalleBitacora>() {

            @Override
            public void onResponse(Call<JSONDetalleBitacora> call, Response<JSONDetalleBitacora> response1) {
                if (response1.code() == 200) {
                    array.detalleBit.clear();
                    array.detalleBit.add(0,"---Seleccionar---");
                    int j=1;
                    JSONDetalleBitacora jsonResponse = response1.body();
                    array.dataDetBit = new ArrayList<List<DetalleBitacoraModel>>(asList(jsonResponse.detalleBitacoraModel()));
                    Iterator<List<DetalleBitacoraModel>> itData = array.dataDetBit.iterator();
                    while (itData.hasNext()) {
                        List<DetalleBitacoraModel> dat = itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            array.detalleBit.add(j,dat.get(i).Descripcion);
                            j=j+1;
                        }

                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.detalleBit);
                    Materiales.descripcionMat.setAdapter(arrayAdapter);
                }
            }
            @Override
            public void onFailure(Call<JSONDetalleBitacora> call, Throwable t) {

            }

        });
    }
    //////////////////////////////
    public void DetalleBit(final Context context) {



        Service service = null;
        service = services.getDetalleBitService();

        Call<JSONDescripcionArticulosBit> call = service.getDetalleBit();
        call.enqueue(new Callback<JSONDescripcionArticulosBit>() {

            @Override
            public void onResponse(Call<JSONDescripcionArticulosBit> call, Response<JSONDescripcionArticulosBit> response1) {
                if (response1.code() == 200) {
                    array.descripcionArtBit.clear();
                    array.descripcionArtBit.add(0,"---Seleccionar---");
                    int j=1;
                    JSONDescripcionArticulosBit jsonResponse = response1.body();
                    array.dataDetArtBit = new ArrayList<List<DescripcionArticuloModel>>(asList(jsonResponse.descripcionArticuloModel()));
                    Iterator<List<DescripcionArticuloModel>> itData = array.dataDetArtBit.iterator();
                    while (itData.hasNext()) {
                        List<DescripcionArticuloModel> dat = itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            array.descripcionArtBit.add(j,dat.get(i).Nombre);
                            j=j+1;
                        }

                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.descripcionArtBit);
                    Materiales.clasificacionMat.setAdapter(arrayAdapter);
                }
            }
            @Override
            public void onFailure(Call<JSONDescripcionArticulosBit> call, Throwable t) {

            }

        });
    }

    public void LlenaExt(final Context context) {



        Service service = null;
        service = services.getLlenaExtService();

        Call<JSONLlenaExtenciones> call = service.getLlenaExt();
        call.enqueue(new Callback<JSONLlenaExtenciones>() {

            @Override
            public void onResponse(Call<JSONLlenaExtenciones> call, Response<JSONLlenaExtenciones> response1) {
                if (response1.code() == 200) {
                    Materiales.extMat.setVisibility(View.VISIBLE);
                    array.descripcionExt.clear();
                    array.descripcionExt.add(0,"---Seleccionar---");
                    int j=1;
                    JSONLlenaExtenciones jsonResponse = response1.body();
                    array.dataLlenaExt = new ArrayList<List<LlenaExtencionesModel>>(asList(jsonResponse.llenaExtencionesModel()));
                    Iterator<List<LlenaExtencionesModel>> itData = array.dataLlenaExt.iterator();
                    while (itData.hasNext()) {
                        List<LlenaExtencionesModel> dat = itData.next();

                        for (int i = 0; i < dat.size(); i++) {
                            array.descripcionExt.add(j,dat.get(i).DESCRIPCION);
                            j=j+1;
                        }

                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.descripcionExt);
                    Materiales.spinnerExtMat.setAdapter(arrayAdapter);
                }
            }
            @Override
            public void onFailure(Call<JSONLlenaExtenciones> call, Throwable t) {

            }

        });
    }
    public void getTipoMat() {
        Service service = null;
        service = services.getTipoMatService();
        Call<JsonObject> call = service.getTipoMat();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    JsonObject userJson = response.body().getAsJsonObject("GetSoftv_ObtenTipoMaterialResult");
                    TipoMaterialModel user = new TipoMaterialModel(
                            userJson.get("Tipo").getAsString()
                    );
                    if(user.Tipo.equals("Piezas")){
                        Materiales.piezasMat.setVisibility(View.VISIBLE);
                        pieza=true;
                        // Materiales.metrosMat.setVisibility(View.VISIBLE);
                    }else{
                        Materiales.metrosMat.setVisibility(View.VISIBLE);
                        pieza=false;
                    }
                }



            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void getValidaPreDes(final Context context) {
        Service service = null;
        service = services.getValidaPreService();
        Call<JsonObject> call = service.getValidaPre();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    String dato;
                    dato= String.valueOf(response.body().getAsJsonPrimitive("ValidaExisteTblPreDescargaMaterialResult"));
                    if(dato.equals("0")){
                        addPreDes(context);
                    }
                    if(dato.equals("1")){
                        Toast.makeText(context,"Ya existe ese tipo de material",Toast.LENGTH_SHORT).show();
                        getPredescarga(context);
                    }

                }



            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void addPreDes(final Context context) {
        Service service = null;
        service = services.addPreDescargaService();
        Call<JsonObject> call = service.addPreDescarga();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code()==200){
                    Toast.makeText(context,"Se agrego correctamente",Toast.LENGTH_SHORT).show();
                    getPredescarga(context);
                }else{

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void getPredescarga(final Context context){
        Service service = null;
        service = services.getPreDescargaService();
        Call<JSONPreDescarga> call = service.getPreDescarga();
        call.enqueue(new Callback<JSONPreDescarga>() {
            @Override
            public void onResponse(Call<JSONPreDescarga> call, Response<JSONPreDescarga> response) {
                array.listaTabla.clear();
               /* array.listaTabla.add("Clave");
                array.listaTabla.add("Descripcion");
                array.listaTabla.add("Cantidad");
                array.listaTabla.add("Metraje inicial int.");
                array.listaTabla.add("Metraje final int.");
                array.listaTabla.add("Metraje inicial ext.");
                array.listaTabla.add("Metraje final ext.");*/
                if(response.code()==200){
                    JSONPreDescarga jsonResponse = response.body();
                    array.dataPreDescarga = new ArrayList<List<dameTblPreDescargaMaterialResultModel>> (asList(jsonResponse.getdameTblPreDescargaMaterialResultModel()));
                    Iterator<List<dameTblPreDescargaMaterialResultModel>> itdata = array.dataPreDescarga.iterator();

                    while (itdata.hasNext()) {
                        List<dameTblPreDescargaMaterialResultModel> dat = itdata.next();
                        for (int i = 0; i < dat.size(); i++) {
                            array.listaTabla.add(String.valueOf(dat.get(i).clvOrden));
                            array.listaTabla.add(String.valueOf(dat.get(i).contrato));
                            array.listaTabla.add(String.valueOf(dat.get(i).cantidadUtilizada));
                            array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicio));
                            array.listaTabla.add(String.valueOf(dat.get(i).metrajeFin));
                            array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicioExterior));
                            array.listaTabla.add(String.valueOf(dat.get(i).metrajeFinExterior));

                        }
                    }



                }
            }

            @Override
            public void onFailure(Call<JSONPreDescarga> call, Throwable t) {

            }
        });
    }
}










