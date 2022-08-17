package com.ty.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Brand;
import com.ty.dto.Product;

public class TestUpdateProduct {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Brand samsung = manager.find(Brand.class,1);
		
		if(samsung!=null)
		{
//			List<Product> pro = samsung.getProduct();
			
			Product p1 = new Product();
			p1.setName("Galaxy Tab");
			p1.setType("Tablet");
			p1.setBrand(samsung);

			Product p2 = new Product();
			p2.setName("Smart Clock");
			p2.setType("Smart Watch");
			p2.setBrand(samsung);
//			pro.add(p2);
//			pro.add(p1);
			
//			samsung.setProduct(pro);
			transaction.begin();
			manager.persist(samsung);
			manager.persist(p1);
			manager.persist(p2);
			transaction.commit();
		}
		else {
			System.out.println("Brand not Found!!!");
		}
		
		
		
	}

}
