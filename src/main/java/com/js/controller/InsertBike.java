package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BikeCRUD;

import com.js.dto.Bike;
@WebServlet(value="/prajwal")
public class InsertBike extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bike b = new Bike();
		b.setBike_no(Integer.parseInt(req.getParameter("id")));
		b.setBike_name(req.getParameter("bikename"));
		b.setOwner_name(req.getParameter("ownername"));
		
		BikeCRUD bc = new BikeCRUD();
		int res=bc.insertBike(b);
		if(res>0) {
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "BIKE ON THE ROAD");
			rd.forward(req, resp);
			
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", " SHOWROOM ITSELF  ");
			rd.forward(req, resp);
			
		}
	}

}
