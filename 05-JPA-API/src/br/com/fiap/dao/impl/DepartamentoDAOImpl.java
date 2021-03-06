package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Departamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.DepartamentoNaoEncontradoException;
import br.com.fiap.jpa.dao.DepartamentoDAO;

public class DepartamentoDAOImpl implements DepartamentoDAO {

	private EntityManager em;


	public DepartamentoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void Cadastrar(Departamento departamento) {
		em.persist(departamento);
	}


	@Override
	public Departamento buscar(int codigo) {
		return em.find(Departamento.class, codigo);
	}

	@Override
	public void Atualizar(Departamento departamento) {
		em.merge(departamento);
	}

	@Override
	public void Excluir(int codigo) throws DepartamentoNaoEncontradoException {
		Departamento d = buscar(codigo);
		
		if(d ==  null){
			try {
				throw new Exception("Funcionario inexistente");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		em.remove(d);
	}

	@Override
	public void commit() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();

		}catch(Exception e){
			if(em.getTransaction().isActive()){
			   em.getTransaction().rollback();
				
			}
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
			
		}
	}

}
