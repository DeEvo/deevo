package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;



import com.deevo.java.server.EMF;
import com.deevo.java.share.Login;

public class LogIndao {

	
	public void createLogin(Login logIn) throws EntityExistsException , Throwable {
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		 try {
			       tx.begin();
			       em.persist(logIn);
			       tx.commit();
			     }
		 catch (RollbackException | EntityExistsException e){
			 throw new EntityExistsException("=P");
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

		  public Login retrieveLogin(String per_dni) {

			EntityManager em = EMF.get().createEntityManager();

		    Login logIn= null;
		    try {
		      logIn = em.find(Login.class, per_dni);
		    }
		    finally {
		      em.close();
		    }
		    return logIn;
		  }   
		  
		  
		  @SuppressWarnings("unchecked")
		public List<Login> retrieveAccounts() {
			  
		    EntityManager em = EMF.get().createEntityManager();
		    List<Login> list = null;
		    
		    try {
		    	String qery = "SELECT x FROM PadreFamilia x ";
	            list= em.createQuery(qery).getResultList();
	          //  list = q.getResultList();
		    }
		    finally {
		      em.close();
		    }
		    return list;
		  }
		   
		  public Login updateLogin(Login logIn) {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Login logIn2 = null;
		    try {
		      tx.begin();
		      logIn2 = em.merge(logIn);
		      tx.commit();
		    }
		    catch (Throwable t) {
		      t.printStackTrace();
		      tx.rollback();
		    }
		    finally {
		      em.close();
		    }
		    return logIn2;
		  }
		  
		  
		  public void deleteAccount(Login logIn) {
			  
		  EntityManager em = EMF.get().createEntityManager();
		  EntityTransaction tx = em.getTransaction();
		    
		    try {
		      tx.begin();
		      em.remove(em.merge(logIn));
		      tx.commit();
		    }
		    catch (Throwable t) {
		      t.printStackTrace();
		      tx.rollback();
		    }
		    finally {
		      em.close();
		    }
		  }

}
