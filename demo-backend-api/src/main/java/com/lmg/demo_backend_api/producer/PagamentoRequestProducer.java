package com.lmg.demo_backend_api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmg.demo_backend_api.dto.PagamentoDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {

//    @Value("${rabbitmq.request.exchange.value}")
//    private String exchange;
//
//    @Value("${rabbitmq.request.rout-key.value}")
//    private String routKey;

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PagamentoRequestProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void integrar(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange",
                "pagamento-request-rout-key",
                objectMapper.writeValueAsString(pagamentoDTO));
    }
}
