package com.in28minutes.mockito.mockitodemo;

public class SomeBusinessImp {

	private DataService dataService;
	
	public SomeBusinessImp(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	int findTheGreatestFromAllData() {
		int[] data = dataService.retriveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for(int value : data) {
			if(value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}


