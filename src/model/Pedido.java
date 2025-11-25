package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    private static int contador = 1;

    private int numero;
    private Cliente cliente;
    private ArrayList<ItemCarrinho> itens;
    private double total;
    private LocalDateTime data;
    private String status;

    public Pedido(Cliente cliente, ArrayList<ItemCarrinho> itens, double total) {
        this.numero = contador++;
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
        this.data = LocalDateTime.now();
        this.status = "Em preparação";
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return "Pedido #" + numero +
               "\nCliente: " + cliente +
               "\nTotal: R$" + total +
               "\nStatus: " + status +
               "\nData: " + data;
    }
}
