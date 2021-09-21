package com.dmaktech.tienda.proveedores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {

    @Id
    @Column(name="nit_proveedores")
    private Long nit;
    @Column(name="ciudad_proveedor")
    private String ciudad;
    @Column(name="dir_proveedor")
    private String direccion;    
    @Column(name="nom_proveedor")
    private String nombre;
    @Column(name="tel_proveedor")
    private String telefono;

    public Proveedor() {}

    public Proveedor(Long nit, String ciudad, String direccion, String nombre, String telefono) {
        this.nit = nit;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor [ciudad=" + ciudad + ", direccion=" + direccion + ", nit=" + nit + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }  
}
