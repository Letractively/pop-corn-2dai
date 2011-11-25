/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popcorn.persistence;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Key id;

    //@Column(nullable = false, length = 50)
    @Basic
    private String nombre;

    @Column()
    private String descripcion;
    
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public Rol() {
        
    }
    
    public List<Usuario> getUsuarios() {
        if(usuarios == null) {
            usuarios = new ArrayList<Usuario>();
        } 
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        return ((Rol)o).getId().equals(id) || ((Rol)o).getNombre().equals(nombre);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }

}
