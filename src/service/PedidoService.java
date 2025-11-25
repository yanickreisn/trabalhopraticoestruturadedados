package service;

import model.Carrinho;
import model.Pedido;
import model.Cliente;

import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Pedido criarPedido(Cliente cliente, Carrinho carrinho) {
        Pedido pedido = new Pedido(
            cliente,
            new ArrayList<>(carrinho.getItens()),
            carrinho.getTotal()
        );
        
        pedidos.add(pedido);
        carrinho.limpar();
        return pedido;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido p : pedidos) {
            if (p.getNumero() == numero) return p;
        }
        return null;
    }
}
