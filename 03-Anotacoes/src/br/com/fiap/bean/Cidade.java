package br.com.fiap.bean;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Tabela;

@Tabela(nomeTabela="T_JAVA_ANNOTATION")
public class Cidade {

	@Coluna(nome="nm_cidade")
	private String nome;
	
	@Coluna(nome="ds_uf")
	private String uf;
	
	
	//02
	public String inserirSQL(Cidade c){
		return "SELECT * FROM ";
	}
	
	
	public Cidade(){
		super();
	}
	
	public Cidade(String nome, String uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
}
