package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;



import com.deevo.java.server.EMF;
import com.deevo.java.share.Persona;
import com.deevo.java.share.Persona;

public class Personadao {

	
	
	public boolean existeAula(Persona persona) {
			
			EntityManager em = EMF.get().createEntityManager();
			Persona persona2= null;
		    try {
		      persona2 = em.find(Persona.class, persona.getPerDir());
		    }
		    finally {
		      em.close();
		    }
		    if(persona2 == null) return false;
		    
		    return true;
				  }
	
	public void createPersona(Persona persona) throws EntityExistsException , Throwable {
		
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		 try {
			       tx.begin();
			       em.persist(persona);
			       tx.commit();
			     }
		 catch ( EntityExistsException e){
			 throw new EntityExistsException();
		 }catch(RollbackException e1){
			 throw new RollbackException();
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

		  public Persona retrievePersona(String per_dni) throws  Throwable{

			EntityManager em = EMF.get().createEntityManager();

		    Persona persona= null;
		    try {
		      persona = em.find(Persona.class, per_dni);
		    } catch (Throwable t) {
			       throw t;
		    }
		    finally {
		      em.close();
		    }
		    return persona;
		  }   
		  
		  
		  @SuppressWarnings("unchecked")
		public List<Persona> retrieveAccounts() throws  Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();
		    List<Persona> list = null;
		    
		    try {
		    	String qery = "SELECT x FROM PadreFamilia x ";
	            list= em.createQuery(qery).getResultList();
	          //  list = q.getResultList();
		    }  catch (Throwable t) {
			       throw t;
		    }
		    finally {
		      em.close();
		    }
		    return list;
		  }
		   
		  public Persona updatePersona(Persona persona) throws  Throwable {
			  
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
		      throw t;
		    }
		    finally {
		      em.close();
		    }
		    return persona2;
		  }
		  
		  
		  public void deleteAccount(Persona persona) throws  Throwable {
			  
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
		      throw t;
		    }
		    finally {
		      em.close();
		    }
		  }

}
