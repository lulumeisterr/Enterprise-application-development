package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class ContaCorrente_Teste {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar formatura = new GregorianCalendar(2018, Calendar.FEBRUARY, 02);

		ContaCorrente c1 = new ContaCorrente();

		List<ContaCorrente> lista = new ArrayList<>();
		
		c1.setAgencia(1);
		c1.setDataAbertura(formatura);
		c1.setNumero(02);
		c1.setSaldo(323);
		c1.setTipo(TipoConta.COMUM);
		
		lista.add(c1);
		
		for (ContaCorrente conta : lista) {
			System.out.println("Agencia : " + c1.getAgencia());
			System.out.println("Data abertura : " + c1.getDataAbertura());
			System.out.println("Saldo : " + c1.getSaldo());
			System.out.println("Tipo da conta : " + c1.getTipo());
			
			System.out.println("");
			
			//c1.depositar(1, -50);
			System.out.println("");
			c1.retirar(1, 100);
		}
		
	}

}
