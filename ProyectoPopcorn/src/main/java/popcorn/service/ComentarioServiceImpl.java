package popcorn.service;

import com.google.appengine.api.datastore.Key;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import popcorn.dao.ComentarioDAO;
import popcorn.dao.PeliculaDAO;
import popcorn.persistence.Comentario;
import popcorn.persistence.Pelicula;

/**
 *
 * @author miguel
 */
@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    private ComentarioDAO comentarioDAO;
    private PeliculaDAO peliculaDAO;
    
    
    @Autowired
    @Required
    public void setComentarioDAO(final ComentarioDAO comentarioDao) {
        this.comentarioDAO = comentarioDao;
    }

    @Autowired
    @Required
    public void setPeliculaDAO(final PeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }    
    
    @Override
    public void create(final Comentario comentario) {
        comentarioDAO.insert(comentario);
    }

    @Override
    public void create(final Comentario comentario, Key idPelicula) {
        Pelicula pelicula = peliculaDAO.findByPK(Pelicula.class, idPelicula);
        comentario.setNomPeli(pelicula.getTitulo());
        pelicula.getComentarios().add(comentario);
    }

    @Override
    public Collection<Comentario> getAllComentarios(Key idPelicula) {
        Pelicula pelicula = peliculaDAO.findByPK(Pelicula.class, idPelicula);
        return pelicula.getComentarios();                
    }

    @Override
    public Collection<Comentario> getAll() {
        return comentarioDAO.getAll(Comentario.class);
    }

    @Override
    public Collection<Comentario> getPaginaComentarios(int startPosition, int maxResult) {
        return comentarioDAO.getOrderedPaginated(Comentario.class, startPosition, maxResult, "fecha", 2);
    }
    
    @Override
    public Collection<Comentario> getComentariosPeli(String titulo) {        
        return comentarioDAO.getComentariosPeli(titulo);                
    }    

    @Override
    public int countAllComentarios() {
        return comentarioDAO.countAll(Comentario.class);
    }
    
    @Override
    public void borrarComentario(Key idComentario) {
        Comentario com = comentarioDAO.findByPK(Comentario.class, idComentario);
        com.setContent("El contenido de este comentario ha sido eliminado por los administradores.");
    }
    
    @Override
    public void borrarComentario2(Key idComentario) {
        Comentario com = comentarioDAO.findByPK(Comentario.class, idComentario);
        com.setContent("El comentario ha sido eliminado por su autor.");
    }
}
