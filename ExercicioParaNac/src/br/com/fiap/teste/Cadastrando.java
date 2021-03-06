package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.categoriaEnum.Categoria;
import br.com.fiap.categoriaEnum.Posicao;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.genericDAOFilha.TimeDAOimpl;
import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastrando {

	public static void main(String[] args) {
		
		EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fa.createEntityManager();
	
		
		// Inserindo os DAOS
		TimeDAO tDAO = new TimeDAOimpl(em);
		
	
		//Preenchendo objTime e tecnico
		Time t = new Time("TURN OFF" , Categoria.PRINCIPAL , 
				 new Tecnico("LUCAS", 1000));
	
		List<Jogador> jogadores = new ArrayList<>();
		
		//Preenchendo jogador
		jogadores.add(new Jogador("Lucas" , 58 , Posicao.LATERAL, t));
		t.setJogadores(jogadores); //Adicionando jogadores dentro da lista de time
		
	
		//Preenchendo Campeonato
		List<Campeonato> campeonatos = new ArrayList<>();
		campeonatos.add(new Campeonato("Brasileirao"));
		t.setCamp(campeonatos); // Prenchendo um campeonato dentro de um time
		
		
		//Rodando a aplica��o
		try{
	
			tDAO.Inserir(t);
			tDAO.commit();
			System.out.println("Cadastrado!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		em.close();
		fa.close();
		
	}

}
