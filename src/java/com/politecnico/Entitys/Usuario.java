/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Entitys;

/**
 *
 * @author alejandro.henao
 */
public class Usuario {
    String nombre;
    String apellidos;
    String email;
    String grupo;
    String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Usuario(String nombre, String apellidos, String email, String grupo,String usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.grupo = grupo;
        this.usuario = usuario;
    }
    
}
