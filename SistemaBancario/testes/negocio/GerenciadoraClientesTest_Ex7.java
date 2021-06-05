package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Gustavo Farias
 * @date 21/01/2035 
 */
public class GerenciadoraClientesTest_Ex7 {

	private GerenciadoraClientes gerClientes; //Variável global
	private int idCLiente01 = 1; //Variável global
	private	int idCLiente02 = 2; //Variável global
	
	/*=========================================Primeira e Quarta(Executada após dar um clear no cliente pesquisado
	 * parte do teste==========================================*/
	
	@Before //  Antes  de executar o teste, através do comando @Before
	//excuta o  trecho de código que é comum para  toda a classe.
	
	
	
	public void setUp() { 
	
		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	
	System.out.println("Before foi executado");
	}

	
	/*=========================================Terceira e Sexta(Após ter verificado a remoção do cliente 
	 * parte do teste==========================================*/
	
	
	@After // Depois de executar o teste Pesquisa Cliente, o sistema excuta o testes tearDown
	//Terceira parte do teste
	
	//Significa que quando for executado o teste removeCliente não hverá comando ativo do teste pesquisaCliente
	
	public void tearDown() {
		gerClientes.limpa();
		
		System.out.println("After foi executado");
	}
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	
	/*=========================================Segunda parte do teste==========================================*/
	@Test 
	
	//Segunda parte do teste é executar o testes pesquisa cliente
	public void testPesquisaCliente() {

		/* ========== Execução ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verificações ========== */
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	
	/*=========================================Quinta parte do teste==========================================*/
	@Test
	public void testRemoveCliente() {
		
		/* ========== Execução ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
}
// Como Ganhar Tempo e Otimizar Testes com Cenários Parecidos