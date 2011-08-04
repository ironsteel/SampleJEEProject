package com.samplee;

public class SampleeFacade {
	public String createSimpleString(String arg) {
		return new String(arg);
	}
	
	public SampleModel createSampleModel() {
		return new SampleModel();
	}	
}
