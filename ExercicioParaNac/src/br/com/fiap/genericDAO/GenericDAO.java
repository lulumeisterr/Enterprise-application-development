package br.com.fiap.genericDAO;

public interface GenericDAO<Tabela, Chave>{
	
	/*
	 * Criar um DAO que possa ser reutilizado (via heran�a) para as opera��es b�sicas
	   de persist�ncia (CRUD);
	 * 
	 */
	
	
	//Cadastrar
	void Inserir(Tabela tabela);
	
	//Buscar
	Tabela Buscar(Tabela tabela);
	
	//Excluir
	void Excluir(Chave codigo);
	
	//Atualizar
	void Atualizar(Tabela tabela);
	
	//Commitar
	void commit();
	
	
	
}