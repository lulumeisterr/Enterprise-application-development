package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Funcionario;

public class Atualizar {
	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
	
		Funcionario f = em.find(Funcionario.class, 1);
	
		//Para n�o perder as camadas , voc� usa o merge pois ele Atualiza � cadastra!
		//Merge atualiza do java para o banco
		
		//Refresh atualiza do banco pro java
		
		
		Funcionario f2 = new Funcionario(f.getNm_funcionario(), 
										 f.getDt_admissao(), 
										 f.getDt_nascimento(), 
										 1000, 
										 f.getFoto(), 
										 f.getDs_escolaridade());
										
										 f2.setCdfuncionario(f.getCdfuncionario());
										
										 //Atualizando funcionario
										 em.merge(f2);
										 
										 
		//Atualizando
		//f.setVl_salario(f.getVl_salario() + 500);
	
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
		
	}
}
