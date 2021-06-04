package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//Cria um Testes para testar pesquisa de clientes
public class GerenciadoraClientesTest_Ex1 {

	@Test
	public void testPesquisaCliente() {
		
		//Para Testar o método pesquisa cliente devemos primeiramente criar alguns clientes

		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Cristian Jonas Ataliba", 34, "cristian.ataliba@outlook.com",3, true);
		
		//Após ter criado alguns clientes devemos criar uma lista para popular os clientes criados
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>(); //Sintaxe com clientes criados
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco); // Instância a classe pesquisa cliente
		
	
		Cliente cliente = gerClientes.pesquisaCliente(3);// Chama o método pesquisa clientes passando o ID 1
		
		assertThat(cliente.getId(), is(3)); //assetthat significa verifique quem é  cliente 1
		assertThat(cliente.getEmail(), is("cristian.ataliba@outlook.com"));
		assertThat(cliente.getIdade(), is(34));//Verifica o cliente com idade de 34 anos
		
	}

}
