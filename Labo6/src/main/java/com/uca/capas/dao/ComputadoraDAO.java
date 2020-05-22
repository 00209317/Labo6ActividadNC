package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Computadora;

@Repository
public interface ComputadoraDAO {

	public List<Computadora>findAll() throws DataAccessException;
	
	public Computadora findOne(Integer code) throws DataAccessException;

}
