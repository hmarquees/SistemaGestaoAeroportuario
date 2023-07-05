package ga.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class atualizar {
	
	public void aeroporto(int cod, String nome, String logradouro,
			  String numero, String complemento,
			  String bairro, String cidade, String estado,
			  String cep) {

		//Passo 1 - Qual comando SQL?
		String sql = "UPDATE aeroporto SET nome =" + "?"
										+ ", logradouro=" + "?"
										+ ", numero=" + "?"
										+ ", complemento=" + "?"
										+ ", bairro=" + "?"
										+ ", cidade=" + "?"
										+ ", estado=" + "?"
										+ ", cep=" + "?"
										+ "WHERE cod=" + "?";
		
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		//ResultSet resultados = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setString(1, nome);
			preparar.setString(2, logradouro);
			preparar.setString(3, numero);
			preparar.setString(4, complemento);
			preparar.setString(5, bairro);
			preparar.setString(6, cidade);
			preparar.setString(7, estado);
			preparar.setString(8, cep);
			preparar.setInt(9, cod);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Aeroporto atualizado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao atualizar!\n" + erro.getMessage());
		}
	
	}
	
	
	
	public void aviao(int cod, String fabricante, String modelo, int capacidade) {

		//Passo 1 - Qual comando SQL?
		String sql = "UPDATE aviao SET fabricante =" + "?"
										+ ", modelo=" + "?"
										+ ", capacidade=" + "?"
										+ "WHERE cod=" + "?";
		
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		//ResultSet resultados = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setString(1, fabricante);
			preparar.setString(2, modelo);
			preparar.setInt(3, capacidade);
			preparar.setInt(4, cod);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Avião atualizado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao atualizar!\n" + erro.getMessage());
		}
	
	}
	
	
	public void companhia(String cnpj, String razaosocial,
			  String nomefantasia,String logradouro, String numero, String complemento,
			  String bairro, String cidade, String estado,
			  String cep) {

		//Passo 1 - Qual comando SQL?
		String sql = "UPDATE companhia SET razao_social =" + "?"
										+ ", nome_fantasia=" + "?"
										+ ", logradouro=" + "?"
										+ ", numero=" + "?"
										+ ", complemento=" + "?"
										+ ", bairro=" + "?"
										+ ", cidade=" + "?"
										+ ", estado=" + "?"
										+ ", cep=" + "?"
										+ "WHERE cnpj=" + "?";
		
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setString(1, razaosocial);
			preparar.setString(2, nomefantasia);
			preparar.setString(3, logradouro);
			preparar.setString(4, numero);
			preparar.setString(5, complemento);
			preparar.setString(6, bairro);
			preparar.setString(7, cidade);
			preparar.setString(8, estado);
			preparar.setString(9, cep);
			preparar.setString(10, cnpj);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Companhia atualizado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao atualizar!\n" + erro.getMessage());
		}
	
	}

}
