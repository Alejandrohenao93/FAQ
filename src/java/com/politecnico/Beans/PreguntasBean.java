/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Beans;

import com.politecnico.Entitys.Preguntas;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sebas Developer
 */
@ManagedBean
@RequestScoped
public class PreguntasBean {

    private Preguntas preguntas = new Preguntas();

    public PreguntasBean() {
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

}
