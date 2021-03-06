package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.excecao.CommitException;
import br.com.fiap.jpa.excecao.RegistroNaoEncontrado;

public class GenericDAOImpl<Tabela , Chave> implements GenericDAO<Tabela, Chave> {

	
	private EntityManager em;
	
	//Pegar a tabela em tempo de excecu��o
	private Class<Tabela> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		
		//Recuperando a Classe    
		clazz = (Class<Tabela>) ((ParameterizedType) 
				
				                                 //Devolve os parametros da classe
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void gravar(Tabela tabela) {
		em.persist(tabela);
	}

	@Override
	public void excluir(Chave codigo) throws RegistroNaoEncontrado {
		
		Tabela tabela = buscar(codigo);
			if(tabela == null){
				try {
					throw new Exception("Registro n�o encontrado");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		em.remove(codigo);
	}

	@Override
	public void atualizar(Tabela tabela) {
		em.merge(tabela);
	}

	@Override
	public Tabela buscar(Chave codigo) {
	 return em.find(clazz, codigo);
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
