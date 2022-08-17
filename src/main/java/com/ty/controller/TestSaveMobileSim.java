package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Pixel");
		mobile.setCost(63000);
		
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setImrc("AIR567");
		sim1.setMobile(mobile);
		
		Sim sim2 = new Sim();
		sim2.setProvider("Jio");
		sim2.setImrc("JIO997");
		sim2.setMobile(mobile);
		
		transcation.begin();
		manager.persist(mobile);
		manager.persist(sim1);
		manager.persist(sim2);
		transcation.commit();
 	}

}
