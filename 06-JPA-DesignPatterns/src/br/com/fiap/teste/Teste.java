package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.bean.Aluno;
import br.com.fiap.dao.impl.AlunoDAOimpl;
import br.com.fiap.jpa.DAOtwo.AlunoDAO;
import br.com.fiap.jpa.excecao.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

				AlunoDAO alunoDAO = new AlunoDAOimpl(em);

				//Cadastrar
				
				Aluno alu = new Aluno("76583", "Lucas" , new GregorianCalendar(1998 , Calendar.FEBRUARY , 27));
				
				try{
					
				alunoDAO.gravar(alu);
				alunoDAO.commit();
				System.out.println("Cadastrado");
				}catch(CommitException e){
					System.err.println(e.getMessage());
				}
				
				//Buscar
				
				Aluno busca = alunoDAO.buscar("76583");

				//Atualizar

				try{
					
				busca.setNome("JOAO");
				alunoDAO.atualizar(busca);
				
				alunoDAO.commit();
				System.out.println("Atualizado");
				}catch(CommitException e){
					System.err.println(e.getMessage());
				}
				
				//Remover
				
				try {
					
					alunoDAO.excluir("76583");
					alunoDAO.commit();
					System.out.println("Removido");
					
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

}
