package com.nagarro.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.nagarro.csv_handler.CsvProcessor;
import com.nagarro.input_handler.InputHandler;
import com.nagarro.output_handler.OutputHandler;

public class Main {
	public static void main(String[] args) throws IOException {
	
			CsvProcessor launcher = new CsvProcessor();
			launcher.initiateThread();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			String ch;
			while (true) {
				
				InputHandler inputHandler = new InputHandler();
				inputHandler.getUserInput();
				OutputHandler outputHandler = new OutputHandler(inputHandler.getInputDetails());
				outputHandler.showOutput();
	            System.out.println("Do you want to continue (y/n) :");

				ch = br.readLine();
				if(ch.equalsIgnoreCase("n") || ch.equalsIgnoreCase("no")) {
	               
	               launcher.stopThread();
	               break;
	            }
			}
			br.close();

	}
	
	
}
