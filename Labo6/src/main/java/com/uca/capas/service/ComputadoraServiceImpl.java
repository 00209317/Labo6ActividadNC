package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.capas.dao.ComputadoraDAO;
import com.uca.capas.domain.Computadora;

public class ComputadoraServiceImpl implements ComputadoraService {
	
	@Autowired
	ComputadoraDAO estudianteDAO;

	@Override
	public List<Computadora> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findAll();
	}

	@Override
	public Computadora findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findOne(code);
	}

}
