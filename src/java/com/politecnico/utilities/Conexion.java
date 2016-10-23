/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebas Developer
 */
public class Conexion {

    private static Conexion instance = null;
    private EntityManagerFactory factory = null;

    private Conexion() {
        factory = Persistence.createEntityManagerFactory("FAQPU");
    }

    public static Conexion getInstace() {

        if (instance == null) {
            instance = new Conexion();
        }
        return instance;

    }

    /**
     * @return the factory
     */
    public EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * @param factory the factory to set
     */
    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

}
