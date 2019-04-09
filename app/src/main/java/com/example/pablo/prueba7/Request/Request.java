package com.example.pablo.prueba7.Request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pablo.prueba7.Activitys.Orden;
import com.example.pablo.prueba7.Activitys.CambioDom;

import com.example.pablo.prueba7.Activitys.CambioAparato;
import com.example.pablo.prueba7.Activitys.Reportes;
import com.example.pablo.prueba7.Adapters.TablaAdapter;
import com.example.pablo.prueba7.Adapters.ordenes_adapter_result;
import com.example.pablo.prueba7.Fragments.EjecutarFragment;
import com.example.pablo.prueba7.Activitys.ExtensionesAdi;

import com.example.pablo.prueba7.Activitys.Inicio;
import com.example.pablo.prueba7.Fragments.InstalacionFragment;
import com.example.pablo.prueba7.Fragments.Materiales;
import com.example.pablo.prueba7.Fragments.MaterialesFragment;
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
import com.example.pablo.prueba7.Services.Services;
import com.example.pablo.prueba7.Fragments.TrabajosFragment;
import com.example.pablo.prueba7.Activitys.asignacion;
import com.example.pablo.prueba7.Activitys.asignado;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Service;
import com.example.pablo.prueba7.sampledata.SplashActivity;
import com.example.pablo.prueba7.sampledata.Util;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pablo.prueba7.Activitys.CambioAparato.dialogCAPAT;
import static com.example.pablo.prueba7.Activitys.CambioAparato.obtenerPosicionA;
import static com.example.pablo.prueba7.Activitys.CambioAparato.obtenerPosicionAC;
import static com.example.pablo.prueba7.Activitys.CambioAparato.obtenerPosicionSA;
import static com.example.pablo.prueba7.Activitys.CambioAparato.obtenerPosicionTA;
import static com.example.pablo.prueba7.Activitys.Login.contraseña;
import static com.example.pablo.prueba7.Activitys.Login.entrar;
import static com.example.pablo.prueba7.Activitys.Login.usurio;
import static com.example.pablo.prueba7.Activitys.asignacion.dialogAsignacion;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.dialogTrabajos;
import static com.example.pablo.prueba7.Fragments.EjecutarFragment.dialogEjecutar;
import static com.example.pablo.prueba7.Fragments.EjecutarFragment.msgEjecutarOrd;
import static com.example.pablo.prueba7.Fragments.EjecutarFragment.reiniciar;
import static com.example.pablo.prueba7.Fragments.HorasFragment.TecSec1;
import static com.example.pablo.prueba7.Fragments.HorasFragment.tecPosRepo;
import static com.example.pablo.prueba7.Fragments.InstalacionFragment.posTec;
import static com.example.pablo.prueba7.Fragments.Materiales.clasificacionMat;
import static com.example.pablo.prueba7.Fragments.Materiales.descripcionMat;
import static com.example.pablo.prueba7.Fragments.Materiales.posClasMat;
import static com.example.pablo.prueba7.Fragments.Materiales.posDescMat;
import static com.example.pablo.prueba7.Fragments.Materiales.posExtMat;
import static com.example.pablo.prueba7.Fragments.Materiales.spinnerExtMat;
import static com.example.pablo.prueba7.Fragments.Trabajos.adaptertrabajos;
import static com.example.pablo.prueba7.Fragments.Trabajos.trabajos;
import static com.example.pablo.prueba7.Fragments.TrabajosFragment.posSolucionRepo;
import static com.example.pablo.prueba7.Listas.Array.Asigna;
import static com.example.pablo.prueba7.Listas.Array.Asigna1;
import static com.example.pablo.prueba7.Fragments.TrabajosFragment.solucion;
import static java.util.Arrays.asList;

public class Request extends AppCompatActivity {
    Services services = new Services();
    Array array = new Array();
    public static String reintentarComando, obsMA, extencionesE, Obs, clave_tecnico, msgComando = "";
    public static boolean isnet;
    public static Long abc;
    public static int clvP, tecC, nExtenciones = 0;
    public int reintentaB;
    public static ArrayAdapter adapterTecSec, adapterTecSecR;
    public static boolean pieza = false, rapagejecutar = false, extencionesMat = false;
    JsonObject jsonConsultaIp;
    String f = "Seleccione tipo de solucion";
    public static String datos[];
    //--------------------------------//
    private String sigueinteTipo, siguenteContrato, sigueinteHora, siguenteCalle, sigueinteNumero, siguenteColonia, contraroMA, statusMA;
    private int idArticulo, contratoNet;
    //----------------------------------//

    public void ErrorInicioDeSesion(final Context context) {
        try {
            Login.dialogLogin.dismiss();

        } catch (Exception e) {
            Inicio.progressInicio.dismiss();
            Intent intento = new Intent(context, Inicio.class);
            intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intento.putExtra("Reiniciar", "1");
            context.startActivity(intento);

        }

    }

    //Token///
    public void getReviews(final Context context) {

        Service service = services.getClientService(context);
        Call<JsonObject> call = service.getDataUser();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //Peticion de datos sobre el Json "LogOnResult"
                try {
                    if (response.code() == 200) {
                        Util.preferences = context.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                        Util.editor = Util.preferences.edit();
                        JsonObject userJson = response.body().getAsJsonObject("LogOnResult");
                        //Introduccion de datos del request en el Modelo para poder usarlos
                        UserModel user = new UserModel(
                                userJson.get("Usuario").getAsString(),
                                userJson.get("Token").getAsString(),
                                userJson.get("Codigo").getAsString(),
                                userJson.get("IdUsuario").getAsInt()
                        );
                        Util.editor.putString("token", user.getCodigo());

                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("Clv_Usuario", Util.getUsuarioPreference(Util.preferences));
                        Util.editor.commit();
                        getClv_tecnico(context);
                    } else {
                        Login.dialogLogin.dismiss();
                    }
                } catch (Exception e) {
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Login.dialogLogin.dismiss();
                Toast.makeText(context, "Error al iniciar sesión", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Clave Tecnico//
    public void getClv_tecnico(final Context context) {
        Util.preferences = context.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        Util.editor = Util.preferences.edit();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Clv_Usuario", Util.getUsuarioPreference(Util.preferences));
        } catch (Exception e) {
        }
        Call<JSONResponseTecnico> call = services.RequestPost(context, jsonObject).getDataTec();
        call.enqueue(new Callback<JSONResponseTecnico>() {
            @Override
            public void onResponse(Call<JSONResponseTecnico> call, Response<JSONResponseTecnico> response) {
                //Guardar Body del request en JSONResponseTecnico ya que lo regresa como una lista
                try {
                    if (response.code() == 200) {

                        JSONResponseTecnico jsonResponse = response.body();
                        //Pide datos sobre el Json Get_ClvTecnicoResult haciendo referencia al JsonResponse donde se guardo
                        array.datatec = new ArrayList<List<Get_ClvTecnicoResult>>(asList(jsonResponse.Get_ClvTecnicoResult()));
                        //Se crea un Iterator con la lista para que se pueda recorrer con la informacion
                        Iterator<List<Get_ClvTecnicoResult>> iteData = array.datatec.iterator();
                        while (iteData.hasNext()) {
                            List<Get_ClvTecnicoResult> data = (List<Get_ClvTecnicoResult>) iteData.next();
                            //Se recorre la lista y se guarla la informacion en el Modelo
                            Util.editor.putString("nombre_Tecnico", data.get(0).getNombre_tec());
                            Util.editor.putInt("clvTecnico", data.get(0).getClv_tecnico());
                        }
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("clv_tecnico", Util.getClvTecnico(Util.preferences));
                        getProximaCita(context, jsonObject);
                        Util.editor.commit();
                    } else {
                        Login.dialogLogin.dismiss();
                        Toast.makeText(context, "Error al conseguir clave técnico", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<JSONResponseTecnico> call, Throwable t) {
                ErrorInicioDeSesion(context);
                finish();
            }
        });
    }

    //Proxima Cita//
    public void getProximaCita(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDataProx();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    try {
                        JsonObject userJson = response.body().getAsJsonObject("GetDameSiguienteCitaResult");
                        ProximaCitaModel user = new ProximaCitaModel(
                                userJson.get("Calle").getAsString(),
                                userJson.get("Clave").getAsInt(),
                                userJson.get("Colonia").getAsString(),
                                userJson.get("Contrato").getAsString(),
                                userJson.get("Hora").getAsString(),
                                userJson.get("NUMERO").getAsString(),
                                userJson.get("Tipo").getAsString()
                        );

                        sigueinteTipo = user.Tipo;
                        siguenteContrato = user.Contrato;
                        sigueinteHora = user.Hora;
                        siguenteCalle = user.Calle;
                        sigueinteNumero = user.NUMERO;
                        siguenteColonia = user.Colonia;


                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("clv_tecnico", Util.getClvTecnico(Util.preferences));
                        getOrdenes(context, jsonObject);
                    } catch (Exception e) {
                    }
                } else {
                    ErrorInicioDeSesion(context);
                    Toast.makeText(context, "Error al conseguir datos, intente otra vez", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                ErrorInicioDeSesion(context);
                Toast.makeText(context, "Error al conseguir, intente otra vez", Toast.LENGTH_LONG).show();
            }
        });
    }

    //ORDENES//
    public void getOrdenes(final Context context, final JSONObject jsonObject) {
        Call<Example> call = services.RequestPost(context, jsonObject).getDataOrdenes();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try {
                    if (response.code() == 200) {
                        Example jsonResponse = response.body();
                        try {
                            array.dataord = new ArrayList<List<OrdSer>>(asList(jsonResponse.getDameOrdenesQuejasTotalesResult.getOrdSer()));
                            Iterator<List<OrdSer>> itData = array.dataord.iterator();
                            while (itData.hasNext()) {
                                List<OrdSer> dat = (List<OrdSer>) itData.next();
                                for (int i = 0; i < dat.size(); i++) {
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
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("Clv_Usuario", Util.getClvTecnico(Util.preferences));
                        getQuejas(context, jsonObject);
                    } else {
                        ErrorInicioDeSesion(context);
                        Toast.makeText(context, "Error al conseguir, intente otra vez", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                ErrorInicioDeSesion(context);
                Toast.makeText(context, "Error al conseguir, intente otra vez", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Quejas//
    public void getQuejas(final Context context, final JSONObject jsonObject) {
        Call<Example> call = services.RequestPost(context, jsonObject).getDataOrdenes();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try {
                    if (response.code() == 200) {
                        Example jsonResponse = response.body();
                        array.dataque = new ArrayList<List<Queja>>(asList(jsonResponse.getDameOrdenesQuejasTotalesResult.getQueja()));
                        Iterator<List<Queja>> itData = array.dataque.iterator();
                        while (itData.hasNext()) {
                            List<Queja> dat = (List<Queja>) itData.next();
                            for (int i = 0; i < dat.size(); i++) {
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
                        if (SplashActivity.LoginShare == true) {

                            Inicio.Grafica(Inicio.pieChart);
                            Inicio.tipoTrabajo.setText(sigueinteTipo);
                            Inicio.contratoTrabajo.setText(siguenteContrato);
                            Inicio.horaTrabajo.setText(sigueinteHora);
                            Inicio.calleDireccion.setText(siguenteCalle);
                            Inicio.numeroDireccion.setText(sigueinteNumero);
                            Inicio.coloniaDireccion.setText(siguenteColonia);
                            Inicio.progressInicio.dismiss();
                        } else {
                            Intent intento = new Intent(context, Inicio.class);
                            intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            Inicio.Grafica(Inicio.pieChart);
                            intento.putExtra("tipo", sigueinteTipo);
                            intento.putExtra("contrato", siguenteContrato);
                            intento.putExtra("hora", sigueinteHora);
                            intento.putExtra("calle", siguenteCalle);
                            intento.putExtra("numero", sigueinteNumero);
                            intento.putExtra("colonia", siguenteColonia);
                            context.startActivity(intento);
                            Login.dialogLogin.dismiss();
                        }
                    } else {
                        ErrorInicioDeSesion(context);
                        Toast.makeText(context, "Error al conseguir, intente otra vez", Toast.LENGTH_LONG).show();

                    }
                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                ErrorInicioDeSesion(context);
                Toast.makeText(context, "Error al conseguir, intente otra vez", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Lista de ordenes///
    public void getListQuejas(final Context context, final JSONObject jsonObject) {
        Call<QuejasList> call = services.RequestPost(context, jsonObject).getQuejasAgendadas();
        call.enqueue(new Callback<QuejasList>() {
            @Override
            public void onResponse(Call<QuejasList> call, Response<QuejasList> response) {
                if (response.code() == 200) {
                    QuejasList jsonResponse = response.body();
                    Array.Quejassrc.clear();
                    array.dataquejas = new ArrayList<List<ListadoQuejasAgendadas>>(asList(jsonResponse.GetDameListadoQuejasAgendadasResult()));
                    Iterator<List<ListadoQuejasAgendadas>> itData = array.dataquejas.iterator();
                    while (itData.hasNext()) {
                        List<ListadoQuejasAgendadas> dat = (List<ListadoQuejasAgendadas>) itData.next();
                        for (int b = 0; b < 5; b++) {
                            Array.Quejassrc.add(new ArrayList<String>());
                        }
                        for (int i = 0; i < dat.size(); i++) {
                            Array.Quejassrc.get(0).add(String.valueOf(dat.get(i).getClvQueja()));
                            Array.Quejassrc.get(1).add(String.valueOf(dat.get(i).getContrato()));
                            Array.Quejassrc.get(2).add(String.valueOf(dat.get(i).getNombre()));
                            Array.Quejassrc.get(3).add(String.valueOf(dat.get(i).getStatus()));
                            Array.Quejassrc.get(4).add(String.valueOf(dat.get(i).getColonia() + ", " + dat.get(i).getCalle() + ", " + dat.get(i).getNUMERO()));
                        }
                    }
                    Intent intent1 = new Intent(context, Reportes.class);
                    context.startActivity(intent1);

                } else {
                    Toast.makeText(context, "Error al conseguir lista quejas", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<QuejasList> call, Throwable t) {
                Toast.makeText(context, "Error al conseguir lista quejas", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getListOrd(final Context context, final JSONObject jsonObject) {
        Call<Example1> call = services.RequestPost(context, jsonObject).getDataListOrd();
        call.enqueue(new Callback<Example1>() {
            @Override
            public void onResponse(Call<Example1> call, Response<Example1> response) {
                if (response.code() == 200) {
                    Example1 jsonResponse = response.body();
                    array.dataagenda = new ArrayList<List<GetDameListadoOrdenesAgendadasResult>>(asList(jsonResponse.getGetDameListadoOrdenesAgendadasResult()));
                    Iterator<List<GetDameListadoOrdenesAgendadasResult>> itData = array.dataagenda.iterator();
                    while (itData.hasNext()) {
                        List<GetDameListadoOrdenesAgendadasResult> dat = (List<GetDameListadoOrdenesAgendadasResult>) itData.next();
                        Array.Ordenessrc.clear();
                        for (int b = 0; b < 5; b++) {
                            Array.Ordenessrc.add(new ArrayList<String>());
                        }
                        for (int i = 0; i < dat.size(); i++) {
                            Array.Ordenessrc.get(0).add(String.valueOf(dat.get(i).getClvOrden()));
                            Array.Ordenessrc.get(1).add(String.valueOf(dat.get(i).getContrato()));
                            Array.Ordenessrc.get(2).add(String.valueOf(dat.get(i).getNombre()));
                            Array.Ordenessrc.get(3).add(String.valueOf(dat.get(i).getStatus()));
                            Array.Ordenessrc.get(4).add(String.valueOf(dat.get(i).getColonia() + ", " + dat.get(i).getCalle() + ", " + dat.get(i).getNumero()));
                        }
                    }
                    Intent intent1 = new Intent(context, Orden.class);
                    context.startActivity(intent1);


                } else {
                    Toast.makeText(context, "Error al conseguir datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Example1> call, Throwable t) {
                Toast.makeText(context, "Error al conseguir lista ordenes", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Consuta pantalla ordenes//
    public void getDeepCons(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDataDeepCons();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject userJson = response.body().getAsJsonObject("GetDeepConsultaOrdSerResult");
                    try {
                        TryDeepConsulta(userJson);
                    } catch (Exception e) {
                        TryDeepConsulta1(userJson);
                    }
                    getTrabajos(context, jsonObject);
                    contraroMA = (String.valueOf(DeepConsModel.getContatoCom()));
                    obsMA = (String.valueOf(DeepConsModel.Obs));
                    if (DeepConsModel.STATUS.equals("E")) {
                        statusMA = ("Ejecutada");

                    } else if (DeepConsModel.STATUS.equals("P")) {
                        statusMA = ("Pendiente");

                    } else if (DeepConsModel.STATUS.equals("V")) {
                        statusMA = ("En Visita");
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }

    //informacion trabajos//
    public void getTrabajos(final Context context, final JSONObject jsonObject) {
        Call<Example3> call = services.RequestPost(context, jsonObject).getDataTrabajos();
        call.enqueue(new Callback<Example3>() {
            @Override
            public void onResponse(Call<Example3> call, Response<Example3> response) {
                if (response.code() == 200) {
                    Array.trabajox.clear();
                    Array.accionx.clear();
                    Array.clavex.clear();
                    Array.clv_trabajox.clear();
                    Array.recibix.clear();
                    isnet = false;
                    Example3 jsonResponse = response.body();
                    array.dataTrabajos = new ArrayList<List<GetBUSCADetOrdSerListResult>>(asList(jsonResponse.getGetBUSCADetOrdSerListResult()));
                    Iterator<List<GetBUSCADetOrdSerListResult>> itData = array.dataTrabajos.iterator();
                    Array.trabajox.clear();
                    Array.accionx.clear();
                    while (itData.hasNext()) {
                        List<GetBUSCADetOrdSerListResult> dat = (List<GetBUSCADetOrdSerListResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            dat.get(i).setSeRealiza(false);
                            Array.trabajox.add(String.valueOf(dat.get(i).getDescripcion()));
                            Array.accionx.add(String.valueOf(dat.get(i).getAccion()));
                            Array.clavex.add(dat.get(i).getClave());
                            Array.clv_trabajox.add(dat.get(i).getClvTrabajo());
                            Array.recibix.add(dat.get(i).getSeRealiza());
                            if (dat.get(i).getClvTrabajo() == 1270) {
                                isnet = true;
                            }
                            if (dat.get(i).getClvTrabajo() == 1203) {
                                rapagejecutar = true;
                            }
                        }

                        Intent intento1 = new Intent(context, MainActivity.class);
                        intento1.putExtra("contrato", contraroMA);
                        intento1.putExtra("estatus", statusMA);
                        context.startActivity(intento1);
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir trabajos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Example3> call, Throwable t) {
            }
        });
    }

    //Informacion del Cliente//
    public void getInfoCliente(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDataInfoCliente();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    try {
                        JsonObject userJson = response.body().getAsJsonObject("GetDeepBUSCLIPORCONTRATO_OrdSerResult");
                        InfoClienteModelo user = new InfoClienteModelo(
                                userJson.get("CALLE").getAsString(),
                                userJson.get("CIUDAD").getAsString(),
                                userJson.get("COLONIA").getAsString(),
                                userJson.get("Compania").getAsString(),
                                userJson.get("NOMBRE").getAsString(),
                                userJson.get("NUMERO").getAsString()
                        );
                    } catch (Exception e) {
                    }
                    MainActivity.Direccion.setText(InfoClienteModelo.CALLE + " " + InfoClienteModelo.NUMERO + " " + InfoClienteModelo.COLONIA);
                    MainActivity.Nombre.setText(InfoClienteModelo.NOMBRE);
                } else {
                    Toast.makeText(context, "Error al conseguir información del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }

    //ServiciosdelCliente//
    public void getServicios(final Context context, final JSONObject jsonObject) {
        Call<Example2> call = services.RequestPost(context, jsonObject).getDataServicios();
        call.enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call, Response<Example2> response) {
                if (response.code() == 200) {
                    ArrayList<String> resumen = new ArrayList<>();
                    Example2 jsonResponse = response.body();
                    array.dataclientes = new ArrayList<List<GetdameSerDELCliresumenResult>>(asList(jsonResponse.getdameSerDELCliresumenResult()));
                    Iterator<List<GetdameSerDELCliresumenResult>> itData = array.dataclientes.iterator();
                    while (itData.hasNext()) {
                        List<GetdameSerDELCliresumenResult> dat = (List<GetdameSerDELCliresumenResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            String a = "";
                            a += dat.get(i).getResumen() + "\t\t";
                            resumen.add(i, a);
                        }
                        MainActivity.InfoServicios.setText(resumen.toString());
                        MainActivity.dialogMain.dismiss();
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir servicios del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {
            }
        });
    }

    //TecnicoSecundario////
    public void getTecSec(final Context context, final JSONObject jsonObject, final Spinner Tec) {
        Array.clv_tecnicoSecundario = new ArrayList<Integer>();
        Array.clv_tecnicoSecundario.add(0, -1);
        Call<JSONTecSec> call = services.RequestPost(context, jsonObject).getDataTecSec();
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
                        datos[0] = "Seleccione tecnico secundario";
                        for (int i = 0; i < dat.size(); i++) {
                            datos[j] = dat.get(i).getNOMBRE();
                            Array.clv_tecnicoSecundario.add(j, dat.get(i).getCLV_TECNICO());

                            j = j + 1;
                        }
                        adapterTecSec = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        Tec.setAdapter(adapterTecSec);
                        Tec.setSelection(posTec);

                        InstalacionFragment.Obs.setText(String.valueOf(DeepConsModel.Obs));
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir lista de tecnicos secundarios", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONTecSec> call, Throwable t) {
            }
        });
    }

    public void getDeepCAPAT(final Context context, final JSONObject jsonObject, final Spinner aparatocliente,final Spinner aparatoTipo,final Spinner aparatoAsignar,final Spinner aparatoEstado) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDeepCAPAT();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //Peticion de datos sobre el Json "LogOnResult"
                if (response.code() == 200) {
                    CambioAparatoDeepModel.StatusEntrega = "";
                    JsonObject userJson = response.body().getAsJsonObject("GetCambioAparatoDeepResult");
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("Contrato", DeepConsModel.Contrato);
                    } catch (Exception e) {
                    }

                    try {
                        CambioAparatoDeepModel user = new CambioAparatoDeepModel(
                                userJson.get("AparatoAsignar").getAsInt(),
                                userJson.get("AparatoCliente").getAsInt(),
                                userJson.get("TipoAparatoAsignar").getAsInt(),
                                userJson.get("StatusEntrega").getAsString()
                        );
                        getCliApa(context, jsonObject,aparatocliente,aparatoTipo,aparatoAsignar,aparatoEstado);

                    } catch (Exception e) {
                        CambioAparatoDeepModel user = new CambioAparatoDeepModel(
                                99,
                                99,
                                99,
                                ""
                        );
                        getCliApa(context, jsonObject,aparatocliente,aparatoTipo,aparatoAsignar,aparatoEstado);
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir datos de cambio de aparato", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //ClientesAparato//
    public void getCliApa(final Context context, final JSONObject jsonObject, final Spinner aparatoCliente,final Spinner aparatoTipo,final Spinner aparatoAsignar,final Spinner aparatoEstado) {
        Call<JSONCLIAPA> call = services.RequestPost(context, jsonObject).getDataCliApa();
        call.enqueue(new Callback<JSONCLIAPA>() {
            @Override
            public void onResponse(Call<JSONCLIAPA> call, Response<JSONCLIAPA> response) {
                if (response.code() == 200) {
                    JSONCLIAPA jsonResponse = response.body();
                    array.dataCliApa = new ArrayList<List<GetListClienteAparatosResult>>(asList(jsonResponse.GetListClienteAparatosResult()));
                    Iterator<List<GetListClienteAparatosResult>> itdata = array.dataCliApa.iterator();
                    while (itdata.hasNext()) {
                        List<GetListClienteAparatosResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Aparato";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            datos[j] = dat.get(i).getMac();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        aparatoCliente.setAdapter(adapter);
                        getStatusApa(context,aparatoTipo,aparatoAsignar,aparatoEstado);
                        try {
                            aparatoCliente.setSelection(obtenerPosicionAC(CambioAparatoDeepModel.AparatoCliente));
                            idArticulo = dat.get(obtenerPosicionAC(CambioAparatoDeepModel.AparatoCliente) - 1).getIdArticulo();
                            contratoNet = dat.get(obtenerPosicionAC(CambioAparatoDeepModel.AparatoCliente) - 1).getControNet();
                        } catch (Exception e) {
                            dialogTrabajos.dismiss();
                        }
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir aparatos del cliente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONCLIAPA> call, Throwable t) {
            }
        });
    }

    //Status Aparato////
    public void getStatusApa(final Context context,final Spinner aparatoTipo,final Spinner aparatoAsignar,final Spinner aparatoEstado) {
        Call<JSONStatusApa> call = services.getStatusApa(context).getDataStatusApa();
        call.enqueue(new Callback<JSONStatusApa>() {
            @Override
            public void onResponse(Call<JSONStatusApa> call, Response<JSONStatusApa> response) {
                if (response.code() == 200) {
                    JSONStatusApa jsonResponse = response.body();
                    array.dataStaApa = new ArrayList<List<GetSP_StatusAparatosListResult>>(asList(jsonResponse.GetSP_StatusAparatosListResult()));
                    Iterator<List<GetSP_StatusAparatosListResult>> itdata = array.dataStaApa.iterator();
                    while (itdata.hasNext()) {
                        List<GetSP_StatusAparatosListResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Estado";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            datos[j] = dat.get(i).getConcepto();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        aparatoEstado.setAdapter(adapter);

                        JSONObject jsonObject = new JSONObject();

                        try {
                            jsonObject.put("ContratoNet", contratoNet);
                            jsonObject.put("Id_Articulo", idArticulo);
                            aparatoEstado.setSelection(obtenerPosicionSA(CambioAparatoDeepModel.StatusEntrega));
                            getApaTipo(context, jsonObject,aparatoTipo,aparatoAsignar);
                        } catch (Exception e) {

                        }
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir estatus del aparato", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONStatusApa> call, Throwable t) {
            }
        });
    }

    //TipoAparato////
    public void getApaTipo(final Context context, final JSONObject jsonObject,final Spinner aparatoTipo,final Spinner aparatoAsignar) {
        Call<JSONApaTipo> call = services.RequestPost(context, jsonObject).getDataApaTipo();
        call.enqueue(new Callback<JSONApaTipo>() {
            @Override
            public void onResponse(Call<JSONApaTipo> call, Response<JSONApaTipo> response) {
                if (response.code() == 200) {
                    JSONApaTipo jsonResponse = response.body();
                    array.dataApaTipo = new ArrayList<List<GetListTipoAparatosByIdArticuloResult>>(asList(jsonResponse.GetListTipoAparatosByIdArticuloResult()));
                    Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = array.dataApaTipo.iterator();
                    while (itdata.hasNext()) {
                        List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccione Tipo de Aparato";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            datos[j] = dat.get(i).getNombre();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        aparatoTipo.setAdapter(adapter);
                        JSONObject jsonObject = new JSONObject();
                        try {
                            aparatoTipo.setSelection(obtenerPosicionTA(CambioAparatoDeepModel.TipoAparatoAsignar));
                            jsonObject.put("Clv_Tecnico", Util.getClvTecnico(Util.preferences));
                            jsonObject.put("Id_Articulo", idArticulo);
                            getApaTipDis(context, jsonObject,aparatoAsignar);
                        } catch (Exception e) {
                        }
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir tipo de aparato", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONApaTipo> call, Throwable t) {

            }
        });
    }

    //AparatoDisponible////
    public void getApaTipDis(final Context context, final JSONObject jsonObject,final Spinner aparatoAsignar) {
        Call<JSONApaTipDis> call = services.RequestPost(context, jsonObject).getDataApaTipDis();
        call.enqueue(new Callback<JSONApaTipDis>() {
            @Override
            public void onResponse(Call<JSONApaTipDis> call, Response<JSONApaTipDis> response) {
                if (response.code() == 200) {
                    JSONApaTipDis jsonResponse = response.body();
                    array.dataApaTipDis = new ArrayList<List<GetListAparatosDisponiblesByIdArticuloResult>>(asList(jsonResponse.GetListAparatosDisponiblesByIdArticuloResult()));
                    Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata = array.dataApaTipDis.iterator();
                    while (itdata.hasNext()) {
                        List<GetListAparatosDisponiblesByIdArticuloResult> dat = itdata.next();
                        String datos[] = new String[dat.size() + 1];
                        datos[0] = "Seleccine Aparato Disponible";
                        int j = 1;
                        for (int i = 0; i < dat.size(); i++) {
                            datos[j] = dat.get(i).getDescripcion();
                            j = j + 1;
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos);
                        aparatoAsignar.setAdapter(adapter);
                        try {
                            aparatoAsignar.setSelection(obtenerPosicionA(CambioAparatoDeepModel.AparatoAsignar));
                            dialogTrabajos.dismiss();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    Toast.makeText(context, "Error al conseguir aparatos disponibles", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONApaTipDis> call, Throwable t) {
            }
        });
    }

    public void SetCambioAparato(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getCAPAT();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if (response1.code() == 200) {
                    Toast.makeText(context, "Se ha guardado el aparato correctamente", Toast.LENGTH_SHORT).show();
                    dialogCAPAT.dismiss();
                    dialogTrabajos.dismiss();
                    trabajos.refreshDrawableState();
                } else {
                    Toast.makeText(context, "Error al agregar el aparato", Toast.LENGTH_SHORT).show();
                    dialogCAPAT.dismiss();
                    dialogTrabajos.dismiss();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void getExtencionesAdicionales(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDataExtencionAdi();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                if (response1.code() == 200) {
                    String string = String.valueOf(response1.body().getAsJsonPrimitive("GetCONCONEXResult"));
                    Intent intento = new Intent(context, ExtensionesAdi.class);
                    intento.putExtra("ext", string);
                    context.startActivity(intento);
                    dialogTrabajos.dismiss();
                } else {
                    Toast.makeText(context, "Error al conseguir extenciones adicionales", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }


    public void getCAMDO(final Context context, final JSONObject jsonObject) {
        Call<JSONCAMDO> call = services.RequestPost(context, jsonObject).getDataCAMDO();
        call.enqueue(new Callback<JSONCAMDO>() {
            @Override
            public void onResponse(Call<JSONCAMDO> call, Response<JSONCAMDO> response) {

                if (response.code() == 200) {
                    Intent intento = new Intent(context, CambioDom.class);
                    try {
                        JSONCAMDO jsonResponse = response.body();
                        array.dataCAMDO = new ArrayList<List<GetDameDatosCAMDOResult>>(asList(jsonResponse.getDameDatosCAMDOResult()));
                        Iterator<List<GetDameDatosCAMDOResult>> itdata = array.dataCAMDO.iterator();
                        while (itdata.hasNext()) {
                            List<GetDameDatosCAMDOResult> dat = itdata.next();
                            intento.putExtra("ciudad", dat.get(0).Ciudad);
                            intento.putExtra("localidad", dat.get(0).localidad);
                            intento.putExtra("colonia", dat.get(0).colonia);
                            intento.putExtra("calle", dat.get(0).calle);
                            intento.putExtra("numero", String.valueOf(dat.get(0).NUMERO));
                            intento.putExtra("numeroint", dat.get(0).Num_int);
                            intento.putExtra("telefono", dat.get(0).TELEFONO);
                            intento.putExtra("callen", dat.get(0).calleNorte);
                            intento.putExtra("calles", dat.get(0).calleSur);
                            intento.putExtra("callee", dat.get(0).calleEste);
                            intento.putExtra("calleo", dat.get(0).calleOeste);
                            intento.putExtra("casa", dat.get(0).Casa);
                        }
                    } catch (Exception e) {
                        intento.putExtra("ciudad", "");
                        intento.putExtra("localidad", "");
                        intento.putExtra("colonia", "");
                        intento.putExtra("calle", "");
                        intento.putExtra("numero", "");
                        intento.putExtra("numeroint", "");
                        intento.putExtra("telefono", "");
                        intento.putExtra("callen", "");
                        intento.putExtra("calles", "");
                        intento.putExtra("callee", "");
                        intento.putExtra("calleo", "");
                        intento.putExtra("casa", "");
                        Toast.makeText(context, "Error al conseguir datos de cambio de domicilio", Toast.LENGTH_LONG).show();
                    }
                    context.startActivity(intento);
                    dialogTrabajos.dismiss();
                } else {
                    Toast.makeText(context, "Error al conseguir datos de cambio de domicilio", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONCAMDO> call, Throwable t) {
            }
        });
    }

    ////////////////inicio instalacion///////////////
    //Arbol Servicios//
    public void getArbSer(final Context context, final JSONObject jsonObject) {
        Call<JSONArbolServicios> call = services.RequestPost(context, jsonObject).getDataArbSer();
        call.enqueue(new Callback<JSONArbolServicios>() {
            @Override
            public void onResponse(Call<JSONArbolServicios> call, Response<JSONArbolServicios> response) {
                if (response.code() == 200) {

                    array.nombreArbol.clear();
                    JSONArbolServicios jsonResponse = response.body();
                    array.dataArbSer = new ArrayList<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>>(asList(jsonResponse.GetMuestraArbolServiciosAparatosPorinstalarListResult()));
                    Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData4 = array.dataArbSer.iterator();
                    while (itData4.hasNext()) {
                        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4 = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData4.next();
                        for (int i = 0; i < dat4.size(); i++) {
                            array.nombreArbol.add(dat4.get(i).getNombre());
                        }
                    }
                    Intent intento25 = new Intent(context, asignacion.class);
                    context.startActivity(intento25);
                    dialogTrabajos.dismiss();
                } else {
                    Toast.makeText(context, "Error al conseguir datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONArbolServicios> call, Throwable t) {
            }
        });
    }

    //Medios Servicios//
    public void getMedSer(final Context context, final JSONObject jsonObject) {
        Call<JSONMediosSer> call = services.RequestPost(context, jsonObject).getDataMedSer();
        call.enqueue(new Callback<JSONMediosSer>() {
            @Override
            public void onResponse(Call<JSONMediosSer> call, Response<JSONMediosSer> response) {
                if (response.code() == 200) {
                    array.medio.clear();
                    JSONMediosSer jsonResponse = response.body();
                    array.dataMedSer = new ArrayList<List<GetMuestraMedioPorServicoContratadoListResult>>(asList(jsonResponse.GetMuestraMedioPorServicoContratadoListResult()));
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData = array.dataMedSer.iterator();
                    while (itData.hasNext()) {
                        List<GetMuestraMedioPorServicoContratadoListResult> dat = (List<GetMuestraMedioPorServicoContratadoListResult>) itData.next();
                        array.medio.add("Selecionar Medio");
                        for (int i = 0; i < dat.size(); i++) {
                            array.medio.add(dat.get(i).getDescripcion());
                        }
                    }
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.medio);
                    asignacion.spinnerMedio.setAdapter(adapter1);
                } else {
                    Toast.makeText(context, "Error al conseguir clave tecnico", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONMediosSer> call, Throwable t) {
            }
        });
    }

    //Tipo de Aparatos//
    public void getTipoAparatos(final Context context, final JSONObject jsonObject) {
        Call<JSONTipoAparatos> call = services.RequestPost(context, jsonObject).getDataTipoAparatos();
        call.enqueue(new Callback<JSONTipoAparatos>() {
            @Override
            public void onResponse(Call<JSONTipoAparatos> call, Response<JSONTipoAparatos> response) {
                Log.d("asd","asd");
                if (response.code() == 200) {
                    array.tipoAparato.clear();
                    JSONTipoAparatos jsonResponse = response.body();
                    array.dataTipoAparatos = new ArrayList<List<GetMuestraTipoAparatoListResult>>(asList(jsonResponse.GetMuestraTipoAparatoListResult()));
                    Iterator<List<GetMuestraTipoAparatoListResult>> itData = array.dataTipoAparatos.iterator();
                    array.tipoAparato.add("Seleccione tipo de aparato");
                    while (itData.hasNext()) {
                        List<GetMuestraTipoAparatoListResult> dat = itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            array.tipoAparato.add(dat.get(i).getNombre());
                        }
                    }
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.tipoAparato);
                    asignado.spinnerAparato.setAdapter(adapter1);
                } else {
                    Toast.makeText(context, "Error al conseguir tipos de aparatos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONTipoAparatos> call, Throwable t) {
            }
        });
    }

    //Aparatos Disponibles///
    public void getAparatosDisponibles(final Context context, final JSONObject jsonObject) {
        Call<JSONAparatosDisponibles> call = services.RequestPost(context, jsonObject).getDataAparatosDisponibles();
        call.enqueue(new Callback<JSONAparatosDisponibles>() {
            @Override
            public void onResponse(Call<JSONAparatosDisponibles> call, Response<JSONAparatosDisponibles> response) {
                if (response.code() == 200) {
                    array.aparatoDisponibles.clear();
                    array.aparatoAsignacion.clear();
                    JSONAparatosDisponibles jsonResponse = response.body();
                    array.dataAparatosDisponibles = new ArrayList<List<GetMuestraAparatosDisponiblesListResult>>(asList(jsonResponse.GetMuestraAparatosDisponiblesListResult()));
                    Iterator<List<GetMuestraAparatosDisponiblesListResult>> itData = array.dataAparatosDisponibles.iterator();
                    array.aparatoAsignacion.add("Seleccione aparato");
                    while (itData.hasNext()) {
                        List<GetMuestraAparatosDisponiblesListResult> dat = (List<GetMuestraAparatosDisponiblesListResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            array.aparatoDisponibles.add(dat.get(i).getDescripcion());
                            array.aparatoAsignacion.add(dat.get(i).getDescripcion());

                        }
                    }

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array.aparatoAsignacion);
                    asignado.spinneraparatoDisponible.setAdapter(adapter1);
                } else {
                    Toast.makeText(context, "Error al conseguir aparatos disponibles", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONAparatosDisponibles> call, Throwable t) {
            }
        });
    }

    //Servicios Aparatos//
    public void getServiciosAparatos(final Context context, final JSONObject jsonObject) {
        Call<JSONServiciosAparatos> call = services.RequestPost(context, jsonObject).getDataServiciosAparatos();
        call.enqueue(new Callback<JSONServiciosAparatos>() {
            @Override
            public void onResponse(Call<JSONServiciosAparatos> call, Response<JSONServiciosAparatos> response) {
                if (response.code() == 200) {
                    array.serviciosAparatos.clear();
                    JSONServiciosAparatos jsonResponse = response.body();
                    array.dataserviciosAparatos = new ArrayList<List<GetMuestraServiciosRelTipoAparatoListResult>>(asList(jsonResponse.GetMuestraServiciosRelTipoAparatoListResult()));
                    Iterator<List<GetMuestraServiciosRelTipoAparatoListResult>> itData = array.dataserviciosAparatos.iterator();
                    while (itData.hasNext()) {
                        List<GetMuestraServiciosRelTipoAparatoListResult> dat = (List<GetMuestraServiciosRelTipoAparatoListResult>) itData.next();
                        for (int i = 0; i < dat.size(); i++) {
                            array.serviciosAparatos.add(dat.get(i).getNombre());
                        }
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_checked, array.serviciosAparatos);
                    asignado.serviciosAparato.setAdapter(arrayAdapter);
                } else {
                    Toast.makeText(context, "Error al conseguir servicios de aparatos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONServiciosAparatos> call, Throwable t) {
            }
        });
    }

    public void getAceptatAsignacino(final Context context, final JSONObject jsonObject) {
        Call<JsonObject> call = services.RequestPost(context, jsonObject).getDataAceptarAsig();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "Aparatos agregados", Toast.LENGTH_LONG).show();
                    dialogAsignacion.dismiss();
                    finish();
                } else {
                    Toast.makeText(context, "Error al aceptar asignacion", Toast.LENGTH_LONG).show();
                    dialogAsignacion.dismiss();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }

    /////////////////fin instalacion//////////////////
/*
///////////////inicio reportes////////////////
       //INFO CLIENTE Reportes///
   //TIPO DE SOLUCION///
       public void getSolucuion(final Context context, final JSONObject jsonObject) {
           Array.clv_Soluc = new ArrayList<Integer>();
           Array.clv_Soluc.add(0, -1);
           Call<JSONSolucion> call = services.RequestPost(context, jsonObject).getSolut();
           call.enqueue(new Callback<JSONSolucion>() {
               @Override
               public void onResponse(Call<JSONSolucion> call, Response<JSONSolucion> response) {
                   if (response.code() == 200) {
                       JSONSolucion jsonResponse = response.body();
                       array.dataSOL = new ArrayList<List<GetMUESTRATRABAJOSQUEJASListResult>>((asList(jsonResponse.getGetMUESTRATRABAJOSQUEJASListResult())));
                       Iterator<List<GetMUESTRATRABAJOSQUEJASListResult>> itdata = array.dataSOL.iterator();
                       while (itdata.hasNext()) {
                           List<GetMUESTRATRABAJOSQUEJASListResult> dat = itdata.next();
                           datos = new String[dat.size() + 1];
                           int j = 1;
                           datos[0] = f;
                           for (int i = 0; i < dat.size(); i++) {
                               datos[j] = dat.get(i).getDESCRIPCION();
                               Array.clv_Soluc.add(j, dat.get(i).getCLVTRABAJO());
                               j = j + 1;
                           }
                           ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                           solucion.setAdapter(adapter);
                           solucion.setSelection(posSolucionRepo);
                       }
                   } else {
                       Toast.makeText(context, "Error al conseguir soluciones", Toast.LENGTH_LONG).show();
                   }
               }

               @Override
               public void onFailure(Call<JSONSolucion> call, Throwable t) {

               }
           });
       }

       //Reporte del Cliente//
       public void getReportesC(final Context context, final JSONObject jsonObject) {
           Call<JSONReporteCliente> call = services.RequestPost(context, jsonObject).getRPC();
           call.enqueue(new Callback<JSONReporteCliente>() {
               @Override
               public void onResponse(Call<JSONReporteCliente> call, Response<JSONReporteCliente> response) {
                   if (response.code() == 200) {
                       JSONReporteCliente jsonResponse = response.body();
                       array.dataReport = new ArrayList<List<GetQuejasListResult>>(asList(jsonResponse.getGetQuejasListResult()));
                       Iterator<List<GetQuejasListResult>> itData = array.dataReport.iterator();
                       while (itData.hasNext()) {
                           List<GetQuejasListResult> dat = (List<GetQuejasListResult>) itData.next();
                           for (int i = 0; i < dat.size(); ++i) {
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

       //Nombre Tecnico//////
       public void getnombretec(final Context context, final JSONObject jsonObject) {
           Call<JSONNombreTecnico> call = services.RequestPost(context, jsonObject).getNom();
           call.enqueue(new Callback<JSONNombreTecnico>() {
               @Override
               public void onResponse(Call<JSONNombreTecnico> call, Response<JSONNombreTecnico> response) {
                   if (response.code() == 200) {
                       JSONNombreTecnico jsonResponse = response.body();
                       array.dataNom = new ArrayList<List<GetConTecnicoAgendaResult>>(Collections.singleton(asList(jsonResponse.getGetConTecnicoAgendaResult())));
                       Iterator<List<GetConTecnicoAgendaResult>> itData = array.dataNom.iterator();
                       while (itData.hasNext()) {
                           List<GetConTecnicoAgendaResult> dat = (List<GetConTecnicoAgendaResult>) itData.next();
                           for (int i = 0; i < dat.size(); ++i) {
                               MainReportes.NombreTec1.setText(String.valueOf(dat.get(i).getTecnico()));
                           }
                       }
                   }
               }

               @Override
               public void onFailure(Call<JSONNombreTecnico> call, Throwable t) {
               }
           });
       }

       //servicios asiggnados //
       public void getServiciosAsignados(final Context context, final JSONObject jsonObject) {
           Call<JSONServicioAsignado> call = services.RequestPost(context, jsonObject).getServ();
           call.enqueue(new Callback<JSONServicioAsignado>() {
               @Override
               public void onResponse(Call<JSONServicioAsignado> call, Response<JSONServicioAsignado> response) {
                   if (response.code() == 200) {
                       JSONServicioAsignado jsonResponse = response.body();
                       ArrayList<String> servicio = new ArrayList<>();
                       array.dataServ = new ArrayList<List<GetDameSerDelCliFacListResult>>((asList(jsonResponse.getGetDameSerDelCliFacListResult())));
                       Iterator<List<GetDameSerDelCliFacListResult>> itData = array.dataServ.iterator();
                       while (itData.hasNext()) {
                           List<GetDameSerDelCliFacListResult> dat = (List<GetDameSerDelCliFacListResult>) itData.next();
                           for (int i = 0; i < dat.size(); ++i) {
                               String a = "";
                               a += dat.get(i).getServicio() + "\t\t";
                               servicio.add(i, a);
                               MainReportes.infoA.setText(servicio.toString());
                           }
                       }
                   }
               }

               @Override
               public void onFailure(Call<JSONServicioAsignado> call, Throwable t) {
               }
           });
       }

       public void getReportes(final Context context, final JSONObject jsonObject) {
           Call<JSONReportes> call = services.RequestPost(context, jsonObject).getReport();
           call.enqueue(new Callback<JSONReportes>() {
               @RequiresApi(api = Build.VERSION_CODES.N)
               @Override
               public void onResponse(Call<JSONReportes> call, Response<JSONReportes> response) {
                   if (response.code() == 200) {
                       JSONReportes jsonResponse = response.body();
                       array.dataRep = new ArrayList<List<GetuspBuscaContratoSeparado2ListResult>>(asList(jsonResponse.getGetuspBuscaContratoSeparado2ListResult()));
                       Iterator<List<GetuspBuscaContratoSeparado2ListResult>> itData = array.dataRep.iterator();
                       while (itData.hasNext()) {
                           List<GetuspBuscaContratoSeparado2ListResult> dat = (List<GetuspBuscaContratoSeparado2ListResult>) itData.next();
                           for (int i = 0; i < dat.size(); ++i) {
                               MainReportes.Nombre1.setText(dat.get(i).getNombre() + "  " + dat.get(i).getApellidoPaterno() + "  " + dat.get(i).getApellidoMaterno());
                               MainReportes.Direccion1.setText(dat.get(i).getCALLE() + "  " + dat.get(i).getNUMERO() + "  " + dat.get(i).getCOLONIA());
                               MainReportes.contrato1.setText(dat.get(i).getCONTRATO());
                               MainReportes.ciudad1.setText(dat.get(i).getCIUDAD());
                               abc = dat.get(i).contratoBueno;
                               getServiciosAsignados(context);
                               abc = dat.get(i).contratoBueno;
                               getServiciosAsignados(context);
                           }
                       }
                   }
               }

               @Override
               public void onFailure(Call<JSONReportes> call, Throwable t) {
               }
           });
       }

       public void getTecSecR(final Context context, final JSONObject jsonObject) {
           Array.Clv_TecSecR = new ArrayList<Integer>();
           Array.Clv_TecSecR.add(0, -1);
           Call<JSONTecSecReport> call = services.RequestPost(context, jsonObject).getTec();
           call.enqueue(new Callback<JSONTecSecReport>() {
               @Override
               public void onResponse(Call<JSONTecSecReport> call, Response<JSONTecSecReport> response) {
                   if (response.code() == 200) {
                       JSONTecSecReport jsonResponse = response.body();
                       array.dataTECSEC = new ArrayList<List<GetMuestraTecnicosAlmacenListResult>>((asList(jsonResponse.getGetMuestraTecnicosAlmacenListResult())));
                       Iterator<List<GetMuestraTecnicosAlmacenListResult>> itdata = array.dataTECSEC.iterator();
                       while (itdata.hasNext()) {
                           List<GetMuestraTecnicosAlmacenListResult> dat = itdata.next();
                           datos = new String[dat.size() + 1];
                           int j = 1;
                           datos[0] = a;
                           for (int i = 0; i < dat.size(); i++) {
                               datos[j] = dat.get(i).getNombre();
                               Array.Clv_TecSecR.add(j, dat.get(i).getClvTecnico());
                               j = j + 1;
                           }
                           adapterTecSecR = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, datos);
                           TecSec1.setAdapter(adapterTecSecR);
                           TecSec1.setSelection(tecPosRepo);
                       }
                   }
               }

               @Override
               public void onFailure(Call<JSONTecSecReport> call, Throwable t) {
               }
           });
       }
////////////////instalacion///////////////////
       public void getValidaOrdSer(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getVALIOrdSer();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       String string1 = String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult"));

                       if (String.valueOf(response1.body().getAsJsonPrimitive("GetSP_ValidaGuardaOrdSerAparatosResult")).length() == 2) {
                           getChecaCAMDO(context);
                       } else {
                           dialogEjecutar.dismiss();
                           EjecutarFragment.eject.setEnabled(true);
                           Toast.makeText(context, "Error" + string1, Toast.LENGTH_LONG).show();
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getChecaCAMDO(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getChecaCAMDO();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       JsonObject jsonObject = response1.body().getAsJsonObject("GetCheca_si_tiene_camdoResult");
                       GetCheca_si_tiene_CAMDOModel checa = new GetCheca_si_tiene_CAMDOModel(
                               jsonObject.get("Error").getAsString()
                       );
                       if (checa.Error.equals("0")) {
                           getAddRelOrdUsu(context);
                       } else {
                           dialogEjecutar.dismiss();
                           EjecutarFragment.eject.setEnabled(true);
                           Toast.makeText(context, "Error" + checa.Error, Toast.LENGTH_LONG).show();
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getAddRelOrdUsu(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getADDRELORDUSU();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       getDeepMODORDSER(context);
                   } else {
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       dialogEjecutar.dismiss();
                       EjecutarFragment.eject.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {
               }
           });
       }

       public void getDeepMODORDSER(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getMODORDSER();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       getGuardaHora(context);
                   } else {
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       dialogEjecutar.dismiss();
                       EjecutarFragment.eject.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {
               }
           });
       }

       public void getGuardaHora(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getGuardaHora();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       getGuardaOrdSerAparatos(context);
                   } else {
                       dialogEjecutar.dismiss();
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       EjecutarFragment.eject.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getGuardaOrdSerAparatos(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getGUARDAOrdSerAparatos();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       addLlenaBitacora(context);
                   } else {
                       dialogEjecutar.dismiss();
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       EjecutarFragment.eject.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void addLlenaBitacora(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getLLENABITACORA_ORD();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   int IS = 0;
                   if (response1.code() == 200) {
                       if (String.valueOf(response1.body().getAsJsonPrimitive("AddSP_LLena_Bitacora_OrdenesResult")).equals("-1")) {
                           Iterator<List<GetBUSCADetOrdSerListResult>> itData = Array.dataTrabajos.iterator();
                           List<GetBUSCADetOrdSerListResult> dat = itData.next();
                           for (int a = 0; a < dat.size(); a++) {
                               if (dat.get(a).getClvTrabajo() == 1270 || dat.get(a).getClvTrabajo() == 1271 || dat.get(a).getClvTrabajo() == 1272) {
                                   IS = 1;
                               }
                           }
                           if (IS == 1) {
                               GuardaCoordenadas(context);
                           } else {
                               dialogEjecutar.dismiss();
                               Intent intent = new Intent(context, Orden.class);
                               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                               context.startActivity(intent);
                           }

                       }
                   } else {
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       EjecutarFragment.eject.setEnabled(true);
                       dialogEjecutar.dismiss();
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }
          public void GuardaCoordenadas(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getGuardaCoordenadas();
           call.enqueue(new Callback<JsonObject>() {


               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   reintentaB = 0;

                   if (response1.code() == 200) {
                       ConsultaIp(context);
                   } else {
                       Toast.makeText(context, "Error, Aparatos no enviados", Toast.LENGTH_SHORT);
                       dialogEjecutar.dismiss();
                       EjecutarFragment.eject.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void ConsultaIp(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getConsultaIp();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       jsonConsultaIp = new JsonObject();
                       jsonConsultaIp = response1.body().getAsJsonObject("GetConsultaIpPorContratoResult");
                       ConsultaIpModel user = new ConsultaIpModel(
                               jsonConsultaIp.get("AplicaReintentar").getAsBoolean(),
                               jsonConsultaIp.get("Msg").getAsString()
                       );
                       reintentarComando = String.valueOf(user.AplicaReintentar);
                       msgComando = user.Msg;
                       for (int a = 0; a < 1; a++) {
                           if (reintentarComando.equals("true")) {
                               reiniciar.setEnabled(true);
                               msgEjecutarOrd.setText(Request.msgComando);
                           } else {
                               if (msgComando.length() > 3) {
                                   msgEjecutarOrd.setText(msgComando);
                                   dialogEjecutar.dismiss();
                                   Login.esperar(5);
                                   ((Activity) context).finish();
                               } else {
                                   Login.esperar(3);
                                   retry(call);
                               }
                           }
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {
               }

               public void retry(Call<JsonObject> call) {
                   call.clone().enqueue(this);
               }
           });
       }

       public void ReintentarComando(final Context context, final JSONObject jsonObject) {
           reintentaB = 0;
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getReintentaComando();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
                   if (response1.code() == 200) {
                       ConsultaIp(context);
                       msgEjecutarOrd.setText("");
                       reiniciar.setEnabled(true);
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }


/////////////////ejecucion/////////////
       //Ejecutar Reporte//
       public void getValidaReporte(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getValidaRep();
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

       //horas//
       public void getGuardaHoraReporte(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getHiHf();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
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

       //guardar campos//
       public void getGuardaCampos(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getLLenaReporte();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response1) {
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



       public void send_aparat(final Context context, final JSONObject jsonObject) {
           adaptertrabajos.norec();
           Call<JsonObject> call = services.RequestPost(context, jsonObject).noent();
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
//////////////materiales//////////////
       public void getChecaExt(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getChecaExt();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       JsonObject userJson = response.body().getAsJsonObject("GetUspChecaSiTieneExtensionesResult");
                       ChecaSiExtencionesModel user = new ChecaSiExtencionesModel(
                               userJson.get("BND").getAsInt(),
                               userJson.get("NUMEXT").getAsInt()
                       );
                       if (user.BND == 1) {
                           MuestraBit(context);
                           LlenaExt(context);
                           nExtenciones = user.BND;

                       } else {
                           MuestraBit(context);
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void MuestraBit(final Context context, final JSONObject jsonObject) {
           Call<JSONDetalleBitacora> call = services.RequestPost(context, jsonObject).getMuestraBit();
           call.enqueue(new Callback<JSONDetalleBitacora>() {
               @Override
               public void onResponse(Call<JSONDetalleBitacora> call, Response<JSONDetalleBitacora> response1) {
                   if (response1.code() == 200) {
                       array.detalleBit.clear();
                       array.detalleBit.add(0, "---Seleccionar---");
                       int j = 1;
                       JSONDetalleBitacora jsonResponse = response1.body();
                       array.dataDetBit = new ArrayList<List<DetalleBitacoraModel>>(asList(jsonResponse.detalleBitacoraModel()));
                       Iterator<List<DetalleBitacoraModel>> itData = array.dataDetBit.iterator();
                       while (itData.hasNext()) {
                           List<DetalleBitacoraModel> dat = itData.next();

                           for (int i = 0; i < dat.size(); i++) {
                               array.detalleBit.add(j, dat.get(i).Descripcion);
                               j = j + 1;
                           }

                       }
                       ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.detalleBit);
                       descripcionMat.setAdapter(arrayAdapter);
                       descripcionMat.setSelection(posDescMat);
                   }
               }

               @Override
               public void onFailure(Call<JSONDetalleBitacora> call, Throwable t) {

               }

           });
       }

       public void DetalleBit(final Context context, final JSONObject jsonObject) {
           Call<JSONDescripcionArticulosBit> call = services.RequestPost(context, jsonObject).getDetalleBit();
           call.enqueue(new Callback<JSONDescripcionArticulosBit>() {
               @Override
               public void onResponse(Call<JSONDescripcionArticulosBit> call, Response<JSONDescripcionArticulosBit> response1) {
                   if (response1.code() == 200) {
                       array.descripcionArtBit.clear();
                       array.descripcionArtBit.add(0, "---Seleccionar---");
                       int j = 1;
                       JSONDescripcionArticulosBit jsonResponse = response1.body();
                       array.dataDetArtBit = new ArrayList<List<DescripcionArticuloModel>>(asList(jsonResponse.descripcionArticuloModel()));
                       Iterator<List<DescripcionArticuloModel>> itData = array.dataDetArtBit.iterator();
                       while (itData.hasNext()) {
                           List<DescripcionArticuloModel> dat = itData.next();

                           for (int i = 0; i < dat.size(); i++) {
                               array.descripcionArtBit.add(j, dat.get(i).Nombre);
                               j = j + 1;
                           }

                       }
                       ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.descripcionArtBit);
                       Materiales.clasificacionMat.setAdapter(arrayAdapter);
                       clasificacionMat.setSelection(posClasMat);

                   }
               }

               @Override
               public void onFailure(Call<JSONDescripcionArticulosBit> call, Throwable t) {

               }

           });
       }

       public void LlenaExt(final Context context, final JSONObject jsonObject) {
           Call<JSONLlenaExtenciones> call = services.RequestPost(context, jsonObject).getLlenaExt();
           call.enqueue(new Callback<JSONLlenaExtenciones>() {
               @Override
               public void onResponse(Call<JSONLlenaExtenciones> call, Response<JSONLlenaExtenciones> response1) {
                   if (response1.code() == 200) {
                       Materiales.extMat.setVisibility(View.VISIBLE);
                       array.descripcionExt.clear();
                       array.descripcionExt.add(0, "---Seleccionar---");
                       int j = 1;
                       JSONLlenaExtenciones jsonResponse = response1.body();
                       array.dataLlenaExt = new ArrayList<List<LlenaExtencionesModel>>(asList(jsonResponse.llenaExtencionesModel()));
                       Iterator<List<LlenaExtencionesModel>> itData = array.dataLlenaExt.iterator();
                       while (itData.hasNext()) {
                           List<LlenaExtencionesModel> dat = itData.next();
                           for (int i = 0; i < dat.size(); i++) {
                               array.descripcionExt.add(j, dat.get(i).DESCRIPCION);
                               j = j + 1;
                           }
                       }
                       try {
                           ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.descripcionExt);
                           Materiales.spinnerExtMat.setAdapter(arrayAdapter);
                           extencionesMat = true;
                           spinnerExtMat.setSelection(posExtMat);
                       } catch (Exception e) {

                       }
                   }
               }

               @Override
               public void onFailure(Call<JSONLlenaExtenciones> call, Throwable t) {

               }

           });
       }

       public void getTipoMat(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getTipoMat();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       JsonObject userJson = response.body().getAsJsonObject("GetSoftv_ObtenTipoMaterialResult");
                       TipoMaterialModel user = new TipoMaterialModel(
                               userJson.get("Tipo").getAsString()
                       );
                       if (user.Tipo.equals("Piezas")) {
                           Materiales.piezasMat.setVisibility(View.VISIBLE);
                           pieza = true;
                       } else {
                           Materiales.metrosMat.setVisibility(View.VISIBLE);
                           pieza = false;
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getValidaPreDes(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getValidaPre();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       String dato;
                       dato = String.valueOf(response.body().getAsJsonPrimitive("ValidaExisteTblPreDescargaMaterialResult"));
                       if (dato.equals("0")) {
                           addPreDes(activity, context);
                       }
                       if (dato.equals("1")) {
                           Toast.makeText(context, "Ya existe ese tipo de material", Toast.LENGTH_SHORT).show();
                           getPredescarga(activity, context);
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void addPreDes(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).addPreDescarga();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       Toast.makeText(context, "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                       getPredescarga(activity, context);
                   } else {

                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getPredescarga(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JSONPreDescarga> call = services.RequestPost(context, jsonObject).getPreDescarga();
           call.enqueue(new Callback<JSONPreDescarga>() {
               @Override
               public void onResponse(Call<JSONPreDescarga> call, Response<JSONPreDescarga> response) {
                   final TablaAdapter tablaAdapter = new TablaAdapter(activity, Materiales.tabla);
                   try {
                       tablaAdapter.eliminarFila(1);
                   } catch (Exception e) {
                   }
                   array.listaTabla.clear();
                   if (response.code() == 200) {
                       JSONPreDescarga jsonResponse = response.body();
                       array.dataPreDescarga = new ArrayList<List<dameTblPreDescargaMaterialResultModel>>(asList(jsonResponse.getdameTblPreDescargaMaterialResultModel()));
                       Iterator<List<dameTblPreDescargaMaterialResultModel>> itdata = array.dataPreDescarga.iterator();
                       while (itdata.hasNext()) {
                           List<dameTblPreDescargaMaterialResultModel> dat = itdata.next();
                           for (int i = 0; i < dat.size(); i++) {
                               array.listaTabla.add(String.valueOf(dat.get(i).clvOrden));
                               array.listaTabla.add(String.valueOf(dat.get(i).getNombre()));
                               array.listaTabla.add(String.valueOf(dat.get(i).cantidadUtilizada));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicio));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeFin));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicioExterior));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeFinExterior));
                               array.listaTabla.add(String.valueOf(dat.get(i).getNoExt()));
                           }
                       }
                       Materiales.scrollViewM.setVisibility(View.VISIBLE);
                       Materiales.tabla.setVisibility(View.VISIBLE);
                       tablaAdapter.agregarFilaTabla(Array.listaTabla);
                   }
               }

               @Override
               public void onFailure(Call<JSONPreDescarga> call, Throwable t) {
               }
           });
       }
//////////////materiales//////////////
       //////////////////
       public void DetalleBitR(final Context context, final JSONObject jsonObject) {
           Call<JSONDescripcionArticulosBit> call = services.RequestPost(context, jsonObject).getDetalleBit();
           call.enqueue(new Callback<JSONDescripcionArticulosBit>() {

               @Override
               public void onResponse(Call<JSONDescripcionArticulosBit> call, Response<JSONDescripcionArticulosBit> response1) {
                   if (response1.code() == 200) {
                       array.descripcionArtBit.clear();
                       array.descripcionArtBit.add(0, "---Seleccionar---");
                       int j = 1;
                       JSONDescripcionArticulosBit jsonResponse = response1.body();
                       array.dataDetArtBit = new ArrayList<List<DescripcionArticuloModel>>(asList(jsonResponse.descripcionArticuloModel()));
                       Iterator<List<DescripcionArticuloModel>> itData = array.dataDetArtBit.iterator();
                       while (itData.hasNext()) {
                           List<DescripcionArticuloModel> dat = itData.next();

                           for (int i = 0; i < dat.size(); i++) {
                               array.descripcionArtBit.add(j, dat.get(i).Nombre);
                               j = j + 1;
                           }

                       }
                       ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, array.descripcionArtBit);
                       MaterialesFragment.clasificacionMatR.setAdapter(arrayAdapter);
                   }
               }

               @Override
               public void onFailure(Call<JSONDescripcionArticulosBit> call, Throwable t) {

               }

           });
       }

       public void getTipoMatR(final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getTipoMat();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       JsonObject userJson = response.body().getAsJsonObject("GetSoftv_ObtenTipoMaterialResult");
                       TipoMaterialModel user = new TipoMaterialModel(
                               userJson.get("Tipo").getAsString()
                       );
                       if (user.Tipo.equals("Piezas")) {
                           MaterialesFragment.piezasMatR.setVisibility(View.VISIBLE);
                           pieza = true;
                       } else {
                           MaterialesFragment.metrosMatR.setVisibility(View.VISIBLE);
                           pieza = false;
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getValidaPreDesR(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).getValidaPre();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       String dato;
                       dato = String.valueOf(response.body().getAsJsonPrimitive("ValidaExisteTblPreDescargaMaterialResult"));
                       if (dato.equals("0")) {
                           addPreDesR(activity, context);
                       }
                       if (dato.equals("1")) {
                           Toast.makeText(context, "Ya existe ese tipo de material", Toast.LENGTH_SHORT).show();
                           getPredescargaR(activity, context);
                       }
                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void addPreDesR(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JsonObject> call = services.RequestPost(context, jsonObject).addPreDescarga();
           call.enqueue(new Callback<JsonObject>() {
               @Override
               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                   if (response.code() == 200) {
                       Toast.makeText(context, "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                       getPredescargaR(activity, context);
                   } else {

                   }
               }

               @Override
               public void onFailure(Call<JsonObject> call, Throwable t) {

               }
           });
       }

       public void getPredescargaR(final Activity activity, final Context context, final JSONObject jsonObject) {
           Call<JSONPreDescarga> call = services.RequestPost(context, jsonObject).getPreDescarga();
           call.enqueue(new Callback<JSONPreDescarga>() {
               @Override
               public void onResponse(Call<JSONPreDescarga> call, Response<JSONPreDescarga> response) {
                   final TablaAdapter tablaAdapter = new TablaAdapter(activity, Materiales.tabla);
                   try {
                       tablaAdapter.eliminarFila(1);
                   } catch (Exception e) {
                   }
                   array.listaTabla.clear();
                   if (response.code() == 200) {
                       JSONPreDescarga jsonResponse = response.body();
                       array.dataPreDescarga = new ArrayList<List<dameTblPreDescargaMaterialResultModel>>(asList(jsonResponse.getdameTblPreDescargaMaterialResultModel()));
                       Iterator<List<dameTblPreDescargaMaterialResultModel>> itdata = array.dataPreDescarga.iterator();
                       while (itdata.hasNext()) {
                           List<dameTblPreDescargaMaterialResultModel> dat = itdata.next();
                           for (int i = 0; i < dat.size(); i++) {
                               array.listaTabla.add(String.valueOf(dat.get(i).clvOrden));
                               array.listaTabla.add(String.valueOf(dat.get(i).getNombre()));
                               array.listaTabla.add(String.valueOf(dat.get(i).cantidadUtilizada));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicio));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeFin));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeInicioExterior));
                               array.listaTabla.add(String.valueOf(dat.get(i).metrajeFinExterior));
                               array.listaTabla.add(String.valueOf(dat.get(i).getNoExt()));

                           }
                       }
                       MaterialesFragment.horizontalScrollViewR.setVisibility(View.VISIBLE);
                       MaterialesFragment.tablaR.setVisibility(View.VISIBLE);
                       tablaAdapter.agregarFilaTabla(Array.listaTabla);
                   }
               }

               @Override
               public void onFailure(Call<JSONPreDescarga> call, Throwable t) {

               }
           });
       }
       //////////
       */
    public void TryDeepConsulta(JsonObject userJson) {
        try {
            DeepConsModel user = new DeepConsModel(
                    userJson.get("Clv_FACTURA").getAsInt(),
                    userJson.get("Contrato").getAsInt(),
                    userJson.get("ContratoCom").getAsString(),
                    userJson.get("STATUS").getAsString(),
                    userJson.get("Obs").getAsString(),
                    userJson.get("Clv_Orden").getAsInt(),
                    userJson.get("Clv_TipSer").getAsInt(),
                    userJson.get("Fec_Sol").getAsString(),
                    userJson.get("Visita1").getAsString()
            );
        } catch (Exception e) {
            DeepConsModel user = new DeepConsModel(
                    userJson.get("Clv_FACTURA").getAsInt(),
                    userJson.get("Contrato").getAsInt(),
                    userJson.get("ContratoCom").getAsString(),
                    userJson.get("STATUS").getAsString(),
                    userJson.get("Obs").getAsJsonNull().toString(),
                    userJson.get("Clv_Orden").getAsInt(),
                    userJson.get("Clv_TipSer").getAsInt(),
                    userJson.get("Fec_Sol").getAsString(),
                    userJson.get("Visita1").getAsString()
            );
        }
    }

    public void TryDeepConsulta1(JsonObject userJson) {
        try {
            DeepConsModel user1 = new DeepConsModel(
                    userJson.get("Clv_FACTURA").getAsInt(),
                    userJson.get("Contrato").getAsInt(),
                    userJson.get("ContratoCom").getAsString(),
                    userJson.get("STATUS").getAsString(),
                    userJson.get("Obs").getAsString(),
                    userJson.get("Clv_Orden").getAsInt(),
                    userJson.get("Clv_TipSer").getAsInt(),
                    userJson.get("Fec_Sol").getAsString(),
                    userJson.get("Visita1").getAsJsonNull().toString()
            );
        } catch (Exception f) {
            DeepConsModel user1 = new DeepConsModel(
                    userJson.get("Clv_FACTURA").getAsInt(),
                    userJson.get("Contrato").getAsInt(),
                    userJson.get("ContratoCom").getAsString(),
                    userJson.get("STATUS").getAsString(),
                    userJson.get("Obs").getAsJsonNull().toString(),
                    userJson.get("Clv_Orden").getAsInt(),
                    userJson.get("Clv_TipSer").getAsInt(),
                    userJson.get("Fec_Sol").getAsString(),
                    userJson.get("Visita1").getAsJsonNull().toString()
            );
        }
    }
}