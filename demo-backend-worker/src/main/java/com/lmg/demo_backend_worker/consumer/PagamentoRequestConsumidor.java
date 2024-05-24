package com.lmg.demo_backend_worker.consumer;

import com.lmg.demo_backend_worker.producer.PagamentoErroProdutor;
import com.lmg.demo_backend_worker.producer.PagamentoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumidor {

    private final PagamentoErroProdutor erroProdutor;
    private final PagamentoSucessoProdutor sucessoProdutor;

    public PagamentoRequestConsumidor(PagamentoErroProdutor erroProdutor, PagamentoSucessoProdutor sucessoProdutor) {
        this.erroProdutor = erroProdutor;
        this.sucessoProdutor = sucessoProdutor;
    }

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Sucesso de pagamento " + message);
        } else {
            erroProdutor.gerarResposta("Erro no pagamento " + message );
        }
    }
}
