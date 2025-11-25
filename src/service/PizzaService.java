package service;

import model.Pizza;
import java.util.ArrayList;

public class PizzaService {

    private ArrayList<Pizza> cardapio = new ArrayList<>();

    public PizzaService() {
        // Cardápio padrão
        cardapio.add(new Pizza("Calabresa", 35.0));
        cardapio.add(new Pizza("Frango com Catupiry", 40.0));
        cardapio.add(new Pizza("Portuguesa", 42.0));
        cardapio.add(new Pizza("Quatro Queijos", 45.0));
        cardapio.add(new Pizza("Marguerita", 38.0));
    }

    public ArrayList<Pizza> getCardapio() {
        return cardapio;
    }

    public Pizza getPizza(int index) {
        if (index >= 0 && index < cardapio.size()) {
            return cardapio.get(index);
        }
        return null;
    }

    public void adicionarPizza(Pizza pizza) {
        cardapio.add(pizza);
    }
}
