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
@Table(name = "precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precios.findAll", query = "SELECT p FROM Precios p")
    , @NamedQuery(name = "Precios.findByIdPrecio", query = "SELECT p FROM Precios p WHERE p.idPrecio = :idPrecio")
    , @NamedQuery(name = "Precios.findByValorArriendo", query = "SELECT p FROM Precios p WHERE p.valorArriendo = :valorArriendo")
    , @NamedQuery(name = "Precios.findByValorGarantia", query = "SELECT p FROM Precios p WHERE p.valorGarantia = :valorGarantia")})
public class Precios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_precio")
    private Integer idPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_arriendo")
    private double valorArriendo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_garantia")
    private double valorGarantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precioId")
    private Collection<Departamentos> departamentosCollection;

    public Precios() {
    }

    public Precios(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Precios(Integer idPrecio, double valorArriendo, double valorGarantia) {
        this.idPrecio = idPrecio;
        this.valorArriendo = valorArriendo;
        this.valorGarantia = valorGarantia;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public double getValorArriendo() {
        return valorArriendo;
    }

    public void setValorArriendo(double valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    public double getValorGarantia() {
        return valorGarantia;
    }

    public void setValorGarantia(double valorGarantia) {
        this.valorGarantia = valorGarantia;
    }

    @XmlTransient
    public Collection<Departamentos> getDepartamentosCollection() {
        return departamentosCollection;
    }

    public void setDepartamentosCollection(Collection<Departamentos> departamentosCollection) {
        this.departamentosCollection = departamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precios)) {
            return false;
        }
        Precios other = (Precios) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPrecio + " Arriendo: " + valorArriendo + " Garantia: " + valorGarantia;
    }
    
}
