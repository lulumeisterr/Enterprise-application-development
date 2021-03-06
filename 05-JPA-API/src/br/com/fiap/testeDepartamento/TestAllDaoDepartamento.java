package br.com.fiap.testeDepartamento;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Departamento;
import br.com.fiap.dao.impl.DepartamentoDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.DepartamentoNaoEncontradoException;
import br.com.fiap.jpa.dao.DepartamentoDAO;

public class TestAllDaoDepartamento {

	public static void main(String[] args) {
	
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		DepartamentoDAO dao = new DepartamentoDAOImpl(em);
		
		
		Departamento d = new Departamento("MC DIGUINHO");

		//Cadastrar
		
		try{
		dao.Cadastrar(d);
		dao.commit();
		System.out.println("SUCESSO");
		}catch(CommitException e){
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Departamento depBusca = dao.buscar(d.getCodigo());
		System.out.println(depBusca.getNome());
		
		//Atualizar
		
		try {
			
			depBusca.setNome("RH");
			dao.Atualizar(depBusca);
			dao.commit();
			System.out.println("Atualizado");
			
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		
		//Remover
//		try{
//			
//		dao.Excluir(depBusca.getCodigo());
//		dao.commit();
//		System.out.println("Removido");
//		}catch(Exception e ){
//		System.err.println(e.getMessage());
//		}
		
		em.close();
		fabrica.close();
	}

}
