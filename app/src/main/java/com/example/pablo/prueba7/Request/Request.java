package com.example.pablo.prueba7.Request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.pablo.prueba7.Activitys.Orden;
import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Activitys.CambioDom;

import com.example.pablo.prueba7.Activitys.CambioAparato;
import com.example.pablo.prueba7.Fragments.EjecutarFragment;
import com.example.pablo.prueba7.Activitys.ExtensionesAdi;
import com.example.pablo.prueba7.Fragments.HorasFragment;



import com.example.pablo.prueba7.Activitys.Inicio;
import com.example.pablo.prueba7.Fragments.InstalacionFragment;
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
import com.example.pablo.prueba7.Listas.JSONMediosSer;
import com.example.pablo.prueba7.Listas.JSONNombreTecnico;
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
import com.example.pablo.prueba7.Modelos.ConsultaIpModel;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
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
import com.example.pablo.prueba7.Modelos.OrdSer;
import com.example.pablo.prueba7.Modelos.ProximaCitaModel;
import com.example.pablo.prueba7.Modelos.Queja;
import com.example.pablo.prueba7.Modelos.UserModel;
import com.example.pablo.prueba7.Services.Services;
import com.example.pablo.prueba7.Fragments.TrabajosFragment;
import com.example.pablo.prueba7.Activitys.asignacion;
import com.example.pablo.prueba7.Activitys.asignado;
import com.example.pablo.prueba7.sampledata.Service;
import com.google.gson.JsonObject;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.example.pablo.prueba7.Activitys.ExtensionesAdi.txtExtencion;
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
    public static String clave_tecnico,msgComando="",sigueinteTrabajo,siguenteDireccion;;
    public static String nombre_tecnico;
    public static Long contbu;
    public static Long abc;
    public static String Obs;
    public static int clvP;
    public static int tecC;
    public int reintentaB;

        public static Integer clvQ;
    public static String reintentarComando;
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
                try {
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

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error en el Login(request)", Toast.LENGTH_LONG).show();
                }


                if (response.code() == 200) {
                    getClv_tecnico(context);
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
                if (response.code() == 200) {
                    Toast.makeText(context, "Bienvenido", Toast.LENGTH_LONG).show();
                    getProximaCita(context);
                    getOrdenes();

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
                sigueinteTrabajo= "Tipo de trabajo: " + user.Tipo + " Contrato: " + user.Contrato + " Hora: " + user.Hora;
                siguenteDireccion = "Colonia: " + user.Colonia + " Calle: " + user.Calle;
                Intent intento = new Intent(context, Inicio.class);
                intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intento);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    ///////////////////Status,Observaciones, ORDENES///////////////////////////
    public void getOrdenes() {
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
                getQuejas();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

    /////////////////Lista de ordenes/////////////////////////////
    public void getListQuejas() {

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
                QuejasList jsonResponse = response.body();

                array.dataquejas = new ArrayList<List<ListadoQuejasAgendadas>>(asList(jsonResponse.GetDameListadoQuejasAgendadasResult()));
                Iterator<List<ListadoQuejasAgendadas>> itData = array.dataquejas.iterator();
                while (itData.hasNext()) {
                    List<ListadoQuejasAgendadas> dat = (List<ListadoQuejasAgendadas>) itData.next();
                    Array.Queja.clear();
                    Array.nombreQ.clear();
                    Array.statusQ.clear();
                    Array.contratoQ.clear();
                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("Clave Reporte", String.valueOf(dat.get(i).getClvQueja()));
                        Log.d("Contrato", dat.get(i).getContrato());
                        Log.d("Nombre", dat.get(i).getNombre());
                        Log.d("Status", dat.get(i).getStatus());


                        Array.Queja.add(String.valueOf(dat.get(i).getClvQueja()));
                        Array.contratoQ.add(String.valueOf(dat.get(i).getContrato()));
                        Array.nombreQ.add(String.valueOf(dat.get(i).getNombre()));
                        Array.statusQ.add(String.valueOf(dat.get(i).getStatus()));

                    }
                }
            }

            @Override
            public void onFailure(Call<QuejasList> call, Throwable t) {

            }


        });

    }

    //////////////////Quejas////////////////////////////
    public void getQuejas() {
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
                Inicio.Grafica();

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }


        });
    }


    public void getListOrd() {

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
                    }
                }
            }

            @Override
            public void onFailure(Call<Example1> call, Throwable t) {

            }


        });

    }

    ///////////////////Consuta pantalla ordenes///////////////////////////
    public void getDeepCons() {

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
                JsonObject userJson = response.body().getAsJsonObject("GetDeepConsultaOrdSerResult");
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
                try {
                    MainActivity.Contrato.setText(String.valueOf(DeepConsModel.getContatoCom()));
                } catch (Exception e) {

                }
                try {
                    InstalacionFragment.Obs.setText(String.valueOf(DeepConsModel.Obs));
                } catch (Exception e) {

                }


                try {
                    if (DeepConsModel.STATUS.equals("E")) {
                        MainActivity.Status.setText("Ejecutada");

                    } else if (DeepConsModel.STATUS.equals("P")) {
                        MainActivity.Status.setText("Pendiente");

                    } else if (DeepConsModel.STATUS.equals("V")) {
                        MainActivity.Status.setText("En Visita");
                    }
                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    /////////////////Informacion del Cliente/////////////////////////////
    public void getInfoCliente() {

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
                JsonObject userJson = response.body().getAsJsonObject("GetDeepBUSCLIPORCONTRATO_OrdSerResult");
                InfoClienteModelo user = new InfoClienteModelo(
                        userJson.get("CALLE").getAsString(),
                        userJson.get("CIUDAD").getAsString(),
                        userJson.get("COLONIA").getAsString(),
                        userJson.get("Compania").getAsString(),
                        userJson.get("NOMBRE").getAsString(),
                        userJson.get("NUMERO").getAsString()
                );

                MainActivity.Empresa.setText(InfoClienteModelo.Compania);
                MainActivity.Direccion.setText(InfoClienteModelo.CALLE + " " + InfoClienteModelo.NUMERO + " " + InfoClienteModelo.COLONIA);
                MainActivity.Nombre.setText(InfoClienteModelo.NOMBRE);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    /////////////////ServiciosdelCliente/////////////////////////////
    public void getServicios() {

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
                ArrayList<String> resumen = new ArrayList<>();
                Example2 jsonResponse = response.body();
                array.dataclientes = new ArrayList<List<GetdameSerDELCliresumenResult>>(asList(jsonResponse.getdameSerDELCliresumenResult()));
                Iterator<List<GetdameSerDELCliresumenResult>> itData = array.dataclientes.iterator();
                while (itData.hasNext()) {
                    List<GetdameSerDELCliresumenResult> dat = (List<GetdameSerDELCliresumenResult>) itData.next();
                    for (int i = 0; i < dat.size(); i++) {
                        String a="";
                        a=dat.get(i).getResumen()+'\n';
                        resumen.add(i,a);
                    }
                    MainActivity.InfoServicios.setText(resumen.toString());
            
                }
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {

            }


        });
    }

    /////////////////////////////informacion trabajos//////////////////////////////
    public void getTrabajos() {
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
                Example3 jsonResponse = response.body();
                array.dataTrabajos = new ArrayList<List<GetBUSCADetOrdSerListResult>>(asList(jsonResponse.getGetBUSCADetOrdSerListResult()));
                Iterator<List<GetBUSCADetOrdSerListResult>> itData = array.dataTrabajos.iterator();
                Array.trabajox.clear();
                Array.accionx.clear();
                while (itData.hasNext()) {
                    List<GetBUSCADetOrdSerListResult> dat = (List<GetBUSCADetOrdSerListResult>) itData.next();
                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("response11", dat.get(i).getDescripcion());

                        Array.trabajox.add(String.valueOf(dat.get(i).getDescripcion()));
                        Array.accionx.add(String.valueOf(dat.get(i).getAccion()));
                        Array.clavex.add(dat.get(i).getClave());
                        Array.clv_trabajox.add(dat.get(i).getClvTrabajo());
                        Array.recibix.add(dat.get(i).getSeRealiza());


                    }
                }
                trabajos.setAdapter(adaptertrabajos);


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
                JSONTecSec jsonResponse = response.body();
                Array.dataTecSec = new ArrayList<>(asList(jsonResponse.GetMuestraRelOrdenesTecnicosListResult()));
                Iterator<List<GetMuestraRelOrdenesTecnicosListResult>> itdata = Array.dataTecSec.iterator();
                while (itdata.hasNext()){
                    List<GetMuestraRelOrdenesTecnicosListResult> dat = itdata.next();
                    datos = new String[dat.size()+1];
                    int j=1;
                    datos[0] = a;
                    for(int i=0; i< dat.size(); i++){
                        Log.d("responsetecsec", dat.get(i).getNOMBRE());
                        datos[j] = dat.get(i).getNOMBRE();
                        Array.clv_tecnicoSecundario.add(j,dat.get(i).getCLV_TECNICO());

                        j=j+1;
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                    InstalacionFragment.TecSec.setAdapter(adapter);
                    InstalacionFragment.Obs.setText(String.valueOf(DeepConsModel.Obs));



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

                String string = String.valueOf(response1.body().getAsJsonPrimitive("GetCONCONEXResult"));
                txtExtencion.setText(string);
                if (response1.code() == 200) {
                    Intent intento = new Intent(context, ExtensionesAdi.class);
                    context.startActivity(intento);
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
                    try{
                        CambioAparato.aparato.setSelection(CambioAparato.obtenerPosicionAC(CambioAparatoDeepModel.AparatoCliente));
                    }catch (Exception e){

                    }


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
                    try{
                        CambioAparato.estado.setSelection(CambioAparato.obtenerPosicionSA(CambioAparato.estado,CambioAparatoDeepModel.StatusEntrega));
                    }catch (Exception e){

                    }
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
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                    CambioAparato.aparatoAsignar.setAdapter(adapter);
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
                CambioAparatoDeepModel.StatusEntrega="";
                JsonObject userJson = response.body().getAsJsonObject("GetCambioAparatoDeepResult");
                try {
                    CambioAparatoDeepModel user = new CambioAparatoDeepModel(
                            userJson.get("AparatoAsignar").getAsInt(),
                            userJson.get("AparatoCliente").getAsInt(),
                            userJson.get("TipoAparatoAsignar").getAsInt(),
                            userJson.get("StatusEntrega").getAsString()
                    );
                    getCliApa(context);
                    getStatusApa(context);
                    ///
                    Iterator<List<GetListClienteAparatosResult>> itdata = Array.dataCliApa.iterator();
                    List<GetListClienteAparatosResult> dat = itdata.next();
                    CambioAparato.idArticulo = dat.get(CambioAparato.obtenerPosicionTA(CambioAparato.tipoAparato,CambioAparatoDeepModel.TipoAparatoAsignar)).getIdArticulo();
                    CambioAparato.contrato = dat.get(CambioAparato.obtenerPosicionTA(CambioAparato.tipoAparato,CambioAparatoDeepModel.TipoAparatoAsignar)).getControNet();
                    getApaTipo(context);

                    //////////////////////
                    Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata1 = Array.dataApaTipo.iterator();
                    List<GetListTipoAparatosByIdArticuloResult> dat1 = itdata1.next();
                    CambioAparato.idArticulo2 = dat1.get(CambioAparato.obtenerPosicionA(CambioAparato.aparatoAsignar,CambioAparatoDeepModel.AparatoAsignar)).getIdArticulo();
                    getApaTipDis(context);



                }catch (Exception e){
                    getCliApa(context);
                    getStatusApa(context);
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
                JSONCAMDO jsonResponse = response.body();
                array.dataCAMDO = new ArrayList<List<GetDameDatosCAMDOResult>>(asList(jsonResponse.getDameDatosCAMDOResult()));
                Iterator<List<GetDameDatosCAMDOResult>> itdata = array.dataCAMDO.iterator();
                while (itdata.hasNext()) {
                    List<GetDameDatosCAMDOResult> dat = itdata.next();
                    String datos[] = new String[dat.size()];
                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("casa", dat.get(i).getCasa());
                    }
                    c.Ciudad.setText(dat.get(0).getCiudad());
                    c.Localidad.setText(dat.get(0).getLocalidad());
                    c.Colonia.setText(dat.get(0).getColonia());
                    c.Calle.setText(dat.get(0).getCalle());
                    c.Numero.setText(String.valueOf(dat.get(0).getNUMERO()));
                    c.Numero_i.setText(dat.get(0).getNum_int());
                    c.Telefono.setText(dat.get(0).getTELEFONO());
                    c.CalleN.setText(dat.get(0).getCalleNorte());
                    c.CalleS.setText(dat.get(0).getCalleSur());
                    c.CallleE.setText(dat.get(0).getCalleEste());
                    c.CalleO.setText(dat.get(0).getCalleOeste());

                    if (dat.get(0).getCasa().equals("N")) {
                        c.CasaNorte.setVisibility(View.VISIBLE);
                    }
                    if (dat.get(0).getCasa().equals("S")) {
                        c.CasaSur.setVisibility(View.VISIBLE);
                    }
                    if (dat.get(0).getCasa().equals("E")) {
                        c.CasaEste.setVisibility(View.VISIBLE);
                    }
                    if (dat.get(0).getCasa().equals("O")) {
                        c.CasaOeste.setVisibility(View.VISIBLE);
                    }

                    if (response.code() == 200) {
                        Intent intento = new Intent(context, CambioDom.class);
                        context.startActivity(intento);
                    }
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

                array.nombreArbol.clear();
                JSONArbolServicios jsonResponse = response.body();
                array.dataArbSer = new ArrayList<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>>(asList(jsonResponse.GetMuestraArbolServiciosAparatosPorinstalarListResult()));
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                while (itData.hasNext()) {
                    List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();

                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("response21", String.valueOf(dat.get(i).getIdMedio()));
                        array.nombreArbol.add(dat.get(i).getNombre());
                    }
                }
                if (response.code() == 200) {
                    Intent intento25 = new Intent(context, asignacion.class);
                    context.startActivity(intento25);
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
                array.tipoAparato.clear();
                JSONTipoAparatos jsonResponse = response.body();
                array.dataTipoAparatos = new ArrayList<List<GetMuestraTipoAparatoListResult>>(asList(jsonResponse.GetMuestraTipoAparatoListResult()));
                Iterator<List<GetMuestraTipoAparatoListResult>> itData = array.dataTipoAparatos.iterator();
                array.tipoAparato.add("Seleccione aparato");
                while (itData.hasNext()) {
                    List<GetMuestraTipoAparatoListResult> dat = (List<GetMuestraTipoAparatoListResult>) itData.next();

                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("response23", dat.get(i).getNombre());
                        array.tipoAparato.add(dat.get(i).getNombre());
                    }
                }
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.tipoAparato);
                asignado.spinnerAparato.setAdapter(adapter1);


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
                JSONSolucion jsonResponse = response.body();
                array.dataSOL = new ArrayList<List<GetMUESTRATRABAJOSQUEJASListResult>>((asList(jsonResponse.getGetMUESTRATRABAJOSQUEJASListResult())));
                Iterator<List<GetMUESTRATRABAJOSQUEJASListResult>> itdata = array.dataSOL.iterator();
                while (itdata.hasNext()) {
                    List<GetMUESTRATRABAJOSQUEJASListResult> dat = itdata.next();

                    datos = new String[dat.size()+1];
                    int j=1;
                    datos[0] = f;
                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("descripcion", String.valueOf(dat.get(i).dESCRIPCION));
                        Log.d("occ", String.valueOf(dat.get(i).cLVTRABAJO));
                        datos[j] = dat.get(i).getDESCRIPCION();

                        Array.clv_Soluc.add(j,dat.get(i).getCLVTRABAJO());

                        j = j + 1;

                        //clvQ=dat.get(i).getCLVTRABAJO();

                    }


                    ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                    solucion.setAdapter(adapter);
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


                        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Asigna);
                        TrabajosFragment.prioridad.setAdapter(adapter);


                        ArrayAdapter adapter1 = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Asigna1);
                        TrabajosFragment.clasific.setAdapter(adapter1);


                        TrabajosFragment.desc.setText(String.valueOf(dat.get(i).getObservaciones()));
                        TrabajosFragment.problm.setText(String.valueOf(dat.get(i).getProblema()));

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


                        abc = dat.get(i).contratoBueno;
                        getServiciosAsignados();
                        getTecSecR(context);


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
                JSONTecSecReport jsonResponse = response.body();
                array.dataTECSEC = new ArrayList<List<GetMuestraTecnicosAlmacenListResult>>((asList(jsonResponse.getGetMuestraTecnicosAlmacenListResult())));
                Iterator<List<GetMuestraTecnicosAlmacenListResult>> itdata = array.dataTECSEC.iterator();
                while (itdata.hasNext()) {

                    List<GetMuestraTecnicosAlmacenListResult> dat = itdata.next();
                    datos = new String[dat.size()+1];
                    int j=1;
                    datos[0] = a;
                    for (int i = 0; i < dat.size(); i++) {
                        Log.d("descripcion81", String.valueOf(dat.get(i).getNombre()));
                        datos[j] = dat.get(i).getNombre();
                        Array.Clv_TecSecR.add(j,dat.get(i).getClvTecnico());

                        j = j + 1;

                    }

                    ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                    HorasFragment.TecSec1.setAdapter(adapter);


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

                String string1 = String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult"));
                if(response1.code()==200){
                    if(String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult")).length()==2){
                        getChecaCAMDO(context);
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
                JsonObject jsonObject = response1.body().getAsJsonObject("GetCheca_si_tiene_camdoResult");
                //  String string = String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult"));
                // txtExtencion.setText(string);
                GetCheca_si_tiene_CAMDOModel checa = new GetCheca_si_tiene_CAMDOModel(
                        jsonObject.get("Error").getAsString()
                );


                if (response1.code() == 200) {
                    if (checa.Error.equals("0")) {
                        getAddRelOrdUsu(context);
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

                String string1 = String.valueOf(response1.body().getAsJsonPrimitive("AddNueRelOrdenUsuarioResult"));
                if(response1.code()==200){
                    getDeepMODORDSER(context);
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

                JsonObject jsonObject = response1.body().getAsJsonObject("GetDeepMODORDSERResult");
                GetDeepMODORDSERModel checa = new GetDeepMODORDSERModel(
                        jsonObject.get("BaseIdUser").getAsInt()
                );


                if (response1.code() == 200) {
                    if (checa.getBaseIdUser() == 0) {
                        getGuardaHora(context);
                    }
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

                //String string1 = String.valueOf(response1.body().getAsJsonPrimitive("AddSP_LLena_Bitacora_OrdenesResult"));
                if (response1.code() == 200) {
                    addLlenaBitacora(context);
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

                JsonObject jsonObject = response1.body().getAsJsonObject("GetDeepValidaQuejaCompaniaAdicResult");
                GetDeepValidaQuejaCompaniaAdicModel checa = new GetDeepValidaQuejaCompaniaAdicModel(
                        jsonObject.get("BaseIdUser").getAsInt()
                );


                if (response1.code() == 200) {
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

                String string1 = String.valueOf(response1.body().getAsJsonPrimitive("GetGuardaHoraOrdenResult"));
                if (response1.code() == 200) {
                    if (String.valueOf(response1.body().getAsJsonPrimitive("GetGuardaHoraOrdenResult")).equals(0)) {
                        getValidaReporte(context);


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
                jsonConsultaIp = new JsonObject();
                jsonConsultaIp = response1.body().getAsJsonObject("GetConsultaIpPorContratoResult");
                ConsultaIpModel user = new ConsultaIpModel(
                        jsonConsultaIp.get("AplicaReintentar").getAsBoolean(),
                        jsonConsultaIp.get("Msg").getAsString()
                );
                reintentarComando = String.valueOf(user.AplicaReintentar);
                msgComando = user.Msg;

                if(response1.code()==200){

                    for(int a=0;a<1;a++){

                        if(reintentarComando.equals("true")){
                            EjecutarFragment.reiniciar.setEnabled(true);
                            EjecutarFragment.msgEjecutarOrd.setText(Request.msgComando);
                        }else{
                            if(msgComando.length()>3){
                                EjecutarFragment.msgEjecutarOrd.setText(msgComando);
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
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void SetCambioAparato(Context baseContext) {

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
                    Log.d("asd", response1.body().toString());
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


    }










