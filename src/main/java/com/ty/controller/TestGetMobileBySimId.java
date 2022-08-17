package com.ty.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestGetMobileBySimId {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sim Id : ");
		int id = sc.nextInt();
		Sim s = manager.find(Sim.class, id);
		if (s != null) {
			System.out.println(s.getId());
			System.out.println(s.getProvider());
			System.out.println(s.getImrc());

			Mobile m = s.getMobile();
			System.out.println("Mobile Details");
			System.out.println(m.getId());
			System.out.println(m.getName());
			System.out.println(m.getCost());
		}
		sc.close();
	}

}
