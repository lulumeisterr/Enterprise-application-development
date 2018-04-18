package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{
	
	
	List<Pacote> obterListaPacote(String nm_transporte);
	List<Pacote> ListarTransporte(Transporte t);
	List<Pacote> ListarPorData(Calendar inicio , Calendar fim);
	double CalcularMedia();

	List<Pacote> buscarPorDescricao(String desc);
}
