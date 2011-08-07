package com.samplee;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SampleeFacade {

	@EJB
	private SampleModelDao sampleModelDao;
	
	public void insertSampleModel(SampleModel model) {
		sampleModelDao.insertSampleModel(model);
	}
	
	public SampleModel getSampleModel(String name) {
		return sampleModelDao.getSampleModelByName(name);
	}
	
	public SampleModel getSampleModelByName(String name) {
		return sampleModelDao.getSampleModelByName(name);
	}
	
	public void deleteSampleModel(SampleModel model) {
		sampleModelDao.deleteSampleModel(model);
	}
	
	public void deleteSampleModelByName(String name) {
		sampleModelDao.deleteSampleModelByName(name);
	}
	
	public void updateSampleModel(SampleModel model) {
		sampleModelDao.updateSampleModel(model);
	}
	
	public void deleteAll() {
		sampleModelDao.deleteAll();
	}
	
	public List<SampleModel> getAll() {
		return sampleModelDao.getAll();
	}
	
	
}