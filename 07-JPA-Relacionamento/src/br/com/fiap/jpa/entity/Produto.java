package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUTO")
@SequenceGenerator(name = "produto" , sequenceName="SQ_T_PRODUTO" , allocationSize = 1)
public class Produto {

	@Id
	@GeneratedValue(generator = "produto" , strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_produto")
	private int codigo;
	@Column(name = "ds_descricao" , nullable = false , length=255)
	private String descricao;
	@Column(name = "ds_perecivel")
	private boolean perecivel;
	
	// JoinColumn Nome da tabela associativa
	// JoinTable - Nome da tabela associativa - joinColumns Vira chave estrangeira da propria entidade , chave primaria da outra associativa
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_PRODUTO_FORNECEDOR" , joinColumns = @JoinColumn(name = "cd_produto") ,  inverseJoinColumns =@JoinColumn(name = "cd_fornecedor")) 
	List<Fornecedor> listafornece;
	
	
	public Produto(){
		
	}
	
	public List<Fornecedor> getListafornece() {
		return listafornece;
	}

	public void setListafornece(List<Fornecedor> listafornece) {
		this.listafornece = listafornece;
	}

	public Produto(String descricao, boolean perecivel) {
		super();
		
		this.descricao = descricao;
		this.perecivel = perecivel;
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
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	
	
}
