/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Beans;

import com.politecnico.DAO.CategoriasDAO;
import com.politecnico.Entitys.Categorias;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Sebas Developer
 */
@ManagedBean
@RequestScoped
public class CategoriasBean {

    private List<SelectItem> listadoCategorias;
    private Categorias categoria = new Categorias();
    private List<Categorias> lista;
    private CategoriasDAO daoCategoria = new CategoriasDAO();

    public CategoriasBean() {

    }

    public void crearCategoria() {

        categoria.setCaCategoria("Moodle");
        daoCategoria.crearCategoria(categoria);

    }

    /**
     * @return the categoria
     */
    public Categorias getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the listadoCategorias
     */
    public List<SelectItem> getListadoCategorias() {

        List<Categorias> listaCategorias = daoCategoria.listarCategorias();      
        listadoCategorias = new ArrayList();
        for (Categorias listaCategoria : listaCategorias) {
            listadoCategorias.add(new SelectItem(listaCategoria.getIdCategoria(),listaCategoria.getCaCategoria()));
        }

        return listadoCategorias;
    }

    /**
     * @param listadoCategorias the listadoCategorias to set
     */
    public void setListadoCategorias(List<SelectItem> listadoCategorias) {
        this.listadoCategorias = listadoCategorias;
    }

    /**
     * @return the lista
     */
    public List<Categorias> getLista() {
         lista = daoCategoria.listarCategorias();     
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Categorias> lista) {
        this.lista = lista;
    }

}
