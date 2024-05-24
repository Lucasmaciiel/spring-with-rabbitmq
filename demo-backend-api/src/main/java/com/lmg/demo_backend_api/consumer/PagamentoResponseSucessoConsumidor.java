package com.lmg.demo_backend_api.consumer;

import com.lmg.demo_backend_api.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseSucessoConsumidor {

    private final PagamentoFacade pagamentoFacade;

    public PagamentoResponseSucessoConsumidor(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + " " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.sucessoPagamento(payload);

    }
}
