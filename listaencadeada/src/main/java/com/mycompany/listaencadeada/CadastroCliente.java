/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaencadeada;

import javax.swing.JOptionPane;

public class CadastroCliente {
    private static Lista listaClientes = new Lista();

    public static void main(String[] args) {
        while (true) {
            String menu = "\nMenu:\n"
                    + "1. Gravar novo cadastro\n"
                    + "2. Excluir cadastro\n"
                    + "3. Alterar cadastro\n"
                    + "4. Recuperar cadastro\n"
                    + "5. Exibir todos os cadastros\n"
                    + "6. Sair\n"
                    + "Escolha uma opção: ";
            String opcaoStr = JOptionPane.showInputDialog(menu);
            
            if (opcaoStr == null) {
                break; // Se cancelar ou fechar, sair do loop
            }

            int opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    alterarCliente();
                    break;
                case 4:
                    recuperarCliente();
                    break;
                case 5:
                    exibirTodosClientes();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código: "));
            String nome = JOptionPane.showInputDialog("Nome: ");
            String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento: ");
            String telefone = JOptionPane.showInputDialog("Telefone: ");

            Cliente cliente = new Cliente(codigo, nome, dataNascimento, telefone);
            listaClientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente adicionado: " + cliente);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Por favor, insira um número.");
        }
    }

    private static void excluirCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente a excluir: "));
            boolean removido = listaClientes.remove(codigo);
            if (!removido) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Por favor, insira um número.");
        }
    }

    private static void alterarCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente a alterar: "));
            Cliente cliente = listaClientes.get(codigo);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                return;
            }
            String novoNome = JOptionPane.showInputDialog("Novo Nome: ", cliente.getNome());
            String novaDataNascimento = JOptionPane.showInputDialog("Nova Data de Nascimento: ", cliente.getDataNascimento());
            String novoTelefone = JOptionPane.showInputDialog("Novo Telefone: ", cliente.getTelefone());

            listaClientes.update(codigo, novoNome, novaDataNascimento, novoTelefone);
            JOptionPane.showMessageDialog(null, "Cliente atualizado: " + cliente);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Por favor, insira um número.");
        }
    }

    private static void recuperarCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente: "));
            Cliente cliente = listaClientes.get(codigo);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            } else {
                JOptionPane.showMessageDialog(null, cliente);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Por favor, insira um número.");
        }
    }

    private static void exibirTodosClientes() {
        Node current = listaClientes.head;
        StringBuilder todosClientes = new StringBuilder();
        while (current != null) {
            todosClientes.append(current.cliente).append("\n");
            current = current.next;
        }
        JOptionPane.showMessageDialog(null, todosClientes.toString());
    }
}


