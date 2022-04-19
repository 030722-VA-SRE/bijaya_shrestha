package com.revature.daos;

import java.util.List;

import com.revature.models.Boba;

public interface BobaDao {
	//method for adding item to the database
	public int addboba(Boba add);
	public Boba getBobaById(int id);
	public Boba getBobaByName(String name);
	//method for listing all bobas in arraylist 
	public List<Boba> getAllBoba();
	
	public boolean updateBoba(Boba updateBoba);
	public boolean deleteBoba(int id);
} 
