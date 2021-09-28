package com.nagarro.data_store;

import java.util.*;
import com.nagarro.product_details.*;

@SuppressWarnings("all")
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

}
