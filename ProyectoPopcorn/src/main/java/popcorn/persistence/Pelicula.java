package popcorn.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
//import java.util.Date;

@Entity
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key id;
    
    @Basic
    private String sinopsis;
    
    @Basic
    private String titulo;
    
    @Basic
    private int duracion;
    
    @Basic
    private String categoria;
    
    @Basic
    private List<String> actores = new ArrayList<String>();
    
    @Basic
    private String director;
    
    @Basic
    private String imagen;
     
    //@Temporal(javax.persistence.TemporalType.DATE)
    //private Date fechEstreno;
    @Basic
    private String fechEstreno;
    
    @Basic
    private String trailer;
    
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Valoracion> valoraciones;
    
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    public Pelicula() {
    }

    public Pelicula(String titulo, String sinopsis, int duracion, String categoria, String director,String fecha,String trailer) {
        this.sinopsis = sinopsis;
        this.titulo = titulo;
        this.duracion = duracion;
        this.categoria = categoria;
        this.director = director;
        this.fechEstreno = fecha;
        this.trailer = trailer;
        this.valoraciones = new ArrayList<Valoracion>();
        this.comentarios = new ArrayList<Comentario>();    
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getFechEstreno() {
        return fechEstreno;
    }
    
    public void setFechEstreno(String fechEstreno) {
        this.fechEstreno = fechEstreno;
    }
    
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    } 
    
    public List<Valoracion> getValoraciones() {
        if(valoraciones == null) {
            valoraciones = new ArrayList<Valoracion>();
        } 
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }    

    public List<Comentario> getComentarios() {
        if(comentarios == null) {
            comentarios = new ArrayList<Comentario>();
        }
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public String getIdString() {
        return KeyFactory.keyToString(id);
    }
}
