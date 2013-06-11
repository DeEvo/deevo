package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Usuario;


public class UsuarioDao {

	
		public boolean existeUsuario(Usuario usuario) {
				
				EntityManager em = EMF.get().createEntityManager();
				Usuario usuario2= null;
			    try {
			      usuario2 = em.find(Usuario.class, usuario);
			    }
			    finally {
			      em.close();
			    }
			    if(usuario2 == null) return false;
			    
			    return true;
				}
		


		public void createUsuario(Usuario usuario) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(usuario);
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

	  public Usuario retrieveUsuario(Usuario usuario)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Usuario usuario2= null;
	    try {
	      usuario2 = em.find(Usuario.class, usuario.getUsurCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return usuario2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Usuario> retrieveUsuarios() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Usuario> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Usuario x ";
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
	   
		  public Usuario updateUsuario(Usuario usuario)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Usuario usuario2 = null;
		    try {
		     	tx.begin();
		     	usuario2 = em.merge(usuario);
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
		    return usuario2;
		  }

}
