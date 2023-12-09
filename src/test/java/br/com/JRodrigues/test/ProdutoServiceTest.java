package br.com.JRodrigues.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.JRodrigues.dao.IProdutoDAO;
import br.com.JRodrigues.dao.ProdutoDaoMock;
import br.com.JRodrigues.domain.Produto;
import br.com.JRodrigues.exception.DAOException;
import br.com.JRodrigues.exception.TipoChaveNaoEncontradaException;
import br.com.JRodrigues.services.IProdutoService;
import br.com.JRodrigues.services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Rodrigo Pires");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Rodrigo Pires", produto.getNome());
	}
}