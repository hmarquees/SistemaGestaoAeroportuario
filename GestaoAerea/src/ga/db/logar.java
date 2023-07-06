package ga.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class logar {
	
	public boolean fazerLogin(String cpf, char[] senha) {
       
        //Passo 1 - Comando SQL
        String sql = "SELECT * FROM usuario WHERE cpf=? AND senha=?";
       
        //Passo 2 - Preparar a conexão
        conexao novaConexao = new conexao();
        Connection conectar = novaConexao.getConexao();
        PreparedStatement preparar = null;
        ResultSet resultados = null;
       
        //Passo 3 - Tentar executar o SQL
        try {
            preparar = conectar.prepareStatement(sql);
            preparar.setString(1, cpf);
            preparar.setString(2, new String(senha));
            resultados = preparar.executeQuery();
        }catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Usuário ou senha inválido(s)");
            System.err.println(erro.getMessage());
        }
       
        //Passo 4 - Tentar mostrar os resultados
        try {
            if(resultados.next()) {
                //JOptionPane.showMessageDialog(null,"Login efetuado");
                return true;
            }else {
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválido(s)");
            }
        }catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Falha não há resultados");
            System.err.println(erro.getMessage());
        }
		return false;
       
       
       
    }

}
