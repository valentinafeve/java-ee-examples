package com.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.Product;

/**
 * Session Bean implementation class Catalog
 */
@Stateful
@LocalBean
public class Catalog implements CatalogRemote, CatalogLocal {

	private HashMap<Integer, List<Product>> cache = new HashMap<Integer, List<Product>>();
	
	@PersistenceContext(unitName = "test", type = PersistenceContextType.EXTENDED)
	EntityManager em;
	
	/**
     * Default constructor. 
     */
    public Catalog() {
    	
    }
    
    @Override
	public List<Product> getCatalog(int page) {
    	
    	final int PRODUCTS_BY_PAGE = 2;
    	final int PAGES_IN_CACHE = 5;
    	
    	if ( cache.containsKey(page) ) {
    		System.out.println("Getting from cache");
    		return cache.get(page);
    	}
   
    	System.out.println("Getting from database");
    	int limit_a = page-1;
    	int limit_b = page+PRODUCTS_BY_PAGE*PAGES_IN_CACHE-1;
    	
		String query = "SELECT c FROM Product c WHERE c.id IS NOT NULL";
		
		Query tq = em.createNativeQuery(query,  Product.class).setFirstResult(limit_a).setMaxResults(limit_b);
		List<Product> products = null;
		int cont = limit_a;
		try {
			products = tq.getResultList();
			if( products.isEmpty()) {
				System.out.println("There are no products in the database.");
				return new ArrayList<Product>();
			}
			for (Product product : products) {
				List<Product> temp = null;
				int page_temp = cont/PRODUCTS_BY_PAGE+1;
				if ( cache.containsKey(page_temp) ) {
					temp = cache.get(page_temp);
					temp.add(product);
		    	}
				else {
					temp = new ArrayList<Product>();
					temp.add(product);
				}
				cache.put( page_temp , temp);
				cont++;
			}
			System.out.println(products.size()+" products readed from database.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cache.get(page);
	}

}
