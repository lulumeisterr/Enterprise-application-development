package br.com.fiap.teste.insercao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.bean.Autor;
import br.com.fiap.constantes.bean.tipoSexo;
import br.com.fiap.factory.JPAUtil;

public class Persistencia_Autor {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criarObjetoEstados();
		
		Autor at = new Autor();
		
		at.setNome("Lucas");
		at.setSobrenome("Rodrigues");
		at.setTipo(tipoSexo.MASCULINO);
		at.setData(Calendar.getInstance());
		
		em.getTransaction().begin();

		em.persist(at);
	
		em.getTransaction().commit();
		em.close();
		
	
	}

}
