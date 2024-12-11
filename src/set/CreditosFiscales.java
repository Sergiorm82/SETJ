package set;

import java.sql.Date;

public class CreditosFiscales {

    private int IDMovimiento, NumeroControl, IDUsuarioCaptura, IdArea, IdUsuarioUltModificacion;
    private boolean Impresion, Validacion, Guardado;
    private String rfc, numeroCredito, IdAutoridadDeterminante, RazonSocial, Domicilio, Colonia, CodigoPostal, Municipio, ExpedienteProcedencia, TipoNotificacion, TipoCredito, Estatus, ObsrvacionesCredito, JefeDpartamento, Asignacion, Notas, IdCoordinadora;
    private Date FechaIngreso, fechaRecepcion, FechaDocumentoDeterminante, FechaNotificacion, FechaExigible, FechaEstatus, FechaUltModificacion, FechaCaptura;
    private double importeDeterminado;
    private String observaciones;

    // Constructor vacío
    public CreditosFiscales() {

    }

    public CreditosFiscales(int IdMovimiento, String RFC, String NumeroCredito, String NombreRazonSocial, String Domicilio, String CodigoPostal, String IdMunicipio, String IdAutoridad, Date FechaRecepcion, String ExpedienteProcedencia, Date FechaDocumento, double ImporteDeterminado, Date FechaNotificacion, Date FechaExigible, String IdTipoNotificacion, String IdTipoCredito, String Estatus, Date FechaEstatus, String Observaciones) {
    }

    public CreditosFiscales(int IDMovimiento, int NumeroControl, int IDUsuarioCaptura, int IdArea, boolean Impresion, boolean Validacion, String rfc, String numeroCredito, String IdAutoridadDeterminante, String RazonSocial, String Domicilio, String Colonia, String CodigoPostal, String Municipio, String ExpedienteProcedencia, String TipoNotificacion, String TipoCredito, String Estatus, String ObsrvacionesCredito, String JefeDpartamento, String Asignacion, String Notas, String IdCoordinadora, Date FechaIngreso, Date fechaRecepcion, Date FechaDocumentoDeterminante, Date FechaNotificacion, Date FechaExigible, Date FechaEstatus, Date FechaCaptura, double importeDeterminado, String observaciones, int IdUsuarioUltModificacion, boolean Guardado, Date FechaUltModificacion) {
        this.IDMovimiento = IDMovimiento;
        this.NumeroControl = NumeroControl;
        this.IDUsuarioCaptura = IDUsuarioCaptura;
        this.IdArea = IdArea;
        this.Impresion = Impresion;
        this.Validacion = Validacion;
        this.rfc = rfc;
        this.numeroCredito = numeroCredito;
        this.IdAutoridadDeterminante = IdAutoridadDeterminante;
        this.RazonSocial = RazonSocial;
        this.Domicilio = Domicilio;
        this.Colonia = Colonia;
        this.CodigoPostal = CodigoPostal;
        this.Municipio = Municipio;
        this.ExpedienteProcedencia = ExpedienteProcedencia;
        this.TipoNotificacion = TipoNotificacion;
        this.TipoCredito = TipoCredito;
        this.Estatus = Estatus;
        this.ObsrvacionesCredito = ObsrvacionesCredito;
        this.JefeDpartamento = JefeDpartamento;
        this.Asignacion = Asignacion;
        this.Notas = Notas;
        this.IdCoordinadora = IdCoordinadora;
        this.FechaIngreso = FechaIngreso;
        this.fechaRecepcion = fechaRecepcion;
        this.FechaDocumentoDeterminante = FechaDocumentoDeterminante;
        this.FechaNotificacion = FechaNotificacion;
        this.FechaExigible = FechaExigible;
        this.FechaEstatus = FechaEstatus;
        this.FechaCaptura = FechaCaptura;
        this.importeDeterminado = importeDeterminado;
        this.observaciones = observaciones;
    }
//crear credito

    CreditosFiscales(int NumeroControl, String RFC, String NumeroCredito, int IDUsuarioCaptura, int IdArea, String IdAutoridadDeterminante, Date FechaIngreso, String RazonSocial, String Domicilio, String Colonia, String CodigoPostal, String Municipio, Date FechaRecepcion, String ExpedienteProcedencia, Date FechaDocumentoDeterminante, Double ImporteDeterminado, Date FechaNotificacion, Date FechaExigible, String TipoNotificacion, String TipoCredito, String Estatus, Date FechaEstatus, String Observaciones, boolean Impresion, boolean Validacion, String JefeDepartamento, String Asignacion, String Notas, Date FechaCaptura, int IdUsuarioUltModificacion, boolean Guardado, Date FechaUltModificacion) {
        this.NumeroControl = NumeroControl;
        this.rfc = RFC;
        this.numeroCredito = NumeroCredito;
        this.IDUsuarioCaptura = IDUsuarioCaptura;
        this.IdArea = IdArea;
        this.IdAutoridadDeterminante = IdAutoridadDeterminante;
        this.FechaIngreso = FechaIngreso;
        this.RazonSocial = RazonSocial;
        this.Domicilio = Domicilio;
        this.Colonia = Colonia;
        this.CodigoPostal = CodigoPostal;
        this.Municipio = Municipio;
        this.fechaRecepcion = FechaRecepcion;
        this.ExpedienteProcedencia = ExpedienteProcedencia;
        this.FechaDocumentoDeterminante = FechaDocumentoDeterminante;
        this.importeDeterminado = ImporteDeterminado;
        this.FechaNotificacion = FechaNotificacion;
        this.FechaExigible = FechaExigible;
        this.TipoNotificacion = TipoNotificacion;
        this.TipoCredito = TipoCredito;
        this.Estatus = Estatus;
        this.FechaEstatus = FechaEstatus;
        this.ObsrvacionesCredito = Observaciones;
        this.Impresion = Impresion;
        this.Validacion = Validacion;
        this.JefeDpartamento = JefeDepartamento;
        this.Asignacion = Asignacion;
        this.Notas = Notas;
        this.FechaCaptura = FechaCaptura;
        this.IdUsuarioUltModificacion = IdUsuarioUltModificacion;
        this.Guardado = Guardado;
        this.FechaUltModificacion = FechaUltModificacion;
    }

    public int getIdUsuarioUltModificacion() {
        return IdUsuarioUltModificacion;
    }

    public void setIdUsuarioUltModificacion(int IdUsuarioUltModificacion) {
        this.IdUsuarioUltModificacion = IdUsuarioUltModificacion;
    }

    public boolean isGuardado() {
        return Guardado;
    }

    public void setGuardado(boolean Guardado) {
        this.Guardado = Guardado;
    }

    public Date getFechaUltModificacion() {
        return FechaUltModificacion;
    }

    public void setFechaUltModificacion(Date FechaUltModificacion) {
        this.FechaUltModificacion = FechaUltModificacion;
    }

    public int getIDMovimiento() {
        return IDMovimiento;
    }

    public void setIDMovimiento(int IDMovimiento) {
        this.IDMovimiento = IDMovimiento;
    }

    public int getNumeroControl() {
        return NumeroControl;
    }

    public void setNumeroControl(int NumeroControl) {
        this.NumeroControl = NumeroControl;
    }

    public int getIDUsuarioCaptura() {
        return IDUsuarioCaptura;
    }

    public void setIDUsuarioCaptura(int IDUsuarioCaptura) {
        this.IDUsuarioCaptura = IDUsuarioCaptura;
    }

    public int getIdArea() {
        return IdArea;
    }

    public void setIdArea(int IdArea) {
        this.IdArea = IdArea;
    }

    public boolean isImpresion() {
        return Impresion;
    }

    public void setImpresion(boolean Impresion) {
        this.Impresion = Impresion;
    }

    public boolean isValidacion() {
        return Validacion;
    }

    public void setValidacion(boolean Validacion) {
        this.Validacion = Validacion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getIdAutoridadDeterminante() {
        return IdAutoridadDeterminante;
    }

    public void setIdAutoridadDeterminante(String IdAutoridadDeterminante) {
        this.IdAutoridadDeterminante = IdAutoridadDeterminante;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getExpedienteProcedencia() {
        return ExpedienteProcedencia;
    }

    public void setExpedienteProcedencia(String ExpedienteProcedencia) {
        this.ExpedienteProcedencia = ExpedienteProcedencia;
    }

    public String getTipoNotificacion() {
        return TipoNotificacion;
    }

    public void setTipoNotificacion(String TipoNotificacion) {
        this.TipoNotificacion = TipoNotificacion;
    }

    public String getTipoCredito() {
        return TipoCredito;
    }

    public void setTipoCredito(String TipoCredito) {
        this.TipoCredito = TipoCredito;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public String getObsrvacionesCredito() {
        return ObsrvacionesCredito;
    }

    public void setObsrvacionesCredito(String ObsrvacionesCredito) {
        this.ObsrvacionesCredito = ObsrvacionesCredito;
    }

    public String getJefeDpartamento() {
        return JefeDpartamento;
    }

    public void setJefeDpartamento(String JefeDpartamento) {
        this.JefeDpartamento = JefeDpartamento;
    }

    public String getAsignacion() {
        return Asignacion;
    }

    public void setAsignacion(String Asignacion) {
        this.Asignacion = Asignacion;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public String getIdCoordinadora() {
        return IdCoordinadora;
    }

    public void setIdCoordinadora(String IdCoordinadora) {
        this.IdCoordinadora = IdCoordinadora;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaDocumentoDeterminante() {
        return FechaDocumentoDeterminante;
    }

    public void setFechaDocumentoDeterminante(Date FechaDocumentoDeterminante) {
        this.FechaDocumentoDeterminante = FechaDocumentoDeterminante;
    }

    public Date getFechaNotificacion() {
        return FechaNotificacion;
    }

    public void setFechaNotificacion(Date FechaNotificacion) {
        this.FechaNotificacion = FechaNotificacion;
    }

    public Date getFechaExigible() {
        return FechaExigible;
    }

    public void setFechaExigible(Date FechaExigible) {
        this.FechaExigible = FechaExigible;
    }

    public Date getFechaEstatus() {
        return FechaEstatus;
    }

    public void setFechaEstatus(Date FechaEstatus) {
        this.FechaEstatus = FechaEstatus;
    }

    public Date getFechaCaptura() {
        return FechaCaptura;
    }

    public void setFechaCaptura(Date FechaCaptura) {
        this.FechaCaptura = FechaCaptura;
    }

    public double getImporteDeterminado() {
        return importeDeterminado;
    }

    public void setImporteDeterminado(double importeDeterminado) {
        this.importeDeterminado = importeDeterminado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Crédito Fiscal" + "\nNumeroControl: " + NumeroControl + "\nCapturado por: " + SessionManager.getInstance().getNombreUsuario() + " - Fecha de captura: " + FechaCaptura + "\n\nDatos: \nRFC: " + rfc + "\nNúmero de crédito: " + numeroCredito + "\nRazón Social: " + RazonSocial + "\nDomicilio: " + Domicilio + "\nCódigo Postal: " + CodigoPostal + "\nColonia: " + Colonia + "\nMunicipio: " + Municipio + "\nAutoridad determinante: " + IdAutoridadDeterminante + "\nFecha recepción: " + fechaRecepcion + "\nExpediente de procedencia: " + ExpedienteProcedencia + "\nFecha documento determinante: " + FechaDocumentoDeterminante + "\nImporte Determinado: $" + importeDeterminado + "\nFecha Notificación: " + FechaNotificacion + "\nFecha Exigible del crédito: " + FechaExigible + "\nTipo de Notificación: " + TipoNotificacion + "\nTipo de crédito: " + TipoCredito + "\nEstatus: " + Estatus + "\nFecha de estatus: " + FechaEstatus + "\nJefe de departamento: " + JefeDpartamento + "\nAsignación: " + Asignacion + "\nCoordinadora: " + IdCoordinadora;
    }

}
