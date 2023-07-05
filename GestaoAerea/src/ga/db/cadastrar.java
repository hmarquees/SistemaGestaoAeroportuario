package ga.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class cadastrar {
	
	
	public void aeroporto(int cod, String nome, String logradouro,
						  String numero, String complemento,
						  String bairro, String cidade, String estado,
						  String cep) {
			
		//Passo 1 - Qual comando SQL?
		String sql = "INSERT INTO aeroporto VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		//ResultSet resultados = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setInt(1, cod);
			preparar.setString(2, nome);
			preparar.setString(3, logradouro);
			preparar.setString(4, numero);
			preparar.setString(5, complemento);
			preparar.setString(6, bairro);
			preparar.setString(7, cidade);
			preparar.setString(8, estado);
			preparar.setString(9, cep);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Aeroporto cadastrado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao cadastrar!\n" + erro.getMessage());
		}

	}
	
	
	
	
	public void aviao(String fabricante, String modelo, int capacidade) {

		//Passo 1 - Qual comando SQL?
		String sql = "INSERT INTO aviao " + "(fabricante, modelo, capacidade)" + "VALUES (?, ?, ?)";
		
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
			
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Avião cadastrado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao cadastrar!\n" + erro.getMessage());
		}

	}
	
	
	
	public void voo(String companhia, int aeroorigem, int aerodestino, String data, String hora, int codaviao) {

		//Passo 1 - Qual comando SQL?
		String sql = "INSERT INTO voo (companhia, aeroporto_origem, aeroporto_destino, data, horario, cod_aviao) VALUES (?, ?, ?, ?, ?, ?)";
		
				
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		//ResultSet resultados = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setString(1, companhia);
			preparar.setInt(2, aeroorigem);
			preparar.setInt(3, aerodestino);
			preparar.setString(4, data);
			preparar.setString(5, hora);
			preparar.setInt(6, codaviao);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Voo cadastrado!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao cadastrar!\n" + erro.getMessage());
	}

}
	
	
	
	public void companhia(String cnpj, String razaosocial,
			  String nomefantasia,String logradouro, String numero, String complemento,
			  String bairro, String cidade, String estado,
			  String cep) {

		//Passo 1 - Qual comando SQL?
		String sql = "INSERT INTO companhia VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Passo 2 - Preparar a conexão
		conexao novaConexao = new conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		//ResultSet resultados = null;
		
		//Passo 3 - Tentar executar o SQL
		try {
			preparar = conectar.prepareStatement(sql);
			preparar.setString(1, cnpj);
			preparar.setString(2, razaosocial);
			preparar.setString(3, nomefantasia);
			preparar.setString(4, logradouro);
			preparar.setString(5, numero);
			preparar.setString(6, complemento);
			preparar.setString(7, bairro);
			preparar.setString(8, cidade);
			preparar.setString(9, estado);
			preparar.setString(10, cep);
			preparar.execute();
			JOptionPane.showMessageDialog(null,"Companhia cadastrada!");
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha ao cadastrar!\n" + erro.getMessage());
		}
		
	}
	
}
