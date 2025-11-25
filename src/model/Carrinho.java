package model;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(Pizza pizza, int quantidade) {
        itens.add(new ItemCarrinho(pizza, quantidade));
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void limpar() {
        itens.clear();
    }
}
