package app;

import service.*;
import model.*;

import java.util.Scanner;

public class Main {   // ← AQUI! Classe main correta

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PizzaService pizzaService = new PizzaService();
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();
        PagamentoService pagamentoService = new PagamentoService();

        Carrinho carrinho = new Carrinho();

        while (true) {
            System.out.println("\n=== PIZZARIA JAVA DELÍCIA ===");
            System.out.println("1 - Ver cardápio");
            System.out.println("2 - Adicionar pizza ao carrinho");
            System.out.println("3 - Ver carrinho");
            System.out.println("4 - Finalizar pedido");
            System.out.println("5 - Listar pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {

                case 1:
                    System.out.println("\n--- CARDÁPIO ---");
                    int i = 1;
                    for (Pizza p : pizzaService.getCardapio()) {
                        System.out.println(i++ + " - " + p);
                    }
                    break;

                case 2:
                    System.out.println("\nDigite o número da pizza:");
                    int index = input.nextInt() - 1;
                    Pizza pizzaEscolhida = pizzaService.getPizza(index);

                    if (pizzaEscolhida == null) {
                        System.out.println("Pizza inválida!");
                        break;
                    }

                    System.out.println("Quantidade:");
                    int qtd = input.nextInt();

                    carrinho.adicionarItem(pizzaEscolhida, qtd);
                    System.out.println("Pizza adicionada!");
                    break;

                case 3:
                    System.out.println("\n--- SEU CARRINHO ---");
                    for (ItemCarrinho item : carrinho.getItens()) {
                        System.out.println(item);
                    }
                    System.out.println("TOTAL: R$" + carrinho.getTotal());
                    break;

                case 4:
                    System.out.println("\n--- DADOS DO CLIENTE ---");
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    System.out.print("Telefone: ");
                    String tel = input.nextLine();
                    System.out.print("Endereço: ");
                    String end = input.nextLine();

                    Cliente cliente = clienteService.cadastrar(nome, tel, end);

                    System.out.println("\nEscolha a forma de pagamento (Pix / Cartão / Dinheiro): ");
                    String forma = input.nextLine();

                    Pagamento pagamento = new Pagamento(forma, carrinho.getTotal());

                    pagamentoService.processarPagamento(pagamento);

                    Pedido pedido = pedidoService.criarPedido(cliente, carrinho);

                    System.out.println("\nPedido gerado com sucesso!");
                    System.out.println(pedido);
                    break;

                case 5:
                    System.out.println("\n--- LISTA DE PEDIDOS ---");
                    for (Pedido p : pedidoService.getPedidos()) {
                        System.out.println(p);
                        System.out.println("---------------------");
                    }
                    break;

                case 0:
                    System.out.println("Obrigado! Volte sempre.");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
