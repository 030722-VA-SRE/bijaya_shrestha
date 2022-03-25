package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Boba;
import com.revature.util.ConnectionUtil;

public class BobaPostgres implements BobaDao {

	@Override
	public Boba getBobaById(int id) {
		String sql = " select * from boba where id = ?;";
		Boba boba = null; // initialize the boba 
		
		try (Connection c = ConnectionUtil.getConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				boba = new Boba();
				boba.setId(rs.getInt("id"));
				boba.setFlavor(rs.getString("flavor_name"));
				boba.setPrice(rs.getInt("price_"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boba;
	}

	
	@Override
	public Boba getBobaByName(String name) {
		String sql = " select * from boba where flavor_name = ?;";
		Boba boba = null;
		
		try (Connection c = ConnectionUtil.getConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,name);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				boba = new Boba();
				boba.setId(rs.getInt("id"));
				boba.setFlavor(rs.getString("flavor_name"));
				boba.setPrice(rs.getInt("price_"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return boba;
	}
	


}
