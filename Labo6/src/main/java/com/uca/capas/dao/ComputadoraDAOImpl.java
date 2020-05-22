package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Computadora;

public class ComputadoraDAOImpl implements ComputadoraDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Computadora> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.computadora");
		Query query = entityManager.createNativeQuery(sb.toString(), Computadora.class);
		List<Computadora>resulset=query.getResultList();
		return resulset;
	}

	@Override
	public Computadora findOne(Integer code) throws DataAccessException {
		Computadora computadora = entityManager.find(Computadora.class, code);
		return computadora;
	}

}
