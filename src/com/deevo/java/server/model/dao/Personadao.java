package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;



import com.deevo.java.server.EMF;
import com.deevo.java.share.Persona;

public class Personadao {

	
	public void createPersona(Persona persona) throws EntityExistsException , Throwable {
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		 try {
			       tx.begin();
			       em.persist(persona);
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

		  public Persona retrievePersona(String per_dni) {

			EntityManager em = EMF.get().createEntityManager();

		    Persona persona= null;
		    try {
		      persona = em.find(Persona.class, per_dni);
		    }
		    finally {
		      em.close();
		    }
		    return persona;
		  }   
		  
		  
		  @SuppressWarnings("unchecked")
		public List<Persona> retrieveAccounts() {
			  
		    EntityManager em = EMF.get().createEntityManager();
		    List<Persona> list = null;
		    
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
		   
		  public Persona updatePersona(Persona persona) {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Persona persona2 = null;
		    try {
		      tx.begin();
		      persona2 = em.merge(persona);
		      tx.commit();
		    }
		    catch (Throwable t) {
		      t.printStackTrace();
		      tx.rollback();
		    }
		    finally {
		      em.close();
		    }
		    return persona2;
		  }
		  
		  
		  public void deleteAccount(Persona persona) {
			  
		  EntityManager em = EMF.get().createEntityManager();
		  EntityTransaction tx = em.getTransaction();
		    
		    try {
		      tx.begin();
		      em.remove(em.merge(persona));
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
