package model;

public class Pagamento {
    private String forma; // "Cartão", "PIX", "Dinheiro"
    private double valor;
    private boolean confirmado;

    public Pagamento(String forma, double valor) {
        this.forma = forma;
        this.valor = valor;
        this.confirmado = false;
    }

    public String getForma() {
        return forma;
    }

    public double getValor() {
        return valor;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void confirmar() {
        this.confirmado = true;
    }

    @Override
    public String toString() {
        return "Forma: " + forma + " - Valor: R$" + valor + 
               " - Confirmado: " + (confirmado ? "Sim" : "Não");
    }
}
