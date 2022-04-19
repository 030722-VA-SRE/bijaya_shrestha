package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Boba;

public class BobaDTO {
	
	private int id;
	private String bobaName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBobaname() {
		return bobaName;
	}

	public void setBobaname(String bobaName) {
		this.bobaName = bobaName;
	}

	public BobaDTO() {
		super();
	}

	public BobaDTO(Boba boba) {
	}

	@Override
	public String toString() {
		return "BobaDTO [id=" + id + ", bobaName=" + bobaName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bobaName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BobaDTO other = (BobaDTO) obj;
		return Objects.equals(bobaName, other.bobaName) && id == other.id;
	}

	
}
