package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_NOTA_FISCAL")
@SequenceGenerator(name="nota" , allocationSize = 1 , sequenceName="SQ_NOTA_FISCAL")
public class NotaFiscal {
	
	@GeneratedValue(generator="nota" , strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "cd_codigo")
	private int codigo;
	@Column(name = "vl_fiscal" , nullable = false)
	private double valor;
	@Column(name = "nr_serie" , nullable = false , length=255)
	private String numeroSerie;
	
	//RELACIONAMENTO BIDIRECIONAL
	//Todos Relacionamentos precisam ter a mesma anotacao para ambas tabelas
	//Todo relacionamento que for biderecional deve se colocar o mappedBy para nao mapear nas duas tabelas
	
	//nome do atributo
	@OneToOne(mappedBy="nota")
	private Pedido pedido;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public NotaFiscal(){
		
	}
	
	public NotaFiscal(double valor, String numeroSerie) {
		super();
		this.valor = valor;
		this.numeroSerie = numeroSerie;
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	
	

}
