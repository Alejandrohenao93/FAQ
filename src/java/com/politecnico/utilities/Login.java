/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politecnico.utilities;

import com.politecnico.Entitys.Usuario;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author alejandro.henao
 */
public class Login {

    private String usuario;
    private String clave;
 

    private static final String LDAP_URL = "ldap://192.168.1.17:389";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario correctLogin() { //El usuario ya viene con toda la ruta
        try {
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, LDAP_URL);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, this.usuario+"@scaquestions.com");
            env.put(Context.SECURITY_CREDENTIALS, this.clave);
            
            DirContext ctx = new InitialDirContext(env);
            SearchControls searchCtls = new SearchControls();
            
            String returnedAtts[] = {"displayName", "mail", "cn", "givenName", "sn", "memberOf","sAMAccountName"};

            searchCtls.setReturningAttributes(returnedAtts);

            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

             String searchFilter = "(&(objectClass=*)(samaccountname="+this.usuario+"))";

            String searchBase = "DC=scaquestions,DC=COM";

            NamingEnumeration answer = ctx.search(searchBase, searchFilter, searchCtls);

            Usuario user = null;

            while (answer.hasMoreElements()) {

                SearchResult sr = (SearchResult) answer.next();

                Attributes attrs = sr.getAttributes();

                if (attrs != null) {

                    try {
                                             
                        user = new Usuario((attrs.get("givenName").get()!=null)?attrs.get("givenName").get().toString():"",
                                (attrs.get("sn").get()!=null)?attrs.get("sn").get().toString():"",
                                (attrs.get("mail").get()!=null)?attrs.get("mail").get().toString():"",
                                (attrs.get("memberof").get()!=null)?attrs.get("memberof").get(0).toString():"",
                                (attrs.get("cn").get()!=null)?attrs.get("samaccountname").get().toString():"");
                     
                        

                    } catch (NullPointerException e) {

                        System.out.println("Errors listing attributes: " + e);

                    }

                }

            }
            ctx.close();
            return user;
        } catch (NamingException e) {
            return null;
        }
    }
}
