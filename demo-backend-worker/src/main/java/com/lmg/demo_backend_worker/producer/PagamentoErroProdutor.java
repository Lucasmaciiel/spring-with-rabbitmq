package com.lmg.demo_backend_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErroProdutor {

    private final AmqpTemplate amqpTemplate;

    public PagamentoErroProdutor(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void gerarResposta(String mensagem) {
        amqpTemplate.convertAndSend(
                "pagamento-response-erro-exchange",
                "pagamento-response-erro-rout-key",
                mensagem
        );

    }
}
