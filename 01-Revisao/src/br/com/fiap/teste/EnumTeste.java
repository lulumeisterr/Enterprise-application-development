package br.com.fiap.teste;

import br.com.fiap.bean.Estado;

public class EnumTeste {
	
	public static void main(String[] args) {
		
		Estado uf = Estado.SP;
		
		if(uf.compareTo(Estado.SP) == 0){
			System.out.println("Voc� � paulista");
		}else{
			System.out.println("Voc� n�o � paulista");
		}
		
	}

}
