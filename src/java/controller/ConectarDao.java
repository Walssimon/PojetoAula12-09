package controller;

import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.ResultSet;
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import java.sql.PreparedStatement;

public class ConectarDao {

    public Connection con = null;
    public String sql = null;
    public PreparedStatement ps = null;
    public String htmlError = null;
    public ResultSet tab = null;
    
    public void ConectarDao() { 
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        criarBanco();
    }
    catch (ClassNotFoundException ex

        ){
            htmlError = "Houve erro ao executar - " + ex.getMessage();
    }
    catch (SQLException ex
        ){
            htmlError = "Houve erro ao executar - " + ex.getMessage();
    }
    }
    public void criarBanco() {
        try {
            ps = con.prepareStatement("create database if not exists gerente");
            ps.executeUpdate();
            ps = con.prepareStatement("use gerente");
            ps.executeUpdate(); // seleciona banco
            sql = "CREATE TABLE IF NOT EXISTS USUARIOS ("
                    + "pkUser int not null AUTO_INCREMENT ,"
                    + "nome varchar(50) not null ,"
                    + "email varchar(50) not null ,"
                    + "celular varchar(20) not null ,"
                    + "senha varchar(10) not null,"
                    + "nivel varchar(20) not null, "
                    + "primary key (pkUser) )";
            ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
            ps.executeUpdate();// Executa o comando SQL
        } catch (SQLException err) {
            htmlError = err.getMessage();
        }
    }
}
