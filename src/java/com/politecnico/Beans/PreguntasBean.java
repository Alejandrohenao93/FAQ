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
import java.util.AbstractList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sebas Developer
 */
@ManagedBean
@RequestScoped
public class PreguntasBean {

    private Preguntas preguntas = new Preguntas();
    private PreguntasDAO daoPreguntas = new PreguntasDAO();
    private List<Preguntas> preguntasList;
    private CategoriasBean categoriaBean = new CategoriasBean();

    public PreguntasBean() {

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

}
