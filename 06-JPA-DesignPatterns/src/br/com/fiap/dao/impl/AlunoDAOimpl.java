package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Aluno;
import br.com.fiap.jpa.DAOtwo.AlunoDAO;

public class AlunoDAOimpl extends GenericDAOImpl<Aluno, String> implements AlunoDAO{

	public AlunoDAOimpl(EntityManager em) {
		super(em);
	
		
	}

}
