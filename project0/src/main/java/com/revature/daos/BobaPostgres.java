package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Boba;
import com.revature.util.ConnectionUtil;

public class BobaPostgres implements BobaDao{
	
  // this method will put the items(boba) in arraylist from the database.
	
	@Override
	public List<Boba> getAllBoba() {
		String sql = "select * from Boba;";
		List<Boba> bobas = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection()){
			Statement s = c.createStatement();//statement is an interface
			ResultSet rs = s.executeQuery(sql); // object rs will save the sql using resultset interface.
			
			while (rs.next()) {
				Boba newboba= new Boba();
				
				newboba.setId(rs.getInt("id"));
				newboba.setFlavor(rs.getString("flavor_name"));
				newboba.setPrice(rs.getInt("price_"));
				
				bobas.add(newboba);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bobas ;
	}
	
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

	//overriding method with logic
	@Override
	public Boba getBobaByName(String name) {
		String sql = " select * from boba where flavor_name = ?;";
		//List<Boba> bobas = new ArrayList<>();
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

	//overriding the adding item method with simple inserting logic 
	public int addboba(Boba add) {
		int gen = -1;
		String sql = "insert into boba(boba,flavor_name, price) value (?,?,?) returning id;";
		
		try(Connection c = ConnectionUtil.getConnection()){
			
			PreparedStatement ps = c.prepareStatement(sql);
		
				ps.setString(1, add.getFlavor());
				ps.setInt(2, add.getPrice());	
				
				ResultSet rs = ps.executeQuery(); 
				
				if (rs.next()) {
					gen = rs.getInt("id");
									
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gen;
		
		
	}

	@Override
	public boolean updateBoba(Boba updateBoba) {
		String sql = "update boba set flavor_name = ?, price_ = ? where id = ?;";
		try(Connection c = ConnectionUtil.getConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, updateBoba.getId());
			ps.setString(2, updateBoba.getFlavor());
			ps.setInt(3, updateBoba.getPrice());
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean deleteBoba(int id) {
		String sql = "delete from boba where id = ?;";
		
		try(Connection c = ConnectionUtil.getConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return false;
		}

}
