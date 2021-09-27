package com.nagarro.service_class;

import java.util.*;

import com.nagarro.product_details.ProductDetails;
public class ServiceClass 
{
	
	public List<ProductDetails> getProducts(List<ProductDetails> list, String color, String size, String gender) {
		List<ProductDetails> ansList = new LinkedList<ProductDetails>();
		for(ProductDetails itr : list) {
			if(itr.getColor().toLowerCase().equals(color.toLowerCase())
        			&& itr.getSize().toLowerCase().equals(size.toLowerCase())
        			&& (itr.getGender().toLowerCase().equals(gender.toLowerCase()) || itr.getGender().toLowerCase().equals("u")))
					{
        		ansList.add(itr);
			}
			
		}
		return ansList;
	}
	
	
	public void sortByPriceAndRating(List<ProductDetails> people) {
		Comparator<ProductDetails> c = (p, o) ->
		Integer.compare(Integer.parseInt(p.getPrice()), Integer.parseInt(o.getPrice()));
		
		c = c.thenComparing((p, o) ->
		Double.compare(p.getRating(),o.getRating()));

		people.sort(c);
	}
	public void sortByPrice(List<ProductDetails> list) {
		Comparator<ProductDetails> c = (p, o) ->
		Integer.compare(Integer.parseInt(p.getPrice()), Integer.parseInt(o.getPrice()));

		list.sort(c);

	}

	public void sortByRating(List<ProductDetails> list) {
		Comparator<ProductDetails> c = (p, o) ->
				Double.compare(p.getRating(), o.getRating());

		list.sort(c);

	}

}
