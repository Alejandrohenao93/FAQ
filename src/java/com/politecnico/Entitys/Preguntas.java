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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author alejandro.henao
 */
@Entity
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
    @NamedQuery(name = "Preguntas.findByIdPregunta", query = "SELECT p FROM Preguntas p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Preguntas.findByCaPregunta", query = "SELECT p FROM Preguntas p WHERE p.caPregunta = :caPregunta"),
    @NamedQuery(name = "Preguntas.findByCaRespuesta", query = "SELECT p FROM Preguntas p WHERE p.caRespuesta = :caRespuesta"),
    @NamedQuery(name = "Preguntas.findByFeInicioVigencia", query = "SELECT p FROM Preguntas p WHERE p.feInicioVigencia = :feInicioVigencia"),
    @NamedQuery(name = "Preguntas.findByFeFinVigencia", query = "SELECT p FROM Preguntas p WHERE p.feFinVigencia = :feFinVigencia"),
    @NamedQuery(name = "Preguntas.findByCaEstado", query = "SELECT p FROM Preguntas p WHERE p.caEstado = :caEstado"),
    @NamedQuery(name = "Preguntas.findByFeCreacion", query = "SELECT p FROM Preguntas p WHERE p.feCreacion = :feCreacion"),
    @NamedQuery(name = "Preguntas.findByFeActualizacion", query = "SELECT p FROM Preguntas p WHERE p.feActualizacion = :feActualizacion")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPregunta")
    private Integer idPregunta;
    @Column(name = "caPregunta")
    private String caPregunta;
    @Column(name = "caRespuesta")
    private String caRespuesta;
    @Column(name = "feInicioVigencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feInicioVigencia;
    @Column(name = "feFinVigencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feFinVigencia;
    @Column(name = "caEstado")
    private String caEstado;
    @Column(name = "feCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feCreacion;
    @Column(name = "feActualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feActualizacion;
    @JoinColumn(name = "idUsuarioCreacion", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;
    @JoinColumn(name = "idUsuarioActualiza", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuarioActualiza;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta")
    private Collection<Respuesta> respuestaCollection;

    public Preguntas() {
    }

    public Preguntas(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getCaPregunta() {
        return caPregunta;
    }

    public void setCaPregunta(String caPregunta) {
        this.caPregunta = caPregunta;
    }

    public String getCaRespuesta() {
        return caRespuesta;
    }

    public void setCaRespuesta(String caRespuesta) {
        this.caRespuesta = caRespuesta;
    }

    public Date getFeInicioVigencia() {
        return feInicioVigencia;
    }

    public void setFeInicioVigencia(Date feInicioVigencia) {
        this.feInicioVigencia = feInicioVigencia;
    }

    public Date getFeFinVigencia() {
        return feFinVigencia;
    }

    public void setFeFinVigencia(Date feFinVigencia) {
        this.feFinVigencia = feFinVigencia;
    }

    public String getCaEstado() {
        return caEstado;
    }

    public void setCaEstado(String caEstado) {
        this.caEstado = caEstado;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public Date getFeActualizacion() {
        return feActualizacion;
    }

    public void setFeActualizacion(Date feActualizacion) {
        this.feActualizacion = feActualizacion;
    }

    public Usuarios getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuarios idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Usuarios getIdUsuarioActualiza() {
        return idUsuarioActualiza;
    }

    public void setIdUsuarioActualiza(Usuarios idUsuarioActualiza) {
        this.idUsuarioActualiza = idUsuarioActualiza;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.politecnico.Entitys.Preguntas[ idPregunta=" + idPregunta + " ]";
    }
    
}
