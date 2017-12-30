/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAFECESA
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente_1.findAll", query = "SELECT c FROM Cliente_1 c")
    , @NamedQuery(name = "Cliente_1.findByIdCliente", query = "SELECT c FROM Cliente_1 c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente_1.findByNombre", query = "SELECT c FROM Cliente_1 c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente_1.findByApellidos", query = "SELECT c FROM Cliente_1 c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cliente_1.findByDni", query = "SELECT c FROM Cliente_1 c WHERE c.dni = :dni")
    , @NamedQuery(name = "Cliente_1.findByDireccion", query = "SELECT c FROM Cliente_1 c WHERE c.direccion = :direccion")})
public class Cliente_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Column(name = "direccion")
    private String direccion;

    public Cliente_1() {
    }

    public Cliente_1(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente_1(Integer idCliente, String nombre, String apellidos, String dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente_1)) {
            return false;
        }
        Cliente_1 other = (Cliente_1) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dto.Cliente_1[ idCliente=" + idCliente + " ]";
    }
    
}
