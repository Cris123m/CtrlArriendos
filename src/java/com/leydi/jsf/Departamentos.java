/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leydi.jsf;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d")
    , @NamedQuery(name = "Departamentos.findByIdDepartamento", query = "SELECT d FROM Departamentos d WHERE d.idDepartamento = :idDepartamento")
    , @NamedQuery(name = "Departamentos.findByPiso", query = "SELECT d FROM Departamentos d WHERE d.piso = :piso")
    , @NamedQuery(name = "Departamentos.findByLetra", query = "SELECT d FROM Departamentos d WHERE d.letra = :letra")
    , @NamedQuery(name = "Departamentos.findByCapacidad", query = "SELECT d FROM Departamentos d WHERE d.capacidad = :capacidad")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "letra")
    private Character letra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private Collection<Arrendatarios> arrendatariosCollection;
    @JoinColumn(name = "precio_id", referencedColumnName = "id_precio")
    @ManyToOne(optional = false)
    private Precios precioId;

    public Departamentos() {
    }

    public Departamentos(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamentos(Integer idDepartamento, int piso, Character letra, int capacidad) {
        this.idDepartamento = idDepartamento;
        this.piso = piso;
        this.letra = letra;
        this.capacidad = capacidad;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<Arrendatarios> getArrendatariosCollection() {
        return arrendatariosCollection;
    }

    public void setArrendatariosCollection(Collection<Arrendatarios> arrendatariosCollection) {
        this.arrendatariosCollection = arrendatariosCollection;
    }

    public Precios getPrecioId() {
        return precioId;
    }

    public void setPrecioId(Precios precioId) {
        this.precioId = precioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leydi.jsf.Departamentos[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
