package service;

import model.Pagamento;

public class PagamentoService {

    public boolean processarPagamento(Pagamento pagamento) {
        // Simulação de pagamento aprovado
        pagamento.confirmar();
        return true;
    }
}
