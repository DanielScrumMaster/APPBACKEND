package com.dmaktech.tienda.clientes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "ced_cliente")
    private Long cedula;
    @Column(name = "nom_cliente")
    private String nombres;
    @Column(name = "dir_cliente")
    private String direccion;
    @Column(name = "tel_cliente")
    private String telefono;
    @Column(name = "email_cliente")
    private String email;
    
    public Cliente() {}

    public Cliente(Long cedula, String nombres, String direccion, String telefono, String email) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [cedula=" + cedula + ", direccion=" + direccion + ", email=" + email + ", nombres=" + nombres
                + ", telefono=" + telefono + "]";
    }
}
