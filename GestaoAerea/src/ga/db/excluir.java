package ga.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class excluir {
	
		
		public void aeroporto(int cod) {

			//Passo 1 - Qual comando SQL?
			String sql = "DELETE FROM aeroporto WHERE cod = ?";
			
			//Passo 2 - Preparar a conexão
			conexao novaConexao = new conexao();
			Connection conectar = novaConexao.getConexao();
			PreparedStatement preparar = null;
			
			//Passo 3 - Tentar executar o SQL
			try {
				preparar = conectar.prepareStatement(sql);
				preparar.setInt(1, cod);
				
				preparar.execute();
				JOptionPane.showMessageDialog(null,"Aeroporto excluído!");
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null,"Falha ao excluir!\n" + erro.getMessage());
			}
		
		}
		
		
		
		public void aviao(int cod) {

			//Passo 1 - Qual comando SQL?
			String sql = "DELETE FROM aviao WHERE cod = ?";
			
			//Passo 2 - Preparar a conexão
			conexao novaConexao = new conexao();
			Connection conectar = novaConexao.getConexao();
			PreparedStatement preparar = null;
			
			//Passo 3 - Tentar executar o SQL
			try {
				preparar = conectar.prepareStatement(sql);
				preparar.setInt(1, cod);
				
				preparar.execute();
				JOptionPane.showMessageDialog(null,"Avião excluído!");
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null,"Falha ao excluir!\n" + erro.getMessage());
			}
		
		}
		
		
		
		public void voo(int cod) {

			//Passo 1 - Qual comando SQL?
			String sql = "DELETE FROM voo WHERE cod = ?";
			
			//Passo 2 - Preparar a conexão
			conexao novaConexao = new conexao();
			Connection conectar = novaConexao.getConexao();
			PreparedStatement preparar = null;
			
			//Passo 3 - Tentar executar o SQL
			try {
				preparar = conectar.prepareStatement(sql);
				preparar.setInt(1, cod);
				
				preparar.execute();
				JOptionPane.showMessageDialog(null,"Voo excluído!");
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null,"Falha ao excluir!\n" + erro.getMessage());
			}
		
		}
		
		
		
		public void companhia(String cnpj) {

			//Passo 1 - Qual comando SQL?
			String sql = "DELETE FROM companhia WHERE cnpj = ?";
			
			//Passo 2 - Preparar a conexão
			conexao novaConexao = new conexao();
			Connection conectar = novaConexao.getConexao();
			PreparedStatement preparar = null;
			
			//Passo 3 - Tentar executar o SQL
			try {
				preparar = conectar.prepareStatement(sql);
				preparar.setString(1, cnpj);
				
				preparar.execute();
				JOptionPane.showMessageDialog(null,"Companhia excluída!");
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null,"Falha ao excluir!\n" + erro.getMessage());
			}
		
		}

}
