package popcorn.dao;

import popcorn.dao.EMF;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.Query;


public class GenericPopDAOJPAImpl<T, PK extends Serializable> implements GenericPopDAO<T, PK> {

    EntityManager em;
    
    public GenericPopDAOJPAImpl() {
    	em = EMF.get().createEntityManager();
	}
	
    @Override
    public void insert(T t) {
        em.persist(t);
    }

    @Override
    public void closeEm() {
    	em.close();
    }
    
    @Override
    public T findByPK(Class<T> typeClass, PK id) {
    	return em.find(typeClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Class<T> typeClass) {
        final StringBuilder sql = new StringBuilder("select c from ").append(
                typeClass.getSimpleName()).append(" c");
        return (List<T>) em.createQuery(sql.toString()).getResultList();

    }
    
    @Override
   	public Integer countAll(Class<T> typeClass) {    	
       	em = EMF.get().createEntityManager();
           final StringBuilder sql = new StringBuilder("select count(c) from ").append(typeClass.getSimpleName()).append(" c");
           return (Integer)em.createQuery(sql.toString()).getSingleResult();
   	}

    @Override
    public void remove(T object) {
    	em.remove(em.merge(object));
    }

    @Override
    public void update(T object) {
    	em.merge(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getPaginated(Class<T> typeClass, int startPosition,
            int maxResult) {
        final StringBuilder sql = new StringBuilder("select c from ").append(
                typeClass.getSimpleName()).append(" c");
        final Query query = em.createQuery(sql.toString());
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResult);
        return (List<T>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getOrderedPaginated(Class<T> typeClass, int startPosition,
            int maxResult, String order, int dir) {
        String direccion = "ASC";
        if (dir == 2) {
            direccion = "DESC";
        }
        final StringBuilder sql = new StringBuilder("select c from ").append(typeClass.getSimpleName()).append(" c order by ").append(order).append(" ").append(direccion);
        final Query query = em.createQuery(
                sql.toString());
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResult);
        return (List<T>) query.getResultList();
    }
}
