package com.samplee;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class SampleModelDao {
	
	private Map<Integer, SampleModel> modelContainer;
	@PersistenceContext
	private EntityManager manager;
	
	public SampleModelDao() {
		modelContainer = new HashMap<Integer, SampleModel>();
	}
	
	public void insertSampleModel(SampleModel model) {
		modelContainer.put(model.getId(), model);
		manager.persist(model);
	}
	
	public SampleModel getSampleModel(Integer id) {
		return modelContainer.get(id);
	}
	
	public void deleteSampleModel(Integer id) {
		modelContainer.remove(id);
	}
	
	public void updateSampleModel(SampleModel model) {
		SampleModel removed = modelContainer.remove(model.getId());
		modelContainer.put(model.getId(), model);		
	}
}
