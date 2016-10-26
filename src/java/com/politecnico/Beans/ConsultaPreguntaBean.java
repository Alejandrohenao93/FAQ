/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Beans;

import com.politecnico.DAO.PreguntasDAO;
import com.politecnico.Entitys.Preguntas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alejandro.henao
 */
@ManagedBean(name = "ConsultaPreguntaBean")
@RequestScoped
public class ConsultaPreguntaBean {

    public ConsultaPreguntaBean() {

    }

    private List<Preguntas> Preguntaslist = new ArrayList<Preguntas>();

    public List<Preguntas> getPreguntaslist() {

        PreguntasDAO dao = new PreguntasDAO();
        Preguntaslist = dao.ConsultaPreguntas();
        return Preguntaslist;
    }
String algo;

}
