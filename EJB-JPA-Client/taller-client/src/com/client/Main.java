package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import com.beans.CatalogRemote;
import com.entities.Product;

public class Main {
 
   static BufferedReader brConsoleReader = null; 
   static Properties props;
   static InitialContext ctx;
   
   public static void main(String[] args) {
      getCatalog();
   }
   
   private static void getCatalog() {
 
      try {
    	  props = new Properties();
    	  props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    	  props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    	  props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    	  props.put("jboss.naming.client.ejb.context", true);
    	  
          try {
             ctx = new InitialContext(props);
             CatalogRemote bean = (CatalogRemote)ctx.lookup("ejb:taller-ear/taller-ejb/Catalog!com.beans.CatalogRemote?stateful");
             int page;
             
             page = 1;
             List<Product> products = bean.getCatalog(page);
             System.out.println("Page: "+page);
             for (Product product : products) {
				System.out.println("Id: "+product.getId());
             }
             
             page = 1;
             System.out.println("Page: "+page);
             products = bean.getCatalog(1);
             for (Product product : products) {
				System.out.println("Id: "+product.getId());
			}
             
             page = 2;
             System.out.println("Page: "+page);
             products = bean.getCatalog(2);
             for (Product product : products) {
				System.out.println("Id: "+product.getId());
			}
          } catch (NamingException ex) {
             ex.printStackTrace();
          }
          
         
      } catch (Exception e) {
    	  
         e.printStackTrace();
      }finally {
         try {
            if(brConsoleReader !=null) {
               brConsoleReader.close();
            }
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         }
      }
   }
}