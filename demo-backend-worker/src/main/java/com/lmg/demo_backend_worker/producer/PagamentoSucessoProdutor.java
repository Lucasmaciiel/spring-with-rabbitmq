package com.lmg.demo_backend_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;

public class PagamentoSucessoProdutor {

    private final AmqpTemplate amqpTemplate;

    public PagamentoSucessoProdutor(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    public void gerarResposta(String mensagem) {
        amqpTemplate.convertAndSend(
                "pagamento-response-sucesso-exchange",
                "pagamento-response-sucesso-rout-key",
                mensagem
        );

    }
}
