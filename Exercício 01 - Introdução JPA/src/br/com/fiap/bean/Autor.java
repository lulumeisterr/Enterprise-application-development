package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fiap.constantes.bean.tipoSexo;

@Entity
public class Autor implements Serializable{

	private static final long serialVersionUID = 244472496080112934L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private int id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private tipoSexo tipo;
	private String sobrenome;
	private Calendar data;

	public Autor(){

	}

	public Autor(int id, String nome, tipoSexo tipo, String sobrenome, Calendar data) {
		super();
		setId(id);
		setNome(nome);
		setTipo(tipo);
		setSobrenome(sobrenome);
		setData(data)	;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public tipoSexo getTipo() {
		return tipo;
	}

	public void setTipo(tipoSexo tipo) {
		this.tipo = tipo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}



}
