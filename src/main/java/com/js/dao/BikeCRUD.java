
package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Bike;

public class BikeCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/bike_showroom?user=root&password=Abc@123";
	static Connection c;

	public int insertBike(Bike b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			// dynamic method
			PreparedStatement ps = c.prepareStatement("insert into bike values(?,?,?)");
			ps.setInt(1, b.getBike_no());
			ps.setString(2, b.getBike_name());
			ps.setString(3, b.getOwner_name());

			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteBikebyNo(int no) {

		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("delete from bike where bike_no=?");
			ps.setInt(1, no);

			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int UpdateBikebyNO(int no, Bike name) {

		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("update bike set bike_name=?,owner_name=?where bike_no=?");
			ps.setString(1, name.getBike_name());
			ps.setString(2, name.getOwner_name());
			ps.setInt(3, no);

			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Bike getBikeByNo(int id_number) {
		Bike b = null;
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from bike where bike_id=?");
			ps.setInt(1, id_number);
			ResultSet rs = ps.executeQuery(); // result database table takes controller to id.
			if (rs.next()) {
				b = new Bike();
				b.setBike_no(rs.getInt(1));
				b.setBike_name(rs.getString(2));
				b.setOwner_name(rs.getString(3));

				return b;
			} else {
				return b;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;

	}

	public ArrayList<Bike> GetAllBikes() {
		ArrayList<Bike> allbike = new ArrayList<>();
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from bike");
			ResultSet RS = ps.executeQuery();
			while (RS.next()) {
				Bike B = new Bike();
				B.setBike_no(RS.getInt(1));
				B.setBike_name(RS.getString(2));
				B.setOwner_name(RS.getString(3));

				allbike.add(B);
			}
			return allbike;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
