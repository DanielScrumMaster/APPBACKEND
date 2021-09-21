package com.dmaktech.tienda.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @Column(name = "ced_usuario")
    private Long cedula;
    @Column(name = "nom_usuario")
    private String nombres;
    @Column(name = "email_usuario")
    private String email;
    @Column(name = "password_usuario")
    private String password;
    @Column(name = "usuario")
    private String usuario;

    public Usuario() {}

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
