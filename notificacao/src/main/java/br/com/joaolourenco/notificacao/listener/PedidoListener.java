package br.com.joaolourenco.notificacao.listener;

import br.com.joaolourenco.notificacao.entity.Pedido;
import br.com.joaolourenco.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final String QUEUE = "pedidos.v1.pedido.criado.gerar.notificacao";

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);
    private final EmailService emailService;

    public PedidoListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = QUEUE)
    public void pedidoCriado(Pedido pedido) {
        emailService.enviarEmail(pedido);
        logger.info("Notificação criada: {}", pedido);
    }

}