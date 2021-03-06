package br.com.fiap.teste.veiculo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.implVeiculoDAO.implVeiculo;



public class VeiculoTeste{

	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);

		EntityManagerFactory f = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = f.createEntityManager();

		VeiculoDAO vDAO = new implVeiculo(em);

		Veiculo ve = new Veiculo("XXTN3L4S" , 
				"Vermelho" , 
				new GregorianCalendar(2004 , Calendar.YEAR , Calendar.NOVEMBER));

		System.out.println("1 - Cadastrar");
		System.out.println("2 - Buscar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Excluir");
		int ler = entrada.nextInt();

		switch (ler) {
		case 1:
			try{
				vDAO.gravar(ve);
				vDAO.commit();
				System.out.println("Cadastrado");
			}catch(Exception e){
				System.err.println(e.getMessage());
			}

			break;

		case 2:
			Veiculo buscarVe = vDAO.Buscar(ve.getCodigo());
			System.out.println(buscarVe.getCodigo());
			break;

		case 3:
			try{
				Veiculo buscarVeAtt = vDAO.Buscar(ve.getCodigo());

				buscarVeAtt.setCor("Rosa");
				buscarVeAtt.setAno(new GregorianCalendar(2017 , Calendar.YEAR , Calendar.FEBRUARY));

				vDAO.Atualizar(buscarVeAtt);
				vDAO.commit();
				System.out.println("Atualizado");

			}catch(Exception e){
				System.err.println(e.getMessage());
			}
			break;

		case 4:
			try{

				vDAO.Apagar(1);
				vDAO.commit();
				System.out.println("Removido");

			}catch(Exception e){
				System.err.println(e.getMessage());

			}
			break;

		default:
			System.out.println("Op��o invalida");
			break;
		}
		
		em.close();
		f.close();
	}


}
