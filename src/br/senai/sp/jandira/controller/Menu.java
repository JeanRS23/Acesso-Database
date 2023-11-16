package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void executarMenu() throws SQLException {

        boolean sair = false;

        FuncionarioController funcionarioController = new FuncionarioController();

        while (!sair){
            System.out.println("/----- Menu -----/");
            System.out.println("1- Listar Funcionarios");
            System.out.println("2- Deletar Funcionarios");
            System.out.println("3- Pesquisar Funcionarios");
            System.out.println("4- Cadastrar Funcionarios");
            System.out.println("5- Sair");
            System.out.println("");
            System.out.println("Escolha uma opção: ");
            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario){
                case 1:
                        funcionarioController.listarFuncionarios();
                    break;

                case 2:
                    funcionarioController.deletarFuncionario();
                    break;

                case 3:
                    System.out.println("Feature in Development");
                    break;

                case 4:
                    System.out.println("Feature in Development");
                    break;

                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Escolha uma opção válida! ");
            }
        }

    }

}
