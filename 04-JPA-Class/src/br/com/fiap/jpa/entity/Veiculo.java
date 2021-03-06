package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator(name="veiculo" , sequenceName = "SQ_TB_VEICULO" , allocationSize=1) //Mapeando a sequencia

public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 5404639528857101136L;
	
	@GeneratedValue(generator="veiculo" , strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name="cd_veiculo")
	private int id;
	
	@Column(name="ds_cor", nullable = false , length = 100)
	@Enumerated(EnumType.STRING)
	private Enum_Cor cor;
	
	@Column(name = "ds_modelo" , nullable = false , length = 100)
	private String modelo;
	
	@Column(name = "ds_ano" , nullable = false)
	private String ano;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fabricacao")
	private Calendar dataFabricacao;
	
	@Lob //Gravar um arquivo no banco de dados
	@Column(name = "ft_foto")
	private byte[] foto;
	
	//Transient n�o sera uma coluna no banco , apenas no java
	@Transient
	private int chaveAcesso;
	
	public Veiculo(){
		
	}

	public Veiculo(int id, Enum_Cor cor, String modelo, String ano, Calendar dataFabricacao, int chaveAcesso) {
		super();
		this.id = id;
		this.cor = cor;
		this.modelo = modelo;
		this.ano = ano;
		this.dataFabricacao = dataFabricacao;
		this.chaveAcesso = chaveAcesso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum_Cor getCor() {
		return cor;
	}

	public void setCor(Enum_Cor cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public int getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(int chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

}
