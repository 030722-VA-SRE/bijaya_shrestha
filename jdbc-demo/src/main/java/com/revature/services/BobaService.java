package com.revature.services;

import java.util.List;

import com.revature.daos.BobaDao;
import com.revature.daos.BobaPostgres;
import com.revature.models.Boba;

public class BobaService {
	private BobaDao ud;
	
	public BobaService() {
		ud = new BobaPostgres();
	}
	
	public Boba getById(int id) throws BobaNotFoundException {
		Boba boba = ud.getBobaById(id);
		if (boba == null) {
			throw new BobaNotFoundException();
	}
		return boba;
	}
	
	
	public Boba getByName(String name) throws BobaNotFoundException {
	Boba boba = ud.getBobaByName(name);
	if(boba ==null) {
		throw new BobaNotFoundException();
	}
	return boba;	
	}

	
	
}
