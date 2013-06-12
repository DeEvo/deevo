package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.TestTipo;


public class TestTipoDao {

	
		public boolean existeTestTipo(TestTipo testtipo) {
				
				EntityManager em = EMF.get().createEntityManager();
				TestTipo testtipo2= null;
			    try {
			      testtipo2 = em.find(TestTipo.class, testtipo.getTestTipoCod());
			    }
			    finally {
			      em.close();
			    }
			    if(testtipo2 == null) return false;
			    
			    return true;
				}
				


		public void createTestTipo(TestTipo testtipo) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(testtipo);
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

	  public TestTipo retrieveTestTipo(TestTipo testtipo)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    TestTipo testtipo2= null;
	    try {
	      testtipo2 = em.find(TestTipo.class, testtipo.getTestTipoCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return testtipo2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<TestTipo> retrieveTestTipos() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<TestTipo> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM TestTipo x ";
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
	   
		  public TestTipo updateTestTipo(TestTipo testtipo)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    TestTipo testtipo2 = null;
		    try {
		     	tx.begin();
		     	testtipo2 = em.merge(testtipo);
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
		    return testtipo2;
		  }


}
