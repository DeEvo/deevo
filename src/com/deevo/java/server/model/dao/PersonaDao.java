package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;



import com.deevo.java.server.EMF;
import com.deevo.java.shared.Persona;


public class PersonaDao {

	
	
	public boolean existeAula(Persona persona) {
			
			EntityManager em = EMF.get().createEntityManager();
			Persona persona2= null;
		    try {
		      persona2 = em.find(Persona.class, persona.getPerDni());
		    }
		    finally {
		      em.close();
		    }
		    if(persona2 == null) return false;
		    else
		    return true;
				  }
	
	public Persona createPersona(Persona persona) throws EntityExistsException , Throwable {
		
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
		 return persona;
		  }

		  public Persona retrievePersona(Persona persona) throws  Throwable{

			EntityManager em = EMF.get().createEntityManager();

		    Persona persona2= new Persona();
		    try {
		      persona2 = em.find(Persona.class, persona.getPerDni());
		    } catch (Throwable t) {
			       throw t;
		    }
		    finally {
		      em.close();
		    }
		    return persona2;
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
		  
		
			@SuppressWarnings("unchecked")
			public List<Persona> retrievePersonasxperPat(String perPat) throws  Throwable  {
				  
				    EntityManager em = EMF.get().createEntityManager();	
				    List<Persona> list = null;
				   
				    try {
				    	String qery = "SELECT x FROM Persona x WHERE x.perPat LIKE :code ORDER BY x.perPat";
			            list= em.createQuery(qery).setParameter("code", "%" +perPat+ "%").getResultList();
				    }catch(Throwable t){
				    	t.printStackTrace();
				    	throw t;
			        } finally {
			            em.close();
			        }
			        return list;
				  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperMat(String perMat)  throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try {
					    	String qery = "SELECT x FROM Persona x WHERE x.perMat LIKE :code ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perMat+ "%").getResultList();
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperNom(String perNom) throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try { 
					    	String qery = "SELECT x FROM Persona x WHERE x.perNom LIKE :code ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perNom+ "%").getResultList();
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperNomxperMat(String perNom, String perMat) throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try { 
					    	String qery = "SELECT x FROM Persona x WHERE x.perNom LIKE :code AND x.perMat LIKE :busca" +
					    			" ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perNom+ "%").setParameter("busca", "%" +perMat+ "%").getResultList(); 
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperNomxperPat(String perNom, String perPat)  throws  Throwable {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try { 
					    	String qery = "SELECT x FROM Persona x WHERE x.perNom LIKE :code AND x.perPat LIKE :busca" +
					    			" ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perNom+ "%").setParameter("busca", "%" +perPat+ "%").getResultList(); 
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperMatxperPat(String perMat, String perPat)  throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try { 
					    	String qery = "SELECT x FROM Persona x WHERE x.perMat LIKE :code AND x.perPat LIKE :busca" +
					    			" ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perMat+ "%").setParameter("busca", "%" +perPat+ "%").getResultList(); 
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Persona> retrievePersonasxperMatxperPatXperNom(String perMat, String perPat,String perNom) throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try { 
					    	String qery = "SELECT x FROM Persona x WHERE x.perMat LIKE :code AND x.perPat LIKE :busca" +
					    			" AND x.perNom LIKE :final ORDER BY x.perPat";
				            list= em.createQuery(qery).setParameter("code", "%" +perMat+ "%").setParameter("busca", "%" +perPat+ "%").setParameter("final", "%" +perNom+ "%").getResultList(); 
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
					    	throw t;
				        } finally {
				            em.close();
				        }
				        return list;
					  }
}
