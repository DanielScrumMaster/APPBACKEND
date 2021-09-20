package com.dmaktech.tienda.usuario;

public class Usuario {
    
    private Long cedula;
    private String nombres;
    private String email;
    private String password;
    private String usuario;

    public Usuario(Long cedula, String nombres, String email, String password, String usuario) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.email = email;
        this.password = password;
        this.usuario = usuario;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cedula=" + cedula +
                ", nombres='" + nombres + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
