package ga.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	
	//Atributos da conexão
	   
    private String maquina = "127.0.0.1";
    private String banco = "gestaoaerea";
    private String usuario = "root";
    private String senha = "";
    private int porta = 3306;
    private Connection conectar;
   
    public conexao() {
        try {
            String url = "jdbc:mysql://"+maquina+":"+porta+"/"+banco;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conectar = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados conectado com sucesso!");
        }catch(Exception erro) {
            System.out.println("Falha na conexão com o BD!");
            System.out.println(erro.getMessage());
        }
    }//fim do construtor da classe
       
   
    //Método para retornar a conexão
   
    public Connection getConexao() {
        return this.conectar;
    }

    //Método sem retorno, apenas para finalizar a conexão
    public void finalizarConexao() {
        try {
            conectar.close();
        }catch(SQLException erro2) {
            System.out.println("Falha ao finalizar conexão! " + erro2.getMessage());
        }
    }

}
