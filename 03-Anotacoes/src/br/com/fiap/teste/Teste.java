package br.com.fiap.teste;

import java.lang.reflect.Field;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Cidade;

public class Teste {
	
	public static void main(String[] args) {
		
		Cidade cidade = new Cidade("Bauro" , "SP");

		//Api Reflection
		
		//Recuperar o nome da classe
		System.out.println(cidade.getClass().getName());
		
		//Recuperar os atributos
		
		Field [] atributo = cidade.getClass().getDeclaredFields();
		for (Field field : atributo) {
			//Nome do atributo
			System.out.println(field.getName());
			//Recuperar a anota��o que est� no atributo
			Coluna anotacao = field.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
		}
		
		
		
	}

}
