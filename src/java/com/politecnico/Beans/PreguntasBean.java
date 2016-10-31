/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Beans;

import com.politecnico.DAO.PreguntasDAO;
import com.politecnico.Entitys.Categorias;
import com.politecnico.Entitys.Preguntas;
import com.politecnico.Entitys.Usuario;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Sebas Developer
 */
@ManagedBean
@ViewScoped
public class PreguntasBean implements Serializable{

    private Preguntas preguntas = new Preguntas();
    private PreguntasDAO daoPreguntas = new PreguntasDAO();
    private List<Preguntas> preguntasList;
    private CategoriasBean categoriaBean = new CategoriasBean();
    private List<Preguntas> PreguntasAdmin = new ArrayList<Preguntas>();
    private String pregunta;
    
    @PostConstruct
    public void init(){
        PreguntasAdmin = daoPreguntas.ConsultaPreguntasAdmin();
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public PreguntasBean() {

    }

    public void setPreguntasList(List<Preguntas> preguntasList) {
        this.preguntasList = preguntasList;
    }

    /**
     * @return the preguntas
     */
    public Preguntas getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the categoriaBean
     */
    public CategoriasBean getCategoriaBean() {
        return categoriaBean;
    }

    /**
     * @param categoriaBean the categoriaBean to set
     */
    public void setCategoriaBean(CategoriasBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public void crearPregunta() {

        preguntas.setIdCategoria(getCategoriaBean().getCategoria());
        Usuario autor = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        preguntas.setNombreUsuarioCreacion(autor.getNombre());
        preguntas.setApellidosUsuarioCreacion(autor.getApellidos());
        daoPreguntas.crearPregunta(preguntas);

    }

    public List<Preguntas> getPreguntasList() {
        return preguntasList = daoPreguntas.ConsultaPreguntas();
    }

    public List<Preguntas> getPreguntasAdmin() {
        return PreguntasAdmin;
    }

    public void setPreguntasAdmin(List<Preguntas> PreguntasAdmin) {
        this.PreguntasAdmin = PreguntasAdmin;
    }

    public void actualizarPregunta(RowEditEvent event) {
        preguntas = (Preguntas) event.getObject();
        String msg = daoPreguntas.editarPregunta(preguntas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));

    }

}
