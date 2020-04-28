package com.beans;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Product;

@Remote
public interface CatalogRemote {
	public List<Product> getCatalog( int page );
}
