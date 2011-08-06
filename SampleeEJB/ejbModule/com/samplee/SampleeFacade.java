package com.samplee;


import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SampleeFacade {

	@EJB
	private SampleModelDao sampleModelDao;
	
	public void insertSampleModel(SampleModel model) {
		sampleModelDao.insertSampleModel(model);
	}
	
	public SampleModel getSampleModel(Integer id) {
		return sampleModelDao.getSampleModel(id);
	}
	
	public void deleteSampleModel(Integer id) {
		sampleModelDao.deleteSampleModel(id);
	}
	
	public void updateSampleModel(SampleModel model) {
		sampleModelDao.updateSampleModel(model);
	}
	
	
}