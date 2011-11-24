/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popcorn.service;

import com.google.appengine.api.datastore.Key;
import popcorn.persistence.*;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsuarioService extends UserDetailsService {
    //void preload_usuarios();    
    void create(Usuario usuario);
    Rol getRol(Usuario usuario);
    void crearRol();
    void setRol(Usuario usuario, String rol);
    void addRol(Usuario usuario, Rol rol);
    Usuario getUsuario(String idUsuario);    
    Usuario getCurrentUser();
    boolean isAdmin();
    
}
