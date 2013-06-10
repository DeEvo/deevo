package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;



import com.deevo.java.server.EMF;

import com.deevo.java.share.LogIn;

public class LogIndao {

	
	public void createLogIn(LogIn logIn) throws EntityExistsException , Throwable {
		
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

		  public LogIn retrieveLogIn(String per_dni) {

			EntityManager em = EMF.get().createEntityManager();

		    LogIn logIn= null;
		    try {
		      logIn = em.find(LogIn.class, per_dni);
		    }
		    finally {
		      em.close();
		    }
		    return logIn;
		  }   
		  
		  
		  @SuppressWarnings("unchecked")
		public List<LogIn> retrieveAccounts() {
			  
		    EntityManager em = EMF.get().createEntityManager();
		    List<LogIn> list = null;
		    
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
		   
		  public LogIn updateLogIn(LogIn logIn) {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    LogIn logIn2 = null;
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
		  
		  
		  public void deleteAccount(LogIn logIn) {

			  
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
