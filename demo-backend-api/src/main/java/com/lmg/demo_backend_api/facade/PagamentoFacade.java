package com.lmg.demo_backend_api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lmg.demo_backend_api.dto.PagamentoDTO;
import com.lmg.demo_backend_api.producer.PagamentoRequestProducer;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    private final PagamentoRequestProducer pagamentoRequestProducer;

    public PagamentoFacade(PagamentoRequestProducer pagamentoRequestProducer) {
        this.pagamentoRequestProducer = pagamentoRequestProducer;
    }

    public String solicitarPagamento(PagamentoDTO request) {
        try {
            pagamentoRequestProducer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar pagamento.." + e.getMessage();
        }
        return "Pagamento aguardando confirmação";
    }
}
