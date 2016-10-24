/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.DAO;

import com.politecnico.Entitys.Categorias;
import com.politecnico.utilities.PersistenceConexion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebas Developer
 */
public class CategoriasDAO extends PersistenceConexion {

    public void crearCategoria(Categorias categoria) {

        crear(categoria);
    }

    public List<Categorias> listarCategorias() {

        return (List<Categorias>) obtenerLista("Categorias.consultarCategorias", null);

    }

    /*public void editar(Categorias categoria){
        categoria.setIdCategoria(1);
        categoria.setCaCategoria("Notas finales");
        editar(categoria);
    }
    
    public void eliminar(Categorias categoria){
        
        eliminar(categoria);        
    }
     */
 /*
    public void obtenerCategoria(Categorias categoria){
        
        categoria = obtenerObjeto(Categorias.class, 1);
        
    }
    
    public void ejecutar(Categorias categoria){        
        
        categoria.setCaCategoria("Parciales");
        categoria.setIdCategoria(9);
        
        Object[] params = new Object[]{categoria.getIdCategoria(),categoria.getCaCategoria()};
        ejecutar("INSERT INTO Categorias VALUES(?1,?2)",params);
        
    }*/
}
