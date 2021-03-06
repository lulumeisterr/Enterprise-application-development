package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PEDIDO")
@SequenceGenerator(name = "pedido" , sequenceName="SQ_T_PEDIDO" , allocationSize = 1)
public class Pedido implements Serializable{

	private static final long serialVersionUID = -1793767464900263277L;

	@Id
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_pedido")
	private int codigo;

	@Column(name = "ds_pedido" , nullable = false , length  = 255)
	private String descricao;

	@Column(name = "dt_pedido" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	//FK
	@OneToOne(fetch=FetchType.LAZY ,cascade = CascadeType.PERSIST) //Cadastrando em cascata
	//Quando minha tabela for receber chave estrageira eu coloco JoinColumn
	@JoinColumn(name= "cd_nota_fiscal")
	private NotaFiscal nota;

	//Relacionamento bidirecional
	//Um Pedido varios intens
	//Uma Lista de pedidos

	//Estou cadastrando um pedido e cadastrando items automaticamente
	@OneToMany(mappedBy = "pedido" , cascade = CascadeType.PERSIST) //Para Evitar n�o duplicar o nome da fk nas duas tabelas
	
	private List<ItemPedido> itens = new ArrayList<>(); // se eu nao colocar ele add em uma lista vazia e da erro da nullpointer

	//Metodo para adicionar os elementos
	public void AdicionarItem(ItemPedido item){
		itens.add(item);
		item.setPedido(this); // Para garantir que estou cadastrando as chaves
		// e para cada item eu preciso setar os pedidos dele para cadasrar
	}
	
	public Pedido(){

	}

	public Pedido(String descricao, Calendar data, NotaFiscal nota) {
		super();

		this.descricao = descricao;
		this.data = data;
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}

	public NotaFiscal getNota() {
		return nota;
	}

	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}



}
