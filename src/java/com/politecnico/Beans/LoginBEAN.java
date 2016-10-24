/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.Beans;

import com.politecnico.Entitys.Usuario;
import com.politecnico.utilities.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;

/**
 *
 * @author alejandro.henao
 */
@ManagedBean
@SessionScoped

public class LoginBEAN {

    /**
     * Creates a new instance of LoginBEAN
     */    
    
    String user;
    String pass;
    private Usuario usuario;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LoginBEAN() {

    }

    

   
   public void validateLogin() {
     Login login = new Login(user,pass);
        setUsuario(login.correctLogin());
     if(getUsuario()!= null){
      
         try {
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", getUsuario());
             FacesContext.getCurrentInstance().getExternalContext().redirect("/FAQ/pages/indexuser.jsf");
                setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario"));
         } catch (IOException ex) {
             Logger.getLogger(LoginBEAN.class.getName()).log(Level.SEVERE, null, ex);
         }
     }else{
         
     }
}

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
