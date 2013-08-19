/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */

    @Repository
public class HibernateExcerptSpitter implements ExcerptSpitterDAO {

        @Autowired
    private SessionFactory sessionFactory;
    
    public Session currentSession() {
    
        
       return sessionFactory.getCurrentSession();
    }

    public void addExcerpt(Excerpt exc) {
        //System.out.println(currentSession().isConnected());
        /*sessionFactory.openSession();
        System.out.println(currentSession().isConnected());
        currentSession().beginTransaction();
        
        currentSession().getTransaction().commit();
        currentSession().close();*/
        currentSession().save(exc);
    }

    public boolean createTable() {

    return false;
    }

    public void removeExcerpt(Excerpt exc) {
        currentSession().delete(exc);
       
    }

    public void updateExcerpt(Excerpt exc) {
    currentSession().update(exc);
    }

    public void setSpitterTemplate(JdbcTemplate jdbcTemplate) {

    }

    public List<Excerpt> getExcerptbyAccountName(String name)
    {
        
        return (List<Excerpt>) currentSession().get(List.class, name);
    }
    /**
     * Method selects a single instance and makes a map of the ENTITY-COLUMN/VALUE
     * relationship.
     * @return Map of the object
     */
    @Override
    public Map<String, Object> getMappedExcerpt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getEntity(ExcerptIdentifier id) {
       return currentSession().byId(Excerpt.class).getReference(id);
    }

    @Override
    public List retrieveByDate(Date d) {
        List objects = currentSession().createQuery("FROM Excerpt E WHERE E.id.date < ?").setDate(0, d).list();
        return objects;
    }
    
    
  
}
