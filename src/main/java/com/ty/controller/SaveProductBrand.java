package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Brand;
import com.ty.dto.Product;

public class SaveProductBrand {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand b = new Brand();
		b.setName("Samsung");
		b.setHeadquarter("USA");

		Product p1 = new Product();
		p1.setName("S22 Ultra");
		p1.setType("SmartPhone");
		p1.setBrand(b);

		Product p2 = new Product();
		p2.setName("Oled");
		p2.setType("TV");
		p2.setBrand(b);

		transaction.begin();
		manager.persist(p2);
		manager.persist(b);
		manager.persist(p1);

		transaction.commit();
		System.out.println("Done !!!");
	}

}
