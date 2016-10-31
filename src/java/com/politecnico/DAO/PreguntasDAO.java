/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.DAO;

import com.politecnico.Entitys.Preguntas;
import com.politecnico.utilities.PersistenceConexion;
import java.util.List;

/**
 *
 * @author Sebas Developer
 */
public class PreguntasDAO extends PersistenceConexion {

    public int crearPregunta(Preguntas pregunta) {
        crear(pregunta);
        return 0;
    }

    public List<Preguntas> ConsultaPreguntas() {
        return (List<Preguntas>) obtenerLista("Preguntas.findActive", null);
    }
    public List<Preguntas> ConsultaPreguntasAdmin() {
        return (List<Preguntas>) obtenerLista("Preguntas.findAll", null);
    }

    public String editarPregunta(Preguntas pregunta) {
        String msg = "";
        try {
            ejecutar("UPDATE Preguntas p Set p.caPregunta = ?1 where p.idPregunta = ?2 "
                    ,new Object[]{pregunta.getCaPregunta(),pregunta.getIdPregunta()});
            msg = "Se ha actualizado con exito";
        } catch (Exception e) {
            msg = "Hubo un problema al actualizar intente mas tarde";
        }
        return msg;
    }

}
