package popcorn.service;

import com.google.appengine.api.datastore.Key;
/*import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;*/
import popcorn.dao.PeliculaDAO;
import popcorn.persistence.Pelicula;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
/**
 *
 * @author david
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {
    
    private PeliculaDAO peliculaDAO;
    
    @Autowired
    @Required
    public void setPeliculaDAO(final PeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }
    
    @Override
    public void create(final Pelicula pelicula) {
        peliculaDAO.insert(pelicula);
    }
    
    @Override
    public void borrar(Key idPelicula) {
        Pelicula pelicula = peliculaDAO.findByPK(Pelicula.class, idPelicula);
        if(pelicula != null) {
            peliculaDAO.remove(pelicula);
        }
    }
    
    @Override
    public Pelicula getPelicula(Key idPelicula) {
        return peliculaDAO.findByPK(Pelicula.class, idPelicula);
    }
    
    @Override
    public Collection<Pelicula> getAllPeliculas() {
        return peliculaDAO.getAll(Pelicula.class);
    }

    @Override
    public int countAllPeliculas() {
        return peliculaDAO.countAll(Pelicula.class);
    }
}