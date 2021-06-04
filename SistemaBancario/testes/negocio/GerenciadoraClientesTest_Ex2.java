package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex2 {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {

		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Ricardo Goncalves", 34, "ricardo.goncalves@outolook.com", 3, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(2);
		
		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("felipeaugusto@gmail.com"));
		assertThat(cliente.getNome(), is("Felipe Augusto"));
		
	}
	
	
	//Elaborado um teste para remover o cliente
	@Test
	public void testRemoveCliente() {

		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Ricardo Goancalves", 34, "ricardo.goncalves@outlook.com", 3, true);
		
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);// Instânciando a classe GerenciadoraCliente
		//passando por parâmetro clientesDoBanco
		
		boolean clienteRemovido = gerClientes.removeCliente(2); //Chama o método remove cliente, passando com parãmetro o ID 2
		
		assertThat(clienteRemovido, is(true));
		
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));//Verifica que o tamanho da lista de clientes é 2, 
		//pois um cliente foi removido.
		
		assertNull(gerClientes.pesquisaCliente(2)); // Pesquisa que o cliente removido está "vazio".
		
	}

}
