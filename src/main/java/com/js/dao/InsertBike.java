package com.js.dao;

import com.js.dto.Bike;

public class InsertBike {
	
		public static void main(String[] args) {
			Bike b=new Bike();
			b.setBike_no(4);
			b.setBike_name("activa");
			b.setOwner_name("kimars");
			
			
			BikeCRUD bc = new BikeCRUD();
			int a=bc.insertBike(b);
			if(a>0) {
				System.out.println("bike insert ");
			}
			else {
				System.out.println("not inserted");
			}
		}

	}

