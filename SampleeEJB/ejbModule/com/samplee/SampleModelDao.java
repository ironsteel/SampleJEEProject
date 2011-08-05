package com.samplee;

import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.NotFoundException;

public class SampleModelDao {
	private Map<Integer, SampleModel>  modelContainer;
	public SampleModelDao() {
		modelContainer = new HashMap<Integer, SampleModel>();
	}
	
	public void insertSampleModel(SampleModel model) {
		modelContainer.put(model.getId(), model);
	}
	
	public SampleModel getSampleModel(Integer id) {
		
		if(modelContainer.isEmpty())
			throw new NotFoundException();
		
		return modelContainer.get(id);
	}
	
	public void deleteSampleModel(Integer id) {
		if(modelContainer.isEmpty()) {
			throw new NotFoundException();
		}
		modelContainer.remove(id);
	}
	
	public void updateSampleModel(SampleModel model) {
		SampleModel removed = modelContainer.remove(model.getId());
		if(removed == null) {
			throw new NotFoundException();
		}
		modelContainer.put(model.getId(), model);		
	}
}
