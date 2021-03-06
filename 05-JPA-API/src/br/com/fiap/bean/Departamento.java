package br.com.fiap.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "T_DEPARTAMENTO")
@SequenceGenerator(name = "departamento" , sequenceName="SQ_T_DEPARTAMENTO" , allocationSize = 1)
public class Departamento implements Serializable{

	private static final long serialVersionUID = 3306294707921634198L;
	
	@GeneratedValue(generator="departamento" , strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "cd_codigo")
	private int codigo;
	@Column(name = "ds_nome" , length = 255 , nullable=false)
	private String nome;
	
	public Departamento(){
		
	}

	
	public Departamento(String nome) {
		super();
		this.nome = nome;
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
	
	
	
	
	

}
