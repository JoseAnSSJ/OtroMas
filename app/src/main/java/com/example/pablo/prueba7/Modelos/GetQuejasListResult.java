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

    public Object getBaseRemoteIp() {
        return baseRemoteIp;
    }

    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }

    public Object getCOMENTARIO() {
        return cOMENTARIO;
    }

    public void setCOMENTARIO(Object cOMENTARIO) {
        this.cOMENTARIO = cOMENTARIO;
    }

    public Object getCallCenter() {
        return callCenter;
    }

    public void setCallCenter(Object callCenter) {
        this.callCenter = callCenter;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getClasificacionProblema() {
        return clasificacionProblema;
    }

    public void setClasificacionProblema(String clasificacionProblema) {
        this.clasificacionProblema = clasificacionProblema;
    }

    public Long getClaveTecnico() {
        return claveTecnico;
    }

    public void setClaveTecnico(Long claveTecnico) {
        this.claveTecnico = claveTecnico;
    }

    public Object getClvCita() {
        return clvCita;
    }

    public void setClvCita(Object clvCita) {
        this.clvCita = clvCita;
    }

    public Long getClvQueja() {
        return clvQueja;
    }

    public void setClvQueja(Long clvQueja) {
        this.clvQueja = clvQueja;
    }

    public Object getClvTecnico() {
        return clvTecnico;
    }

    public void setClvTecnico(Object clvTecnico) {
        this.clvTecnico = clvTecnico;
    }

    public Long getClvTipSer() {
        return clvTipSer;
    }

    public void setClvTipSer(Long clvTipSer) {
        this.clvTipSer = clvTipSer;
    }

    public Object getClvTipoQueja() {
        return clvTipoQueja;
    }

    public void setClvTipoQueja(Object clvTipoQueja) {
        this.clvTipoQueja = clvTipoQueja;
    }

    public Long getClvTrabajo() {
        return clvTrabajo;
    }

    public void setClvTrabajo(Long clvTrabajo) {
        this.clvTrabajo = clvTrabajo;
    }

    public Object getComentarioAge() {
        return comentarioAge;
    }

    public void setComentarioAge(Object comentarioAge) {
        this.comentarioAge = comentarioAge;
    }

    public Object getContrato() {
        return contrato;
    }

    public void setContrato(Object contrato) {
        this.contrato = contrato;
    }

    public String getContratoCom() {
        return contratoCom;
    }

    public void setContratoCom(String contratoCom) {
        this.contratoCom = contratoCom;
    }

    public Object getEjecucuionReal() {
        return ejecucuionReal;
    }

    public void setEjecucuionReal(Object ejecucuionReal) {
        this.ejecucuionReal = ejecucuionReal;
    }

    public String getFechaAge() {
        return fechaAge;
    }

    public void setFechaAge(String fechaAge) {
        this.fechaAge = fechaAge;
    }

    public Object getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Object fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Object getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Object fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Object getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Object fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(String fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public String getFechaSoliciutud() {
        return fechaSoliciutud;
    }

    public void setFechaSoliciutud(String fechaSoliciutud) {
        this.fechaSoliciutud = fechaSoliciutud;
    }

    public Object getHP() {
        return hP;
    }

    public void setHP(Object hP) {
        this.hP = hP;
    }

    public Object getHV1() {
        return hV1;
    }

    public void setHV1(Object hV1) {
        this.hV1 = hV1;
    }

    public Object getHV2() {
        return hV2;
    }

    public void setHV2(Object hV2) {
        this.hV2 = hV2;
    }

    public Object getHV3() {
        return hV3;
    }

    public void setHV3(Object hV3) {
        this.hV3 = hV3;
    }

    public Object getHoraEjecucion() {
        return horaEjecucion;
    }

    public void setHoraEjecucion(Object horaEjecucion) {
        this.horaEjecucion = horaEjecucion;
    }

    public Object getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Object idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Object getImp() {
        return imp;
    }

    public void setImp(Object imp) {
        this.imp = imp;
    }

    public Object getImpresa() {
        return impresa;
    }

    public void setImpresa(Object impresa) {
        this.impresa = impresa;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public String getNombreTecAge() {
        return nombreTecAge;
    }

    public void setNombreTecAge(String nombreTecAge) {
        this.nombreTecAge = nombreTecAge;
    }

    public Object getNombreTecnicoCuadrilla() {
        return nombreTecnicoCuadrilla;
    }

    public void setNombreTecnicoCuadrilla(Object nombreTecnicoCuadrilla) {
        this.nombreTecnicoCuadrilla = nombreTecnicoCuadrilla;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Object getSolucion() {
        return solucion;
    }

    public void setSolucion(Object solucion) {
        this.solucion = solucion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



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

    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }

    public Object getUsuarioEjecuto() {
        return usuarioEjecuto;
    }

    public void setUsuarioEjecuto(Object usuarioEjecuto) {
        this.usuarioEjecuto = usuarioEjecuto;
    }

    public String getUsuarioGenero() {
        return usuarioGenero;
    }

    public void setUsuarioGenero(String usuarioGenero) {
        this.usuarioGenero = usuarioGenero;
    }

    public Boolean getVisita() {
        return visita;
    }

    public void setVisita(Boolean visita) {
        this.visita = visita;
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






}
