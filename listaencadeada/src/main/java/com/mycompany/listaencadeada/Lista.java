/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaencadeada;

public class Lista{
    public Node head; 

    public Lista() {
        this.head = null;
    }

    public void add(Cliente cliente) {
        Node newNode = new Node(cliente);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        System.out.println("Cliente adicionado: " + cliente);
    }

    public boolean remove(int codigo) {
        Node current = head;
        while (current != null && current.cliente.getCodigo() != codigo) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        System.out.println("Cliente removido: " + current.cliente);
        return true;
    }

    public boolean update(int codigo, String novoNome, String novaDataNascimento, String novoTelefone) {
        Node current = head;
        while (current != null && current.cliente.getCodigo() != codigo) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        current.cliente.setNome(novoNome);
        current.cliente.setDataNascimento(novaDataNascimento);
        current.cliente.setTelefone(novoTelefone);
        System.out.println("Cliente atualizado: " + current.cliente);
        return true;
    }

    public Cliente get(int codigo) {
        Node current = head;
        while (current != null && current.cliente.getCodigo() != codigo) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        return current.cliente;
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.cliente);
            current = current.next;
        }
    }
}

