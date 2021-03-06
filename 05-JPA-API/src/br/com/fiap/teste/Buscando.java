package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Funcionario;

public class Buscando {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		
		em.getTransaction().begin();
		
		//Classe e ID
		Funcionario f = em.find(Funcionario.class, 1);
		
		System.out.println(f.getNm_funcionario());
		System.out.println(f.getVl_salario());
		
		em.close();
		fabrica.close();
		
	}
}
