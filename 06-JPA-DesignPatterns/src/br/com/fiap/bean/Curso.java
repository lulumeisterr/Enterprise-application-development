package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso" , sequenceName = "SQ_TB_CURSO" , allocationSize=1)
public class Curso {
	
	@Id
	@Column(name ="cd_curso" , length=50 , nullable = false)
	@GeneratedValue(generator="curso" , strategy=GenerationType.SEQUENCE)
	
	private int codigo;
	
	@Column(name="nm_curso" , nullable = false , length=255)
	private String nome;
	
	@Column(name="qt_cargaHoraria" , nullable = false)
	private int cargaHoraria;

	public Curso(){
		
	}

	public Curso(int codigo, String nome, int cargaHoraria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
	

}
