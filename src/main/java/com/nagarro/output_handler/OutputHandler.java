package com.nagarro.output_handler;

import java.util.*;
import com.nagarro.constants.Constants;
import com.nagarro.data_store.DataStore;
import com.nagarro.product_details.ProductDetails;
import com.nagarro.service_class.ServiceClass;


@SuppressWarnings("all")
public class OutputHandler
{
	ProductDetails inputDetails;
	ServiceClass serviceClass;
	private int preferenceCase;
	List<ProductDetails> list;
	DataStore dataStore;
	List<ProductDetails> data;

    public OutputHandler(ProductDetails inputDetails) {
        this.dataStore = DataStore.getInstance();
        this.data = dataStore.list;
		this.inputDetails = inputDetails;
        this.serviceClass = new ServiceClass();
        this.list = serviceClass.getProducts(data,inputDetails.getColor(), inputDetails.getSize(), inputDetails.getGender());
        this.preferenceCase = inputDetails.getPreference();
        switch (preferenceCase) {
            case 1:
                serviceClass.sortByPrice(list);
                break;
            case 2:
                serviceClass.sortByRating(list);
                break;
            case 3:
                serviceClass.sortByPriceAndRating(list);
                break;
            default:
                serviceClass.sortByPriceAndRating(list);
        }

    }
	
	public void showOutput() {
		if(list.size() == 0 || list == null) {
			System.out.println(Constants.NOT_FOUND);
			return;
		}
        for(ProductDetails obj : list) {
            System.out.println(obj.toString());
        }
    }
}
