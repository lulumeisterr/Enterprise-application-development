package br.com.fiap.ImplementacaoDAO;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;


public class GenericDAOFather<Tabela , Chave> implements GenericDAO<Tabela, Chave>{

	
	/*
	 * DAO QUE SERVE PARA QUALQUER CLASSE
	   Onde voc� passa por parametro (<Tabela,Chave) essa chave � a onde voc� deseja fazer a busca
	 */
	
	
	/*
	 *  Os m�todos de neg�cio espec�ficos da entidade devem ser implementados na
		classe DAO filha e n�o na DAO gen�rica!
	 */
	
	private EntityManager em;
	
	//Pegar a tabela em tempo de excecu��o
	@SuppressWarnings("unchecked")
	private Class<Tabela> clazz = (Class<Tabela>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];
	
	public GenericDAOFather(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void Inserir(Tabela tabela) {
		em.persist(tabela);
	}

	@Override
	public Tabela Buscar(Chave codigo) {
		return em.find(clazz, codigo);
	}

	@Override
	public void Excluir(Chave codigo) {
		Tabela tabela = Buscar(codigo);
		if(tabela == null){
			try{
				throw new Exception("Registro n�o encontrado");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Atualizar(Tabela tabela) {
		em.merge(tabela);
	}

	@Override
	public void commit() throws Exception {
	
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			
			throw new Exception("Erro ao realizar o commit");
		}
		
	}

	
}
