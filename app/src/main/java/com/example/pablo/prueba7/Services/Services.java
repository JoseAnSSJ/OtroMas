package com.example.pablo.prueba7.Services;



import com.example.pablo.prueba7.CambioAparato;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Login;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.UserModel;
import com.example.pablo.prueba7.asignacion;
import com.example.pablo.prueba7.sampledata.Constants;
import com.example.pablo.prueba7.sampledata.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.clv_unicaNet;
import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.contratoReq;
import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.clvReport;
//import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.contbueno;
import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.contratoReport;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.ClaveTrabajo;
import static com.example.pablo.prueba7.Ejecutar1Fragment.Spin;
import static com.example.pablo.prueba7.Ejecutar1Fragment.probm;
import static com.example.pablo.prueba7.Ejecutar1Fragment.selectD;
import static com.example.pablo.prueba7.Ejecutar1Fragment.selectT;
import static com.example.pablo.prueba7.Ejecutar1Fragment.selectT2;
import static com.example.pablo.prueba7.Request.Request.contbu;
import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.contratoReport;
import static com.example.pablo.prueba7.asignacion.jsonArray;
import static com.example.pablo.prueba7.asignacion.jsonObject2;
import static com.example.pablo.prueba7.asignado.idArticuloasignado;


public class Services {
    public static int claveTecnico;
    public static int opcion;
    public static int clvorden = 0;
    public static int clavequeja = 0;
    public static String cont;

    public String abc = "Basic: " + Login.enco;

    /////////TOKEN///C////
    public Service getClientService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        //Modificacion del Header

                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", abc)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Servicio Tecnico/////////C////////////
    public Service getTecService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Usuario", Login.cvl_usuario);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        try {
            final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

                @Override
                public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                    //Modificacion del Header
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", UserModel.Codigo)
                            .addHeader("Content-Type", "application/json")
                            .post(body)
                            .build();


                    return chain.proceed(newRequest);
                }
            }).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.NEW_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(Service.class);

        } catch (Exception e) {
            getTecService();
        }


        return null;
    }

    /////////////Proximo Servicio/////////C////////////
    public Service getProxService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Orden de servicio/////////C////////////
    public Service getOrdSerService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

    /////////////Lista de ordenes//////////C///////////
    public Service getListOrdService() throws JSONException {
        //POST Body JsonArray
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        jsonObject.put("op", opcion);
        jsonObject.put("clv_orden", clvorden);
        jsonObject.put("contratoCom", cont);
        jsonObject2.put("ObjLista", jsonObject);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject2));

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

    ////////////Lista de Reportes//////////C///////////
    public Service getListQuejasService() throws JSONException {
        //POST Body JsonArray
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        jsonObject.put("op", opcion);
        jsonObject.put("clv_queja", clavequeja);
        jsonObject.put("contratoCom", cont);
        jsonObject2.put("ObjLista", jsonObject);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject2));

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

    /////////////Servicios Service/////////C////////////
    public Service getServiciosService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato", DeepConsModel.Contrato);


        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject));

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }


    /////////////Informacion pantalla de ordenes//////C///////////////
    public Service getDeepConsService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Orden", clvor);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Informacion del cliente////////C/////////////
    public Service getInfoClienteService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CONTRATO", DeepConsModel.Contrato);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }


    //////////////Lista de Trabajos/////C///////
    public Service getTrabajoService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Orden", clvor);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Tecnico Secundario/////C//////////
    public Service getTecSecService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ClvOrdSer", clvor);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    ////////////// Aparatos Clientes/////C//////////
    public Service getCliApaService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato", DeepConsModel.Contrato);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Status Aparato/////C//////////
    public Service getStatusApa() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", UserModel.Codigo)
                                .build();


                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    //////////////Tipo de Aparato/////C//////////
    public Service getApaTipoService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ContratoNet", CambioAparato.contrato);
        jsonObject.put("Id_Articulo", CambioAparato.idArticulo);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Tipo de Aparato Disponible/////C//////////
    public Service getApaTipDisService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Tecnico", claveTecnico);
        jsonObject.put("Id_Articulo", CambioAparato.idArticulo2);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Cambio de Domicilio/////C//////////
    public Service getCAMODOService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_orden", clvorden);
        jsonObject.put("Clave", ClaveTrabajo);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Arbol Servicios/////C//////////
    public Service getArbolSerService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_orden", clvor);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Medios Servicios/////C//////////
    public Service getMediosSerService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ClvUnicaNet", clv_unicaNet);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Tipo Aparatos/////C//////////
    public Service getTipoAparatosService() throws JSONException {
        ////////
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", 0);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("obj", jsonObject);
        /////////////
        /////////////
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("obj", jsonObject);
        jsonObject3.put("Lst", jsonArray);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject3));
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Aparatos Disponibles/////C//////////
    public Service getAparatosDisponiblesService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_orden", clvor);
        jsonObject.put("Clv_Tecnico", claveTecnico);
        jsonObject.put("idArticulo", idArticuloasignado);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Servicios Disponibles/////C//////////
    public Service getServiciosAparatosService() throws JSONException {
        ////////
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", idArticuloasignado);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("obj", jsonObject);
        /////////////

        ////////
        JSONArray list = new JSONArray();
        list.put(jsonObject2);
        /////////////
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("obj", jsonObject);
        jsonObject3.put("Lst", jsonArray);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject3));
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Tipo Aparatos/////C//////////
    public Service getAceptarAsigService() throws JSONException {
        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = Array.dataArbSer.iterator();
        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();

        ////////
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", 0);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("obj", jsonObject);
        /////////////

        /////////////
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("obj", jsonObject);
        jsonObject3.put("Lst", asignacion.jsonArray2);
        // jsonObject3.getJSONObject(String.valueOf(asignacion.jsonObject3));
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject3));
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Servicios Disponibles/////C/////////
    public Service getExtencionAdiService() throws JSONException {
        ////////
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clave", ClaveTrabajo);
        jsonObject.put("Clv_Orden", clvor);
        jsonObject.put("Contrato", DeepConsModel.Contrato);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject));
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////////////Reportes////////////////////////////////////////////////////
//////////////////////Reportes/////////////////////F///////////////////////////////
    public Service getMediosReportes() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ContratoCom", contratoReport);
        jsonObject.put("IdUsuario", 1);
        jsonObject.put("TipoSer", 1);
        jsonObject.put("Op", 0);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }
    /////////////////////////solucion///////////F//////////////////////////

    public Service getSolocionService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TipoSer", 1);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    /////////////////////////  observacion y problema ///////C/////////////////////////////////

    public Service getReporteCService() throws JSONException {


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Queja", clvReport);
        jsonObject.put("Fecha_Ejecucion", selectD);
        jsonObject.put("TipoSolucion", Spin);
        jsonObject.put("Solucion", probm);


        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    ///////////////////////tipo prioridad///////////////C/////////////////
    public Service getPrioridadService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", UserModel.Codigo)
                                .build();


                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    //////////////////////////clasificacion/////////C///////
    public Service getClasificacionService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", UserModel.Codigo)
                                .build();


                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }
    ///////////////////tecnicoNombre//////////F///////

    public Service getNombreService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv", clvReport);
        jsonObject.put("Op", 1);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    ///////////////////////Servicios Asignados/////C/////////
    public Service getAsignadosService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato", com.example.pablo.prueba7.Request.Request.abc);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
    //////////////hora inicio, hora fin/////////////////////


    public Service getHIHFService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clave", clvReport);


        jsonObject.put("HoraFin", selectT2);
        jsonObject.put("HoraIni", selectT);


        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }


    public Service getTecSecRService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato", com.example.pablo.prueba7.Request.Request.abc);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
}


