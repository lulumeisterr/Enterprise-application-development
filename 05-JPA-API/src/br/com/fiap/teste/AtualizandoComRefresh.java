package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Funcionario;

public class AtualizandoComRefresh {

	public static void main(String[] args) {
		
		/*
		 * O metodo refresh Atualiza do java para o banco de dados
		 * 
		 */
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Funcionario f = em.find(Funcionario.class, 1);
		
		
		//Exibir o salario
		System.out.println(f.getVl_salario());
				
		//Atualizar
		f.setVl_salario(3000);
					
		//Atualizando funcionario
		em.refresh(f);
		
		//Exibir salario atual
		f.getVl_salario();
		
		em.getTransaction().begin();
		
		
		em.close();
		fabrica.close();
	}
	
}
