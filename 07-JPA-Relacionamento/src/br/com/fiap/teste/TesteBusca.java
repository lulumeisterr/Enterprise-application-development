package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.PedidoDAO_impl;
import br.com.fiap.jpa.DAOtwo.Pedido_DAO;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteBusca {
	
	public static void main(String[] args) {
	
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
			EntityManager em = fabrica.createEntityManager();
		
			Pedido_DAO pDAO = new PedidoDAO_impl(em);
		
		// Buscar o pedido
		

			Pedido p = pDAO.buscar(1);
	
		// Exibir a descri��o do pedido
		
			System.out.println(p.getDescricao());
		
		// Exibir o valor da nota fiscal
		
		//System.out.println(p.getNota().getValor());
			
			em.close();
			fabrica.close();
	}
	
}
