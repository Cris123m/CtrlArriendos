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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "arrendatarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrendatarios.findAll", query = "SELECT a FROM Arrendatarios a")
    , @NamedQuery(name = "Arrendatarios.findByCedula", query = "SELECT a FROM Arrendatarios a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Arrendatarios.findByNombres", query = "SELECT a FROM Arrendatarios a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "Arrendatarios.findByApellidos", query = "SELECT a FROM Arrendatarios a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Arrendatarios.findByTelefono", query = "SELECT a FROM Arrendatarios a WHERE a.telefono = :telefono")})
public class Arrendatarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private Departamentos departamentoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arrendatariosCedula")
    private Collection<Pagos> pagosCollection;

    public Arrendatarios() {
    }

    public Arrendatarios(String cedula) {
        this.cedula = cedula;
    }

    public Arrendatarios(String cedula, String nombres, String apellidos, String telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Departamentos getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamentos departamentoId) {
        this.departamentoId = departamentoId;
    }

    @XmlTransient
    public Collection<Pagos> getPagosCollection() {
        return pagosCollection;
    }

    public void setPagosCollection(Collection<Pagos> pagosCollection) {
        this.pagosCollection = pagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arrendatarios)) {
            return false;
        }
        Arrendatarios other = (Arrendatarios) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cedula + " - " + nombres + " " + apellidos ;
    }
    
}
