package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_FORNECEDOR")
@SequenceGenerator(name = "fornecedor" , sequenceName = "SQ_T_FORNECEDOR" , allocationSize = 1)
public class Fornecedor {

	
	@Id
	@GeneratedValue(generator = "fornecedor" , strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "ds_nome" , nullable = false)
	private String nome;
	@Column(name = "ds_fone" , nullable = false , length = 11)
	private String telefone;
	
	@ManyToMany(mappedBy="listafornece") //Nome do atributo na outra classe
	List<Produto> listaProdutos;
	
	public Fornecedor (){
		
	}
	
	public Fornecedor(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
