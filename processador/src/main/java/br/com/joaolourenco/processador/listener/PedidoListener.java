package br.com.joaolourenco.processador.listener;

import br.com.joaolourenco.processador.entity.Pedido;
import br.com.joaolourenco.processador.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final String QUEUE = "pedidos.v1.pedido.criado.gerar.processamento";

    @RabbitListener(queues = QUEUE)
    public void receive(Pedido pedido) {
        pedido.setStatus(Status.PROCESSADO);
        logger.info("Received message: {}", pedido);
    }
}
