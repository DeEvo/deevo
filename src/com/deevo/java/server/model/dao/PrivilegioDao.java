package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Privilegio;


public class PrivilegioDao {

public boolean existePrivilegio(Privilegio privilegio) {
		
		EntityManager em = EMF.get().createEntityManager();
		Privilegio privilegio2= null;
	    try {
	      privilegio2 = em.find(Privilegio.class, privilegio.getPriCod());
	    }
	    finally {
	      em.close();
	    }
	    if(privilegio2 == null) return false;
	    
	    return true;
		}
		


		public void createPrivilegio(Privilegio privilegio) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(privilegio);
				       em.flush();
				       em.refresh(privilegio);
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

	  public Privilegio retrievePrivilegio(Privilegio privilegio)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Privilegio privilegio2= null;
	    try {
	      privilegio2 = em.find(Privilegio.class, privilegio.getPriCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return privilegio2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Privilegio> retrievePrivilegios() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Privilegio> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Privilegio x ";
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
	   
		  public Privilegio updatePrivilegio(Privilegio privilegio)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Privilegio privilegio2 = null;
		    try {
		     	tx.begin();
		     	privilegio2 = em.merge(privilegio);
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
		    return privilegio2;
		  }
}
