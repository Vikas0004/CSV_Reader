package com.nagarro.csv_handler;


public class CsvProcessor {
	
	CsvHandler csvFileHandler;
	Thread t1;
	public CsvProcessor() {
		this.csvFileHandler = new CsvHandler();
		this.t1 = new Thread(csvFileHandler);
	}

	public boolean flag = true;
	
	public void initiateThread() {
		
		t1.start();
	}
	public void stopThread() {
		csvFileHandler.stop();
	}
}
