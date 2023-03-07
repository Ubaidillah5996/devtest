package com.muhammadubaidillah.devtest.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.muhammadubaidillah.devtest.model.Devtest;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DevtestRepository implements PanacheRepository<Devtest> {
	
	public Devtest findById(String id) {
		return find("id=?1", id).firstResult();
	}
	
	public List<Devtest> findByName(String name) {
		return find("lower(name) like ?1", name.trim().toLowerCase()).list();
	}
	
	public List<Devtest> findByNameAndPhone(String name, String phone) {
		return find("lower(name) like ?1 and phone =?2", name.trim().toLowerCase(), phone).list();
	}

	public List<Devtest> findByPhone(String phone) {
		return find("phone =?1", phone).list();
	}

}
