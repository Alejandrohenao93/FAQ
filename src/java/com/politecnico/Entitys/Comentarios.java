/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Entitys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebas Developer
 */
@Entity
@Table(name = "comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
    @NamedQuery(name = "Comentarios.findByIdComentario", query = "SELECT c FROM Comentarios c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentarios.findByCaComentario", query = "SELECT c FROM Comentarios c WHERE c.caComentario = :caComentario"),
    @NamedQuery(name = "Comentarios.findByCaUsuario", query = "SELECT c FROM Comentarios c WHERE c.caUsuario = :caUsuario"),
    @NamedQuery(name = "Comentarios.findByCaCorreo", query = "SELECT c FROM Comentarios c WHERE c.caCorreo = :caCorreo"),
    @NamedQuery(name = "Comentarios.findByFechaComentario", query = "SELECT c FROM Comentarios c WHERE c.fechaComentario = :fechaComentario")})
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComentario")
    private Integer idComentario;
    @Column(name = "caComentario")
    private String caComentario;
    @Column(name = "caUsuario")
    private String caUsuario;
    @Column(name = "caCorreo")
    private String caCorreo;
    @Column(name = "fechaComentario")
    @Temporal(TemporalType.DATE)
    private Date fechaComentario;
    @JoinTable(name = "preguntas_has_comentarios", joinColumns = {
        @JoinColumn(name = "idComentario", referencedColumnName = "idComentario")}, inverseJoinColumns = {
        @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")})
    @ManyToMany
    private Collection<Preguntas> preguntasCollection;
    @OneToMany(mappedBy = "idComentarioResp")
    private Collection<Comentarios> comentariosCollection;
    @JoinColumn(name = "idComentarioResp", referencedColumnName = "idComentario")
    @ManyToOne
    private Comentarios idComentarioResp;

    public Comentarios() {
    }

    public Comentarios(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getCaComentario() {
        return caComentario;
    }

    public void setCaComentario(String caComentario) {
        this.caComentario = caComentario;
    }

    public String getCaUsuario() {
        return caUsuario;
    }

    public void setCaUsuario(String caUsuario) {
        this.caUsuario = caUsuario;
    }

    public String getCaCorreo() {
        return caCorreo;
    }

    public void setCaCorreo(String caCorreo) {
        this.caCorreo = caCorreo;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    @XmlTransient
    public Collection<Preguntas> getPreguntasCollection() {
        return preguntasCollection;
    }

    public void setPreguntasCollection(Collection<Preguntas> preguntasCollection) {
        this.preguntasCollection = preguntasCollection;
    }

    @XmlTransient
    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
    }

    public Comentarios getIdComentarioResp() {
        return idComentarioResp;
    }

    public void setIdComentarioResp(Comentarios idComentarioResp) {
        this.idComentarioResp = idComentarioResp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.politecnico.Entitys.Comentarios[ idComentario=" + idComentario + " ]";
    }
    
}
