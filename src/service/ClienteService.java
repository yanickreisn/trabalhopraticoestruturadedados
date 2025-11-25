package service;

import model.Cliente;
import java.util.ArrayList;

public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrar(String nome, String telefone, String endereco) {
        Cliente cliente = new Cliente(nome, telefone, endereco);
        clientes.add(cliente);
        return cliente;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
