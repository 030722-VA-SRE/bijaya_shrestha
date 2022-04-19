package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Boba;

@Repository
public interface BobaRepository extends JpaRepository<Boba,Integer> {

	public Boba findBobaById(int id);

	public List<Boba> findBobaByName(String name);

	public void deleteById();

	public Boba findAllById(int id);

}
