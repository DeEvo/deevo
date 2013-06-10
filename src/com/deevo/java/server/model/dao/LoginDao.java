package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Login;

public class LoginDao {
	
	
public boolean existeLogin(Login login) {
		
		EntityManager em = EMF.get().createEntityManager();
		Login login2= null;
	    try {
	      login2 = em.find(Login.class, login);
	    }
	    finally {
	      em.close();
	    }
	    if(login2 == null) return false;
	    
	    return true;
		}
		


		public void createLogin(Login login) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(login);
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

	  public Login retrieveLogin(Login login)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Login login2= null;
	    try {
	      login2 = em.find(Login.class, login.getUser());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return login2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Login> retrieveLogins() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Login> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Login x ";
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
	   
		  public Login updateLogin(Login login)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Login login2 = null;
		    try {
		     	tx.begin();
		     	login2 = em.merge(login);
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
		    return login2;
		  }


}
