package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	

	/*
	 *  Listando as cidades
	 */
	
	
	// In = a equals para compara��o
	
	
	@Override
	public List<Cidade> cityList() {
		// Criar a query
		
		
		/*
		 * TypedQuery permite trabalhar com o recurso Java generics;
		 
		 * TypedQuery verificam, no momento da cria��o, se o retorno realmente 
		 *  pode ser atribu�do para o tipo desejado, lan�ando uma exce��o se n�o for
		 */
		
		

											//Exibir por Nome da classe , e passar a Classe.class
		TypedQuery<Cidade> query = em.createQuery("from Cidade" , Cidade.class);
		// Executar a query
		return query.getResultList();
	}



	@Override
	public List<Cidade> BuscarPorMaiorNumeroHabitante(int numero) {
		
		//Criar a query
		TypedQuery<Cidade> queryCity = em.createQuery("from Cidade c where c.nrHabitantes > :n", Cidade.class);
		
		//Passar o parametro
		queryCity.setParameter("n", numero);
		
		//Executar
		return queryCity.getResultList();
	}





}
