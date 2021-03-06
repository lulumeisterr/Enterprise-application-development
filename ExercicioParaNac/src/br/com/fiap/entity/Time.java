package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.categoriaEnum.Categoria;

@Entity
@Table(name = "T_TIME")
@SequenceGenerator(name="team" , sequenceName = "SQ_T_TIME" , allocationSize = 1)
public class Time implements Serializable{

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "team" , strategy=GenerationType.SEQUENCE)
	@Column(name = "cd_time")
	private int cd;

	@Column(name = "nm_time" , length = 100 , nullable = false)
	private String nome;

	@Column(name = "ds_categoria")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	// Um time pode ter um tecnico e um tecnico so pode ter um time 1-1
	@OneToOne(fetch=FetchType.LAZY ,cascade = CascadeType.PERSIST) // Realizando o relacionamento e persistindo em cascata
	@JoinColumn(name = "TB_TIME_TB_TECNICO_FK", nullable = false) // Nomeando a chave estrangeira e indicando a entidade que �
																  // respons�vel pelo relacionamento.
	private Tecnico tecnico; //Pode Ter - FK

	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	//PEGANDO OS CD'S DESSA TABELA E DPS O DA OUTRA
	@JoinTable(name = "T_TIME_CAMPEONATO" , joinColumns = @JoinColumn(name = "cd_campeonato") ,  
	inverseJoinColumns =@JoinColumn(name = "CD_TIMEv2"))


	private List<Campeonato> camp = new ArrayList<>();

	public Time(){
		
	}
	
	public Time(String nome, Categoria categoria, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.tecnico = tecnico;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Campeonato> getCamp() {
		return camp;
	}

	public void setCamp(List<Campeonato> camp) {
		this.camp = camp;
	}

}
