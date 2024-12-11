
package set;

import set.Permisos;


public class SessionManager {

    private static SessionManager instance;

    private int usuarioID;
    private String codigoUsuario;
    private String nombreUsuario;
    private String tipoUsuario;
    private int nivel;
    private String email;
    private String contraseña;
    private String fechaCreacion;
    private String ultimoLogin;
    private String estado;
    private String telefono;
    private int idRol;
    private int idArea;
    private String cargo;
    private Permisos permisos;

    // Constructor privado
    private SessionManager() {
    }

    // Obtener la instancia única
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Getters y setters
    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para limpiar la sesión
    public void clearSession() {
        instance = null;
    }
     @Override
    public String toString() {
        return "Datos del usuario:" +
               "\nUsuario ID: " + usuarioID +
               "\nCódigo Usuario: " + codigoUsuario +
               "\nContraseña Usuario: "+ contraseña +
               "\nNombre Usuario: " + nombreUsuario +
               "\nTipo Usuario: " + tipoUsuario +
               "\nNivel: " + nivel +
               "\nEmail: " + email +
               "\nEstado: " + estado +
               "\nTeléfono: " + telefono +
               "\nRol: " + idRol +
               "\nÁrea: " + idArea +
               "\nCargo: " + cargo +
               "\fechaCreacion: " + fechaCreacion +
               "\nultimoLogin: " + ultimoLogin +
               "\nPermisos: " + permisos;
    }
 }