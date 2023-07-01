package com.js.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BikeCRUD;
import com.js.dto.Bike;

@WebServlet(value = "/pmk")

public class ViewAllBikes extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BikeCRUD ob1 = new BikeCRUD();
		ArrayList<Bike> ob2 = ob1.GetAllBikes();
		if (ob2.isEmpty()) {
			RequestDispatcher ob3 = req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "NO BIKES AVAILABLE");
			ob3.forward(req, resp);
		} else {
			RequestDispatcher ob3 = req.getRequestDispatcher("viewall.jsp");
			req.setAttribute("name", ob2);
			ob3.forward(req, resp);
		}
	}

}
