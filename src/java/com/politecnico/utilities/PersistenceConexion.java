/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.utilities;

import com.politecnico.Entitys.Categorias;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Sebas Developer
 */
public abstract class PersistenceConexion {
    
    private EntityManagerFactory factory = null;
    private EntityManager manager = null;
    private EntityTransaction trasc = null;
    private Query querys;
    private Conexion conexion = null;

    public PersistenceConexion(){
        conexion = Conexion.getInstace();
        factory = conexion.getFactory();
        manager = factory.createEntityManager();
        trasc = manager.getTransaction();
    }

    public void crear(Object entidad) {
        trasc.begin();
        manager.persist(entidad);
        trasc.commit();;
    }

    public void editar(Object entidad) {
        trasc.begin();
        manager.merge(entidad);
        trasc.commit();
    }

    public void eliminar(Object entidad) {
        trasc.begin();
        manager.remove(manager.merge(entidad));
        trasc.commit();
    }

    public List<? extends Object> obtenerLista(String query,Object[] parametros) {

        
       querys = manager.createNamedQuery(query);
         if(parametros != null && parametros.length > 0){
            for (int i = 0; i < parametros.length; i++) {
                querys.setParameter((i+1),parametros[i]);
            }         
        }
         
        return querys.getResultList();
    }

    public <T extends Object> T obtenerObjeto(Class<T> clase, int id) {

        return (T) manager.find(clase, id);
    }

    public void ejecutar(String query,Object[] parametros) {
        
        trasc.begin();        
        
        querys = manager.createNativeQuery(query);
        if(parametros != null && parametros.length > 0){
            for (int i = 0; i < parametros.length; i++) {
                querys.setParameter((i+1),parametros[i]);
            }         
        }        
        querys.executeUpdate();
        trasc.commit();;

    }

}
