package com.dto;

import java.io.Serializable;

/**
 *
 * @author DAFECESA
 */
public class Cliente implements Serializable{
    private Integer idCliente;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    
    public Cliente(){
    }

    public Cliente(int Id, String Nombre, String Apellido, String DNI, String Direccion) {
        this.idCliente = Id;
        this.nombre = Nombre;
        this.apellidos = Apellido;
        this.dni = DNI;
        this.direccion = Direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
