package br.com.fiap.dao.impl;
import javax.persistence.EntityManager;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EmptyFuncionarioException;
import br.com.fiap.jpa.dao.FuncionarioDAO;

public class FuncionarioDAOImpl implements FuncionarioDAO{

	private  EntityManager em;

	public FuncionarioDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void gravar(Funcionario f) {
		em.persist(f);
	}

	@Override
	public void apagar(int codigo)throws EmptyFuncionarioException{
		//Primeiro voc� busca depois remove
		Funcionario f = buscar(codigo);
		
		//Validar funcionario vazio
		if(f == null){
			throw new EmptyFuncionarioException("Funcionario Inexistente");
		}
		em.remove(f);
	}

	@Override
	public void atualizar(Funcionario f) {
		em.merge(f);
	}

	@Override
	public Funcionario buscar(int codigo) {
		return em.find(Funcionario.class, codigo);
	}

	@Override
	public void commit()throws CommitException{
		try{
		em.getTransaction().begin();
		em.getTransaction().commit();
		}catch(Exception e){
			
			if(em.getTransaction().isActive())
				
				em.getTransaction().rollback();
				e.printStackTrace();
				
				throw new CommitException("Erro ao realizar o commit");
				
			}
		}
	}

