package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String servidor, user, password, banco;

    public Connection conexao;


    public Conexao() {
        this.servidor = "localhost";
        this.banco = "db_senai_java";
        this.user = "root";
        this.password = "bcd127";

    }

    public boolean connectDriver() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.user, this.password);
            return true;
        } catch (Exception error){
            System.out.println(error);
            return false;
        }
    }

    public Connection getConnection(){
        boolean validaConexao = connectDriver();
        if (validaConexao){
            return conexao;
        }
        return null;
    }

}
