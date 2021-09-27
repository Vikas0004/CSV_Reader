package com.nagarro.data_store;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.nagarro.constants.Constants;
import com.nagarro.product_details.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class DataStore 
{
	/*
	 * Instance of Singleton Class
	 */
	private static DataStore singletonInstance;
	
	Map<String, Set<ProductDetails>> dataList = new HashMap<String, Set<ProductDetails>>();
	public List<ProductDetails> list = new LinkedList<>();

	
	public static synchronized DataStore getInstance() {
		if (null == singletonInstance) {
			singletonInstance = new DataStore();
		}
		return singletonInstance;
	}
	
	public void insertCsvFileData(String filename, Set<ProductDetails> details){
		if(filename!=null && details!= null){
			dataList.put(filename, details);
			for(ProductDetails p : details) {
				this.list.add(p);
			}
		}

	}
	
	
//	public void getList() {
//			
//		System.out.println("rtuoposaklkjhfds");
//		System.out.println(list.size());
//		for(ProductDetails p:list) {
//			System.out.println(p.toString());
//		}
//	}
	
}
