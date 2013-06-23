package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Alumno;
import com.deevo.java.shared.GradoSeccionPK;


public class AlumnoDao {

	
			public boolean existeAlumno(Alumno alumno) {
				
				EntityManager em = EMF.get().createEntityManager();
				Alumno alumno2= null;
			    try {
			      alumno2 = em.find(Alumno.class, alumno.getAluCod());
			    }
			    finally {
			      em.close();
			    }
			    if(alumno2 == null) return false;
			    
			    return true;
				}
				
		
		
		public Alumno createAlumno(Alumno alumno) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(alumno);
				       em.flush();
				       em.refresh(alumno);
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
			 return alumno;
			  }
		
			  public Alumno retrieveAlumno(Alumno alumno)  throws Throwable{
		
				EntityManager em = EMF.get().createEntityManager();
		
			    Alumno alumno2= null;
			    try {
			      alumno2 = em.find(Alumno.class, alumno.getAluCod());
			    }catch (Throwable t) {
				       throw t;
				     }
			    finally {
			      em.close();
			    }
			    return alumno2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Alumno> retrieveAlumnos() throws Throwable{
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Alumno> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Alumno x ";
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
			   
			  public Alumno updateAlumno(Alumno alumno)  throws Throwable {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Alumno alumno2 = null;
			    try {
			     	tx.begin();
			     	alumno2 = em.merge(alumno);
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
			    return alumno2;
			  }
			  
			  
			  public void deleteAlumno(Alumno alumno)  throws Throwable  {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alumno));
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
			public List<Alumno> retrieveAlumnosxperPat(String perPat) {
				  
				    EntityManager em = EMF.get().createEntityManager();	
				    List<Alumno> list = null;
				   
				    try {
				    	String qery = "SELECT x FROM Alumno x WHERE x.persona.perPat LIKE '%?1%'";
			            list= em.createQuery(qery).setParameter(1, perPat).getResultList();
			          //  list = q.getResultList();
				    }catch(Throwable t){
				    	t.printStackTrace();
			        } finally {
			            em.close();
			        }
			        return list;
				  }
			  
			  @SuppressWarnings("unchecked")
				public List<Alumno> retrieveAlumnosxperMat(String perMat) {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Alumno> list = null;
					   
					    try {
					    	String qery = "SELECT x FROM Alumno x WHERE x.persona.perMat LIKE '%?1%'";
				            list= em.createQuery(qery).setParameter(1, perMat).getResultList();
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Alumno> retrieveAlumnosxperNom(String perNom) {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Alumno> list = null;
					   
					    try {
					    	String qery = "SELECT x FROM Alumno x WHERE x.persona.perNom LIKE '%?1%'";
				            list= em.createQuery(qery).setParameter(1, perNom).getResultList();
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
				        } finally {
				            em.close();
				        }
				        return list;
					  }
			  
			  @SuppressWarnings("unchecked")
				public List<Alumno> retrieveAlumnosxSeccionGrado(GradoSeccionPK id, int codPer, int psiCod) {
					  
					    EntityManager em = EMF.get().createEntityManager();	
					    List<Alumno> list = null;
					   
					    try {
					    	String qery = "SELECT x.alumno1 FROM AlumnoAula x WHERE x.aula.gradoSeccion.id = ?1 AND x.aula.periodoAcademico1.codPer = ?2 AND x.aula.psicologo.psiCod = ?3";
				            list= em.createQuery(qery).setParameter(1, id).setParameter(2, codPer).setParameter(3, psiCod).getResultList();
				          //  list = q.getResultList();
					    }catch(Throwable t){
					    	t.printStackTrace();
				        } finally {
				            em.close();
				        }
				        return list;
					  }


}
