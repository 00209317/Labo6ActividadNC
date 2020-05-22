package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Computadora;

public interface ComputadoraService {

	public List<Computadora>findAll() throws DataAccessException;
	
	public Computadora findOne(Integer code) throws DataAccessException;
	
}
