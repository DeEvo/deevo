package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.TestTipo;

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
		


		public void createTestTipo(TestTipo testtipo) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(testtipo);
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

			  public TestTipo retrieveTestTipo(TestTipo testtipo) {

				EntityManager em = EMF.get().createEntityManager();

			    TestTipo testtipo2= null;
			    try {
			      testtipo2 = em.find(TestTipo.class, testtipo.getTestTipoCod());
			    }
			    finally {
			      em.close();
			    }
			    return testtipo2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<TestTipo> retrieveTestTipos() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<TestTipo> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM TestTipo x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public TestTipo updateTestTipo(TestTipo testtipo) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return testtipo2;
			  }
			  
			  
			  public void deleteTestTipo(TestTipo testtipo) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(testtipo));
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
