package model;

public class ItemCarrinho {
    private Pizza pizza;
    private int quantidade;

    public ItemCarrinho(Pizza pizza, int quantidade) {
        this.pizza = pizza;
        this.quantidade = quantidade;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return pizza.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return pizza.getSabor() + " x" + quantidade + " = R$" + getSubtotal();
    }
}
