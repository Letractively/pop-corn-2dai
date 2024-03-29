package popcorn.persistence;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@Entity
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	@Basic 
	private User author;
	
	@Basic
	private String valoracion;
	
	@ManyToOne(fetch=FetchType.LAZY)
    private Pelicula pelicula;
	
	public Valoracion() {
		
	}
	
	public Valoracion(User author,String valoracion,Pelicula pelicula) {
		this.author = author;
		this.valoracion = valoracion;
		this.pelicula = pelicula;
	}
	
	public Key getId() {
		return id;
	}
	
	public void setId(Key id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public String getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
}
