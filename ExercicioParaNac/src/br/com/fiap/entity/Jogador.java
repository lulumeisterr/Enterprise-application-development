package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.categoriaEnum.Posicao;

@Table(name = "T_JOGADOR")
@Entity
@SequenceGenerator(name = "player" , sequenceName="SQ_T_JOGADOR" , allocationSize = 1)
public class Jogador implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066039046525776184L;
	
	
	@Id
	@GeneratedValue(generator = "player" , strategy= GenerationType.SEQUENCE)
	@Column(name = "cd_jogador")

	private int cd;
	@Column(name = "nm_jogador" , length = 100 , nullable = false)
	private String nome;
	@Column(name = "ds_peso")
	private float peso;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_posicao")
	private Posicao posicao;
	
	@ManyToOne
	@JoinColumn(name = "cd_time")
	private Time time;
	
	
	public Jogador(){
		
	}
	
	
	public Jogador( String nome, float peso, Posicao posicao, Time time) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.posicao = posicao;
		this.time = time;
	}


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public float getPeso() {
		return peso;
	}



	public void setPeso(float peso) {
		this.peso = peso;
	}



	public Posicao getPosicao() {
		return posicao;
	}



	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}



	public Time getTime() {
		return time;
	}



	public void setTime(Time time) {
		this.time = time;
	}

	
	
}
