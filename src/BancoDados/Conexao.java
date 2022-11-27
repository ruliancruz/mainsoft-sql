package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
    public Connection getConexao() throws SQLException
    {
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mainsoft", "postgres", "Pass!2234");
        return conexao;
    }   
}