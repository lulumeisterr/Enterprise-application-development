package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Curso;
import br.com.fiap.jpa.DAOtwo.CursoDAO;

public class CursoDAOimpl extends GenericDAOImpl<Curso, Integer> implements CursoDAO{

	public CursoDAOimpl(EntityManager em) {
		super(em);
		
	}

}
