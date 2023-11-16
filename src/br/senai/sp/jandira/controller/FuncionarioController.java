package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionarioController {

    Scanner scanner = new Scanner(System.in);

    public boolean deletarFuncionario() throws SQLException {

        System.out.println("Informe o nome de quem deseja excluir: ");
        String nomeDelete = scanner.nextLine();

        Conexao conexao = new Conexao();

        Connection connection = conexao.getConnection();

        Statement statement = connection.createStatement();

        String queryDelete = "DELETE from funcionario WHERE nome= '" + nomeDelete + "'";

        try {
            statement.executeUpdate(queryDelete);
            return true;
        } catch (Exception error){
            System.out.println(error);
            return false;
        }

    }


    public void listarFuncionarios() throws SQLException {
        //Instanciar Conexão
        Conexao conexao = new Conexao();

        Connection connection = conexao.getConnection();

        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * From funcionario";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome() + " " + funcionario.getSobrenome());
            System.out.println(funcionario.getMatricula());
            System.out.println(funcionario.getPermissao());
            System.out.println(funcionario.getDepartamento_FK());

        }

    }


    public void pesquisarFuncionario(){


    }
}
