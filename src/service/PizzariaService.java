// Nome: YANICK REIS NUNES DE OLIVEIRA

package service;

import model.Pedido;

import java.util.*;

public class PizzariaService {

    // 1️⃣ Cadastro de sabores
    private Set<String> sabores = new HashSet<>();

    // 2️⃣ Pedidos abertos
    private List<Pedido> pedidosAbertos = new ArrayList<>();

    // 3️⃣ Fila de entregas
    private Queue<Pedido> filaEntregas = new LinkedList<>();

    // 4️⃣ Pedidos prioritários
    private PriorityQueue<Pedido> filaPrioritaria =
            new PriorityQueue<>(Comparator.comparingInt(Pedido::getTempoPreparo));

    // 5️⃣ Histórico de cancelamentos
    private Stack<Pedido> historicoCancelados = new Stack<>();

    // 6️⃣ Registro de vendas
    private Map<String, Integer> vendasPorSabor = new HashMap<>();


    // ------------------- MÉTODOS -------------------

    // 1. Cadastro de Sabores
    public void adicionarSabor(String sabor) {
        if (sabores.add(sabor))
            System.out.println("Sabor adicionado: " + sabor);
        else
            System.out.println("Sabor já existe!");
    }

    public void removerSabor(String sabor) {
        sabores.remove(sabor);
    }

    public void listarSabores() {
        System.out.println("Sabores disponíveis: " + sabores);
    }

    public boolean existeSabor(String sabor) {
        return sabores.contains(sabor);
    }


    // 2. Registro de Pedidos
    public void adicionarPedido(Pedido p) {
        pedidosAbertos.add(p);
        System.out.println("Pedido adicionado: " + p);
    }

    public Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido p : pedidosAbertos)
            if (p.getNumero() == numero) return p;
        return null;
    }

    public void listarPedidos() {
        pedidosAbertos.forEach(System.out::println);
    }

    public void ordenarPorValor() {
        pedidosAbertos.sort(Comparator.comparingDouble(Pedido::getValor));
    }

    public void ordenarPorCliente() {
        Collections.sort(pedidosAbertos);
    }


    // 3. Fila de Entregas
    public void adicionarFilaEntrega(Pedido p) {
        filaEntregas.offer(p);
        System.out.println("Pedido adicionado à fila: " + p);
    }

    public Pedido entregarPedido() {
        Pedido entregue = filaEntregas.poll();
        if (entregue != null) System.out.println("Pedido entregue: " + entregue);
        return entregue;
    }

    public Pedido proximoEntrega() {
        return filaEntregas.peek();
    }

    public boolean filaVazia() {
        return filaEntregas.isEmpty();
    }


    // 4. Pedidos Prioritários
    public void adicionarPedidoPrioritario(Pedido p) {
        filaPrioritaria.offer(p);
        System.out.println("Pedido prioritário adicionado: " + p);
    }

    public Pedido processarPrioritario() {
        return filaPrioritaria.poll();
    }


    // 5. Histórico de Cancelamentos
    public void cancelarPedido(Pedido p) {
        historicoCancelados.push(p);
        System.out.println("Pedido cancelado: " + p);
    }

    public Pedido ultimoCancelado() {
        return historicoCancelados.peek();
    }

    public Pedido desfazerCancelamento() {
        return historicoCancelados.pop();
    }


    // 6. Registro de Vendas
    public void registrarVenda(String sabor) {
        vendasPorSabor.put(sabor, vendasPorSabor.getOrDefault(sabor, 0) + 1);
    }

    public void exibirRanking() {
        System.out.println("\n--- Ranking de Sabores ---");
        vendasPorSabor.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " vendas"));
    }

    public void exibirVendas() {
        System.out.println("Vendas registradas: " + vendasPorSabor);
    }

    public int totalVendasSabor(String sabor) {
        return vendasPorSabor.getOrDefault(sabor, 0);
    }
}
