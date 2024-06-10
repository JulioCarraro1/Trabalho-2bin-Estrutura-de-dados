/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaencadeada;

public class Node {
    Cliente cliente;
    Node prev;
    Node next;

    public Node(Cliente cliente) {
        this.cliente = cliente;
        this.prev = null;
        this.next = null;
    }
}

