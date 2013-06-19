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

		    Persona persona2= null;
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
				    	String qery = "SELECT x FROM Persona x WHERE x.persona.perPat LIKE '%?1%' ORDER BY x.persona.perPat";
			            list= em.createQuery(qery).setParameter(1, perPat).getResultList();
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
				public List<Persona> retrievePersonasxperMat(String perMat)  throws  Throwable  {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Persona> list = null;
					   
					    try {
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perMat LIKE '%?1%' ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perMat).getResultList();
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
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perNom LIKE '%?1%' ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perNom).getResultList();
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
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perNom LIKE '%?1%' AND x.persona.perMat LIKE '%?2%'" +
					    			" ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perNom).setParameter(2, perMat).getResultList(); 
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
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perNom LIKE '%?1%' AND x.persona.perPat LIKE '%?2%'" +
					    			" ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perNom).setParameter(2, perPat).getResultList(); 
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
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perMat LIKE '%?1%' AND x.persona.perPat LIKE '%?2%'" +
					    			" ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perMat).setParameter(2, perPat).getResultList(); 
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
					    	String qery = "SELECT x FROM Persona x WHERE x.persona.perMat LIKE '%?1%' AND x.persona.perPat LIKE '%?2%'" +
					    			" AND x.persona.perNom LIKE '%?3%' ORDER BY x.persona.perPat";
				            list= em.createQuery(qery).setParameter(1, perMat).setParameter(2, perPat).setParameter(3, perNom).getResultList(); 
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
