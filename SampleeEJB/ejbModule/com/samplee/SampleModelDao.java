package com.samplee;


import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.jersey.api.NotFoundException;


@Stateless
public class SampleModelDao {
	
	private static final Log log = LogFactory.getLog(SampleModelDao.class);
	
	
	
	@PersistenceContext
	private EntityManager manager;
	
	public SampleModelDao() {
	
	}
	
	public void insertSampleModel(SampleModel model) {
		manager.persist(model);
	}
	
	
	public SampleModel getSampleModelByName(String name) {
		final Query query = manager.createNamedQuery(SampleModel.GET_SAMPLEMODEL_BY_NAME);
		query.setParameter("name", name);
		try {
			return (SampleModel) query.getSingleResult();
		} catch (NoResultException nr) {
			log.error("No result returned");
			return null;
		} catch (NonUniqueResultException nu) {
			log.error("Result non unique");
			return null;
		}
	}
	
	public void deleteSampleModelByName(String name) {
		deleteSampleModel(getSampleModelByName(name));
	}
	
	
	public void deleteSampleModel(SampleModel model) {
		try {
			manager.remove(model);
		} catch (IllegalArgumentException iae) {
			log.debug("Model does not exists");
		}
	}
	
	public List<SampleModel> getAll() {
		final Query query = manager.createNamedQuery(SampleModel.GET_SAMPLEMODEL_ALL);
		
		List<SampleModel> all = (List<SampleModel> ) query.getResultList();
		
		return all;
	}
	
	public void deleteAll() {
		List<SampleModel> all = getAll();
		Iterator<SampleModel> it = all.iterator();
		
		while(it.hasNext()) {
			deleteSampleModel(it.next());
		}
	}
	
	public void updateSampleModel(SampleModel model) {
		manager.merge(model);
	}
	
}
