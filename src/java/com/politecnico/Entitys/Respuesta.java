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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro.henao
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByDescripcionRespuesta", query = "SELECT r FROM Respuesta r WHERE r.descripcionRespuesta = :descripcionRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuestacol", query = "SELECT r FROM Respuesta r WHERE r.respuestacol = :respuestacol"),
    @NamedQuery(name = "Respuesta.findByFechaRespuesta", query = "SELECT r FROM Respuesta r WHERE r.fechaRespuesta = :fechaRespuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRespuesta")
    private Integer idRespuesta;
    @Column(name = "descripcionRespuesta")
    private String descripcionRespuesta;
    @Column(name = "Respuestacol")
    private String respuestacol;
    @Column(name = "fechaRespuesta")
    @Temporal(TemporalType.DATE)
    private Date fechaRespuesta;
    @JoinTable(name = "respuesta_comentario", joinColumns = {
        @JoinColumn(name = "idRespuesta", referencedColumnName = "idRespuesta")}, inverseJoinColumns = {
        @JoinColumn(name = "idComentario", referencedColumnName = "idComentario")})
    @ManyToMany
    private Collection<Comentarios> comentariosCollection;
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    @ManyToOne(optional = false)
    private Preguntas idPregunta;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }

    public String getRespuestacol() {
        return respuestacol;
    }

    public void setRespuestacol(String respuestacol) {
        this.respuestacol = respuestacol;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    @XmlTransient
    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
    }

    public Preguntas getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Preguntas idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.politecnico.Entitys.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
