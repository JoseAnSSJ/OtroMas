package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetQuejasListResult {
    @SerializedName("BaseIdUser")
    @Expose
    private Long baseIdUser;
    @SerializedName("BaseRemoteIp")
    @Expose
    private Object baseRemoteIp;
    @SerializedName("COMENTARIO")
    @Expose
    private Object cOMENTARIO;
    @SerializedName("CallCenter")
    @Expose
    private Object callCenter;
    @SerializedName("Clasificacion")
    @Expose
    private String clasificacion;
    @SerializedName("ClasificacionProblema")
    @Expose
    private String clasificacionProblema;
    @SerializedName("Clave_Tecnico")
    @Expose
    private Long claveTecnico;
    @SerializedName("Clv_Cita")
    @Expose
    private Object clvCita;
    @SerializedName("Clv_Queja")
    @Expose
    private Long clvQueja;
    @SerializedName("Clv_Tecnico")
    @Expose
    private Object clvTecnico;
    @SerializedName("Clv_TipSer")
    @Expose
    private Long clvTipSer;
    @SerializedName("Clv_TipoQueja")
    @Expose
    private Object clvTipoQueja;
    @SerializedName("Clv_Trabajo")
    @Expose
    private Long clvTrabajo;
    @SerializedName("ComentarioAge")
    @Expose
    private Object comentarioAge;
    @SerializedName("Contrato")
    @Expose
    private Object contrato;
    @SerializedName("ContratoCom")
    @Expose
    private String contratoCom;
    @SerializedName("EjecucuionReal")
    @Expose
    private Object ejecucuionReal;
    @SerializedName("FechaAge")
    @Expose
    private String fechaAge;
    @SerializedName("FechaProceso")
    @Expose
    private Object fechaProceso;
    @SerializedName("Fecha_Actualizacion")
    @Expose
    private Object fechaActualizacion;
    @SerializedName("Fecha_Captura")
    @Expose
    private Object fechaCaptura;
    @SerializedName("Fecha_Ejecucion")
    @Expose
    private String fechaEjecucion;
    @SerializedName("Fecha_Soliciutud")
    @Expose
    public String fechaSoliciutud;
    @SerializedName("HP")
    @Expose
    private Object hP;
    @SerializedName("HV1")
    @Expose
    private Object hV1;
    @SerializedName("HV2")
    @Expose
    private Object hV2;
    @SerializedName("HV3")
    @Expose
    private Object hV3;
    @SerializedName("Hora_Ejecucion")
    @Expose
    private Object horaEjecucion;
    @SerializedName("IdUsuario")
    @Expose
    private Object idUsuario;
    @SerializedName("Imp")
    @Expose
    private Object imp;
    @SerializedName("Impresa")
    @Expose
    private Object impresa;
    @SerializedName("Nivel")
    @Expose
    private Long nivel;
    @SerializedName("NombreTecAge")
    @Expose
    private String nombreTecAge;
    @SerializedName("NombreTecnicoCuadrilla")
    @Expose
    private Object nombreTecnicoCuadrilla;
    @SerializedName("Observaciones")
    @Expose
    public String observaciones;
    @SerializedName("Prioridad")
    @Expose
    private String prioridad;
    @SerializedName("Problema")
    @Expose
    public String problema;
    @SerializedName("Solucion")
    @Expose
    private Object solucion;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("TecnicoCuadrilla")
    @Expose
    public int tecnicoCuadrilla;
    @SerializedName("TipSer")
    @Expose
    private String tipSer;
    @SerializedName("TipoSolucion")
    @Expose
    private Object tipoSolucion;
    @SerializedName("Turno")
    @Expose
    private Object turno;
    @SerializedName("TurnoAge")
    @Expose
    private String turnoAge;
    @SerializedName("Usuario")
    @Expose
    private Object usuario;
    @SerializedName("UsuarioEjecuto")
    @Expose
    private Object usuarioEjecuto;
    @SerializedName("UsuarioGenero")
    @Expose
    private String usuarioGenero;
    @SerializedName("Visita")
    @Expose
    private Boolean visita;
    @SerializedName("Visita1")
    @Expose
    private Object visita1;
    @SerializedName("Visita2")
    @Expose
    private Object visita2;
    @SerializedName("Visita3")
    @Expose
    private Object visita3;
    @SerializedName("clvPrioridadQueja")
    @Expose
    public int clvPrioridadQueja;
    @SerializedName("clvProblema")
    @Expose
    private Long clvProblema;
    @SerializedName("clv_llamada")
    @Expose
    private Object clvLlamada;

    public Long getBaseIdUser() {
        return baseIdUser;
    }

    public void setBaseIdUser(Long baseIdUser) {
        this.baseIdUser = baseIdUser;
    }


    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }


    public Object getContrato() {
        return contrato;
    }

    public void setContrato(Object contrato) {
        this.contrato = contrato;
    }


    public String getFechaSoliciutud() {
        return fechaSoliciutud;
    }



    public Object getHP() {
        return hP;
    }

    public void setHP(Object hP) {
        this.hP = hP;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public String getProblema() {
        return problema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

<<<<<<< HEAD


    public String getTipSer() {
        return tipSer;
    }

    public void setTipSer(String tipSer) {
        this.tipSer = tipSer;
    }

    public Object getTipoSolucion() {
        return tipoSolucion;
    }

    public void setTipoSolucion(Object tipoSolucion) {
        this.tipoSolucion = tipoSolucion;
    }

    public Object getTurno() {
        return turno;
    }

    public void setTurno(Object turno) {
        this.turno = turno;
    }

    public String getTurnoAge() {
        return turnoAge;
    }

    public void setTurnoAge(String turnoAge) {
        this.turnoAge = turnoAge;
    }

=======
>>>>>>> master
    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }

    public Object getVisita1() {
        return visita1;
    }

    public void setVisita1(Object visita1) {
        this.visita1 = visita1;
    }

    public Object getVisita2() {
        return visita2;
    }

    public void setVisita2(Object visita2) {
        this.visita2 = visita2;
    }

<<<<<<< HEAD
    public Object getVisita3() {
        return visita3;
    }

    public void setVisita3(Object visita3) {
        this.visita3 = visita3;
    }



    public Long getClvProblema() {
        return clvProblema;
    }

    public void setClvProblema(Long clvProblema) {
        this.clvProblema = clvProblema;
    }

    public Object getClvLlamada() {
        return clvLlamada;
    }

    public void setClvLlamada(Object clvLlamada) {
        this.clvLlamada = clvLlamada;
    }




=======
>>>>>>> master


}
