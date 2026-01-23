package app;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;
import repository.ArquitetoDAO;
import repository.ClienteDAO;
import repository.Conexao;
import repository.ProjetoDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArquitetoDAO arquitetoDAO = new ArquitetoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do{
            System.out.println("\n=== 🏛️ SISTEMA DE GESTÃO DE ARQUITETURA ===");
            System.out.println("1. Cadastrar Novo Arquiteto");
            System.out.println("2. Cadastrar Novo Cliente");
            System.out.println("3. Cadastrar Novo Projeto");
            System.out.println("4. Listar Projetos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try{
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                opcao = -1;
            }

            switch (opcao){
                case 1:
                    System.out.println("\n--- Cadastro de Arquiteto ---");
                    System.out.print("Nome: ");
                    String nomeArq = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailArq = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfArq = scanner.nextLine();
                    System.out.print("CAU: ");
                    String cau = scanner.nextLine();

                    Arquiteto novoArq = new Arquiteto(nomeArq, emailArq, cpfArq, cau);
                    arquitetoDAO.salvar(novoArq);
                    break;

                case 2:
                    System.out.println("\n--- Cadastro de Cliente ---");
                    System.out.print("Nome: ");
                    String nomeCli = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailCli = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCli = scanner.nextLine();
                    System.out.print("Telefone de Contato: ");
                    String contatoCli = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nomeCli, emailCli, cpfCli, contatoCli);
                    clienteDAO.salvar(novoCliente);
                    break;

                case 3:
                    System.out.println("\n--- Cadastro de Projeto ---");
                    System.out.println("Nome do Projeto: ");
                    String nomeProj = scanner.nextLine();
                    System.out.println("Endereço da Obra: ");
                    String enderecoProj = scanner.nextLine();
                    System.out.println("Fase do Projeto: ");
                    String faseProj = scanner.nextLine();

                    System.out.println("Digite o CPF do Arquiteto Responsável: ");
                    String cpfBuscaArq = scanner.nextLine();
                    Arquiteto arqEncontrado = arquitetoDAO.buscarPorCpf(cpfBuscaArq);

                    System.out.println("Digite o CPF do Cliente: ");
                    String cpfBuscaCli = scanner.nextLine();
                    Cliente cliEncontrado = clienteDAO.buscarPorCpf(cpfBuscaCli);

                    if(arqEncontrado != null && cliEncontrado != null){
                        Projeto novoProjeto = new Projeto(nomeProj, enderecoProj, faseProj, arqEncontrado,
                                cliEncontrado);

                        projetoDAO.salvar(novoProjeto);
                    }else{
                        System.out.println("Erro: Arquiteto ou Cliente não encontrado!!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Lista de Projetos ---");
                    List<Projeto> projetos = projetoDAO.listarTodos();

                    for(Projeto p : projetos){
                        System.out.println(p);
                    }
                    break;

                case 0:
                    System.out.println("Saindo do Programa!!");
                    break;

                default:
                    System.out.println("Opção inválida");
        }
    }while(opcao != 0);
}}
