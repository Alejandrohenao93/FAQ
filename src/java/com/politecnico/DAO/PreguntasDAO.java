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
public class PreguntasDAO extends PersistenceConexion{
    
    public int crearPregunta(Preguntas pregunta){        
        crear(pregunta);
        return 0;
    }
    
    public List<Preguntas> ConsultaPreguntas(){
        return (List<Preguntas>) obtenerLista("Preguntas.findActive", null);
    }
    
    
}
