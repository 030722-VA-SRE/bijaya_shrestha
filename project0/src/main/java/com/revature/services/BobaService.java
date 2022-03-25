
//service layer 	- Business logic
package com.revature.services;

import com.revature.daos.BobaDao;
import com.revature.daos.BobaPostgres;
import com.revature.models.Boba;
import java.util.List;

public class BobaService {
private BobaDao bd;
	
	public BobaService() {
		bd = new BobaPostgres();
	}
	
	// method to use a getAllBoba defined in Dao class in Service class
	public List<Boba> getAllBoba() {
		
		return bd.getAllBoba();
	}
	

	//method to sort out using id.
	public Boba getById(int id) throws BobaNotFoundException {
		Boba boba = bd.getBobaById(id);
		if (boba == null) {
			throw new BobaNotFoundException();
	}
		return boba;
	}
	
	//method for sorting the boba using name.
	public Boba getByName(String name) throws BobaNotFoundException {
	Boba boba = bd.getBobaByName(name);
	if(boba ==null) {
		throw new BobaNotFoundException();
	}
	return boba;	
	}
	//
	public boolean addboba(Boba newboba) {
	int newid = bd.addboba(newboba);
	if (newid != (-1)) {
		return true;
	}
	return false;
	}
	
	public boolean update(Boba updateBoba) {
	return bd.updateBoba(updateBoba);
	}
	
	public boolean deleteBoba(int id) {
		boolean del = bd.deleteBoba(id);
		return del;
		
	}
}
