package com.nagarro.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.nagarro.csv_handler.CsvProcessor;
import com.nagarro.data_store.DataStore;
import com.nagarro.input_handler.InputHandler;
import com.nagarro.output_handler.OutputHandler;
import com.nagarro.product_details.ProductDetails;

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
