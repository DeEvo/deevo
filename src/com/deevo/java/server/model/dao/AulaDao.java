package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Aula;



public class AulaDao {

	
	public boolean existeAula(Aula aula) {
		
		EntityManager em = EMF.get().createEntityManager();
		Aula aula2= null;
	    try {
	      aula2 = em.find(Aula.class, aula.getCodAula());
	    }
	    finally {
	      em.close();
	    }
	    if(aula2 == null) return false;
	    
	    return true;
		}
		


public void createAula(Aula aula) throws EntityExistsException , Throwable {
	
	EntityManager em = EMF.get().createEntityManager();
	EntityTransaction tx = em.getTransaction();

	 try {
		       tx.begin();
		       em.persist(aula);
		       tx.commit();
		     }catch ( EntityExistsException | RollbackException e){
				 throw new EntityExistsException();
		     }
		     catch (Throwable t) {
		       t.printStackTrace();
		       tx.rollback();
		       throw t;
		     }
		     finally {
		       em.close();
		     }
	  }

	  public Aula retrieveAula(Aula aula)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Aula aula2= null;
	    try {
	      aula2 = em.find(Aula.class, aula.getCodAula());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return aula2;
	  }   
	  
	  
	  @SuppressWarnings("unchecked")
	public List<Aula> retrieveAulas() throws Throwable{
		  
	    EntityManager em = EMF.get().createEntityManager();	
	    List<Aula> list = null;
	   
	    try {
	    	String qery = "SELECT x FROM Aula x ";
            list= em.createQuery(qery).getResultList();
          //  list = q.getResultList();
	    }catch(Throwable t){
	    	t.printStackTrace();
	        throw t;
        } finally {
            em.close();
        }
        return list;
	  }
	   
	  public Aula updateAula(Aula aula)  throws Throwable {
		  
		EntityManager em = EMF.get().createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    Aula aula2 = null;
	    try {
	     	tx.begin();
	     	aula2 = em.merge(aula);
	     	tx.commit();
	    }
	    catch (Throwable t) {
	      t.printStackTrace();
	      tx.rollback();
	      throw t;
	    }
	    finally {
	      em.close();
	    }
	    return aula2;
	  }
	  
	  
	  public void deleteAula(Aula aula)  throws Throwable  {
		  
	  EntityManager em = EMF.get().createEntityManager();
	  EntityTransaction tx = em.getTransaction();
	    
	    try {
	      tx.begin();
	      em.remove(em.merge(aula));
	      tx.commit();
	    }
	    catch (Throwable t) {
	      t.printStackTrace();
	      tx.rollback();
	      throw t;
	    }
	    finally {
	      em.close();
	    }
	  }

}
