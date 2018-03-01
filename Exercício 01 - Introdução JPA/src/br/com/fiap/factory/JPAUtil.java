package br.com.fiap.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	/*
	 * Gerenciador de entidades e estados de objetos
	 */
	
	
	//financias � o nome da persistence-unit , Para cada classe 
	private static EntityManagerFactory em = Persistence.createEntityManagerFactory("exercicio");
	
	
	public EntityManager criarObjetoEstados(){
		return em.createEntityManager();
		
 //O m�todo createEntityManagerFactory ir� gerar um EntityManagerFactory baseado nas configura��es do persistence.xml
		
		
	}
	
}
				