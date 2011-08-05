package com.samplee;


import java.util.HashMap;
import java.util.Map;


public class SampleeFacade {
	private Map<Integer, SampleModel>  modelContainer;
	public SampleeFacade() {
		modelContainer = new HashMap<Integer, SampleModel>();
	}
	public String createSimpleString(String arg) {
		return new String(arg);
	}
	
	public void insertSampleModel(String name) {
		SampleModel model = new SampleModel();
		model.setName(name);	
		modelContainer.put(model.getId(), model);
	}
	
	public SampleModel getSampleModel(Integer id) {
			return modelContainer.get(id);
	}
	
	public void deleteSampleModel(Integer id) {
		modelContainer.remove(id);
	}
	
	public void updateSampleModel(Integer id, final String name) {
		SampleModel model = modelContainer.get(id);
		model.setName(name);
	}
	
}