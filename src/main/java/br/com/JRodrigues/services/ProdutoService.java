package br.com.JRodrigues.services;

import br.com.JRodrigues.dao.IProdutoDAO;
import br.com.JRodrigues.domain.Produto;
import br.com.JRodrigues.services.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}