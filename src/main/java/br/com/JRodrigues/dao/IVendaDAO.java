package br.com.JRodrigues.dao;

import br.com.JRodrigues.dao.generics.IGenericDAO;
import br.com.JRodrigues.domain.Venda;
import br.com.JRodrigues.exception.DAOException;
import br.com.JRodrigues.exception.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
